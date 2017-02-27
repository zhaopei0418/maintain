package online.zhaopei.myproject.mapper.ecssent;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import online.zhaopei.myproject.domain.ecssent.GrantCompany;
import online.zhaopei.myproject.sqlprovide.ecssent.GrantCompanySqlProvide;

public interface GrantCompanyMapper {

	@Results(id = "resultGrantCompany", value = {
		@Result(property = "authorizationToken", column = "authorization_token", id = true),
		@Result(property = "companyCode", column = "company_code")
	})
	@SelectProvider(type = GrantCompanySqlProvide.class, method = "getGrantCompanyByAuthTokenSql")
	GrantCompany getGrantCompanyByAuthToken(String authorizationToken);
}
