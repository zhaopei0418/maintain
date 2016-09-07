package online.zhaopei.myproject.domain.ecssent;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import online.zhaopei.myproject.domain.BaseDomain;

public class InvtHead extends BaseDomain {


	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7169591327880423599L;

	private String headGuid;

	private String appType;

	private Date appTime;

	private String appStatus;

	private String appSenderId;

	private String orderNo;

	private String ebpCode;

	private String ebpName;

	private String ebcCode;

	private String ebcName;

	private String logisticsNo;

	private String logisticsCode;

	private String logisticsName;

	private String copNo;

	private String assureCode;

	private String emsNo;

	private String invtNo;

	private Date declTime;

	private String customsCode;

	private String portCode;

	private Date ieDate;

	private String buyerIdType;

	private String buyerIdNumber;

	private String buyerName;

	private String buyerTelephone;

	private String consigneeAddress;

	private String agentCode;

	private String agentName;

	private String areaCode;

	private String areaName;

	private String tradeMode;

	private String trafMode;

	private String voyageNo;

	private String billNo;

	private String loctNo;

	private String licenseNo;

	private String country;

	private Double freight;

	private Double insuredFee;

	private String currency;

	private String wrapType;

	private Double packNo;

	private Double grossWeight;

	private Double netWeight;

	private String note;

	private Integer delFlag;

	private String msgGuid;

	private Integer sysDays;

	private Date sysDate;

	private Double totalValue;

	private String actualIdNumber;
	
	private String opStatus;

	private String distStatus;

	private Date dischargeDate;
	
	private List<PubRtn> pubRtnList;

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

	public String getAppSenderId() {
		return appSenderId;
	}

	public void setAppSenderId(String appSenderId) {
		this.appSenderId = appSenderId;
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

	public String getLogisticsNo() {
		return logisticsNo;
	}

	public void setLogisticsNo(String logisticsNo) {
		this.logisticsNo = logisticsNo;
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

	public String getCopNo() {
		return copNo;
	}

	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}

	public String getAssureCode() {
		return assureCode;
	}

	public void setAssureCode(String assureCode) {
		this.assureCode = assureCode;
	}

	public String getEmsNo() {
		return emsNo;
	}

	public void setEmsNo(String emsNo) {
		this.emsNo = emsNo;
	}

	public String getInvtNo() {
		return invtNo;
	}

	public void setInvtNo(String invtNo) {
		this.invtNo = invtNo;
	}

	public Date getDeclTime() {
		return declTime;
	}

	public void setDeclTime(Date declTime) {
		this.declTime = declTime;
	}

	public String getCustomsCode() {
		return customsCode;
	}

	public void setCustomsCode(String customsCode) {
		this.customsCode = customsCode;
	}

	public String getPortCode() {
		return portCode;
	}

	public void setPortCode(String portCode) {
		this.portCode = portCode;
	}

	public Date getIeDate() {
		return ieDate;
	}

	public void setIeDate(Date ieDate) {
		this.ieDate = ieDate;
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

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerTelephone() {
		return buyerTelephone;
	}

	public void setBuyerTelephone(String buyerTelephone) {
		this.buyerTelephone = buyerTelephone;
	}

	public String getConsigneeAddress() {
		return consigneeAddress;
	}

	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}

	public String getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getTradeMode() {
		return tradeMode;
	}

	public void setTradeMode(String tradeMode) {
		this.tradeMode = tradeMode;
	}

	public String getTrafMode() {
		return trafMode;
	}

	public void setTrafMode(String trafMode) {
		this.trafMode = trafMode;
	}

	public String getVoyageNo() {
		return voyageNo;
	}

	public void setVoyageNo(String voyageNo) {
		this.voyageNo = voyageNo;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getLoctNo() {
		return loctNo;
	}

	public void setLoctNo(String loctNo) {
		this.loctNo = loctNo;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public String getWrapType() {
		return wrapType;
	}

	public void setWrapType(String wrapType) {
		this.wrapType = wrapType;
	}

	public Double getPackNo() {
		return packNo;
	}

	public void setPackNo(Double packNo) {
		this.packNo = packNo;
	}

	public Double getGrossWeight() {
		return grossWeight;
	}

	public void setGrossWeight(Double grossWeight) {
		this.grossWeight = grossWeight;
	}

	public Double getNetWeight() {
		return netWeight;
	}

	public void setNetWeight(Double netWeight) {
		this.netWeight = netWeight;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public String getMsgGuid() {
		return msgGuid;
	}

	public void setMsgGuid(String msgGuid) {
		this.msgGuid = msgGuid;
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

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public String getActualIdNumber() {
		return actualIdNumber;
	}

	public void setActualIdNumber(String actualIdNumber) {
		this.actualIdNumber = actualIdNumber;
	}

	public String getOpStatus() {
		return opStatus;
	}

	public void setOpStatus(String opStatus) {
		this.opStatus = opStatus;
	}

	public String getDistStatus() {
		return distStatus;
	}

	public void setDistStatus(String distStatus) {
		this.distStatus = distStatus;
	}

	public Date getDischargeDate() {
		return dischargeDate;
	}

	public void setDischargeDate(Date dischargeDate) {
		this.dischargeDate = dischargeDate;
	}

	public List<PubRtn> getPubRtnList() {
		return pubRtnList;
	}

	public void setPubRtnList(List<PubRtn> pubRtnList) {
		this.pubRtnList = pubRtnList;
	}
}
