package com.buy.together.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.buy.together.domain.AttachedPhoto;
import com.buy.together.domain.JoinUserInfo;
import com.buy.together.domain.MySearchCriteria;
import com.buy.together.domain.Reputation;
import com.buy.together.domain.ScoreUserInfo;
import com.buy.together.dto.BuyTogetherDTO;

@Repository
public class MyBuyTogetherDaoImpl implements MyBuyTogetherDao {

	private static final String namespace="com.buy.together.mappers.myBuyTogetherMapper";

	@Inject
	private SqlSession sqlSession;

	@Override //게시글의 사진 리스트 조회
	public List<AttachedPhoto> photoList(Integer buytogether_number) throws Exception {

		return sqlSession.selectList(namespace+".photoList", buytogether_number);

	}

	@Override//개설한 같이사냥
	public List<BuyTogetherDTO> searchOpenBuyTogether(MySearchCriteria cri) throws Exception {

		int user_number = cri.getUser_number();

		List<BuyTogetherDTO> myBuyTogetherList = sqlSession.selectList(namespace+".searchOpenBuyTogether", cri);

		for(int i = 0; i < myBuyTogetherList.size(); i++){//리스트에서 buyTogether_number 뽑아내기 위함.

			int myBuyTogetherNumber = myBuyTogetherList.get(i).getBuytogether_number();

			//참여유저번호 조회
			List<Integer> joinUserNumbersList = sqlSession.selectList(namespace+".searchJoinUser", myBuyTogetherNumber);

			int[] joinUserNumbers = new int[joinUserNumbersList.size()];

			for (int k=0; k < joinUserNumbers.length; k++)
			{
				joinUserNumbers[k] = joinUserNumbersList.get(k).intValue();
			}

			boolean beOrNot = true;
			
			for(int j = 0; j < joinUserNumbers.length; j++){//평판조회

				int joinUserNumber = joinUserNumbers[j];
				int reputationNumber;

				Reputation reputation = new Reputation(user_number, joinUserNumber, myBuyTogetherNumber);

				if(sqlSession.selectOne(namespace+".reputationLog", reputation) == null) {//평판주기 가능
					reputationNumber = 0;
				} else {//평판 이미 줬음, 이제 평판주기 안뜸
					reputationNumber = sqlSession.selectOne(namespace+".reputationLog", reputation);
				}

				if(reputationNumber == 0){
					beOrNot = false;//평판기록이 존재하지 않으면 평판을 줄 수 있음.
				}

			}

			myBuyTogetherList.get(i).setBeOrNot(beOrNot);
		}

		return myBuyTogetherList;

	}

	//참여한 같이사냥 
	@Override
	public List<BuyTogetherDTO> searchJoinBuyTogether(MySearchCriteria cri) throws Exception {

		boolean beOrNot = true;
		int reputationNumber;
		List<BuyTogetherDTO> myBuyTogetherList = sqlSession.selectList(namespace+".searchJoinBuyTogether", cri);

		for(int i = 0; i < myBuyTogetherList.size(); i++){
			int buyTogetherNumber = myBuyTogetherList.get(i).getBuytogether_number();
			int joinUserNumber = sqlSession.selectOne(namespace+".readUserNumber", buyTogetherNumber);//개설한 유저정보임
			int user_number = cri.getUser_number();//참여한 유저 정보임.
			Reputation reputation = new Reputation(joinUserNumber, user_number, buyTogetherNumber);//점수매김받을유저,점수매기는유저,같이사냥번호 순 

			if(sqlSession.selectOne(namespace+".reputationLog", reputation) == null) {//평판주기 가능
				reputationNumber = 0;
			} else {//평판 이미 줬음, 이제 평판주기 안뜸
				reputationNumber = sqlSession.selectOne(namespace+".reputationLog", reputation);
			}

			if(reputationNumber == 0){
				beOrNot = false;//평판기록이 존재하지 않으면 평판을 줄 수 있음.
			}
			myBuyTogetherList.get(i).setBeOrNot(beOrNot);
		}

		return myBuyTogetherList;

	}

	@Override//완료한 같이사냥
	public List<BuyTogetherDTO> searchDoneBuyTogether(MySearchCriteria cri) throws Exception {

		return sqlSession.selectList(namespace+".searchDoneBuyTogether", cri);

	}

	//페이징 위한 메서드
	@Override
	public int searchMyBuyTogetherCount(MySearchCriteria cri) throws Exception {

		return sqlSession.selectOne(namespace+".searchMyBuyTogetherCount", cri);

	}

	//평판주려고 참여유저 조회 
	@Override
	public List<JoinUserInfo> openReputation(int buyTogetherNumber) throws Exception {

		return sqlSession.selectList(namespace+".openReputation", buyTogetherNumber);
	}

	//평판 점수 주기
	@Override
	public void scoreReputation(List<ScoreUserInfo> scoreUserInfoList) throws Exception {
		//쉬운 방법 있을듯 한데??
		int scored_user_number = 0;
		int score = 0;
		for(int i = 0; i < scoreUserInfoList.size(); i++){
			scored_user_number = scoreUserInfoList.get(i).getScored_user_number();
			score = scoreUserInfoList.get(i).getScore();
			ScoreUserInfo scoreUserInfoOne = new ScoreUserInfo(scored_user_number, score);
			sqlSession.update(namespace+".scoreReputation", scoreUserInfoOne);
		}
	}

	//평판 기록 남기기
	@Override
	public void reputationLog(List<ScoreUserInfo> scoreUserInfoList) throws Exception {
		//현재 있는게 조인한 애들 유저 정보랑, 바이투게더 정보임. 1. 개설한 애 유저정보를 받아와야 함 바이투게더에서 받으면 됨
		int buyTogetherNumber = scoreUserInfoList.get(0).getBuyTogetherNumber();
		int score_user_number = sqlSession.selectOne(namespace+".readUserNumber",buyTogetherNumber);

		for(int i = 0; i < scoreUserInfoList.size(); i++){
			int scored_user_number = scoreUserInfoList.get(i).getScored_user_number();

			ScoreUserInfo scoreUserInfoOne = new ScoreUserInfo(scored_user_number, score_user_number, buyTogetherNumber);
			sqlSession.insert(namespace+".writeReputation", scoreUserInfoOne);
		}

	}
	//같이사냥 완료하기
	@Override
	public void finishBuyTogether(int buyTogetherNumber) throws Exception {

		sqlSession.update(namespace+".finishBuyTogether", buyTogetherNumber);
	}

	//(참여한) 평판 매길 유저 정보 가져오기***************
	@Override
	public JoinUserInfo joinReputation(int buyTogetherNumber) throws Exception {

		return sqlSession.selectOne(namespace+".joinReputation", buyTogetherNumber);
	}

	//(참여한) 평판 점수 주기
	@Override
	public void scoreReputationForJoiner(ScoreUserInfo scoreUserInfo) throws Exception {

		sqlSession.update(namespace+".scoreReputation", scoreUserInfo);
	}
	
	//(참여한) 평판기록 남기기
	@Override
	public void reputationLogForJoiner(ScoreUserInfo scoreUserInfo) throws Exception {

		int score_user_number = scoreUserInfo.getScore_user_number();
		int scored_user_number = scoreUserInfo.getScored_user_number();
		int buyTogetherNumber = scoreUserInfo.getBuyTogetherNumber();
		ScoreUserInfo scoreUserInfoOne = new ScoreUserInfo(scored_user_number, score_user_number, buyTogetherNumber);
		sqlSession.insert(namespace+".writeReputation", scoreUserInfoOne);

	}

	//참여한 페이지 카운트
	@Override
	public int searchJoinBuyTogetherCount(MySearchCriteria cri) throws Exception {

		return sqlSession.selectOne(namespace+".searchJoinBuyTogetherCount", cri);
	}

	//완료한 페이지 카운트
	@Override
	public int searchDoneBuyTogetherCount(MySearchCriteria cri) throws Exception {

		int countedOpen = sqlSession.selectOne(namespace+".searchDoneBuyTogetherCount1", cri);
		int countedJoin = sqlSession.selectOne(namespace+".searchDoneBuyTogetherCount2", cri); 
		int sumOfCount = countedOpen + countedJoin;

		return sumOfCount;
	}

}
