package online.zhaopei.myproject.constant;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public enum DistsConstant implements Serializable {

	;
	
	private static Map<String, String> I_E_FLAG = new HashMap<String, String>();
	
	private static Map<String, String> I_E_TYPE = new HashMap<String, String>();
	
	private static Map<String, String> DIST_STAT = new HashMap<String, String>();
	
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
	
}
