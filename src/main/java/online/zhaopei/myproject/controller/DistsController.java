package online.zhaopei.myproject.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import online.zhaopei.myproject.common.tool.ParaTool;
import online.zhaopei.myproject.constant.CommonConstant;
import online.zhaopei.myproject.constant.DistsConstant;
import online.zhaopei.myproject.constant.InvtHeadConstant;
import online.zhaopei.myproject.domain.common.DatatablePara;
import online.zhaopei.myproject.domain.ecssent.DistBillList;
import online.zhaopei.myproject.domain.ecssent.DistHead;
import online.zhaopei.myproject.domain.ecssent.GrantCompany;
import online.zhaopei.myproject.service.ecssent.DistBillListService;
import online.zhaopei.myproject.service.ecssent.DistHeadService;
import online.zhaopei.myproject.service.ecssent.GrantCompanyService;
import online.zhaopei.myproject.service.para.CustomsService;

@Controller
@RequestMapping("/dists")
public class DistsController extends BaseController {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1247933637170790663L;

	private static final Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
	
	private static final String SALT = "zhaopei";
	
	@Autowired
	private DistHeadService distHeadService ;
	
	@Autowired
	private DistBillListService distBillListService;
	
	@Autowired
	private CustomsService customsService;
	
	@Autowired
	private GrantCompanyService grantCompanyService;
	
	@GetMapping("/{seqNo}")
	public ModelAndView show(@PathVariable String seqNo) {
		ModelAndView mv = new ModelAndView("dists/show");
		mv.addObject("distHead", this.distHeadService.getDistHeadBySeqNo(seqNo));
		mv.addObject("ieFlag", DistsConstant.getI_E_FLAG());
		mv.addObject("ieType", DistsConstant.getI_E_TYPE());
		mv.addObject("distStat", DistsConstant.getDIST_STAT());
		mv.addObject("customsCode", CommonConstant.getZBXC_CUSTOMS_MAP());
		mv.addObject("iePort", ParaTool.getAllCustoms(this.customsService));
		mv.addObject("districtCode", DistsConstant.getDISTRICT_CODE());
		mv.addObject("distType", DistsConstant.getDIST_TYPE());
		mv.addObject("tradeMode", CommonConstant.getZBXC_TRADE_MODE_MAP());
		
		return mv;
	}

	@GetMapping("/calculationPackWt/{distNo}")
	@ResponseBody
	public String calculationPackWt(@PathVariable String distNo) {
		this.distHeadService.calculationPackWt(distNo);
		return "{success: true}";
	}

	@PostMapping("/searchDistBill/{seqNo}")
	@ResponseBody
	public String searchDistBill(@PathVariable String seqNo, DatatablePara datatablePara) {
		JsonObject result = new JsonObject();
		JsonArray data = new JsonArray();
		JsonObject dataObj = null;
		result.addProperty("draw", datatablePara.getDraw());
		result.addProperty("recordsTotal", this.distBillListService.countDistBillList(seqNo));
		int pageNum = datatablePara.getStart() / datatablePara.getLength() + 1;
		PageHelper.startPage(pageNum, datatablePara.getLength());
		PageInfo<DistBillList> pageInfo = new PageInfo<DistBillList>(this.distBillListService.getDistBillListListBySearchText(seqNo, datatablePara.getSearch().get("value")));
		result.addProperty("recordsFiltered", pageInfo.getTotal());
		List<DistBillList> distBillListList = pageInfo.getList();
		
		if (null != distBillListList && !distBillListList.isEmpty()) {
			for (DistBillList dbl : distBillListList) {
				dataObj = new JsonObject();
				dataObj.addProperty("billNo", "<a href='/invts/" + dbl.getSeqNo() + "'>" + dbl.getBillNo() + "</a>");
				dataObj.addProperty("grossWt", dbl.getGrossWt());
				dataObj.addProperty("netWt", dbl.getNetWt());
				dataObj.addProperty("arrivalFlag", DistsConstant.getARRIVAL_FLAG().get(dbl.getArrivalFlag()) + "[" + dbl.getArrivalFlag() + "]");
				dataObj.addProperty("ebcName", dbl.getEbcName());
				dataObj.addProperty("orderNo", dbl.getOrderNo());
				dataObj.addProperty("logisticsName", dbl.getLogisticsName());
				dataObj.addProperty("logisticsNo", dbl.getLogisticsNo());
				dataObj.addProperty("tradeMode", CommonConstant.getZBXC_TRADE_MODE_MAP().get(dbl.getTradeMode()) + "[" + dbl.getTradeMode() + "]");
				dataObj.addProperty("appStatus", InvtHeadConstant.getAPP_STATUS_MAP().get(dbl.getAppStatus()) + "[" + dbl.getAppStatus() + "]");
				data.add(dataObj);
			}
		}
		
		result.add("data", data);
		return result.toString();
	}
	
	@RequestMapping("exportExcludeInvts")
	public ResponseEntity<byte[]> export(String authToken, String distNo) throws IOException {
		SimpleDateFormat sdfFileName = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String fileName = "exclude_invts_" + sdfFileName.format(Calendar.getInstance().getTime()) + ".csv";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", fileName);
		File file = new File("export/" + fileName);
		PrintWriter writer = null;
		OutputStream output = null;
		
		GrantCompany grantCompany = this.grantCompanyService.getGrantCompanyByAuthToken(authToken);
		
		List<DistBillList> distBillListList = new ArrayList<DistBillList>();
		if (null != grantCompany) {
			distBillListList = this.distBillListService.excludeInvts(distNo, grantCompany.getCompanyCode());	
		}
		
		try {
			output = new FileOutputStream(file);
			output.write(CommonConstant.BOM);
			output.close();
			
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8")));
			writer.println("清单号,订单号,运单号");
			for(DistBillList dbl : distBillListList) {
				writer.print(dbl.getBillNo());
				writer.print("," + dbl.getOrderNo());
				writer.print("," + dbl.getLogisticsNo());
				writer.println();
			}
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			output.close();
			writer.close();
		}
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}
	
	@RequestMapping
	public ModelAndView index(DistHead distHead) {
		PageInfo<DistHead> pageInfo = this.getPageInfo(distHead, DistHead.class, this.distHeadService, "getDistHeadList");
		ModelAndView mv = this.buildBaseModelAndView("dists/list", pageInfo);
		mv.addObject("distHead", distHead);
		mv.addObject("distHeadList", pageInfo.getList());
		mv.addObject("ieFlag", DistsConstant.getI_E_FLAG());
		mv.addObject("ieType", DistsConstant.getI_E_TYPE());
		mv.addObject("distStat", DistsConstant.getDIST_STAT());
		mv.addObject("customsCode", CommonConstant.getZBXC_CUSTOMS_MAP());
		
		return mv;
	}
}
