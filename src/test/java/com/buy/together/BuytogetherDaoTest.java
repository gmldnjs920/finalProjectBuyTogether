package com.buy.together;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.buy.together.dao.BuyTogetherDao;
import com.buy.together.domain.AttachedPhoto;
import com.buy.together.domain.ListSearchCriteria;
import com.buy.together.dto.BuyTogetherUpdateDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})

public class BuytogetherDaoTest {

	private static final Logger logger = LoggerFactory.getLogger(BuytogetherDaoTest.class);

	@Inject
	BuyTogetherDao dao;

	// userInterestDao Test
	@Ignore
	@Test
	public void testUserInterestDao() throws Exception {

		logger.info("testUserInterestDao() 호출됨.");
		Integer user_number = 2;
		dao.userInterestDao(user_number);

	}


	// searchBuyTogetherCount Test
	@Ignore
	@Test
	public void testSearchBuyTogetherCount() throws Exception {

		logger.info("testSearchBuyTogetherCount() 호출됨.");
		ListSearchCriteria cri = new ListSearchCriteria();		
		dao.searchBuyTogetherCount(cri);

	}


	// searchBuyTogetherMapList Test
	@Ignore
	@Test
	public void testSearchBuyTogetherMapList() throws Exception {

		logger.info("testSearchBuyTogetherMapList() 호출됨.");
		ListSearchCriteria cri = new ListSearchCriteria();
		dao.searchBuyTogetherMapList(cri);

	}

	// searchBuyTogetherList Test
	@Ignore
	@Test
	public void testsearchBuyTogetherList() throws Exception {

		logger.info("testsearchBuyTogetherList() 호출됨.");
		ListSearchCriteria cri = new ListSearchCriteria();
		dao.searchBuyTogetherList(cri);

	}

	// photoList Test
	@Ignore
	@Test
	public void testPhotoList() throws Exception {

		logger.info("testPhotoList() 호출됨.");
		Integer buytogether_number = 11;
		dao.photoList(buytogether_number);

	}

	// categoryList Test
	@Ignore
	@Test
	public void testCategoryList() throws Exception {

		logger.info("testCategoryList() 호출됨.");
		dao.categoryList();

	}

	// huntingTypeList Test
	@Ignore
	@Test
	public void testHuntingTypeList() throws Exception {

		logger.info("testHuntingTypeList() 호출됨.");
		dao.huntingTypeList();

	}

	// huntingStatusList Test
	@Test
	@Ignore
	public void testHuntingStatusList() throws Exception {

		logger.info("testHuntingStatusList() 호출됨.");
		dao.huntingStatusList();
	}

	// buyTogetherInsert Test
	@Ignore
	@Test
	public void testBuyTogetherInsert() throws Exception {

		logger.info("testBuyTogetherInsert() 호출됨.");
		BuyTogetherUpdateDTO buyTogether = new BuyTogetherUpdateDTO();

		String title = "test";
		String content = "test";
		String duedate = "2017/1/1";
		int price = 2;
		int category_number = 3;
		int user_number = 5;
		int hunting_type_number = 2;

		buyTogether.setTitle(title);
		buyTogether.setContent(content);
		buyTogether.setDuedate(duedate);
		buyTogether.setPrice(price);
		buyTogether.setCategory_number(category_number);
		buyTogether.setUser_number(user_number);
		buyTogether.setHunting_type_number(hunting_type_number);

		dao.buyTogetherInsert(buyTogether);

	}

	// getBuyTogetherNumber Test
	@Ignore
	@Test
	public void testGetBuyTogetherNumber() throws Exception {

		logger.info("testGetBuyTogetherNumber() 호출됨.");
		BuyTogetherUpdateDTO buyTogether = new BuyTogetherUpdateDTO();

		String title = "test";
		String content = "test";
		int user_number = 5;

		buyTogether.setTitle(title);
		buyTogether.setContent(content);
		buyTogether.setUser_number(user_number);

		dao.getBuyTogetherNumber(buyTogether);

	}

	// buyTogetherAddressInsert Test
	@Ignore
	@Test
	public void testBuyTogetherAddressInsert() throws Exception {

		logger.info("testBuyTogetherAddressInsert() 호출됨.");
		BuyTogetherUpdateDTO BuyTogetherAddress = new BuyTogetherUpdateDTO();

		double latitude = 2.3;
		double longitude = 2.3;
		String buytogether_address_sido = "test1";
		String buytogether_address_sigungu = "test2";
		String buytogether_address_road_address = "test3";
		String buytogether_address_detail = "test4";
		int buyTogether_number = 11;

		BuyTogetherAddress.setLatitude(latitude);
		BuyTogetherAddress.setLongitude(longitude);
		BuyTogetherAddress.setBuytogether_address_sido(buytogether_address_sido);
		BuyTogetherAddress.setBuytogether_address_sigungu(buytogether_address_sigungu);
		BuyTogetherAddress.setBuytogether_address_road_address(buytogether_address_road_address);
		BuyTogetherAddress.setBuytogether_address_detail(buytogether_address_detail);
		BuyTogetherAddress.setBuytogether_number(buyTogether_number);


		dao.buyTogetherAddressInsert(BuyTogetherAddress);

	}

	// buyTogetherPhotoInsert Test
	@Test	
	@Ignore
	public void testBuyTogetherPhotoInsert() throws Exception {

		logger.info("testBuyTogetherPhotoInsert() 호출됨.");

		AttachedPhoto AttachedPhoto = new AttachedPhoto();

		String path = "test";
		int buytogether_number = 11;

		AttachedPhoto.setPath(path);
		AttachedPhoto.setBuytogether_number(buytogether_number);

		dao.buyTogetherPhotoInsert(AttachedPhoto);

	}

	// buyTogetherReadOneDao Test
	@Test
	@Ignore
	public void testBuyTogetherReadOneDao() throws Exception {

		logger.info("testBuyTogetherReadOneDao() 호출됨.");
		Integer buytogether_number = 11;

		dao.buyTogetherReadOneDao(buytogether_number);

	}

	// buyTogetherAddressReadOneDao Test
	@Test
	@Ignore
	public void testBuyTogetherAddressReadOneDao() throws Exception {

		logger.info("testBuyTogetherAddressReadOneDao() 호출됨.");
		Integer buytogether_number = 4;

		dao.buyTogetherAddressReadOneDao(buytogether_number);

	}

	// buyTogetherUpdateDao Test
	@Test
	@Ignore
	public void testBuyTogetherUpdateDao() throws Exception {

		logger.info("testBuyTogetherUpdateDao() 호출됨.");
		BuyTogetherUpdateDTO buytogetherUpdateDTO = new BuyTogetherUpdateDTO();

		String title = "test";
		String content = "test";
		int category_number = 1;
		int hunting_type_number = 1;
		String duedate = "2017/2/2";
		int price = 22;
		int join_number = 2;
		int buyTogether_number = 11;

		buytogetherUpdateDTO.setTitle(title);
		buytogetherUpdateDTO.setContent(content);
		buytogetherUpdateDTO.setCategory_number(category_number);
		buytogetherUpdateDTO.setHunting_type_number(hunting_type_number);
		buytogetherUpdateDTO.setDuedate(duedate);
		buytogetherUpdateDTO.setPrice(price);
		buytogetherUpdateDTO.setJoin_number(join_number);
		buytogetherUpdateDTO.setBuytogether_number(buyTogether_number);

		dao.buyTogetherUpdateDao(buytogetherUpdateDTO);

	}

	// buyTogetherUpdateAddressDao Test
	@Test
	@Ignore
	public void testBuyTogetherUpdateAddressDao() throws Exception {

		logger.info("testBuyTogetherUpdateAddressDao() 호출됨.");
		BuyTogetherUpdateDTO buytogetherUpdateDTO = new BuyTogetherUpdateDTO();

		double latitude = 4.5;
		double longitude = 4.5;
		String buytogether_address_sido = "test1test";
		String buytogether_address_sigungu = "test2test";
		String buytogether_address_road_address = "test3testt";
		String buytogether_address_detail = "test4test";
		int buyTogether_number = 11;

		buytogetherUpdateDTO.setLatitude(latitude);
		buytogetherUpdateDTO.setLongitude(longitude);
		buytogetherUpdateDTO.setBuytogether_address_sido(buytogether_address_sido);
		buytogetherUpdateDTO.setBuytogether_address_sigungu(buytogether_address_sigungu);
		buytogetherUpdateDTO.setBuytogether_address_road_address(buytogether_address_road_address);
		buytogetherUpdateDTO.setBuytogether_address_detail(buytogether_address_detail);
		buytogetherUpdateDTO.setBuytogether_number(buyTogether_number);

		dao.buyTogetherUpdateAddressDao(buytogetherUpdateDTO);
	}

	// buyTogetherPhotoDeleteDao Test
	@Test
	public void testBuyTogetherPhotoDeleteDao() throws Exception {

		logger.info("testBuyTogetherPhotoDeleteDao() 호출됨.");
		Integer buytogether_number = 11;
		
		dao.buyTogetherPhotoDeleteDao(buytogether_number);
	}





}
