package online.zhaopei.myproject.constant;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public enum CommonConstant implements Serializable {

	DEFAULT_PAGE_ZIZE("10")

	;

	private static Map<String, String> COUNTRY_MAP = new HashMap<String, String>();

	private static Map<String, String> CURRENCY_MAP = new HashMap<String, String>();

	private static Map<String, String> UNIT_MAP = new HashMap<String, String>();

	private static Map<String, String> CUSTOMS_MAP = new HashMap<String, String>();

	private static Map<String, String> WRAP_TYPE_MAP = new HashMap<String, String>();

	private static Map<String, String> TRAF_MODE_MAP = new HashMap<String, String>();

	private static Map<String, String> TRADE_MODE_MAP = new HashMap<String, String>();

	private static Map<String, String> TRAF_NO_MAP = new HashMap<String, String>();

	private static Map<String, String> ID_TYPE_MAP = new HashMap<String, String>();

	private static Map<String, String> APP_TYPE_MAP = new HashMap<String, String>();

	private String value;

	static {
		ID_TYPE_MAP.put("", "所有");
		ID_TYPE_MAP.put("1", "身份证");
		ID_TYPE_MAP.put("2", "军官证");
		ID_TYPE_MAP.put("3", "护照");
		ID_TYPE_MAP.put("4", "其他");

		APP_TYPE_MAP.put("", "所有");
		APP_TYPE_MAP.put("1", "新增");
		APP_TYPE_MAP.put("2", "变更");
		APP_TYPE_MAP.put("3", "删除");
		
		CUSTOMS_MAP.put("", "所有关区");
		CUSTOMS_MAP.put("4604", "郑州机办");
		CUSTOMS_MAP.put("4605", "郑州邮办");
		CUSTOMS_MAP.put("4606", "郑铁东办");
		CUSTOMS_MAP.put("4612", "新郑综保");
		CUSTOMS_MAP.put("4619", "河南德众");
		CUSTOMS_MAP.put("4620", "口岸作业区");
	}

	private CommonConstant(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}

	public static Map<String, String> getCOUNTRY_MAP() {
		return COUNTRY_MAP;
	}

	public static Map<String, String> getCURRENCY_MAP() {
		return CURRENCY_MAP;
	}

	public static Map<String, String> getUNIT_MAP() {
		return UNIT_MAP;
	}

	public static Map<String, String> getCUSTOMS_MAP() {
		return CUSTOMS_MAP;
	}

	public static Map<String, String> getWRAP_TYPE_MAP() {
		return WRAP_TYPE_MAP;
	}

	public static Map<String, String> getTRAF_MODE_MAP() {
		return TRAF_MODE_MAP;
	}

	public static Map<String, String> getTRADE_MODE_MAP() {
		return TRADE_MODE_MAP;
	}

	public static Map<String, String> getTRAF_NO_MAP() {
		return TRAF_NO_MAP;
	}

	public static Map<String, String> getAPP_TYPE_MAP() {
		return APP_TYPE_MAP;
	}

	public static Map<String, String> getID_TYPE_MAP() {
		return ID_TYPE_MAP;
	}
}
