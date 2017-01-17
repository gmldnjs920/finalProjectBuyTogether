package com.buy.together.dao;

import java.util.List;

import com.buy.together.domain.AttachedPhoto;
import com.buy.together.domain.JoinUserInfo;
import com.buy.together.domain.MySearchCriteria;
import com.buy.together.domain.ScoreUserInfo;
import com.buy.together.dto.BuyTogetherDTO;

public interface MyBuyTogetherDao {
	
	public List<AttachedPhoto> photoList(Integer buytogether_number) throws Exception;

	public List<BuyTogetherDTO> searchOpenBuyTogether(MySearchCriteria cri) throws Exception;

	public List<BuyTogetherDTO> searchJoinBuyTogether(MySearchCriteria cri) throws Exception;
	
	public List<BuyTogetherDTO> searchDoneBuyTogether(MySearchCriteria cri) throws Exception;
	
	public int searchMyBuyTogetherCount(MySearchCriteria cri) throws Exception;
	
	public List<JoinUserInfo> openReputation(int buyTogetherNumber) throws Exception;
	
	public void scoreReputation(List<ScoreUserInfo> scoreUserInfo) throws Exception;
	
	public void reputationLog(List<ScoreUserInfo> scoreUserInfo) throws Exception;
	
	public void finishBuyTogether(int buyTogetherNumber) throws Exception;
	
	public JoinUserInfo joinReputation(int buyTogetherNumber) throws Exception;
	
	public void scoreReputationForJoiner(ScoreUserInfo scoreUserInfo) throws Exception;
	
	public void reputationLogForJoiner(ScoreUserInfo scoreUserInfo) throws Exception;
	
	public int searchJoinBuyTogetherCount(MySearchCriteria cri) throws Exception;
	
	public int searchDoneBuyTogetherCount(MySearchCriteria cri) throws Exception;
	
	
}
