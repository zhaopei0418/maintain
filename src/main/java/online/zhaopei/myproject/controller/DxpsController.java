package online.zhaopei.myproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import online.zhaopei.myproject.constant.DxpsConstant;
import online.zhaopei.myproject.domain.ecssent.DxpReceEnd;
import online.zhaopei.myproject.service.ecssent.DxpReceEndService;

@Controller
@RequestMapping("/dxps")
public class DxpsController extends BaseController {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1864137088538469209L;

	@Autowired
	private DxpReceEndService dxpReceEndService;
	
	@RequestMapping("/rece")
	public ModelAndView receIndex(DxpReceEnd dxpReceEnd) {
		PageInfo<DxpReceEnd> pageInfo = this.getPageInfo(dxpReceEnd, DxpReceEnd.class, this.dxpReceEndService, "getDxpReceEndList");
		ModelAndView mv = this.buildBaseModelAndView("dxps/rece_list", pageInfo);
		
		mv.addObject("dxpReceEnd", dxpReceEnd);
		mv.addObject("dxpReceEndList", pageInfo.getList());
		mv.addObject("dxpMode", DxpsConstant.getDXP_MODE_MAP());
		mv.addObject("dxpStatus", DxpsConstant.getDXP_STATUS_MAP());
		mv.addObject("msgType", DxpsConstant.getMSG_TYPE_MAP());
		
		return mv;
	}
}
