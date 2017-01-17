package com.buy.together;

import java.util.List;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.buy.together.dao.MyPageDao;
import com.buy.together.domain.User;
import com.buy.together.dto.MyPageDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MyPageDaoTest {

	@Inject
	MyPageDao dao;

	@Test
	@Ignore
	public void testRead() throws Exception {
		
		int user_number = 1;
		
		dao.read(user_number);

	}
	
	@Test
	@Ignore
	public void testReadInterest() throws Exception {
		
		int user_number = 1;
		
		dao.readInterest(user_number);
		
	}
	
	@Test
	@Ignore
	public void testReadPassword() throws Exception {
		
		User user = new User();
	
		Integer user_number = 2;
		String pw = "user2";
		
		user.setUser_number(user_number);
		user.setPw(pw);
		
		dao.readPassword(user);
	
	}
	
	@Test
	@Ignore
	public void testUpdatePassword() throws Exception {
		
		User user = new User();
		
		Integer user_number = 2;
		String pw = "user3";
		
		user.setUser_number(user_number);
		user.setPw(pw);
		
		dao.updatePassword(user);

	}
	
	@Test
	@Ignore
	public void testReadPhoneNumber() throws Exception {
		
		String phone_number = "01010101";
		
		dao.readPhoneNumber(phone_number);
	}
	
	
	@Test
	@Ignore
	public void testUpdatePhoneNumber() throws Exception {
		
		User user = new User();
		
		String phone_number = "123123";
		Integer user_number = 1;
		
		user.setPhone_number(phone_number);
		user.setUser_number(user_number);
		
		dao.updatePhoneNumber(user);
		
	}
	
	@Test
	@Ignore
	public void testReadEmail() throws Exception {
		
		String string = "qwe";
		
		dao.readEmail(string);
		
	}
	
	@Test
	@Ignore
	public void testUpdateEmail() throws Exception {
		
		User user = new User();
		
		Integer user_number = 2;
		String email = "asd@qwe.com";
		
		user.setUser_number(user_number);
		user.setEmail(email);
		
		dao.updateEmail(user);
	
	}
	
	@Test
	@Ignore
	public void testDeleteInterest() throws Exception {
		
		Integer user_number = 4;
		
		dao.deleteInterest(user_number);
	}
	
	@Test
	@Ignore
	public void testCreateInterest() throws Exception {
		
		MyPageDTO user = new MyPageDTO();
		
		int interest = 1;
		int user_number = 1;
		
		user.setInterest(interest);
		user.setUser_number(user_number);
		
		dao.createInterest(user);
		
	}
	
	@Test
	@Ignore
	public void testUpdateAddress() throws Exception {
		
		MyPageDTO user = new MyPageDTO();
		
		String user_sido = "qwe";
		String user_sigungu = "qwe";
		Integer user_number = 2;
		
		user.setUser_sido(user_sido);
		user.setUser_sigungu(user_sigungu);
		user.setUser_number(user_number);
		
		dao.updateAddress(user);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}