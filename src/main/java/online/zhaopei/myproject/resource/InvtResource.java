package online.zhaopei.myproject.resource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "清单相关信息类")
public class InvtResource {

	private String copNo;

	private String appStatus;

	@ApiModelProperty(value = "企业内部编号", required = true)
	public String getCopNo() {
		return copNo;
	}

	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}

	@ApiModelProperty(value = "业务状态", required = true)
	public String getAppStatus() {
		return appStatus;
	}

	public void setAppStatus(String appStatus) {
		this.appStatus = appStatus;
	}
	
}
