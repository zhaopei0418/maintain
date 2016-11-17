package online.zhaopei.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import online.zhaopei.myproject.common.tool.ParaTool;
import online.zhaopei.myproject.domain.ecssent.VeHead;
import online.zhaopei.myproject.service.ecssent.VeHeadService;
import online.zhaopei.myproject.service.para.CustomsService;

@Controller
@RequestMapping("/vehicles")
public class VehiclesController extends BaseController {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1247933637170790663L;

	@Autowired
	private VeHeadService veHeadService;
	
	@Autowired
	private CustomsService customsService;
	
	@GetMapping("/{veNo}")
	@ResponseBody
	public VeHead getVeHeadByVeNo(@PathVariable String veNo) {
		 VeHead veHead = this.veHeadService.getVeHeadByVeNo(veNo);
		 return null == veHead ? new VeHead() : veHead;
	}
	
	@RequestMapping
	public ModelAndView index(VeHead veHead) {
		PageInfo<VeHead> pageInfo = this.getPageInfo(veHead, VeHead.class, this.veHeadService, "getVeHeadList");
		ModelAndView mv = this.buildBaseModelAndView("vehicles/list", pageInfo);
		mv.addObject("veHead", veHead);
		mv.addObject("veHeadList", pageInfo.getList());
		mv.addObject("customsCodeMap", ParaTool.getAllCustoms(this.customsService));
		
		return mv;
	}
}
