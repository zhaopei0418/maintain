package online.zhaopei.myproject.domain.gjent;

import java.io.Serializable;
import java.util.Date;

public class ImpInvtHead implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5329864020631124000L;

	private String guid;
	
	private String detailsCode;
	
	private String invtNo;
	
	private String preNo;
	
	private String applyCode;
	
	private String auditState;
	
	private String bwName;
	
	private Date applyDate;
	
	private String payCode;
	
	private String payName;

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getPreNo() {
		return preNo;
	}

	public void setPreNo(String preNo) {
		this.preNo = preNo;
	}

	public String getApplyCode() {
		return applyCode;
	}

	public void setApplyCode(String applyCode) {
		this.applyCode = applyCode;
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

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
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

	public String getDetailsCode() {
		return detailsCode;
	}

	public void setDetailsCode(String detailsCode) {
		this.detailsCode = detailsCode;
	}

	public String getInvtNo() {
		return invtNo;
	}

	public void setInvtNo(String invtNo) {
		this.invtNo = invtNo;
	}
}
