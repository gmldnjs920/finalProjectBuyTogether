package com.buy.together.service;

import java.util.List;

import com.buy.together.dto.BuyTogetherDTO;

public interface SearchService {
	
	public List<BuyTogetherDTO> searchBuyTogether(String[] keyWords) throws Exception;
	
}
