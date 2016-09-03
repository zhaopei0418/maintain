package online.zhaopei.myproject.constant;

import java.io.Serializable;

public enum CommonConstant implements Serializable {

	DEFAULT_PAGE_ZIZE("10")
	
	;
	
	private String value;
	
	private CommonConstant(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
}
