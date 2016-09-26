package online.zhaopei.myproject.controller;

import java.io.File;
import java.io.IOException;
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

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import online.zhaopei.myproject.constant.CommonConstant;
import online.zhaopei.myproject.constant.InvtHeadConstant;
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
import online.zhaopei.myproject.service.para.WrapService;
import online.zhaopei.myproject.tool.common.ParaTool;

@Controller
@RequestMapping("/invts")
public class InvtHeadController extends BaseController {

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
	
	@GetMapping("/{headGuid}")
	public ModelAndView show(@PathVariable("headGuid") String headGuid) {
		ModelAndView mv = new ModelAndView("invts/show");
		InvtHead invtHead = this.invtHeadService.getInvtHeadByHeadGuid(headGuid);
		invtHead.setBuyerIdTypeDesc(CommonConstant.getID_TYPE_MAP().get(invtHead.getBuyerIdType()));
		invtHead.setAppStatusDesc(InvtHeadConstant.getAPP_STATUS_MAP().get(invtHead.getAppStatus()));
		invtHead.setAppTypeDesc(CommonConstant.getAPP_TYPE_MAP().get(invtHead.getAppType()));
		ParaTool paraTool = new ParaTool();
		invtHead.setTradeModeDesc(paraTool.getTradeModeDesc(invtHead.getTradeMode(), this.tradeService));
		invtHead.setCustomsCodeDesc(paraTool.getCustomsDesc(invtHead.getCustomsCode(), this.customsService));
		invtHead.setPortCodeDesc(paraTool.getCustomsDesc(invtHead.getPortCode(), this.customsService));
		invtHead.setCountryDesc(paraTool.getCountryDesc(invtHead.getCountry(), this.countryService));
		invtHead.setCurrencyDesc(paraTool.getCurrDesc(invtHead.getCurrency(), this.currService));
		invtHead.setWrapTypeDesc(paraTool.getWrapDesc(invtHead.getWrapType(), this.wrapService));
		invtHead.setTrafModeDesc(paraTool.getTransfDesc(invtHead.getTrafMode(), this.transfService));

		List<InvtList> invtListList = this.invtListService.getInvtListListByHeadGuid(headGuid);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd kk:mm:ss.SSS").create();
		mv.addObject("invtHead", invtHead);
		mv.addObject("count", invtListList.size());
		mv.addObject("invtListList", invtListList);
		mv.addObject("invtListListJson", gson.toJson(invtListList));
		return mv;
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
		return mv;
	}
	
	@RequestMapping
	public ModelAndView index(InvtHead invtHead) {
		PageInfo<InvtHead> pageInfo = this.getPageInfo(invtHead, InvtHead.class, this.invtHeadService, "getInvtHeadList");
		ModelAndView mv = this.buildBaseModelAndView("invts/list", pageInfo);
		mv.addObject("invtHead", invtHead);
		mv.addObject("invtHeadList", pageInfo.getList());
		mv.addObject("appStatus", InvtHeadConstant.getAPP_STATUS_MAP());
		mv.addObject("appStatusJson", new Gson().toJson(InvtHeadConstant.getAPP_STATUS_MAP()));
		mv.addObject("auditStatusJson", new Gson().toJson(InvtHeadConstant.getAUDIT_STATE_MAP()));
		mv.addObject("distStatus", InvtHeadConstant.getDIST_STATUS_MAP());
		return mv;
	}
}
