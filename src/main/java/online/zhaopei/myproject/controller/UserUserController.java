package online.zhaopei.myproject.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;

import online.zhaopei.myproject.domain.ecssent.UserUser;
import online.zhaopei.myproject.domain.gjent.PersonalInfo;
import online.zhaopei.myproject.domain.para.Customs;
import online.zhaopei.myproject.service.ecssent.UserUserService;
import online.zhaopei.myproject.service.gjent.PersonalInfoService;
import online.zhaopei.myproject.service.para.CustomsService;

@RestController
public class UserUserController implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 9021376358241713298L;

	@Autowired
	private UserUserService userUserService;
	
	@Autowired
	private CustomsService customsService;
	
	@Autowired
	private PersonalInfoService personalInfoService;
	
	@RequestMapping("/user/getAllUsers")
	public List<UserUser> getAllUsers() {
		PageHelper.startPage(1, 5);
		return this.userUserService.getAllUsers();
	}
	
	@RequestMapping("/customs/getCustomsByCode/{code}")
	public Customs getCustomsByCode(@PathVariable("code") String code) {
		return this.customsService.getCustomsByCode(code);
	}
	
	@RequestMapping("/personal/getPersonalById/{id}")
	public PersonalInfo getPersonalById(@PathVariable("id") String id) {
		return this.personalInfoService.getPersonById(id);
	}
}
