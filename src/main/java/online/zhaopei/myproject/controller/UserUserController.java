package online.zhaopei.myproject.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import online.zhaopei.myproject.constant.CommonConstant;
import online.zhaopei.myproject.domain.ecssent.UserUser;
import online.zhaopei.myproject.service.ecssent.UserUserService;

@Controller
@RequestMapping("/users")
public class UserUserController implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 9021376358241713298L;

	@Autowired
	private UserUserService userUserService;

	@GetMapping
	public ModelAndView index(UserUser user) {
		if (null == user) {
			user = new UserUser();
		}
		
		if (null == user.getPageNum() || 0 > user.getPageNum()) {
			user.setPageNum(1);
		}
		
		if (null == user.getPageSize() || 0 >= user.getPageSize()) {
			user.setPageSize(Integer.valueOf(CommonConstant.DEFAULT_PAGE_ZIZE.toString()));;
		}
		
		List<Integer> pageList = new ArrayList<Integer>();
		PageHelper.startPage(user.getPageNum(), user.getPageSize());
		List<UserUser> userList = this.userUserService.getUsers(user);
		PageInfo pageInfo = new PageInfo(userList);
		
		if (5 >= user.getPageNum()) {
			for (int i = 1; i <= pageInfo.getPages(); i++) {
				pageList.add(i);
			}
		} else {
			
		}
		ModelAndView mv = new ModelAndView("users/list");
		mv.addObject("user", user);
		mv.addObject("userList", userList);
		mv.addObject("pageInfo", pageInfo);
		mv.addObject("pageList", pageList);
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
