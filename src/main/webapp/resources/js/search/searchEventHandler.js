$('head').append('<script src=\'/resources/js/search/searchController.js\'><\/script>');

$('.c-quick-search').submit(function() {
	
	var controller = new searchController();
	var query = $('#query').val(); //검색 문장
	
	controller.requestSearch(query);
	
});
