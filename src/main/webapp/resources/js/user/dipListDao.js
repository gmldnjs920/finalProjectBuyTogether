function dipListDao() {

   //내 찜 목록
   this.myDipListDao = function(user_number){
      
      var parsedResult;
      
      $.ajax({
         type : 'post',
         url : '/restUser/myDipList',
         async : false,
         dataType : 'json',
         data : {"user_number" : user_number},
         success : function(result) {
            //data가 map에 담겨 있는 json형식의 문자열이므로 list를 쓰려면 한 단계 추가로 거쳐줘야함.
            parsedResult = result;
   
         }
         
      });
      
      return parsedResult;
      
   }
   
   //선택한 찜 등록
   this.registDipDao = function(heartAni) {
   
      var result = 'fail';
      var dip = {
            user_number : sessionStorage.getItem("number"),
            buytogether_number : heartAni
      };
      
      //서버에 선택한 찜 등록 요청
      $.ajax({
         type: 'post',
         url: '/restUser/registNewDip',   
         headers: { 
            "Content-Type": "application/json",
            "X-HTTP-Method-Override": "POST" },
         data: JSON.stringify(dip),
         dataType: 'text',
         async : false,   
         success:function(data){   
            
            result = data;
            
         }
            
      });
      
      return result;
      
   };
   
   //선택한 찜 삭제
   this.removeDipDao = function(heartAni) {
      
      var result;
      var user_number = sessionStorage.getItem("number");

      jQuery.ajaxSettings.traditional = true; //jquery 1.3 version 사용 시

      //서버에 선택한 찜 삭제 결과 요청
      $.ajax({
         type: 'post',
         url: '/restUser/removeDip',   
         data: {
            "user_number": user_number,
            "buytogether_numbers": heartAni
         },
         dataType: 'text',
         async : false,   
         success:function(data){   
            
            result = data;
            
         }
            
      });
      
      return result;
       
   };

}