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

import com.buy.together.domain.JoinUserInfo;
import com.buy.together.domain.MySearchCriteria;
import com.buy.together.domain.PageMaker;
import com.buy.together.domain.ScoreUserInfo;
import com.buy.together.dto.BuyTogetherDTO;
import com.buy.together.service.MyBuyTogetherService;

@RestController
@RequestMapping("/restMyBuytogether/*")
public class MyBuyTogetherRestController {

	private static final Logger logger = LoggerFactory.getLogger(MyBuyTogetherRestController.class);

	@Inject
	private MyBuyTogetherService service;

	/*---------------------------------------개설한 같이사냥--------------------------------------*/
	@RequestMapping(value = "requestOpenBuyTogether/", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> requestOpenBuyTogether(@RequestBody MySearchCriteria scri) {
		ResponseEntity<Map<String, Object>> entity = null;

		try {
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(scri);

			int searchMyBuyTogetherCount = service.searchMyBuyTogetherCount(scri);
			pageMaker.setTotalCount(searchMyBuyTogetherCount);

			Map<String, Object> map = new HashMap<String, Object>();
			List<BuyTogetherDTO> searchMyBuyTogether = service.searchOpenBuyTogether(scri);

			map.put("searchMyBuyTogether", searchMyBuyTogether);
			map.put("pageMaker", pageMaker);

			entity = new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception e) {

			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
		return entity;
	}

	/*---------------------------참여한 같이사냥------------------------------*/	
	@RequestMapping(value = "requestJoinBuyTogether/", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> requestjoinBuyTogether(@RequestBody MySearchCriteria scri) {
		ResponseEntity<Map<String, Object>> entity = null;
		
		try {
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(scri);

			int searchMyBuyTogetherCount = service.searchJoinBuyTogetherCount(scri);
			pageMaker.setTotalCount(searchMyBuyTogetherCount);

			Map<String, Object> map = new HashMap<String, Object>();
			List<BuyTogetherDTO> searchMyBuyTogether = service.searchJoinBuyTogether(scri);

			map.put("searchMyBuyTogether", searchMyBuyTogether);
			map.put("pageMaker", pageMaker);

			entity = new ResponseEntity<>(map, HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
		return entity;
	}


	/*---------------------------완료한 같이사냥------------------------------*/
	@RequestMapping(value = "requestDoneBuyTogether/", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> requestDoneBuyTogether(@RequestBody MySearchCriteria scri) {
		ResponseEntity<Map<String, Object>> entity = null;
		
		try {
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(scri);

			int searchMyBuyTogetherCount = service.searchDoneBuyTogetherCount(scri);
			pageMaker.setTotalCount(searchMyBuyTogetherCount);

			Map<String, Object> map = new HashMap<String, Object>();
			List<BuyTogetherDTO> searchMyBuyTogether = service.searchDoneBuyTogether(scri);

			map.put("searchMyBuyTogether", searchMyBuyTogether);
			map.put("pageMaker", pageMaker);

			entity = new ResponseEntity<>(map, HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
		return entity;
	}

	/*---------------------------(개설한)유저목록 가져오기------------------------------*/
	@RequestMapping(value = "requestOpenReputation/{buyTogetherNumber}", method = RequestMethod.GET)
	public ResponseEntity<List<JoinUserInfo>> requestOpenReputation(@PathVariable("buyTogetherNumber") int buyTogetherNumber){
		ResponseEntity<List<JoinUserInfo>> entity = null;
		
		try {
			List<JoinUserInfo> joinUser_list = service.openReputaion(buyTogetherNumber);
			entity = new ResponseEntity<List<JoinUserInfo>>(joinUser_list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<JoinUserInfo>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	/*---------------------------(개설한)평판점수 보내기------------------------------*/
	@RequestMapping(value = "requestReputationScore", method = RequestMethod.POST)
	public ResponseEntity<String> requestRequestReputationScore (String[] scoreUserInfoList)	{

		ResponseEntity<String> entity = null;

		try {
			service.scoreUserInfo(scoreUserInfoList);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	/*---------------------------(개설한) 1인 평판점수 보내기------------------------------*/
	@RequestMapping(value = "requestReputationScoreForOne", method = RequestMethod.POST)
	public ResponseEntity<String> requestReputationScoreForOne (String[] scoreUserInfoList)	{

		ResponseEntity<String> entity = null;

		try {

			service.scoreUserInfoForOne(scoreUserInfoList);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	/*---------------------------같이사냥 완료하기------------------------------*/
	@RequestMapping(value = "requestFinishBuyTogether/{buyTogetherNumber}", method = RequestMethod.GET)
	public ResponseEntity<String> requestFinishBuyTogether(@PathVariable("buyTogetherNumber") int buyTogetherNumber) {
		ResponseEntity<String> entity = null;
		
		try {

			service.finishBuyTogether(buyTogetherNumber);
			entity = new ResponseEntity<>("success", HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
		return entity;
	}

	/*---------------------------(참여한)유저목록 가져오기------------------------------*/
	@RequestMapping(value = "requestJoinReputation/{buyTogetherNumber}", method = RequestMethod.GET)
	public ResponseEntity<JoinUserInfo> requestJoinReputation(@PathVariable("buyTogetherNumber") int buyTogetherNumber) {
		ResponseEntity<JoinUserInfo> entity = null;
		
		try {

			JoinUserInfo UserInfo = service.joinReputaion(buyTogetherNumber);

			UserInfo.setBuyTogetherNumber(buyTogetherNumber);

			entity = new ResponseEntity<>(UserInfo, HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
		return entity;
	}

	/*---------------------------(참여한)평판점수 보내기------------------------------*/
	@RequestMapping(value = "requestReputationScoreForJoiner/{scored_user_number}/{score}/{score_user_number}/{buyTogetherNumber}", method = RequestMethod.GET)
	public ResponseEntity<String> requestReputationScoreForeJoiner (@PathVariable int scored_user_number, @PathVariable int score,
			@PathVariable int score_user_number, @PathVariable int buyTogetherNumber){
		ResponseEntity<String> entity = null;
		ScoreUserInfo scoreUserInfo = new ScoreUserInfo(scored_user_number,score,score_user_number,buyTogetherNumber);

		try {
			service.scoreUserInfoForJoiner(scoreUserInfo);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}



}