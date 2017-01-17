$('head').append('<script type="text/javascript" src="/resources/js/user/joinController.js"></script>')

$(document).ready(function() {
   //모달을 전역변수로 선언
   var controller = new joinController();
   var message = [];
   var idCheck, emailCheck, nicknameCheck;
   var name = ["아이디", "닉네임", "이메일"];
   var divName = ["Id", "Nickname", "Email"];
   
    $('.onlyAlphabetOrNumber').keyup(function(event){ //키보드를 누르고 뗄때 아이디입력창에서 일어나는 이벤트
       
        if (!(event.keyCode >=37 && event.keyCode<=40)) {
           
            var inputVal = $(this).val();
            $(this).val($(this).val().replace(/[^A-Za-z0-9+]{1,}$/gi,'')); //아이디 4자리 이상 16자리 이하, 영문과 숫자만 가능
            
        }
        
    });

   $(".onlyHangul").keyup(function(event) { //키보드를 누르고 뗄때 이름입력창에서 일어나는 이벤트
      
      if (!(event.keyCode >= 37 && event.keyCode <= 40)) {
         
         var inputVal = $(this).val();
         $(this).val(inputVal.replace(/[a-z0-9]/gi, '')); //이름 한글만 가능
         
      }
      
   });

   $(".onlyNumber").keyup(function(event) { //키보드를 누르고 뗄때 핸드폰번호입력창에서 일어나는 이벤트
      
      if (!(event.keyCode >= 37 && event.keyCode <= 40)) {
         
         var inputVal = $(this).val();
         $(this).val(inputVal.replace(/[^0-9]/gi, '')); //휴대폰번호 숫자만 가능
         
      }
      
   });

   //------- 검사하여 상태를 class에 적용
   $('#id').keyup(function(event) { //인풋창 빨강, 초록창으로 변하는 이벤트

      var divId = $('#divId');

      if ($('#id').val() == "") {
         
         divId.addClass("has-error");
         
      } else if ($('#id').val().length <= 5) {
         
         divId.addClass("has-error");
         
      }  else {
         
         divId.removeClass("has-error");
         divId.addClass("has-success");
         
      }
      
   });

   $('#password').keyup(function(event) { //인풋창 빨강, 초록창으로 변하는 이벤트

      var divPassword = $('#divPassword');

      if ($('#password').val() == "") {
         
         divPassword.addClass("has-error");
         
      } else if ($('#password').val().length <= 5) {
         
         divPassword.addClass("has-error");
         
      } else {
         
         divPassword.removeClass("has-error");
         divPassword.addClass("has-success");
         
      }
      
   });

   $('#passwordCheck').keyup(function(event) { //인풋창 빨강, 초록창으로 변하는 이벤트

      var passwordCheck = $('#passwordCheck').val();
      var password = $('#password').val();
      var divPasswordCheck = $('#divPasswordCheck');

      if ((passwordCheck == "") || (password != passwordCheck)) {
         
         divPasswordCheck.addClass("has-error");
         
      } else {
         
         divPasswordCheck.removeClass("has-error");
         divPasswordCheck.addClass("has-success");
         
      }
      
   });

   $('#name').keyup(function(event) { //인풋창 빨강, 초록창으로 변하는 이벤트

      var divName = $('#divName');

      if ($.trim($('#name').val()) == "") {
         
         divName.addClass("has-error");
         
      } else {
         
         divName.removeClass("has-error");
         divName.addClass("has-success");
         
      }
      
   });

   $('#nickname').keyup(function(event) { //인풋창 빨강, 초록창으로 변하는 이벤트

      var divNickname = $('#divNickname');

      if ($.trim($('#nickname').val()) == "") {
         
         divNickname.addClass("has-error");
         
      } else {
         
         divNickname.removeClass("has-error");
         divNickname.addClass("has-success");
         
      }
      
   });

   $('#email').keyup(function(event) { //인풋창 빨강, 초록창으로 변하는 이벤트

      var divEmail = $('#divEmail');

      if ($.trim($('#email').val()) == "") {
         
         divEmail.addClass("has-error");
         
      } else {
         
         divEmail.removeClass("has-error");
         divEmail.addClass("has-success");
         
      }
      
   });

   $('#phoneNumber').keyup(function(event) { //인풋창 빨강, 초록창으로 변하는 이벤트

      var divPhoneNumber = $('#divPhoneNumber');

      if ($.trim($('#phoneNumber').val()) == "") {
         
         divPhoneNumber.addClass("has-error");
         
      } else {
         
         divPhoneNumber.removeClass("has-error");
         divPhoneNumber.addClass("has-success");
         
      }
      
   });
   
   //------- validation 검사
   $('#userAddBtn').on("click", function(event) {
      
      message = $('#idcheck'); //아이디 중복체크 유무
      var nicknamecheck = $('#nicknamecheck'); //닉네임 중복체크 유무
      var emailcheck = $('#emailcheck'); //이메일 중복체크 유무
      var re_id = /^[A-Za-z0-9+]{6,16}$/; //아이디 검사식
      var re_pw = /^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{6,16}$/; //비밀번호 검사식
      var re_mail = /^([\w\.-]+)@([a-z\d\.-]+)\.([a-z\.]{2,6})$/; //이메일 검사식

      var provision = $('#provision');
      var memberInfo = $('#memberInfo');
      var divId = $('#divId');
      var divPassword = $('#divPassword');
      var divPasswordCheck = $('#divPasswordCheck');
      var divName = $('#divName');
      var divNickname = $('#divNickname');
      var divEmail = $('#divEmail');
      var divPhoneNumber = $('#divPhoneNumber');

      //회원가입약관
      if ($('#provisionYn:checked').val() == "N") {
         
         message[0] = "c-font-red glyphicon glyphicon-info-sign";
         message[1] = "회원가입약관에 동의하여 주시기 바랍니다.";
         modal(message);
         
         provision.addClass("has-error");
         $('#provisionYn').focus();
         return false;
         
      } else {
         
         provision.removeClass("has-error");
         provision.addClass("has-success");
         
      }

      //개인정보취급방침
      if ($('#memberInfoYn:checked').val() == "N") {
         
         message[0] = "c-font-red glyphicon glyphicon-info-sign";
         message[1] = "개인정보취급방침에 동의하여 주시기 바랍니다.";
         modal(message);
         
         memberInfo.addClass("has-error");
         $('#memberInfoYn').focus();
         return false;
         
      } else {
         
         memberInfo.removeClass("has-error");
         memberInfo.addClass("has-success");
         
      }

      //아이디 검사
      if ($('#id').val() == "") {
         
         message[0] = "c-font-red glyphicon glyphicon-info-sign";
         message[1] = "아이디를 입력하여 주시기 바랍니다.";
         modal(message);
         
         divId.addClass("has-error");
         $('#id').focus();
         return false;
         
      } else if (re_id.test($('#id').val()) != true) {
         
         message[0] = "c-font-red glyphicon glyphicon-info-sign";
         message[1] = "아이디의 작성법이 올바르지 않습니다.";
         modal(message);

         divId.addClass("has-error");
         $('#id').focus();
         return false;
         
      } else if (message == "") {
         
         message[0] = "c-font-red glyphicon glyphicon-info-sign";
         message[1] = "아이디 중복체크는 필수입니다.";
         modal(message);

         divId.addClass("has-error");
         $('#id').focus();
         return false;
         
      } else {
         
         divId.removeClass("has-error");
         divId.addClass("has-success");
         
      }

      //패스워드 검사
      if ($('#password').val() == "") {
         
         message[0] = "c-font-red glyphicon glyphicon-info-sign";
         message[1] = "패스워드를 입력하여 주시기 바랍니다.";
         modal(message);
         
         divPassword.addClass("has-error");
         $('#password').focus();
         return false;
         
      } else if (re_pw.test($('#password').val()) != true) {
         
         message[0] = "c-font-red glyphicon glyphicon-info-sign";
         message[1] = "패스워드의 작성법이 올바르지 않습니다.";
         modal(message);

         divPassword.addClass("has-error");
         $('#password').focus();
         return false;
         
      } else {
         
         divPassword.removeClass("has-error");
         divPassword.addClass("has-success");
         
      }

      //패스워드 확인
      if ($('#passwordCheck').val() == "") {
         
         message[0] = "c-font-red glyphicon glyphicon-info-sign";
         message[1] = "패스워드 확인을 입력하여 주시기 바랍니다.";
         modal(message);

         divPasswordCheck.addClass("has-error");
         $('#passwordCheck').focus();
         return false;
         
      } else {
         
         divPasswordCheck.removeClass("has-error");
         divPasswordCheck.addClass("has-success");
         
      }

      //패스워드 비교
      if ($('#password').val() != $('#passwordCheck').val() || $('#passwordCheck').val() == "") {
         
         message[0] = "c-font-red glyphicon glyphicon-info-sign";
         message[1] = "패스워드가 일치하지 않습니다.";
         modal(message);
         
         divPasswordCheck.addClass("has-error");
         $('#passwordCheck').focus();
         return false;
         
      } else {
         
         divPasswordCheck.removeClass("has-error");
         divPasswordCheck.addClass("has-success");
         
      }

      //이름
      if ($('#name').val() == "") {
         
         message[0] = "c-font-red glyphicon glyphicon-info-sign";
         message[1] = "이름을 입력하여 주시기 바랍니다.";
         modal(message);
         
         divName.addClass("has-error");
         $('#name').focus();
         return false;
         
      } else {
         
         divName.removeClass("has-error");
         divName.addClass("has-success");
         
      }

      //닉네임
      if ($('#nickname').val() == "") {
         
         message[0] = "c-font-red glyphicon glyphicon-info-sign";
         message[1] = "닉네임을 입력하여 주시기 바랍니다.";
         modal(message);

         divNickname.addClass("has-error");
         $('#nickname').focus();
         return false;
         
      } else {
         
         divNickname.removeClass("has-error");
         divNickname.addClass("has-success");
         
      }

      //휴대폰 번호
      if ($('#phoneNumber').val() == "") {
         
         message[0] = "c-font-red glyphicon glyphicon-info-sign";
         message[1] = "휴대폰 번호를 입력하여 주시기 바랍니다.";
         modal(message);

         divPhoneNumber.addClass("has-error");
         $('#phoneNumber').focus();
         return false;
         
      } else {
         
         divPhoneNumber.removeClass("has-error");
         divPhoneNumber.addClass("has-success");
         
      }

      //이메일
      if ($('#email').val() == "") {
         
         message[0] = "c-font-red glyphicon glyphicon-info-sign";
         message[1] = "이메일을 입력하여 주시기 바랍니다.";
         modal(message);

         divEmail.addClass("has-error");
         $('#email').focus();
         return false;
         
      } else if (re_mail.test($('#email').val()) != true) {
         
         message[0] = "c-font-red glyphicon glyphicon-info-sign";
         message[1] = "이메일의 작성법이 올바르지 않습니다.";
         modal(message);

         divEmail.addClass("has-error");
         $('#email').focus();
         return false;
         
      } else {
         
         divEmail.removeClass("has-error");
         divEmail.addClass("has-success");
         
      }
      
      if (idCheck == 1 && emailCheck == 1 && nicknameCheck == 1) {
         //모든 입력 검사 끝나면 회원정보 받음
         var user = { 
               id : $('#id').val(),
               pw : $('#password').val(),
               passwordCheck : $('#passwordCheck').val(),
               name : $('#name').val(),
               nickname : $('#nickname').val(),
               birthdate : $('#birthdate').val(),
               gender : $('#gender').val(),
               email : $('#email').val(),
               phone_number : $('#phoneNumber').val()
         };
         
         message = controller.requestJoin(user);
         modal(message);

         controller.requestHome(); //회원가입 완료 성공하면 홈으로 이동
         
      } else {
         
         message[0] = "c-font-red glyphicon glyphicon-info-sign";
         message[1] = "중복체크를 모두 완료해주세요.";
         modal(message);
         return false;
         
      }
      
   });
   
   //회원가입 취소 button click
   $('#cancelBtn').on("click", function() {
      
      controller.requestCancel();

   });
   
   //회원가입시 아이디 중복 체크
   $('#idcheck').on("click", function () {
      
      var divId = $('#divId');

      id = $('#id').val();
      
      if (id == "") {
         
         message[0] = "c-font-red glyphicon glyphicon-remove-sign";
         message[1] = "아이디를 입력하여 주세요.";
         modal(message);
         
         divId.addClass("has-error");
         $('#id').focus();
         
      } else {
         
         var result = controller.requestIdCheck(id);
            
         if (result == "success") {
            
            idCheck = 1;            
            message = controller.requestCheckMsg(result, name[0], divName[0]);
            
         } else {
            
            idCheck = 0;
            message = controller.requestCheckMsg(result, name[0], divName[0]);   
            
         } 
         
         modal(message);
         
      }
      
   });
   
   //회원가입시 닉네임 중복 체크
   $('#nicknamecheck').on("click", function () {

      var divNickname = $('#divNickname');
      
      nickname = $('#nickname').val();
      
      if (nickname == "") {
         
         message[0] = "c-font-red glyphicon glyphicon-remove-sign";
         message[1] = "닉네임을 입력하여 주세요.";
         modal(message);
         
         divNickname.addClass("has-error");
         $('#nickname').focus();
         
      } else {
         
         var result = controller.requestNicknameCheck(nickname);
         
         if (result == "success") {
            
            nicknameCheck = 1;            
            message = controller.requestCheckMsg(result, name[1], divName[1]);
            
         } else {
            
            nicknameCheck = 0;
            message = controller.requestCheckMsg(result, name[1], divName[1]);   
            
         } 
         
         modal(message);
         
      }
      
   });
   
   //회원가입시 이메일 중복 체크
   $('#emailcheck').on("click", function () {
   
      var divEmail = $('#divEmail');
      
      email = $('#email').val();

      if (email == "") {
         
         message[0] = "c-font-red glyphicon glyphicon-remove-sign";
         message[1] = "이메일을 입력하여 주세요.";
         modal(message);
         
         divEmail.addClass("has-error");
         $('#email').focus();
         
      } else {
         
         var result = controller.requestEmailCheck(email);
         
         if (result == "success") {
            
            emailCheck = 1;            
            message = controller.requestCheckMsg(result, name[2]);
            
         } else {
            
            emailCheck = 0;
            message = controller.requestCheckMsg(result, name[2]);   
            
         } 
         
         modal(message);
         
      }
      
   });

});

function modal(message) { //모달창
    
    $(".modal-body").children("p").removeClass();
    $(".modal-body").children("p").addClass(message[0]);
    $("#msg").children("span").text(message[1]);
    $('#modal').modal({'show' : true});
    
}