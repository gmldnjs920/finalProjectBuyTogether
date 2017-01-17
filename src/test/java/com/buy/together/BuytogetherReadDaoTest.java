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

import com.buy.together.dao.BuyTogetherReadDao;
import com.buy.together.domain.Comment;
import com.buy.together.domain.DeclareBoard;
import com.buy.together.dto.BuyTogetherDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})

public class BuytogetherReadDaoTest {

	private static final Logger logger = LoggerFactory.getLogger(BuytogetherReadDaoTest.class);

	@Inject
	BuyTogetherReadDao dao;

	@Ignore
	// BuytogetherRead Test
	@Test
	public void testBuytogetherReadList() throws Exception {

		logger.info("testBuytogetherReadList() 호출됨.");
		Integer buytogether_number = 2;
		BuyTogetherDTO list = dao.buyTogetherRead(buytogether_number);

		logger.info(list.toString());

	}

	@Ignore
	// commentList Test
	@Test
	public void testCommentList() throws Exception{

		logger.info("testCommentList() 호출됨.");
		Integer buytogether_number = 11;
		Integer comment_type_number = 1;
		List<Comment> list = dao.commentList(buytogether_number, comment_type_number);

		logger.info(list.toString());

	}

	@Ignore
	// createComment Test
	@Test
	public void testCreateComment() throws Exception{

		logger.info("testCreateComment() 호출됨.");
		Comment comment = new Comment("전체댓글 Test JUNIT", 11, 3, 1);
		dao.createComment(comment);

	}

	@Ignore
	// deleteComment Test
	@Test
	public void testDeleteComment() throws Exception{

		logger.info("testDeleteComment() 호출됨.");
		Integer comment_number = 2;
		dao.deleteComment(comment_number);

	}

	@Ignore
	// commentUpdate Test
	@Test
	public void testCommentUpdate() throws Exception{

		logger.info("testCommentUpdate() 호출됨.");
		Comment comment = new Comment("전체 수정 댓글 Test JUNIT", 11, 1);
		dao.commentUpdate(comment);

	}

	@Ignore
	// createRecomment Test
	@Test
	public void testCreateRecomment() throws Exception{

		logger.info("testCreateRecomment() 호출됨.");
		Comment comment = new Comment(4, "답글 테스트 JUNIT", 11, 5, 1);
		dao.createRecomment(comment);

	}

	@Ignore
	// recommentList Test
	@Test
	public void testRecommentList() throws Exception{

		logger.info("testRecommentList() 호출됨.");
		Integer comment_number = 4;
		Integer comment_type_number = 1;
		List<Comment> list = dao.recommentList(comment_number, comment_type_number);

		for(int i = 0 ; i < list.size() ; i++) {
			logger.info(list.get(i).toString());
		}
	}

	@Ignore
	// deleteBuytogether Test
	@Test
	public void testDeleteBuytogether() throws Exception{

		logger.info("testDeleteBuytogether() 호출됨.");
		Integer buytogether_number = 2;
		dao.deleteBuytogether(buytogether_number);

	}

	@Ignore
	// registBuytogether Test
	@Test
	public void testRegistBuytogetherBtn() throws Exception{

		logger.info("testRegistBuytogether() 호출됨.");
		Integer user_number = 3;
		Integer buytogether_number = 11;
		dao.registBuytogether(user_number, buytogether_number);

	}

	@Ignore
	// insertDip Test
	@Test
	public void testInsertDip() throws Exception{

		logger.info("testInsertDip() 호출됨.");
		Integer buytogether_number = 11;
		Integer user_number = 2;
		dao.insertDip(buytogether_number, user_number);

	}

	@Ignore
	// deleteDip Test
	@Test
	public void testDeleteDip() throws Exception{

		logger.info("testDeleteDip() 호출됨.");
		Integer buytogether_number = 11;
		Integer user_number = 2;
		dao.deleteDip(buytogether_number, user_number);

	}

	@Ignore
	// checkDip Test
	@Test
	public void testCheckDip() throws Exception{

		logger.info("testCheckDip() 호출됨.");
		Integer buytogether_number = 11;
		Integer user_number = 2;
		dao.checkDip(buytogether_number, user_number);

	}

	@Ignore
	// reportDao Test
	@Test
	public void testReportDao() throws Exception{

		logger.info("testReportDao() 호출됨.");
		Integer buytogether_number = 11;
		Integer comment_number = 4;
		BuyTogetherDTO list = dao.reportDao(buytogether_number, comment_number);

		logger.info(list.toString());

	}

	@Ignore
	//sendReport Test
	@Test
	public void testSendReport() throws Exception{

		logger.info("testSendReport() 호출됨.");
		int buytogether_number = 11;
		int type_number = 2;
		int comment_number = 4;
		int declare_category_number = 2;
		int user_number = 6;
		String declare_reason = "qwe";

		DeclareBoard declareBoard = new DeclareBoard(buytogether_number, type_number, comment_number, declare_category_number, user_number, declare_reason);

		dao.sendReport(declareBoard);
	}

	@Ignore
	// buytogetherCheckDao Test
	@Test
	public void testBuytogetherCheckDao() throws Exception{

		logger.info("testFaqCenterList() 호출됨.");
		Integer buytogether_number = 11;
		Integer user_number = 4;		
		dao.buytogetherCheckDao(buytogether_number, user_number);

	}

	@Ignore
	// cancleBuytogetherDao Test
	@Test
	public void testCancleBuytogetherDao() throws Exception{

		logger.info("testCancleBuytogetherDao() 호출됨.");
		Integer buytogether_number = 11;
		Integer user_number = 4;
		dao.cancleBuytogetherDao(buytogether_number, user_number);

	}

	@Ignore
	// joininListDao Test
	@Test
	public void testJoininListDao() throws Exception{

		logger.info("testJoininListDao() 호출됨.");
		Integer buytogether_number = 11;
		List<BuyTogetherDTO> list = dao.joininListDao(buytogether_number);

		for(int i = 0 ; i < list.size() ; i++) {
			logger.info(list.get(i).toString());
		}
	}

	@Ignore
	// joinCheckDao Test
	@Test
	public void testJoinCheckDao() throws Exception{

		logger.info("testJoinCheckDao() 호출됨.");
		Integer joinCheck_userNumber = 1;
		dao.joinCheckDao(joinCheck_userNumber);

	}

	@Ignore
	// JoinCheck2Dao Test
	@Test
	public void testJoinCheck2Dao() throws Exception{

		logger.info("testJoinCheck2Dao() 호출됨.");
		Integer buytogether_number = 11;
		dao.JoinCheck2Dao(buytogether_number);

	}
	
}
