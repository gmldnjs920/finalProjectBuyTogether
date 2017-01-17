package com.buy.together.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.buy.together.domain.User;
import com.buy.together.dto.MyPageDTO;

@Repository
public class MyPageDaoImpl implements MyPageDao {

	private static final String namespace="com.buy.together.mappers.mypageMapper";
		
	@Inject
	private SqlSession sqlSession;
	
	//내 정보 보기
	@Override
	public MyPageDTO read(int user_number) throws Exception {

		return sqlSession.selectOne(namespace + ".read", user_number);
		
	}
	
	//내 관심 카테고리 조회
	@Override
	public List<Integer> readInterest(int user_number) throws Exception {

		return sqlSession.selectList(namespace + ".readInterest", user_number);
		
	}

	//회원 비밀번호 조회
	@Override
	public String readPassword(User user) throws Exception {

		return sqlSession.selectOne(namespace + ".readPassword", user);
		
	}

	//회원 비밀번호 수정
	@Override
	public void updatePassword(User user) throws Exception {
		
		sqlSession.selectOne(namespace + ".updatePassword", user);
		
	}
	
	//연락처 조회
	@Override
	public String readPhoneNumber(String phone_number) throws Exception {

		return sqlSession.selectOne(namespace + ".readPhoneNumber", phone_number);
		
	}
	
	//회원 연락처 수정
	@Override
	public void updatePhoneNumber(User user) throws Exception {
		
		sqlSession.selectOne(namespace + ".updatePhoneNumber", user);
		
	}
	
	//이메일 조회
	@Override
	public String readEmail(String email) throws Exception {

		return sqlSession.selectOne(namespace + ".readEmail", email);
		
	}
	
	//회원 이메일 수정
	@Override
	public void updateEmail(User user) throws Exception {
		
		sqlSession.selectOne(namespace + ".updateEmail", user);
		
	}

	//관심 카테고리 삭제
	@Override
	public void deleteInterest(int user_number) throws Exception {
		
		sqlSession.selectOne(namespace + ".deleteInterest", user_number);
		
	}

	//관심 카테고리 등록
	@Override
	public void createInterest(MyPageDTO user) throws Exception {
		
		sqlSession.selectOne(namespace + ".createInterest", user);
		
	}

	//관심 지역 수정
	@Override
	public void updateAddress(MyPageDTO user) throws Exception {
		
		sqlSession.selectOne(namespace + ".updateAddress", user);
		
	}

}
