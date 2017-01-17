$('head').append('<script type="text/javascript" src="/resources/js/myPage/myPageDao.js"></script>');

function myPageController() {
	
	var dao = new myPageDao();
	var user, result;
	var message = [];
	
	//내 정보 요청
	this.requestMyPageRead = function() {
		
		user = dao.readDao();

		if(user != null) {
			
			$("#id").val(user.id);
			$("#reputation").val(user.reputation);
			$("#name").val(user.name);
			$("#nickname").val(user.nickname);
			$("#phone_number").val(user.phone_number);
			$("#email").val(user.email);
			$("#sido").val(user.user_sido);
			$("#sigungu").val(user.user_sigungu);
			
			for(var i = 0; i < user.category_number.length; i++){
				$('input:checkbox[name = "'+ user.category_number[i] +'"]').each(function() {
					      this.checked = true; //checked 처리
				});
			}
		
		}
		
	}
	
	//패스워드 수정 요청
	this.requestUpdatePassword = function(password, updatePassword) {
		
		result = dao.updatePasswordDao(password, updatePassword);
		
		if(result == "success") {
			
			message[0] = "c-font-green-2 glyphicon glyphicon-ok-sign";
			message[1] = "비밀번호가 수정되었습니다.";
			
			
		} else {
			
			message[0] = "c-font-red glyphicon glyphicon-remove-sign";
			message[1] = "비밀번호 수정에 오류가 발생했습니다.";
			
		}
		
		return message;
		
	}
	
	//연락처 수정 요청
	this.requestUpdatePhoneNumber = function(phone_number) {
		
		result = dao.updatePhoneNumberDao(phone_number);
		
		if(result == "success") {
			
			message[0] = "c-font-green-2 glyphicon glyphicon-ok-sign";
			message[1] = "연락처가 수정되었습니다.";
			
			
		} else {
			
			message[0] = "c-font-red glyphicon glyphicon-remove-sign";
			message[1] = "연락처 수정에 오류가 발생했습니다.";
			
		}
		
		return message;
		
	}
	
	//이메일 수정 요청
	this.requestUpdateEmail = function(email) {
		
		result = dao.updateEmailDao(email);
		
		if(result == "success") {
			
			message[0] = "c-font-green-2 glyphicon glyphicon-ok-sign";
			message[1] = "이메일이 수정되었습니다.";
			
			
		} else {
			
			message[0] = "c-font-red glyphicon glyphicon-remove-sign";
			message[1] = "이메일 수정에 오류가 발생했습니다.";
			
		}
		
		return message;
		
	}
	
	//관심 카테고리 수정 요청
	this.requestUpdateInterest = function(interest) {
		
		if(interest.length == 0) {
			
			message[0] = "c-font-red glyphicon glyphicon-exclamation-sign";
			message[1] = "적어도 하나의 카테고리를 선택해주세요.";
			
		} else {
			result = dao.updateInterestDao(interest);
			
			if(result == "success") {
				
				message[0] = "c-font-green-2 glyphicon glyphicon-ok-sign";
				message[1] = "관심 카테고리가 수정되었습니다.";
				
				
			} else {
				
				message[0] = "c-font-red glyphicon glyphicon-remove-sign";
				message[1] = "관심 카테고리 수정에 오류가 발생했습니다.";
				
			}
			
		}
		
		return message;
		
	}
	
	//화면 새로고침 요청
	this.requestDaumPost = function() {
		
		dao.DaumPostDao();
		
	}
	
	//관심 지역 수정 요청
	this.requestUpdateAddress = function(address) {

		result = dao.updateAddresstDao(address);
		
		if(result == "success") {
			
			message[0] = "c-font-green-2 glyphicon glyphicon-ok-sign";
			message[1] = "관심 지역이 수정되었습니다.";
			
			
		} else {
			
			message[0] = "c-font-red glyphicon glyphicon-remove-sign";
			message[1] = "관심 지역 수정에 오류가 발생했습니다.";
			
		}
			
		return message;
		
	}
	
	//화면 새로고침 요청
	this.requestRefresh = function() {
		
		document.location = "/mypage";
		
	}
	
}
