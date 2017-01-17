package com.buy.together.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buy.together.dao.MyBuyTogetherDao;
import com.buy.together.domain.AttachedPhoto;
import com.buy.together.domain.JoinUserInfo;
import com.buy.together.domain.MySearchCriteria;
import com.buy.together.domain.ScoreUserInfo;
import com.buy.together.dto.BuyTogetherDTO;

@Service
public class MyBuyTogetherServiceImpl implements MyBuyTogetherService {

	@Inject
	private MyBuyTogetherDao dao;

	@Override//개설한 같이사냥
	public List<BuyTogetherDTO> searchOpenBuyTogether(MySearchCriteria cri) throws Exception {

		List<BuyTogetherDTO> searchOpenBuyTogether = dao.searchOpenBuyTogether(cri);

		for(int i = 0; i<searchOpenBuyTogether.size(); i++){
			List<AttachedPhoto> attachedPhotos = dao.photoList(searchOpenBuyTogether.get(i).getBuytogether_number());

			searchOpenBuyTogether.get(i).setPhoto_path(attachedPhotos);
			searchOpenBuyTogether.get(i).setFinishOrNot(false);

		}

		return searchOpenBuyTogether;
	}

	@Override//참여한 같이사냥
	public List<BuyTogetherDTO> searchJoinBuyTogether(MySearchCriteria cri) throws Exception {

		List<BuyTogetherDTO> searchJoinBuyTogether = dao.searchJoinBuyTogether(cri);

		for(int i = 0; i<searchJoinBuyTogether.size(); i++){
			List<AttachedPhoto> attachedPhotos = dao.photoList(searchJoinBuyTogether.get(i).getBuytogether_number());

			searchJoinBuyTogether.get(i).setPhoto_path(attachedPhotos);
			searchJoinBuyTogether.get(i).setFinishOrNot(false);
		}

		return searchJoinBuyTogether;
	}

	@Override//완료한 같이사냥
	public List<BuyTogetherDTO> searchDoneBuyTogether(MySearchCriteria cri) throws Exception {

		List<BuyTogetherDTO> searchDoneBuyTogether = dao.searchDoneBuyTogether(cri);

		for(int i = 0; i<searchDoneBuyTogether.size(); i++){
			List<AttachedPhoto> attachedPhotos = dao.photoList(searchDoneBuyTogether.get(i).getBuytogether_number());

			searchDoneBuyTogether.get(i).setPhoto_path(attachedPhotos);
			searchDoneBuyTogether.get(i).setBeOrNot(true);
			searchDoneBuyTogether.get(i).setFinishOrNot(true);
		}

		return searchDoneBuyTogether;
	}

	//개설한 페이지 번호 카운트
	@Override
	public int searchMyBuyTogetherCount(MySearchCriteria cri) throws Exception {
		return dao.searchMyBuyTogetherCount(cri);
	}

	//평판 주기 위해 참여유저 조회
	@Override
	public List<JoinUserInfo> openReputaion(int buyTogetherNumber) throws Exception {
		List<JoinUserInfo> joinUser_list = dao.openReputation(buyTogetherNumber);
		for(int i = 0; i< joinUser_list.size(); i++){
			joinUser_list.get(i).setBuyTogetherNumber(buyTogetherNumber);
		}
		return joinUser_list;
	}

	//평판매기기
	@Transactional
	@Override
	public void scoreUserInfo(String[] scoreUserInfoList) throws Exception {
		String test = scoreUserInfoList[0];
		String[] str= new String[4];
		List<ScoreUserInfo> ScoreUserInfoList = new ArrayList<ScoreUserInfo>();
		int scored_user_number;
		int score;
		int score_user_number;
		int buyTogetherNumber;

		for(int i = 0; i<scoreUserInfoList.length; i++){
			str = scoreUserInfoList[i].split(",");//str = [],[],[],[];
			
			scored_user_number = Integer.parseInt(str[0]);
			score = Integer.parseInt(str[1]);
			score_user_number = Integer.parseInt(str[2]);
			buyTogetherNumber = Integer.parseInt(str[3]);
			ScoreUserInfo scoreUserInfo = new ScoreUserInfo(scored_user_number, score, score_user_number, buyTogetherNumber);
			ScoreUserInfoList.add(scoreUserInfo);

		} 

		dao.scoreReputation(ScoreUserInfoList);
		dao.reputationLog(ScoreUserInfoList);

	}

	//(개설한) 1인 평판매기기 
	@Override
	public void scoreUserInfoForOne(String[] scoreUserInfoList) throws Exception {

		List<ScoreUserInfo> ScoreUserInfoList = new ArrayList<ScoreUserInfo>();

		int scored_user_number = Integer.parseInt(scoreUserInfoList[0]);
		int score = Integer.parseInt(scoreUserInfoList[1]);
		int score_user_number = Integer.parseInt(scoreUserInfoList[2]);
		int buyTogetherNumber = Integer.parseInt(scoreUserInfoList[3]);
		ScoreUserInfo scoreUserInfo = new ScoreUserInfo(scored_user_number, score, score_user_number, buyTogetherNumber);
		ScoreUserInfoList.add(scoreUserInfo);

		dao.scoreReputation(ScoreUserInfoList);
		dao.reputationLog(ScoreUserInfoList);

	}

	//같이사냥 완료하기
	@Override
	public void finishBuyTogether(int buyTogetherNumber) throws Exception {

		dao.finishBuyTogether(buyTogetherNumber);

	}

	//평판 매길 유저정보 가져오기
	@Override
	public JoinUserInfo joinReputaion(int buyTogetherNumber) throws Exception {

		return dao.joinReputation(buyTogetherNumber);
	}

	//참여한(평판매기기)
	@Transactional
	@Override
	public void scoreUserInfoForJoiner(ScoreUserInfo scoreUserInfo) throws Exception {

		dao.scoreReputationForJoiner(scoreUserInfo);
		dao.reputationLogForJoiner(scoreUserInfo);
	}

	//참여한 페이지 카운트
	@Override
	public int searchJoinBuyTogetherCount(MySearchCriteria cri) throws Exception {
		
		return dao.searchJoinBuyTogetherCount(cri);
	}

	//완료한 페이지 카운트
	@Override
	public int searchDoneBuyTogetherCount(MySearchCriteria cri) throws Exception {
		
		return dao.searchDoneBuyTogetherCount(cri);
	}


}
