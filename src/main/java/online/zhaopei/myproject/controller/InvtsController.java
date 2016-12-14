package online.zhaopei.myproject.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import online.zhaopei.myproject.common.tool.ParaTool;
import online.zhaopei.myproject.constant.CommonConstant;
import online.zhaopei.myproject.constant.InvtHeadConstant;
import online.zhaopei.myproject.domain.common.DatatablePara;
import online.zhaopei.myproject.domain.ecssent.DistHead;
import online.zhaopei.myproject.domain.ecssent.InvtHead;
import online.zhaopei.myproject.domain.ecssent.InvtHeadStatistics;
import online.zhaopei.myproject.domain.ecssent.InvtList;
import online.zhaopei.myproject.domain.ecssent.PubRtn;
import online.zhaopei.myproject.domain.gjent.ImpInvtHead;
import online.zhaopei.myproject.service.ecssent.DistHeadService;
import online.zhaopei.myproject.service.ecssent.InvtHeadService;
import online.zhaopei.myproject.service.ecssent.InvtHeadStatisticsService;
import online.zhaopei.myproject.service.ecssent.InvtListService;
import online.zhaopei.myproject.service.ecssent.PubRtnService;
import online.zhaopei.myproject.service.gjent.ImpInvtHeadService;
import online.zhaopei.myproject.service.para.CountryService;
import online.zhaopei.myproject.service.para.CurrService;
import online.zhaopei.myproject.service.para.CustomsService;
import online.zhaopei.myproject.service.para.TradeService;
import online.zhaopei.myproject.service.para.TransfService;
import online.zhaopei.myproject.service.para.UnitService;
import online.zhaopei.myproject.service.para.WrapService;

@Controller
@RequestMapping("/invts")
public class InvtsController extends BaseController {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8742945481030004154L;

	@Autowired
	private InvtHeadService invtHeadService;
	
	@Autowired
	private ImpInvtHeadService impInvtHeadService;
	
	@Autowired
	private PubRtnService pubRtnService;
	
	@Autowired
	private DistHeadService distHeadService;

	@Autowired
	private InvtListService invtListService;
	
	@Autowired
	private InvtHeadStatisticsService invtHeadStatisticsService;

	@Autowired
	private TradeService tradeService;

	@Autowired
	private CustomsService customsService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private CurrService currService;

	@Autowired
	private WrapService wrapService;

	@Autowired
	private TransfService transfService;
	
	@Autowired
	private UnitService unitService;
	
	@GetMapping("/getImpInvtHeadListByInvtNo/{invtNo}")
	@ResponseBody
	public List<ImpInvtHead> getImpInvtHeadListByInvtNo(@PathVariable("invtNo") String invtNo) {
		List<ImpInvtHead> impInvtHeadList = this.impInvtHeadService.getInvtHeadListByInvtNo(invtNo);
		return impInvtHeadList;
	}
	
	@GetMapping("/getImpInvtHeadListByCopNo/{copNo}")
	@ResponseBody
	public List<ImpInvtHead> getImpInvtHeadListByCopNo(@PathVariable("copNo") String copNo) {
		 return this.impInvtHeadService.getInvtHeadListByCopNo(copNo);
	}
	
	@GetMapping("/getPubRtnListByBizGuid/{bizGuid}")
	@ResponseBody
	public List<PubRtn> getPubRtnListByBizGuid(@PathVariable("bizGuid") String bizGuid) {
		return this.pubRtnService.getPubRtnListByBizGuid(bizGuid);
	}
	
	@GetMapping("/getDistHeadByInvtNo/{invtNo}")
	@ResponseBody
	public DistHead getDistHeadByInvtNo(@PathVariable("invtNo") String invtNo) {
		return this.distHeadService.getDistHeadByInvtNo(invtNo);
	}
	
	@GetMapping("/getInvtHeadCount")
	@ResponseBody
	public String getInvtHeadMonthCount() {
		JsonObject result = new JsonObject();
		JsonArray labels = new JsonArray();
		JsonArray datasets = new JsonArray();
		JsonObject data = null;
		
		data.addProperty("label", "清单总量");
		data.addProperty("backgroundColor", "rgba(38, 185, 154, 0.31)");
		data.addProperty("borderColor", "rgba(38, 185, 154, 0.7)");
		data.addProperty("pointBorderColor", "rgba(38, 185, 154, 0.7)");
		data.addProperty("borderColor", "rgba(38, 185, 154, 0.7)");
		data.addProperty("borderColor", "rgba(38, 185, 154, 0.7)");
		
		return result.toString();
	}
	
	@GetMapping("/getInvtHeadTotal")
	@ResponseBody
	public String getInvtHeadTotal(String type) {
		JsonObject result = new JsonObject();
		JsonArray labels = new JsonArray();
		JsonArray datasets = new JsonArray();
		JsonArray data = new JsonArray();
		JsonArray backgroundColor = new JsonArray();
		JsonObject tempObject = null;
		InvtHead invtHead = new InvtHead();
		long other = 0;
		if ("release".equals(type)) {
			invtHead.setAppStatus("800");
		}
		
		List<InvtHead> invtHeadTotalList = this.invtHeadService.getDeclareTopTenSql(invtHead);
		
		if (null != invtHeadTotalList && !invtHeadTotalList.isEmpty()) {
			for (int i = 0; i < invtHeadTotalList.size() && i < 6; i++) {
				InvtHead ih = invtHeadTotalList.get(i);
				labels.add(ih.getEbcName());
				data.add(ih.getCount());
				other += ih.getCount();
				backgroundColor.add(CommonConstant.getPIE_COLORS().get(i));
			}
			
			if (7 <= invtHeadTotalList.size()) {
				labels.add("其他");
				data.add(invtHeadTotalList.get(0).getTotal() - other);
				backgroundColor.add(CommonConstant.getPIE_COLORS().get(6));
			}
			tempObject = new JsonObject();
			tempObject.add("data", data);
			tempObject.add("backgroundColor", backgroundColor);
			datasets.add(tempObject);
		}
		result.add("labels", labels);
		result.add("datasets", datasets);
		return result.toString();
	}
	
	@GetMapping("/{headGuid}")
	public ModelAndView show(@PathVariable("headGuid") String headGuid) {
		ModelAndView mv = new ModelAndView("invts/show");
		InvtHead invtHead = this.invtHeadService.getInvtHeadByHeadGuid(headGuid);

		mv.addObject("invtHead", invtHead);
		mv.addObject("appType", CommonConstant.getAPP_TYPE_MAP());
		mv.addObject("appStatus", InvtHeadConstant.getAPP_STATUS_MAP());
		mv.addObject("distStatus", InvtHeadConstant.getDIST_STATUS_MAP());
		mv.addObject("customsCode", CommonConstant.getZBXC_CUSTOMS_MAP());
		mv.addObject("portCode", ParaTool.getAllCustoms(this.customsService));
		mv.addObject("country", ParaTool.getAllCountries(this.countryService));
		mv.addObject("tradeMode", CommonConstant.getZBXC_TRADE_MODE_MAP());
		mv.addObject("idType", CommonConstant.getID_TYPE_MAP());
		
		return mv;
	}
	
	@GetMapping("/searchInvtList/{headGuid}")
	@ResponseBody
	public String searchInvtList(@PathVariable String headGuid, DatatablePara datatablePara) {
		JsonObject result = new JsonObject();
		JsonArray data = new JsonArray();
		JsonObject dataObj = null;
		result.addProperty("draw", datatablePara.getDraw());
		result.addProperty("recordsTotal", this.invtListService.countInvtList(headGuid));
		int pageNum = datatablePara.getStart() / datatablePara.getLength() + 1;
		PageHelper.startPage(pageNum, datatablePara.getLength());
		PageInfo<InvtList> pageInfo = new PageInfo<InvtList>(this.invtListService.getInvtListListBySearchText(headGuid, datatablePara.getSearch().get("value")));
		result.addProperty("recordsFiltered", pageInfo.getTotal());
		List<InvtList> invtListList = pageInfo.getList();
		
		if (null != invtListList && !invtListList.isEmpty()) {
			for (InvtList il : invtListList) {
				dataObj = new JsonObject();
				dataObj.addProperty("gNum", il.getGNum());
				dataObj.addProperty("gName", il.getGName());
				dataObj.addProperty("gCode", il.getGCode());
				dataObj.addProperty("itemRecordNo", il.getItemRecordNo());
				dataObj.addProperty("itemNo", il.getItemNo());
				dataObj.addProperty("qty", il.getQty());
				dataObj.addProperty("unit", ParaTool.getUnitDesc(il.getUnit(), this.unitService) + "[" + il.getUnit() + "]");
				dataObj.addProperty("price", il.getPrice());
				dataObj.addProperty("totalPrice", il.getTotalPrice());
				dataObj.addProperty("currency", ParaTool.getCurrDesc(il.getCurrency(), this.currService) + "[" + il.getCurrency() + "]");
				dataObj.addProperty("country", ParaTool.getCountryDesc(il.getCountry(), this.countryService) + "[" + il.getCountry() + "]");
				
				data.add(dataObj);
			}
		}
		result.add("data", data);
		return result.toString();
	}
	
	@RequestMapping("download")
	public ResponseEntity<byte[]> download() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", "README.md");
		File file = new File("README.md");
		System.out.println(file.getAbsolutePath());
		System.out.println(this.getClass().getResource(""));
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}
	
	@RequestMapping("/statistics")
	public ModelAndView statistics(InvtHeadStatistics invtHeadStatistics) {
		PageInfo<InvtHeadStatistics> pageInfo = this.getPageInfo(invtHeadStatistics, InvtHeadStatistics.class, this.invtHeadStatisticsService, "statisticsInvtHeadQuantity");
		ModelAndView mv = this.buildBaseModelAndView("invts/statistics", pageInfo);
		final Map<String, String> groupFieldMap = new LinkedHashMap<String, String>(){{
			this.put("cih.ebc_name", "电商企业");
			this.put("cih.agent_name", "报关企业");
			this.put("cih.logistics_name", "物流企业");
			this.put("cih.area_name", "区内企业");
			this.put("coh.pay_name", "支付企业");
			this.put("clh.trade_name", "仓储企业");
			this.put("cih.app_status", "业务状态");
			this.put("cih.customs_code", "海关关区");
			this.put("cih.trade_mode", "贸易方式");
			this.put("cih.ems_no", "账册");
			this.put("cih.port_code", "进口口岸");
			this.put("cih.buyer_id_number", "订购人证件号");
			this.put("cih.buyer_name", "订购人名称");
			this.put("to_char(cih.sys_date, 'yyyy-mm-dd hh:mi')", "按分钟");
			this.put("to_char(cih.sys_date, 'yyyy-mm-dd hh')", "按小时");
			this.put("to_char(cih.sys_date, 'yyyy-mm-dd')", "按天");
			this.put("to_char(cih.sys_date, 'yyyy-mm')", "按月");
			this.put("to_char(cih.sys_date, 'yyyy')", "按年");
		}};
		mv.addObject("invtHeadStatistics", invtHeadStatistics);
		mv.addObject("invtHeadStatisticsList", pageInfo.getList());
		mv.addObject("appStatus", InvtHeadConstant.getAPP_STATUS_MAP());
		mv.addObject("distStatus", InvtHeadConstant.getDIST_STATUS_MAP());
		mv.addObject("groupFieldMap", groupFieldMap);
		mv.addObject("groupFiledMapTwo", new LinkedHashMap<String, String>(){{
			this.put("", "无");
			this.putAll(groupFieldMap);
		}});
		mv.addObject("declareStatus", new HashMap<String, String>(){{
			this.put("", "所有");
			this.put("1", "待申报");
			this.put("2", "已申报");
		}});
		mv.addObject("customsCodeMap", CommonConstant.getZBXC_CUSTOMS_MAP());
		mv.addObject("distinctMap", new LinkedHashMap<String, String>(){{
			this.put("", "不去重复");
			this.put("1", "按电商及订单号去重");
		}});
		mv.addObject("tradeModeMap", new LinkedHashMap<String, String>(){{
			this.put("", "所有方式");
			this.put("1210", "保税电商");
			this.put("9610", "电子商务");
		}});
		return mv;
	}
	
	@RequestMapping
	public ModelAndView index(InvtHead invtHead) {
		if (null != invtHead && !StringUtils.isEmpty(invtHead.getApplyCode())) {
			invtHead.setCopNoList(this.impInvtHeadService.getCopNoList(invtHead.getApplyCode()));
		}
		
		PageInfo<InvtHead> pageInfo = this.getPageInfo(invtHead, InvtHead.class, this.invtHeadService, "getInvtHeadList");
		ModelAndView mv = this.buildBaseModelAndView("invts/list", pageInfo);
		
		mv.addObject("invtHead", invtHead);
		mv.addObject("invtHeadList", pageInfo.getList());
		mv.addObject("appStatus", InvtHeadConstant.getAPP_STATUS_MAP());
		mv.addObject("appStatusJson", new Gson().toJson(InvtHeadConstant.getAPP_STATUS_MAP()));
		mv.addObject("auditStatusJson", new Gson().toJson(InvtHeadConstant.getAUDIT_STATE_MAP()));
		mv.addObject("distStatus", InvtHeadConstant.getDIST_STATUS_MAP());
		mv.addObject("declareStatus", new HashMap<String, String>(){{
			this.put("", "所有");
			this.put("1", "待申报");
			this.put("2", "已申报");
		}});
		mv.addObject("customsCodeMap", CommonConstant.getZBXC_CUSTOMS_MAP());
		mv.addObject("distinctMap", new LinkedHashMap<String, String>(){{
			this.put("", "不去重复");
			this.put("1", "按电商及订单号去重");
		}});
		mv.addObject("tradeModeMap", new LinkedHashMap<String, String>(){{
			this.put("", "所有方式");
			this.put("1210", "保税电商");
			this.put("9610", "电子商务");
		}});
		return mv;
	}
}
