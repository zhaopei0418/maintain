package online.zhaopei.myproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import online.zhaopei.myproject.common.tool.ParaTool;
import online.zhaopei.myproject.constant.CommonConstant;
import online.zhaopei.myproject.constant.DeliveryHeadConstant;
import online.zhaopei.myproject.domain.common.DatatablePara;
import online.zhaopei.myproject.domain.ecssent.OrderHead;
import online.zhaopei.myproject.domain.ecssent.OrderList;
import online.zhaopei.myproject.service.ecssent.OrderHeadService;
import online.zhaopei.myproject.service.ecssent.OrderListService;
import online.zhaopei.myproject.service.para.CurrService;

@Controller
@RequestMapping("/orders")
public class OrdersController extends BaseController {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1247933637170790663L;

	@Autowired
	private OrderHeadService orderHeadService;
	
	@Autowired
	private OrderListService orderListService;
	
	@Autowired
	private CurrService currService;
	
	@RequestMapping
	public ModelAndView index(OrderHead orderHead) {
		PageInfo<OrderHead> pageInfo = this.getPageInfo(orderHead, OrderHead.class, this.orderHeadService, "getOrderHeadList");
		ModelAndView mv = this.buildBaseModelAndView("orders/list", pageInfo);
		mv.addObject("orderHead", orderHead);
		mv.addObject("orderHeadList", pageInfo.getList());
		mv.addObject("appStatus", DeliveryHeadConstant.getAPP_STATUS_MAP());
		mv.addObject("appType", CommonConstant.getAPP_TYPE_MAP());
		mv.addObject("appStatusJson", new Gson().toJson(DeliveryHeadConstant.getAPP_STATUS_MAP()));
		return mv;
	}
	
	@GetMapping("/{headGuid}")
	public ModelAndView show(@PathVariable("headGuid") String headGuid) {
		ModelAndView mv = new ModelAndView("orders/show");
//		InvtHead invtHead = this.invtHeadService.getInvtHeadByHeadGuid(headGuid);
		OrderHead orderHead = this.orderHeadService.getOrderHeadByHeadGuid(headGuid);
		
		mv.addObject("orderHead", orderHead);
		mv.addObject("appType", CommonConstant.getAPP_TYPE_MAP());
		mv.addObject("appStatus", DeliveryHeadConstant.getAPP_STATUS_MAP());
		mv.addObject("currency", ParaTool.getCurrDesc(orderHead.getCurrency(), currService));
		mv.addObject("orderType", CommonConstant.getIE_TYPE_MAP());
//		mv.addObject("distStatus", InvtHeadConstant.getDIST_STATUS_MAP());
//		mv.addObject("customsCode", CommonConstant.getZBXC_CUSTOMS_MAP());
//		mv.addObject("portCode", ParaTool.getAllCustoms(this.customsService));
//		mv.addObject("country", ParaTool.getAllCountries(this.countryService));
//		mv.addObject("tradeMode", CommonConstant.getZBXC_TRADE_MODE_MAP());
		mv.addObject("idType", CommonConstant.getID_TYPE_MAP());
		
		return mv;
	}
	
	@GetMapping("/searchOrderList/{headGuid}")
	@ResponseBody
	public String searchInvtList(@PathVariable String headGuid, DatatablePara datatablePara) {
		JsonObject result = new JsonObject();
		JsonArray data = new JsonArray();
		JsonObject dataObj = null;
		result.addProperty("draw", datatablePara.getDraw());
		result.addProperty("recordsTotal", this.orderListService.countOrderList(headGuid));
		int pageNum = datatablePara.getStart() / datatablePara.getLength() + 1;
		PageHelper.startPage(pageNum, datatablePara.getLength());
		PageInfo<OrderList> pageInfo = new PageInfo<OrderList>(this.orderListService.getOrderListBySearchText(headGuid, datatablePara.getSearch().get("value")));
		result.addProperty("recordsFiltered", pageInfo.getTotal());
		List<OrderList> orderListList = pageInfo.getList();
		
		if (null != orderListList && !orderListList.isEmpty()) {
			for (OrderList ol : orderListList) {
				dataObj = new JsonObject();
//				dataObj.addProperty("gNum", il.getGNum());
//				dataObj.addProperty("gName", il.getGName());
//				dataObj.addProperty("gCode", il.getGCode());
//				dataObj.addProperty("itemRecordNo", il.getItemRecordNo());
//				dataObj.addProperty("itemNo", il.getItemNo());
//				dataObj.addProperty("qty", il.getQty());
//				dataObj.addProperty("unit", ParaTool.getUnitDesc(il.getUnit(), this.unitService) + "[" + il.getUnit() + "]");
//				dataObj.addProperty("price", il.getPrice());
//				dataObj.addProperty("totalPrice", il.getTotalPrice());
//				dataObj.addProperty("currency", ParaTool.getCurrDesc(il.getCurrency(), this.currService) + "[" + il.getCurrency() + "]");
//				dataObj.addProperty("country", ParaTool.getCountryDesc(il.getCountry(), this.countryService) + "[" + il.getCountry() + "]");
				
				data.add(dataObj);
			}
		}
		result.add("data", data);
		return result.toString();
	}
}
