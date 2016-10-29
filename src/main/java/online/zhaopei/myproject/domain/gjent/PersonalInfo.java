package online.zhaopei.myproject.domain.gjent;

import java.util.Date;

import online.zhaopei.myproject.domain.BaseDomain;

public class PersonalInfo extends BaseDomain {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8341912837423289472L;

	private String uuid;
	
	private String perName;
	
	private String certId;
	
	private String status;
	
	private String perPhone;
	
	private Date sysDate;
	
	private String authWay;
	
	private String authCop;
	
	private String checkFlag;
	
	private String checkMark;
	
	private String jyOrderNo;
	
	private String isCheck;
	
	private String billMode;
	
	private String errorCode;
	
	private String errorResult;
	
	private Integer errorCount;
	
	private String ciqStatus;
	
	private String chkMark;
	
	private Date noticeDate;
	
	private String ebpCode;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getPerName() {
		return perName;
	}

	public void setPerName(String perName) {
		this.perName = perName;
	}

	public String getCertId() {
		return certId;
	}

	public void setCertId(String certId) {
		this.certId = certId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPerPhone() {
		return perPhone;
	}

	public void setPerPhone(String perPhone) {
		this.perPhone = perPhone;
	}

	public Date getSysDate() {
		return sysDate;
	}

	public void setSysDate(Date sysDate) {
		this.sysDate = sysDate;
	}

	public String getAuthWay() {
		return authWay;
	}

	public void setAuthWay(String authWay) {
		this.authWay = authWay;
	}

	public String getAuthCop() {
		return authCop;
	}

	public void setAuthCop(String authCop) {
		this.authCop = authCop;
	}

	public String getCheckFlag() {
		return checkFlag;
	}

	public void setCheckFlag(String checkFlag) {
		this.checkFlag = checkFlag;
	}

	public String getCheckMark() {
		return checkMark;
	}

	public void setCheckMark(String checkMark) {
		this.checkMark = checkMark;
	}

	public String getJyOrderNo() {
		return jyOrderNo;
	}

	public void setJyOrderNo(String jyOrderNo) {
		this.jyOrderNo = jyOrderNo;
	}

	public String getIsCheck() {
		return isCheck;
	}

	public void setIsCheck(String isCheck) {
		this.isCheck = isCheck;
	}

	public String getBillMode() {
		return billMode;
	}

	public void setBillMode(String billMode) {
		this.billMode = billMode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorResult() {
		return errorResult;
	}

	public void setErrorResult(String errorResult) {
		this.errorResult = errorResult;
	}

	public Integer getErrorCount() {
		return errorCount;
	}

	public void setErrorCount(Integer errorCount) {
		this.errorCount = errorCount;
	}

	public String getCiqStatus() {
		return ciqStatus;
	}

	public void setCiqStatus(String ciqStatus) {
		this.ciqStatus = ciqStatus;
	}

	public String getChkMark() {
		return chkMark;
	}

	public void setChkMark(String chkMark) {
		this.chkMark = chkMark;
	}

	public Date getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}

	public String getEbpCode() {
		return ebpCode;
	}

	public void setEbpCode(String ebpCode) {
		this.ebpCode = ebpCode;
	}
}
