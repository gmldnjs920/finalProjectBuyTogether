package com.buy.together.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.buy.together.domain.User;
import com.buy.together.service.JoinService;

@RestController
@RequestMapping("/join")
public class JoinRestController {
   
   @Inject
   private JoinService joinService;
   private static final Logger logger = LoggerFactory.getLogger(JoinRestController.class);
   
   //회원가입
   @RequestMapping(value="/regist", method = RequestMethod.POST)
   public ResponseEntity<String> requestRegistUser(@RequestBody User user) {
      
      logger.info("Welcome home! registUser in!");
      ResponseEntity<String> entity = null;

      try {
         joinService.addJoin(user);
         entity = new ResponseEntity<String>("success", HttpStatus.OK);
      } catch (Exception e) {
         e.printStackTrace();
         entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
      }
      
      return entity;
      
   }
   
   //아이디 중복 확인
   @RequestMapping(value = "/idCheck", method=RequestMethod.POST)
   public ResponseEntity<String> requestIdCheck(String id) throws Exception{

      ResponseEntity<String> entity = null;
      String result = null;
      
      try {
         result = joinService.idCheck(id);
         entity = new ResponseEntity<String>(result, HttpStatus.OK);
      } catch (Exception e) {
         e.printStackTrace();
         entity = new ResponseEntity<String>(result, HttpStatus.BAD_REQUEST);
      }
      
      return entity;
      
   }
   
   //닉네임 중복 확인
   @RequestMapping(value = "/nicknameCheck", method=RequestMethod.POST)
   public ResponseEntity<String> requestNicknameCheck(String nickname) throws Exception{

      ResponseEntity<String> entity = null;
      String result = null;
      
      try {
         result = joinService.nicknameCheck(nickname);      
         entity = new ResponseEntity<String>(result, HttpStatus.OK);
      } catch (Exception e) {
         e.printStackTrace();
         entity = new ResponseEntity<String>(result, HttpStatus.BAD_REQUEST);
      }

      return entity;
      
   }
      
   //이메일 중복 확인
   @RequestMapping(value = "/emailCheck", method=RequestMethod.POST)
   public ResponseEntity<String> requestEmailCheck(String email) throws Exception{

      ResponseEntity<String> entity = null;
      String result = null;
      
      try {
         result = joinService.emailCheck(email);
         entity = new ResponseEntity<String>(result, HttpStatus.OK);
      } catch (Exception e) {
         e.printStackTrace();
         entity = new ResponseEntity<String>(result, HttpStatus.BAD_REQUEST);
      }
      
      return entity;
      
   }

}