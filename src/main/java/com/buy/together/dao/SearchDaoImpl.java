package com.buy.together.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.buy.together.dto.BuyTogetherDTO;

@Repository
public class SearchDaoImpl implements SearchDao {
	
	@Inject
	private SqlSession sqlSession;	
	private static String namespace = "com.buy.together.mappers.searchMapper";
	
	@Override
	public List<BuyTogetherDTO> searchBuyTogether(String keyWord) throws Exception {
		
		return sqlSession.selectList(namespace + ".search", keyWord);
		
	}
	
}
