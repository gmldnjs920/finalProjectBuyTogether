package com.buy.together.dao;

import java.util.List;

import com.buy.together.dto.BuyTogetherDTO;

public interface SearchDao {
	
	public List<BuyTogetherDTO> searchBuyTogether(String keyWord) throws Exception;

}
