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

	private String value;
	
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
}
