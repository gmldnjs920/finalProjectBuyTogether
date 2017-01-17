package com.buy.together.dao;

import com.buy.together.domain.User;

public interface JoinDao {
   
   //회원가입
   public void create(User user) throws Exception;
   
   //회원 아이디 중복 체크
   public String userIdCheck(String id) throws Exception;
   
   //관리자 아이디 중복 체크
   public String adminIdCheck(String id) throws Exception;
   
   //회원 닉네임 중복 체크
   public String userNicknameCheck(String nickname) throws Exception;
   
   //관리자 닉네임 중복 체크
   public String adminNicknameCheck(String nickname) throws Exception;
   
   //회원 이메일 중복 체크
   public String userEmailCheck(String email) throws Exception;
   
   //관리자 이메일 중복 체크
   public String adminEmailCheck(String email) throws Exception;

}