package online.zhaopei.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;

import online.zhaopei.myproject.constant.CommonConstant;
import online.zhaopei.myproject.constant.InvtCancelConstant;
import online.zhaopei.myproject.domain.ecssent.InvtCancel;
import online.zhaopei.myproject.service.ecssent.InvtCancelService;

@Controller
@RequestMapping("/invtCancel")
public class InvtCancelController extends BaseController {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6793800871418669419L;

	@Autowired
	private InvtCancelService invtCancelService;
	
	@RequestMapping
	public ModelAndView index(InvtCancel invtCancel) {
		PageInfo<InvtCancel> pageInfo = this.getPageInfo(invtCancel, InvtCancel.class, this.invtCancelService, "getInvtCancelList");
		ModelAndView mv = this.buildBaseModelAndView("invt_cancel/list", pageInfo);
		mv.addObject("invtCancel", invtCancel);
		mv.addObject("invtCancelList", pageInfo.getList());
		mv.addObject("appStatus", InvtCancelConstant.getAPP_STATUS_MAP());
		mv.addObject("appStatusJson", new Gson().toJson(InvtCancelConstant.getAPP_STATUS_MAP()));
		mv.addObject("customsCodeMap", CommonConstant.getCUSTOMS_MAP());
		return mv;
	}
}
