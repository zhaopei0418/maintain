package online.zhaopei.myproject.domain.ecssent;

import online.zhaopei.myproject.domain.BaseDomain;

public class InvtDeliveryComparison extends BaseDomain {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7562709963950329434L;

	private String deliveryHeadGuid;
	
	private String invtHeadGuid;
	
	private String deliveryVoyageNo;
	
	private String invtVoyageNo;
	
	private String deliveryBillNo;
	
	private String invtBillNo;
	
	private String deliveryTrafMode;
	
	private String invtTrafMode;
	
	private String deliveryTrafNo;
	
	private String invtTrafNo;
	
	private String logisticsCode;
	
	private String logisticsNo;
	
	private String copNo;

	public String getDeliveryHeadGuid() {
		return deliveryHeadGuid;
	}

	public void setDeliveryHeadGuid(String deliveryHeadGuid) {
		this.deliveryHeadGuid = deliveryHeadGuid;
	}

	public String getInvtHeadGuid() {
		return invtHeadGuid;
	}

	public void setInvtHeadGuid(String invtHeadGuid) {
		this.invtHeadGuid = invtHeadGuid;
	}

	public String getDeliveryVoyageNo() {
		return deliveryVoyageNo;
	}

	public void setDeliveryVoyageNo(String deliveryVoyageNo) {
		this.deliveryVoyageNo = deliveryVoyageNo;
	}

	public String getInvtVoyageNo() {
		return invtVoyageNo;
	}

	public void setInvtVoyageNo(String invtVoyageNo) {
		this.invtVoyageNo = invtVoyageNo;
	}

	public String getDeliveryBillNo() {
		return deliveryBillNo;
	}

	public void setDeliveryBillNo(String deliveryBillNo) {
		this.deliveryBillNo = deliveryBillNo;
	}

	public String getInvtBillNo() {
		return invtBillNo;
	}

	public void setInvtBillNo(String invtBillNo) {
		this.invtBillNo = invtBillNo;
	}

	public String getDeliveryTrafMode() {
		return deliveryTrafMode;
	}

	public void setDeliveryTrafMode(String deliveryTrafMode) {
		this.deliveryTrafMode = deliveryTrafMode;
	}

	public String getInvtTrafMode() {
		return invtTrafMode;
	}

	public void setInvtTrafMode(String invtTrafMode) {
		this.invtTrafMode = invtTrafMode;
	}

	public String getDeliveryTrafNo() {
		return deliveryTrafNo;
	}

	public void setDeliveryTrafNo(String deliveryTrafNo) {
		this.deliveryTrafNo = deliveryTrafNo;
	}

	public String getInvtTrafNo() {
		return invtTrafNo;
	}

	public void setInvtTrafNo(String invtTrafNo) {
		this.invtTrafNo = invtTrafNo;
	}

	public String getLogisticsCode() {
		return logisticsCode;
	}

	public void setLogisticsCode(String logisticsCode) {
		this.logisticsCode = logisticsCode;
	}

	public String getLogisticsNo() {
		return logisticsNo;
	}

	public void setLogisticsNo(String logisticsNo) {
		this.logisticsNo = logisticsNo;
	}

	public String getCopNo() {
		return copNo;
	}

	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}
}
