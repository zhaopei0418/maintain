package online.zhaopei.myproject.domain.ecssent;

import java.util.Date;
import java.util.List;

import online.zhaopei.myproject.domain.BaseDomain;

public class DistHead extends BaseDomain {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7381174376703467288L;

	private String seqNo;
	
	private String distNo;
	
	private String copDistNo;
	
	private String customsCode;
	
	private String distType;
	
	private String cfsCode;
	
	private String ieFlag;
	
	private String ieType;
	
	private String billType;
	
	private Double totalPackNum;
	
	private Double totalGrossWt;
	
	private Double totalNetWt;
	
	private Double totalGValue;
	
	private String declCode;
	
	private String declName;
	
	private String districtCode;
	
	private String ieFlag1;
	
	private String dischargeCode;
	
	private String ieFlag2;
	
	private String inputPerson;
	
	private String distStat;
	
	private Date inputDate;
	
	private String inputDateStr;
	
	private String beginInputDate;
	
	private String endInputDate;
	
	private Date declDate;
	
	private String billSum;
	
	private String veSum;
	
	private String modifyMark;
	
	private Date apprDate;
	
	private String note;
	
	private String returnReason;
	
	private String iePort;
	
	private String searchText;
	
	private String veNo;
	
	private VeHead veHead;
	
	private List<DistBillList> distBillListList;

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

	public String getCustomsCode() {
		return customsCode;
	}

	public void setCustomsCode(String customsCode) {
		this.customsCode = customsCode;
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

	public String getDistStat() {
		return distStat;
	}

	public void setDistStat(String distStat) {
		this.distStat = distStat;
	}

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public Date getDeclDate() {
		return declDate;
	}

	public void setDeclDate(Date declDate) {
		this.declDate = declDate;
	}

	public String getReturnReason() {
		return returnReason;
	}

	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getCopDistNo() {
		return copDistNo;
	}

	public void setCopDistNo(String copDistNo) {
		this.copDistNo = copDistNo;
	}

	public String getDistType() {
		return distType;
	}

	public void setDistType(String distType) {
		this.distType = distType;
	}

	public String getCfsCode() {
		return cfsCode;
	}

	public void setCfsCode(String cfsCode) {
		this.cfsCode = cfsCode;
	}

	public String getIeFlag() {
		return ieFlag;
	}

	public void setIeFlag(String ieFlag) {
		this.ieFlag = ieFlag;
	}

	public String getIeType() {
		return ieType;
	}

	public void setIeType(String ieType) {
		this.ieType = ieType;
	}

	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	public Double getTotalPackNum() {
		return totalPackNum;
	}

	public void setTotalPackNum(Double totalPackNum) {
		this.totalPackNum = totalPackNum;
	}

	public Double getTotalGrossWt() {
		return totalGrossWt;
	}

	public void setTotalGrossWt(Double totalGrossWt) {
		this.totalGrossWt = totalGrossWt;
	}

	public Double getTotalNetWt() {
		return totalNetWt;
	}

	public void setTotalNetWt(Double totalNetWt) {
		this.totalNetWt = totalNetWt;
	}

	public Double getTotalGValue() {
		return totalGValue;
	}

	public void setTotalGValue(Double totalGValue) {
		this.totalGValue = totalGValue;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getIeFlag1() {
		return ieFlag1;
	}

	public void setIeFlag1(String ieFlag1) {
		this.ieFlag1 = ieFlag1;
	}

	public String getDischargeCode() {
		return dischargeCode;
	}

	public void setDischargeCode(String dischargeCode) {
		this.dischargeCode = dischargeCode;
	}

	public String getIeFlag2() {
		return ieFlag2;
	}

	public void setIeFlag2(String ieFlag2) {
		this.ieFlag2 = ieFlag2;
	}

	public String getInputPerson() {
		return inputPerson;
	}

	public void setInputPerson(String inputPerson) {
		this.inputPerson = inputPerson;
	}

	public String getBillSum() {
		return billSum;
	}

	public void setBillSum(String billSum) {
		this.billSum = billSum;
	}

	public String getVeSum() {
		return veSum;
	}

	public void setVeSum(String veSum) {
		this.veSum = veSum;
	}

	public String getModifyMark() {
		return modifyMark;
	}

	public void setModifyMark(String modifyMark) {
		this.modifyMark = modifyMark;
	}

	public Date getApprDate() {
		return apprDate;
	}

	public void setApprDate(Date apprDate) {
		this.apprDate = apprDate;
	}

	public String getIePort() {
		return iePort;
	}

	public void setIePort(String iePort) {
		this.iePort = iePort;
	}

	public String getBeginInputDate() {
		return beginInputDate;
	}

	public void setBeginInputDate(String beginInputDate) {
		this.beginInputDate = beginInputDate;
	}

	public String getEndInputDate() {
		return endInputDate;
	}

	public void setEndInputDate(String endInputDate) {
		this.endInputDate = endInputDate;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public String getVeNo() {
		return veNo;
	}

	public void setVeNo(String veNo) {
		this.veNo = veNo;
	}

	public String getInputDateStr() {
		return inputDateStr;
	}

	public void setInputDateStr(String inputDateStr) {
		this.inputDateStr = inputDateStr;
	}

	public VeHead getVeHead() {
		return veHead;
	}

	public void setVeHead(VeHead veHead) {
		this.veHead = veHead;
	}

	public List<DistBillList> getDistBillListList() {
		return distBillListList;
	}

	public void setDistBillListList(List<DistBillList> distBillListList) {
		this.distBillListList = distBillListList;
	}
}
