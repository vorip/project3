<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모정</title>
   <link rel="stylesheet" href="resources/css/chat.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
   <script src="resources/js/getChat.js"></script>

   <link rel="stylesheet" href="resources/assets/css/weather.css">

   ${publicHead}   
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script> //나중에 해당 지역 검색시 날짜 나오게 하기 추가
   /* 날씨 예보 관련 소스 */
   $.getJSON('http://api.openweathermap.org/data/2.5/forecast?id=1835848&APPID=d5196c99956fe82fdb246da58c2ff9ef&units=metric', function (data) {
      //alert(data.list[0].main.temp_min);
      var $city = data.city.name;
      var $cDate = data.list[0].dt_txt;
      var $cTemp = data.list[0].main.temp;
      var $maxTemp = data.list[0].main.temp_max;
      var $minTemp = data.list[0].main.temp_min;
      var $wIcon = data.list[0].weather[0].icon;
      $('.city_name').append($city);
      $('.weather_header').prepend($cDate);
      $('.ctemp').append($cTemp);
      $('.ctemp_value').prepend($cTemp);
      $('.chightemp').append($maxTemp);
      $('.clowtemp').append($minTemp);
      $('.cicon').append('<img src="http://openweathermap.org/img/w/' + $wIcon + '.png" />');
      
   });
   
   /* 오늘 날씨 관련 소스 */
   $.getJSON('http://api.openweathermap.org/data/2.5/weather?id=1835848&APPID=d5196c99956fe82fdb246da58c2ff9ef&units=metric', function (data) {
      var $t_city = data.name;
      var $now = new Date($.now()); //현재 시간 출력
      var $cDate = $now.getFullYear() + "-" + ($now.getMonth()+1) + "-" + $now.getDate() +" " + $now.getHours() + ":" + $now.getMinutes();
      var $cTemp = data.main.temp;
      var $maxTemp = data.main.temp_max;
      var $minTemp = data.main.temp_min;
      var $wIcon = data.weather[0].icon;
      $('.p_city_name').append($t_city);
      $('.t_weather_header').prepend($cDate);
      $('.t_ctemp').append($cTemp);
      $('.t_ctemp_value').prepend($cTemp);
      $('.t_chightemp').append($maxTemp);
      $('.t_clowtemp').append($minTemp);
      $('.t_cicon').append('<img src="http://openweathermap.org/img/w/' + $wIcon + '.png" />');
      
   });
</script>

<body>
   <img id='getChat'onclick = "getChat();" src = "resources/img/logo.png">
   ${publicBody}
         <!-- header -->
         
         <div id="content">
            <div id = "cont_nav">
               <div class="container">
                  <div class="nav" style="margin: 0; padding: 0;">
                     <div class="nav_tit">
                        <h2 style="margin: 0; padding: 0;">WHERE &amp; WHEN</h2>
                     </div>
                        <div class="nav_sub">
                           <p>여행계획은 언제, 어디서를 하나씩 채워하가는 과정이라 생각합니다.</p>
                           <p>도레미 스토리는 언제, 어디서를 바탕으로 사람들이 모이는 여행커뮤니티 입니다.</p>
                        </div>
                  </div>
               </div>
            </div>
         <!-- cont_nav -->
         
            <div id = "cont_tit">
               <div class="container">
                  <div class="test">
                     <div class="test1">
                        <h2 class="weather_header"> - 날씨 예보</h2>
                        <div class="ctemp">현재 온도 : </div>
                        <div class="chightemp">최고 온도 : </div>
                        <div class="clowtemp">최저 온도 : </div>
                        <div class="weather-wrapper">
                            <div class="weather-card madrid">
                                <div class="weather-icon sun"></div>
                                <h1 class="ctemp_value">º</h1>
                                <p class="city_name"></p>
                            </div>
                        </div>
                     </div>
                     <div class="test2">
                        <h2 class="t_weather_header"> - 오늘 날씨</h2>
                        <div class="t_ctemp">현재 온도 : </div>
                        <div class="t_chightemp">최고 온도 : </div>
                        <div class="t_clowtemp">최저 온도 : </div>
                        <div class="weather-wrapper">
                           <div class="weather-card london">
                                <div class="weather-icon cloud"></div>
                                <h1 class="t_ctemp_value">º</h1>
                                <p class="p_city_name"></p>
                            </div>
                         </div>
                     </div>
                     <div class="test3">
                        해당 지역검색기능 추가예정
                     </div>
                     <div class="test4">
                        해당 지역검색기능 추가예정
                     </div>
                  </div>
               </div>
                  <!-- <a href="#" class="prev"><span>이전 이미지</span></a>
                     <ul>
                        <li><a href="#"><img src="../img/button_1.png" alt="주제별 추천코스 보기"></a>
                        <li><a href="#"><img src="../img/button_2.png" alt="주제별 추천코스 보기"></a>
                     </ul>
                  <a href="#" class="next"><span>다음 이미지</span></a> -->
               </div>
            </div>
         ${publicBody2}
</body>
</html>