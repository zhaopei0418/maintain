package online.zhaopei.myproject.domain.ecssent;

import java.sql.Blob;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import online.zhaopei.myproject.domain.BaseDomain;
import online.zhaopei.myproject.jsonserialize.CustomJsonSerializer;

public class DxpReceMsg extends BaseDomain {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1920257819899696250L;
	
	private String msgGuid;
	
	private String encoding;
	
	private Integer msgSize;
	
	private byte[] msgBlob;
	
	private byte[] bizBlob;
	
	private String note;
	
	private Integer sysDays;
	
	private String beginSysDate;
	
	private String endSysDate;
	
	private String sysDateStr;
	
	private Date sysDate;

	public String getMsgGuid() {
		return msgGuid;
	}

	public void setMsgGuid(String msgGuid) {
		this.msgGuid = msgGuid;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public Integer getMsgSize() {
		return msgSize;
	}

	public void setMsgSize(Integer msgSize) {
		this.msgSize = msgSize;
	}

	@JsonSerialize(using = CustomJsonSerializer.ByteArraySerializer.class)
	public byte[] getMsgBlob() {
		return msgBlob;
	}

	public void setMsgBlob(byte[] msgBlob) {
		this.msgBlob = msgBlob;
	}

	@JsonSerialize(using = CustomJsonSerializer.ByteArraySerializer.class)
	public byte[] getBizBlob() {
		return bizBlob;
	}

	public void setBizBlob(byte[] bizBlob) {
		this.bizBlob = bizBlob;
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

	public Date getSysDate() {
		return sysDate;
	}

	public void setSysDate(Date sysDate) {
		this.sysDate = sysDate;
	}

}
