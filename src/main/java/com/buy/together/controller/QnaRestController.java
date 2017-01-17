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
import com.buy.together.dto.QnaDTO;
import com.buy.together.service.QnaService;


@RestController
@RequestMapping("/restQna/*")
public class QnaRestController {

	private static final Logger logger = LoggerFactory.getLogger(QnaRestController.class);

	@Inject
	private QnaService service;

	//qna 목록
	@RequestMapping(value = "qnaListAll", method = {RequestMethod.POST,RequestMethod.GET})
	public ResponseEntity<Map<String, Object>> qnaListAll(@RequestBody MyCriteria cri) {

		ResponseEntity<Map<String, Object>> entity = null;


		try {
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);

			int searchQnaListCount = service.searchQnaListCount(cri);
			pageMaker.setTotalCount(searchQnaListCount);

			Map<String, Object> map = new HashMap<String, Object>();
			List<QnaDTO> qnaListAll = service.qnaListAll(cri);

			map.put("qnaListAll", qnaListAll);
			map.put("pageMaker", pageMaker);	

			entity = new ResponseEntity<>(map, HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
		return entity;
	}

	//qna 조회
	@RequestMapping(value = "qnaListOne/{qna_number}", method = RequestMethod.GET)
	public ResponseEntity<QnaDTO> qnaListOne(@PathVariable("qna_number") Integer qna_number) {


		ResponseEntity<QnaDTO> entity = null;

		try {

			entity = new ResponseEntity<>(service.qnaListOne(qna_number), HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
		return entity;
	}

	//qna 삭제
	@RequestMapping(value = "qnaDelete/{qna_number}", method = {RequestMethod.DELETE, RequestMethod.GET})
	public ResponseEntity<String> qnaDelete (@PathVariable("qna_number")Integer qna_number){

		ResponseEntity<String> entity = null;
		try{
			service.qnaDelete(qna_number);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(
					e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	
		return entity;

	}

	//qna 수정			
	@RequestMapping(value = "qnaUpdate/{qna_number}", method = {RequestMethod.PUT, RequestMethod.PATCH})
	public ResponseEntity<String> qnaUpadte(@PathVariable("qna_number") Integer qna_number,@RequestBody QnaDTO qnaDTO){

		ResponseEntity<String> entity = null;
		try{
			qnaDTO.setQna_number(qna_number);
			service.qnaUpadte(qnaDTO);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(
					e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;

	}

	//qna 등록
	@RequestMapping(value = "qnaInsert", method = RequestMethod.POST)
	public ResponseEntity<String> qnaInsert(@RequestBody QnaDTO qnaDTO) {
		
		ResponseEntity<String> entity = null;

		try {
			service.qnaInsert(qnaDTO);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}

		return entity;
		
	}
	
	//qna 수정완료
	@RequestMapping(value = "qnaDoneUpdate", method = RequestMethod.POST)
	public ResponseEntity<String> qnaDoneUpdate(@RequestBody QnaDTO qnaDTO) {
		
		ResponseEntity<String> entity = null;
		System.out.println("entity = " + entity);
		try {
			service.qnaDoneUpdate(qnaDTO);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
		
		return entity;
		
	}

}
