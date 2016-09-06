package online.zhaopei.myproject.controller;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ApplicationController implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5265049346336029926L;

	@RequestMapping
	public ModelAndView index() {
		return new ModelAndView("forward:/invts");
	}
}
