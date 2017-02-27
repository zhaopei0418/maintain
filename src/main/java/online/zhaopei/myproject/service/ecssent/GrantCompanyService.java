package online.zhaopei.myproject.service.ecssent;

import java.io.Serializable;

import online.zhaopei.myproject.domain.ecssent.GrantCompany;

public interface GrantCompanyService extends Serializable {

	GrantCompany getGrantCompanyByAuthToken(String authorizationToken);
}
