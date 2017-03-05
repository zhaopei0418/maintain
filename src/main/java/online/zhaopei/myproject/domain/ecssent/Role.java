package online.zhaopei.myproject.domain.ecssent;

import online.zhaopei.myproject.domain.BaseDomain;

public class Role extends BaseDomain {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2889662747313690508L;

	private String code;
	
	private String name;
	
	private String descript;

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

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}
}
