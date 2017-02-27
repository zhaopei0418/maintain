package online.zhaopei.myproject.sqlprovide.ecssent;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

import online.zhaopei.myproject.common.tool.OracleTool;

public class GrantCompanySqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4842250904121470118L;

	public String getGrantCompanyByAuthTokenSql(final String authorizationToken) {
		return new SQL() {{
			this.SELECT("authorization_token");
			this.SELECT("company_code");
			this.FROM("grant_company");
			
			OracleTool.where(this, "authorization_token", authorizationToken);
		}}.toString();
	}
}
