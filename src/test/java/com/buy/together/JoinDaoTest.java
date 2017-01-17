package com.buy.together;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.buy.together.dao.JoinDao;
import com.buy.together.domain.User;
import com.buy.together.util.SHA256;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class JoinDaoTest {

	SHA256 sha = SHA256.getInsatnce();

	@Inject
	JoinDao joinDao;

	@Test
	public void testJoin() throws Exception {

		User user = new User();

		user.setPw("u01");
		user.setName("김권식");
		user.setNickname("김권식쨩");
		String from = "1992-04-18";
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date to = transFormat.parse(from);
		user.setBirthdate(to);
		user.setGender("M");
		user.setPhone_number("01029744318");
		user.setEmail("slsrmsn@hhhh.com");

		String orgPass = user.getPw();
		String shaPass = sha.getSha256(orgPass.getBytes());

		user.setPw(shaPass);

		joinDao.create(user);

	}

	@Test
	public void testUserIdCheck() throws Exception{

		String userid = "user01";
		String result = joinDao.userIdCheck(userid);

		if(result != null){

			System.out.println("아이디 사용 불가");

		} else{

			System.out.println("아이디 사용 가능");

		}

	}

	@Test
	public void testAdminIdCheck() throws Exception{

		String adminid = "admin1";
		String result = joinDao.adminIdCheck(adminid);

		if(result != null){

			System.out.println("아이디 사용 불가");

		} else{

			System.out.println("아이디 사용 가능");

		}

	}

	@Test
	public void testUserNicknameCheck() throws Exception{

		String userNickname = "양갱갱";
		String result = joinDao.userNicknameCheck(userNickname);

		if(result != null){

			System.out.println("닉네임 사용 불가");

		} else{

			System.out.println("닉네임 사용 가능");

		}

	}

	@Test
	public void testAdminNicknameCheck() throws Exception{

		String adminNickname = "admin1";
		String result = joinDao.adminNicknameCheck(adminNickname);

		if(result != null){

			System.out.println("닉네임 사용 불가");

		} else{

			System.out.println("닉네임 사용 가능");

		}

	}

	@Test
	public void testUserEmailCheck() throws Exception{

		String userEmail = "user1@user1";
		String result = joinDao.userEmailCheck(userEmail);

		if(result != null){

			System.out.println("이메일 사용 불가");

		} else{

			System.out.println("이메일 사용 가능");

		}

	}

	@Test
	public void testAdminEmailCheck() throws Exception{

		String adminEmail = "admin1@admin1.com";
		String result = joinDao.adminEmailCheck(adminEmail);

		if(result != null){

			System.out.println("이메일 사용 불가");

		} else{

			System.out.println("이메일 사용 가능");

		}

	}

}