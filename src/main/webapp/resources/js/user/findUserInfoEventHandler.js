$('head').append('<script type="text/javascript" src="/resources/js/user/findUserInfoController.js"><\/script>')

$(document).ready(function() {

	var controller = new userController();

	//아이디 찾기 버튼 클릭 이벤트
	$('#findId').on("click", function() {

		var name = $('#nameID').val();
		var email = $('#emailID').val();

		if (name == "") {
			$('.modal-body').children().eq(0).attr("class","c-font-red");
			$("#modalContent").html("아이디를 입력해주세요");
			$(".modal").modal({'show' : true});
			return false;
		}
		
		if (email == "") {
			$('.modal-body').children().eq(0).attr("class","c-font-red");
			$("#modalContent").html("이메일을 입력해주세요");
			$(".modal").modal({'show' : true});
			return false;
		}

		var result = controller.findId(name, email);

	});

	//비밀번호 찾기 버튼 클릭 이벤트
	$('#findPassword').on("click", function() {

		var id = $('#idPW').val();
		var name = $('#namePW').val();
		var email = $('#emailPW').val();

		if (id == "") {
			$('.modal-body').children().eq(0).attr("class","c-font-red");
			$("#modalContent").html("아이디를 입력해주세요");
			$(".modal").modal({'show' : true});
			return false;
		}
		
		if (name == "") {
			$('.modal-body').children().eq(0).attr("class","c-font-red");
			$("#modalContent").html("이름을 입력해주세요");
			$(".modal").modal({'show' : true});
			return false;
		}
		
		if (email == "") {
			$('.modal-body').children().eq(0).attr("class","c-font-red");
			$("#modalContent").html("이메일을 입력해주세요");
			$(".modal").modal({'show' : true});
			return false;
		}

		controller.findPassword(name, id, email);
	});

	
});

