$('head').append('<script type="text/javascript" src="/resources/js/user/dipListDao.js"></script>')

function dipListController() {

	var dao = new dipListDao();
	var result;
	var heartAni = [];
	//내 찜 목록 요청
	this.requestDipListAll = function(user_number) {

		var data = dao.myDipListDao(user_number);

		console.log(data);

		var str = "";

		for(var i=0; i<data.length; i++){

			if(data[i].photo_path.length == 0){ //이미지 사진

				data[i].photo_path[0] = '/resources/img/noImage.png'; //빈사진일경우

			} else {

				console.log(data[i].photo_path[0].path);
				var path = data[i].photo_path[0].path;
				data[i].photo_path[0] = "/restBuytogether/displayFile?fileName=" + path; //사진이 있을 경우

			}
			//날짜 제대로 뜨게 해줌
			var dateObj = new Date(data[i].duedate);
			var year = dateObj.getFullYear();
			var month = dateObj.getMonth() + 1;
			var date = dateObj.getDate();
			var duedate = year+"/"+month+"/"+date;

			str += "<div class='row c-cart-table-row' id='dipLi'>";
			str += "<div class='col-md-2 col-sm-3 col-xs-5 c-cart-image'>";
			str += "<img src=" + data[i].photo_path[0] + " /> </div>";
			str += "<div class='col-md-4 col-sm-9 col-xs-7 c-cart-price'>";
			str += "<h3><a href='/buyTogether/read?buytogether_number="+data[i].buytogether_number+"' class='c-font-bold c-theme-link c-font-18 c-font-dark'>";
			str += data[i].title+"</a></h3><p>모집인원 : " + data[i].join_number +"명</p></div><div class='col-md-2 col-sm-3 col-xs-6 c-cart-ref'>";
			str += "<p class='c-cart-sub-title c-theme-font c-font-uppercase c-font-bold'>닉네임</p><p class='c-cart-price c-font-bold p1'>"+data[i].nickname+"</p></div>";
			str += "<div class='col-md-2 col-sm-3 col-xs-6 c-cart-total'>";
			str += "<p class='c-cart-sub-title c-theme-font c-font-uppercase c-font-bold'>가격</p>";
			str += "<p class='c-cart-price c-font-bold p1'>"+ data[i].price + "원</p></div>";
			str += "<div class='col-md-1 col-sm-3 col-xs-6 c-cart-price'>";
			str += "<p class='c-cart-sub-title c-theme-font c-font-uppercase c-font-bold'>마감일</p>";
			str += "<p class='c-cart-price c-font-bold p1'>" + duedate + "</p></div>";
			str += "<div class='col-md-1 col-sm-2 col-xs-6 c-cart-total'>";
			str += "<p class='c-cart-sub-title c-theme-font c-font-uppercase c-font-bold'>찜상태</p>";
			str += "<div class='heart' rel='like' value='" + data[i].buytogether_number + "'></div></div></div>";

		}

		$(".c-cart-table-title").after(str);

	}

	//찜 상태 클릭시 현재 로그인 한 유저의 찜으로 보내주기
	this.requestNewDip = function(heartValue) {

		result = dao.registDipDao(heartValue);

	}

	//찜 클릭 상태 삭제 요청
	this.requestDipDelete = function(heartAni) {

		result = dao.removeDipDao(heartAni);

		if(result == "success") { //찜 목록에 저장 성공이면

			document.location = "/user/myDipList"; //찜 목록 화면으로 이동

		}

	};

}