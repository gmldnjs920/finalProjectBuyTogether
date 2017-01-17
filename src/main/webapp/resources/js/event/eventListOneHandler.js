$('head').append('<script src=\'/resources/js/event/eventController.js\'><\/script>');

$(function(){
	
    var board_number = $(location).attr('search');
    
    var searchKeyword = board_number.split("?board_number=");
    board_number = searchKeyword[1];
    
	var controller = new eventController();
	controller.eventListOne(board_number);
	
	$("#listBtn").on("click", function () {
		
		document.location = "/event";
		
	});
    
});