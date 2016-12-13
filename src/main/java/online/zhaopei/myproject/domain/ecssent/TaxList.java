package online.zhaopei.myproject.domain.ecssent;

import java.util.Date;

import online.zhaopei.myproject.domain.BaseDomain;

public class TaxList extends BaseDomain {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3447605496668245768L;
	
	private String headGuid;
	
	private Integer gNum;
	
	private String gCode;
	
	private String gName;
	
	private Double qty;
	
	private Double price;
	
	private Double taxPrice;
	
	private Double customsTax;
	
	private Double valueAddedTax;
	
	private Double customsRate;
	
	private Double ConsumptionRate;
	
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

	public String getgCode() {
		return gCode;
	}

	public void setgCode(String gCode) {
		this.gCode = gCode;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public Double getQty() {
		return qty;
	}

	public void setQty(Double qty) {
		this.qty = qty;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTaxPrice() {
		return taxPrice;
	}

	public void setTaxPrice(Double taxPrice) {
		this.taxPrice = taxPrice;
	}

	public Double getCustomsTax() {
		return customsTax;
	}

	public void setCustomsTax(Double customsTax) {
		this.customsTax = customsTax;
	}

	public Double getValueAddedTax() {
		return valueAddedTax;
	}

	public void setValueAddedTax(Double valueAddedTax) {
		this.valueAddedTax = valueAddedTax;
	}

	public Double getCustomsRate() {
		return customsRate;
	}

	public void setCustomsRate(Double customsRate) {
		this.customsRate = customsRate;
	}

	public Double getConsumptionRate() {
		return ConsumptionRate;
	}

	public void setConsumptionRate(Double consumptionRate) {
		ConsumptionRate = consumptionRate;
	}

	public Date getSysDate() {
		return sysDate;
	}

	public void setSysDate(Date sysDate) {
		this.sysDate = sysDate;
	}

}
