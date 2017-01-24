function searchDao() {
	
	//검색 문장 분석 dao
	this.splitQueryDao = function(data) {
		
		var query = data;
		var keyWords = [];
		var result;
		
		while(query.includes(" ")) { //문장에 공백이 포함되어있는동안,

			var index = query.indexOf(" ");
			keyWords.push(query.substring(0,index)); 
			query = query.substring(index+1);
			
		}
		
		keyWords.push(query);

		jQuery.ajaxSettings.traditional = true;

		$.ajax({
			type: 'post',
			url: '/restSearch/buyTogether',
			data: { "keyWords": keyWords },
			dataType: 'text',
			async : false,
			success : function(data) {
				result = data;
			}
		});
		
		console.log("result: " + result);
		
	}
	
}
