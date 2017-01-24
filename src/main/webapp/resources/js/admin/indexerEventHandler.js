$('head').append('<script src=\'/resources/js/admin/indexerController.js\'><\/script>');

$(document).ready(function (){

	var controller = new indexerController();
	
	var page = 1;
	var perPageNum = 6;
	var user_number = sessionStorage.getItem("number");
	
	var scri = {
			page : page, perPageNum : perPageNum, user_number : user_number
	};
	
	controller.requestListAll(scri);
	
	//검색버튼 클릭시
	$('#search_button').click(function(){

		var category_number = $('#category_number').val();
		var hunting_type_number = $('#hunting_type_number').val();
		var status_number = $('#hunting_status_number').val();
		var buytogether_address_sido = $('#sido').val();
		var buytogether_address_sigungu = $('#sigungu').val();
		var regDate = $('#registDate').val();
		
		var keyword = $('#keyword').val();
		var page = 1;
		var perPageNum = 6;

		var scri = {
				page : page,
				perPageNum : perPageNum,
				category_number : category_number,
				hunting_type_number : hunting_type_number,
				status_number : status_number,
				buytogether_address_sido : buytogether_address_sido,
				buytogether_address_sigungu : buytogether_address_sigungu,
				regDate : regDate,
				keyword : keyword
		}

		controller.requestBuyTogetherMap(scri);
		
	});

	//페이징
	$('#pagination').on("click", "li a", function(event){

		event.preventDefault();

		var category_number = $('#category_number').val();
		var hunting_type_number = $('#hunting_type_number').val();
		var status_number = $('#hunting_status_number').val();
		var buytogether_address_sido = $('#sido').val();
		var buytogether_address_sigungu = $('#sigungu').val();
		var regDate = $('#registDate').val();

		var keyword = $('#keyword').val();
		
		var page = $(this).attr("href");
		var perPageNum = 6;

		var scri = {
				page : page,
				perPageNum : perPageNum,
				category_number : category_number,
				hunting_type_number : hunting_type_number,
				status_number : status_number,
				buytogether_address_sido : buytogether_address_sido,
				buytogether_address_sigungu : buytogether_address_sigungu,
				regDate : regDate,
				keyword : keyword
		}
		
		controller.requestBuyTogetherMap(scri);
		
	});
	
});