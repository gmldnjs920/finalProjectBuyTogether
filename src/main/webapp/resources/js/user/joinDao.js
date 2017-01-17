function joinDao() {
   
   var result;
   //신규회원 가입
   this.regist = function(user) {
      
      $.ajax({
         type: 'post',
         url: '/join/regist',   
         headers: { 
            "Content-Type": "application/json",
            "X-HTTP-Method-Override": "POST" },
         data: JSON.stringify(user),
         async : false,
         dataType: 'text', //서버에서 보내오는 데이터 타입
         success:function(data){
            
            if(data=="success") { //등록 성공시
               
               result = data;
               
            } else { //등록 실패시
               
               result = "fail";
               
            }

         }
            
      });
      
      return result;

   };
   
   //회원가입 취소 시 회원가입 화면으로 이동
   this.homeDao = function() {      
      
      document.location = "/";

   };

   //회원가입시 아이디 중복체크
   this.idCheckDao = function(id) {      
      //아이디 중복체크
      $.ajax({
         url:'/join/idCheck',      
         type: 'post',
         dataType: 'text',
         data: { "id" : id },
         async : false,
         success: function(data){
            
            if(data == ""){ //닉네임 사용가능
               
               result = "success";
               
            } else { //닉네임 사용불가
               
               result = "fail";
               
            }
            
         }   
         
      });
      
      return result;

   };
   
   //회원가입시 닉네임 중복체크
   this.nicknameCheckDao = function(nickname) {
      //닉네임 중복체크
      $.ajax({
         url:'/join/nicknameCheck',      
         type: 'post',
         dataType: 'text',
         data: { "nickname" : nickname },
         async : false,
         success: function(data){
            
            if(data == ""){ //닉네임 사용가능
               
               result = "success";
               
            } else { //닉네임 사용불가
               
               result = "fail";
               
            }
            
         }   
         
      });

      return result;

   };
   
   //회원가입시 이메일 중복체크
   this.emailCheckDao = function(email) {      

      $.ajax({
         url:'/join/emailCheck',      
         type: 'post',
         dataType: 'text',
         data: { "email" : email },
         async : false,
         success: function(data){
            
            if(data == ""){ //닉네임 사용가능
               
               result = "success"; 
               
            } else { //닉네임 사용불가
               
               result = "fail";
               
            }
            
         }   
         
      });
      
      return result;

   };

}