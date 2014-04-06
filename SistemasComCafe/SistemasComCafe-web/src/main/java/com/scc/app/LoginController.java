package com.scc.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value = "/login")
	public ModelAndView welcome(ModelMap model) {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	
}
