package com.buy.together.dao;

import java.util.List;

import com.buy.together.domain.AttachedPhoto;
import com.buy.together.domain.BuyTogether;
import com.buy.together.domain.BuyTogetherAddress;
import com.buy.together.domain.Category;
import com.buy.together.domain.HuntingStatus;
import com.buy.together.domain.HuntingType;
import com.buy.together.domain.ListSearchCriteria;
import com.buy.together.dto.BuyTogetherDTO;
import com.buy.together.dto.BuyTogetherMapDTO;
import com.buy.together.dto.BuyTogetherUpdateDTO;

public interface BuyTogetherDao {
	
	public Integer userInterestDao(Integer user_number) throws Exception;
	
	public Integer userAddressDao(Integer user_number) throws Exception;
	
	public Integer searchBuyTogetherCount(ListSearchCriteria cri) throws Exception;
	
	public Integer searchBuyTogetherMapCount(ListSearchCriteria cri) throws Exception;
	
	public List<BuyTogetherMapDTO> searchBuyTogetherMapList(ListSearchCriteria cri) throws Exception;
		
	public List<BuyTogetherDTO> searchBuyTogetherList(ListSearchCriteria cri) throws Exception;
	
	public List<AttachedPhoto> photoList(Integer buytogether_number) throws Exception;
	
	public List<Category> categoryList() throws Exception;
	
	public List<HuntingType> huntingTypeList() throws Exception;
	
	public List<HuntingStatus> huntingStatusList() throws Exception;
	
	public void buyTogetherInsert(BuyTogetherUpdateDTO buyTogether) throws Exception;
	
	public Integer getBuyTogetherNumber(BuyTogetherUpdateDTO buyTogether) throws Exception;

	public void buyTogetherAddressInsert(BuyTogetherUpdateDTO BuyTogetherAddress) throws Exception;
	
	public void buyTogetherPhotoInsert(AttachedPhoto AttachedPhoto) throws Exception;
	


	public BuyTogether buyTogetherReadOneDao(Integer buytogether_number) throws Exception;
	
	public BuyTogetherAddress buyTogetherAddressReadOneDao(Integer buytogether_number) throws Exception;
	
	public void buyTogetherUpdateDao(BuyTogetherUpdateDTO buytogetherUpdateDTO) throws Exception;

	public void buyTogetherUpdateAddressDao(BuyTogetherUpdateDTO buytogetherUpdateDTO) throws Exception;

	public void buyTogetherPhotoDeleteDao(Integer buytogether_number) throws Exception;

}
