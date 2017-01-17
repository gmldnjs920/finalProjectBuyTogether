function eventDao() {

	//정보사냥 목록
	this.eventListAllDao = function(cri){
		
		$.ajax({
			type : 'post',
			url : '/restEvent/eventListAll/',
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType : 'text',
			data : JSON.stringify(cri),
			success : function(result) {

				//data가map에담겨있는json형식의문자열이므로list를쓰려면한단계추가로거쳐줘야함.
				var parsedResult = JSON.parse(result);
				var eventListAll = parsedResult.eventListAll;
				
				var ListTemplate = Handlebars.compile($('#eventListTemplate').html());
				var html1 = ListTemplate(eventListAll);

				$("#eventListAllLi").remove();
				$("#eventListAll").html(html1);

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

	//정보사냥 조회
	this.eventListOneDao = function(board_number) {

		$.getJSON("/restEvent/eventListOne/"+board_number, function(data) {	
			
			var template = Handlebars.compile($('#eventListOneTemplate').html());

			var html2 = template(data);

			$("#eventListOne").html(html2);
		});
	}

}
