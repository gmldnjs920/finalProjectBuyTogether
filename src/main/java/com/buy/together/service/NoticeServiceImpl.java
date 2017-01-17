package com.buy.together.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.buy.together.dao.NoticeDao;
import com.buy.together.domain.Board;
import com.buy.together.domain.MyCriteria;
import com.buy.together.dto.BoardDTO;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Inject
	private NoticeDao dao;

	//공지사항 목록
	@Override
	public List<BoardDTO> noticeListAll(MyCriteria cri) throws Exception {
		
		List<BoardDTO> noticeListAll = dao.noticeListAll(cri);
		
		return noticeListAll;
	}

	//공지사항 조회
	@Override
	public BoardDTO noticeListOne(Integer board_number) throws Exception {
		
		BoardDTO noticeListOne = dao.noticeListOne(board_number);
	
		return noticeListOne;
		
	}

	@Override
	public int searchNoticeListCount(MyCriteria cri) throws Exception {
		
		return dao.searchNoticeListCount(cri);
	}

	@Override
	public void noticeDelete(Integer board_number) throws Exception {
		
		dao.noticeDelete(board_number);
		
	}

	@Override
	public void noticeWrite(Board board) throws Exception {

		dao.noticeInsert(board);
	}
	
}
