function noticeDao() {

	this.listAllDao = function(cri) {

		$.ajax({
			type : 'POST',
			url : "/restNotice/list",
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType : 'text',
			data : JSON.stringify(cri),
			success : function(result) {
				var parsedResult = JSON.parse(result);
				var noticeListAll = parsedResult.noticeListAll;
				var template = Handlebars.compile($('#noticeListTemplate').html());
				var html1 = template(noticeListAll);

				$(".noticeListAllLi").remove();
				$("#noticeList").html(html1);

				var pageMaker = parsedResult.pageMaker;
				$("#forRemove *").remove();
				printPaging(pageMaker, $("#pagination"));//페이징

			}
		});
	}

	//페이징작업위치여기
	var printPaging = function(pageMaker, target){

		var str = "<ul class='c-content-pagination c-theme' id='forRemove'>"

			if(pageMaker.prev){
				str += "<li><a href='"+(pageMaker.startPage-1)+"'> << </a></li>"
			}

		for(var i = pageMaker.startPage, len = pageMaker.endPage; i <= len; i++){
			var strClass = pageMaker.cri.page == i?'class = active':''
				str += "<li "+strClass+" class='pageNumber'><a href = '"+i+"'>"+i+"</a></li>"
		}

		if(pageMaker.next){
			str += "<li><a href='"+(pageMaker.endPage+1)+"'> >> </a></li>"
		}

		str += "</ul>"
			target.html(str);
	};

	this.readOneDao = function(board_number) {

		var result;
		
		$.ajax({
			type : "GET",
			url : "/restNotice/listOne/" + board_number,
			async : false,
			header: {
				"Content-Type" : "application/json;charset=UTF-8",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType: "json",
			success : function(data) {

				result = data;
			}
		});
		
		return result;
	}

	this.InsertDao = function(board_title, board_content) {

		$.ajax({
			type : "post",
			url : "/restNotice/write",
			header: {
				"Content-Type" : "application/json;charset=UTF-8",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType: "text",   
			data: {
				board_title : board_title,
				board_content : board_content
			},
			success : function(result) {
				console.log("result : " + result);
				if(result == 'success') {
					document.location.href='/notice/list';
				}
			}
		});
	}

}