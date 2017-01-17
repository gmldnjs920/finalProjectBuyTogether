$('head').append('<script src=\'/resources/js/notice/noticeController.js\'><\/script>');

$(document).ready(function() {
	
	var page = 1;
	var perPageNum = 10;
	var keyword = $('#keyword').val();
	var searchType = $('#serachType').val();
	
	var controller = new noticeController();
	
	var cri = {page : page, perPageNum : perPageNum, keyword : keyword, searchType : searchType}

	controller.requestListAll(cri);
	
	//글쓰기 버튼 클릭시
	$("#register").on("click", function(){
		
		controller.requestWritePage();
	});
	
	//paging 버튼 클릭시
	$('#pagination').on("click", "li a", function(event){
		event.preventDefault();

		var page = $(this).attr("href");
		var perPageNum = 10;
		var keyword = $('#keyword').val();

		var searchType = $('#searchType').val();

		var cri = {page : page, perPageNum : perPageNum, keyword : keyword, searchType : searchType}

		controller.requestListAll(cri);
	
	});
	
	//search 버튼 클릭시 
	$('#search').click(function(){

		var keyword = $('#keyword').val();
		var page = 1;
		var perPageNum = 10;
		var searchType = $('#searchType').val();

		var cri = {page : page, perPageNum : perPageNum, searchType : searchType, keyword : keyword}
		
		controller.requestListAll(cri);
	
	});
	
});