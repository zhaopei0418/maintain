package online.zhaopei.myproject.constant;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public enum DistsConstant implements Serializable {

	;
	
	private static Map<String, String> I_E_FLAG = new HashMap<String, String>();
	
	private static Map<String, String> I_E_TYPE = new HashMap<String, String>();
	
	private static Map<String, String> DIST_STAT = new HashMap<String, String>();
	
	private static Map<String, String> DISTRICT_CODE = new HashMap<String, String>();
	
	private static Map<String, String> DIST_TYPE = new HashMap<String, String>();
	
	private static Map<String, String> ARRIVAL_FLAG = new HashMap<String, String>();
	
	static {
		I_E_FLAG.put("", "全部");
		I_E_FLAG.put("1", "出区");
		I_E_FLAG.put("1", "入区");
		I_E_FLAG.put("1", "其他");
		
		I_E_TYPE.put("", "全部");
		I_E_TYPE.put("1", "进口集货");
		I_E_TYPE.put("2", "进口备货(先入后报)");
		I_E_TYPE.put("3", "进口备货(先报后入)");
		
		DIST_STAT.put("", "全部");
		DIST_STAT.put("1", "保存");
		DIST_STAT.put("2", "申报");
		DIST_STAT.put("3", "核放单已发送");
		DIST_STAT.put("4", "核放单已接收");
		DIST_STAT.put("5", "审核通过");
		DIST_STAT.put("6", "审核不通过");
		DIST_STAT.put("7", "载货单放行");
		DIST_STAT.put("8", "结案(车货解绑)");
		
		DISTRICT_CODE.put("", "全部");
		DISTRICT_CODE.put("CD00", "陆港/机场区外");
		DISTRICT_CODE.put("RE33", "陆港卡口");
		DISTRICT_CODE.put("ZZ01", "综保/德众区外");
		DISTRICT_CODE.put("ZZ04", "河南保税");
		DISTRICT_CODE.put("ZZ05", "出口加工区");
		DISTRICT_CODE.put("ZZ06", "河南德众");
		DISTRICT_CODE.put("ZZ09", "综保区内一卡口");
		DISTRICT_CODE.put("RE24", "机场");
		
		DIST_TYPE.put("", "全部");
		DIST_TYPE.put("1", "普通业务");
		DIST_TYPE.put("2", "在途业务");
		
		ARRIVAL_FLAG.put("", "全部");
		ARRIVAL_FLAG.put("1", "未运抵");
		ARRIVAL_FLAG.put("2", "已运抵");
	}
	
	private String value;
	
	private DistsConstant(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}

	public static Map<String, String> getI_E_FLAG() {
		return I_E_FLAG;
	}

	public static Map<String, String> getI_E_TYPE() {
		return I_E_TYPE;
	}

	public static Map<String, String> getDIST_STAT() {
		return DIST_STAT;
	}

	public static Map<String, String> getDISTRICT_CODE() {
		return DISTRICT_CODE;
	}

	public static Map<String, String> getDIST_TYPE() {
		return DIST_TYPE;
	}

	public static Map<String, String> getARRIVAL_FLAG() {
		return ARRIVAL_FLAG;
	}
}
