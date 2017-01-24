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
	
	//유저 관심 지역 존재 여부 확인
	this.listUserAddress = function(user_number) {
		
		var result;
		
		$.ajax({

			url:'/restBuytogether/userAddress',
			type: 'post',
			data: {user_number : user_number},
			dataType: 'text',
			async : false,
			success: function(data){

				result = data;
			}
		})
		
		return result;
	}

	//카테고리 리스트 요청
	this.listCategoryDao = function() {

		var result;
		
		$.ajax({
			
			url:'/restBuytogether/listCategory',
			type: 'get',
			dataType: 'json',
			async : false,
			success: function(data){

				result = data;
			}
		});
		
		return result;
	}

	//사냥방식 리스트 요청
	this.listHuntingTypeDao = function() {

		var result;
		
		$.ajax({
			
			url:'/restBuytogether/listHuntingType',
			type: 'get',
			dataType: 'json',
			async : false,
			success: function(data){

				result = data;
			}
		});
		
		return result;
	}
	
	//사냥방식 리스트 요청
	this.listHuntingStatusDao = function() {

		var result;
		
		$.ajax({
			
			url:'/restBuytogether/listHuntingStatus',
			type: 'get',
			dataType: 'json',
			async : false,
			success: function(data){

				result = data;
			}
		});
		
		return result;
	}

	//사진경로
	this.savePhotoPath = function(formData) {

		var result;
		
		$.ajax({
			url:'/restBuytogether/uploadAjax',
			type: 'POST',
			data: formData,
			dataType: 'text',
			processData: false,
			contentType: false,
			success: function(data){

				result = data;
			}
		});
		
		return result;
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

		$.ajax({
			type : "post",
			url : "/restBuytogether/write",
			contentType: "application/json;charset=UTF-8",
			dataType: "text",	
			data: JSON.stringify(buytogether),
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
		
		return result;
	}
	
	//같이사냥 글 수정
	this.UpdateBuyTogetherDao = function(buytogetherUpdate) {
		
		var result;
		
		$.ajax({
			type: 'post',
			url : '/restBuytogether/update',
			contentType: "application/json;charset=UTF-8",
			async : false,
			data : JSON.stringify(buytogetherUpdate),
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