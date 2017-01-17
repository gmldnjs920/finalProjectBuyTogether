package com.buy.together.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buy.together.dao.BuyTogetherReadDao;
import com.buy.together.domain.AttachedPhoto;
import com.buy.together.domain.Comment;
import com.buy.together.domain.DeclareBoard;
import com.buy.together.dto.BuyTogetherDTO;

@Service
public class BuyTogetherReadServiceImpl implements BuyTogetherReadService {

	@Inject
	private BuyTogetherReadDao dao;

	// 같이사냥 조회
	@Transactional
	@Override
	public BuyTogetherDTO buyTogetherRead(Integer buytogether_number) throws Exception {

		BuyTogetherDTO dto = dao.buyTogetherRead(buytogether_number);
		List<AttachedPhoto> photo = dao.photoList(buytogether_number);

		dto.setPhoto_path(photo);

		return dto;
	}

	// 댓글리스트
	@Override
	public List<Comment> commentList(Integer buytogether_number, Integer comment_type_number) throws Exception {

		List<Comment> list = dao.commentList(buytogether_number, comment_type_number);

		return list;

	}

	// 댓글 쓰기
	@Override
	public void registComment(Comment comment) throws Exception {

		dao.createComment(comment);

	}

	// 댓글 삭제
	@Override
	public void deleteComment(Integer comment_number) throws Exception {

		dao.deleteComment(comment_number);

	}

	// 댓글 수정
	@Override
	public void updateComment(Comment comment) throws Exception {

		dao.commentUpdate(comment);

	}

	// 답글 쓰기
	@Override
	public void registRecomment(Comment comment) throws Exception {

		dao.createRecomment(comment);

	}

	// 답글 리스트
	@Override
	public List<Comment> recommentList(Integer comment_number, Integer comment_type_number) throws Exception {

		return dao.recommentList(comment_number, comment_type_number);

	}

	// 게시판 삭제
	@Override
	public void deleteBuytogether(Integer buytogether_number) throws Exception {

		dao.deleteBuytogether(buytogether_number);

	}

	// 같이사냥 버튼
	@Override
	public void registBuytogether(Integer user_number, Integer buytogether_number)
			throws Exception {

		dao.registBuytogether(user_number, buytogether_number);

	}

	// 찜하기 버튼
	@Override
	public void registDip(Integer buytogether_number, Integer user_number) throws Exception {

		dao.insertDip(buytogether_number, user_number);

	}

	// 찜하기 취소
	@Override
	public void deleteDip(Integer buytogether_number, Integer user_number) throws Exception {

		dao.deleteDip(buytogether_number, user_number);

	}

	// 찜 확인
	@Override
	public Integer checkDip(Integer buytogether_number, Integer user_number) throws Exception {

		return dao.checkDip(buytogether_number, user_number);
	}

	// 신고
	@Override
	public BuyTogetherDTO report(Integer buytogether_number, Integer comment_number) throws Exception {

		return dao.reportDao(buytogether_number, comment_number);

	}

	// 신고하기
	@Override
	public void registReport(DeclareBoard declareBoard) throws Exception {

		dao.sendReport(declareBoard);

	}

	// 같이사냥 확인
	@Override
	public Integer buytogetherCheck(Integer buytogether_number, Integer user_number) throws Exception {

		return dao.buytogetherCheckDao(buytogether_number, user_number);

	}

	// 같이사냥 취소하기
	@Override
	public void cancleBuytogether(Integer buytogether_number, Integer user_number) throws Exception {

		dao.cancleBuytogetherDao(buytogether_number, user_number);

	}

	// 사냥 참여자 리스트
	@Override
	public List<BuyTogetherDTO> joininList(Integer buytogether_number) throws Exception {

		return dao.joininListDao(buytogether_number);

	}

	// 참여자 선택 버튼
	@Transactional
	@Override
	public void joinCheck(Integer buytogether_number, Integer[] joinCheck_userNumber) throws Exception {

		for(int i=0; i<joinCheck_userNumber.length; i++){
			dao.joinCheckDao(joinCheck_userNumber[i]);
		}
		dao.JoinCheck2Dao(buytogether_number);

	}

}
