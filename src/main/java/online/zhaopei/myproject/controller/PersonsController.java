package online.zhaopei.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import online.zhaopei.myproject.constant.PersonalInfoConstant;
import online.zhaopei.myproject.domain.gjent.PersonalInfo;
import online.zhaopei.myproject.service.gjent.PersonalInfoService;

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
	
	@RequestMapping("/reAuthentication")
	public ModelAndView reAuthentication(String uuid) {
		this.personalInfoService.clearErrorCount(uuid);
		return new ModelAndView("redirect:");
	}
}
