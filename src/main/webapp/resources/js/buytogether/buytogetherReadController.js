$('head').append('<script src=\'/resources/js/buytogether/buytogetherReadDao.js\'><\/script>');

function buytogetherReadController() {

	var dao = new buytogetherReadDao();
	var photoPath;

	// 같이사냥 조회
	this.requestRead = function(buytogether_number) {
		
		var data = dao.readDao(buytogether_number);
		
		var dateObj = new Date(data.duedate);
		var year = dateObj.getFullYear();
		var month = dateObj.getMonth() + 1;
		var date = dateObj.getDate();
		var duedate = year+"/"+month+"/"+date;
		
		//조회 append
		$("#title").html(data.title);
		$("#buytogether_number").html(data.buytogether_number);
		$("#duedate").html(duedate);
		$("#join_number").html(data.join_number);
		$("#joinin_user").html(data.joinin_user);
		$("#price").html(data.price);
		$("#address_road").html(data.buytogether_address_road_address);
		$("#address_detail").html(data.buytogether_address_detail);
		$('#contentHTML').html(data.content);
		$("#nickname").html(data.nickname);
		$("#status_name").html(data.status_name);
		$("#reputation").html(data.reputation);

		if(data == undefined) {
			document.location = '/error';
		}
		
		photoPath = data.photo_path;
		if(data.photo_path == null){
			
			for(var i=0; i < 4 ; i++){
				
				$('#zoom'+(i+1)).attr("src","/resources/img/noImage.png");
				$('#thumb'+(i+1)).attr("src","/resources/img/noImage.png");
				
			}
			
		} else {
		
			var size = data.photo_path.length;

			for(var i=0; i < size ; i++) {
				
				var path = data.photo_path[i].path;
				
				$('#zoom'+(i+1)).attr("src","/restBuytogether/displayFile?fileName=" + path);
				$('#thumb'+(i+1)).attr("src","/restBuytogether/displayFile?fileName=" + path);
			}
			for(var i=size; i<4 ; i++) {
				
				$('#zoom'+(i+1)).attr("src","/resources/img/noImage.png");
				$('#thumb'+(i+1)).attr("src","/resources/img/noImage.png");
			}
		}
		
		return data;
	}

	// 같이사냥 게시판 삭제
	this.requestBuytogetherDelete = function(buytogether_number){

		dao.buytogetherDeleteDao(buytogether_number, photoPath);

	}

	// 같이사냥 게시판 수정
	this.requestBuytogetherUpdate = function(buytogether_number, user_number){

		dao.buytogetherUpdateDao(buytogether_number, user_number);

	}

	// 같이사냥 댓글, 답글 입력
	this.requestCommentInsert = function(buytogether_number, comment_type_number, user_number, comment_content){

		dao.commentInsertDao(buytogether_number, comment_type_number, user_number, comment_content);

	}

	// 같이사냥 댓글 리스트 부분
	this.requestCommentList = function(buytogether_number, comment_type_number){

		return dao.commentListDao(buytogether_number, comment_type_number);

	}

	// 같이사냥 삭제 부분
	this.requestCommentDelete = function(buytogether_number, comment_number){

		dao.commentDeleteDao(buytogether_number, comment_number);

	}

	// 같이사냥 댓글, 답글 수정 부분
	this.requestCommentUpdate = function(buytogether_number, comment_number, comment_content, comment_type_number){

		dao.commentUpdateDao(buytogether_number, comment_number, comment_content, comment_type_number);

	}

	// 같이사냥 답글 쓰기 부분
	this.requestRecommentInsert = function(buytogether_number, comment_type_number, comment_parent_number, comment_content, user_number){


		dao.recommentInsertDao(buytogether_number, comment_type_number, comment_parent_number, comment_content, user_number);

	}

	// 같이사냥 참여자 답글 리스트 부분
	this.requestRecommentList = function(comment_number, comment_type_number){

		var data = dao.recommentListDao(comment_number, comment_type_number);

		return data;
	}


	// 같이사냥 전체 답글 리스트 부분
	this.requestAllRecommentList = function(comment_number, comment_type_number){

		var data = dao.recommentListDao(comment_number, comment_type_number);

		return data;

	}

	// 같이사냥 버튼
	this.requestRegistBuytogether = function(buytogether_number, user_number){

		return dao.registBuytogetherDao(buytogether_number, user_number);

	}

	// 같이사냥 찜하기 버튼
	this.requestDipBtn = function(buytogether_number, user_number){

		dao.dipBtnDao(buytogether_number, user_number);

	}

	// 같이사냥 찜하기 취소 버튼
	this.requestCancleDip = function(buytogether_number, user_number){

		dao.cancleDipDao(buytogether_number, user_number);

	}

	// 같이사냥 찜 확인
	this.requestCheckDip = function(buytogether_number, user_number){

		return dao.checkDipDao(buytogether_number, user_number);
	}

	// 같이사냥 댓글 신고버튼
	this.requestCommentReport = function(buytogether_number, comment_number){

		var data = dao.commentReportDao(buytogether_number, comment_number);
		
		$("#comment_content").html(data.comment_content);
		$("#nickname").html(data.nickname);

	}
	
	// 신고페이지 신고버튼 클릭
	this.requestSendReport = function(reportData){
		
		dao.sendReportDao(reportData);
			
	}
	
	// 같이사냥 참여자 확인
	this.requestBuytogetherCheck = function(buytogether_number, user_number){
		
		return dao.buytogetherCheckDao(buytogether_number, user_number);
		
	}
	
	// 같이사냥 취소 버튼
	this.requestCancleBuytogether = function(buytogether_number, user_number){

		dao.cancleBuytogetherDao(buytogether_number, user_number);
		
	}
	
	// 사냥 참여 리스트
	this.requestJoininList = function(buytogether_number){
		
		dao.joininListDao(buytogether_number);
		
	}
	
	// 참여자 선택 버튼
	this.requestJoinCheckBtn = function(buytogether_number, joinCheck_userNumber){
		
		return dao.joinCheckBtnDao(buytogether_number, joinCheck_userNumber);
		
	}

}