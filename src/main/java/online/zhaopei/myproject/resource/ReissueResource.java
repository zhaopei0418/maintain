package online.zhaopei.myproject.resource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * Created by zhaopei on 18/1/30.
 */
@ApiModel(description = "补发清单响应")
public class ReissueResource {

    @ApiModelProperty("补发个数")
    private Integer reissueAmount;

    public Integer getReissueAmount() {
        return reissueAmount;
    }

    public void setReissueAmount(Integer reissueAmount) {
        this.reissueAmount = reissueAmount;
    }
}
