package online.zhaopei.myproject.domain.ecssent;

import java.io.Serializable;

public class Para implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6856542086478273749L;

	private String code;

	private String name;

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
