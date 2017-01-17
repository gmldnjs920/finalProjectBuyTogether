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

import com.buy.together.dto.MyPageDTO;
import com.buy.together.dto.UserDTO;
import com.buy.together.service.MyPageService;

@RestController
@RequestMapping("/restMyPage")
public class MyPageRestController {

	private static final Logger logger = LoggerFactory.getLogger(MyPageRestController.class);

	@Inject
	private MyPageService myPageService;

	//내 정보 조회
	@RequestMapping(value="/read", method = RequestMethod.POST)
	public ResponseEntity<MyPageDTO> requestReadMyPage(String user_number) {
		
		ResponseEntity<MyPageDTO> entity = null;
		MyPageDTO user = null;
		
		try {
			user = myPageService.readMyPage(Integer.parseInt(user_number));
			entity = new ResponseEntity<MyPageDTO>(user, HttpStatus.OK); // HttpStatus.OK == 200
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<MyPageDTO>(user, HttpStatus.BAD_REQUEST); // HttpStatus.BAD_REQUEST == 400
		}
		
		return entity;
		
	}
	
	//현재 비밀번호 체크 및 비밀번호 수정
	@RequestMapping(value="/updatePassword", method = RequestMethod.POST)
	public ResponseEntity<String> requestUpdatePassword(String[] user_info) {
		
		ResponseEntity<String> entity = null;
		String result = null;
		
		try {
			result = myPageService.updatePassword(user_info);
			entity = new ResponseEntity<String>(result, HttpStatus.OK); // HttpStatus.OK == 200
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(result, HttpStatus.BAD_REQUEST); // HttpStatus.BAD_REQUEST == 400
		}

		return entity;
		
	}
	
	//현재 연락처 체크 및 연락처 수정
	@RequestMapping(value="/updatePhoneNumber", method = RequestMethod.POST)
	public ResponseEntity<String> requestUpdatePhoneNumber(String[] user_info) {
		
		ResponseEntity<String> entity = null;
		String result = null;

		try {
			result = myPageService.updatePhoneNumber(user_info);
			entity = new ResponseEntity<String>(result, HttpStatus.OK); // HttpStatus.OK == 200
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(result, HttpStatus.BAD_REQUEST); // HttpStatus.BAD_REQUEST == 400
		}

		return entity;
		
	}
	
	//현재 이메일 체크 및 이메일 수정
	@RequestMapping(value="/updateEmail", method = RequestMethod.POST)
	public ResponseEntity<String> requestUpdateEmail(String[] user_info) {
		
		ResponseEntity<String> entity = null;
		String result = null;
		
		try {
			result = myPageService.updateEmail(user_info);
			entity = new ResponseEntity<String>(result, HttpStatus.OK); // HttpStatus.OK == 200
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(result, HttpStatus.BAD_REQUEST); // HttpStatus.BAD_REQUEST == 400
		}

		return entity;
		
	}
	
	//현재 관심 카테고리 체크 및 관심 카테고리 수정
	@RequestMapping(value="/updateInterest", method = RequestMethod.POST)
	public ResponseEntity<String> requestUpdateInterest(String user_number, String[] interest) {
		
		ResponseEntity<String> entity = null;

		try {
			myPageService.updateInterest(Integer.parseInt(user_number), interest);
			entity = new ResponseEntity<String>("success", HttpStatus.OK); // HttpStatus.OK == 200
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST); // HttpStatus.BAD_REQUEST == 400
		}

		return entity;
		
	}
	
	//현재 관심 지역 체크 및 관심 지역 수정
	@RequestMapping(value="/updateAddress", method = RequestMethod.POST)
	public ResponseEntity<String> requestUpdateAddress(String[] user_info) {
		
		ResponseEntity<String> entity = null;

		try {
			myPageService.updateAddress(user_info);
			entity = new ResponseEntity<String>("success", HttpStatus.OK); // HttpStatus.OK == 200
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST); // HttpStatus.BAD_REQUEST == 400
		}

		return entity;
		
	}

}