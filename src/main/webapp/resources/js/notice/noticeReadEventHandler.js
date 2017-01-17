$('head').append('<script src=\'/resources/js/notice/noticeController.js\'><\/script>');

$(document).ready(function(){
	
    var board_number = $(location).attr('search');
    var searchKeyword = board_number.split("?board_number=");
    board_number = searchKeyword[1];
    
	var controller = new noticeController();
	
	controller.requestReadOne(board_number);
	
	//목록 버튼 클릭시
	$('#list').on("click", function(){
		
		document.location = '/notice/list';
		
	});
/*	
	//수정 버튼 클릭시
	$("#update").on("click", function(){
		
		controller.requestUpdatePage(board_number);
		
	});
	
	//삭제 버튼 클릭시
	$('#delete').on("click", function(){
		
		controller.requestDelete(board_number);
		
	});*/
    
});