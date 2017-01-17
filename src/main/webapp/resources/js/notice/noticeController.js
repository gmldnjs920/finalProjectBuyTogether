$('head').append('<script src=\'/resources/js/notice/noticeDao.js\'><\/script>');

function noticeController() {
	
	var dao = new noticeDao();

	this.requestListAll = function(cri) {
		
		dao.listAllDao(cri);
		
	}
	
	this.requestReadOne = function(board_number) {
		
		var data = dao.readOneDao(board_number);
     
		//날짜 제대로 뜨게 해줌
        var dateObj = new Date(data.board_writeDate);
        var year = dateObj.getFullYear();
        var month = dateObj.getMonth() + 1;
        var date = dateObj.getDate();
        var writeDate = year+"/"+month+"/"+date;
        
		console.log(data);
		$('#title').html(data.board_title);
		$('#writer').html(data.admin_nickname);
		$('#writeDate').html(writeDate);
		$('#content').html(data.board_content);
	
	}
	
	this.requestWritePage = function() {
		
		document.location = "/notice/write";
		
	}
	
	this.requestWriteNotice = function(board_title, board_content) {
		
		dao.InsertDao(board_title, board_content);
		
	}
	
}