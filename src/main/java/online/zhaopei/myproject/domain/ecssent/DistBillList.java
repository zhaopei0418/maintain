package online.zhaopei.myproject.domain.ecssent;

import java.util.Date;

import online.zhaopei.myproject.domain.BaseDomain;

public class DistBillList extends BaseDomain {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6793556409636922217L;

	private String seqNo;
	
	private String distNo;
	
	private String billNo;
	
	private String billType;
	
	private String entryId;
	
	private String lmsSeqNo;
	
	private String lmsNo;
	
	private Integer packNum;
	
	private Double grossWt;
	
	private Double netWt;
	
	private String gName;
	
	private String tradeCode;
	
	private String tradeName;
	
	private String declCode;
	
	private String declName;
	
	private String ownerCode;
	
	private String ownerName;
	
	private String iePort;
	
	private String turnNo;
	
	private String trafMode;
	
	private String tradeMode;
	
	private String billId;
	
	private String customsCode;
	
	private String note;
	
	private String decStatus;
	
	private String decLogStat;
	
	private String arrivalFlag;
	
	private Double gValue;
	
	private String modifyMark;
	
	private Date inputDate;
	
	private InvtHead invtHead;

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	public String getDistNo() {
		return distNo;
	}

	public void setDistNo(String distNo) {
		this.distNo = distNo;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	public String getEntryId() {
		return entryId;
	}

	public void setEntryId(String entryId) {
		this.entryId = entryId;
	}

	public String getLmsSeqNo() {
		return lmsSeqNo;
	}

	public void setLmsSeqNo(String lmsSeqNo) {
		this.lmsSeqNo = lmsSeqNo;
	}

	public String getLmsNo() {
		return lmsNo;
	}

	public void setLmsNo(String lmsNo) {
		this.lmsNo = lmsNo;
	}

	public Integer getPackNum() {
		return packNum;
	}

	public void setPackNum(Integer packNum) {
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

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public String getTradeCode() {
		return tradeCode;
	}

	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}

	public String getTradeName() {
		return tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}

	public String getDeclCode() {
		return declCode;
	}

	public void setDeclCode(String declCode) {
		this.declCode = declCode;
	}

	public String getDeclName() {
		return declName;
	}

	public void setDeclName(String declName) {
		this.declName = declName;
	}

	public String getOwnerCode() {
		return ownerCode;
	}

	public void setOwnerCode(String ownerCode) {
		this.ownerCode = ownerCode;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getIePort() {
		return iePort;
	}

	public void setIePort(String iePort) {
		this.iePort = iePort;
	}

	public String getTurnNo() {
		return turnNo;
	}

	public void setTurnNo(String turnNo) {
		this.turnNo = turnNo;
	}

	public String getTrafMode() {
		return trafMode;
	}

	public void setTrafMode(String trafMode) {
		this.trafMode = trafMode;
	}

	public String getTradeMode() {
		return tradeMode;
	}

	public void setTradeMode(String tradeMode) {
		this.tradeMode = tradeMode;
	}

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public String getCustomsCode() {
		return customsCode;
	}

	public void setCustomsCode(String customsCode) {
		this.customsCode = customsCode;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getDecStatus() {
		return decStatus;
	}

	public void setDecStatus(String decStatus) {
		this.decStatus = decStatus;
	}

	public String getDecLogStat() {
		return decLogStat;
	}

	public void setDecLogStat(String decLogStat) {
		this.decLogStat = decLogStat;
	}

	public String getArrivalFlag() {
		return arrivalFlag;
	}

	public void setArrivalFlag(String arrivalFlag) {
		this.arrivalFlag = arrivalFlag;
	}

	public Double getgValue() {
		return gValue;
	}

	public void setgValue(Double gValue) {
		this.gValue = gValue;
	}

	public String getModifyMark() {
		return modifyMark;
	}

	public void setModifyMark(String modifyMark) {
		this.modifyMark = modifyMark;
	}

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public InvtHead getInvtHead() {
		return invtHead;
	}

	public void setInvtHead(InvtHead invtHead) {
		this.invtHead = invtHead;
	}
}
