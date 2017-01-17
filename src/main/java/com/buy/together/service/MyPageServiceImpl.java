package com.buy.together.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.buy.together.dao.MyPageDao;
import com.buy.together.domain.User;
import com.buy.together.dto.MyPageDTO;
import com.buy.together.util.SHA256;

@Service
public class MyPageServiceImpl implements MyPageService {

	@Inject
	private MyPageDao myPageDao;
	SHA256 sha = SHA256.getInsatnce();
	
	//내 정보 조회
	@Override
	public MyPageDTO readMyPage(int user_number) throws Exception {

		MyPageDTO user =  myPageDao.read(user_number);
		List<Integer> interest = myPageDao.readInterest(user_number);

		if(interest.size() != 0) {
			
			user.setCategory_number(interest);
			
		}
		
		return user;

	}

	//현재 비밀번호 조회 및 비밀번호 수정
	@Override
	public String updatePassword(String[] user_info) throws Exception {
		
		String result = "fail";
		String shaPass = sha.getSha256(user_info[1].getBytes());
		
		User user = new User();
		user.setUser_number(Integer.parseInt(user_info[0]));        
        user.setPw(shaPass);

		String password = myPageDao.readPassword(user);

		if(password != null) { //비밀번호가 일치한다면,
			
			shaPass = sha.getSha256(user_info[2].getBytes());
			user.setPw(shaPass);
			myPageDao.updatePassword(user);
			result = "success";
			
		}
		
		return result;
		
	}

	//연락처 중복확인 및 연락처 수정
	@Override
	public String updatePhoneNumber(String[] user_info) throws Exception {
		
		String result = "fail";

		String phone_number = myPageDao.readPhoneNumber(user_info[1]);

		if(phone_number == null) { //이미 사용중인 연락처가 아니라면,
			
			User user = new User();
			user.setUser_number(Integer.parseInt(user_info[0]));        
	        user.setPhone_number((user_info[1]));
	        myPageDao.updatePhoneNumber(user);
			result = "success";
			
		}
		
		return result;
		
	}
	
	//이메일 중복확인 및 이메일 수정 
	@Override
	public String updateEmail(String[] user_info) throws Exception {
		
		String result = "fail";

		String email = myPageDao.readEmail(user_info[1]);

		if(email == null) { //이미 사용중인 이메일이 아니라면,
			
			User user = new User();
			user.setUser_number(Integer.parseInt(user_info[0]));        
	        user.setEmail(user_info[1]);
	        myPageDao.updateEmail(user);
			result = "success";
			
		}
		
		return result;
		
	}
	
	//관심 카테고리 수정
	@Override
	public void updateInterest(int user_number, String[] interest) throws Exception {
		
		MyPageDTO user = new MyPageDTO();
		
		myPageDao.deleteInterest(user_number);
		
		for(int i=0; i<interest.length; i++) {
						
			user.setUser_number(user_number);
			user.setInterest(Integer.parseInt(interest[i]));
			myPageDao.createInterest(user);
			
		}
		
	}

	//관심 지역 수정
	@Override
	public void updateAddress(String[] user_info) throws Exception {
		
		MyPageDTO user = new MyPageDTO();
		user.setUser_number(Integer.parseInt(user_info[0]));
		user.setUser_sido(user_info[1]);
		user.setUser_sigungu(user_info[2]);
		
		myPageDao.updateAddress(user);
		
	}

}
