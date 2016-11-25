package online.zhaopei.myproject.domain.gjent;

import java.util.Date;

import online.zhaopei.myproject.domain.BaseDomain;

public class ImpPayHead extends BaseDomain {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5157514868096935278L;

	private String guid;
	
	private String appType;
	
	private Date appTime;
	
	private String appStatus;
	
	private String appUId;
	
	private String appUName;
	
	private String payCode;
	
	private String payName;
	
	private String payTransactionId;
	
	private String orderNo;
	
	private String ebpCode;
	
	private String ebpName;
	
	private String payerIdType;
	
	private String payerIdNumber;
	
	private String payerName;
	
	private String telephone;
	
	private Double amountPaid;
	
	private String currency;
	
	private Date payTime;
	
	private String note;
	
	private Integer sysDays;
	
	private Date sysDate;
	
	private String returnStatus;
	
	private Date returnTime;
	
	private String returnInfo;
	
	private String seqNo;
	
	private String managerCustomsCode;
	
	private String paymentType;
	
	private String customerFlag;
	
	private String ieType;
	
	private String payECode;
	
	private String cbeCodeInsp;
	
	private String coinInsp;
	
	private String cbeCode;
	
	private String cbeName;
	
	private String billMode;
	
	private String basicId;
	
	private String approvalDate;
	
	private String auditState;
	
	private Date applyDate;
	
	private String uuid;
	
	public ImpPayHead() {
	}
	
	public ImpPayHead(String uuid) {
		this.uuid = uuid;
	}
	
	public ImpPayHead(String payCode, String payTransactionId) {
		this.payCode = payCode;
		this.payTransactionId = payTransactionId;
	}
	
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

	public String getAppUId() {
		return appUId;
	}

	public void setAppUId(String appUId) {
		this.appUId = appUId;
	}

	public String getAppUName() {
		return appUName;
	}

	public void setAppUName(String appUName) {
		this.appUName = appUName;
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

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
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

	public Double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(Double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
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

	public Date getSysDate() {
		return sysDate;
	}

	public void setSysDate(Date sysDate) {
		this.sysDate = sysDate;
	}

	public String getReturnStatus() {
		return returnStatus;
	}

	public void setReturnStatus(String returnStatus) {
		this.returnStatus = returnStatus;
	}

	public Date getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}

	public String getReturnInfo() {
		return returnInfo;
	}

	public void setReturnInfo(String returnInfo) {
		this.returnInfo = returnInfo;
	}

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	public String getManagerCustomsCode() {
		return managerCustomsCode;
	}

	public void setManagerCustomsCode(String managerCustomsCode) {
		this.managerCustomsCode = managerCustomsCode;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getCustomerFlag() {
		return customerFlag;
	}

	public void setCustomerFlag(String customerFlag) {
		this.customerFlag = customerFlag;
	}

	public String getIeType() {
		return ieType;
	}

	public void setIeType(String ieType) {
		this.ieType = ieType;
	}

	public String getPayECode() {
		return payECode;
	}

	public void setPayECode(String payECode) {
		this.payECode = payECode;
	}

	public String getCbeCodeInsp() {
		return cbeCodeInsp;
	}

	public void setCbeCodeInsp(String cbeCodeInsp) {
		this.cbeCodeInsp = cbeCodeInsp;
	}

	public String getCoinInsp() {
		return coinInsp;
	}

	public void setCoinInsp(String coinInsp) {
		this.coinInsp = coinInsp;
	}

	public String getCbeCode() {
		return cbeCode;
	}

	public void setCbeCode(String cbeCode) {
		this.cbeCode = cbeCode;
	}

	public String getCbeName() {
		return cbeName;
	}

	public void setCbeName(String cbeName) {
		this.cbeName = cbeName;
	}

	public String getBillMode() {
		return billMode;
	}

	public void setBillMode(String billMode) {
		this.billMode = billMode;
	}

	public String getBasicId() {
		return basicId;
	}

	public void setBasicId(String basicId) {
		this.basicId = basicId;
	}

	public String getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}

	public String getAuditState() {
		return auditState;
	}

	public void setAuditState(String auditState) {
		this.auditState = auditState;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
