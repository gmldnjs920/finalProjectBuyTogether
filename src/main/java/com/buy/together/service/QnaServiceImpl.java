package com.buy.together.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.buy.together.dao.QnaDao;
import com.buy.together.domain.AttachedPhoto;
import com.buy.together.domain.MyCriteria;
import com.buy.together.dto.QnaDTO;

@Service
public class QnaServiceImpl implements QnaService {

	@Inject
	private QnaDao dao;
	
	//qna용 사진 리스트
	@Override
	public List<AttachedPhoto> qnaPhotoList(Integer qna_number) throws Exception {
	
		return dao.qnaPhotoList(qna_number);
	}
	
	//qna 목록
	@Override
	public List<QnaDTO> qnaListAll(MyCriteria cri) throws Exception {
		
		 List<QnaDTO> qnaListAll = dao.qnaListAll(cri);

	      for(int i = 0; i<qnaListAll.size(); i++){
	         List<AttachedPhoto> attachedPhotos = dao.qnaPhotoList(qnaListAll.get(i).getQna_number()); 
	    
	         qnaListAll.get(i).setPath(attachedPhotos);
	      }
	      
	      return qnaListAll;
	   }

	//qna 조회
	@Override
	public QnaDTO qnaListOne(Integer qna_number) throws Exception {
		
		QnaDTO qnaListOne = dao.qnaListOne(qna_number);
		
		List<AttachedPhoto> attachedPhotos = dao.qnaPhotoList(qnaListOne.getQna_number());
			
		qnaListOne.setPath(attachedPhotos);
		
		return qnaListOne;
	
	}

	//qna 카운트
	@Override
	public int searchQnaListCount(MyCriteria cri) throws Exception {
		
		return dao.searchQnaListCount(cri);
	}

	//qna 삭제
	@Override
	public void qnaDelete(Integer qna_number) throws Exception {
	
		dao.qnaDelete(qna_number);
		
	}

	//qna 수정
	@Override
	public void qnaUpadte(QnaDTO qnaDTO) throws Exception {
		
		dao.qnaUpdate(qnaDTO);
		
	}
	
	//qna 등록
	@Override
	public void qnaInsert(QnaDTO qnaDTO) throws Exception {
	
		dao.qnaInsert(qnaDTO);
		
	}

	//qna 수정완료
	@Override
	public void qnaDoneUpdate(QnaDTO qnaDTO) throws Exception {
		
		dao.qnaDoneUpdate(qnaDTO);
		
	}	
		
}
