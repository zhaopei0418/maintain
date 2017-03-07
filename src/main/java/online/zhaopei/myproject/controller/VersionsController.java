package online.zhaopei.myproject.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import online.zhaopei.myproject.constant.VersionConstant;
import online.zhaopei.myproject.domain.ecssent.Version;
import online.zhaopei.myproject.service.ecssent.VersionService;

@Controller
@RequestMapping("/versions")
public class VersionsController extends BaseController {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5324133906838908474L;

	@Autowired
	private VersionService versionService;
	
	@GetMapping("new")
	public ModelAndView newVersion() {
		ModelAndView mv = new ModelAndView("versions/form");
		mv.addObject("version", new Version());
		mv.addObject("baseSystem", VersionConstant.getBASE_SYSTEM_MAP());
		return mv;
	}
	
	@PostMapping("new")
	public ModelAndView create(Version version) {
		this.versionService.insertVersion(version);
		return new ModelAndView("redirect:");
	}
	
	@GetMapping("update/{code}")
	public ModelAndView update(@PathVariable(name = "code") String code) {
		ModelAndView mv = new ModelAndView("versions/form");
		mv.addObject("version", this.versionService.getVersionByCode(code));
		mv.addObject("baseSystem", VersionConstant.getBASE_SYSTEM_MAP());
		return mv;
	}
	
	@PostMapping("update/{code}")
	public ModelAndView update(@PathVariable(name = "code") String code, Version version) {
		this.versionService.updateVersion(version);
		return new ModelAndView("redirect:/versions");
	}
	
	@RequestMapping
	public ModelAndView index(Version version) {
		PageInfo<Version> pageInfo = this.getPageInfo(version, Version.class, this.versionService, "getVersionList");
		ModelAndView mv = this.buildBaseModelAndView("versions/list", pageInfo);
		mv.addObject("version", version);
		mv.addObject("versionList", pageInfo.getList());
		mv.addObject("trueFalseMap", new HashMap<String, String>() {{
			this.put("", "所有");
			this.put("1", "是");
			this.put("0", "否");
		}});
		mv.addObject("passMap", new HashMap<String, String>() {{
			this.put("", "所有");
			this.put("1", "通过");
			this.put("0", "不通过");
		}});
		mv.addObject("baseSystem", VersionConstant.getBASE_SYSTEM_MAP());
		return mv;
	}
}
