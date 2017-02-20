package online.zhaopei.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import online.zhaopei.myproject.common.tool.ParaTool;
import online.zhaopei.myproject.constant.GoodConstant;
import online.zhaopei.myproject.domain.ecssent.Good;
import online.zhaopei.myproject.service.ecssent.GoodService;
import online.zhaopei.myproject.service.para.CountryService;

@Controller
@RequestMapping("/goods")
public class GoodsController extends BaseController {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2966447781818617131L;

	@Autowired
	private GoodService goodService;
	
	@Autowired
	private CountryService countryService;
	
	@RequestMapping
	public ModelAndView index(Good good) {
		PageInfo<Good> pageInfo = this.getPageInfo(good, Good.class, this.goodService, "getGoodList");
		ModelAndView mv = this.buildBaseModelAndView("goods/list", pageInfo);
		mv.addObject("good", good);
		mv.addObject("goodList", pageInfo.getList());
		mv.addObject("status", GoodConstant.getSTATUS());
		mv.addObject("country", ParaTool.getAllCountries(countryService));
		return mv;
	}
}
