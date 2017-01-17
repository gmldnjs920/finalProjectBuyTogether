package com.buy.together;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.buy.together.dao.QnaDao;
import com.buy.together.domain.MyCriteria;
import com.buy.together.dto.QnaDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class QnaDaoTest {

	@Inject
	QnaDao dao;

	@Test
	@Ignore
	public void testQnaPhotoList() throws Exception {


		Integer qna_number = 2;
		dao.qnaPhotoList(qna_number);


	}

	@Test
	@Ignore
	public void testQnaListAll() throws Exception {


		MyCriteria cri = new MyCriteria();

		Integer user_number = 1;

		cri.setUser_number(user_number);
		dao.qnaListAll(cri);


	}


	@Test
	@Ignore
	public void testQnaListOne() throws Exception {

		Integer qna_number = 1;
		dao.qnaListOne(qna_number);

	}


	@Test
	@Ignore
	public void testSearchQnaListCount() throws Exception {

		MyCriteria cri = new MyCriteria();

		Integer user_number = 1;

		cri.setUser_number(user_number);

		dao.searchQnaListCount(cri);


	}

	@Test
	@Ignore
	public void testQnaDelete() throws Exception {

		Integer qna_number = 2;
		dao.qnaDelete(qna_number);

	}


	@Test
	@Ignore
	public void testQnaUpdate() throws Exception {


		QnaDTO qnaDTO = new QnaDTO();
		
		String qna_title = "test";
		String qna_content = "test";
		int qna_number = 2;
		
		qnaDTO.setQna_title(qna_title);
		qnaDTO.setQna_content(qna_content);
		qnaDTO.setQna_number(qna_number);
		
		dao.qnaUpdate(qnaDTO);

	}
	
	@Test
	@Ignore
	public void testqnaInsert() throws Exception {

		QnaDTO qnaDTO = new QnaDTO();
		
		String qna_title = "test";
		String qna_content = "test";
		int user_number = 4;
		
		qnaDTO.setQna_title(qna_title);
		qnaDTO.setQna_content(qna_content);
		qnaDTO.setUser_number(user_number);
		
		dao.qnaInsert(qnaDTO);

	}
	
	@Test
	@Ignore
	public void testQnaDoneUpdate() throws Exception {

		
		QnaDTO qnaDTO = new QnaDTO();
			
		String qna_title = "test";
		String qna_content = "test";
		int user_number = 4;
		
		qnaDTO.setQna_title(qna_title);
		qnaDTO.setQna_content(qna_content);
		qnaDTO.setUser_number(user_number);
		
		dao.qnaDoneUpdate(qnaDTO);

	}

}