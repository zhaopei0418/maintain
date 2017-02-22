package online.zhaopei.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import online.zhaopei.myproject.constant.CheckMailGoodsConstant;
import online.zhaopei.myproject.constant.CommonConstant;
import online.zhaopei.myproject.constant.InvtHeadConstant;
import online.zhaopei.myproject.domain.ecssent.CheckMailGoodHead;
import online.zhaopei.myproject.service.ecssent.CheckMailGoodHeadService;

@Controller
@RequestMapping("/checkGoods")
public class CheckGoodsController extends BaseController {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 860709274982174737L;

	@Autowired
	private CheckMailGoodHeadService checkMailGoodHeadService;
	
	@RequestMapping
	public ModelAndView index(CheckMailGoodHead checkMailGoodHead) {
		PageInfo<CheckMailGoodHead> pageInfo = this.getPageInfo(checkMailGoodHead, CheckMailGoodHead.class, this.checkMailGoodHeadService, "getCheckMailGoodHeadList");
		ModelAndView mv = this.buildBaseModelAndView("check_goods/list", pageInfo);
		mv.addObject("checkMailGoodHead", checkMailGoodHead);
		mv.addObject("checkMailGoodHeadList", pageInfo.getList());
		mv.addObject("status", InvtHeadConstant.getCUSTOMS_STATUS_MAP());
		mv.addObject("statusInsp", InvtHeadConstant.getAUDIT_STATE_MAP());
		mv.addObject("customsCode", CommonConstant.getZBXC_CUSTOMS_MAP());
		mv.addObject("opType", CheckMailGoodsConstant.getOP_TYPE_MAP());
		mv.addObject("opTypeInsp", CheckMailGoodsConstant.getOP_TYPE_MAP());
		return mv;
	}
}
