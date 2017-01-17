package com.buy.together.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/myBuyTogether/*")
public class MyBuyTogetherController {

	private static final Logger logger = LoggerFactory.getLogger(MyBuyTogetherController.class);
	
	@RequestMapping(value ="/myBuyTogether", method = RequestMethod.GET)
	public String mybuy(Locale locale, Model model) {
		
		System.out.println("buyTogetherController");
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "/views/myBuyTogether/myBuyTogether";
	}
}
