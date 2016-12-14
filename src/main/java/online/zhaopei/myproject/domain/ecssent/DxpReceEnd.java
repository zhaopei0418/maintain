package online.zhaopei.myproject.domain.ecssent;

import java.util.Date;

import online.zhaopei.myproject.domain.BaseDomain;

public class DxpReceEnd extends BaseDomain {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5918801048132210874L;

	private String msgGuid;
	
	private String dxpMode;
	
	private Integer dxpStatus;
	
	private String dxpHost;
	
	private String msgType;
	
	private String msgName;
	
	private String msgId;
	
	private String msgKey;
	
	private Date msgTime;
	
	private String sendAd;
	
	private String receAd;
	
	private String note;
	
	private Integer sysDays;
	
	private String beginSysDate;
	
	private String endSysDate;
	
	private String sysDateStr;
	
	private Date sysDate;

	public String getMsgGuid() {
		return msgGuid;
	}

	public void setMsgGuid(String msgGuid) {
		this.msgGuid = msgGuid;
	}

	public String getDxpMode() {
		return dxpMode;
	}

	public void setDxpMode(String dxpMode) {
		this.dxpMode = dxpMode;
	}

	public Integer getDxpStatus() {
		return dxpStatus;
	}

	public void setDxpStatus(Integer dxpStatus) {
		this.dxpStatus = dxpStatus;
	}

	public String getDxpHost() {
		return dxpHost;
	}

	public void setDxpHost(String dxpHost) {
		this.dxpHost = dxpHost;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getMsgName() {
		return msgName;
	}

	public void setMsgName(String msgName) {
		this.msgName = msgName;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getMsgKey() {
		return msgKey;
	}

	public void setMsgKey(String msgKey) {
		this.msgKey = msgKey;
	}

	public Date getMsgTime() {
		return msgTime;
	}

	public void setMsgTime(Date msgTime) {
		this.msgTime = msgTime;
	}

	public String getSendAd() {
		return sendAd;
	}

	public void setSendAd(String sendAd) {
		this.sendAd = sendAd;
	}

	public String getReceAd() {
		return receAd;
	}

	public void setReceAd(String receAd) {
		this.receAd = receAd;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getSysDays() {
		return sysDays;
	}

	public void setSysDays(Integer sysDays) {
		this.sysDays = sysDays;
	}

	public String getBeginSysDate() {
		return beginSysDate;
	}

	public void setBeginSysDate(String beginSysDate) {
		this.beginSysDate = beginSysDate;
	}

	public String getEndSysDate() {
		return endSysDate;
	}

	public void setEndSysDate(String endSysDate) {
		this.endSysDate = endSysDate;
	}

	public String getSysDateStr() {
		return sysDateStr;
	}

	public void setSysDateStr(String sysDateStr) {
		this.sysDateStr = sysDateStr;
	}

	public Date getSysDate() {
		return sysDate;
	}

	public void setSysDate(Date sysDate) {
		this.sysDate = sysDate;
	}
}
