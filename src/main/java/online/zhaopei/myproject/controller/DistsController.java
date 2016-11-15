package online.zhaopei.myproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import online.zhaopei.myproject.constant.CommonConstant;
import online.zhaopei.myproject.constant.DistsConstant;
import online.zhaopei.myproject.constant.InvtHeadConstant;
import online.zhaopei.myproject.domain.common.DatatablePara;
import online.zhaopei.myproject.domain.ecssent.DistBillList;
import online.zhaopei.myproject.domain.ecssent.DistHead;
import online.zhaopei.myproject.service.ecssent.DistBillListService;
import online.zhaopei.myproject.service.ecssent.DistHeadService;
import online.zhaopei.myproject.service.para.CustomsService;
import online.zhaopei.myproject.tool.common.ParaTool;

@Controller
@RequestMapping("/dists")
public class DistsController extends BaseController {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1247933637170790663L;

	@Autowired
	private DistHeadService distHeadService ;
	
	@Autowired
	private DistBillListService distBillListService;
	
	@Autowired
	private CustomsService customsService;
	
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
