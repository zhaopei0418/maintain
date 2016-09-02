package online.zhaopei.myproject.service.ecssent.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.ecssent.UserUser;
import online.zhaopei.myproject.mapper.ecssent.UserUserMapper;
import online.zhaopei.myproject.service.ecssent.UserUserService;

@Service
public class UserUserServiceImpl implements UserUserService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8068102828664629884L;
	
	@Autowired
	private UserUserMapper userUserMapper;
	
	@Override
	public List<UserUser> getAllUsers() {
		return this.userUserMapper.getAllUsers();
	}

}
