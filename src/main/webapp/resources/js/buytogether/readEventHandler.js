$('head').append('<script src=\'/resources/js/buytogether/buytogetherReadController.js\'><\/script>');

$(document).ready(function() {

	// HEADER FOOTER
	$("#buytogetherHeader").load("/views/include/header.html");
	$("#buytogetherFooter").load("/views/include/footer.html");

	// 로그인한 유저번호 
	var user_number = sessionStorage.getItem("number");

	// 게시판 넘버
	var buytogether_number = $(location).attr('search');
	var searchKeyword = buytogether_number.split("?buytogether_number=");
	buytogether_number = searchKeyword[1];

	// controller 선언
	var controller = new buytogetherReadController();

	// BUYTOGETHER READ PAGE
	var readData = controller.requestRead(buytogether_number);
	
	if(readData.status_name == '같이사냥중' || readData.status_name == '같이사냥완료' || readData.status_name == '같이사냥실패'){
		$('.buy_together_btn').attr("disabled",true);
	}

	var data;
	
	// 같이사냥 참여자 확인
	if(user_number != readData.user_number){

		data = controller.requestBuytogetherCheck(buytogether_number, user_number);
		
	} 
	
	// 게시글 등록자가 조회에서 사냥 참여자 있을 시, 같이사냥 버튼 CHECK로 바꿈
	if(user_number == readData.user_number){
		
		// 게시글 등록한 사람이 글 조회시  UPDATE, DELETE 버튼이 보여야 한다.
		$(".buytogether_delete_btn").show();
		$(".buytogether_update_btn").show();
		
		$("#buy_together_btn").attr("value", "CHECK PLEASE");
		$("#buy_together_btn").attr("id", "buy_together_btn_check");

		// 게시판 주인 CHECK 클릭시 모달 창
		$(document).on("click", "#buy_together_btn_check", function() {

			// 참여자 리스트 부
			controller.requestJoininList(buytogether_number);
			$("#myModal2").modal({'show' : true});

			//참여자 전체 선택
			$('[name=checkAll]').click(function () {

				if($("[name=checkAll]").prop("checked")) {
					$("[name=check]").prop("checked",true);
				// 전체선택 체크박스가 해제된 경우
				} else {
					//해당화면에 모든 checkbox들의 체크를해제시킨다.
					$("[name=check]").prop("checked",false);
				}

			});

			// 선택한 참여자 선택 버튼
			$('#joinCheck').click(function(){
				
				var joinCheck_userNumber=[];
				
				$("input[name=check]:checked").each(function() {
					
					var num = $(this).attr("data-user_number");
					joinCheck_userNumber.push(num);
					
				});
				var result = controller.requestJoinCheckBtn(buytogether_number, joinCheck_userNumber);
				
				if(result == 'success') {
					document.location = '/buyTogether/read?buytogether_number='+buytogether_number;
				}
			});

		});
		
	} else {

		// 게시글 등록한 사람이 글 조회시  UPDATE, DELETE 버튼이 안보여야 한다.
		$(".buytogether_delete_btn").hide();
		$(".buytogether_update_btn").hide();
		
	}
	
	var dip;
	
	// 찜확인 후 하트 색 변경
	if(user_number != readData.user_number){

		dip = controller.requestCheckDip(buytogether_number, user_number);

	}

	if(dip == false) {

	} else if(dip == true){

		$("#heart").attr("class", "glyphicon glyphicon-heart c-font-22 c-font-red-3 c-border-red");

	} 

	// 게시판 삭제 
	$(".delete_update_btn").on("click", ".row #buytogether_delete_btn", function() {

		controller.requestBuytogetherDelete(buytogether_number);

	});

	// 게시판 수정
	$(".delete_update_btn").on("click", ".row #buytogether_update_btn", function() {

		if ($(this).val() == "UPDATE") {

			var url = "/buyTogether/update?buytogether_number="+buytogether_number; 
					
			$(location).attr('href',url);
		}
	});

	// 댓글 Tap
	$("#tapAllList").on("click", function() {

		//전체참여 번호
		var comment_type_number = 1;

		// 전체 댓글 쓰기 부분
		$('#comment_List').on("click", "#comment_content_Btn1", function() {

			var textarea = $(this).prev();
			//글내용 불러오기
			var comment_content = textarea.val();

			controller.requestCommentInsert(buytogether_number, comment_type_number, user_number, comment_content);

		});

		// 전체 댓글 수정 버튼
		$('#comment_List').on("click", ".updateBtn", function() {

			var div = $(this).parent();
			var div2 = div.prev();
			var textarea = div2.children().eq(1);
			var comment_number = div.attr("data-comment-number");
			var comment_content = textarea.val();


			if ($(this).val() == "수정") {

				textarea.attr("readonly", false);
				$(this).attr("value", "수정완료");

			} else {

				$(this).attr("value", "수정");
				textarea.attr("readonly", true);

				controller.requestCommentUpdate(buytogether_number, comment_number, comment_content, comment_type_number);

			}

		});

		// 전체 답글 쓰기 버튼
		$("#comment_List").on("click", ".recommentInsertBtn_A", function() {

			var reply = $(this).parent();
			var comment_parent_number = reply.attr("data-recomment-number");

			var textarea = $(this).prev();
			var comment_content = textarea.val();

			controller.requestRecommentInsert(buytogether_number, comment_type_number, comment_parent_number, comment_content, user_number);

		});

		// 전체 답글 수정 부분
		$("#comment_List").on("click", ".recomment_updateBtn_A", function() {

			var div = $(this).parent();
			var div2 = div.prev();
			var textarea = div2.children().eq(1);
			var comment_number = div.attr("data-comment-number");
			var comment_content = textarea.val();

			if ($(this).val() == "수정") {

				textarea.attr("readonly", false);
				$(this).attr("value", "수정완료");

			} else {

				$(this).attr("value", "수정");
				textarea.attr("readonly", true);

				controller.requestCommentUpdate(buytogether_number, comment_number, comment_content, comment_type_number);

			}

		});

		// 전체 답글 리스트 부분
		$("#comment_List").on("click", ".recommentList_Btn_A", function() {

			var reply = $(this).parent();
			var comment_number = reply.attr("data-comment-number");

			var data = controller.requestAllRecommentList(comment_number, comment_type_number);

			var div = $(this).next();
			var div1 = div.children().eq(0);

			if (data == '') {

			} else {

				if (comment_number == data[0].comment_parent_number) {

					var template_recomment = Handlebars.compile($('#recommentTemplate_A').html());

					var html_recomment = template_recomment(data);

					div1.children("#recommentLi_a").remove();

					div1.html(html_recomment);

				} 
			}
			
		});

		// 댓글 리스트
		var commentData = controller.requestCommentList(buytogether_number, comment_type_number);

		// 로그인 사용자와 댓글 등록 사용자가 미동일시 삭제, 수정버튼 숨기기
		if(user_number != commentData.user_number){
			
			$(".dellupdate").hide();
			
		} else if(user_number == commnetData.user_number){
			
			$(".delupate").show();
			
		}
		
	});

	// 참여자 댓글 Tap
	$("#tapChatList").on("click", function() {

		// 참여자 Tap 번호
		var comment_type_number = 2;

		// 같이사냥 참여자 확인(게시판번호, 유저번호)
		var buytoegetherCheck = controller.requestBuytogetherCheck(buytogether_number, user_number);

		if(buytoegetherCheck == true || user_number == readData.user_number){

			// 참여자 댓글 쓰기 부분
			$('#comment_List2').on("click", "#comment_content_Btn2", function() {

				var textarea = $(this).prev();

				//글내용 불러오기
				var comment_content = textarea.val();

				controller.requestCommentInsert(buytogether_number, comment_type_number, user_number, comment_content);

			});

			// 참여자 댓글 수정 버튼(댓글 번호, 내용)
			$("#comment_List2").on("click", ".updateBtn_B", function() {

				var div = $(this).parent();
				var div2 = div.prev();
				var textarea = div2.children().eq(1);
				var comment_number = div.attr("data-comment-number");
				var comment_content = textarea.val();

				if ($(this).val() == "수정") {

					textarea.attr("readonly", false);
					$(this).attr("value", "수정완료");

				} else {

					$(this).attr("value", "수정");
					textarea.attr("readonly", true);

					controller.requestCommentUpdate(buytogether_number, comment_number, comment_content, comment_type_number);

				}

			});

			// 참여자 답글 쓰기 버튼
			$("#comment_List2").on("click", "#recommentInsertBtn", function() {

				var reply = $(this).parent();
				var comment_parent_number = reply.attr("data-recomment-number");

				var textarea = $(this).prev();
				var comment_content = textarea.val();

				controller.requestRecommentInsert(buytogether_number, comment_type_number, comment_parent_number, comment_content, user_number);

			});

			// 참여자 답글 수정 부분
			$("#comment_List2").on("click", ".recomment_updateBtn_B", function() {

				var div = $(this).parent();
				var div2 = div.prev();
				var textarea = div2.children().eq(1);
				var comment_number = div.attr("data-comment-number");
				var comment_content = textarea.val();

				if ($(this).val() == "수정") {

					textarea.attr("readonly", false);
					$(this).attr("value", "수정완료");

				} else {

					$(this).attr("value", "수정");
					textarea.attr("readonly", true);

					controller.requestCommentUpdate(buytogether_number, comment_number, comment_content, comment_type_number);

				}

			});

			// 참여자 답글 리스트 출력
			$("#comment_List2").on("click", ".recommentList_Btn_B", function() {

				var reply = $(this).parent();
				var comment_number = reply.attr("data-comment-number");

				var data = controller.requestRecommentList(comment_number, comment_type_number);

				var div = $(this).next();
				var recommentList = div.children().eq(0);

				if (comment_number == data[0].comment_parent_number) {

					var template_recomment = Handlebars.compile($('.recommentTemplate_B').html());

					var html_recomment = template_recomment(data);

					recommentList.children("#recommentLi_b").remove();

					recommentList.html(html_recomment);

				} else {
				}

			});

			controller.requestCommentList(buytogether_number, comment_type_number);

		} else if(buytoegetherCheck == false){

			// 같이사냥 참여자 댓글 모달
			$("#commentModal").modal({'show' : true});

		}

	});

	//	전체 댓글 and 답글 삭제 버튼
	$("#comment_List").on("click", ".deleteBtn", function() {

		var reply = $(this).parent();
		var comment_number = reply.attr("data-comment-number");

		controller.requestCommentDelete(buytogether_number, comment_number);

	});

	//	참여자 댓글 and 답글 삭제 버튼
	$("#comment_List2").on("click", ".deleteBtn", function() {

		var reply = $(this).parent();
		var comment_number = reply.attr("data-comment-number");

		controller.requestCommentDelete(buytogether_number, comment_number);

	});

	// 찜하기 버튼 클릭
	$(document).on("click", ".iconClass .dip_heratIcon", function() {

		var heartIcon = $(this).children();
		var btnClass = heartIcon.attr("class");

		if (btnClass == "icon-heart c-font-22 c-font-red-3 c-border-red") {

			controller.requestDipBtn(buytogether_number, user_number);
			heartIcon.attr("class", "glyphicon glyphicon-heart c-font-22 c-font-red-3 c-border-red");

		} else if (btnClass == "glyphicon glyphicon-heart c-font-22 c-font-red-3 c-border-red") {

			controller.requestCancleDip(buytogether_number, user_number);
			heartIcon.attr("class", "icon-heart c-font-22 c-font-red-3 c-border-red");

		}

	});

	// 댓글 신고 버튼 팝업창
	$(document).on("click", ".report_btn", function() {

		// 댓글번호
		var span = $(this).parent();
		var label = span.parent();
		var div_comment = label.parent();
		var comment_number = div_comment.attr("data-comment-number");

		window.open("/buyTogether/buytogetherPopup?buytogether_number="+buytogether_number+"&comment_number="+comment_number,
				"report", "width=600, height=670, left=100, top=50");

	});

	// 답글 신고 버튼 팝업창
	$(document).on("click", ".recommentReport_btn", function() {

		// 댓글번호
		var span = $(this).parent();
		var comment_number = span.attr("data-comment-number");

		window.open("/buyTogether/buytogetherPopup?buytogether_number="+buytogether_number+"&comment_number="+comment_number,
				"report", "width=600, height=670, left=100, top=50");

	});

	// 같이 사냥 버튼 클릭시 모달 창
	$(document).on("click", ".buytogetherBtn .buy_together_btn", function() {

		if($("#buy_together_btn").val() == "BUY TOGETHER"){

			var result = controller.requestBuytogetherCheck(buytogether_number,user_number);
			if(result == '') {

				$("#myModal").modal({'show' : true});
				controller.requestRegistBuytogether(buytogether_number, user_number);

			} else {

				$("#myModal1").modal({'show' : true});

			}
		}

	});

	// 같이 사냥 취소하기 버튼 클릭
	$(document).on("click", "#cancel", function() {

		controller.requestCancleBuytogether(buytogether_number, user_number);

	});

	// URL 복사
	$(document).on("click", "#urlCopy", function copy_trackback() {

		var IE = (document.all)?true:false;
		var url = $(location).attr('href');

		if (IE) {

			if(confirm("이 글의 트랙백 주소를 클립보드에 복사하시겠습니까?")){

				window.clipboardData.setData("Text", url);

			}

		} else {

			temp = prompt("이 글의 트랙백 주소입니다. Ctrl+C를 눌러 클립보드로 복사하세요", url);

		}

	});

});
