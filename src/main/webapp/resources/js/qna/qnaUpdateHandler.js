$('head').append('<script src=\'/resources/js/qna/qnaController.js\'><\/script>');

$(function(){
	
    var qna_number = $(location).attr('search');
    
    var searchKeyword = qna_number.split("?qna_number=");
    qna_number = searchKeyword[1];
    
	var controller = new qnaController();
	
	var data = controller.qnaListOne(qna_number);
	
	var template = Handlebars.compile($('#qnaUpdateTemplate').html());
	var html2 = template(data);
	$("#qnaUpdate").html(html2);

	
	//업데이트 클릭이벤트
	$("#qnaUpdate").on("click", "#qnaUpdate", function(){

		var qna_number = $("#qna_number").attr("data-qnanumber");
		var qna_title = $('#qna_title').val();
		var qna_content = $('#qna_content').val();
		
		
		var info = {
				"qna_number" : qna_number,
				"qna_title" : qna_title,
				"qna_content" : qna_content,
		}

		controller.qnaDoneUpdate(info);
	});
	
});
