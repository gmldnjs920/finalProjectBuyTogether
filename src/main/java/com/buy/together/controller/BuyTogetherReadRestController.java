package com.buy.together.controller;

import java.util.List;

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

import com.buy.together.domain.Comment;
import com.buy.together.domain.DeclareBoard;
import com.buy.together.dto.BuyTogetherDTO;
import com.buy.together.service.BuyTogetherReadService;

@RestController
@RequestMapping("/restBuytogetherRead/*")
public class BuyTogetherReadRestController {

	private static final Logger logger = LoggerFactory.getLogger(BuyTogetherReadRestController.class);

	@Inject
	private BuyTogetherReadService service;

	// 글 조회 부분
	@RequestMapping(value = "read/{buytogether_number}", method = RequestMethod.GET)
	public ResponseEntity<BuyTogetherDTO> requestRead(@PathVariable("buytogether_number") Integer buytogether_number){

		ResponseEntity<BuyTogetherDTO> entity = null;

		try {

			entity = new ResponseEntity<BuyTogetherDTO>(service.buyTogetherRead(buytogether_number), HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
			entity = new ResponseEntity<BuyTogetherDTO>(HttpStatus.BAD_REQUEST);

		}

		return entity;
	}

	// 게시글 삭제 부분
	@RequestMapping(value = "delete/{buytogether_number}", method = RequestMethod.DELETE)
	public ResponseEntity<String> requestBuytogetherDelete(@PathVariable("buytogether_number") Integer buytogether_number){

		ResponseEntity<String> entity = null;

		try{

			service.deleteBuytogether(buytogether_number);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);

		}catch(Exception e){

			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}

		return entity;

	}

	// 댓글 리스트 부분
	@RequestMapping(value = "commentList/{buytogether_number}/{comment_type_number}", method = RequestMethod.GET)
	public ResponseEntity<List<Comment>> requestCommentList(@PathVariable("buytogether_number") Integer buytogether_number,
			@PathVariable("comment_type_number") Integer comment_type_number){

		ResponseEntity<List<Comment>> entity = null;

		try{
			entity = new ResponseEntity<List<Comment>>(service.commentList(buytogether_number, comment_type_number), HttpStatus.OK);

		}catch(Exception e){

			e.printStackTrace();
			entity = new ResponseEntity<List<Comment>>(HttpStatus.BAD_REQUEST);

		}

		return entity;		

	}

	// 댓글 쓰기 부분
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> requestCommentRegist(@RequestBody Comment comment) {

		ResponseEntity<String> entity = null;

		try{
			service.registComment(comment);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);

		}catch (Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	// 댓글 삭제 부분
	@RequestMapping(value = "/{comment_number}", method = RequestMethod.DELETE)
	public ResponseEntity<String> requestCommentRemove(@PathVariable("comment_number") Integer comment_number){

		ResponseEntity<String> entity = null;

		try{

			service.deleteComment(comment_number);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);

		}catch(Exception e){

			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}

		return entity;
	}

	// 댓글 수정 부분
	@RequestMapping(value = "/{comment_number}", method = {RequestMethod.PUT, RequestMethod.PATCH})
	public ResponseEntity<String> requestCommentUpdate(@PathVariable("comment_number") Integer comment_number, 
			@RequestBody Comment comment){

		ResponseEntity<String> entity = null;

		try{

			comment.setComment_number(comment_number);
			service.updateComment(comment);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);

		}catch(Exception e){

			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}

		return entity;

	};

	// 답글 쓰기 부분
	@RequestMapping(value = "recommentInsert", method = RequestMethod.POST)
	public ResponseEntity<String> requestRecommentRegist(@RequestBody Comment comment) {

		ResponseEntity<String> entity = null;

		try{
			service.registRecomment(comment);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);

		}catch (Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	// 답글 리스트 부분
	@RequestMapping(value = "recommentList/{comment_number}/{comment_type_number}", method = RequestMethod.GET)
	public ResponseEntity<List<Comment>> requestRecommentList(@PathVariable("comment_number") Integer comment_number, @PathVariable("comment_type_number") Integer comment_type_number){

		ResponseEntity<List<Comment>> entity = null;

		try{

			entity = new ResponseEntity<List<Comment>>(service.recommentList(comment_number, comment_type_number), HttpStatus.OK);

		}catch (Exception e){

			e.printStackTrace();
			entity = new ResponseEntity<List<Comment>>(HttpStatus.BAD_REQUEST);
		}

		return entity;

	}

	// 같이사냥 버튼
	@RequestMapping(value = "buytogetherBtn/{buytogether_number}/{user_number}", method = RequestMethod.POST)
	public ResponseEntity<String> requestBuytogetherBtn(@PathVariable("buytogether_number") Integer buytogether_number, @PathVariable("user_number") Integer user_number){

		ResponseEntity<String> entity = null;

		try{
			service.registBuytogether(user_number, buytogether_number);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);

		}catch (Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}


		return entity;

	}

	// 찜하기 버튼
	@RequestMapping(value = "dipBtn/{buytogether_number}/{user_number}", method = RequestMethod.POST)
	public ResponseEntity<String> requestDipBtn(@PathVariable("buytogether_number") Integer buytogether_number, @PathVariable("user_number") Integer user_number){

		ResponseEntity<String> entity = null;

		try{
			service.registDip(buytogether_number, user_number);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);

		}catch (Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;

	}

	// 찜하기 취소버튼
	@RequestMapping(value = "cancleDip/{buytogether_number}/{user_number}", method = RequestMethod.DELETE)
	public ResponseEntity<String> requestDeleteDip(@PathVariable("buytogether_number") Integer buytogether_number, @PathVariable("user_number") Integer user_number){

		ResponseEntity<String> entity = null;

		try{

			service.deleteDip(buytogether_number, user_number);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);

		}catch (Exception e){

			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}

		return entity;

	}

	// 찜한 거 확인
	@RequestMapping(value = "checkDip/{buytogether_number}/{user_number}", method = RequestMethod.POST)
	public ResponseEntity<String> requestCheckDip(@PathVariable("buytogether_number") Integer buytogether_number, @PathVariable("user_number") Integer user_number){

		ResponseEntity<String> entity = null;

		try{

			int dip_number = service.checkDip(buytogether_number, user_number);

			if(dip_number > 0){
				
				entity = new ResponseEntity<String>("success", HttpStatus.OK);
				
			} else {
				
				entity = new ResponseEntity<String>("fail", HttpStatus.OK);
				
			}
			
		} catch (Exception e){

			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}

		return entity;

	}

	// 댓글 신고 내용 / 작성자
	@RequestMapping(value = "commentReport/{buytogether_number}/{comment_number}" , method = RequestMethod.GET)
	public ResponseEntity<BuyTogetherDTO> requestReport(@PathVariable("buytogether_number") Integer buytogether_number,@PathVariable("comment_number") Integer comment_number ){

		ResponseEntity<BuyTogetherDTO> entity = null;

		try{

			entity = new ResponseEntity<BuyTogetherDTO>(service.report(buytogether_number, comment_number), HttpStatus.OK);

		}catch (Exception e){

			e.printStackTrace();
			entity = new ResponseEntity<BuyTogetherDTO>(HttpStatus.BAD_REQUEST);
			
		}

		return entity;

	}

	// 댓글 페이지 신고버튼 이벤트
	@RequestMapping(value = "sendReport/", method = RequestMethod.POST)
	public ResponseEntity<String> requestSendReport(@RequestBody DeclareBoard declareBoard){

		ResponseEntity<String> entity = null;

		try{

			service.registReport(declareBoard);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);

		}catch (Exception e){

			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}

		return entity;
	}

	// 같이사냥 참여자 확인
	@RequestMapping(value = "buytogetherCheck/{buytogether_number}/{user_number}", method = RequestMethod.POST)
	public ResponseEntity<String> requestBuytogetherCheck(@PathVariable("buytogether_number") Integer buytogether_number, @PathVariable("user_number") Integer user_number){

		ResponseEntity<String> entity = null;

		try{

			int check_number = service.buytogetherCheck(buytogether_number, user_number);

			if(check_number > 0){

				entity = new ResponseEntity<String>("success", HttpStatus.OK);

			} else {

				entity = new ResponseEntity<String>("fail", HttpStatus.OK);

			}

		}catch (Exception e){

			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}

		return entity;

	}
	
	// 같이사냥 취소 버튼
	@RequestMapping(value = "cancleBuytogether/{buytogether_number}/{user_number}", method = RequestMethod.DELETE)
	public ResponseEntity<String> requestCancleBuytogether(@PathVariable("buytogether_number") Integer buytogether_number, @PathVariable("user_number") Integer user_number){

		ResponseEntity<String> entity = null;

		try{

			service.cancleBuytogether(buytogether_number, user_number);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);

		}catch (Exception e){

			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}

		return entity;

	}
	
	// 사냥 참여자 리스트
	@RequestMapping(value = "joininList/{buytogether_number}" , method = RequestMethod.GET)
	public ResponseEntity<List<BuyTogetherDTO>> requestjoininList(@PathVariable("buytogether_number") Integer buytogether_number){
		
		ResponseEntity<List<BuyTogetherDTO>> entity = null;
		
		try{

			entity = new ResponseEntity<List<BuyTogetherDTO>>(service.joininList(buytogether_number), HttpStatus.OK);

		} catch (Exception e){

			e.printStackTrace();
			entity = new ResponseEntity<List<BuyTogetherDTO>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	// 사냥 참여자 선택 버튼(프로필 : "같이사냥중" 변경, Matching_status_number : "2번" 변경)
	@RequestMapping(value="/joinCheck", method = RequestMethod.POST)
	public ResponseEntity<String> requestJoinCheck(Integer buytogether_number, Integer[] joinCheck_userNumber){
		
		ResponseEntity<String> entity = null;
		
		try{
			
			service.joinCheck(buytogether_number , joinCheck_userNumber);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);

		}catch(Exception e){

			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
		
		return entity;
		
	}
	
}