$('head').append('<script src=\'/resources/js/qna/qnaController.js\'><\/script>');

$(document).ready(function (){

	var usernumber = sessionStorage.getItem("number");
	
	var controller = new qnaController();

	$(".container").on("click", ".insert_writer", function(){

		var qna_title =$("#qna_title").val();
		var qna_content =$("#qna_content").val();

		var info = {"qna_title" : qna_title, "qna_content" : qna_content, "user_number" : usernumber};
		
		
		var result = controller.qnaInsert(info);
		
		if(result == "success") {

			document.location = "/qna/qna";
		}

	});

});