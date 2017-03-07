package online.zhaopei.myproject.domain.ecssent;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import online.zhaopei.myproject.domain.BaseDomain;

public class Version extends BaseDomain {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4674105710127005165L;

	private String code;
	
	private String name;
	
	private String versionNo;
	
	private String baseSystem;
	
	private String description;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date sendTime;
	
	private String beginSendTime;
	
	private String endSendTime;
	
	private String sendTimeStr;
	
	private String isUpdateTest;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTestTime;
	
	private String beginUpdateTestTime;
	
	private String endUpdateTestTime;
	
	private String updateTestTimeStr;
	
	private String isUpdateFormal;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateFormalTime;
	
	private String beginUpdateFormalTime;
	
	private String endUpdateFormalTime;
	
	private String updateFormalTimeStr;
	
	private String testResult;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date testTime;
	
	private String beginTestTime;
	
	private String endTestTime;
	
	private String testTimeStr;
	
	private String testResultDescription;
	
	private String isPatch;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}

	public String getBaseSystem() {
		return baseSystem;
	}

	public void setBaseSystem(String baseSystem) {
		this.baseSystem = baseSystem;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public String getIsUpdateTest() {
		return isUpdateTest;
	}

	public void setIsUpdateTest(String isUpdateTest) {
		this.isUpdateTest = isUpdateTest;
	}

	public Date getUpdateTestTime() {
		return updateTestTime;
	}

	public void setUpdateTestTime(Date updateTestTime) {
		this.updateTestTime = updateTestTime;
	}

	public String getIsUpdateFormal() {
		return isUpdateFormal;
	}

	public void setIsUpdateFormal(String isUpdateFormal) {
		this.isUpdateFormal = isUpdateFormal;
	}

	public Date getUpdateFormalTime() {
		return updateFormalTime;
	}

	public void setUpdateFormalTime(Date updateFormalTime) {
		this.updateFormalTime = updateFormalTime;
	}

	public String getTestResult() {
		return testResult;
	}

	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}

	public Date getTestTime() {
		return testTime;
	}

	public void setTestTime(Date testTime) {
		this.testTime = testTime;
	}

	public String getTestResultDescription() {
		return testResultDescription;
	}

	public void setTestResultDescription(String testResultDescription) {
		this.testResultDescription = testResultDescription;
	}

	public String getIsPatch() {
		return isPatch;
	}

	public void setIsPatch(String isPatch) {
		this.isPatch = isPatch;
	}

	public String getBeginSendTime() {
		return beginSendTime;
	}

	public void setBeginSendTime(String beginSendTime) {
		this.beginSendTime = beginSendTime;
	}

	public String getEndSendTime() {
		return endSendTime;
	}

	public void setEndSendTime(String endSendTime) {
		this.endSendTime = endSendTime;
	}

	public String getSendTimeStr() {
		return sendTimeStr;
	}

	public void setSendTimeStr(String sendTimeStr) {
		this.sendTimeStr = sendTimeStr;
	}

	public String getBeginUpdateTestTime() {
		return beginUpdateTestTime;
	}

	public void setBeginUpdateTestTime(String beginUpdateTestTime) {
		this.beginUpdateTestTime = beginUpdateTestTime;
	}

	public String getEndUpdateTestTime() {
		return endUpdateTestTime;
	}

	public void setEndUpdateTestTime(String endUpdateTestTime) {
		this.endUpdateTestTime = endUpdateTestTime;
	}

	public String getUpdateTestTimeStr() {
		return updateTestTimeStr;
	}

	public void setUpdateTestTimeStr(String updateTestTimeStr) {
		this.updateTestTimeStr = updateTestTimeStr;
	}

	public String getBeginUpdateFormalTime() {
		return beginUpdateFormalTime;
	}

	public void setBeginUpdateFormalTime(String beginUpdateFormalTime) {
		this.beginUpdateFormalTime = beginUpdateFormalTime;
	}

	public String getEndUpdateFormalTime() {
		return endUpdateFormalTime;
	}

	public void setEndUpdateFormalTime(String endUpdateFormalTime) {
		this.endUpdateFormalTime = endUpdateFormalTime;
	}

	public String getUpdateFormalTimeStr() {
		return updateFormalTimeStr;
	}

	public void setUpdateFormalTimeStr(String updateFormalTimeStr) {
		this.updateFormalTimeStr = updateFormalTimeStr;
	}

	public String getBeginTestTime() {
		return beginTestTime;
	}

	public void setBeginTestTime(String beginTestTime) {
		this.beginTestTime = beginTestTime;
	}

	public String getEndTestTime() {
		return endTestTime;
	}

	public void setEndTestTime(String endTestTime) {
		this.endTestTime = endTestTime;
	}

	public String getTestTimeStr() {
		return testTimeStr;
	}

	public void setTestTimeStr(String testTimeStr) {
		this.testTimeStr = testTimeStr;
	}
}
