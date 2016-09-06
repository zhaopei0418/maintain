package online.zhaopei.myproject.domain.ecssent;

import java.sql.Time;


import online.zhaopei.myproject.domain.BaseDomain;

public class PubRtn extends BaseDomain {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3797751324015784543L;

	private String msgGuid;
	
	private String bizType;
	
	private String bizGuid;
	
	private String preNo;
	
	private String h2kNo;
	
	private String appStatus;
	
	private String rtnStatus;
	
	private Time rtnTime;
	
	private String rtnInfo;
	
	private String note;
	
	private Integer sysDays;
	
	private Time sysDate;

	public String getMsgGuid() {
		return msgGuid;
	}

	public void setMsgGuid(String msgGuid) {
		this.msgGuid = msgGuid;
	}

	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public String getBizGuid() {
		return bizGuid;
	}

	public void setBizGuid(String bizGuid) {
		this.bizGuid = bizGuid;
	}

	public String getPreNo() {
		return preNo;
	}

	public void setPreNo(String preNo) {
		this.preNo = preNo;
	}

	public String getH2kNo() {
		return h2kNo;
	}

	public void setH2kNo(String h2kNo) {
		this.h2kNo = h2kNo;
	}

	public String getAppStatus() {
		return appStatus;
	}

	public void setAppStatus(String appStatus) {
		this.appStatus = appStatus;
	}

	public String getRtnStatus() {
		return rtnStatus;
	}

	public void setRtnStatus(String rtnStatus) {
		this.rtnStatus = rtnStatus;
	}

	public Time getRtnTime() {
		return rtnTime;
	}

	public void setRtnTime(Time rtnTime) {
		this.rtnTime = rtnTime;
	}

	public String getRtnInfo() {
		return rtnInfo;
	}

	public void setRtnInfo(String rtnInfo) {
		this.rtnInfo = rtnInfo;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getSysDays() {
		return sysDays;
	}

	public void setSysDays(Integer sysDays) {
		this.sysDays = sysDays;
	}

	public Time getSysDate() {
		return sysDate;
	}

	public void setSysDate(Time sysDate) {
		this.sysDate = sysDate;
	}
}
