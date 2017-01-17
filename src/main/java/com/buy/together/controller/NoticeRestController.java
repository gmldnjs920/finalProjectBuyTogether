package com.buy.together.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.buy.together.domain.Board;
import com.buy.together.domain.MyCriteria;
import com.buy.together.domain.PageMaker;
import com.buy.together.dto.BoardDTO;
import com.buy.together.service.NoticeService;

@Controller
@RequestMapping("/restNotice")
public class NoticeRestController {

	private static final Logger logger = LoggerFactory.getLogger(NoticeRestController.class);

	@Inject
	private NoticeService service;

	@RequestMapping(value = "list", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> requestNoticeListAll(@RequestBody MyCriteria cri) {

		ResponseEntity<Map<String, Object>> entity = null;

		try {
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);

			int searchNoticeListCount = service.searchNoticeListCount(cri);
			pageMaker.setTotalCount(searchNoticeListCount);

			Map<String, Object> map = new HashMap<String, Object>();
			List<BoardDTO> noticeListAll = service.noticeListAll(cri);
			map.put("noticeListAll", noticeListAll);
			map.put("pageMaker", pageMaker);

			entity = new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	//공지사항 쓰기
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public ResponseEntity<String> requestNoticeWrite(Board board) {

		ResponseEntity<String> entity = null;

		try {
			service.noticeWrite(board);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);

		}

		return entity;
	}
	
	//공지사항 조회
	@RequestMapping(value = "listOne/{board_number}", method = RequestMethod.GET)
	public ResponseEntity<BoardDTO> requestNoticeListOne(@PathVariable("board_number") Integer board_number) {

		ResponseEntity<BoardDTO> entity = null;

		try {
			entity = new ResponseEntity<BoardDTO>(service.noticeListOne(board_number), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<BoardDTO>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
}