package online.zhaopei.myproject.sqlprovide.ecssent;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

public class UserUserSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1358708625072160473L;

	public String getAllUsers(String state) {
		
		return new SQL() {{
			this.SELECT("user_id, login_name, user_name");
			this.FROM("user_user");
			this.ORDER_BY("oper_time");
		}}.toString();
	}
}
