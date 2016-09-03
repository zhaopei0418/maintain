package online.zhaopei.myproject.service.ecssent;

import java.io.Serializable;
import java.util.List;

import online.zhaopei.myproject.domain.ecssent.UserUser;

public interface UserUserService extends Serializable {

	List<UserUser> getUsers(UserUser user);
	
	UserUser getUserByUserId(String userId);
}
