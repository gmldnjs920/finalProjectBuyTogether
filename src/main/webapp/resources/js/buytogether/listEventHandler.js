$('head').append('<script src=\'/resources/js/buytogether/buytogetherController.js\'><\/script>');

$(document).ready(function (){

	var controller = new buytogetherController();

	controller.requestCategoryList();
	controller.requestHuntingTypeList();
	controller.requestHuntingStatusList();
	
	var keyword =  $('#keyword').val();
	var page = 1;
	var perPageNum = 6;
	var user_number = sessionStorage.getItem("number");

	var scri = {
			page : page, perPageNum : perPageNum, keyword : keyword, user_number : user_number
	};
	
	//리스트를 보여주기 위해 큐브포토폴리오 초기화
	var cube = new cubphoto();
	cube.init();
	controller.requestListAll(scri);
	
	//옵션 변경시
	$('#listOption').change(function(){
		
		if($('#listOption').val()==1){
			//관심카테고리로 보기 선택시
			if(user_number == "undefined" || user_number == null){
				//로그인상태가 아닌경우 로그인화면으로 이동
				controller.requestLogin();
				
			}
			
			var interest = controller.requestUserInterest(user_number);
			if(interest <= 0){
				//관심카테고리 등록화면으로 이동
				controller.requestBasicUserInfo();
			} else {
				//관심카테고리로 리스트 출력
				scri.option = 1;
				controller.requestListAll(scri);
			}
			
		} else if($('#listOption').val()==2){
			//관심지역으로 보기 선택시
			
			if(user_number == "undefined" || user_number == null){
				//로그인상태가 아닌경우 로그인화면으로	//로그인상태가 아닌경우 로그인화면으로 이동
				ontroller.requestLogin();
				
			}
			var userAddress = controller.requestUserAddress(user_number);
			if(userAddress <= 0){
				//관심지역 등록화면으로 이동
				controller.requestBasicUserInfo();
				
			} else {
				//관심지역으로 리스트 출력
				scri.option = 2;
				controller.requestListAll(scri);
			}
			
		} else {
			scri.option = 0;
			controller.requestListAll(scri);
		}
	});
	
	//글쓰기버튼 클릭시
	$('#writeButton').click(function(){
		controller.requestWrite();
	});

	//검색버튼 클릭시
	$('#search_button').click(function(){

		var category_number = $('#category_number').val();
		var hunting_type_number = $('#hunting_type_number').val();
		var status_number = $('#hunting_status_number').val();
		var buytogether_address_sido = $('#sido').val();
		var buytogether_address_sigungu = $('#sigungu').val();
		var regDate = $('#registDate').val();
		var option = $('#listOption').val();
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
				user_number : user_number,
				regDate : regDate,
				option : option,
				keyword : keyword
		}

		controller.requestListAll(scri);
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
		var option = $('#listOption').val();
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
				user_number : user_number,
				regDate : regDate,
				option : option,
				keyword : keyword
		}
		
		controller.requestListAll(scri);
	});
});