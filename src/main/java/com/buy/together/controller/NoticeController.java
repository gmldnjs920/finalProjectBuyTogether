package com.buy.together.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/notice")
public class NoticeController {
   
   @Inject
   private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

   @RequestMapping(value ="/list", method = RequestMethod.GET)
   public String requestNoticeList() throws Exception {

	   logger.info("listView");
      return "/views/customerCenter/noticeList";
      
   }
   
   //공지사항 쓰기
   @RequestMapping(value ="/write", method = RequestMethod.GET)
   public String requestNoticeWrite() throws Exception {

	   logger.info("writeView");
      return "/views/customerCenter/noticeWrite";
      
   }

   //공지사항 쓰기
   @RequestMapping(value ="/noticeReadOne", method = RequestMethod.GET)
   public String requestNoticeReadOne() throws Exception {

	   logger.info("readView");
      return "/views/customerCenter/noticeRead";
      
   }
}