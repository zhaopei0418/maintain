package online.zhaopei.myproject.constant;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public enum DeliveryHeadConstant implements Serializable {

	APP_STATUS_01("01"),
	APP_STATUS_01_DESC("暂存"),
	APP_STATUS_02("02"),
	APP_STATUS_02_DESC("申报中"),
	APP_STATUS_03("03"),
	APP_STATUS_03_DESC("发送海关成功"),
	APP_STATUS_04("04"),
	APP_STATUS_04_DESC("发送海关失败"),
	APP_STATUS_05("05"),
	APP_STATUS_05_DESC("电子口岸校验失败"),
	APP_STATUS_1("1"),
	APP_STATUS_1_DESC("电子口岸暂存"),
	APP_STATUS_2("2"),
	APP_STATUS_2_DESC("电子口岸申报中"),
	APP_STATUS_3("3"),
	APP_STATUS_3_DESC("发送电子口岸成功"),
	APP_STATUS_4("4"),
	APP_STATUS_4_DESC("发送电子口岸失败"),
	APP_STATUS_100("100"),
	APP_STATUS_100_DESC("海关退单"),
	APP_STATUS_120("120"),
	APP_STATUS_120_DESC("海关入库"),
	
	;
	
	private static Map<String, String> APP_STATUS_MAP = new HashMap<String, String>();
	
	private String value;
	
	static {
		APP_STATUS_MAP.put("", "所有");
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
