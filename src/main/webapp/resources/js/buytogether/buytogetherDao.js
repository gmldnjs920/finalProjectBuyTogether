function buytogetherDao() {
	
	//유저 관심 카테고리 존재 여부 확인
	this.listUserInterest = function(user_number) {
		
		var result;
		
		$.ajax({
			
			url:'/restBuytogether/userInterest',
			type: 'post',
			data: {user_number : user_number},
			dataType: 'text',
			async : false,
			success: function(data){

				result = data;
			}
		});
		
		return result;
	};

	//카테고리 리스트 요청
	this.listCategoryDao = function() {

		$.getJSON("/restBuytogether/listCategory", function(data) {

			var str = "<option value=''>선택해주세요.</option>";

			$(data).each(function() {

				str += "<option value='" + this.category_number + "'>";
				str += this.category_name+"</option>";

			});

			$("#category_number").html(str);
		});
	}

	//사냥방식 리스트 요청
	this.listHuntingTypeDao = function() {

		$.getJSON("/restBuytogether/listHuntingType", function(data) {

			var str = "<option value=''>선택해주세요.</option>";

			$(data).each(function() {

				str += "<option value='" + this.hunting_type_number + "'>";
				str += this.hunting_type+"</option>";
			});

			$("#hunting_type_number").html(str);
		});
	}
	
	//사냥방식 리스트 요청
	this.listHuntingStatusDao = function() {

		$.getJSON("/restBuytogether/listHuntingStatus", function(data) {

			var str = "<option value=''>선택해주세요.</option>";

			$(data).each(function() {

				str += "<option value='" + this.status_number + "'>";
				str += this.status_name+"</option>";
			});

			$("#hunting_status_number").html(str);
		});
	}

	//사진경로
	this.savePhotoPath = function(formData) {

		$.ajax({

			url:'/restBuytogether/uploadAjax',
			type: 'POST',
			data: formData,
			dataType: 'text',
			processData: false,
			contentType: false,
			success: function(data){

				var str="<div class='col-md-3'>";
				str = str + "<img src='/restBuytogether/displayFile?fileName=" + data +"'/>";
				str = str + "<div class='mailbox-attachment-info'>"+data.substr(data.indexOf("_",14)+1);
				str = str + " <small class='btn btn-default btn-xs delbtn' data-src=" + data + ">X</small></div></div>";

				$(".uploadedList").append(str);
			}
		});
	};

	//첨부사진 삭제
	this.deletePhotoDao = function(photo) {

		var result;
		$.ajax({

			url:'/restBuytogether/deleteFile',
			type: 'POST',
			data: {fileName: photo.attr("data-src")},
			dataType: 'text',
			async : false,
			success: function(data){

				result = data;
			}
		});
		return result;
	}

	//게시글 쓰기
	this.insertDao = function(buytogether) {

		console.log(buytogether);
		$.ajax({
			type : "post",
			url : "/restBuytogether/write",
			header: {
				"Content-Type": "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType: "text",	
			data: {
				title : buytogether.title,
				content : buytogether.content,
				path : buytogether.path,
				duedate : buytogether.duedate,
				join_number : buytogether.join_number,
				price : buytogether.price,
				user_number : buytogether.user_number,
				category_number : buytogether.category_number,
				hunting_type_number : buytogether.hunting_type_number,
				buytogether_address_sido : buytogether.buyTogether_address_sido,
				buytogether_address_sigungu : buytogether.buyTogether_address_sigungu,
				buytogether_address_road_address : buytogether.buyTogether_address_road_address,
				buytogether_address_detail : buytogether.buyTogether_address_detail,
				longitude : buytogether.longitude,
				latitude : buytogether.latitude
			},
			success : function(result) {

				if(result == "success") {
					document.location.href='/buyTogether/list';
				}else {
					alert("글쓰기 실패");
					document.location.href='/buyTogether/list';
				}

			}
		});
	}
	
	//같이사냥 수정시 해당 글번호의 내용 가져옴
	this.readOneDao = function(buytogether_number) {
		
		var result;
		
		$.ajax({
			type: 'post',
			url : '/restBuytogether/readOne',
			async : false,
			data : {buytogether_number : buytogether_number},
			dataType : 'json',
			success : function(data) {
				
				result = data;
			}
		});
		
		console.log(result);
		return result;
	}
	
	//같이사냥 글 수정
	this.UpdateBuyTogetherDao = function(buytogetherUpdate) {
		
		var result;
		$.ajax({
			type: 'post',
			url : '/restBuytogether/update',
			header: {
				"Content-Type": "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			async : false,
			data : { 
				buyTogether_number : buytogetherUpdate.buyTogether_number,
				title : buytogetherUpdate.title,
				content : buytogetherUpdate.content,
				path : buytogetherUpdate.path,
				duedate : buytogetherUpdate.duedate,
				join_number : buytogetherUpdate.join_number,
				price : buytogetherUpdate.price,
				category_number : buytogetherUpdate.category_number,
				hunting_type_number : buytogetherUpdate.hunting_type_number,
				buytogether_address_sido : buytogetherUpdate.buyTogether_address_sido,
				buytogether_address_sigungu : buytogetherUpdate.buyTogether_address_sigungu,
				buytogether_address_road_address : buytogetherUpdate.buyTogether_address_road_address,
				buytogether_address_detail : buytogetherUpdate.buyTogether_address_detail,
				longitude : buytogetherUpdate.longitude,
				latitude : buytogetherUpdate.latitude
			},
			dataType : 'text',
			success : function(data) {
				
				result = data;
			}
		});
		return result;
		
	}

	//같이사냥 리스트(기본)
	this.listBuyTogetherDao = function(scri){

		var parsedResult;

		$.ajax({
			type : 'post',
			url : '/restBuytogether/listBuyTogether',
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			async : false,
			dataType : 'text',
			data : JSON.stringify(scri),
			success : function(result) {
				//data가 map에 담겨 있는 json형식의 문자열이므로 list를 쓰려면 한 단계 추가로 거쳐줘야함.
				parsedResult = JSON.parse(result);

			}
		});

		return parsedResult;
	}

	//같이사냥 리스트(지도)
	this.mapListBuyTogetherDao = function(scri){
		
		var parsedResult;
		
		$.ajax({
			type : 'post',
			url : '/restBuytogether/mapListBuyTogether',
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			async : false,
			dataType : 'text',
			data : JSON.stringify(scri),
			success : function(result) {

				//data가 map에 담겨 있는 json형식의 문자열이므로 list를 쓰려면 한 단계 추가로 거쳐줘야함.
				parsedResult = JSON.parse(result);

			}
		});

		return parsedResult;
		
	}
	
}