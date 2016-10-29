package online.zhaopei.myproject.domain.ecssent;

import java.util.Date;

import online.zhaopei.myproject.domain.BaseDomain;

public class OrderList extends BaseDomain {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7266843091194223955L;

	private String headGuid;
	
	private Integer gNum;
	
	private String itemNo;
	
	private String itemName;
	
	private String itemDescribe;
	
	private String barCode;
	
	private String unit;
	
	private Integer qty;
	
	private Double price;
	
	private Double totalPrice;
	
	private String currency;
	
	private String country;
	
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

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescribe() {
		return itemDescribe;
	}

	public void setItemDescribe(String itemDescribe) {
		this.itemDescribe = itemDescribe;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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
