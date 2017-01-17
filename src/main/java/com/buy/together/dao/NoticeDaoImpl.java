package com.buy.together.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.buy.together.domain.Board;
import com.buy.together.domain.MyCriteria;
import com.buy.together.dto.BoardDTO;

@Repository
public class NoticeDaoImpl implements NoticeDao {
	
	private static final String Namespace="com.buy.together.mappers.noticeMapper";
	
	@Inject
	private SqlSession sql;

	//공지사항 목록
	@Override
	public List<BoardDTO> noticeListAll(MyCriteria cri) throws Exception {
		
		return sql.selectList(Namespace + ".noticeListAll", cri);
	
	}

	//공지사항 조회
	@Override
	public BoardDTO noticeListOne(Integer board_number) throws Exception {
		
		return sql.selectOne(Namespace + ".noticeListOne", board_number);
	}

	@Override
	public int searchNoticeListCount(MyCriteria cri) throws Exception {
		
		return sql.selectOne(Namespace + ".searchNoticeListCount", cri);
	}

	@Override
	public void noticeDelete(Integer board_number) {

		sql.selectOne(Namespace + ".noticeDelete", board_number);
	}

	@Override
	public void noticeInsert(Board board) throws Exception {
		
		sql.insert(Namespace + ".noticeInsert", board);
	}

}
