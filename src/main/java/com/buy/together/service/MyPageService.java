package com.buy.together.service;

import com.buy.together.dto.MyPageDTO;

public interface MyPageService {

   public MyPageDTO readMyPage(int user_number) throws Exception;
   
   public String updatePassword(String[] user_info) throws Exception;
   
   public String updatePhoneNumber(String[] user_info) throws Exception;
   
   public String updateEmail(String[] user_info) throws Exception;
   
   public void updateInterest(int user_number, String[] interest) throws Exception;
   
   public void updateAddress(String[] user_info) throws Exception;
   
}
