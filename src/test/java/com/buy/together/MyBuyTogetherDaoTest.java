package com.buy.together;

import java.util.List;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.buy.together.dao.MyBuyTogetherDao;
import com.buy.together.domain.MySearchCriteria;
import com.buy.together.domain.ScoreUserInfo;
import com.buy.together.dto.BuyTogetherDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})

public class MyBuyTogetherDaoTest {

	private static final Logger logger = LoggerFactory.getLogger(MyBuyTogetherDaoTest.class);

	@Inject
	MyBuyTogetherDao dao;

	// photoList Test
	@Test
	@Ignore
	public void testPhotoList1() throws Exception {

		logger.info("testPhotoList() 호출됨.");
		Integer buytogether_number = 2;

		dao.photoList(buytogether_number);

	}

	// searchOpenBuyTogether Test
	@Test
	@Ignore
	public void testSearchOpenBuyTogether() throws Exception {

		logger.info("testSearchOpenBuyTogether() 호출됨.");	
		MySearchCriteria cri = new MySearchCriteria();

		int user_number = 3;
		int page = 1;
		int perPageNum = 2;
		String keyword ="test";
		String searchType = "t";

		cri.setPage(page);
		cri.setPerPageNum(perPageNum);
		cri.setUser_number(user_number);
		cri.setKeyword(keyword);
		cri.setSearchType(searchType);

		List<BuyTogetherDTO> list = dao.searchOpenBuyTogether(cri);

		logger.info(list.toString());

	}

	// searchJoinBuyTogether Test
	@Test
	@Ignore
	public void testSearchJoinBuyTogether() throws Exception {

		logger.info("testSearchJoinBuyTogether() 호출됨.");
		MySearchCriteria cri = new MySearchCriteria();

		int user_number = 2;
		int page = 1;
		int perPageNum = 2;
		String keyword ="test";
		String searchType = "t";

		cri.setPage(page);
		cri.setPerPageNum(perPageNum);
		cri.setUser_number(user_number);
		cri.setKeyword(keyword);
		cri.setSearchType(searchType);

		List<BuyTogetherDTO> list = dao.searchOpenBuyTogether(cri);

		logger.info(list.toString());
		
	}

	// searchDoneBuyTogether Test
	@Test
	@Ignore
	public void testSearchDoneBuyTogether() throws Exception {

		logger.info("testSearchDoneBuyTogether() 호출됨.");
		MySearchCriteria cri = new MySearchCriteria();

		List<BuyTogetherDTO> list = dao.searchDoneBuyTogether(cri);

		logger.info(list.toString());
		
	}

	// searchMyBuyTogetherCount Test
	@Test
	public void testSearchMyBuyTogetherCount() throws Exception {

		logger.info("testSearchMyBuyTogetherCount() 호출됨.");
		MySearchCriteria cri = new MySearchCriteria();

		int user_number = 2;

		cri.setUser_number(user_number);

		dao.searchMyBuyTogetherCount(cri);

	}

	// openReputation Test
	@Test
	@Ignore
	public void testOpenReputation() throws Exception {

		logger.info("testOpenReputation() 호출됨.");
		Integer buyTogetherNumber = 11;

		dao.openReputation(buyTogetherNumber);

	}

	// scoreReputation Test
	@Test
	@Ignore
	public void testScoreReputation() throws Exception {

		logger.info("testScoreReputation() 호출됨.");	

		ScoreUserInfo scoreUserInfo = new ScoreUserInfo();
		List<ScoreUserInfo> list = null;

		Integer score_user_number = 5;
		Integer score = 50;

		scoreUserInfo.setScore_user_number(score_user_number);
		scoreUserInfo.setScore(score);

		dao.scoreReputation(list);


	}

	// scoreReputation Test
	@Test	
	@Ignore
	public void testReputationLog() throws Exception {

		logger.info("testReputationLog() 호출됨.");	

		Integer scored_user_number = 1;
		Integer score_user_number = 2;
		Integer buyTogetherNumber = 3;

		ScoreUserInfo scoreUserInfo = new ScoreUserInfo(scored_user_number, score_user_number, buyTogetherNumber);
		List<ScoreUserInfo> scoreUserInfoList = null;

		dao.reputationLog(scoreUserInfoList);

	}

	// FinishBuyTogether Test
	@Test	
	@Ignore
	public void testFinishBuyTogether() throws Exception {

		logger.info("testFinishBuyTogether() 호출됨.");	

		Integer buyTogetherNumber = 3;

		dao.finishBuyTogether(buyTogetherNumber);

	}

	// JoinReputation Test
	@Test	
	@Ignore
	public void testJoinReputation() throws Exception {

		logger.info("testJoinReputation() 호출됨.");	

		Integer buyTogetherNumber = 3;

		dao.finishBuyTogether(buyTogetherNumber);

	}

	// ScoreReputationForJoiner Test
	@Test	
	@Ignore
	public void testScoreReputationForJoiner() throws Exception {

		logger.info("testScoreReputationForJoiner() 호출됨.");	

		ScoreUserInfo scoreUserInfo = new ScoreUserInfo();

		Integer score = 12;
		Integer score_user_number = 1;

		scoreUserInfo.setScore(score);
		scoreUserInfo.setScore_user_number(score_user_number);

		dao.scoreReputationForJoiner(scoreUserInfo);
	}

	// reputationLogForJoiner Test
	@Test	
	@Ignore
	public void testReputationLogForJoiner() throws Exception {

		logger.info("testReputationLogForJoiner() 호출됨.");	

		Integer scored_user_number = 1;
		Integer score_user_number = 2;
		Integer buyTogetherNumber = 3;

		ScoreUserInfo scoreUserInfoOne = new ScoreUserInfo(scored_user_number, score_user_number, buyTogetherNumber);

		dao.reputationLogForJoiner(scoreUserInfoOne);
	}

	// searchJoinBuyTogetherCount Test
	@Test	
	@Ignore
	public void testSearchJoinBuyTogetherCount() throws Exception {

		logger.info("testSearchJoinBuyTogetherCount() 호출됨.");	

		MySearchCriteria cri = new MySearchCriteria();

		String keyword ="test";
		Integer user_number = 1;

		cri.setKeyword(keyword);
		cri.setUser_number(user_number);

		dao.searchJoinBuyTogetherCount(cri);
	}

	// searchDoneBuyTogetherCount Test
	@Test	
	@Ignore
	public void testSearchDoneBuyTogetherCount() throws Exception {

		logger.info("testSearchDoneBuyTogetherCount() 호출됨.");	

		MySearchCriteria cri = new MySearchCriteria();
		
		String keyword ="test";
		Integer user_number = 1;

		cri.setKeyword(keyword);
		cri.setUser_number(user_number);
		
		dao.searchDoneBuyTogetherCount(cri);
	
	}

}
