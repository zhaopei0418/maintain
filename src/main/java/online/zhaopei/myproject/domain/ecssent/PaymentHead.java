package online.zhaopei.myproject.domain.ecssent;

import java.util.Date;

import online.zhaopei.myproject.domain.BaseDomain;

public class PaymentHead extends BaseDomain {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4640113677709759030L;

	private String guid;
	
	private String appType;
	
	private Date appTime;
	
	private String appStatus;
	
	private String appUid;
	
	private String appSenderId;
	
	private Date declTime;
	
	private String payCode;
	
	private String payName;
	
	private String payTransactionId;
	
	private String ordNo;
	
	private String ebpCode;
	
	private String ebpName;
	
	private String payerIdType;
	
	private String payerIdNumber;
	
	private String payerName;
	
	private String telephone;
	
	private Double aumountPaid;
	
	private String currency;
	
	private String note;
	
	private String msgGuid;
	
	private Integer delFlag;
	
	private Integer sysDays;
	
	private Date sysDate;
	
	private String beginSysDate;
	
	private String endSysDate;

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	public Date getAppTime() {
		return appTime;
	}

	public void setAppTime(Date appTime) {
		this.appTime = appTime;
	}

	public String getAppStatus() {
		return appStatus;
	}

	public void setAppStatus(String appStatus) {
		this.appStatus = appStatus;
	}

	public String getAppUid() {
		return appUid;
	}

	public void setAppUid(String appUid) {
		this.appUid = appUid;
	}

	public String getAppSenderId() {
		return appSenderId;
	}

	public void setAppSenderId(String appSenderId) {
		this.appSenderId = appSenderId;
	}

	public Date getDeclTime() {
		return declTime;
	}

	public void setDeclTime(Date declTime) {
		this.declTime = declTime;
	}

	public String getPayCode() {
		return payCode;
	}

	public void setPayCode(String payCode) {
		this.payCode = payCode;
	}

	public String getPayName() {
		return payName;
	}

	public void setPayName(String payName) {
		this.payName = payName;
	}

	public String getPayTransactionId() {
		return payTransactionId;
	}

	public void setPayTransactionId(String payTransactionId) {
		this.payTransactionId = payTransactionId;
	}

	public String getOrdNo() {
		return ordNo;
	}

	public void setOrdNo(String ordNo) {
		this.ordNo = ordNo;
	}

	public String getEbpCode() {
		return ebpCode;
	}

	public void setEbpCode(String ebpCode) {
		this.ebpCode = ebpCode;
	}

	public String getEbpName() {
		return ebpName;
	}

	public void setEbpName(String ebpName) {
		this.ebpName = ebpName;
	}

	public String getPayerIdType() {
		return payerIdType;
	}

	public void setPayerIdType(String payerIdType) {
		this.payerIdType = payerIdType;
	}

	public String getPayerIdNumber() {
		return payerIdNumber;
	}

	public void setPayerIdNumber(String payerIdNumber) {
		this.payerIdNumber = payerIdNumber;
	}

	public String getPayerName() {
		return payerName;
	}

	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Double getAumountPaid() {
		return aumountPaid;
	}

	public void setAumountPaid(Double aumountPaid) {
		this.aumountPaid = aumountPaid;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getMsgGuid() {
		return msgGuid;
	}

	public void setMsgGuid(String msgGuid) {
		this.msgGuid = msgGuid;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public Integer getSysDays() {
		return sysDays;
	}

	public void setSysDays(Integer sysDays) {
		this.sysDays = sysDays;
	}

	public Date getSysDate() {
		return sysDate;
	}

	public void setSysDate(Date sysDate) {
		this.sysDate = sysDate;
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
}
