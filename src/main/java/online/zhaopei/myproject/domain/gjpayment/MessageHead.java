package online.zhaopei.myproject.domain.gjpayment;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import online.zhaopei.myproject.common.adapter.DateAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageHead implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6592310080509734370L;

	@XmlElement(name = "MESSAGEID")
	private String messageId;
	
	@XmlElement(name = "MESSAGETYPE")
	private String messageType;
	
	@XmlElement(name = "SENDERID")
	private String senderId;
	
	@XmlElement(name = "RECEIVERID")
	private String receiverId;
	
	@XmlElement(name = "SEQNO")
	private String seqNo;
	
	@XmlElement(name = "SENDTIME")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date sendTime;
	
	@XmlTransient
	private Date appTime;
	
	@XmlElement(name = "BILLMODE")
	private String billMode;

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	public Date getAppTime() {
		return appTime;
	}

	public void setAppTime(Date appTime) {
		this.appTime = appTime;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public String getBillMode() {
		return billMode;
	}

	public void setBillMode(String billMode) {
		this.billMode = billMode;
	}
}
