package com.buy.together.service;

import java.util.List;

import com.buy.together.domain.AttachedPhoto;
import com.buy.together.domain.MyCriteria;
import com.buy.together.dto.BoardDTO;


public interface EventService {
	
	//정보사냥 사진 리스트
	public List<AttachedPhoto> eventPhotoList(Integer board_number) throws Exception;

	//정보사냥 목록
	public List<BoardDTO> eventListAll(MyCriteria cri) throws Exception;
	
	//정보사냥 조회
	public BoardDTO eventListOne(Integer board_number) throws Exception;
	
	//정보사냥 카운트
	public int searchEventListCount(MyCriteria cri) throws Exception;
	
}
