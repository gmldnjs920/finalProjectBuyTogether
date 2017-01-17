package com.buy.together.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.buy.together.domain.MyCriteria;
import com.buy.together.domain.PageMaker;
import com.buy.together.dto.BoardDTO;
import com.buy.together.service.EventService;


@RestController
@RequestMapping("/restEvent/*")
public class EventRestController {

	private static final Logger logger = LoggerFactory.getLogger(EventRestController.class);

	@Inject
	private EventService service;

	//정보사냥 목록
	@RequestMapping(value = "eventListAll", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> eventListAll(@RequestBody MyCriteria cri) {

		ResponseEntity<Map<String, Object>> entity = null;

		try {
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);

			int searchEventListCount = service.searchEventListCount(cri);
			pageMaker.setTotalCount(searchEventListCount);

			Map<String, Object> map = new HashMap<String, Object>();
			List<BoardDTO> eventListAll = service.eventListAll(cri);

			map.put("eventListAll", eventListAll);
			map.put("pageMaker", pageMaker);	

			entity = new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
		
	}

	//정보사냥 조회

	@RequestMapping(value = "eventListOne/{board_number}", method = RequestMethod.GET)
	public ResponseEntity<BoardDTO> ListTest2(@PathVariable("board_number") Integer board_number) {

		ResponseEntity<BoardDTO> entity = null;

		try {
			entity = new ResponseEntity<>(service.eventListOne(board_number), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
		
	}

}
