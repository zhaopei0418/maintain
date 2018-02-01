package online.zhaopei.myproject.jerseyservice;

import io.swagger.annotations.*;
import online.zhaopei.myproject.domain.gjent.PersonalInfo;
import online.zhaopei.myproject.resource.DistResource;
import online.zhaopei.myproject.resource.InvtResource;
import online.zhaopei.myproject.resource.PersonalResource;
import online.zhaopei.myproject.service.ecssent.UserUserService;
import online.zhaopei.myproject.service.gjent.PersonalInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by zhaopei on 17/11/9.
 */
@Component
@Path("/v1/personal")
@Consumes({MediaType.APPLICATION_JSON + ";charset=UTF-8", MediaType.TEXT_PLAIN + ";charset=UTF-8"})
@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
@Api(value = "验证身份证信息", produces = "application/json")
public class PersonalEndpoint {

    @Autowired
    private PersonalInfoService personalInfoService;

    @Autowired
    private UserUserService userUserService;


    @GET
    @Path("/checkNameAndCertId")
    @ApiOperation(
            value = "根据身份证号及名称验证是否一致",
            response = PersonalResource.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = PersonalResource.class),
            @ApiResponse(code = 500, message = "服务器出错")
    })
    public Response checkPersonal(@ApiParam(required = true, value = "企业代码") @QueryParam("companyCode") String companyCode,
                          @ApiParam(required = true, value = "密码") @QueryParam("password") String password,
                          @ApiParam(required = true, value = "名称") @QueryParam("name") String name,
                          @ApiParam(required = true, value = "身份证号") @QueryParam("certId") String certId) {
        PersonalResource pr = new PersonalResource();
        PersonalInfo pi = null;
        if (StringUtils.isEmpty(companyCode) || StringUtils.isEmpty(password) || StringUtils.isEmpty(name) || StringUtils.isEmpty(certId)) {
            pr.setCheckFlag("2");
            pr.setInfo("companyCode,password,name,certId都不能为空，请检查参数!");
        } else {
            if (0 == this.userUserService.countUserByLoginNameAndPassword(companyCode, password)) {
                pr.setCheckFlag("2");
                pr.setInfo("企业代码或者密码不正确，请检查!");
            } else {
                pi = this.personalInfoService.getPersonalInfoByNameCertId(name, certId);
                if (null == pi) {
                    pr.setCheckFlag("2");
                    pr.setInfo("库中没有此身份信息");
                } else {
                    pr.setCheckFlag("Y".equals(pi.getCheckFlag()) ? "1" : "0");
                    pr.setInfo(pi.getCheckMark());
                }
            }
        }

        return Response.ok(pr).build();
    }
}
