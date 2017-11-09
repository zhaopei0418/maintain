package online.zhaopei.myproject.mapper.ecssent;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.*;

import online.zhaopei.myproject.domain.ecssent.UserUser;
import online.zhaopei.myproject.sqlprovide.ecssent.UserUserSqlProvide;

public interface UserUserMapper extends Serializable {

	@Results(id = "userUserResult", value = {
		@Result(property = "userId", column = "user_id", id = true),
		@Result(property = "loginName", column = "login_name"),
		@Result(property = "userName", column = "user_name")
	})
	@SelectProvider(type = UserUserSqlProvide.class, method = "getUsersSql")
	List<UserUser> getUsers(UserUser user);
	
	@ResultMap(value = "userUserResult")
	@SelectProvider(type = UserUserSqlProvide.class, method = "getUserByUserIdSql")
	UserUser getUserByUserId(String userId);

	@SelectProvider(type = UserUserSqlProvide.class, method =  "countUserByLoginNameAndPasswordSql")
	@ResultType(Integer.class)
	Integer countUserByLoginNameAndPassword(String loginName, String password);
}
