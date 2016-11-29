package online.zhaopei.myproject.schedule;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import online.zhaopei.myproject.common.tool.PaymentTool;
import online.zhaopei.myproject.domain.gjent.ImpPayHead;
import online.zhaopei.myproject.domain.gjpayment.PaymentMessage;
import online.zhaopei.myproject.service.gjent.ImpPayHeadService;
import online.zhaopei.myproject.service.gjpayment.PaymentMessageService;
import online.zhaopei.myproject.service.para.SyncPaymentInfoService;

@Configuration
@EnableAsync
@EnableScheduling
public class ScheduledTaskConfig {

	@Autowired
	private ImpPayHeadService impPayHeadService;
	
	@Autowired
	private PaymentMessageService paymentMessageService;
	
	@Autowired
	private SyncPaymentInfoService syncPaymentInfoService;
	
	@Scheduled(initialDelay = 10000, fixedDelay = 60000)
	public void syncPaymentInfo() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat sdfDay = new SimpleDateFormat("yyyyMMdd");
		ImpPayHead insertImpPayHead = null;
		ImpPayHead searchImpPayHead = null;
		PaymentMessage searchPm = new PaymentMessage();
		List<PaymentMessage> resultPaymentMessageList = null;
		Long lastSyncTime = this.syncPaymentInfoService.getSyncTime();
		
		if (null != lastSyncTime && 10000000000000L < lastSyncTime) {
			searchPm.setBeginCreateDate(String.valueOf(lastSyncTime));
		}
		
		Calendar yesterdayCalendar = Calendar.getInstance();
		yesterdayCalendar.add(Calendar.DAY_OF_YEAR, -1);
		searchPm.setBeginDateNum(Long.valueOf(sdfDay.format(yesterdayCalendar.getTime()) + "00"));
		searchPm.setXmlContent("<BILLMODE>0</BILLMODE>");
		searchPm.setOrderBy("created_date asc");
		resultPaymentMessageList = this.paymentMessageService.getPaymentMessageList(searchPm);
		
		if (null != resultPaymentMessageList && !resultPaymentMessageList.isEmpty()) {
			for (PaymentMessage pm : resultPaymentMessageList) {
				insertImpPayHead = PaymentTool.buildImpPayHeadByCbecMessage(PaymentTool.buildCbecMessageByString(pm.getXmlContent(), pm.getCreatedDate()));
				
				if (null != insertImpPayHead) {
					try {
						searchImpPayHead = new ImpPayHead(insertImpPayHead.getUuid());
						if (0 < this.impPayHeadService.countImpPayHead(searchImpPayHead)) {
							continue;
						}
						
						searchImpPayHead = new ImpPayHead(insertImpPayHead.getPayCode(), insertImpPayHead.getPayTransactionId());
						if (1 == this.impPayHeadService.countImpPayHead(searchImpPayHead)) {
							this.impPayHeadService.updateImpPayHead(insertImpPayHead);
						} else {
							this.impPayHeadService.insertPayHead(insertImpPayHead);
							this.syncPaymentInfoService.updateSyncTime(Long.valueOf(sdf.format(pm.getCreatedDate())));
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
