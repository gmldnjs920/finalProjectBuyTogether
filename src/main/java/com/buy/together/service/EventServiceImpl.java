package com.buy.together.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.buy.together.dao.EventDao;
import com.buy.together.domain.AttachedPhoto;
import com.buy.together.domain.MyCriteria;
import com.buy.together.dto.BoardDTO;

@Service
public class EventServiceImpl implements EventService {

	@Inject
	private EventDao dao;
	
	//정보사냥 사진 목록
	@Override
	public List<AttachedPhoto> eventPhotoList(Integer board_number) throws Exception {
		
		return dao.eventPhotoList(board_number);
	}

	//정보사냥 목록
	@Override
	public List<BoardDTO> eventListAll(MyCriteria cri) throws Exception {

	     List<BoardDTO> eventListAll = dao.eventListAll(cri);

	      for(int i = 0; i<eventListAll.size(); i++){
	         List<AttachedPhoto> attachedPhotos = dao.eventPhotoList(eventListAll.get(i).getBoard_number());

	         eventListAll.get(i).setPath(attachedPhotos);
	      }
	      
	      return eventListAll;
	   }

	//정보사냥 조회
	@Override
	public BoardDTO eventListOne(Integer board_number) throws Exception {
	
		BoardDTO eventListOne = dao.eventListOne(board_number);
		
		List<AttachedPhoto> attachedPhotos = dao.eventPhotoList(eventListOne.getBoard_number());
		
		eventListOne.setPath(attachedPhotos);
		
		return eventListOne;
	
	}
	
	//정보사냥 검색
	@Override
	public int searchEventListCount(MyCriteria cri) throws Exception {

		return dao.searchEventListCount(cri);
	}

}
