package com.buy.together.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/event")
public class EventController {

	private static final Logger logger = LoggerFactory.getLogger(EventController.class);

	//정보사냥 목록
	@RequestMapping(value ="", method = RequestMethod.GET)
	public String eventlist(Locale locale, Model model) {

		return "/views/event/event";
		
	}

	//정보사냥 조회
	@RequestMapping(value ="/read", method = RequestMethod.GET)
	public String eventlistOne(Locale locale, Model model) {
		
		return "/views/event/eventRead";
		
	}

}