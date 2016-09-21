package online.zhaopei.myproject.domain.ecssent;

import online.zhaopei.myproject.domain.BaseDomain;

public class InvtHeadStatistics extends BaseDomain {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4110525544870289056L;

	private String name;
	
	private String nameTwo;
	
	private Integer quantity;
	
	private Double goodsValue;
	
	private String beginSysDate;
	
	private String endSysDate;
	
	private String groupField;
	
	private String groupFieldTwo;
	
	private String appStatus;
	
	private String distStatus;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameTwo() {
		return nameTwo;
	}

	public void setNameTwo(String nameTwo) {
		this.nameTwo = nameTwo;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getGoodsValue() {
		return goodsValue;
	}

	public void setGoodsValue(Double goodsValue) {
		this.goodsValue = goodsValue;
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

	public String getGroupField() {
		return groupField;
	}

	public void setGroupField(String groupField) {
		this.groupField = groupField;
	}

	public String getGroupFieldTwo() {
		return groupFieldTwo;
	}

	public void setGroupFieldTwo(String groupFieldTwo) {
		this.groupFieldTwo = groupFieldTwo;
	}

	public String getAppStatus() {
		return appStatus;
	}

	public void setAppStatus(String appStatus) {
		this.appStatus = appStatus;
	}

	public String getDistStatus() {
		return distStatus;
	}

	public void setDistStatus(String distStatus) {
		this.distStatus = distStatus;
	}
}
