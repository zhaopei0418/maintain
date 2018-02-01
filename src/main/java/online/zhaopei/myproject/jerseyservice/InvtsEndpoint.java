package online.zhaopei.myproject.jerseyservice;

import io.swagger.annotations.*;
import online.zhaopei.myproject.config.ApplicationProp;
import online.zhaopei.myproject.domain.ecssent.InvtHead;
import online.zhaopei.myproject.resource.DistResource;
import online.zhaopei.myproject.resource.InvtResource;
import online.zhaopei.myproject.resource.ReissueResource;
import online.zhaopei.myproject.service.ecssent.InvtHeadService;
import online.zhaopei.myproject.service.ecssent.UserUserService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Component
@Path("/v1/invts")
@Consumes({MediaType.APPLICATION_JSON + ";charset=UTF-8", MediaType.TEXT_PLAIN + ";charset=UTF-8",
MediaType.APPLICATION_FORM_URLENCODED + ";charset=UTF-8", MediaType.MULTIPART_FORM_DATA + ";charset=UTF-8"})
@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
@Api(value = "清单相关接口", produces = "application/json")
public class InvtsEndpoint {

	private static final Log LOGGER = LogFactory.getLog(InvtsEndpoint.class);

	@Autowired
	private InvtHeadService invtHeadService;

	@Autowired
	private UserUserService userUserService;

	@Autowired
	private ApplicationProp app;
	
	/**@GET					//JAX-RS Annotation
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
	}*/

	@GET
	@ApiOperation(
			value = "根据企业代码，及密码还有清单号来判断该清单是否可以绑核放单",
			response = DistResource.class)
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message = "成功", response = DistResource.class),
			@ApiResponse(code = 500, message = "服务器出错")})
    public Response isBindDist(@ApiParam(required = true, value = "企业代码") @QueryParam("companyCode") String companyCode,
							   @ApiParam(required = true, value = "密码") @QueryParam("password") String password,
							   @ApiParam(value = "电商平台代码") @QueryParam("ebpCode") String ebpCode,
							   @ApiParam(value = "订单号") @QueryParam("orderNo") String orderNo,
								@ApiParam(value = "运单号") @QueryParam("logisticsNo") String logisticsNo) {
		DistResource dr = new DistResource();
		InvtHead ih = null;
		int ihc = 0;
		List<InvtHead> ihList = null;
		if (StringUtils.isEmpty(companyCode) || StringUtils.isEmpty(password)
				|| (StringUtils.isEmpty(orderNo) && StringUtils.isEmpty(logisticsNo))) {
			dr.setStatus("2");
			dr.setInfo("companyCode,password,orderNo与logisticsNo不能同时为空,其他均不能为空，请检查参数!");
		} else {
		    if (0 == this.userUserService.countUserByLoginNameAndPassword(companyCode, password)) {
		    	dr.setStatus("2");
		    	dr.setInfo("企业代码或者密码不正确，请检查!");
			} else {
		    	ih = new InvtHead();
		    	ih.setEbpCode(ebpCode);
		    	ih.setOrderNo(orderNo);
		    	ih.setLogisticsNo(logisticsNo);
		    	ih.setSearchCompanyCode(companyCode);
		    	ih.setDistStat("2");
		    	ihc = this.invtHeadService.countInvtHead(ih);
		    	if (0 == ihc) {
					dr.setStatus("0");
					dr.setInfo("不可以绑");
				} else {
					dr.setStatus("1");
					dr.setInfo("可以绑");
				}
			}
		}
		return Response.ok(dr).build();
	}

	@GET
    @Path("getInvtDetail")
	@ApiOperation(
			value = "查看清单状态",
			response = InvtResource.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "成功", response = InvtResource.class),
			@ApiResponse(code = 500, message = "服务器出错")})
	public Response getInvtDetail(@ApiParam("订单号") @QueryParam("orderNo") String orderNo,
								  @ApiParam("清单号") @QueryParam("invtNo") String invtNo,
								  @ApiParam("核放单号") @QueryParam("distNo") String distNo) {
		return Response.ok(getInvtResource(orderNo, invtNo, distNo, true)).build();
	}

	private List<InvtResource> getInvtResource(String orderNo, String invtNo, String distNo, boolean consistent) {
		List<InvtResource> invtList = new ArrayList<InvtResource>();
		InvtResource invtResource = null;
		InvtHead ih = null;
		List<InvtHead> ihList = null;
		if (StringUtils.isNotEmpty(orderNo) || StringUtils.isNotEmpty(invtNo)
				|| StringUtils.isNotEmpty(distNo)) {
			ih = new InvtHead();
			ih.setExactOrderNo(orderNo);
			ih.setExactInvtNo(invtNo);
			ih.setDistNo(distNo);
			if (!consistent) {
				ih.setCusStatus("010");
			}
			ihList = invtHeadService.getInvtHeadList(ih);
			if (null != ihList && !ihList.isEmpty()) {
				for (InvtHead tih : ihList) {
					invtResource = new InvtResource();
					invtResource.setAppStatus(tih.getAppStatus());
					invtResource.setCopNo(tih.getCopNo());
					invtResource.setCusStatus(tih.getCusStatus());
					invtResource.setInvtNo(tih.getInvtNo());
					invtResource.setOrderNo(tih.getOrderNo());
					invtList.add(invtResource);
				}
			}
		}
		return invtList;
	}

	@POST
	@Path("reissue")
	@ApiOperation(
			value = "补发清单",
			response = ReissueResource.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "成功", response = ReissueResource.class),
			@ApiResponse(code = 500, message = "服务器出错")})
	public Response reissue(@ApiParam("订单号") @FormParam("orderNo") String orderNo,
								  @ApiParam("清单号") @FormParam("invtNo") String invtNo,
								  @ApiParam("核放单号") @FormParam("distNo") String distNo) {
		int count = 0;
		LOGGER.info("reissue[]orderNo=[" + orderNo + "] invtNo=[" + invtNo + "] distNo=[" + distNo + "]");
		ReissueResource reissueResource = new ReissueResource();
		List<InvtResource> invtList = getInvtResource(orderNo, invtNo, distNo, false);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String suffix = "BuFaZbq.txt";
		String reissueFileName = null;
		File reissueTmpFile = null;
		File reissueFile = null;
		PrintWriter reissuePw = null;
		if (null != invtList && !invtList.isEmpty()) {
			try {
				reissueFileName = sdf.format(Calendar.getInstance().getTime()) + "_" + suffix;
				reissueTmpFile = new File(this.app.getReissueTmpDir() + reissueFileName);
				reissueFile = new File(this.app.getReissueDir() + reissueFileName);
				reissuePw = new PrintWriter(reissueTmpFile);
				LOGGER.info("开始写文件");
				for (InvtResource ir : invtList) {
					reissuePw.println(ir.getInvtNo());
				}
				reissuePw.flush();
				reissuePw.close();
				reissuePw = null;
				FileUtils.copyFile(reissueTmpFile, reissueFile);
				count = invtList.size();
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if (null != reissuePw) {
					reissuePw.close();
				}
			}
		}
		reissueResource.setReissueAmount(count);
		return Response.ok(reissueResource).build();
	}

	@GET
	@Path("countReissue")
	@ApiOperation(
			value = "统计需要补发清单个数",
			response = ReissueResource.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "成功", response = ReissueResource.class),
			@ApiResponse(code = 500, message = "服务器出错")})
	public Response countReissue(@ApiParam("订单号") @QueryParam("orderNo") String orderNo,
							@ApiParam("清单号") @QueryParam("invtNo") String invtNo,
							@ApiParam("核放单号") @QueryParam("distNo") String distNo) {
		int count = 0;
		LOGGER.info("countReissue[]orderNo=[" + orderNo + "] invtNo=[" + invtNo + "] distNo=[" + distNo + "]");
		ReissueResource reissueResource = new ReissueResource();
		List<InvtResource> invtList = getInvtResource(orderNo, invtNo, distNo, false);
		if (null != invtList && !invtList.isEmpty()) {
			count = invtList.size();
		}
		reissueResource.setReissueAmount(count);
		return Response.ok(reissueResource).build();
	}
}