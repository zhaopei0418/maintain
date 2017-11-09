package online.zhaopei.myproject.resource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by zhaopei on 17/11/9.
 */
@ApiModel(description = "是否可以绑核单回执类")
public class DistResource {

    private String status;

    private String info;

    @ApiModelProperty(value = "状态,0:不可绑,1:可以绑, 2:异常", required = true)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @ApiModelProperty(value = "状态说明", required = true)
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
