// 타이틀, 여행기간, 출발일 유효성 검사
$(function () {
   $("#btn_next").click(function () {
      var title = $("#title").val().trim();
      var date = $("#travel_day").val().trim();
      var date_start = $("#datepicker").val().trim();
      
      if(title=="" || date=="" || date_start==""){
         alert("필수항목을 입력해주세요:>");
         return false;
      }else{
      }
   })
})


