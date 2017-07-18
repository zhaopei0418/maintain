package online.zhaopei.myproject.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.google.gson.JsonObject;

import online.zhaopei.myproject.constant.DxpsConstant;
import online.zhaopei.myproject.domain.ecssent.DxpReceEnd;
import online.zhaopei.myproject.domain.ecssent.DxpReceMsg;
import online.zhaopei.myproject.service.ecssent.DxpReceEndService;
import online.zhaopei.myproject.service.ecssent.DxpReceMsgService;

@Controller
@RequestMapping("/dxps")
public class DxpsController extends BaseController {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1864137088538469209L;

	@Autowired
	private DxpReceEndService dxpReceEndService;
	
	@Autowired
	private DxpReceMsgService dxpReceMsgService;
	
	@RequestMapping("/rece")
	public ModelAndView receIndex(DxpReceEnd dxpReceEnd) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (null == dxpReceEnd) {
			dxpReceEnd = new DxpReceEnd();
			dxpReceEnd.setBeginSysDate(sdf.format(Calendar.getInstance().getTime()));
		}
		PageInfo<DxpReceEnd> pageInfo = this.getPageInfo(dxpReceEnd, DxpReceEnd.class, this.dxpReceEndService, "getDxpReceEndList");
		ModelAndView mv = this.buildBaseModelAndView("dxps/rece_list", pageInfo);
		
		mv.addObject("dxpReceEnd", dxpReceEnd);
		mv.addObject("dxpReceEndList", pageInfo.getList());
		mv.addObject("dxpMode", DxpsConstant.getDXP_MODE_MAP());
		mv.addObject("dxpStatus", DxpsConstant.getDXP_STATUS_MAP());
		mv.addObject("msgType", DxpsConstant.getMSG_TYPE_MAP());
		
		return mv;
	}
	
	@GetMapping("/receDetail/{msgGuid}")
	@ResponseBody
	public DxpReceMsg receDetail(@PathVariable("msgGuid") String msgGuid) {
		return this.dxpReceMsgService.getDxpReceMsgByMsgGuid(msgGuid);
	}
}
