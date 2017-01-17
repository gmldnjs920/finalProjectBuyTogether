function userDao() {

	this.findIdDao = function(name, email) {
		
		var result;
		
		$.ajax({
			type : "POST",
			url : "/restUser/findId",
			headers: { 
				"Content-Type": "application/json",
				"X-HTTP-Method-Override": "POST" 
					},
			data : JSON.stringify({
					name : name,
					email : email
				}),
			dataType: 'text',
			async : false,	
			success:function(data){
				
				result = data;
			}
		});
		
		return result;

	}
	
	this.findPasswordDao = function(name, id, email) {
		
		var result;
		
		$.ajax({
			type : "POST",
			url : "/restUser/findPassword",
			headers: { 
				"Content-Type": "application/json",
				"X-HTTP-Method-Override": "POST" 
					},
			data : JSON.stringify({
					name : name,
					email : email,
					id : id
				}),
			dataType: 'text', //서버에서 보내오는 데이터 타입
			async : false,	
			success:function(data){
				
				result = data;
			}
		});
		return result;
	}
}