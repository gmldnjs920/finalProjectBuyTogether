package com.buy.together.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.buy.together.domain.User;

@Repository
public class JoinDaoImpl implements JoinDao {
   
   @Inject
   private SqlSession sqlSession;
   private static String namespace = "com.buy.together.mapper.joinMapper";
   
   @Override //회원가입 
   public void create(User user) throws Exception {
      
      sqlSession.insert(namespace + ".create", user);
      
   }
   
   @Override //회원 아이디 중복 체크
   public String userIdCheck(String id) {

      return sqlSession.selectOne(namespace + ".selectUserId", id);
      
   }
   
   @Override //관리자 아이디 중복 체크
   public String adminIdCheck(String id) {

      return sqlSession.selectOne(namespace + ".selectAdminId", id);
      
   }
   
   @Override //회원 닉네임 중복 체크
   public String userNicknameCheck(String nickname) {

      return sqlSession.selectOne(namespace + ".selectUserNickname", nickname);
      
   }
   
   @Override //관리자 닉네임 중복 체크
   public String adminNicknameCheck(String nickname) {

      return sqlSession.selectOne(namespace + ".selectAdminNickname", nickname);
      
   }
   
   @Override //회원 이메일 중복 체크
   public String userEmailCheck(String email) {

      return sqlSession.selectOne(namespace + ".selectUserEmail", email);
      
   }
   
   @Override //관리자 이메일 중복 체크
   public String adminEmailCheck(String email) {

      return sqlSession.selectOne(namespace + ".selectAdminEmail", email);
      
   }
   
}