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

import com.buy.together.dao.FaqDao;
import com.buy.together.domain.Board;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})

public class FaqDaoTest {

	private static final Logger logger = LoggerFactory.getLogger(FaqDaoTest.class);
	
	@Inject
	FaqDao dao;
	
	@Ignore
	//FaqAllList [전체보기]Test
	@Test
	public void testFaqAllList() throws Exception {
		
		logger.info("testFaqAllList() 호출됨.");
		List<Board> list = dao.faqAllList();
		
		for(int i = 0 ; i < list.size() ; i++) {
			logger.info(list.get(i).toString());
		}
		
	}
	
	@Ignore
	//FaqUserList [회원관련]Test
	@Test
	public void testFaqUserList() throws Exception{
		
		logger.info("testFaqUserList() 호출됨.");
		List<Board> list = dao.faqUserList();
		
		for(int i = 0 ; i < list.size() ; i++) {
			logger.info(list.get(i).toString());
		}
	}
	
	@Ignore
	//FaqBuyList [사냥관련]Test
	@Test
	public void testFaqBuyList() throws Exception{
		
		logger.info("testFaqBuyList() 호출됨.");
		List<Board> list = dao.faqBuyList();
		
		for(int i = 0 ; i < list.size() ; i++) {
			logger.info(list.get(i).toString());
		}
		
	}
	
	@Ignore
	//FaqInfoList [정보관련]Test
	@Test
	public void testFaqInfoList() throws Exception{
		
		logger.info("testFaqInfoList() 호출됨.");
		List<Board> list = dao.faqInfoList();
		
		for(int i = 0 ; i < list.size() ; i++) {
			logger.info(list.get(i).toString());
		}
		
	}
	
	@Ignore
	//FaqCenterList [고객센터]Test
	@Test
	public void testFaqCenterList() throws Exception{
		
		logger.info("testFaqCenterList() 호출됨.");
		List<Board> list = dao.faqCenterList();
		
		for(int i = 0 ; i < list.size() ; i++) {
			logger.info(list.get(i).toString());
		}
	}
	
}
