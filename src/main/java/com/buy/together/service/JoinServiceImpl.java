package com.buy.together.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.buy.together.dao.JoinDao;
import com.buy.together.domain.User;
import com.buy.together.util.SHA256;

@Service
public class JoinServiceImpl implements JoinService{
   
   SHA256 sha = SHA256.getInsatnce();
   
   @Inject
   private JoinDao joindao;
   
   @Override
   public void addJoin(User user) throws Exception { //암호화 처리
      
      String orgPass = user.getPw();
      String shaPass = sha.getSha256(orgPass.getBytes());

      user.setPw(shaPass);
      
      joindao.create(user);
      
   }
   
   @Override
   public String idCheck(String id) throws Exception { //회원, 관리자 아이디 중복 체크

      String checkId;
      
      checkId = joindao.userIdCheck(id); //회원 아이디 체크
      
      if(checkId == null) {
         
         checkId = joindao.adminIdCheck(id); //관리자 아이디 체크
         
      }
      
      return checkId;
      
   }
   
   @Override
   public String nicknameCheck(String nickname) throws Exception { //회원, 관리자 닉네임 중복 체크

      String checkNickname;
      
      checkNickname = joindao.userNicknameCheck(nickname); //회원 닉네임 체크
      
      if(checkNickname == null) {
         
         checkNickname = joindao.adminNicknameCheck(nickname); //관리자 닉네임 체크
         
      }
      
      return checkNickname;
      
   }
   
   @Override
   public String emailCheck(String email) throws Exception { //회원, 관리자 이메일 중복 체크

      String checkEmail;
      
      checkEmail = joindao.userEmailCheck(email); //회원 이메일 체크
      
      if(checkEmail == null) {
         
         checkEmail = joindao.adminEmailCheck(email); //관리자 이메일 체크
         
      }
      
      return checkEmail;
      
   }

}