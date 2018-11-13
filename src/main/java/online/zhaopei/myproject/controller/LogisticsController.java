package online.zhaopei.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;

import online.zhaopei.myproject.constant.CommonConstant;
import online.zhaopei.myproject.constant.DeliveryHeadConstant;
import online.zhaopei.myproject.domain.ecssent.LgsHead;
import online.zhaopei.myproject.service.ecssent.LgsHeadService;

import java.util.Calendar;

@Controller
@RequestMapping("/logistics")
public class LogisticsController extends BaseController {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1247933637170790663L;

	@Autowired
	private LgsHeadService lgsHeadService;
	
	@RequestMapping
	public ModelAndView index(LgsHead lgsHead) {
		Calendar calendar = null;
		if (StringUtils.isEmpty(lgsHead.getBeginSysDate())) {
			calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_MONTH, -7);
			lgsHead.setBeginSysDate(CommonConstant.DATE_FORMAT.format(calendar.getTime()));
		}

		if (StringUtils.isEmpty(lgsHead.getEndSysDate())) {
			calendar = Calendar.getInstance();
			lgsHead.setEndSysDate(CommonConstant.DATE_FORMAT.format(calendar.getTime()));
		}

		PageInfo<LgsHead> pageInfo = this.getPageInfo(lgsHead, LgsHead.class, this.lgsHeadService, "getLgsHeadList");
		ModelAndView mv = this.buildBaseModelAndView("logistics/list", pageInfo);
		mv.addObject("lgsHead", lgsHead);
		mv.addObject("lgsHeadList", pageInfo.getList());
		mv.addObject("appStatus", DeliveryHeadConstant.getAPP_STATUS_MAP());
		mv.addObject("appType", CommonConstant.getAPP_TYPE_MAP());
		mv.addObject("appStatusJson", new Gson().toJson(DeliveryHeadConstant.getAPP_STATUS_MAP()));
		return mv;
	}
}
