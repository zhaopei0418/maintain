package online.zhaopei.myproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;

import online.zhaopei.myproject.constant.DeliveryHeadConstant;
import online.zhaopei.myproject.domain.ecssent.DeliveryHead;
import online.zhaopei.myproject.domain.ecssent.DeliveryList;
import online.zhaopei.myproject.domain.ecssent.InvtDeliveryComparison;
import online.zhaopei.myproject.service.ecssent.DeliveryHeadService;
import online.zhaopei.myproject.service.ecssent.DeliveryListService;
import online.zhaopei.myproject.service.ecssent.InvtDeliveryService;

@Controller
@RequestMapping("/deliveries")
public class DeliveriesController extends BaseController {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8610022445562209367L;

	@Autowired
	private DeliveryHeadService deliveryHeadService;
	
	@Autowired
	private DeliveryListService deliveryListService;
	
	@Autowired
	private InvtDeliveryService invtDeliveryService;
	
	@GetMapping("/{headGuid}/deliveryLists")
	@ResponseBody
	public List<DeliveryList> index(@PathVariable("headGuid") String headGuid) {
		List<DeliveryList> deliveryListList = this.deliveryListService.getDeliveryListByGuid(headGuid);
		return deliveryListList;
	}
	
	@GetMapping("/comparisonDeliveryByLogisticsNo")
	@ResponseBody
	public List<InvtDeliveryComparison> comparisonDeliveryByLogisticsNo(String logisticsCode, String logisticsNo, String headGuid) {
		return this.invtDeliveryService.comparisonDeliveryByLogisticsNo(logisticsCode, logisticsNo, headGuid);
	}
	
	@GetMapping
	public ModelAndView index(DeliveryHead deliveryHead) {
		PageInfo<DeliveryHead> pageInfo = this.getPageInfo(deliveryHead, DeliveryHead.class, this.deliveryHeadService, "getDeliveryHeadList");
		ModelAndView mv = this.buildBaseModelAndView("deliveries/list", pageInfo);
		mv.addObject("deliveryHead", deliveryHead);
		mv.addObject("deliveryHeadList", pageInfo.getList());
		mv.addObject("appStatus", DeliveryHeadConstant.getAPP_STATUS_MAP());
		mv.addObject("appStatusJson", new Gson().toJson(DeliveryHeadConstant.getAPP_STATUS_MAP()));
		return mv;
	}
}
