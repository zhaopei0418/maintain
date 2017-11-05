package online.zhaopei.myproject.jerseyservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageHelper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import online.zhaopei.myproject.resource.InvtResource;
import online.zhaopei.myproject.service.ecssent.InvtHeadService;

@Component
@Path("/v1/invts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "清单相关接口", produces = "application/json")
public class InvtsEndpoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(InvtsEndpoint.class);

	@Autowired
	private InvtHeadService invtHeadService;
	
	@GET					//JAX-RS Annotation
	@ApiOperation(				//Swagger Annotation
			value = "根据关键字来查询清单", 
			response = InvtResource.class)  
	@ApiResponses(value = {		//Swagger Annotation
		@ApiResponse(code = 200, message = "成功", response = InvtResource.class),
	    @ApiResponse(code = 500, message = "服务器出错")
	})
	public Response login(@ApiParam(value = "关键字") @QueryParam("key") String key) {
		LOGGER.info("v1/login/{} - {key}", key, MediaType.APPLICATION_JSON);
		
		PageHelper.startPage(1, 10);
		List<InvtResource> invtResourceList = this.invtHeadService.getInvtList(key);
		return Response.ok(invtResourceList).header("Access-Control-Allow-Origin", "*").build();
	}
}