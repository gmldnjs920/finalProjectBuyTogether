package com.buy.together.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	//같이사냥 회원 회원탈퇴 화면 호출
	@RequestMapping(value = "/Bsignout", method = RequestMethod.GET)
	public String requestBUserSignout() throws Exception {

		return "/views/user/buyTogetherUserSignout";

	}

	//로그인 화면 호출
	@RequestMapping(value = "/Esignout", method = RequestMethod.GET)
	public String requestEUserSignout() throws Exception {

		return "/views/user/externalUserSignout";

	}

	//내 찜 목록 화면 호출
	@RequestMapping(value ="/myDipList", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {

		System.out.println("user/myDipList");
		logger.info("Welcome home! The client locale is {}.", locale);

		return "/views/user/myDipList";

	}
	
	//아이디 비밀번호 찾기
	@RequestMapping(value="findIdPw", method = RequestMethod.GET)
	public String requestfind(Locale locale, Model model) {
		
		System.out.println("UserController");
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "/views/user/findIdPw";
	}
	

}
