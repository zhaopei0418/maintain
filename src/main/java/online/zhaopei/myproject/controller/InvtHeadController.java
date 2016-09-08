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

import online.zhaopei.myproject.constant.InvtHeadConstant;
import online.zhaopei.myproject.domain.ecssent.InvtHead;
import online.zhaopei.myproject.domain.gjent.ImpInvtHead;
import online.zhaopei.myproject.service.ecssent.InvtHeadService;
import online.zhaopei.myproject.service.gjent.ImpInvtHeadService;

@Controller
@RequestMapping("/invts")
public class InvtHeadController extends BaseController {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8742945481030004154L;

	@Autowired
	private InvtHeadService invtHeadService;
	
	@Autowired
	private ImpInvtHeadService impInvtHeadService;
	
	@GetMapping("/getImpInvtHeadListByInvtNo/{invtNo}")
	@ResponseBody
	public List<ImpInvtHead> getImpInvtHeadListByInvtNo(@PathVariable("invtNo") String invtNo) {
		List<ImpInvtHead> impInvtHeadList = this.impInvtHeadService.getInvtHeadListByInvtNo(invtNo);
		return impInvtHeadList;
	}
	
	@GetMapping("/getImpInvtHeadListByCopNo/{copNo}")
	@ResponseBody
	public List<ImpInvtHead> getImpInvtHeadListByCopNo(@PathVariable("copNo") String copNo) {
		List<ImpInvtHead> impInvtHeadList = this.impInvtHeadService.getInvtHeadListByCopNo(copNo);
		return impInvtHeadList;
	}
	
	@RequestMapping
	public ModelAndView index(InvtHead invtHead) {
		PageInfo<InvtHead> pageInfo = this.getPageInfo(invtHead, InvtHead.class, this.invtHeadService, "getInvtHeadList");
		ModelAndView mv = this.buildBaseModelAndView("invts/list", pageInfo);
		mv.addObject("invtHead", invtHead);
		mv.addObject("invtHeadList", pageInfo.getList());
		mv.addObject("pageInfo", pageInfo);
		mv.addObject("appStatus", InvtHeadConstant.getAPP_STATUS_MAP());
		mv.addObject("appStatusJson", new Gson().toJson(InvtHeadConstant.getAPP_STATUS_MAP()));
		mv.addObject("distStatus", InvtHeadConstant.getDIST_STATUS_MAP());
		return mv;
	}
}
