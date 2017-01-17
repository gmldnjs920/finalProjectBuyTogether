package com.buy.together.service;

import java.util.List;

import com.buy.together.domain.AttachedPhoto;
import com.buy.together.domain.MyCriteria;
import com.buy.together.dto.QnaDTO;


public interface QnaService {
	
	//qna 사진 리스트
	public List<AttachedPhoto> qnaPhotoList(Integer qna_number) throws Exception;
	
	//qna 목록
	public List<QnaDTO> qnaListAll(MyCriteria cri) throws Exception;
	
	//qna 조회
	public QnaDTO qnaListOne(Integer qna_number) throws Exception;
	
	//qna 카운트
	public int searchQnaListCount(MyCriteria cri) throws Exception;
	
	//qna 삭제
	public void qnaDelete(Integer qna_number) throws Exception;
	
	//qna 수정
	public void qnaUpadte(QnaDTO qnaDTO) throws Exception;

	//qna 등록
	public void qnaInsert(QnaDTO qnaDTO) throws Exception;
	
	//qna 수정 완료
	public void qnaDoneUpdate(QnaDTO qnaDTO) throws Exception;
	
}
