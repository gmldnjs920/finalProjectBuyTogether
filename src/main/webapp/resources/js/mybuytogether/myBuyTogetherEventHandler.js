$('head').append('<script src=\'/resources/js/mybuytogether/myBuyTogetherController.js\'><\/script>');

$(document).ready(function (){

	//첫 화면(개설한 같이사냥) 
	var keyword =  $('#keyword').val();
	var page = 1;
	var perPageNum = 6;
	var searchType = $('#searchType').val();
	var user_number = sessionStorage.getItem("number");

	var scri = {page : page, perPageNum : perPageNum, searchType : searchType, keyword : keyword, user_number : user_number}
	var controller = new myBuyTogetherController();
	controller.requestOpenBuyTogether(scri);

	//개설한 같이사냥(클릭시)
	$('#openBuyTogether').click(function(){

		var keyword = $('#keyword').val();
		var page = 1;
		var perPageNum = 6;
		var searchType = $('#searchType').val();
		var user_number = sessionStorage.getItem("number");;

		var scri = {page : page, perPageNum : perPageNum, searchType : searchType, keyword : keyword, user_number : user_number}

		controller.requestOpenBuyTogether(scri);

	});

	//개설한 같이사냥 검색이벤트
	$('#search').click(function(){

		var keyword = $('#keyword').val();
		var page = 1;
		var perPageNum = 6;
		var searchType = $('#searchType').val();
		var user_number = sessionStorage.getItem("number");;

		var scri = {page : page, perPageNum : perPageNum, searchType : searchType, keyword : keyword, user_number : user_number}

		controller.requestOpenBuyTogether(scri);

	});

	//개설한 같이사냥  페이징& 개설한 같이사냥 검색페이징
	$('#openBuyTogetherList').siblings('.c-pagination').on("click", "li a", function(event){

		event.preventDefault();

		var keyword = $('#keyword').val();
		var page = $(this).attr("href");
		var perPageNum = 6;
		var searchType = $('#searchType').val();
		var user_number = sessionStorage.getItem("number");;

		var scri = {page : page, perPageNum : perPageNum, searchType : searchType, keyword : keyword, user_number : user_number}

		controller.requestOpenBuyTogether(scri);

	});

	//참여한 같이사냥
	$('#joinBuyTogether').click(function(){

		var keyword = $('#keyword').val();
		var page = 1;
		var perPageNum = 6;
		var searchType = $('#searchType').val();
		var user_number = sessionStorage.getItem("number");;

		var scri = {page : page, perPageNum : perPageNum, searchType : searchType, keyword : keyword, user_number : user_number}

		controller.requestJoinBuyTogether(scri);

	});

	//참여한 같이사냥 검색
	$('#search').click(function(){

		var keyword = $('#keyword').val();
		var page = 1;
		var perPageNum = 6;
		var searchType = $('#searchType').val();
		var user_number = sessionStorage.getItem("number");;

		var scri = {page : page, perPageNum : perPageNum, searchType : searchType, keyword : keyword, user_number : user_number}

		controller.requestJoinBuyTogether(scri);

	});

	//참여한 같이사냥 페이징
	$('#joinBuyTogetherList').siblings('.c-pagination').on("click", "li a", function(event){

		event.preventDefault();

		var keyword = $('#keyword').val();
		var page = $(this).attr("href");
		var perPageNum = 6;
		var searchType = $('#searchType').val();
		var user_number = sessionStorage.getItem("number");;

		var scri = {page : page, perPageNum : perPageNum, searchType : searchType, keyword : keyword, user_number : user_number}

		controller.requestJoinBuyTogether(scri);

	});

	//완료한 같이사냥
	$('#doneBuyTogether').click(function(){

		var keyword = $('#keyword').val();
		var page = 1;
		var perPageNum = 6;
		var searchType = $('#searchType').val();
		var user_number = sessionStorage.getItem("number");;

		var scri = {page : page, perPageNum : perPageNum, searchType : searchType, keyword : keyword, user_number : user_number}

		controller.requestDoneBuyTogether(scri);

	});

	//완료한 같이사냥 검색
	$('#search').click(function(){

		var keyword = $('#keyword').val();
		var page = 1;
		var perPageNum = 6;
		var searchType = $('#searchType').val();
		var user_number = sessionStorage.getItem("number");;

		var scri = {page : page, perPageNum : perPageNum, searchType : searchType, keyword : keyword, user_number : user_number}

		controller.requestDoneBuyTogether(scri);

	});

	//완료한 같이사냥 페이징
	$('#doneBuyTogetherList').siblings('.c-pagination').on("click", "li a", function(event){

		event.preventDefault();

		var keyword = $('#keyword').val();
		var page = $(this).attr("href");
		var perPageNum = 6;
		var searchType = $('#searchType').val();
		var user_number = sessionStorage.getItem("number");;

		var scri = {page : page, perPageNum : perPageNum, searchType : searchType, keyword : keyword, user_number : user_number}

		controller.requestDoneBuyTogether(scri);
	});

	//개설한 같이사냥에서 같이사냥 번호로 유저 정보를 받아와야 함.
	$('#openBuyTogetherList').on('click', '.reputationBtn', function(event){

		event.preventDefault();
		var buyTogetherNumber = $(this).parent().parent().parent().parent().children('.buyTogetherNumber').val();
		controller.requestOpenReputationBtn(buyTogetherNumber);
	});

	//참여한 같이사냥에서 같이사냥 번호로 유저 정보를 받아와야 함.
	$('#joinBuyTogetherList').on('click', '.reputationBtn', function(event){

		event.preventDefault();
		var buyTogetherNumber = $(this).parent().parent().parent().parent().children('.buyTogetherNumber').val();

		var data = controller.requestJoinReputationBtn(buyTogetherNumber);
		var ListTemplate = Handlebars.compile($('#joinUserInfo').html());
		var html1 = ListTemplate(data);
		$(this).parent().children().children().children().children('.modal-body').html(html1);
	});

	//개설한 같이사냥 평판주기 완료버튼
	$('#openBuyTogetherList').on('click', '.submitReputation', function(event){

		event.preventDefault();

		/*var scoreUserInfoList = new Array();*/
		var scoreUserInfoList= [];
		var buyTogetherNumber = $(this).parent().parent().children('.modal-body').
		children('.reputationRows').children('.buyTogetherNumberInModalBody').val();

		$(this).parent().parent().children('.modal-body').children('.reputationRows').each(function(){

			var scored_user_number = $(this).children(".joinUserNumber").val();
			var score = $(this).children("div").find("input:radio:checked").val();
			var score_user_number = 0;
			if(score !== undefined){//유저가 다른 한 유저라도 평판점수를 매기지 않고 submit을 누를 경우
				/*var scoreUserInfo = 
            {scored_user_number : scored_user_number, score : score, score_user_number : score_user_number, buyTogetherNumber: buyTogetherNumber};
            scoreUserInfoList.push(scoreUserInfo);
            }*/
				var scoreUserInfo = [scored_user_number, score, score_user_number, buyTogetherNumber];
				scoreUserInfoList.push(scoreUserInfo);
			}

		});
		if((scoreUserInfoList.length == 1) && (scoreUserInfoList.length == $(this).parent().parent().children('.modal-body').children('.reputationRows').length)){
			controller.requestScoreUserInfoForOne(scoreUserInfoList);

			var keyword = $('#keyword').val();
			var page = $(this).parent().parent().parent().parent().parent().parent().parent().parent().parent().
			siblings('#openBuyTogetherPaging').children().children('.active').val;
			var perPageNum = 6;
			var searchType = $('#searchType').val();
			var user_number = 2;

			scri = {page : page, perPageNum : perPageNum, searchType : searchType, keyword : keyword, user_number : user_number}
			controller.requestOpenBuyTogether(scri);

		} else {
			if(scoreUserInfoList.length == $(this).parent().parent().children('.modal-body').children('.reputationRows').length){
				controller.requestScoreUserInfo(scoreUserInfoList);

				var keyword = $('#keyword').val();
				var page = $(this).parent().parent().parent().parent().parent().parent().parent().parent().parent().
				siblings('#openBuyTogetherPaging').children().children('.active').val;
				var perPageNum = 6;
				var searchType = $('#searchType').val();
				var user_number = 2;

				scri = {page : page, perPageNum : perPageNum, searchType : searchType, keyword : keyword, user_number : user_number}
				controller.requestOpenBuyTogether(scri);

			} else {
				alert("모든 유저의 평판을 주어야 합니다.");
			}
		}
	});

	//(참여한) 같이사냥 평판주기 완료버튼
	$('#joinBuyTogetherList').on('click', '.submitReputation', function(event){

		event.preventDefault();

		/*var scoreUserInfoList = new Array();*/


		var buyTogetherNumber = $(this).parent().parent().children('.modal-body').
		children('.reputationRows').children('.buyTogetherNumberInModalBody').val();

		var scored_user_number = $(this).parent().siblings('.modal-body').children().children(".joinUserNumber").val();
		var score = $(this).parent().siblings('.modal-body').children().children('div').find("input:radio:checked").val();
		var score_user_number = 2;//로그인세션에서 받아오면 됨.

		if(score !== undefined){

			controller.requestScoreUserInfoForJoiner(scored_user_number, score, score_user_number, buyTogetherNumber);

			var keyword = $('#keyword').val();
			var page = $(this).parent().parent().parent().parent().parent().parent().parent().parent().parent().
			siblings('#joinBuyTogetherPaging').children().children('.active').val;
			var perPageNum = 6;
			var searchType = $('#searchType').val();
			var user_number = 2;

			scri = {page : page, perPageNum : perPageNum, searchType : searchType, keyword : keyword, user_number : user_number}
			controller.requestJoinBuyTogether(scri);
		}
	});

	//(개설한)같이사냥 완료버튼 클릭시.
	$('#openBuyTogetherList').on('click', '.finishBuyTogether', function(event){
		var buyTogetherNumber = $(this).parent().parent().parent().parent().children('.buyTogetherNumber').val();

		if($(this).parent().siblings(".fourthDiv").children("a").attr("style") == 'display:""'){
			alert("평판주기를 완료해야 같이사냥완료를 할 수 있습니다.")
		} else {

			controller.requestFinishBuyTogether(buyTogetherNumber);
		}

	});

	//(참여한)같이사냥 완료버튼 클릭시.
	$('#joinBuyTogetherList').on('click', '.finishBuyTogether', function(event){
		var buyTogetherNumber = $(this).parent().parent().parent().parent().children('.buyTogetherNumber').val();

		if($(this).parent().siblings(".fourthDiv").children("a").attr("style") == 'display:""'){
			alert("평판주기를 완료해야 같이사냥완료를 할 수 있습니다.")
		} else {

			controller.requestFinishBuyTogether(buyTogetherNumber);
		}

	});

	//개설한 조회클릭시 
	$('#openBuyTogetherList').on('click', '.readBuyTogether', function(event){

		var buyTogether_number = $(this).parent().siblings('.buyTogetherNumber').val();

		controller.requestOpenReadBuyTogether(buyTogether_number)

	});

	$('#joinBuyTogetherList').on('click', '.readBuyTogether', function(event){

		var buyTogether_number = $(this).parent().siblings('.buyTogetherNumber').val();

		controller.requestOpenReadBuyTogether(buyTogether_number)

	});

	$('#doneBuyTogetherList').on('click', '.readBuyTogether', function(event){

		var buyTogether_number = $(this).parent().siblings('.buyTogetherNumber').val();

		controller.requestOpenReadBuyTogether(buyTogether_number)

	});

});
