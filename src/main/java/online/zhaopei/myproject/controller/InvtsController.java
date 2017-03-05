package online.zhaopei.myproject.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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
import online.zhaopei.myproject.domain.mysystem.ImportBill;
import online.zhaopei.myproject.service.ecssent.DistHeadService;
import online.zhaopei.myproject.service.ecssent.InvtHeadService;
import online.zhaopei.myproject.service.ecssent.InvtHeadStatisticsService;
import online.zhaopei.myproject.service.ecssent.InvtListService;
import online.zhaopei.myproject.service.ecssent.PubRtnService;
import online.zhaopei.myproject.service.gjent.ImpInvtHeadService;
import online.zhaopei.myproject.service.mhin.ImportBillInService;
import online.zhaopei.myproject.service.mhout.ImportBillOutService;
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
	
	@Autowired
	private ImportBillInService importBillInService;
	
	@Autowired
	private ImportBillOutService importBillOutService;
	
	@GetMapping("/getImpInvtHeadListByInvtNo/{invtNo}")
	@ResponseBody
	public List<ImpInvtHead> getImpInvtHeadListByInvtNo(@PathVariable("invtNo") String invtNo) {
		List<ImpInvtHead> impInvtHeadList = this.impInvtHeadService.getInvtHeadListByInvtNo(invtNo);
		return impInvtHeadList;
	}
	
	@GetMapping("/getStatisticsInOutInvtData")
	@ResponseBody
	public String getStatisticsInOutInvtData() {
		InvtHeadStatistics invtHeadStatistics = null;
		SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfYeday = new SimpleDateFormat("yyyy年MM月dd日");
		DecimalFormat df = new DecimalFormat("0.00");
		Calendar calendar = Calendar.getInstance();
		List<InvtHeadStatistics> ihsList = null;
		InvtHeadStatistics ihs = null, ihsYesterday = null;
		ImportBill searchBill = null, resultInBill = null, resultOutBill = null;
		ImportBill resultInBillYesterday = null, resultOutBillYesterday = null;
		Long inYesterdayTotalQuantity = 0L, inTotalQuantity = 0L;
		Double inYesterdayTotalGoodsValue = 0.00, inTotalGoodsValue = 0.00;
		
		invtHeadStatistics =  new InvtHeadStatistics("cih.statistics");
		searchBill = new ImportBill();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		invtHeadStatistics.setEndSysDate(sdfDay.format(calendar.getTime()));
		searchBill.setEndDeclareDate(sdfDay.format(calendar.getTime()));
		invtHeadStatistics.setSubtotal(false);
		ihsList = this.invtHeadStatisticsService.statisticsInvtHeadQuantity(invtHeadStatistics);
		resultInBill = this.importBillInService.statisticsBill(searchBill);
		resultOutBill = this.importBillOutService.statisticsBill(searchBill);
		if (null != ihsList && !ihsList.isEmpty()) {
			ihs = ihsList.get(0);
		}
		
		invtHeadStatistics.setSysDateStr(invtHeadStatistics.getEndSysDate());
		invtHeadStatistics.setEndSysDate(null);
		searchBill.setDeclareDateStr(searchBill.getEndDeclareDate());
		searchBill.setEndDeclareDate(null);
		ihsList = this.invtHeadStatisticsService.statisticsInvtHeadQuantity(invtHeadStatistics);
		resultInBillYesterday = this.importBillInService.statisticsBill(searchBill);
		resultOutBillYesterday = this.importBillOutService.statisticsBill(searchBill);
		if (null != ihsList && !ihsList.isEmpty()) {
			ihsYesterday = ihsList.get(0);
		}
		
		inYesterdayTotalQuantity = (null == ihsYesterday ? 0L : ihsYesterday.getQuantity());
		inYesterdayTotalQuantity += (null == resultInBillYesterday ? 0L : resultInBillYesterday.getCount());
		inYesterdayTotalGoodsValue = (null == ihsYesterday ? 0.00 : ihsYesterday.getGoodsValue());
		inYesterdayTotalGoodsValue += (null == resultInBillYesterday || 0 == resultInBillYesterday.getCount() ? 0.00 : resultInBillYesterday.getTotalValueRmb());
		
		inTotalQuantity += (null == ihs ? 0 : ihs.getQuantity());
		inTotalQuantity += (null == resultInBill ? 0 : resultInBill.getCount());
		inTotalGoodsValue += (null == ihs ? 0.00 : ihs.getGoodsValue());
		inTotalGoodsValue += (null == resultInBill || 0 == resultInBill.getCount() ? 0.00 : resultInBill.getTotalValueRmb());
		
		StringBuffer contentBuffer = new StringBuffer("各位领导上午好[微笑]<br/>");
		contentBuffer.append("进口系统:");
		contentBuffer.append(sdfYeday.format(calendar.getTime()));
		contentBuffer.append("跨境电商企业申报清单" + inYesterdayTotalQuantity + "票,货值");
		contentBuffer.append(df.format(inYesterdayTotalGoodsValue / 10000) + "万元。");
		contentBuffer.append("截至目前申报清单" + inTotalQuantity + "票，货值");
		contentBuffer.append(df.format(inTotalGoodsValue / 10000) + "万元");
		
//		contentBuffer.append("<br/>进口过渡版系统:");
//		contentBuffer.append(sdfYeday.format(calendar.getTime()));
//		contentBuffer.append("跨境电商企业申报清单" +  + "票,货值");
//		contentBuffer.append((null == resultInBillYesterday.getTotalValueRmb() ? 0.00 : df.format(resultInBillYesterday.getTotalValueRmb() / 10000)) + "万元。");
//		contentBuffer.append("截至目前申报清单" +  + "票，货值");
//		contentBuffer.append((null == resultInBill.getTotalValueRmb() ? 0.00 : df.format(resultInBill.getTotalValueRmb() / 10000)) + "万元");
		
		contentBuffer.append("<br/>出口系统:");
		contentBuffer.append(sdfYeday.format(calendar.getTime()));
		contentBuffer.append("跨境电商企业申报清单" + (null == resultOutBillYesterday ? 0 : resultOutBillYesterday.getCount()) + "票,货值");
		contentBuffer.append((null == resultOutBillYesterday.getTotalValueRmb() ? 0.00 : df.format(resultOutBillYesterday.getTotalValueRmb() / 10000)) + "万美元。");
		contentBuffer.append("截至目前申报清单" + (null == resultOutBill ? 0 : resultOutBill.getCount()) + "票，货值");
		contentBuffer.append((null == resultOutBill.getTotalValueRmb() ? 0.00 : df.format(resultOutBill.getTotalValueRmb() / 10000)) + "万美元");
		
		return contentBuffer.toString();
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
	
	private String getInvtInfoByFormat(String format) {
		JsonObject result = new JsonObject();
		JsonArray labels = new JsonArray();
		JsonArray datasets = new JsonArray();
		JsonObject dataset = null;
		JsonArray dataCount = new JsonArray();
		JsonArray dataGoodsValue = new JsonArray();
		JsonArray dataGoodsQuantity = new JsonArray();
		JsonArray dataTaxTotal = new JsonArray();
		InvtHeadStatistics tempStatistics = null;
		InvtHeadStatistics invtHeadStatistics = null;
		SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy/MM/dd");
		if ("week".equals(format)) {
			invtHeadStatistics = new InvtHeadStatistics("NEXT_DAY(trunc(cih.sys_date), 2)");
			invtHeadStatistics.setWeekGroup(true);
		} else {
			invtHeadStatistics = new InvtHeadStatistics("to_char(cih.sys_date, '" + format + "')");
		}
		invtHeadStatistics.setSubtotal(false);
		List<InvtHeadStatistics> invtHeadStatisticsList = this.invtHeadStatisticsService.statisticsInvtHeadQuantity(invtHeadStatistics);
		
		if (null != invtHeadStatisticsList && !invtHeadStatisticsList.isEmpty()) {
			for (int i = 0; i < invtHeadStatisticsList.size(); i++) {
				tempStatistics = invtHeadStatisticsList.get(i);
				if ("week".equals(format)) {
					labels.add(sdfDay.format(tempStatistics.getWeekStart()) + " - " + sdfDay.format(tempStatistics.getWeekEnd()));
				} else {
					labels.add(tempStatistics.getName());
				}
				
				dataCount.add(tempStatistics.getQuantity());
				dataGoodsValue.add(tempStatistics.getGoodsValue());
				dataGoodsQuantity.add(tempStatistics.getGoodsTotalQuantity());
				dataTaxTotal.add(tempStatistics.getTaxTotal());
			}
			
			dataset = new JsonObject();
			dataset.addProperty("label", "清单数");
			dataset.addProperty("backgroundColor", "rgba(38, 185, 154, 0.31)");
			dataset.addProperty("borderColor", "rgba(38, 185, 154, 0.7)");
			dataset.addProperty("pointBorderColor", "rgba(38, 185, 154, 0.7)");
			dataset.addProperty("pointBackgroundColor", "rgba(38, 185, 154, 0.7)");
			dataset.addProperty("pointHoverBackgroundColor", "#fff");
			dataset.addProperty("pointHoverBorderColor", "rgba(220,220,220,1)");
			dataset.addProperty("pointBorderWidth", "1");
			dataset.add("data", dataCount);
			datasets.add(dataset);
			
			dataset = new JsonObject();
			dataset.addProperty("label", "货值");
			dataset.addProperty("backgroundColor", "rgba(3, 88, 106, 0.3)");
			dataset.addProperty("borderColor", "rgba(3, 88, 106, 0.70)");
			dataset.addProperty("pointBorderColor", "rgba(3, 88, 106, 0.70)");
			dataset.addProperty("pointBackgroundColor", "rgba(3, 88, 106, 0.70)");
			dataset.addProperty("pointHoverBackgroundColor", "#fff");
			dataset.addProperty("pointHoverBorderColor", "rgba(151,187,205,1)");
			dataset.addProperty("pointBorderWidth", "1");
			dataset.add("data", dataGoodsValue);
			datasets.add(dataset);
			
			dataset = new JsonObject();
			dataset.addProperty("label", "商品数量");
			dataset.addProperty("backgroundColor", "rgba(238, 88, 106, 0.3)");
			dataset.addProperty("borderColor", "rgba(238, 88, 106, 0.70)");
			dataset.addProperty("pointBorderColor", "rgba(238, 88, 106, 0.70)");
			dataset.addProperty("pointBackgroundColor", "rgba(238, 88, 106, 0.70)");
			dataset.addProperty("pointHoverBackgroundColor", "#fff");
			dataset.addProperty("pointHoverBorderColor", "rgba(150,150,150,1)");
			dataset.addProperty("pointBorderWidth", "1");
			dataset.add("data", dataGoodsQuantity);
			datasets.add(dataset);
			
			dataset = new JsonObject();
			dataset.addProperty("label", "税款");
			dataset.addProperty("backgroundColor", "rgba(138, 88, 106, 0.3)");
			dataset.addProperty("borderColor", "rgba(138, 88, 106, 0.70)");
			dataset.addProperty("pointBorderColor", "rgba(138, 88, 106, 0.70)");
			dataset.addProperty("pointBackgroundColor", "rgba(138, 88, 106, 0.70)");
			dataset.addProperty("pointHoverBackgroundColor", "#fff");
			dataset.addProperty("pointHoverBorderColor", "rgba(110,110,110,1)");
			dataset.addProperty("pointBorderWidth", "1");
			dataset.add("data", dataTaxTotal);
			datasets.add(dataset);
		}
		
		result.add("labels", labels);
		result.add("datasets", datasets);
		return result.toString();
	}
	
	@GetMapping("/getDayInvtInfo")
	@ResponseBody
	public String getDayInvtInfo() {
		return this.getInvtInfoByFormat("yyyy-mm-dd");
	}
	
	@GetMapping("/getWeekInvtInfo")
	@ResponseBody
	public String getWeekInvtInfo() {
		return this.getInvtInfoByFormat("week");
	}
	
	@GetMapping("/getMonthInvtInfo")
	@ResponseBody
	public String getMonthInvtInfo() {
		return this.getInvtInfoByFormat("yyyy-mm");
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
//		User user = (User) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
//		System.out.println("111=222=" + user.getUsername());
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
	
	@RequestMapping("export")
	public ResponseEntity<byte[]> export(InvtHead invtHead) throws IOException {
		SimpleDateFormat sdfFileName = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String fileName = "invts_" + sdfFileName.format(Calendar.getInstance().getTime()) + ".csv";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", fileName);
		File file = new File("export/" + fileName);
		PrintWriter writer = null;
		OutputStream output = null;
		List<InvtHead> invtHeadList = this.invtHeadService.exportInvtHeadList(invtHead);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			output = new FileOutputStream(file);
			output.write(CommonConstant.BOM);
			output.close();
			
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8")));
			writer.println("海关清单编号,海关状态,海关回执,回执时间,回执入库时间,国检清单编号,国检状态,国检回执,电商企业,订单编号,物流企业,运单编号,支付企业,支付单编号,主单号,申报日期,总货值,收货人地址,总毛重,总净重,核放单号,核放单状态,过卡口时间");
			for(InvtHead ih : invtHeadList) {
				writer.print(ih.getInvtNo());
				writer.print("," + InvtHeadConstant.getAPP_STATUS_MAP().get(ih.getAppStatus()));
				writer.print(",\"" + ih.getRtnInfo() + "\"");
				writer.print("," + (null == ih.getRtnTime() ? "" : sdf.format(ih.getRtnTime())));
				writer.print("," + (null == ih.getRtnSysDate() ? "" : sdf.format(ih.getRtnSysDate())));
				writer.print("," + ih.getDetailsCode());
				writer.print("," + InvtHeadConstant.getAUDIT_STATE_MAP().get(ih.getAuditState()));
				writer.print(",\"" + ih.getBwName() + "\"");
				writer.print("," + ih.getEbcName());
				writer.print("," + ih.getOrderNo());
				writer.print("," + ih.getLogisticsName());
				writer.print("," + ih.getLogisticsNo());
				writer.print("," + ih.getPayName());
				writer.print("," + ih.getApplyCode());
				writer.print("," + ih.getBillNo());
				writer.print("," + (null == ih.getSysDate() ? "" : sdf.format(ih.getSysDate())));
				writer.print("," + ih.getGoodsValue());
				writer.print(",\"" + ih.getConsigneeAddress() + "\"");
				writer.print("," + ih.getGrossWeight());
				writer.print("," + ih.getNetWeight());
				writer.print("," + ih.getDistNo());
				writer.print("," + InvtHeadConstant.getDIST_STATUS_MAP().get(ih.getDistStat()));
				writer.print("," + (null == ih.getDistTime() ? "" : sdf.format(ih.getDistTime())));
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
}
