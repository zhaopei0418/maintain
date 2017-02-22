package online.zhaopei.myproject.domain.ecssent;

import java.util.Date;

import online.zhaopei.myproject.domain.BaseDomain;

public class CheckMailGoodHead extends BaseDomain {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7388772844937414182L;

	private String seqNo;
	
	private String entryId;
	
	private String ieFlage;
	
	private String orderNo;
	
	private String logisticsNo;
	
	private String logisticsName;
	
	private String logisticsCode;
	
	private String ecpCode;
	
	private String ecpName;
	
	private String wrapType;
	
	private Double packNum;
	
	private Double grossWt;
	
	private Double netWt;
	
	private Double goodsValue;
	
	private Double freight;
	
	private String controlledStatus;
	
	private Date controlledDate;
	
	private String operator;
	
	private Date messageTime;
	
	private String beginMessageTime;
	
	private String endMessageTime;
	
	private String messageTimeStr;
	
	private String note;
	
	private String source;
	
	private Date indbTime;
	
	private Date updateTime;
	
	private Date checkDate;
	
	private String beginCheckDate;
	
	private String endCheckDate;
	
	private String checkDateStr;
	
	private String checkType;
	
	private String checkMan;
	
	private String checkOpinion;
	
	private String customsCode;
	
	private String checkResult;
	
	private String checkMan2;
	
	private String consignee;
	
	private String shipper;
	
	private String status;
	
	private String ifCheckInsp;
	
	private String ifMachine;
	
	private String currCode;
	
	private String statusInsp;
	
	private String opType;
	
	private String opTypeInsp;
	
	private String zydCode;

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	public String getEntryId() {
		return entryId;
	}

	public void setEntryId(String entryId) {
		this.entryId = entryId;
	}

	public String getIeFlage() {
		return ieFlage;
	}

	public void setIeFlage(String ieFlage) {
		this.ieFlage = ieFlage;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getLogisticsNo() {
		return logisticsNo;
	}

	public void setLogisticsNo(String logisticsNo) {
		this.logisticsNo = logisticsNo;
	}

	public String getLogisticsName() {
		return logisticsName;
	}

	public void setLogisticsName(String logisticsName) {
		this.logisticsName = logisticsName;
	}

	public String getLogisticsCode() {
		return logisticsCode;
	}

	public void setLogisticsCode(String logisticsCode) {
		this.logisticsCode = logisticsCode;
	}

	public String getEcpCode() {
		return ecpCode;
	}

	public void setEcpCode(String ecpCode) {
		this.ecpCode = ecpCode;
	}

	public String getEcpName() {
		return ecpName;
	}

	public void setEcpName(String ecpName) {
		this.ecpName = ecpName;
	}

	public String getWrapType() {
		return wrapType;
	}

	public void setWrapType(String wrapType) {
		this.wrapType = wrapType;
	}

	public Double getPackNum() {
		return packNum;
	}

	public void setPackNum(Double packNum) {
		this.packNum = packNum;
	}

	public Double getGrossWt() {
		return grossWt;
	}

	public void setGrossWt(Double grossWt) {
		this.grossWt = grossWt;
	}

	public Double getNetWt() {
		return netWt;
	}

	public void setNetWt(Double netWt) {
		this.netWt = netWt;
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

	public String getControlledStatus() {
		return controlledStatus;
	}

	public void setControlledStatus(String controlledStatus) {
		this.controlledStatus = controlledStatus;
	}

	public Date getControlledDate() {
		return controlledDate;
	}

	public void setControlledDate(Date controlledDate) {
		this.controlledDate = controlledDate;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Date getMessageTime() {
		return messageTime;
	}

	public void setMessageTime(Date messageTime) {
		this.messageTime = messageTime;
	}

	public String getBeginMessageTime() {
		return beginMessageTime;
	}

	public void setBeginMessageTime(String beginMessageTime) {
		this.beginMessageTime = beginMessageTime;
	}

	public String getEndMessageTime() {
		return endMessageTime;
	}

	public void setEndMessageTime(String endMessageTime) {
		this.endMessageTime = endMessageTime;
	}

	public String getMessageTimeStr() {
		return messageTimeStr;
	}

	public void setMessageTimeStr(String messageTimeStr) {
		this.messageTimeStr = messageTimeStr;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Date getIndbTime() {
		return indbTime;
	}

	public void setIndbTime(Date indbTime) {
		this.indbTime = indbTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public String getBeginCheckDate() {
		return beginCheckDate;
	}

	public void setBeginCheckDate(String beginCheckDate) {
		this.beginCheckDate = beginCheckDate;
	}

	public String getEndCheckDate() {
		return endCheckDate;
	}

	public void setEndCheckDate(String endCheckDate) {
		this.endCheckDate = endCheckDate;
	}

	public String getCheckDateStr() {
		return checkDateStr;
	}

	public void setCheckDateStr(String checkDateStr) {
		this.checkDateStr = checkDateStr;
	}

	public String getCheckType() {
		return checkType;
	}

	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}

	public String getCheckMan() {
		return checkMan;
	}

	public void setCheckMan(String checkMan) {
		this.checkMan = checkMan;
	}

	public String getCheckOpinion() {
		return checkOpinion;
	}

	public void setCheckOpinion(String checkOpinion) {
		this.checkOpinion = checkOpinion;
	}

	public String getCustomsCode() {
		return customsCode;
	}

	public void setCustomsCode(String customsCode) {
		this.customsCode = customsCode;
	}

	public String getCheckResult() {
		return checkResult;
	}

	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}

	public String getCheckMan2() {
		return checkMan2;
	}

	public void setCheckMan2(String checkMan2) {
		this.checkMan2 = checkMan2;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getShipper() {
		return shipper;
	}

	public void setShipper(String shipper) {
		this.shipper = shipper;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIfCheckInsp() {
		return ifCheckInsp;
	}

	public void setIfCheckInsp(String ifCheckInsp) {
		this.ifCheckInsp = ifCheckInsp;
	}

	public String getIfMachine() {
		return ifMachine;
	}

	public void setIfMachine(String ifMachine) {
		this.ifMachine = ifMachine;
	}

	public String getCurrCode() {
		return currCode;
	}

	public void setCurrCode(String currCode) {
		this.currCode = currCode;
	}

	public String getStatusInsp() {
		return statusInsp;
	}

	public void setStatusInsp(String statusInsp) {
		this.statusInsp = statusInsp;
	}

	public String getOpType() {
		return opType;
	}

	public void setOpType(String opType) {
		this.opType = opType;
	}

	public String getOpTypeInsp() {
		return opTypeInsp;
	}

	public void setOpTypeInsp(String opTypeInsp) {
		this.opTypeInsp = opTypeInsp;
	}

	public String getZydCode() {
		return zydCode;
	}

	public void setZydCode(String zydCode) {
		this.zydCode = zydCode;
	}
}
