package online.zhaopei.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;

import online.zhaopei.myproject.constant.DeliveryHeadConstant;
import online.zhaopei.myproject.domain.ecssent.OrderHead;
import online.zhaopei.myproject.service.ecssent.OrderHeadService;

@Controller
@RequestMapping("/orders")
public class OrdersController extends BaseController {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1247933637170790663L;

	@Autowired
	private OrderHeadService orderHeadService;
	
	@RequestMapping
	public ModelAndView index(OrderHead orderHead) {
		PageInfo<OrderHead> pageInfo = this.getPageInfo(orderHead, OrderHead.class, this.orderHeadService, "getOrderHeadList");
		ModelAndView mv = this.buildBaseModelAndView("orders/list", pageInfo);
		mv.addObject("orderHead", orderHead);
		mv.addObject("orderHeadList", pageInfo.getList());
		mv.addObject("appStatus", DeliveryHeadConstant.getAPP_STATUS_MAP());
		mv.addObject("appStatusJson", new Gson().toJson(DeliveryHeadConstant.getAPP_STATUS_MAP()));
		return mv;
	}
}
