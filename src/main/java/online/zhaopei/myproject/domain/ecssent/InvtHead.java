package online.zhaopei.myproject.domain.ecssent;

import java.util.Date;
import java.util.List;

import com.google.gson.GsonBuilder;

import online.zhaopei.myproject.domain.BaseDomain;
import online.zhaopei.myproject.domain.gjent.ImpInvtHead;

public class InvtHead extends BaseDomain {


	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7169591327880423599L;

	private String headGuid;

	private String appType;
	
	private String appTypeDesc;

	private Date appTime;
	
	private String beginAppTime;
	
	private String endAppTime;

	private String appStatus;

	private String appStatusDesc;

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
	
	private String preNo;

	private String assureCode;

	private String emsNo;

	private String invtNo;

	private Date declTime;

	private String customsCode;

	private String customsCodeDesc;

	private String portCode;

	private String portCodeDesc;

	private Date ieDate;

	private String buyerIdType;

	private String buyerIdTypeDesc;

	private String buyerIdNumber;

	private String buyerName;

	private String buyerTelephone;

	private String consigneeAddress;

	private String agentCode;

	private String agentName;

	private String areaCode;

	private String areaName;

	private String tradeMode;

	private String tradeModeDesc;

	private String trafMode;

	private String trafModeDesc;

	private String trafNo;

	private String voyageNo;

	private String billNo;

	private String loctNo;

	private String licenseNo;

	private String country;

	private String countryDesc;

	private Double freight;

	private Double insuredFee;

	private String currency;

	private String currencyDesc;

	private String wrapType;

	private String wrapTypeDesc;

	private Double packNo;

	private Double grossWeight;

	private Double netWeight;

	private String note;

	private Integer delFlag;

	private String msgGuid;

	private Integer sysDays;

	private Date sysDate;
	
	private String sysDateStr;

	private Double totalValue;

	private String actualIdNumber;
	
	private String opStatus;

	private String distStatus;
	
	private String declareStatus;

	private Date dischargeDate;
	
	private List<PubRtn> pubRtnList;

	private List<ImpInvtHead> impInvtHeadList;
	
	private String distinct;
	
	private String searchText;
	
	private Long count;
	
	private String countType;
	
	private Double percentage;
	
	private List<String> copNoList;
	
	private String applyCode;
	
	private Long total;
	
	private String rtnInfo;
	
	private String detailsCode;
	
	private String auditState;
	
	private String bwName;
	
	private String payName;
	
	private Double goodsValue;
	
	private String distNo;
	
	private String distStat;
	
	private Date distTime;
	
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

	public String getBeginAppTime() {
		return beginAppTime;
	}

	public void setBeginAppTime(String beginAppTime) {
		this.beginAppTime = beginAppTime;
	}

	public String getEndAppTime() {
		return endAppTime;
	}

	public void setEndAppTime(String endAppTime) {
		this.endAppTime = endAppTime;
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

	public String getPreNo() {
		return preNo;
	}

	public void setPreNo(String preNo) {
		this.preNo = preNo;
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

	public String getTrafNo() {
		return trafNo;
	}

	public void setTrafNo(String trafNo) {
		this.trafNo = trafNo;
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
	
	public String getPubRtnListJson() {
		return new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
				.create().toJson(this.pubRtnList);
	}

	public void setPubRtnList(List<PubRtn> pubRtnList) {
		this.pubRtnList = pubRtnList;
	}

	public List<ImpInvtHead> getImpInvtHeadList() {
		return impInvtHeadList;
	}

	public void setImpInvtHeadList(List<ImpInvtHead> impInvtHeadList) {
		this.impInvtHeadList = impInvtHeadList;
	}

	public void setAppStatusDesc(String appStatusDesc) {
		this.appStatusDesc = appStatusDesc;
	}

	public String getAppStatusDesc() {
		return appStatusDesc;
	}

	public void setBuyerIdTypeDesc(String buyerIdTypeDesc) {
		this.buyerIdTypeDesc = buyerIdTypeDesc;
	}

	public String getBuyerIdTypeDesc() {
		return buyerIdTypeDesc;
	}

	public void setCountryDesc(String countryDesc) {
		this.countryDesc = countryDesc;
	}

	public String getCountryDesc() {
		return countryDesc;
	}

	public void setCurrencyDesc(String currencyDesc) {
		this.currencyDesc = currencyDesc;
	}

	public String getCurrencyDesc() {
		return currencyDesc;
	}

	public void setCustomsCodeDesc(String customsCodeDesc) {
		this.customsCodeDesc = customsCodeDesc;
	}

	public String getCustomsCodeDesc() {
		return customsCodeDesc;
	}

	public void setTradeModeDesc(String tradeModeDesc) {
		this.tradeModeDesc = tradeModeDesc;
	}

	public String getTradeModeDesc() {
		return tradeModeDesc;
	}

	public void setPortCodeDesc(String portCodeDesc) {
		this.portCodeDesc = portCodeDesc;
	}

	public String getPortCodeDesc() {
		return portCodeDesc;
	}

	public void setAppTypeDesc(String appTypeDesc) {
		this.appTypeDesc = appTypeDesc;
	}

	public String getAppTypeDesc() {
		return appTypeDesc;
	}

	public void setTrafModeDesc(String trafModeDesc) {
		this.trafModeDesc = trafModeDesc;
	}

	public String getTrafModeDesc() {
		return trafModeDesc;
	}

	public void setWrapTypeDesc(String wrapTypeDesc) {
		this.wrapTypeDesc = wrapTypeDesc;
	}

	public String getWrapTypeDesc() {
		return wrapTypeDesc;
	}

	public String getDeclareStatus() {
		return declareStatus;
	}

	public void setDeclareStatus(String declareStatus) {
		this.declareStatus = declareStatus;
	}

	public String getDistinct() {
		return distinct;
	}

	public void setDistinct(String distinct) {
		this.distinct = distinct;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public List<String> getCopNoList() {
		return copNoList;
	}

	public void setCopNoList(List<String> copNoList) {
		this.copNoList = copNoList;
	}

	public String getApplyCode() {
		return applyCode;
	}

	public void setApplyCode(String applyCode) {
		this.applyCode = applyCode;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public String getCountType() {
		return countType;
	}

	public void setCountType(String countType) {
		this.countType = countType;
	}

	public String getSysDateStr() {
		return sysDateStr;
	}

	public void setSysDateStr(String sysDateStr) {
		this.sysDateStr = sysDateStr;
	}

	public String getRtnInfo() {
		return rtnInfo;
	}

	public void setRtnInfo(String rtnInfo) {
		this.rtnInfo = rtnInfo;
	}

	public String getDetailsCode() {
		return detailsCode;
	}

	public void setDetailsCode(String detailsCode) {
		this.detailsCode = detailsCode;
	}

	public String getAuditState() {
		return auditState;
	}

	public void setAuditState(String auditState) {
		this.auditState = auditState;
	}

	public String getBwName() {
		return bwName;
	}

	public void setBwName(String bwName) {
		this.bwName = bwName;
	}

	public String getPayName() {
		return payName;
	}

	public void setPayName(String payName) {
		this.payName = payName;
	}

	public Double getGoodsValue() {
		return goodsValue;
	}

	public void setGoodsValue(Double goodsValue) {
		this.goodsValue = goodsValue;
	}

	public String getDistNo() {
		return distNo;
	}

	public void setDistNo(String distNo) {
		this.distNo = distNo;
	}

	public String getDistStat() {
		return distStat;
	}

	public void setDistStat(String distStat) {
		this.distStat = distStat;
	}

	public Date getDistTime() {
		return distTime;
	}

	public void setDistTime(Date distTime) {
		this.distTime = distTime;
	}
}
