package online.zhaopei.myproject.controller;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;

import online.zhaopei.myproject.domain.ecssent.InvtHead;
import online.zhaopei.myproject.domain.ecssent.ServerSystem;
import online.zhaopei.myproject.service.ecssent.InvtHeadService;
import online.zhaopei.myproject.service.ecssent.ServerSystemService;

@Controller
@RequestMapping("/")
public class ApplicationController implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5265049346336029926L;

	@Autowired
	private InvtHeadService invtHeadService;
	
	@Autowired
	private ServerSystemService serverSystemService;
	
	@RequestMapping
	public ModelAndView index() {
		InvtHead invtHead = new InvtHead();
		ModelAndView mv = new ModelAndView("index");
		PageHelper.startPage(1, 10);
		List<InvtHead> invtHeadCountList = this.invtHeadService.getDeclareTopTenSql(invtHead);
		List<ServerSystem> serverSystemList = this.serverSystemService.getServerSystemList(new ServerSystem());
		PageHelper.startPage(1, 10);
		invtHead.setAppStatus("800");
		Long dayCount = 0L, weekCount = 0L, monthCount = 0L, yearCount = 0L;
		Long preDayCount = 0L, preWeekCount = 0L, preMonthCount = 0L, preYearCount = 0L;
		DecimalFormat df = new DecimalFormat("#.##");
		
		List<InvtHead> invtHeadReleaseList = this.invtHeadService.getDeclareTopTenSql(invtHead);
		mv.addObject("invtHeadCountList", invtHeadCountList);
		mv.addObject("invtHeadReleaseList", invtHeadReleaseList);
		
		dayCount = this.invtHeadService.getInvtHeadCount("d");
		weekCount = this.invtHeadService.getInvtHeadCount("w");
		monthCount = this.invtHeadService.getInvtHeadCount("m");
		yearCount = this.invtHeadService.getInvtHeadCount("y");
		
		preDayCount = this.invtHeadService.getInvtHeadCount("pd");
		preWeekCount = this.invtHeadService.getInvtHeadCount("pw");
		preMonthCount = this.invtHeadService.getInvtHeadCount("pm");
		preYearCount = this.invtHeadService.getInvtHeadCount("py");
		
		mv.addObject("dayCount", dayCount);
		mv.addObject("weekCount", weekCount);
		mv.addObject("monthCount", monthCount);
		mv.addObject("yearCount", yearCount);
		
		mv.addObject("preDayCount", preDayCount);
		mv.addObject("preWeekCount", preWeekCount);
		mv.addObject("preMonthCount", preMonthCount);
		mv.addObject("preYearCount", preYearCount);
		
		mv.addObject("fromDay", 0L == preDayCount ? 0 : Double.valueOf(df.format((Double.valueOf(dayCount) - Double.valueOf(preDayCount)) / Double.valueOf(preDayCount) * 100)));
		mv.addObject("fromWeek", 0L == preWeekCount ? 0 : Double.valueOf(df.format((Double.valueOf(dayCount) - Double.valueOf(preWeekCount)) / Double.valueOf(preWeekCount) * 100)));
		mv.addObject("fromMonth", 0L == preMonthCount ? 0 : Double.valueOf(df.format((Double.valueOf(dayCount) - Double.valueOf(preMonthCount)) / Double.valueOf(preMonthCount) * 100)));
		mv.addObject("fromYear", 0L == preYearCount ? 0 : Double.valueOf(df.format((Double.valueOf(dayCount) - Double.valueOf(preYearCount)) / Double.valueOf(preYearCount) * 100)));
		
		mv.addObject("serverSystemList", serverSystemList);

		return mv;
	}
}
