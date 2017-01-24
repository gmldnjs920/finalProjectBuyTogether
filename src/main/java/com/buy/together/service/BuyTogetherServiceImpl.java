package com.buy.together.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buy.together.dao.BuyTogetherDao;
import com.buy.together.domain.AttachedPhoto;
import com.buy.together.domain.BuyTogether;
import com.buy.together.domain.Category;
import com.buy.together.domain.HuntingStatus;
import com.buy.together.domain.HuntingType;
import com.buy.together.domain.ListSearchCriteria;
import com.buy.together.dto.BuyTogetherDTO;
import com.buy.together.dto.BuyTogetherMapDTO;
import com.buy.together.dto.BuyTogetherUpdateDTO;
import com.buy.together.dto.BuyTogetherWriteDTO;

@Service
public class BuyTogetherServiceImpl implements BuyTogetherService {

	@Inject
	private BuyTogetherDao dao;

	@Override //유저의 관심 카테고리 존재 여부 확인
	public Integer userInterest(Integer user_number) throws Exception {
		return dao.userInterestDao(user_number);
	}
	
	@Override //유저의 관심 지역 존재 여부 확인
	public Integer userAddress(Integer user_number) throws Exception {
		return dao.userAddressDao(user_number);
	}

	@Override //리스트 확인
	public Integer searchBuyTogetherCount(ListSearchCriteria cri) throws Exception {
		return dao.searchBuyTogetherCount(cri);
	}

	@Override
	public Integer searchBuyTogetherMapCount(ListSearchCriteria cri) throws Exception {

		return dao.searchBuyTogetherMapCount(cri);
	}

	@Override//사냥지도 리스트
	public List<BuyTogetherMapDTO> searchBuyTogetherMapList(ListSearchCriteria cri) throws Exception {

		List<BuyTogetherMapDTO> search = null;
		List<BuyTogetherMapDTO> searchBuyTogether = new ArrayList<BuyTogetherMapDTO>();
		String query = cri.getKeyword();
		
		if(query != "") {
			
			List<String> keyWords = new ArrayList<String>();

			while(query.contains(" ")) { //문장에 공백이 포함되어있는동안,
				
				int index = query.indexOf(" ");
				keyWords.add(query.substring(0,index));
				query = query.substring(index+1);
				
			}

			keyWords.add(query);
			
			for(int i=0; i<keyWords.size(); i++) {
				
				cri.setKeyword(keyWords.get(i).toString());
				search = dao.searchBuyTogetherMapList(cri);
				searchBuyTogether.addAll(search);
				
			}
			
		} else {
			
			searchBuyTogether = dao.searchBuyTogetherMapList(cri);
			
		}
		
		for(int i = 0; i<searchBuyTogether.size(); i++){

			List<AttachedPhoto> attachedPhotos = dao.photoList(searchBuyTogether.get(i).getBuytogether_number());
			searchBuyTogether.get(i).setPhoto_path(attachedPhotos);

		}

		return searchBuyTogether;

	}

	@Override //같이사냥 리스트
	public List<BuyTogetherDTO> searchBuyTogetherList(ListSearchCriteria cri) throws Exception {

		List<BuyTogetherDTO> buyTogether = dao.searchBuyTogetherList(cri);

		for(int i = 0; i<buyTogether.size(); i++) {

			List<AttachedPhoto> attachedPhotos = dao.photoList(buyTogether.get(i).getBuytogether_number());

			buyTogether.get(i).setPhoto_path(attachedPhotos);

		}

		return buyTogether;
	}

	@Override //카테고리 리스트
	public List<Category> categoryList() throws Exception {

		return dao.categoryList();
	}

	@Override //사냥방식 리스트
	public List<HuntingType> huntingTypeList() throws Exception {

		return dao.huntingTypeList();
	}

	@Override //사냥 상태 리스트
	public List<HuntingStatus> huntingStatusList() throws Exception {

		return dao.huntingStatusList();
	}

	@Transactional
	@Override //같이사낭 쓰기
	public void buyTogetherWrite(BuyTogetherUpdateDTO buytogether) throws Exception {

		dao.buyTogetherInsert(buytogether);

		//입력한 같이사냥 글의 번호를 가져온다.
		int number = dao.getBuyTogetherNumber(buytogether);

		//같이사냥 글과 함께 사진 경로까지 입력
		if(buytogether.getPath() != null){
			for(int i=0; i<buytogether.getPath().length; i++){
				AttachedPhoto photo = new AttachedPhoto();
				photo.setBuytogether_number(number);
				photo.setPath(buytogether.getPath()[i]);
				dao.buyTogetherPhotoInsert(photo);
			}
		}

		if(buytogether.getBuytogether_address_sido() != null){
			buytogether.setBuytogether_number(number);
			dao.buyTogetherAddressInsert(buytogether);
		}
	}

	@Transactional
	@Override
	public BuyTogetherWriteDTO buyTogetherReadOne(Integer buytogether_number) throws Exception {

		BuyTogetherWriteDTO buytogetherDTO = new BuyTogetherWriteDTO();

		BuyTogether buytogether = dao.buyTogetherReadOneDao(buytogether_number);
		List<AttachedPhoto> attachedPhotos = dao.photoList(buytogether_number);

		String[] path = new String[attachedPhotos.size()];

		for(int i=0; i<attachedPhotos.size(); i++){

			path[i] = attachedPhotos.get(i).getPath();
		}
		if(attachedPhotos.size() != 0){
			buytogether.setPath(path);
		}
		buytogetherDTO.setBuytogether(buytogether);
		buytogetherDTO.setBuytogetherAddress(dao.buyTogetherAddressReadOneDao(buytogether_number));

		return buytogetherDTO;
	}

	@Transactional
	@Override
	public void buyTogetherUpdate(BuyTogetherUpdateDTO buyTogetherUpdateDTO) throws Exception {

		dao.buyTogetherUpdateDao(buyTogetherUpdateDTO);
		if(buyTogetherUpdateDTO.getBuytogether_address_sido() != null){
			dao.buyTogetherUpdateAddressDao(buyTogetherUpdateDTO);
		}
		dao.buyTogetherPhotoDeleteDao(buyTogetherUpdateDTO.getBuytogether_number());

		if(buyTogetherUpdateDTO.getPath() != null){

			for(int i=0; i<buyTogetherUpdateDTO.getPath().length; i++){
				AttachedPhoto photo = new AttachedPhoto();
				photo.setBuytogether_number(buyTogetherUpdateDTO.getBuytogether_number());
				photo.setPath(buyTogetherUpdateDTO.getPath()[i]);
				dao.buyTogetherPhotoInsert(photo);
			}
		}
	}

}
