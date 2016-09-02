package online.zhaopei.myproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;

import online.zhaopei.myproject.domain.ecssent.UserUser;
import online.zhaopei.myproject.service.ecssent.UserUserService;

@Controller
@RequestMapping("/")
public class ThymeleafController {

	@Autowired
	private UserUserService userUserService;
	
	@GetMapping
	public ModelAndView list() {
		PageHelper.startPage(1, 10);
		List<UserUser> userList = this.userUserService.getAllUsers();
		return new ModelAndView("messages/list", "userList", userList);
	}
}
