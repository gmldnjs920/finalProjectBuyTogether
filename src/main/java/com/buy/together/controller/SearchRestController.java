package com.buy.together.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.buy.together.dto.BuyTogetherDTO;
import com.buy.together.service.SearchService;

@RestController
@RequestMapping("/restSearch")
public class SearchRestController {
	
	@Inject
	private SearchService searchService;	
	private static final Logger logger = LoggerFactory.getLogger(SearchRestController.class);
	
	//
	@RequestMapping(value="/buyTogether", method = RequestMethod.POST)
	public ResponseEntity<List<BuyTogetherDTO>> searchBuyTogether(String[] keyWords) {

		ResponseEntity <List<BuyTogetherDTO>> entity = null;
		List<BuyTogetherDTO> searchList = null;
		
		try {
			searchList = searchService.searchBuyTogether(keyWords);
			entity = new ResponseEntity<List<BuyTogetherDTO>>(searchList, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<BuyTogetherDTO>>(searchList, HttpStatus.BAD_REQUEST); // HttpStatus.BAD_REQUEST == 400
		}

		return entity;
		
	}

}
