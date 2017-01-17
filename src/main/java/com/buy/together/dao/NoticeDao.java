package com.buy.together.dao;

import java.util.List;

import com.buy.together.domain.Board;
import com.buy.together.domain.MyCriteria;
import com.buy.together.dto.BoardDTO;

public interface NoticeDao {
	
	public List<BoardDTO> noticeListAll(MyCriteria cri) throws Exception;

	public BoardDTO noticeListOne(Integer board_number) throws Exception;

	public int searchNoticeListCount(MyCriteria cri) throws Exception;

	public void noticeDelete(Integer board_number) throws Exception;

	public void noticeInsert(Board board) throws Exception;

}
