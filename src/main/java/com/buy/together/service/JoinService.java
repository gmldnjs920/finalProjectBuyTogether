package com.buy.together.service;

import com.buy.together.domain.User;

public interface JoinService {
   
   //회원 가입
   public void addJoin(User user) throws Exception;
   
   //아이디 중복 체크
   public String idCheck(String id) throws Exception;

   //닉네임 중복 체크
   public String nicknameCheck(String nickname) throws Exception;

   //이메일 중복 체크
   public String emailCheck(String email) throws Exception;

}