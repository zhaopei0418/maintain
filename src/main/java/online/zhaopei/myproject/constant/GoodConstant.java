package online.zhaopei.myproject.constant;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public enum GoodConstant implements Serializable {

	STATUS_1("1"),
	STATUS_1_DESC("暂存"),
	STATUS_2("2"),
	STATUS_2_DESC("申报"),
	STATUS_3("3"),
	STATUS_3_DESC("退单"),
	STATUS_4("4"),
	STATUS_4_DESC("审批通过"),
	STATUS_12("12"),
	STATUS_12_DESC("变更暂存"),
	STATUS_21("21"),
	STATUS_21_DESC("退单重报"),
	STATUS_22("22"),
	STATUS_22_DESC("变更申报"),
	STATUS_23("23"),
	STATUS_23_DESC("删除申报"),
	STATUS_32("32"),
	STATUS_32_DESC("变更退单"),
	STATUS_33("33"),
	STATUS_33_DESC("删除退单"),
	STATUS_42("42"),
	STATUS_42_DESC("变更审批通过"),
	STATUS_43("43"),
	STATUS_43_DESC("删除审批通过"),
	
	;
	
	private static Map<String, String> STATUS = new HashMap<String, String>();
	
	static {
		STATUS.put("", "所有状态");
		STATUS.put(STATUS_1.toString(), STATUS_1_DESC.toString());
		STATUS.put(STATUS_2.toString(), STATUS_2_DESC.toString());
		STATUS.put(STATUS_3.toString(), STATUS_3_DESC.toString());
		STATUS.put(STATUS_4.toString(), STATUS_4_DESC.toString());
		STATUS.put(STATUS_12.toString(), STATUS_12_DESC.toString());
		STATUS.put(STATUS_21.toString(), STATUS_21_DESC.toString());
		STATUS.put(STATUS_22.toString(), STATUS_22_DESC.toString());
		STATUS.put(STATUS_23.toString(), STATUS_23_DESC.toString());
		STATUS.put(STATUS_32.toString(), STATUS_32_DESC.toString());
		STATUS.put(STATUS_33.toString(), STATUS_33_DESC.toString());
		STATUS.put(STATUS_42.toString(), STATUS_42_DESC.toString());
		STATUS.put(STATUS_43.toString(), STATUS_43_DESC.toString());
	}
	
	private String value;
	
	private GoodConstant(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}

	public static Map<String, String> getSTATUS() {
		return STATUS;
	}
}
