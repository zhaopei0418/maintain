package online.zhaopei.myproject.constant;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public enum CheckMailGoodsConstant implements Serializable {

	OP_TYPE_01("01"),
	OP_TYPE_01_DESC("放行"),
	OP_TYPE_02("02"),
	OP_TYPE_02_DESC("查验"),
	OP_TYPE_03("03"),
	OP_TYPE_03_DESC("捡入待处理区"),
	OP_TYPE_04("04"),
	OP_TYPE_04_DESC("暂停流水线并报警"),
	OP_TYPE_05("05"),
	OP_TYPE_05_DESC("即决式查验"),
	;
	
	private String value;
	
	private static Map<String, String> OP_TYPE_MAP = new HashMap<String, String>();
	
	static {
		OP_TYPE_MAP.put("", "所有类型");
		OP_TYPE_MAP.put(OP_TYPE_01.toString(), OP_TYPE_01_DESC.toString());
		OP_TYPE_MAP.put(OP_TYPE_02.toString(), OP_TYPE_02_DESC.toString());
		OP_TYPE_MAP.put(OP_TYPE_03.toString(), OP_TYPE_03_DESC.toString());
		OP_TYPE_MAP.put(OP_TYPE_04.toString(), OP_TYPE_04_DESC.toString());
		OP_TYPE_MAP.put(OP_TYPE_05.toString(), OP_TYPE_05_DESC.toString());
	}
	
	private CheckMailGoodsConstant(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}

	public static Map<String, String> getOP_TYPE_MAP() {
		return OP_TYPE_MAP;
	}
	
}
