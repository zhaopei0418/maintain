package online.zhaopei.myproject.constant;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public enum DeliveryHeadConstant implements Serializable {

	;
	
	private static Map<String, String> APP_STATUS_MAP = new HashMap<String, String>();
	
	private String value;
	
	static {
		APP_STATUS_MAP.put("", "所有");
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
		APP_STATUS_MAP.put(InvtHeadConstant.APP_STATUS_504011.toString(), InvtHeadConstant.APP_STATUS_504011_DESC.toString());
	}
	
	private DeliveryHeadConstant(String value) {
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
