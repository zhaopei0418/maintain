package online.zhaopei.myproject.domain.ecssent;

import online.zhaopei.myproject.domain.BaseDomain;

public class Permission extends BaseDomain {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1698706734422210205L;

	private String code;
	
	private String name;
	
	private String descript;
	
	private String url;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
