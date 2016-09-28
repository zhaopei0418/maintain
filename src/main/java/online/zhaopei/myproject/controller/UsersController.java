package online.zhaopei.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import online.zhaopei.myproject.domain.ecssent.UserUser;
import online.zhaopei.myproject.service.ecssent.UserUserService;

@Controller
@RequestMapping("/users")
public class UsersController extends BaseController {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 9021376358241713298L;

	@Autowired
	private UserUserService userUserService;

	@RequestMapping
	public ModelAndView index(UserUser user) {
		PageInfo<UserUser> pageInfo = this.getPageInfo(user, UserUser.class, this.userUserService, "getUsers");
		ModelAndView mv = this.buildBaseModelAndView("users/list", pageInfo);
		mv.addObject("user", user);
		mv.addObject("userList", pageInfo.getList());
		mv.addObject("pageInfo", pageInfo);
		return mv;
	}
	
	@GetMapping("/{userId}")
	public ModelAndView show(@PathVariable("userId") String userId) {
		ModelAndView mv = new ModelAndView("users/show");
		UserUser user = this.userUserService.getUserByUserId(userId);
		mv.addObject("user", user);
		return mv;
	}
}
