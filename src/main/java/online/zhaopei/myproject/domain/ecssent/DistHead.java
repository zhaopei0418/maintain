package online.zhaopei.myproject.domain.ecssent;

import java.io.Serializable;
import java.util.Date;

public class DistHead implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7381174376703467288L;

	private String seqNo;
	
	private String distNo;
	
	private String customsCode;
	
	private String declCode;
	
	private String declName;
	
	private String distStat;
	
	private Date inputDate;
	
	private Date declDate;
	
	private String returnReason;
	
	private String note;

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
}
