package online.zhaopei.myproject.domain.ecssent;

import java.util.Date;

import online.zhaopei.myproject.domain.BaseDomain;

public class LgsHead extends BaseDomain {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6934310248461818405L;

	private String guid;
	
	private String appType;
	
	private Date appTime;
	
	private String appStatus;
	
	private String appUid;
	
	private String appUname;
	
	private String appSenderId;
	
	private Date declTime;
	
	private String logisticsCode;
	
	private String logisticsName;
	
	private String logisticsNo;
	
	private String billNo;
	
	private Double freight;
	
	private Double insuredFee;
	
	private String currency;
	
	private Double weight;
	
	private Integer packNo;
	
	private String goodsInfo;
	
	private String consignee;
	
	private String consigneeAddress;
	
	private String consigneeTelephone;
	
	private String note;
	
	private String msgGuid;
	
	private Integer delFlag;
	
	private Integer sysDays;
	
	private Date sysDate;
	
	private String beginSysDate;
	
	private String endSysDate;
	
	private String searchText;

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

	public String getLogisticsCode() {
		return logisticsCode;
	}

	public void setLogisticsCode(String logisticsCode) {
		this.logisticsCode = logisticsCode;
	}

	public String getLogisticsName() {
		return logisticsName;
	}

	public void setLogisticsName(String logisticsName) {
		this.logisticsName = logisticsName;
	}

	public String getLogisticsNo() {
		return logisticsNo;
	}

	public void setLogisticsNo(String logisticsNo) {
		this.logisticsNo = logisticsNo;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public Double getFreight() {
		return freight;
	}

	public void setFreight(Double freight) {
		this.freight = freight;
	}

	public Double getInsuredFee() {
		return insuredFee;
	}

	public void setInsuredFee(Double insuredFee) {
		this.insuredFee = insuredFee;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Integer getPackNo() {
		return packNo;
	}

	public void setPackNo(Integer packNo) {
		this.packNo = packNo;
	}

	public String getGoodsInfo() {
		return goodsInfo;
	}

	public void setGoodsInfo(String goodsInfo) {
		this.goodsInfo = goodsInfo;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getConsigneeAddress() {
		return consigneeAddress;
	}

	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}

	public String getConsigneeTelephone() {
		return consigneeTelephone;
	}

	public void setConsigneeTelephone(String consigneeTelephone) {
		this.consigneeTelephone = consigneeTelephone;
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

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
}
