

function qnaDao() {

	this.qnaListAllDao = function(cri){
		
		$.ajax({
			type : 'post',
			url : '/restQna/qnaListAll/',
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType : 'text',
			data : JSON.stringify(cri),
			success : function(result) {

				//data가map에담겨있는json형식의문자열이므로list를쓰려면한단계추가로거쳐줘야함.
				var parsedResult = JSON.parse(result);
				var qnaListAll = parsedResult.qnaListAll;
				var ListTemplate = Handlebars.compile($('#qnaListAllTemplate').html());
				var html1 = ListTemplate(qnaListAll);

				$("#qnaListAllLi").remove();
				$("#qnaListAll").html(html1);

				var pageMaker = parsedResult.pageMaker;
	
				$("#pagination").children().remove();
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

	//qna 조회
	this.qnaListOneDao = function(qna_number) {

		var result;
		
		$.ajax({
			type : 'get',
			url : '/restQna/qnaListOne/' + qna_number,
			dataType : 'json',
			async : false,
			success : function(data) {

				result = data;
			}
		});
		
		return result;
	}

	//QNA 삭제
	this.qnaDeleteDao = function(qna_number) {

		var re;

		$.ajax({
			type : 'delete',
			url : '/restQna/qnaDelete/' + qna_number,
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "DELETE"
			},
			dataType : 'json',
			success : function(result) {

				re = result;

			}
		});

		return re;

	}
	
	//QNA 수정
	this.qnaUpdateDao = function(qna_number) {

		$.ajax({
			type : 'put',
			url : '/restQna/qnaUpdate/' + qna_number,
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "PUT"
			},
			dataType : 'text',
			success : function(result) {

				var ListTemplate = Handlebars.compile($('#qnaUpdateTemplate').html());
				var html1 = ListTemplate(result);

				$("#qnaUpdate").html(html1);
				
			}
			
		});

	}
	
	//QNA 수정완료
	this.qnaDoneUpdateDao = function(info) {
	
		$.ajax({
			type : 'post',
			url : '/restQna/qnaDoneUpdate',
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType : 'text',
			data : JSON.stringify(info),
			success : function(data) {
				
			}
			
		});
		
	}

	//QNA 등록
	this.qnaInsertDao = function(info){
		
		
		
		var result;
		$.ajax({
			type : 'post',
			url : '/restQna/qnaInsert',
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType : 'text',
			data : JSON.stringify(info),
			async : false,
			success : function(data) {
				
				result = data;
			}
				
		});
		
		return result;

	}


}


