package online.zhaopei.myproject.domain.ecssent;

import java.util.Date;

import online.zhaopei.myproject.domain.BaseDomain;

public class TaxHead extends BaseDomain {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1561700506262521785L;

	private String headGuid;
	
	private Date returnTime;
	
	private String customsCode;
	
	private String invtNo;
	
	private String taxNo;
	
	private Double taxTotal;
	
	private Double customsTax;
	
	private Double valueAddedTax;
	
	private Double consumptionTax;
	
	private String status;
	
	private String entDutyNo;
	
	private String note;
	
	private String idNumber;
	
	private String assureCode;
	
	private String ebcCode;
	
	private String logisticsCode;
	
	private Integer delFlag;
	
	private String msgGuid;
	
	private Integer sysDays;
	
	private String beginSysDate;
	
	private String endSysDate;
	
	private String sysDateStr;
	
	private Date sysDate;
	
	private String agentCode;

	public String getHeadGuid() {
		return headGuid;
	}

	public void setHeadGuid(String headGuid) {
		this.headGuid = headGuid;
	}

	public Date getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}

	public String getCustomsCode() {
		return customsCode;
	}

	public void setCustomsCode(String customsCode) {
		this.customsCode = customsCode;
	}

	public String getInvtNo() {
		return invtNo;
	}

	public void setInvtNo(String invtNo) {
		this.invtNo = invtNo;
	}

	public String getTaxNo() {
		return taxNo;
	}

	public void setTaxNo(String taxNo) {
		this.taxNo = taxNo;
	}

	public Double getTaxTotal() {
		return taxTotal;
	}

	public void setTaxTotal(Double taxTotal) {
		this.taxTotal = taxTotal;
	}

	public Double getCustomsTax() {
		return customsTax;
	}

	public void setCustomsTax(Double customsTax) {
		this.customsTax = customsTax;
	}

	public Double getValueAddedTax() {
		return valueAddedTax;
	}

	public void setValueAddedTax(Double valueAddedTax) {
		this.valueAddedTax = valueAddedTax;
	}

	public Double getConsumptionTax() {
		return consumptionTax;
	}

	public void setConsumptionTax(Double consumptionTax) {
		this.consumptionTax = consumptionTax;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEntDutyNo() {
		return entDutyNo;
	}

	public void setEntDutyNo(String entDutyNo) {
		this.entDutyNo = entDutyNo;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getAssureCode() {
		return assureCode;
	}

	public void setAssureCode(String assureCode) {
		this.assureCode = assureCode;
	}

	public String getEbcCode() {
		return ebcCode;
	}

	public void setEbcCode(String ebcCode) {
		this.ebcCode = ebcCode;
	}

	public String getLogisticsCode() {
		return logisticsCode;
	}

	public void setLogisticsCode(String logisticsCode) {
		this.logisticsCode = logisticsCode;
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

	public String getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}
}
