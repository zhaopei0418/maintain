package online.zhaopei.myproject.domain.ecssent;

import java.util.Date;

import online.zhaopei.myproject.domain.BaseDomain;

public class OrderHead extends BaseDomain {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7727501655352035426L;

	private String headGuid;
	
	private String appType;
	
	private Date appTime;
	
	private String appStatus;
	
	private String appUid;
	
	private String appUname;
	
	private String appSenderId;
	
	private Date declTime;
	
	private String orderType;
	
	private String orderNo;
	
	private String ebpCode;
	
	private String ebpName;
	
	private String ebcCode;
	
	private String ebcName;
	
	private Double goodsValue;
	
	private Double freight;
	
	private Double discount;
	
	private Double taxTotal;
	
	private Double acturalPaid;
	
	private String currency;
	
	private String buyerRegNo;
	
	private String buyerName;
	
	private String buyerIdType;
	
	private String buyerIdNumber;
	
	private String payCode;
	
	private String payName;
	
	private String payTransactionId;
	
	private String batchNumbers;
	
	private String consignee;
	
	private String consigneeTelephone;
	
	private String consigneeAddress;
	
	private String consigneeDistrict;
	
	private String note;
	
	private String msgGuid;
	
	private Integer delFlag;
	
	private Integer sysDays;
	
	private Date sysDate;
	
	private String beginSysDate;
	
	private String endSysDate;

	public String getHeadGuid() {
		return headGuid;
	}

	public void setHeadGuid(String headGuid) {
		this.headGuid = headGuid;
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

	public String getAppUname() {
		return appUname;
	}

	public void setAppUname(String appUname) {
		this.appUname = appUname;
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

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
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

	public String getEbcCode() {
		return ebcCode;
	}

	public void setEbcCode(String ebcCode) {
		this.ebcCode = ebcCode;
	}

	public String getEbcName() {
		return ebcName;
	}

	public void setEbcName(String ebcName) {
		this.ebcName = ebcName;
	}

	public Double getGoodsValue() {
		return goodsValue;
	}

	public void setGoodsValue(Double goodsValue) {
		this.goodsValue = goodsValue;
	}

	public Double getFreight() {
		return freight;
	}

	public void setFreight(Double freight) {
		this.freight = freight;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getTaxTotal() {
		return taxTotal;
	}

	public void setTaxTotal(Double taxTotal) {
		this.taxTotal = taxTotal;
	}

	public Double getActuralPaid() {
		return acturalPaid;
	}

	public void setActuralPaid(Double acturalPaid) {
		this.acturalPaid = acturalPaid;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getBuyerRegNo() {
		return buyerRegNo;
	}

	public void setBuyerRegNo(String buyerRegNo) {
		this.buyerRegNo = buyerRegNo;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerIdType() {
		return buyerIdType;
	}

	public void setBuyerIdType(String buyerIdType) {
		this.buyerIdType = buyerIdType;
	}

	public String getBuyerIdNumber() {
		return buyerIdNumber;
	}

	public void setBuyerIdNumber(String buyerIdNumber) {
		this.buyerIdNumber = buyerIdNumber;
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

	public String getBatchNumbers() {
		return batchNumbers;
	}

	public void setBatchNumbers(String batchNumbers) {
		this.batchNumbers = batchNumbers;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getConsigneeTelephone() {
		return consigneeTelephone;
	}

	public void setConsigneeTelephone(String consigneeTelephone) {
		this.consigneeTelephone = consigneeTelephone;
	}

	public String getConsigneeAddress() {
		return consigneeAddress;
	}

	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}

	public String getConsigneeDistrict() {
		return consigneeDistrict;
	}

	public void setConsigneeDistrict(String consigneeDistrict) {
		this.consigneeDistrict = consigneeDistrict;
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
