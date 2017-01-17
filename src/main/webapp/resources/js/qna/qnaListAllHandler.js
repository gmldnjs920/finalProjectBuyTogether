$('head').append('<script src=\'/resources/js/qna/qnaController.js\'><\/script>');

$(document).ready(function (){

	var page = 1;
	var perPageNum = 10;
	var keyword = $('#keyword').val();
	var searchType = $('#searchType').val();
	
	var cri = {page : page, perPageNum : perPageNum, keyword : keyword, searchType : searchType, user_number: sessionStorage.getItem("number")};
	
	var controller = new qnaController();
	
	controller.qnaListAll(cri);

	//페이징
	$('#pagination').on("click", "li a", function(event){

		event.preventDefault();
		
		var page = $(this).attr("href");
		var perPageNum = 10;
		var keyword = $('#keyword').val();
		var searchType = $('#searchType').val();

		var cri = {page : page, perPageNum : perPageNum, keyword : keyword, searchType : searchType, user_number: sessionStorage.getItem("number")};
	
		controller.qnaListAll(cri);

	});
	
});