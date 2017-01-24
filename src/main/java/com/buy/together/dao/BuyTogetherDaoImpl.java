package com.buy.together.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

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

@Repository
public class BuyTogetherDaoImpl implements BuyTogetherDao {
	
	@Inject
	private SqlSession sqlSession;
	private static final String namespace="com.buy.together.mappers.buyTogetherMapper";
	
	//유저 관심 카테고리 갯수
	@Override 
	public Integer userInterestDao(Integer user_number) throws Exception {

		return sqlSession.selectOne(namespace+".userInterestCount",user_number);
		
	}
	
	//유저 관심 지역 존재여부
	@Override 
	public Integer userAddressDao(Integer user_number) throws Exception {

		return sqlSession.selectOne(namespace+".userAddress",user_number);
		
	}
	
	//유저 관심 카테고리 갯수
	@Override 
	public Integer searchBuyTogetherCount(ListSearchCriteria cri) throws Exception {
		
		return sqlSession.selectOne(namespace+".searchBuyTogetherCount", cri);
		
	}
	
	//유저 관심 지역 갯수
	@Override
	public Integer searchBuyTogetherMapCount(ListSearchCriteria cri) throws Exception {

		return sqlSession.selectOne(namespace+".searchBuyTogetherMapCount", cri);
		
	}
	
	//사냥지도 리스트
	@Override
	public List<BuyTogetherMapDTO> searchBuyTogetherMapList(ListSearchCriteria cri) throws Exception {

		return sqlSession.selectList(namespace+".searchBuyTogetherMapList", cri);
		
	}

	//같이사냥 전체 게시글 조회
	@Override 
	public List<BuyTogetherDTO> searchBuyTogetherList(ListSearchCriteria cri) throws Exception {

		return sqlSession.selectList(namespace+".searchBuyTogetherList",cri);
			
	}
	
	//같이사냥 게시글의 사진 리스트 조회
	@Override 
	public List<AttachedPhoto> photoList(Integer buytogether_number) throws Exception {
	
		return sqlSession.selectList(namespace+".photoList", buytogether_number);
		
	}
	
	//카테고리 리스트 조회
	@Override
	public List<Category> categoryList() throws Exception {

		return sqlSession.selectList(namespace+".categoryList");
		
	}
	
	//사냥방식 리스트 조회
	@Override
	public List<HuntingType> huntingTypeList() throws Exception {

		return sqlSession.selectList(namespace+".huntingTypeList");
		
	}
	
	//사냥상태 리스트 조회
	@Override
	public List<HuntingStatus> huntingStatusList() throws Exception {

		return sqlSession.selectList(namespace+".huntingStatusList");
		
	}
	
	@Override //같이사냥 게시글 쓰기
	public void buyTogetherInsert(BuyTogetherUpdateDTO buyTogether) throws Exception {

		sqlSession.insert(namespace+".buytogetherInsert", buyTogether);
		
	}
	
	@Override //방금 쓴 게시글 번호
	public Integer getBuyTogetherNumber(BuyTogetherUpdateDTO buyTogether) throws Exception {

		return sqlSession.selectOne(namespace+".buytogetherNumber", buyTogether);
		
	}
	
	@Override //게시글과 함께 같이사냥 주소 저장
	public void buyTogetherAddressInsert(BuyTogetherUpdateDTO buyTogetherAddress) throws Exception {

		sqlSession.insert(namespace+".buytogetherAddressInsert", buyTogetherAddress);
		
	}
	
	//게시글과 함께 같이사냥 첨부사진 저장
	@Override 
	public void buyTogetherPhotoInsert(AttachedPhoto attachedPhoto) throws Exception {

		sqlSession.insert(namespace+".buytogetherPhotoInsert", attachedPhoto);
		
	}
	
	@Override //해당 게시글 정보를 가져옴
	public BuyTogether buyTogetherReadOneDao(Integer buytogether_number) throws Exception {

		return sqlSession.selectOne(namespace+".buytogetherReadOne", buytogether_number);
	}
	
	@Override //해당 게시글 주소 정보를 가져옴
	public BuyTogetherAddress buyTogetherAddressReadOneDao(Integer buytogether_number) throws Exception {

		return sqlSession.selectOne(namespace+".buytogetherAddressReadOne", buytogether_number);
	}
	
	@Override //같이사냥 게시글 수정
	public void buyTogetherUpdateDao(BuyTogetherUpdateDTO buytogetherUpdateDTO) throws Exception {

		sqlSession.update(namespace+".buytogetherUpdate",buytogetherUpdateDTO);
	}
	
	@Override //같이사냥 주소 수정
	public void buyTogetherUpdateAddressDao(BuyTogetherUpdateDTO buytogetherUpdateDTO) throws Exception {

		sqlSession.update(namespace+".buytogetherUpdateAddress",buytogetherUpdateDTO);
	}
	
	@Override //사진삭제
	public void buyTogetherPhotoDeleteDao(Integer buytogether_number) throws Exception {

		sqlSession.delete(namespace+".deletePhotoPath",buytogether_number);
	}
}
