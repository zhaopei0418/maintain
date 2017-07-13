package online.zhaopei.myproject.controller;

import java.io.File;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;

import online.zhaopei.myproject.config.ApplicationProp;
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
	
	@Autowired
	private ApplicationProp app;
	
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
	
	@RequestMapping("/reissue")
	public ModelAndView reissue(String invtNo) {
		ModelAndView mv = new ModelAndView("invts/reissue");
		String[] invtNos = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String suffix = "BuFaZbq.txt";
		String reissueFileName = null;
		File reissueTmpFile = null;
		File reissueFile = null;
		PrintWriter reissuePw = null;
		if (!StringUtils.isEmpty(invtNo)) {
			try {
				invtNos = invtNo.trim().split(",");
				reissueFileName = sdf.format(Calendar.getInstance().getTime()) + suffix;
				reissueTmpFile = new File(this.app.getReissueTmpDir() + reissueFileName);
				reissueFile = new File(this.app.getReissueDir() + reissueFileName);
				reissuePw = new PrintWriter(reissueTmpFile);
				for (String s : invtNos) {
					reissuePw.println(s.trim());
				}
				reissuePw.flush();
				reissuePw.close();
				reissuePw = null;
				FileUtils.copyFile(reissueTmpFile, reissueFile);
				reissueTmpFile.delete();
				mv.addObject("result", true);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (null != reissuePw) {
					reissuePw.close();
				}
			}
		}
		
		return mv;
	}
}
