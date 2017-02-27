package online.zhaopei.myproject.domain.ecssent;

import online.zhaopei.myproject.domain.BaseDomain;

public class GrantCompany extends BaseDomain {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3994999598592520070L;

	private String authorizationToken;
	
	private String companyCode;

	public String getAuthorizationToken() {
		return authorizationToken;
	}

	public void setAuthorizationToken(String authorizationToken) {
		this.authorizationToken = authorizationToken;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
}
