$('head').append('<script src=\'/resources/js/user/findUserInfoDao.js\'><\/script>');

function userController() {
	
	var dao = new userDao();

	this.findId = function(name, email) {
		
		var id = dao.findIdDao(name, email);
		
		if(id == "") { //회원없음
			$('.modal-body').children().eq(0).attr("class","c-font-red");
			$("#modalContent").html("입력하신 정보와 일치하는 회원이 없습니다.");
			$(".modal").modal({'show' : true});
		} else { //회원 있음
			$('.modal-body').children().eq(0).attr("class","c-font-blue");
			$("#modalContent").html(name+"님의 아이디는 "+id+"입니다.");
			$(".modal").modal({'show' : true});
		}
		$('#nameID').val("");
		$('#emailID').val("");
	}
	
	this.findPassword = function(name, id, email) {
		
		var result = dao.findPasswordDao(name, id, email);
		
		if(result != "success") { //회원없음
			$('.modal-body').children().eq(0).attr("class","c-font-red");
			$("#modalContent").html("입력하신 정보와 일치하는 회원이 없습니다.");
			$(".modal").modal({'show' : true});
		} else { //회원 있음
			$('.modal-body').children().eq(0).attr("class","c-font-blue");
			$("#modalContent").html("입력하신 이메일로 임시 비밀번호를 발송합니다.");
			$(".modal").modal({'show' : true});
		}
		
		$('#idPW').val("");
		$('#namePW').val("");
		$('#emailPW').val("");
		
	}
	
}