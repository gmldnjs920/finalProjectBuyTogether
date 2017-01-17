package com.buy.together.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.buy.together.domain.AttachedPhoto;
import com.buy.together.domain.Dip;
import com.buy.together.domain.Interest;
import com.buy.together.domain.User;
import com.buy.together.domain.UserAddress;
import com.buy.together.dto.BuyTogetherDTO;

@Repository
public class UserDaoImpl implements UserDao {

	@Inject
	private SqlSession sqlSession;	
	private static String namespace = "com.buy.together.mapper.UserMapper";

	//user 테이블 닉네임 중복 확인
	@Override
	public String checkUserNickname(String nickname) throws Exception {

		return sqlSession.selectOne(namespace + ".checkUserNickname", nickname);

	}

	//admin 테이블 닉네임 중복 확인
	@Override
	public String checkAdminNickname(String nickname) throws Exception {

		return sqlSession.selectOne(namespace + ".checkAdminNickname", nickname);

	}

	//로그인 유저 닉네임 DB 저장
	@Override
	public void registNickname(User user) throws Exception {

		sqlSession.insert(namespace + ".registNickname", user);

	}

	//로그인 유저 관심 지역 DB 저장
	@Override
	public void registUserAddress(UserAddress userAddress) throws Exception {

		sqlSession.insert(namespace + ".registUserAddress", userAddress);

	}

	//로그인 유저 관심 카테고리 DB 저장
	@Override
	public void registInterest(Interest interest) throws Exception {

		sqlSession.insert(namespace + ".registInterest", interest);

	}

	//회원 정보 DB 요청
	@Override
	public User readBUser(User user) throws Exception {

		return sqlSession.selectOne(namespace + ".readBUser", user);

	}

	//회원 정보 DB 요청
	@Override
	public User readEUser(User user) throws Exception {

		return sqlSession.selectOne(namespace + ".readEUser", user);

	}

	//회원 정보 DB 삭제
	@Override
	public void delete(int user_number) throws Exception {

		sqlSession.insert(namespace + ".delete", user_number);

	}

	//내 찜 목록
	@Override
	public List<BuyTogetherDTO> myDipList(Integer user_number) throws Exception {

		return sqlSession.selectList(namespace + ".dipList", user_number);

	}

	//내 찜 사진
	@Override
	public List<AttachedPhoto> myDipPhoto(Integer buytogether_number) throws Exception {

		return sqlSession.selectList(namespace + ".dipPhoto",buytogether_number);
	}

	//선택 찜 DB 저장
	@Override
	public void registNewDip(Dip dip) throws Exception {

		sqlSession.insert(namespace + ".registDip", dip);

	}

	//선택 찜 DB 삭제
	@Override
	public void deleteDip(int user_number, int buytogether_number) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user_number", user_number);
		map.put("buytogether_number", buytogether_number);

		sqlSession.insert(namespace + ".deleteDip", map);

	}

	@Override
	public String findId(User user) throws Exception {
		
		Map<String, Object> map = new HashMap<>();
		map.put("name", user.getName());
		map.put("email", user.getEmail());
		
		return sqlSession.selectOne(namespace + ".findId", map);
		
	}
	
	@Override
	public User findPassword(User user) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("name", user.getName());
		map.put("email", user.getEmail());
		//map.put("id", user.getId());
		
		return sqlSession.selectOne(namespace + ".findPassword", map);
	}
	
	@Override
	public void setPasswordDao(User user) throws Exception {
		
		sqlSession.update(namespace + ".setPassword",user);
	}

}
