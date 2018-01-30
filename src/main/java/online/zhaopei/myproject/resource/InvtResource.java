package online.zhaopei.myproject.resource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "清单相关信息类")
public class InvtResource {

	@ApiModelProperty(value = "企业内部编号", required = true)
	private String copNo;

	@ApiModelProperty("订单号")
	private String orderNo;

	@ApiModelProperty("清单号")
	private String invtNo;

	@ApiModelProperty(value = "业务状态", required = true)
	private String appStatus;

	@ApiModelProperty("海关状态")
	private String cusStatus;

	public String getCopNo() {
		return copNo;
	}

	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}

	public String getAppStatus() {
		return appStatus;
	}

	public void setAppStatus(String appStatus) {
		this.appStatus = appStatus;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getInvtNo() {
		return invtNo;
	}

	public void setInvtNo(String invtNo) {
		this.invtNo = invtNo;
	}

	public String getCusStatus() {
		return cusStatus;
	}

	public void setCusStatus(String cusStatus) {
		this.cusStatus = cusStatus;
	}
}
