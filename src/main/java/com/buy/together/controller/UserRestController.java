package com.buy.together.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.buy.together.domain.Dip;
import com.buy.together.domain.User;
import com.buy.together.dto.BuyTogetherDTO;
import com.buy.together.dto.UserDTO;
import com.buy.together.service.UserService;
import com.buy.together.util.MailSend;
import com.buy.together.util.RandomString;

@RestController
@RequestMapping("/restUser")
public class UserRestController {

	@Inject
	private UserService userService;	
	private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);

	//닉네임 중복 확인
	@RequestMapping(value="/nicknameCheck", method = RequestMethod.POST)
	public ResponseEntity<String> requestNickNameCheck(String nickname) {

		ResponseEntity<String> entity = null;
		String isExist = null;

		try {
			isExist = userService.checkNickname(nickname);
			entity = new ResponseEntity<String>(isExist, HttpStatus.OK); // HttpStatus.OK == 200
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(isExist, HttpStatus.BAD_REQUEST); // HttpStatus.BAD_REQUEST == 400
		}

		return entity;

	}

	//필수 정보 DB 저장
	@RequestMapping(value="/registBasicInfo", method = RequestMethod.POST)
	public ResponseEntity<String> requestBasicInfo(@RequestBody UserDTO userDTO) {

		ResponseEntity<String> entity = null;

		try {
			userService.registBasicInfo(userDTO);
			entity = new ResponseEntity<String>("success", HttpStatus.OK); // HttpStatus.OK == 200
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST); // HttpStatus.BAD_REQUEST == 400
		}

		return entity;

	}

	//회원 DB 삭제
	@RequestMapping(value="/remove", method = RequestMethod.POST)
	public ResponseEntity<String> requestRemove(@RequestBody User user) {
		
		ResponseEntity<String> entity = null;
		String result = null;

		try {

			if(user.getPw() != null) { //같이사냥 회원 탈퇴라면,

				result = userService.removeBUser(user);

			} else { //페이스북/네이버 회원 탈퇴라면,

				result = userService.removeEUser(user);

			}

			entity = new ResponseEntity<String>(result, HttpStatus.OK); // HttpStatus.OK == 200

		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(result, HttpStatus.BAD_REQUEST); // HttpStatus.BAD_REQUEST == 400
		}

		return entity;

	}

	//내 찜 목록
	@RequestMapping(value = "/myDipList", method = RequestMethod.POST)
	public ResponseEntity<List<BuyTogetherDTO>> requestDipList(Integer user_number) {

		ResponseEntity<List<BuyTogetherDTO>> entity = null;

		try {
			entity = new ResponseEntity<List<BuyTogetherDTO>>(userService.myDipList(user_number), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<BuyTogetherDTO>>(HttpStatus.BAD_REQUEST);
		}

		return entity;

	}

	//선택 찜 DB 저장
	@RequestMapping(value="/registNewDip", method = RequestMethod.POST)
	public ResponseEntity<String> requestNewDip(@RequestBody Dip dip) {

		ResponseEntity<String> entity = null;
		System.out.println(dip);
		try {
			userService.registDip(dip);
			entity = new ResponseEntity<String>("success", HttpStatus.OK); // HttpStatus.OK == 200
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST); // HttpStatus.BAD_REQUEST == 400
		}

		return entity;

	}

	//찜 DB 삭제
	@RequestMapping(value="/removeDip", method = RequestMethod.POST)
	public ResponseEntity<String> requestDipDelete(String user_number, String[] buytogether_numbers) {

		ResponseEntity<String> entity = null;

		try {
			userService.removeDip(Integer.parseInt(user_number), buytogether_numbers);
			entity = new ResponseEntity<String>("success", HttpStatus.OK); // HttpStatus.OK == 200
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST); // HttpStatus.BAD_REQUEST == 400
		}

		return entity;

	}


	@RequestMapping(value="findId", method = RequestMethod.POST)
	public ResponseEntity<String> requestFindId(@RequestBody User user) throws Exception {

		ResponseEntity<String> entity = null;

		try {
			entity = new ResponseEntity<>(userService.findId(user), HttpStatus.OK);


		} catch (Exception e) {

			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
		}

		return entity;

	}

	@ResponseBody
	@RequestMapping(value="findPassword", method = RequestMethod.POST)
	public ResponseEntity<String> requestFindPassword(@RequestBody User user) throws Exception {

		ResponseEntity<String> entity = null;

		User user1 = new User();
		//입력한 유저 정보가 일치하는지 확인
		user1 = userService.findPassword(user);

		if(user1 != null) {

			String email = user1.getEmail();
			/*임시 비밀번호 만들기*/
			RandomString random = new RandomString();
			String randomKey = random.RandomPass();
			
			user1.setPw(randomKey);
			/*임시 비밀번호 발송 후  유저 비밀번호로 변경하기*/
			userService.setPassword(user1);
			
			/*임시 비밀번호와 입력 받은 이메일을 통해 메일 보내기*/
			MailSend mailSend = new MailSend();
			mailSend.sendMail(email, randomKey);
			
			entity = new ResponseEntity<>("success", HttpStatus.OK);

		} else {

			entity = new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

}
