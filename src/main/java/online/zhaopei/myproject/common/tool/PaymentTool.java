package online.zhaopei.myproject.common.tool;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import online.zhaopei.myproject.domain.gjent.ImpPayHead;
import online.zhaopei.myproject.domain.gjpayment.BodyMaster;
import online.zhaopei.myproject.domain.gjpayment.CbecMessage;
import online.zhaopei.myproject.domain.gjpayment.CbecMessageCiq;
import online.zhaopei.myproject.domain.gjpayment.MessageHead;

public final class PaymentTool {
	
	public static Logger logger = LoggerFactory.getLogger(PaymentTool.class);
	
	public static void generateCbecMessageCiq(CbecMessageCiq cbecMessageCiq, String dir, String backDir) {
		if (null == cbecMessageCiq) {
			return;
		}
		JAXBContext context = null;
		Marshaller marshaller = null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		SimpleDateFormat sdfToday = new SimpleDateFormat("yyyyMMdd");
		String fileName = "CBEC_MESSAGE_" + sdf.format(calendar.getTime());
		File cbecMessage = new File(dir + fileName + ".xml");
		File backCbecMessage = new File(backDir + sdfToday.format(calendar.getTime()) + "/" + fileName + ".xml");
		File backDirFile = new File(backDir + sdfToday.format(calendar.getTime()));
		try {
			context = JAXBContext.newInstance(CbecMessageCiq.class);
			marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
//			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
			
			if (!backDirFile.exists()) {
				backDirFile.mkdir();
			}
			
			marshaller.marshal(cbecMessageCiq, backCbecMessage);
			marshaller.marshal(cbecMessageCiq, cbecMessage);
		} catch (Exception e) {
			e.printStackTrace();
			logger.equals(e);
		}
	}
	
	public static CbecMessage buildCbecMessageByString(String cbecMessageStr, Date appTime) {
		if (null == cbecMessageStr) {
			return null;
		}
		
		CbecMessage cbecMessage = null;
		JAXBContext context = null;
		Unmarshaller um = null;
		ByteArrayInputStream inputStringStream = null;
		try {
			context = JAXBContext.newInstance(CbecMessage.class);
			um = context.createUnmarshaller();
			inputStringStream = new ByteArrayInputStream(cbecMessageStr.getBytes("utf-8"));
			cbecMessage = (CbecMessage) um.unmarshal(inputStringStream);
			cbecMessage.getMessageHead().setAppTime(appTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cbecMessage;
	}
	
	public static ImpPayHead buildImpPayHeadByCbecMessage(CbecMessage cbecMessage) {
		if (null == cbecMessage) {
			return null;
		}
		
		ImpPayHead impPayHead = new ImpPayHead();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		Calendar calendar = Calendar.getInstance();
		MessageHead messageHead = cbecMessage.getMessageHead();
		BodyMaster bodyMaster = cbecMessage.getMessageBody().getBodyMaster();
		impPayHead.setGuid("CFTHENANCUSTOM" + sdf.format(calendar.getTime()) + MathTool.generateFixLenthString(5));
		impPayHead.setUuid(messageHead.getMessageId());
		impPayHead.setAppTime(messageHead.getAppTime());
		impPayHead.setBillMode(messageHead.getBillMode());
		impPayHead.setSeqNo(bodyMaster.getSeqNo());
		impPayHead.setManagerCustomsCode(bodyMaster.getManagerCustomsCode());
		impPayHead.setPayTime(bodyMaster.getPayTime());
		impPayHead.setOrderNo(bodyMaster.getOrderId());
		impPayHead.setPayCode(bodyMaster.getPayEnterpriseCode());
		impPayHead.setPayName(bodyMaster.getPayEnterpriseName());
		impPayHead.setPayTransactionId(bodyMaster.getPayNumber());
		impPayHead.setEbpCode(null == bodyMaster.getEcpCode() ? bodyMaster.getCbeCode() : bodyMaster.getEcpCode());
		impPayHead.setEbpName(bodyMaster.getEcpName());
		impPayHead.setPaymentType(bodyMaster.getPaymentType());
		impPayHead.setCurrency(bodyMaster.getMonetaryType());
		impPayHead.setAmountPaid(bodyMaster.getFee());
		impPayHead.setCustomerFlag(bodyMaster.getCustomerFlag());
		impPayHead.setPayerIdType(bodyMaster.getIdType());
		impPayHead.setPayerIdNumber(bodyMaster.getCustomerId());
		impPayHead.setIeType(bodyMaster.getIeType());
		impPayHead.setNote(bodyMaster.getRemark());
		impPayHead.setPayerName(bodyMaster.getPayUser());
		impPayHead.setPayECode(bodyMaster.getPayECode());
		impPayHead.setCbeCodeInsp(bodyMaster.getCbeCodeInsp());
		impPayHead.setCoinInsp(bodyMaster.getCoinInsp());
		impPayHead.setCbeCode(bodyMaster.getCbeCode());
		impPayHead.setCbeName(bodyMaster.getCbeName());
		
		return impPayHead;
	}
}
