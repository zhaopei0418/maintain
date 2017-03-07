package online.zhaopei.myproject.constant;

import java.util.HashMap;
import java.util.Map;

public enum VersionConstant {

	BASE_SYSTEM_001("001"),
	BASE_SYSTEM_001_DESC("企业WEB服务平台"),
	BASE_SYSTEM_002("002"),
	BASE_SYSTEM_002_DESC("企业DXP报文处理"),
	BASE_SYSTEM_003("003"),
	BASE_SYSTEM_003_DESC("企业光机服务"),
	BASE_SYSTEM_004("004"),
	BASE_SYSTEM_004_DESC("海关服务平台"),
	BASE_SYSTEM_005("005"),
	BASE_SYSTEM_005_DESC("海关物流监控"),
	;
	
	private static Map<String, String> BASE_SYSTEM_MAP = new HashMap<String, String>();
	
	private String value;
	
	static {
		BASE_SYSTEM_MAP.put("", "所有");
		BASE_SYSTEM_MAP.put(BASE_SYSTEM_001.toString(), BASE_SYSTEM_001_DESC.toString());
		BASE_SYSTEM_MAP.put(BASE_SYSTEM_002.toString(), BASE_SYSTEM_002_DESC.toString());
		BASE_SYSTEM_MAP.put(BASE_SYSTEM_003.toString(), BASE_SYSTEM_003_DESC.toString());
		BASE_SYSTEM_MAP.put(BASE_SYSTEM_004.toString(), BASE_SYSTEM_004_DESC.toString());
		BASE_SYSTEM_MAP.put(BASE_SYSTEM_005.toString(), BASE_SYSTEM_005_DESC.toString());
	}
	
	private VersionConstant(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}

	public static Map<String, String> getBASE_SYSTEM_MAP() {
		return BASE_SYSTEM_MAP;
	}
	
}
