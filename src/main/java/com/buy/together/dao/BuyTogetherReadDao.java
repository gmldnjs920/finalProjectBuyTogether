package com.buy.together.dao;

import java.util.List;

import com.buy.together.domain.AttachedPhoto;
import com.buy.together.domain.Comment;
import com.buy.together.domain.DeclareBoard;
import com.buy.together.dto.BuyTogetherDTO;

public interface BuyTogetherReadDao {
	
	public List<AttachedPhoto> photoList(Integer buytogether_number) throws Exception;
	
	public BuyTogetherDTO buyTogetherRead(Integer buytogether_number) throws Exception;
	
	public void deleteBuytogether(Integer buytogether_number) throws Exception;

	public List<Comment> commentList(Integer buytogether_number, Integer comment_type_number) throws Exception;
	
	public void createComment(Comment comment) throws Exception;
	
	public void deleteComment(Integer comment_number) throws Exception;
	
	public void commentUpdate(Comment comment) throws Exception;
	
	public void createRecomment(Comment comment) throws Exception;
	
	public List<Comment> recommentList(Integer comment_number, Integer comment_type_number) throws Exception;
	
	public void registBuytogether(Integer user_number, Integer buytogether_number) throws Exception;
	
	public void insertDip(Integer buytogether_number, Integer user_number) throws Exception;
	
	public void deleteDip(Integer buytogether_number, Integer user_number) throws Exception;
	
	public Integer checkDip(Integer buytogether_number, Integer user_number) throws Exception;
	
	public BuyTogetherDTO reportDao(Integer buytogether_number, Integer comment_number) throws Exception;
	
	public void sendReport(DeclareBoard declareBoard) throws Exception;
	
	public Integer buytogetherCheckDao(Integer buytogether_number, Integer user_number) throws Exception;
	
	public void cancleBuytogetherDao(Integer buytogether_number, Integer user_number) throws Exception;
	
	public List<BuyTogetherDTO> joininListDao(Integer buytogether_number) throws Exception;
	
	public void joinCheckDao(Integer joinCheck_userNumber) throws Exception;
	
	public void JoinCheck2Dao(Integer buytogether_number) throws Exception;
	
}
