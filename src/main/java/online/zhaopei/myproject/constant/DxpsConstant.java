package online.zhaopei.myproject.constant;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public enum DxpsConstant implements Serializable {

	DXP_STATUS_0("0"),
	DXP_STATUS_0_DESC("待处理"),
	DXP_STATUS_1("1"),
	DXP_STATUS_1_DESC("处理中"),
	DXP_STATUS_2("2"),
	DXP_STATUS_2_DESC("处理成功"),
	DXP_STATUS_3("3"),
	DXP_STATUS_3_DESC("处理失败"),
	
	DXP_MODE_LXP("LXP"),
	DXP_MODE_LXP_DESC("本地传输"),
	DXP_MODE_DXP("DXP"),
	DXP_MODE_DXP_DESC("总署传输"),
	
	MSG_TYPE_311("CEB311Message"),
	MSG_TYPE_311_DESC("电子订单"),
	MSG_TYPE_312("CEB312Message"),
	MSG_TYPE_312_DESC("电子订单回执"),
	MSG_TYPE_411("CEB411Message"),
	MSG_TYPE_411_DESC("支付凭证"),
	MSG_TYPE_412("CEB412Message"),
	MSG_TYPE_412_DESC("支付凭证回执"),
	MSG_TYPE_511("CEB511Message"),
	MSG_TYPE_511_DESC("物流运单"),
	MSG_TYPE_512("CEB512Message"),
	MSG_TYPE_512_DESC("物流运单回执"),
	MSG_TYPE_513("CEB513Message"),
	MSG_TYPE_513_DESC("物流运单状态"),
	MSG_TYPE_514("CEB514Message"),
	MSG_TYPE_514_DESC("物流运单状态回执"),
	MSG_TYPE_621("CEB621Message"),
	MSG_TYPE_621_DESC("进口清单"),
	MSG_TYPE_622("CEB622Message"),
	MSG_TYPE_622_DESC("进口清单回执"),
	MSG_TYPE_623("CEB623Message"),
	MSG_TYPE_623_DESC("撤销申请单"),
	MSG_TYPE_624("CEB624Message"),
	MSG_TYPE_624_DESC("撤销申请单回执"),
	MSG_TYPE_625("CEB625Message"),
	MSG_TYPE_625_DESC("退货申请单"),
	MSG_TYPE_626("CEB626Message"),
	MSG_TYPE_626_DESC("退货申请单回执"),
	MSG_TYPE_711("CEB711Message"),
	MSG_TYPE_711_DESC("退货申请单"),
	MSG_TYPE_712("CEB712Message"),
	MSG_TYPE_712_DESC("退货申请单回执"),
	MSG_TYPE_816("CEB816Message"),
	MSG_TYPE_816_DESC("税单"),
	MSG_TYPE_818("CEB818Message"),
	MSG_TYPE_818_DESC("税单状态"),
	
	;
	
	private static Map<String, String> DXP_STATUS_MAP = new HashMap<String, String>();
	
	private static Map<String, String> DXP_MODE_MAP = new HashMap<String, String>();
	
	private static Map<String, String> MSG_TYPE_MAP = new HashMap<String, String>();
	
	static {
		DXP_STATUS_MAP.put("", "所有");
		DXP_STATUS_MAP.put(DXP_STATUS_0.value, DXP_STATUS_0_DESC.value);
		DXP_STATUS_MAP.put(DXP_STATUS_1.value, DXP_STATUS_1_DESC.value);
		DXP_STATUS_MAP.put(DXP_STATUS_2.value, DXP_STATUS_2_DESC.value);
		DXP_STATUS_MAP.put(DXP_STATUS_3.value, DXP_STATUS_3_DESC.value);
		
		DXP_MODE_MAP.put("", "所有");
		DXP_MODE_MAP.put(DXP_MODE_LXP.value, DXP_MODE_LXP_DESC.value);
		DXP_MODE_MAP.put(DXP_MODE_DXP.value, DXP_MODE_DXP_DESC.value);
		
		MSG_TYPE_MAP.put("", "所有");
		MSG_TYPE_MAP.put(MSG_TYPE_311.value, MSG_TYPE_311_DESC.value);
		MSG_TYPE_MAP.put(MSG_TYPE_312.value, MSG_TYPE_312_DESC.value);
		MSG_TYPE_MAP.put(MSG_TYPE_411.value, MSG_TYPE_411_DESC.value);
		MSG_TYPE_MAP.put(MSG_TYPE_412.value, MSG_TYPE_312_DESC.value);
		MSG_TYPE_MAP.put(MSG_TYPE_511.value, MSG_TYPE_511_DESC.value);
		MSG_TYPE_MAP.put(MSG_TYPE_512.value, MSG_TYPE_512_DESC.value);
		MSG_TYPE_MAP.put(MSG_TYPE_513.value, MSG_TYPE_513_DESC.value);
		MSG_TYPE_MAP.put(MSG_TYPE_514.value, MSG_TYPE_514_DESC.value);
		MSG_TYPE_MAP.put(MSG_TYPE_621.value, MSG_TYPE_621_DESC.value);
		MSG_TYPE_MAP.put(MSG_TYPE_622.value, MSG_TYPE_622_DESC.value);
		MSG_TYPE_MAP.put(MSG_TYPE_623.value, MSG_TYPE_623_DESC.value);
		MSG_TYPE_MAP.put(MSG_TYPE_624.value, MSG_TYPE_624_DESC.value);
		MSG_TYPE_MAP.put(MSG_TYPE_625.value, MSG_TYPE_625_DESC.value);
		MSG_TYPE_MAP.put(MSG_TYPE_626.value, MSG_TYPE_626_DESC.value);
		MSG_TYPE_MAP.put(MSG_TYPE_711.value, MSG_TYPE_711_DESC.value);
		MSG_TYPE_MAP.put(MSG_TYPE_712.value, MSG_TYPE_712_DESC.value);
		MSG_TYPE_MAP.put(MSG_TYPE_816.value, MSG_TYPE_816_DESC.value);
		MSG_TYPE_MAP.put(MSG_TYPE_818.value, MSG_TYPE_818_DESC.value);
		
	}
	
	private String value;
	
	private DxpsConstant(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}

	public static Map<String, String> getDXP_STATUS_MAP() {
		return DXP_STATUS_MAP;
	}

	public static Map<String, String> getDXP_MODE_MAP() {
		return DXP_MODE_MAP;
	}

	public static Map<String, String> getMSG_TYPE_MAP() {
		return MSG_TYPE_MAP;
	}
	
}
