package online.zhaopei.myproject.resource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by zhaopei on 17/11/9.
 */
@ApiModel(description = "检查身份信息是否一致回执类")
public class PersonalResource {

    private String checkFlag;

    private String info;

    @ApiModelProperty(value = "检查标志,0:不一致,1:一致,2:异常", required = true)
    public String getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(String checkFlag) {
        this.checkFlag = checkFlag;
    }

    @ApiModelProperty(value = "信息说明", required = true)
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
