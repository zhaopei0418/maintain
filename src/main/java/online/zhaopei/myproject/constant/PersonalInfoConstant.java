package online.zhaopei.myproject.constant;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public enum PersonalInfoConstant implements Serializable {

	;
	
	private String value;
	
	private static Map<String, String> CHECK_FLAG_MAP = new HashMap<String, String>();
	
	static {
		CHECK_FLAG_MAP.put("", "所有");
		CHECK_FLAG_MAP.put("Y", "查验通过");
		CHECK_FLAG_MAP.put("N", "查验不通过");
	}
	
	private PersonalInfoConstant(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}

	public static Map<String, String> getCHECK_FLAG_MAP() {
		return CHECK_FLAG_MAP;
	}
}
