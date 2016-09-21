package online.zhaopei.myproject.constant;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public enum InvtHeadConstant implements Serializable {

	APP_STATUS_1("1"),
	APP_STATUS_1_DESC("电子口岸已暂存"),
	APP_STATUS_2("2"),
	APP_STATUS_2_DESC("电子口岸申报中"),
	APP_STATUS_3("3"),
	APP_STATUS_3_DESC("发送海关成功"),
	APP_STATUS_4("4"),
	APP_STATUS_4_DESC("发送海关失败"),
	APP_STATUS_01("01"),
	APP_STATUS_01_DESC("暂存"),
	APP_STATUS_02("02"),
	APP_STATUS_02_DESC("申报中"),
	APP_STATUS_03("03"),
	APP_STATUS_03_DESC("发送电子口岸成功"),
	APP_STATUS_04("04"),
	APP_STATUS_04_DESC("发送电子口岸失败"),
	APP_STATUS_05("05"),
	APP_STATUS_05_DESC("电子口岸校验失败"),
	APP_STATUS_100("100"),
	APP_STATUS_100_DESC("海关退单"),
	APP_STATUS_120("120"),
	APP_STATUS_120_DESC("海关入库"),
	APP_STATUS_300("300"),
	APP_STATUS_300_DESC("人工审核"),
	APP_STATUS_399("399"),
	APP_STATUS_399_DESC("海关审结"),
	APP_STATUS_500("500"),
	APP_STATUS_500_DESC("查验"),
	APP_STATUS_501("501"),
	APP_STATUS_501_DESC("扣留移送通关"),
	APP_STATUS_502("502"),
	APP_STATUS_502_DESC("扣留移送辑私"),
	APP_STATUS_503("503"),
	APP_STATUS_503_DESC("扣留移送法规"),
	APP_STATUS_599("599"),
	APP_STATUS_599_DESC("其它扣留"),
	APP_STATUS_700("700"),
	APP_STATUS_700_DESC("退运"),
	APP_STATUS_800("800"),
	APP_STATUS_800_DESC("放行"),
	APP_STATUS_899("899"),
	APP_STATUS_899_DESC("结关"),
	APP_STATUS_621003("-621003"),
	APP_STATUS_621003_DESC("清单申报失败"),
	APP_STATUS_621999("-621999"),
	APP_STATUS_621999_DESC("异常"),
	APP_STATUS_621001("-621001"),
	APP_STATUS_621001_DESC("清单校验失败"),
	
	AUDIT_STATE_1("1"),
	AUDIT_STATE_1_DESC("放行"),
	AUDIT_STATE_11("11"),
	AUDIT_STATE_11_DESC("重新申报"),
	
	DIST_STATUS_1("1"),
	DIST_STATUS_1_DESC("未绑核放单"),
	DIST_STATUS_2("2"),
	DIST_STATUS_2_DESC("已绑核放单"),
	DIST_STATUS_5("5"),
	DIST_STATUS_5_DESC("滞留"),
	DIST_STATUS_6("6"),
	DIST_STATUS_6_DESC("放行"),
	DIST_STATUS_8("8"),
	DIST_STATUS_8_DESC("核放单结案"),
	
	;
	
	private static Map<String, String> APP_STATUS_MAP = new HashMap<String, String>();
	
	private static Map<String, String> DIST_STATUS_MAP = new HashMap<String, String>();
	
	private static Map<String, String> AUDIT_STATE_MAP = new HashMap<String, String>();
	
	static {
		APP_STATUS_MAP.put("", "所有状态");
		APP_STATUS_MAP.put(APP_STATUS_01.value, APP_STATUS_01_DESC.value);
		APP_STATUS_MAP.put(APP_STATUS_02.value, APP_STATUS_02_DESC.value);
		APP_STATUS_MAP.put(APP_STATUS_03.value, APP_STATUS_03_DESC.value);
		APP_STATUS_MAP.put(APP_STATUS_04.value, APP_STATUS_04_DESC.value);
		APP_STATUS_MAP.put(APP_STATUS_05.value, APP_STATUS_05_DESC.value);
		APP_STATUS_MAP.put(APP_STATUS_1.value, APP_STATUS_1_DESC.value);
		APP_STATUS_MAP.put(APP_STATUS_2.value, APP_STATUS_2_DESC.value);
		APP_STATUS_MAP.put(APP_STATUS_3.value, APP_STATUS_3_DESC.value);
		APP_STATUS_MAP.put(APP_STATUS_4.value, APP_STATUS_4_DESC.value);
		APP_STATUS_MAP.put(APP_STATUS_100.value, APP_STATUS_100_DESC.value);
		APP_STATUS_MAP.put(APP_STATUS_120.value, APP_STATUS_120_DESC.value);
		APP_STATUS_MAP.put(APP_STATUS_300.value, APP_STATUS_300_DESC.value);
		APP_STATUS_MAP.put(APP_STATUS_399.value, APP_STATUS_399_DESC.value);
		APP_STATUS_MAP.put(APP_STATUS_500.value, APP_STATUS_500_DESC.value);
		APP_STATUS_MAP.put(APP_STATUS_501.value, APP_STATUS_501_DESC.value);
		APP_STATUS_MAP.put(APP_STATUS_502.value, APP_STATUS_502_DESC.value);
		APP_STATUS_MAP.put(APP_STATUS_503.value, APP_STATUS_503_DESC.value);
		APP_STATUS_MAP.put(APP_STATUS_599.value, APP_STATUS_599_DESC.value);
		APP_STATUS_MAP.put(APP_STATUS_700.value, APP_STATUS_700_DESC.value);
		APP_STATUS_MAP.put(APP_STATUS_800.value, APP_STATUS_800_DESC.value);
		APP_STATUS_MAP.put(APP_STATUS_899.value, APP_STATUS_899_DESC.value);
		APP_STATUS_MAP.put(APP_STATUS_621003.value, APP_STATUS_621003_DESC.value);
		APP_STATUS_MAP.put(APP_STATUS_621999.value, APP_STATUS_621999_DESC.value);
		APP_STATUS_MAP.put(APP_STATUS_621001.value, APP_STATUS_621001_DESC.value);
		
		DIST_STATUS_MAP.put("", "所有状态");
		DIST_STATUS_MAP.put(DIST_STATUS_1.value, DIST_STATUS_1_DESC.value);
		DIST_STATUS_MAP.put(DIST_STATUS_2.value, DIST_STATUS_2_DESC.value);
		DIST_STATUS_MAP.put(DIST_STATUS_5.value, DIST_STATUS_5_DESC.value);
		DIST_STATUS_MAP.put(DIST_STATUS_6.value, DIST_STATUS_6_DESC.value);
		DIST_STATUS_MAP.put(DIST_STATUS_8.value, DIST_STATUS_8_DESC.value);
		
		AUDIT_STATE_MAP.put("", "所有状态");
		AUDIT_STATE_MAP.put(AUDIT_STATE_1.value, AUDIT_STATE_1_DESC.value);
		AUDIT_STATE_MAP.put(AUDIT_STATE_11.value, AUDIT_STATE_11_DESC.value);
	}
	
	private String value;
	
	private InvtHeadConstant(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}

	public static Map<String, String> getAPP_STATUS_MAP() {
		return APP_STATUS_MAP;
	}

	public static Map<String, String> getDIST_STATUS_MAP() {
		return DIST_STATUS_MAP;
	}

	public static Map<String, String> getAUDIT_STATE_MAP() {
		return AUDIT_STATE_MAP;
	}
	
}
