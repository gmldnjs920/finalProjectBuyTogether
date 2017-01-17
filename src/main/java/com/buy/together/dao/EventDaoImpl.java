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
public class EventDaoImpl implements EventDao {

	private static final String namespace="com.buy.together.mappers.eventMapper";
	
	@Inject
	private SqlSession sqlSession;
	
	//정보사냥용 사진 리스트
	@Override
	public List<AttachedPhoto> eventPhotoList(Integer board_number) throws Exception {
		
		return sqlSession.selectList(namespace+".eventPhotoList", board_number);
	}
	
	//정보사냥 목록
	@Override
	public List<BoardDTO> eventListAll(MyCriteria cri) throws Exception {
	
		return sqlSession.selectList(namespace+".eventListAll", cri);
	}

	//정보사냥 조회
		@Override
		public BoardDTO eventListOne(Integer board_number) throws Exception {
			
			return sqlSession.selectOne(namespace+".eventListOne", board_number);
		}

	//정보사냥 검색
	@Override
	public int searchEventListCount(MyCriteria cri) throws Exception {
	
		return sqlSession.selectOne(namespace+".searchEventListCount", cri);
	}
	
}
