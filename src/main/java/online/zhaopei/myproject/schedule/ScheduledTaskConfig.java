package online.zhaopei.myproject.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.github.pagehelper.PageHelper;

import online.zhaopei.myproject.common.tool.PaymentTool;
import online.zhaopei.myproject.domain.gjent.ImpPayHead;
import online.zhaopei.myproject.domain.gjpayment.PaymentMessage;
import online.zhaopei.myproject.service.gjent.ImpPayHeadService;
import online.zhaopei.myproject.service.gjpayment.PaymentMessageService;

@Configuration
@EnableAsync
@EnableScheduling
public class ScheduledTaskConfig {

	@Autowired
	private ImpPayHeadService impPayHeadService;
	
	@Autowired
	private PaymentMessageService paymentMessageService;
	
//	@Scheduled(initialDelay = 60000, fixedDelay = 60000)
	public void syncPaymentInfo() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		ImpPayHead searchIph = new ImpPayHead();
		ImpPayHead insertImpPayHead = null;
		PaymentMessage searchPm = new PaymentMessage();;
		List<PaymentMessage> resultPaymentMessageList = null;
		ImpPayHead resultIph = null;
		Date appTime = null;
		searchIph.setPayCode("P460400005");
		searchIph.setOrderBy("app_time desc");
		PageHelper.startPage(1, 1);
		
		List<ImpPayHead> resultImpPayHeadList = this.impPayHeadService.getImpPayHeadList(searchIph);
		
		if (null != resultImpPayHeadList && !resultImpPayHeadList.isEmpty()) {
			resultIph = resultImpPayHeadList.get(0);
			
			if (null != resultIph) {
				appTime = resultIph.getAppTime();
			}
		}
		
		if (null != appTime) {
			searchPm.setBeginCreateDate(sdf.format(appTime));
		}
		searchPm.setXmlContent("<BILLMODE>0</BILLMODE>");
		searchPm.setOrderBy("created_date asc");
		PageHelper.startPage(1, 30);
		resultPaymentMessageList = this.paymentMessageService.getPaymentMessageList(searchPm);
		
		if (null != resultPaymentMessageList && !resultPaymentMessageList.isEmpty()) {
			for (PaymentMessage pm : resultPaymentMessageList) {
				insertImpPayHead = PaymentTool.buildImpPayHeadByCbecMessage(PaymentTool.buildCbecMessageByString(pm.getXmlContent(), pm.getCreatedDate()));
				
				if (null != insertImpPayHead) {
					try {
						this.impPayHeadService.insertPayHead(insertImpPayHead);						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
