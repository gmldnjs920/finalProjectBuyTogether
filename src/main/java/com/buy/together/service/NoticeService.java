package com.buy.together.service;

import java.util.List;

import com.buy.together.domain.Board;
import com.buy.together.domain.MyCriteria;
import com.buy.together.dto.BoardDTO;

public interface NoticeService {
	
	//공지사항 목록
	public List<BoardDTO> noticeListAll(MyCriteria cri) throws Exception;
	
	//공지사항 조회
	public BoardDTO noticeListOne(Integer board_number) throws Exception;
	
	//공지사항 카운트
	public int searchNoticeListCount(MyCriteria cri) throws Exception;

	//공지사항 삭제
	public void noticeDelete(Integer board_number) throws Exception;

	public void noticeWrite(Board board) throws Exception;

}
