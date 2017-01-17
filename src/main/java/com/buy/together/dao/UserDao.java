package com.buy.together.dao;

import java.util.List;

import com.buy.together.domain.AttachedPhoto;
import com.buy.together.domain.Dip;
import com.buy.together.domain.Interest;
import com.buy.together.domain.User;
import com.buy.together.domain.UserAddress;
import com.buy.together.dto.BuyTogetherDTO;

public interface UserDao {

	public String checkUserNickname(String nickName) throws Exception;

	public String checkAdminNickname(String nickName) throws Exception;

	public void registNickname(User user) throws Exception;

	public void registUserAddress(UserAddress userAddress) throws Exception;

	public void registInterest(Interest interest) throws Exception;

	public User readEUser(User user) throws Exception;

	public User readBUser(User user) throws Exception;

	public void delete(int user_number) throws Exception;

	public List<BuyTogetherDTO> myDipList(Integer user_number) throws Exception;

	public List<AttachedPhoto> myDipPhoto(Integer buytogether_number) throws Exception;

	public void deleteDip(int user_number, int buytogether_number) throws Exception;

	public void registNewDip(Dip dip) throws Exception;

	public String findId(User user) throws Exception;;

	public User findPassword(User user) throws Exception;
	
	public void setPasswordDao(User user) throws Exception;

}
