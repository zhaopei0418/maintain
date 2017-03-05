package online.zhaopei.myproject.domain.ecssent;

import online.zhaopei.myproject.domain.BaseDomain;

public class Member extends BaseDomain {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3751073918050002548L;
	
	private String code;
	
	private String name;
	
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
