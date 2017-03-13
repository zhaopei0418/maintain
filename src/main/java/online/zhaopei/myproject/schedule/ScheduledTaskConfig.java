package online.zhaopei.myproject.schedule;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import online.zhaopei.myproject.common.tool.PaymentTool;
import online.zhaopei.myproject.config.ApplicationProp;
import online.zhaopei.myproject.domain.gjent.ImpPayHead;
import online.zhaopei.myproject.domain.gjpayment.BodyMasterCiq;
import online.zhaopei.myproject.domain.gjpayment.CbecMessage;
import online.zhaopei.myproject.domain.gjpayment.CbecMessageCiq;
import online.zhaopei.myproject.domain.gjpayment.MessageBodyCiq;
import online.zhaopei.myproject.domain.gjpayment.MessageHeadCiq;
import online.zhaopei.myproject.domain.gjpayment.PaymentMessage;
import online.zhaopei.myproject.service.ecssent.InvtHeadService;
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

	@Autowired
	private InvtHeadService invtHeadService;
	
	@Autowired
	private ApplicationProp app;

	@Scheduled(cron = "0 0 1 * * *")
	public void deleteExportFile() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String regex = "^[a-z_]{1,}" + sdf.format(Calendar.getInstance().getTime()) + "[0-9]{9}.csv$";
		File file = new File("export");
		if (file.isDirectory()) {
			File[] children = file.listFiles();
			for (File f : children)
				if (!f.getName().matches(regex))
					f.delete();
		}
	}

	@Scheduled(fixedDelay = 300000)
	public void modifyInvtStatus() throws Exception {
		List<String> headGuidList = this.invtHeadService.getReleaseBackStaggeredInvtList();
		
		if (null != headGuidList && !headGuidList.isEmpty()) {
			for (String headGuid : headGuidList) {
				this.invtHeadService.updateInvtHeadStatus(headGuid, "100");
			}
		}
	}
	
	@Scheduled(initialDelay = 10000, fixedDelay = 60000)
	public void syncPaymentInfo() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat sdfDay = new SimpleDateFormat("yyyyMMdd");
		ImpPayHead insertImpPayHead = null;
		ImpPayHead searchImpPayHead = null;
		CbecMessage cbecMessage = null;
		CbecMessageCiq cbecMessageCiq = new CbecMessageCiq();
		MessageHeadCiq messageHeadCiq = new MessageHeadCiq();
		MessageBodyCiq messageBodyCiq = new MessageBodyCiq();
		BodyMasterCiq bodyMasterCiq = new BodyMasterCiq();
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
				cbecMessage = PaymentTool.buildCbecMessageByString(pm.getXmlContent(), pm.getCreatedDate());
				insertImpPayHead = PaymentTool.buildImpPayHeadByCbecMessage(cbecMessage);

				if (null != insertImpPayHead) {
					try {
						searchImpPayHead = new ImpPayHead(insertImpPayHead.getUuid());
						if (0 < this.impPayHeadService.countImpPayHead(searchImpPayHead)) {
							continue;
						}

						BeanUtils.copyProperties(cbecMessage.getMessageBody().getBodyMaster(), bodyMasterCiq);
						BeanUtils.copyProperties(cbecMessage.getMessageHead(), messageHeadCiq);
						bodyMasterCiq.setCoinInsp(bodyMasterCiq.getMonetaryType());
						bodyMasterCiq.setMonetaryType(null);
						messageBodyCiq.setBodyMaster(bodyMasterCiq);
						cbecMessageCiq.setMessageHead(messageHeadCiq);
						cbecMessageCiq.setMessageBody(messageBodyCiq);

						PaymentTool.generateCbecMessageCiq(cbecMessageCiq, this.app.getCiqDir(), this.app.getBackDir());

						searchImpPayHead = new ImpPayHead(insertImpPayHead.getPayCode(),
								insertImpPayHead.getPayTransactionId());
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
