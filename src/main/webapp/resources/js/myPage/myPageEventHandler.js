$('head').append('<script type="text/javascript" src="/resources/js/myPage/myPageController.js"></script>');

$(document).ready(function (){
	
	if(sessionStorage.getItem("pw") != "null") {
		
		$("#passwordArea").css("display", "block");
		$("#emailArea").css("display", "block");
		
	}
	
	var controller = new myPageController();
	controller.requestMyPageRead();
	
	var result;
	var message = [];
	
	$('#pwUpdate').on("click", function() {
		
		var password = $("#password").val();
		var updatePassword = $("#updatePassword").val();
		
		message = controller.requestUpdatePassword(password, updatePassword);
		modal(message);
		
	});
	
	$('#phoneBtn').on("click", function() {
		
		var phone_number = $("#phone_number").val();
		
		message = controller.requestUpdatePhoneNumber(phone_number);
		modal(message);
		
	});
	
	$('#emailBtn').on("click", function() {
		
		var email = $("#email").val();
		
		message = controller.requestUpdateEmail(email);
		modal(message);
		
	});
	
	$('#interestBtn').on("click", function() {
		
		var interest = [];
		
		$('.check').each(function () { //모든 관심 카테고리 체크
			
			if ($(this).is(":checked")) { //관심 카테고리로 설정했다면,
				
				interest.push($(this).val());

			}
			
		});
		
		message = controller.requestUpdateInterest(interest);
		modal(message);
		
	});
	
	$('#DaumPostcode').on("click", function() {

		controller.requestDaumPost();
		
	});
	
	$('#addressBtn').on("click", function() {
		
		var address = [ $("#sido").val(), $("#sigungu").val() ];
		message = controller.requestUpdateAddress(address);
		modal(message);
		
	});
	
	$('#close').on("click", function() {

		controller.requestRefresh();

		
	});
	
	//결과 모달 실행
	function modal(message) {

		$(".modal-body").children("p").removeClass();
		$(".modal-body").children("p").addClass(message[0]);
		$("#msg").children("span").text(message[1]);
		$('#modal').modal({'show' : true});
		
	}

});
