package online.zhaopei.myproject.constant;

public enum WeChatMsgType {

	TEXT("text")
	;
	private String value;
	
	private WeChatMsgType(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}
	
}
