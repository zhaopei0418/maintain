package online.zhaopei.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import online.zhaopei.myproject.constant.InvtHeadConstant;
import online.zhaopei.myproject.domain.ecssent.InvtHead;
import online.zhaopei.myproject.service.ecssent.InvtHeadService;

@Controller
@RequestMapping("/invts")
public class InvtHeadController extends BaseController {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8742945481030004154L;

	@Autowired
	private InvtHeadService invtHeadService;
	
	@RequestMapping
	public ModelAndView index(InvtHead invtHead) {
		PageInfo<InvtHead> pageInfo = this.getPageInfo(invtHead, InvtHead.class, this.invtHeadService, "getInvtHeadList");
		ModelAndView mv = this.buildBaseModelAndView("invts/list", pageInfo);
		mv.addObject("invtHead", invtHead);
		mv.addObject("invtHeadList", pageInfo.getList());
		mv.addObject("pageInfo", pageInfo);
		mv.addObject("appStatus", InvtHeadConstant.getAPP_STATUS_MAP());
		mv.addObject("distStatus", InvtHeadConstant.getDIST_STATUS_MAP());
		return mv;
	}
}
