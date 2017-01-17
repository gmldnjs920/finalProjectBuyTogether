$('head').append('<script src=\'/resources/js/buytogether/buytogetherReadController.js\'><\/script>');

$(document).ready(function() {

   // 로그인한 유저번호 
   var numberuser = sessionStorage.getItem("number");
   // 게시판 넘버
   var url =  $(location).attr('search');
   var buytogether_number;
   var comment_number;
   var searchKeyword = url.split("?buytogether_number=");
   buytogether_number = searchKeyword[1].split("&")[0];
   comment_number = url.split("&comment_number=")[1];
   
   var controller = new buytogetherReadController();
   
   controller.requestCommentReport(buytogether_number,comment_number);
   
   //같이사냥 신고페이지 신고버튼 이벤트
   $(document).on("click", "#report_btn", function() {

      //임의값 test 용
      var user_number = 5;

      // 고정값
      if ($(':radio[name="optradio"]:checked').is(":checked") == true) {

         var declare_category_number = $(':radio[name="optradio"]:checked').val();

      }

      var declare_reason = $("#text").val();
      var type_number = 1;
      var declare_status = "false";

      var reportData = {
            buytogether_number : buytogether_number,
            comment_number : comment_number,
            user_number : user_number,
            declare_category_number : declare_category_number,
            type_number : type_number,
            declare_reason : declare_reason,
            declare_status : declare_status
      };

     controller.requestSendReport(reportData);

     window.close();
     
   });
   
});