package com.buy.together.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/indexer")	
public class IndexerController {

	private static final Logger logger = LoggerFactory.getLogger(IndexerController.class);

	@RequestMapping(value ="", method = RequestMethod.GET)
	public String requestIndexerList(Locale locale) {

		System.out.println("IndexerController/indexer");

		return "/views/admin/indexer";
		
	}
	
}
