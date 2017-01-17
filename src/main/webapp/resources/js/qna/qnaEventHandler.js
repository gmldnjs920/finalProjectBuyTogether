$('head').append('<script src=\'/resources/js/qna/qnaController.js\'><\/script>');

$(function(){
	
    var qna_number = $(location).attr('search');
    
    var searchKeyword = qna_number.split("?qna_number=");
    qna_number = searchKeyword[1];
    console.log("qna_number: " + qna_number);
	var controller = new qnaController();
	
	var data = controller.qnaListOne(qna_number);
	
	var template = Handlebars.compile($('#qnaListOneTemplate').html());
	var html2 = template(data);
	$("#qnaListOne").html(html2);
    
	//클릭이벤트
	$("#qnaListOne").on("click", "#qnaDelete", function(){
				
		var qna_number = $("#qna_number").attr("data-qnanumber");

        $("#myModal").modal({'show' : true});
		
		var re = controller.qnaDelete(qna_number);
		
		document.location = "/qna";
		
	});
	

});
