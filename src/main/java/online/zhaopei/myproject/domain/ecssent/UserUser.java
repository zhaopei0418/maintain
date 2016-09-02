package online.zhaopei.myproject.domain.ecssent;

import java.io.Serializable;

public class UserUser implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7717287477996129429L;

	private String userId;
	
	private String loginName;
	
	private String userName;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
