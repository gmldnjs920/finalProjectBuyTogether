$('head').append('<script src=\'/resources/js/event/eventDao.js\'><\/script>');

function eventController() {

	var dao = new eventDao();

	//정보사냥 목록
	this.eventListAll = function(cri) {
		
		dao.eventListAllDao(cri);
		
	}

	//정보사냥 조회
	this.eventListOne = function(board_number) {

		dao.eventListOneDao(board_number);

	}
}


