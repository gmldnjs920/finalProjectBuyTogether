$('head').append('<script src=\'/resources/js/admin/indexerDao.js\'><\/script>');
$('head').append('<script src=\'/resources/js/buytogether/buytogetherDao.js\'><\/script>');

function indexerController() {
	
	var buytogetherDao = new buytogetherDao();
	
	//같이사냥 목록 요청
	this.requestListAll = function(scri) {

		var parsedResult = buytogetherDao.listBuyTogetherDao(scri);
		var searchBuyTogether = parsedResult.searchBuyTogether;
		
		//같이사냥 글이 없으면 해당 글 없음 화면에 표시
		if(searchBuyTogether.length == 0) {

			return;
			
		}
		
		$('.buyTogetherList').show();

		//리스트 붙여줌
		for(var i=0; i<searchBuyTogether.length; i++) {

			var str = "";

			if(searchBuyTogether[i].title.length > 14) {
				searchBuyTogether[i].title = searchBuyTogether[i].title.substring(0,14);
				searchBuyTogether[i].title += "...";
			}
			
			searchBuyTogether[i].content = searchBuyTogether[i].content.substring(0,14);
			searchBuyTogether[i].content += "...";

			str = str + "<td class='col-md-1 c-center c-font-uppercase c-font-16 c-font-grey-2 c-font-bold'>";
			str = str + searchBuyTogether[i].buytogether_number + "</td>";
			str = str + "<td class='col-md-7 c-font-uppercase c-font-16 c-font-grey-2 c-font-bold'>";
			str = str + "<a class='c-theme-link' href='/buyTogether/read?buytogether_number='" + searchBuyTogether[i].buytogether_number + ">";
			str = str + "</a>" + searchBuyTogether[i].buyTogether_title + "</td>";
			str = str + "<td class='col-md-2 c-center c-font-uppercase c-font-16 c-font-grey-2 c-font-bold'>";
			str = str + searchBuyTogether[i].buyTogether_content + "</td>";

		}
		
		$('#buyTogetherList').append(str);
		
		$("#pagination").show();
		var pageMaker = parsedResult.pageMaker;
		printPaging(pageMaker, $("#pagination"));//페이징

	}
	
}