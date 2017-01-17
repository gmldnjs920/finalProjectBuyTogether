package com.buy.together.dao;


import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.buy.together.domain.AttachedPhoto;
import com.buy.together.domain.MyCriteria;
import com.buy.together.domain.User;
import com.buy.together.dto.BoardDTO;
import com.buy.together.dto.BuyTogetherDTO;
import com.buy.together.dto.QnaDTO;

@Repository
public class QnaDaoImpl implements QnaDao {

	private static final String namespace="com.buy.together.mappers.qnaMapper";
	
	@Inject
	private SqlSession sqlSession;
	
	//qna용 사진 리스트
	@Override
	public List<AttachedPhoto> qnaPhotoList(Integer qna_number) throws Exception {

		return sqlSession.selectList(namespace+".qnaPhotoList", qna_number);
	}
	
	//qna 목록
	@Override
	public List<QnaDTO> qnaListAll(MyCriteria cri) throws Exception {
		
		return sqlSession.selectList(namespace+".qnaListAll",cri);
	}

	//qna 조회
	@Override
	public QnaDTO qnaListOne(Integer qna_number) throws Exception {

		return sqlSession.selectOne(namespace+".qnaListOne", qna_number);
	}

	//qna 카운트
	@Override
	public int searchQnaListCount(MyCriteria cri) throws Exception {
		
		return sqlSession.selectOne(namespace+".searchQnaListCount", cri);
	}

	//qna 삭제
	@Override
	public void qnaDelete(Integer qna_number) throws Exception {
		
		sqlSession.delete(namespace+".qnaDelete", qna_number);
		
	}

	//qna 수정
	@Override
	public void qnaUpdate(QnaDTO qnaDTO) throws Exception {
		
		sqlSession.update(namespace+".qnaUpdate", qnaDTO);
		
	}

	//qna 등록
	@Override
	public void qnaInsert(QnaDTO qnaDTO) throws Exception {
		
		sqlSession.insert(namespace+".qnaInsert", qnaDTO);
		
	}

	//qna 수정 완료
	@Override
	public void qnaDoneUpdate(QnaDTO qnaDTO) throws Exception {
		
		sqlSession.update(namespace+".qnaDoneUpdate", qnaDTO);
		
	}
	

	
}
