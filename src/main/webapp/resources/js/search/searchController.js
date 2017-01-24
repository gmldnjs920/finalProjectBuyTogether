$('head').append('<script type="text/javascript" src="/resources/js/search/searchDao.js"></script>')

function searchController() {
	
	var dao = new searchDao();
	
	//문장 분석 dao 호출
	this.requestSearch = function(query) {
		
		dao.splitQueryDao(query);
		
	}
	
}