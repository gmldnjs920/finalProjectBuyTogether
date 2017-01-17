package com.buy.together.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/mypage")
public class MyPageController {

	private static final Logger logger = LoggerFactory.getLogger(MyPageController.class);

	//내 정보 조회 
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String requestrReadUserInfo() {

		logger.info("mypage");

		return "/views/myPage/myPage";

	}
	
}
