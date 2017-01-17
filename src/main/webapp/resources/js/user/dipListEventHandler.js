$('head').append('<script type="text/javascript" src="/resources/js/user/dipListController.js"></script>')

$(document).ready(function(){
   
   var controller = new dipListController();
//   var user_number = sessionStorage.getItem("number");
   
   
 //  sessionStorage.setItem("number", 11);
   var user_number = sessionStorage.getItem("number");
   console.log(user_number);
   controller.requestDipListAll(user_number);
   //찜하기 버튼 클릭
   $('body').on("click",'.heart', function() {
      
      $(this).css("background-position","")
      
      var heartAni = $(this).attr("rel");
      var heartValue = $(this).attr("value");

      if(heartAni === 'unlike') {
         
         $(this).addClass("heartAnimation").attr("rel","like"); 
         
      } else {
         
         $(this).removeClass("heartAnimation").attr("rel","unlike");
         $(this).css("background-position","left");
         
      }

   });//heart click end

   //변경 완료 버튼 클릭시
   $('#submit').on("click", function() {

      var heartAni = [];
      
      $('.heart').each(function () { //모든 찜
         
         if($(this).attr("rel") === "unlike") { //하트가 눌려있지 않는다면
            
            heartAni.push($(this).attr("value"));

         }
         
      });
      
      if(heartAni != null) { //하나라도 눌려있으면 실행
         
         controller.requestDipDelete(heartAni);
         
      }

   });//heart click end

});