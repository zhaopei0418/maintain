package online.zhaopei.myproject.domain.ecssent;

import java.util.Date;

import online.zhaopei.myproject.domain.BaseDomain;

public class DeliveryList extends BaseDomain {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7507362713685081075L;

	private String headGuid;
	
	private Integer gNum;
	
	private String logisticsNo;
	
	private String note;
	
	private Date sysDate;

	public String getHeadGuid() {
		return headGuid;
	}

	public void setHeadGuid(String headGuid) {
		this.headGuid = headGuid;
	}

	public Integer getgNum() {
		return gNum;
	}

	public void setgNum(Integer gNum) {
		this.gNum = gNum;
	}

	public String getLogisticsNo() {
		return logisticsNo;
	}

	public void setLogisticsNo(String logisticsNo) {
		this.logisticsNo = logisticsNo;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getSysDate() {
		return sysDate;
	}

	public void setSysDate(Date sysDate) {
		this.sysDate = sysDate;
	}
}
