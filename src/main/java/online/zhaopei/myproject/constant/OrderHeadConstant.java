package online.zhaopei.myproject.constant;

import java.io.Serializable;

public enum OrderHeadConstant implements Serializable {

	;
	
	private String value;
	
	private OrderHeadConstant(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}
}
