package online.zhaopei.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import online.zhaopei.myproject.constant.CommonConstant;
import online.zhaopei.myproject.constant.DistsConstant;
import online.zhaopei.myproject.domain.ecssent.DistHead;
import online.zhaopei.myproject.service.ecssent.DistHeadService;
import online.zhaopei.myproject.service.para.CustomsService;
import online.zhaopei.myproject.tool.common.ParaTool;

@Controller
@RequestMapping("/dists")
public class DistsController extends BaseController {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1247933637170790663L;

	@Autowired
	private DistHeadService distHeadService ;
	
	@Autowired
	private CustomsService customsService;
	
	@GetMapping("/{seqNo}")
	public ModelAndView show(@PathVariable String seqNo) {
		ModelAndView mv = new ModelAndView("dists/show");
		mv.addObject("distHead", this.distHeadService.getDistHeadBySeqNo(seqNo));
		mv.addObject("ieFlag", DistsConstant.getI_E_FLAG());
		mv.addObject("ieType", DistsConstant.getI_E_TYPE());
		mv.addObject("distStat", DistsConstant.getDIST_STAT());
		mv.addObject("customsCode", CommonConstant.getZBXC_CUSTOMS_MAP());
		mv.addObject("iePort", ParaTool.getAllCustoms(this.customsService));
		mv.addObject("districtCode", DistsConstant.getDISTRICT_CODE());
		mv.addObject("distType", DistsConstant.getDIST_TYPE());
		mv.addObject("tradeMode", CommonConstant.getZBXC_TRADE_MODE_MAP());
		
		return mv;
	}
	
	@RequestMapping
	public ModelAndView index(DistHead distHead) {
		PageInfo<DistHead> pageInfo = this.getPageInfo(distHead, DistHead.class, this.distHeadService, "getDistHeadList");
		ModelAndView mv = this.buildBaseModelAndView("dists/list", pageInfo);
		mv.addObject("distHead", distHead);
		mv.addObject("distHeadList", pageInfo.getList());
		mv.addObject("ieFlag", DistsConstant.getI_E_FLAG());
		mv.addObject("ieType", DistsConstant.getI_E_TYPE());
		mv.addObject("distStat", DistsConstant.getDIST_STAT());
		mv.addObject("customsCode", CommonConstant.getZBXC_CUSTOMS_MAP());
		
		return mv;
	}
}
