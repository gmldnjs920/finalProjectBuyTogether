package com.buy.together;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "/views/home";
		
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminHome(Locale locale, Model model) {
		
		return "/views/admin/admin_home";
		
	}
	
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String error(Locale locale, Model model) {
		
		return "/views/include/404page";
		
	}
	
}
