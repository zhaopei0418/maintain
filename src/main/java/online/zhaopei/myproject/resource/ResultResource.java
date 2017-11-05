package online.zhaopei.myproject.resource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The domain model class
 * 
 * @author bright.zheng
 *
 */
@ApiModel(description = "反回结果类")
public class ResultResource {

	private boolean success;
	
	private String info;
	
	public ResultResource() {
	}
	
	public ResultResource(boolean success) {
		this.success = success;
	}
	
	public ResultResource(boolean success, String info) {
		this.success = success;
		this.info = info;
	}
	
	@ApiModelProperty(value = "是否成功", required = true)
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	@ApiModelProperty(value = "返回信息")
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}