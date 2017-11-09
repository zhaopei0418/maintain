package online.zhaopei.myproject.jerseyservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import online.zhaopei.myproject.resource.ResultResource;

//@Component
//@Path("/v1/login")
//@Consumes(MediaType.APPLICATION_JSON)
//@Produces(MediaType.APPLICATION_JSON)
//@Api(value = "用户登录接口", produces = "application/json")
public class LoginEndpoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginEndpoint.class);

	@POST					//JAX-RS Annotation
	@Consumes("application/x-www-form-urlencoded")
	@ApiOperation(				//Swagger Annotation
			value = "提供用户名及密码用来登录", 
			response = ResultResource.class)  
	@ApiResponses(value = {		//Swagger Annotation
		@ApiResponse(code = 200, message = "成功", response = ResultResource.class),
	    @ApiResponse(code = 801, message = "登录失败", response = ResultResource.class)
	})
	public Response login(@ApiParam(required = true, value = "用户名") @FormParam("userName") String userName,
			@ApiParam(required = true, value = "密码") @FormParam("password") String password) {
		LOGGER.info("v1/login/{} - {userName}", userName, MediaType.APPLICATION_JSON);
		LOGGER.info("v1/login/{} - {password}", password, MediaType.APPLICATION_JSON);
		if ("admin".equals(userName) && "zhaopei0418".equals(password)) {
			return Response.status(Status.OK).entity(new ResultResource(true)).build();
		} else {
			return Response.status(801).entity(new ResultResource(false, "用户名或者密码错误!")).build();
		}
	}
}