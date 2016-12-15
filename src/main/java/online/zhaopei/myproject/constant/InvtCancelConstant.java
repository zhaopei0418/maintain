package online.zhaopei.myproject.constant;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public enum InvtCancelConstant implements Serializable {

	APP_STATUS_623005("-623005"),
	APP_STATUS_623005_DESC("清单状态不符"),
	APP_STATUS_623003("-623003"),
	APP_STATUS_623003_DESC("清单号不存在"),
	APP_STATUS_623999("-623999"),
	APP_STATUS_623999_DESC("撤销单已存在"),
	
	;
	
	private String value;
	
	private static Map<String, String> APP_STATUS_MAP = new HashMap<String, String>();
	
	static {
		APP_STATUS_MAP.put("", "所有状态");
		APP_STATUS_MAP.put(InvtHeadConstant.APP_STATUS_01.toString(), InvtHeadConstant.APP_STATUS_01_DESC.toString());
		APP_STATUS_MAP.put(InvtHeadConstant.APP_STATUS_02.toString(), InvtHeadConstant.APP_STATUS_02_DESC.toString());
		APP_STATUS_MAP.put(InvtHeadConstant.APP_STATUS_03.toString(), InvtHeadConstant.APP_STATUS_03_DESC.toString());
		APP_STATUS_MAP.put(InvtHeadConstant.APP_STATUS_04.toString(), InvtHeadConstant.APP_STATUS_04_DESC.toString());
		APP_STATUS_MAP.put(InvtHeadConstant.APP_STATUS_05.toString(), InvtHeadConstant.APP_STATUS_05_DESC.toString());
		APP_STATUS_MAP.put(InvtHeadConstant.APP_STATUS_1.toString(), InvtHeadConstant.APP_STATUS_1_DESC.toString());
		APP_STATUS_MAP.put(InvtHeadConstant.APP_STATUS_2.toString(), InvtHeadConstant.APP_STATUS_2_DESC.toString());
		APP_STATUS_MAP.put(InvtHeadConstant.APP_STATUS_3.toString(), InvtHeadConstant.APP_STATUS_3_DESC.toString());
		APP_STATUS_MAP.put(InvtHeadConstant.APP_STATUS_4.toString(), InvtHeadConstant.APP_STATUS_4_DESC.toString());
		APP_STATUS_MAP.put(InvtHeadConstant.APP_STATUS_100.toString(), InvtHeadConstant.APP_STATUS_100_DESC.toString());
		APP_STATUS_MAP.put(InvtHeadConstant.APP_STATUS_120.toString(), InvtHeadConstant.APP_STATUS_120_DESC.toString());
		APP_STATUS_MAP.put(InvtHeadConstant.APP_STATUS_300.toString(), InvtHeadConstant.APP_STATUS_300_DESC.toString());
		APP_STATUS_MAP.put(InvtHeadConstant.APP_STATUS_399.toString(), InvtHeadConstant.APP_STATUS_399_DESC.toString());
		APP_STATUS_MAP.put(APP_STATUS_623005.value, APP_STATUS_623005_DESC.value);
		APP_STATUS_MAP.put(APP_STATUS_623003.value, APP_STATUS_623003_DESC.value);
		APP_STATUS_MAP.put(APP_STATUS_623999.value, APP_STATUS_623999_DESC.value);
	}
	
	private InvtCancelConstant(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}

	public static Map<String, String> getAPP_STATUS_MAP() {
		return APP_STATUS_MAP;
	}
}
