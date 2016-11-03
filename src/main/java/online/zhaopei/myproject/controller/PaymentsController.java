package online.zhaopei.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;

import online.zhaopei.myproject.constant.CommonConstant;
import online.zhaopei.myproject.constant.DeliveryHeadConstant;
import online.zhaopei.myproject.domain.ecssent.PayHead;
import online.zhaopei.myproject.service.ecssent.PayHeadService;

@Controller
@RequestMapping("/payments")
public class PaymentsController extends BaseController {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1247933637170790663L;

	@Autowired
	private PayHeadService payHeadService;
	
	@RequestMapping
	public ModelAndView index(PayHead payHead) {
		PageInfo<PayHead> pageInfo = this.getPageInfo(payHead, PayHead.class, this.payHeadService, "getPayHeadList");
		ModelAndView mv = this.buildBaseModelAndView("payments/list", pageInfo);
		mv.addObject("payHead", payHead);
		mv.addObject("payHeadList", pageInfo.getList());
		mv.addObject("appStatus", DeliveryHeadConstant.getAPP_STATUS_MAP());
		mv.addObject("appType", CommonConstant.getAPP_TYPE_MAP());
		mv.addObject("appStatusJson", new Gson().toJson(DeliveryHeadConstant.getAPP_STATUS_MAP()));
		return mv;
	}
}
