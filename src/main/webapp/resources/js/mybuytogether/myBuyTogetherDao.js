
function myBuyTogetherDao() {
	
	//페이징 작업 위치 여기??
	var printPaging = function(pageMaker, target){

		var str = "<ul class='c-content-pagination c-theme' id='forRemove'>";

		if(pageMaker.prev){
			str += "<li><a href='"+(pageMaker.startPage-1)+"'> << </a></li>";
		}''

		for(var i = pageMaker.startPage, len = pageMaker.endPage; i <= len; i++){
			var strClass = pageMaker.cri.page == i?'class = active':'';
			str += "<li "+strClass+" class='pageNumber'><a href = '"+i+"'>"+i+"</a></li>";
		}

		if(pageMaker.next){
			str += "<li><a href='"+(pageMaker.endPage+1)+"'> >> </a></li>";
		}
		
		str += "</ul>"
		target.html(str);
	};
	
	//개설한 같이사냥
	this.openBuyTogether = function(scri){

		$.ajax({
			async : false,
			type : 'post',
			url : '/restMyBuytogether/requestOpenBuyTogether/',
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType : 'text',
			data : JSON.stringify(scri),
			success : function(result) {
				
				//data가 map에 담겨 있는 json형식의 문자열이므로 list를 쓰려면 한 단계 추가로 거쳐줘야함.
				var parsedResult = JSON.parse(result);
				var searchMyBuyTogether = parsedResult.searchMyBuyTogether;
				var ListTemplate = Handlebars.compile($('#myBuyTogetherTemplate').html());
				var html1 = ListTemplate(searchMyBuyTogether);
				
				$(".myBuyTogetherLi").remove();
				$("#openBuyTogetherList").html(html1);

				var pageMaker = parsedResult.pageMaker;
				$("#openBuyTogetherPaging").children().remove();
				$("#joinBuyTogetherPaging").children().remove();
				$("#doneBuyTogetherPaging").children().remove();
				printPaging(pageMaker, $("#openBuyTogetherPaging"));//페이징

				
			}
		});
	}

	//(개살한) 같이사냥 평판매길 유저정보 가져오기
	
	this.openReputationBtn = function(buyTogetherNumber){
		
		var dataPlate;
		
		$.ajax({
			async : false,
			type : 'get',
			url : '/restMyBuytogether/requestOpenReputation/'+buyTogetherNumber,
			header : {
				'Accept': 'application/json',
				"ContentType" : "application/json",
				"X-HTTP-Method-Override" : "GET"
			},
			dataType : 'text',
			success : function(data){
				var parsedData = JSON.parse(data);
				var ListTemplate = Handlebars.compile($('#openUserInfo').html());
				var html1 = ListTemplate(parsedData);
				
				$(".modal-body").html(html1);
			}
		});
	};
	
	//(개설한) 같이사냥 평판매기기
	this.scoreUserInfo = function(scoreUserInfoList){
		
		$.ajaxSettings.traditional = true;
		
		var scri;
		
		$.ajax({
			async : false,
			type : 'post',
			url : '/restMyBuytogether/requestReputationScore',
			header : {
				'Accept': 'application/json',
				"ContentType" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType : 'text',
			data : {"scoreUserInfoList" : scoreUserInfoList},
			success : function(result){
				
			}
		});
		
	};

	//(개설한) 같이사냥 1인 평판매기기
	this.ScoreUserInfoForOne = function(scoreUserInfoList){
		
		
		$.ajaxSettings.traditional = true;
		
		var scri;
		
		$.ajax({
			async : false,
			type : 'post',
			url : '/restMyBuytogether/requestReputationScoreForOne',
			header : {
				'Accept': 'application/json',
				"ContentType" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType : 'text',
			data : {"scoreUserInfoList" : scoreUserInfoList},
			success : function(result){
				
			}
		});
		
		
	};
	//같이사냥 완료하기 
	this.finishBuyTogether = function(buyTogetherNumber){
		
		$.ajax({
			async : false,
			type : 'get',
			url : '/restMyBuytogether/requestFinishBuyTogether/'+buyTogetherNumber,
			header : {
				'Accept': 'application/json',
				"ContentType" : "application/json",
				"X-HTTP-Method-Override" : "GET"
			},
			dataType : 'text',
			success : function(result){
				
				var keyword = "";
				var page = 1;
				var perPageNum = 6;
				var searchType = 't';
				var user_number = sessionStorage.getItem("number");

				var scri = {page : page, perPageNum : perPageNum, searchType : searchType, keyword : keyword, user_number : user_number}
				var controller = new myBuyTogetherController();
				controller.requestOpenBuyTogether(scri);
				
			}
		});
		
	}	
	
	//참여한 같이사냥
	this.joinBuyTogether = function(scri){
		
		$.ajax({
			async : false,
			type : 'post',
			url : '/restMyBuytogether/requestJoinBuyTogether/',
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType : 'text',
			data : JSON.stringify(scri),
			success : function(result) {
				//data가 map에 담겨 있는 json형식의 문자열이므로 list를 쓰려면 한 단계 추가로 거쳐줘야함.
				
				var parsedResult = JSON.parse(result);
				var searchMyBuyTogether = parsedResult.searchMyBuyTogether;
				var ListTemplate = Handlebars.compile($('#myBuyTogetherTemplate').html());
				var html1 = ListTemplate(searchMyBuyTogether);
				
				$(".myBuyTogetherLi").remove();
				$("#joinBuyTogetherList").html(html1);

				var pageMaker = parsedResult.pageMaker;
				console.log(pageMaker);
				$("#openBuyTogetherPaging").children().remove();
				$("#joinBuyTogetherPaging").children().remove();
				$("#doneBuyTogetherPaging").children().remove();
				printPaging(pageMaker, $("#joinBuyTogetherPaging"));//페이징
				
			}
		});
	}
	
	//(참여한) 같이사냥 평판매길 유저정보 가져오기
	
	this.joinReputationBtn = function(buyTogetherNumber){
		var dataPlate;
		$.ajaxSettings.async = false;
		$.getJSON("/restMyBuytogether/requestJoinReputation/"+buyTogetherNumber, function(data){
			
			/*var ListTemplate = Handlebars.compile($('#joinUserInfo').html());
			var html1 = ListTemplate(data);
			alert(html1);*/
			dataPlate = data;
			
		});
		return dataPlate;
	};
	
	//(참여한) 같이사냥 평판매기기
	this.ScoreUserInfoForJoiner = function(scored_user_number, score, score_user_number, buyTogetherNumber){
		
		$.ajax({
			type : 'get',
			url : '/restMyBuytogether/requestReputationScoreForJoiner/'+scored_user_number+'/'+score+'/'+score_user_number+'/'+buyTogetherNumber,
			header : {
				'Accept': 'application/json',
				"ContentType" : "application/json",
				"X-HTTP-Method-Override" : "GET"
			},
			dataType : 'text',
			success : function(result){
				
			}
		});
	};

	//완료한 같이사냥
	this.doneBuyTogether = function(scri){

		$.ajax({
			type : 'post',
			url : '/restMyBuytogether/requestDoneBuyTogether/',
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType : 'text',
			data : JSON.stringify(scri),
			success : function(result) {
				
				//data가 map에 담겨 있는 json형식의 문자열이므로 list를 쓰려면 한 단계 추가로 거쳐줘야함.
				var parsedResult = JSON.parse(result);
				var searchMyBuyTogether = parsedResult.searchMyBuyTogether;
				var ListTemplate = Handlebars.compile($('#myBuyTogetherTemplate').html());
				var html1 = ListTemplate(searchMyBuyTogether);

				$(".myBuyTogetherLi").remove();
				$("#doneBuyTogetherList").html(html1);

				var pageMaker = parsedResult.pageMaker;
				console.log(pageMaker);
				$("#openBuyTogetherPaging").children().remove();
				$("#joinBuyTogetherPaging").children().remove();
				$("#doneBuyTogetherPaging").children().remove();
				printPaging(pageMaker, $("#doneBuyTogetherPaging"));//페이징

			}
		});
	}

	this.openReadBuyTogether = function(buyTogether_number){

		$.ajax({
			type : 'get',
			url : '/restBuytogetherRead/read/' + buyTogether_number,
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "GET"
			},
			dataType : 'text',
			success : function(result){
				
			}
		});
	};
	
}