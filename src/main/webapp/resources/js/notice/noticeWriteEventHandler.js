$('head').append('<script src=\'/resources/js/notice/noticeController.js\'><\/script>');

$(document).ready(function() {
	
	var controller = new noticeController();
	
	//글쓰기버튼 클릭시
	$('#insert').on('click', function() {

		var board_title = $('#board_title').val();
		var board_content = $('#board_content').val();

		controller.requestWriteNotice(board_title, board_content);
	});
	
	//취소버튼 클릭시
	$('#cancle').on('click', function() {
		
		document.location = '/notice/list';
	});
	
});