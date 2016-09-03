package online.zhaopei.myproject.sqlprovide.ecssent;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

import com.alibaba.druid.util.StringUtils;

import online.zhaopei.myproject.domain.ecssent.UserUser;

public class UserUserSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1358708625072160473L;

	public String getUsersSql(final UserUser user) {
		return new SQL() {{
			this.SELECT("user_id, login_name, user_name");
			this.FROM("user_user");
			this.WHERE("1 = 1");
			if (!StringUtils.isEmpty(user.getUserId())) {
				this.WHERE("user_id = '" + user.getUserId() + "'");
			}
			
			if (!StringUtils.isEmpty(user.getLoginName())) {
				this.WHERE("login_name like '%" + user.getLoginName() + "%'");
			}
			
			if (!StringUtils.isEmpty(user.getUserName())) {
				this.WHERE("user_name = '" + user.getUserName() + "'");
			}
			
			this.ORDER_BY("oper_time");
		}}.toString();
	}
	
	public String getUserByUserIdSql(final String userId) {
		return new SQL() {{
			this.SELECT("user_id, login_name, user_name");
			this.FROM("user_user");
			this.WHERE("user_id = '" + userId + "'");
		}}.toString();
	}
}
