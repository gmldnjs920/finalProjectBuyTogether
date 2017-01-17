$('head').append('<script type="text/javascript" src="/resources/js/user/joinDao.js"></script>')

function joinController() {
   
   var dao = new joinDao();
   var message = [];
   
   var divId = $('#divId');
   var divNickname = $('#divNickname');
   var divEmail = $('#divEmail');
   
   //회원가입
   this.requestJoin = function(user) {
      //회원가입 성공 유무 체크
      var result = dao.regist(user);   
      
      if(result == "success") {
         
         message[0] = "c-font-green-2 glyphicon glyphicon-ok-sign";
         message[1] = "같이사냥에 오신 것을 환영합니다.";
         
      } else {
         
         message[0] = "c-font-red glyphicon glyphicon-remove-sign"
         message[1] = "회원가입을 완료하지 못하였습니다.";
         
      }
      
      return message;
      
   };

   //회원가입 취소버튼 클릭시
   this.requestCancel = function() {
      
      dao.homeDao();   
      
   };
   
   //회원가입시 아이디 중복체크
   this.requestIdCheck = function(id) {
            
      var result = dao.idCheckDao(id);
      
      return result;      
      
   };
   
   //회원가입시 닉네임 중복체크
   this.requestNicknameCheck = function(nickname) {
            
      var result = dao.nicknameCheckDao(nickname);

      return result;      
      
   };
   
   //회원가입시 이메일 중복체크
   this.requestEmailCheck = function(email) {
            
      var result = dao.emailCheckDao(email);
      
      return result;      
      
   };
   
   //회원가입시 아이디 중복체크 메세지
   this.requestCheckMsg = function(result, name, divName) {
      
      if(result == "success") {
            
         message[0] = "c-font-green-2 glyphicon glyphicon-ok-sign";
         message[1] = "사용가능한 " + name + "입니다.";
         
         if(divName == "Id") {
            
            $('#divId').addClass("has-success");
            
         } else if(divName == "Nickname"){
            
            $('#divNickname').addClass("has-success");
            
         } else {
            
            $('#divEmail').addClass("has-success");
            
         }
         
      } else {
         
         message[0] = "c-font-red glyphicon glyphicon-remove-sign"
         message[1] = "이미 사용중인 " + name + "입니다.";

         if(divName == "Id") {
            
            $('#divId').addClass("has-error");
            
         } else if(divName == "Nickname"){
            
            $('#divNickname').addClass("has-error");
            
         } else {
            
            $('#divEmail').addClass("has-error");
            
         }
         
      }
      
      return message;
      
   };
   
   //회원가입 성공 시
   this.requestHome = function() {

      document.location = "/";
      
   };
   
}