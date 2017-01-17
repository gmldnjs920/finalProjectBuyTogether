function myPageDao() {
	
	var result;
	var user_info;
	var user_number = sessionStorage.getItem("number");

	//내 정보 조회 Dao
	this.readDao = function() {
		
		var user;
		
		$.ajax({
			type: 'post',
			url: '/restMyPage/read',
			data: { "user_number": user_number },
			dataType: 'json',
			async : false,
			success : function(data) {
				user = data;
			}
		});

		return user;
		
	};
	
	//패스워드 수정 Dao
	this.updatePasswordDao = function(password, updatePassword) {
		
		user_info = [user_number, password, updatePassword];

		jQuery.ajaxSettings.traditional = true;
		
		$.ajax({
			type: 'post',
			url: '/restMyPage/updatePassword',
			data: { "user_info": user_info },
			dataType: 'text',
			async : false,
			success : function(data) {
				result = data;
			}
		});

		return result;
		
	};
	
	//연락처 수정 Dao
	this.updatePhoneNumberDao = function(phone_number) {
		
		user_info = [user_number, phone_number];

		jQuery.ajaxSettings.traditional = true;
		
		$.ajax({
			type: 'post',
			url: '/restMyPage/updatePhoneNumber',
			data: { "user_info": user_info },
			dataType: 'text',
			async : false,
			success : function(data) {
				result = data;
			}
		});

		return result;
		
	};
	
	//이메일 수정 Dao
	this.updateEmailDao = function(email) {
		
		user_info = [user_number, email];

		jQuery.ajaxSettings.traditional = true;
		
		$.ajax({
			type: 'post',
			url: '/restMyPage/updateEmail',
			data: { "user_info": user_info },
			dataType: 'text',
			async : false,
			success : function(data) {
				result = data;
			}
		});

		return result;
		
	};
	
	//관심 카테고리 수정 Dao
	this.updateInterestDao = function(interest) {

		jQuery.ajaxSettings.traditional = true;
		
		$.ajax({
			type: 'post',
			url: '/restMyPage/updateInterest',
			data: { 
				"user_number": user_number,
				"interest": interest
			},
			dataType: 'text',
			async : false,
			success : function(data) {
				result = data;
			}
		});

		return result;
		
	};
	
	this.DaumPostDao = function() {

		new daum.Postcode({
			 oncomplete: function(data) {
				 
				 $("#sido").val(data.sido);
	             $("#sigungu").val(data.sigungu);	
				 
			 }
		 }).open();
		
	};
	
	//관심 지역 수정 Dao
	this.updateAddresstDao = function(address) {

		user_info = [ user_number, address[0], address[1] ];
		
		jQuery.ajaxSettings.traditional = true;

		if(address != null) {
			
			$.ajax({
				type: 'post',
				url: '/restMyPage/updateAddress',
				data: { "user_info": user_info },
				dataType: 'text',
				async : false,
				success : function(data) {
					result = data;
				}
			});
	
			return result;
			
		}
		
	};
	
}