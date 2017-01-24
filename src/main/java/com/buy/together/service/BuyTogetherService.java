package com.buy.together.service;

import java.util.List;

import com.buy.together.domain.Category;
import com.buy.together.domain.HuntingStatus;
import com.buy.together.domain.HuntingType;
import com.buy.together.domain.ListSearchCriteria;
import com.buy.together.dto.BuyTogetherDTO;
import com.buy.together.dto.BuyTogetherMapDTO;
import com.buy.together.dto.BuyTogetherUpdateDTO;
import com.buy.together.dto.BuyTogetherWriteDTO;

public interface BuyTogetherService {
	
	public Integer userInterest(Integer user_number) throws Exception;
	
	public Integer userAddress(Integer user_number) throws Exception;
	
	public Integer searchBuyTogetherCount(ListSearchCriteria cri) throws Exception;
	
	public Integer searchBuyTogetherMapCount(ListSearchCriteria cri) throws Exception;
	
	public List<BuyTogetherMapDTO> searchBuyTogetherMapList(ListSearchCriteria cri) throws Exception;
	
	public List<BuyTogetherDTO> searchBuyTogetherList(ListSearchCriteria cri) throws Exception;
	
	public List<Category> categoryList() throws Exception;
	
	public List<HuntingType> huntingTypeList() throws Exception;
	
	public List<HuntingStatus> huntingStatusList() throws Exception;
	
	public void buyTogetherWrite(BuyTogetherUpdateDTO buytogether) throws Exception;

	public BuyTogetherWriteDTO buyTogetherReadOne(Integer buytogether_number) throws Exception;

	public void buyTogetherUpdate(BuyTogetherUpdateDTO buyTogetherUpdateDTO) throws Exception;

}
