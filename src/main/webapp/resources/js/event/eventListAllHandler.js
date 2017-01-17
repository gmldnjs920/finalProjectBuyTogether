$('head').append('<script src=\'/resources/js/event/eventController.js\'><\/script>');


$(document).ready(function (){

	var page = 1;
	var perPageNum = 3;
	var keyword = $('#keyword').val();
	var searchType = $('#searchType').val();

	var cri = {page : page, perPageNum : perPageNum, keyword : keyword, searchType : searchType}
	var controller = new eventController();
	controller.eventListAll(cri);

	//paging 버튼클릭시 
	$('#pagination').on("click", "li a", function(event){

		event.preventDefault();

		var page = $(this).attr("href");
		var perPageNum = 3;
		var keyword = $('#keyword').val();

		var searchType = $('#searchType').val();

		var cri = {page : page, perPageNum : perPageNum, keyword : keyword, searchType : searchType}

		controller.eventListAll(cri);
	
	});
	
	//search 버튼 클릭시 
	$('#search').on("click",function(){

		var keyword = $('#keyword').val();
		var page = 1;
		var perPageNum = 3;
		var searchType = $('#searchType').val();

		var cri = {page : page, perPageNum : perPageNum, searchType : searchType, keyword : keyword};
		
		controller.eventListAll(cri);
	
	});

});
