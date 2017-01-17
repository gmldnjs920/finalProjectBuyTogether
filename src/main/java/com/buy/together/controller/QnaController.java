package com.buy.together.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/qna")
public class QnaController {

	private static final Logger logger = LoggerFactory.getLogger(QnaController.class);

	//qna 목록
	@RequestMapping(value ="", method = RequestMethod.GET)
	public String qnaListAll(Locale locale, Model model) {

		return "/views/qna/qna";
		
	}

	//qna 조회
	@RequestMapping(value ="/read", method = RequestMethod.GET)
	public String qnalistOne(Locale locale, Model model) {

		return "/views/qna/qnaRead";
		
	}
	
	//qna 글쓰기
	@RequestMapping(value ="/write", method = RequestMethod.GET)
	public String qnaInsert(Locale locale, Model model) {

		return "/views/qna/qnaWrite";
		
	}
	
	//qna 수정
	@RequestMapping(value ="/update", method = RequestMethod.GET)
	public String qnaUpdate(Locale locale, Model model) {
		
		return "/views/qna/qnaUpdate";
		
	}
	
}