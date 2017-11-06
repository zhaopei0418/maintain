package online.zhaopei.myproject.controller;

import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import online.zhaopei.myproject.constant.PersonalInfoConstant;
import online.zhaopei.myproject.domain.gjent.PersonalInfo;
import online.zhaopei.myproject.service.gjent.PersonalInfoService;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/persons")
public class PersonsController extends BaseController {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1247933637170790663L;

	@Autowired
	private PersonalInfoService personalInfoService;
	
	@RequestMapping
	public ModelAndView index(PersonalInfo personalInfo) {
		PageInfo<PersonalInfo> pageInfo = this.getPageInfo(personalInfo, PersonalInfo.class, this.personalInfoService, "getPersonalInfoList");
		ModelAndView mv = this.buildBaseModelAndView("persons/list", pageInfo);
		mv.addObject("personalInfo", personalInfo);
		mv.addObject("personalInfoList", pageInfo.getList());
		mv.addObject("checkFlag", PersonalInfoConstant.getCHECK_FLAG_MAP());
		return mv;
	}

	@RequestMapping("/statistics")
	public ModelAndView statistics(PersonalInfo personalInfo) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    if (null == personalInfo) {
	    	personalInfo = new PersonalInfo();
		}

		if (StringUtils.isEmpty(personalInfo.getGroupOne())) {
			personalInfo.setGroupOne("to_char(pil1.sys_date, 'yyyy-mm-dd')");
			personalInfo.setSysDateStr(sdf.format(Calendar.getInstance().getTime()));
		}
		final Map<String, String> groupField = new LinkedHashMap<String, String>(){{
			this.put("to_char(pil1.sys_date, 'yyyy-mm-dd hh')", "按小时");
			this.put("to_char(pil1.sys_date, 'yyyy-mm-dd')", "按天");
			this.put("to_char(pil1.sys_date, 'yyyy-mm')", "按月");
			this.put("to_char(pil1.sys_date, 'yyyy')", "按年");
		}};
		PageInfo<PersonalInfo> pageInfo = this.getPageInfo(personalInfo, PersonalInfo.class, this.personalInfoService, "statisticsPersonalInfo");
		ModelAndView mv = this.buildBaseModelAndView("persons/statistics", pageInfo);
		mv.addObject("personalInfo", personalInfo);
		mv.addObject("personalInfoList", pageInfo.getList());
		mv.addObject("groupField", groupField);
		return mv;
	}

	@RequestMapping("/reAuthentication")
	public ModelAndView reAuthentication(String uuid) {
		this.personalInfoService.clearErrorCount(uuid);
		return new ModelAndView("redirect:");
	}
}
