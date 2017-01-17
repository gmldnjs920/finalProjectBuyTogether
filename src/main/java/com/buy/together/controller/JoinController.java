package com.buy.together.controller;

import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class JoinController {
   
   @Inject
   private static final Logger logger = LoggerFactory.getLogger(JoinController.class);

   //회원가입
   @RequestMapping(value ="/join", method = RequestMethod.GET)
   public String requestJoin(Locale locale, Model model) throws Exception {

      System.out.println("user/join");
      logger.info("Welcome home! The client locale is {}.", locale);

      return "/views/user/join";
      
   }

}