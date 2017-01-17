$('head').append('<script src=\'/resources/js/qna/qnaDao.js\'><\/script>');

function qnaController() {

	var dao = new qnaDao();

	//QNA 목록
	this.qnaListAll = function(cri) {
		
		dao.qnaListAllDao(cri);
		
	}

	//QNA 조회
	this.qnaListOne = function(qna_number) {

		return dao.qnaListOneDao(qna_number);
		
	}
	
	//QNA 삭제
	this.qnaDelete = function(qna_number) {

		dao.qnaDeleteDao(qna_number);
		
	}
	
	//QNA 수정
	this.qnaUpdate = function(qna_number) {

		dao.qnaUpdateDao(qna_number);
		
	}
	
	//QNA 수정완료
	this.qnaDoneUpdate = function(info) {
		
		dao.qnaDoneUpdateDao(info);
		
	}
	
	//QNA 등록
	this.qnaInsert = function(info) {

		return dao.qnaInsertDao(info);
		
	}
	
}


