package online.zhaopei.myproject.domain.ecssent;

import online.zhaopei.myproject.domain.BaseDomain;

public class Member extends BaseDomain {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3751073918050002548L;
	
	private String memberName;
	
	private String password;

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
