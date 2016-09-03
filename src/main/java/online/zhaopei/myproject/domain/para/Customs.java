package online.zhaopei.myproject.domain.para;

import online.zhaopei.myproject.domain.BaseDomain;

public class Customs extends BaseDomain {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6848772302375684153L;

	private String customsCode;
	
	private String customsName;
	
	private String AbbrCust;

	public String getCustomsCode() {
		return customsCode;
	}

	public void setCustomsCode(String customsCode) {
		this.customsCode = customsCode;
	}

	public String getCustomsName() {
		return customsName;
	}

	public void setCustomsName(String customsName) {
		this.customsName = customsName;
	}

	public String getAbbrCust() {
		return AbbrCust;
	}

	public void setAbbrCust(String abbrCust) {
		AbbrCust = abbrCust;
	}
}
