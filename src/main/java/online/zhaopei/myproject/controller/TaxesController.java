package online.zhaopei.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import online.zhaopei.myproject.constant.CommonConstant;
import online.zhaopei.myproject.domain.ecssent.TaxHead;
import online.zhaopei.myproject.service.ecssent.TaxHeadService;

@Controller
@RequestMapping("/taxes")
public class TaxesController extends BaseController {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1134904697664104711L;

	@Autowired
	private TaxHeadService taxHeadService;
	
	@RequestMapping
	public ModelAndView index(TaxHead taxHead) {
		PageInfo<TaxHead> pageInfo = this.getPageInfo(taxHead, TaxHead.class, this.taxHeadService, "getTaxHeadList");
		ModelAndView mv = this.buildBaseModelAndView("taxes/list", pageInfo);
		mv.addObject("taxHead", taxHead);
		mv.addObject("taxHeadList", pageInfo.getList());
		mv.addObject("customsCodeMap", CommonConstant.getZBXC_CUSTOMS_MAP());
		return mv;
	}
}
