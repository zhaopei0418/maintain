package online.zhaopei.myproject.service.ecssent.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.ecssent.GrantCompany;
import online.zhaopei.myproject.mapper.ecssent.GrantCompanyMapper;
import online.zhaopei.myproject.service.ecssent.GrantCompanyService;

@Service
public class GrantCompanyServiceImpl implements GrantCompanyService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 9123711441986366303L;

	@Autowired
	private GrantCompanyMapper grantCompanyMapper;
	
	@Override
	public GrantCompany getGrantCompanyByAuthToken(String authorizationToken) {
		return this.grantCompanyMapper.getGrantCompanyByAuthToken(authorizationToken);
	}

}
