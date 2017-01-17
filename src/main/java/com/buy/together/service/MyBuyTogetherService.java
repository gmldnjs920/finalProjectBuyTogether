package com.buy.together.service;

import java.util.List;

import com.buy.together.domain.JoinUserInfo;
import com.buy.together.domain.MySearchCriteria;
import com.buy.together.domain.ScoreUserInfo;
import com.buy.together.dto.BuyTogetherDTO;

public interface MyBuyTogetherService {

	public List<BuyTogetherDTO> searchOpenBuyTogether(MySearchCriteria cri) throws Exception;

	public List<BuyTogetherDTO> searchJoinBuyTogether(MySearchCriteria cri) throws Exception;

	public List<BuyTogetherDTO> searchDoneBuyTogether(MySearchCriteria cri) throws Exception;

	public int searchMyBuyTogetherCount(MySearchCriteria cri) throws Exception;
	
	public List<JoinUserInfo> openReputaion(int buyTogetherNumber) throws Exception;
	
	public void scoreUserInfo(String[] scoreUserInfoList) throws Exception;

	public void finishBuyTogether(int buyTogetherNumber) throws Exception;
	
	public JoinUserInfo joinReputaion(int buyTogetherNumber) throws Exception;
	
	public void scoreUserInfoForJoiner(ScoreUserInfo scoreUserInfo) throws Exception;
	
	public void scoreUserInfoForOne(String[] scoreUserInfoList) throws Exception;
	
	public int searchJoinBuyTogetherCount(MySearchCriteria cri) throws Exception;

	public int searchDoneBuyTogetherCount(MySearchCriteria cri) throws Exception;

}
