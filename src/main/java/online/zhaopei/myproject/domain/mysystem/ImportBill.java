package online.zhaopei.myproject.domain.mysystem;

import online.zhaopei.myproject.domain.BaseDomain;

public class ImportBill extends BaseDomain {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5885826083955142659L;

	private Long count;
	
	private String lastStatus;
	
	private String beginDeclareDate;
	
	private String endDeclareDate;
	
	private String declareDateStr;
	
	private String declareDate;
	
	private Double totalValueRmb;

	public String getLastStatus() {
		return lastStatus;
	}

	public void setLastStatus(String lastStatus) {
		this.lastStatus = lastStatus;
	}

	public String getBeginDeclareDate() {
		return beginDeclareDate;
	}

	public void setBeginDeclareDate(String beginDeclareDate) {
		this.beginDeclareDate = beginDeclareDate;
	}

	public String getEndDeclareDate() {
		return endDeclareDate;
	}

	public void setEndDeclareDate(String endDeclareDate) {
		this.endDeclareDate = endDeclareDate;
	}

	public String getDeclareDateStr() {
		return declareDateStr;
	}

	public void setDeclareDateStr(String declareDateStr) {
		this.declareDateStr = declareDateStr;
	}

	public String getDeclareDate() {
		return declareDate;
	}

	public void setDeclareDate(String declareDate) {
		this.declareDate = declareDate;
	}

	public Double getTotalValueRmb() {
		return totalValueRmb;
	}

	public void setTotalValueRmb(Double totalValueRmb) {
		this.totalValueRmb = totalValueRmb;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}
}
