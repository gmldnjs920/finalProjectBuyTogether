package com.buy.together;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.buy.together.dao.EventDao;
import com.buy.together.dao.QnaDao;
import com.buy.together.domain.MyCriteria;
import com.buy.together.dto.QnaDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class EventDaoTest {

	@Inject
	EventDao dao;

	@Test
	@Ignore
	public void testEventPhotoList() throws Exception {
		
		Integer board_number = 2;
		
		dao.eventPhotoList(board_number);

	}
	
	
	@Test
	@Ignore
	public void testEventListAll() throws Exception {
		
		
		MyCriteria cri = new MyCriteria();
		
		String keyword = "test";
		int page = 1;
		int perPageNum = 1;
		String searchType = "test";
		int user_number = 3;
		
		cri.setKeyword(keyword);
		cri.setPage(page);
		cri.setPerPageNum(perPageNum);
		cri.setSearchType(searchType);
		cri.setUser_number(user_number);
		
		dao.eventListAll(cri);

	}
	
	@Test
	@Ignore
	public void testEventListOne() throws Exception {
		
		Integer board_number = 2;
		
		dao.eventListOne(board_number);

	}
	
	@Test
	@Ignore
	public void testSearchEventListCount() throws Exception {
			
		MyCriteria cri = new MyCriteria();
		
		String keyword = "test";
		String searchType = "test";
		
		cri.setKeyword(keyword);
		cri.setSearchType(searchType);
		
		dao.searchEventListCount(cri);

	}
	
}