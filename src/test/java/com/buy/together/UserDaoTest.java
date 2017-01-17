package com.buy.together;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.buy.together.dao.UserDao;
import com.buy.together.domain.Interest;
import com.buy.together.domain.User;
import com.buy.together.domain.UserAddress;
import com.buy.together.dto.BuyTogetherDTO;
import com.buy.together.util.SHA256;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class UserDaoTest {

   SHA256 sha = SHA256.getInsatnce();
   
   @Inject
   UserDao userDao;
   
   @Test
   public void testCheckUserNickname() throws Exception{
      
      String userNickname = "양갱갱";
      String result = userDao.checkUserNickname(userNickname);
      
      if(result != null){
         
         System.out.println("닉네임 사용 불가");
         
      } else{
         
         System.out.println("닉네임 사용 가능");
         
      }
      
   }
      
   @Test
   public void testCheckAdminNickname() throws Exception{
      
      String adminNickname = "admin1";
      String result = userDao.checkAdminNickname(adminNickname);
      
      if(result != null){
         
         System.out.println("닉네임 사용 불가");
         
      } else{
         
         System.out.println("닉네임 사용 가능");
         
      }
      
   }
   
   @Test
   public void testRegistNickname() throws Exception {

      User user = new User();

      user.setUser_number(1);
      user.setNickname("끠리리");

      userDao.registNickname(user);

   }
   
   @Test
   public void testRegistUserAddress() throws Exception {

      UserAddress userAddress = new UserAddress();

      userAddress.setUser_number(1);
      userAddress.setUser_sido("경기도 수원시");
      userAddress.setUser_sigungu("권선구");

      userDao.registUserAddress(userAddress);

   }
   
   @Test
   public void testRegistInterest() throws Exception {

      Interest interest = new Interest();

      interest.setInterest_number(1);
      interest.setUser_number(1);
      interest.setCategory_number(1);

      userDao.registInterest(interest);

   }
   
   @Test
   public void testMyDipList() throws Exception {
      
      int userNumber = 1;
      
      List<BuyTogetherDTO> list = userDao.myDipList(userNumber);

      if (list == null) {
         
         System.out.println("없다");
         
      }

      for (BuyTogetherDTO myDip : list) {
         
         System.out.println(myDip.getPhoto_path() + "\t" + myDip.getTitle() + "\t" + myDip.getJoin_number() + "\t"
               + myDip.getNickname() + "\t" + myDip.getPrice() + "\t" + myDip.getDuedate());
         
      }
      
   }
   
   @Test
   public void testFindId() throws Exception{
      
      User user = new User();
      String userId;
      
      user.setName("user1");
      user.setEmail("user1@user1");
      
      userId = userDao.findId(user);
      
      System.out.println(userId);
      
   }
   
   @Test
   public void testFindPassword() throws Exception{
      
      User user = new User();
      User userPassword;
      
      user.setName("user1");
      user.setEmail("user1@user1");
      user.setId("user1");
      
      userPassword = userDao.findPassword(user);
      
      System.out.println(userPassword);
      
   }
}