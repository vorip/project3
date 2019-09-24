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

	<!-- CSS STYLE -->
	<link rel="stylesheet" href="resources/assets/css/reset.css">
	<link rel="stylesheet" href="resources/assets/css/style.css">
	<link rel="stylesheet" href="resources/assets/css/weather.css">

	<!-- 웹 폰트 -->
	<link href="https://fonts.googleapis.com/css?family=Black+Han+Sans|Orbitron&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
	
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
		var $cDate = $now.getFullYear() + "/" + $now.getMonth() + "월" + $now.getDate() + 1 + "일" + $now.getHours() + ":" + $now.getMinutes();
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
${loginPageScript}
	<img id='getChat'onclick = "getChat();" src = "resources/img/logo.png">
	<!-- 스킵 내비게이션 -->
	<div id="skip">
		<a href="#cont_nav">전체 메뉴 바로가기</a>
		<a href="#cont_ban">배너 영역 바로가기</a>
		<a href="#cont_cont">컨텐츠 영역 바로가기</a>
	</div>
	<!-- //스킵 내비게이션 -->
	<div id="wrap">
		<div id="menu">
			<div class="container">
				<div class="menu">
					<div>
						<h3><a class="font_color" href="#">홈</a></h3>
					</div>
					<div class="dropdown">
						<h3 class="font_color">여행일정</h3>
						<div class="dropdown-content">
							<a class="menu_nav" href="typea.do">여행일정 만들기</a>
							<a class="menu_nav" href="selectAll.do">여행일정 리스트</a>
						</div>
					</div>
					<div class="dropdown">
						<h3 class="font_color">동행찾기</h3>
						<div class="dropdown-content">
							<a class="menu_nav" href="companion">전체동맹찾기 리스트</a>
						</div>
					</div>
					<div class="dropdown">
						<h3 class="font_color">소통광장</h3>
						<div class="dropdown-content">
							<a class="menu_nav" href="list.do">여행후기 게시판</a>
							<a class="menu_nav" href="#">?? 게시판</a>
							<a class="menu_nav" href="#">?? 게시판</a>
							<a class="menu_nav" href="#">동행찾는 여행일정</a>
						</div>
					</div>
					<div>
						<h3 class="font_color">마이페이지</h3>
						<ul>
							<li><a class="menu_nav" href="#">나의 여행일정</a></li>
							<li><a class="menu_nav" href="#">나의 동행찾기 수정</a></li>
							<li><a class="menu_nav" href="my">회원정보보기</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!-- menu -->
			<div id="header">
				<div class="container">
					<div class="header">
						<div class="header_menu">
							<a id="loginPageHref" href="loginPage">로그인</a>
							<a id="signHref" href="sign">회원가입</a>
						</div>
					<!-- //헤더 메뉴 -->
					<div class="header-tit">
						<h1>모두의 정보 &amp; 모정!!</h1><br>
						<!-- <a href="">www.우리가 정한 사이트 이름</a> -->
					</div>
					<!-- //헤더 타이틀 -->
					
					<!-- 이미지를 표현하는 방법 
						1. img 태그로 표현(의미가 있을때) / alt 태그 - 대체 문자 표현
						2. background 속성으로 표현(의미가 없을때)
						3. 이미지를 background 속성 - 웹 표준 준수하기 위해서 
							가상으로 대체를 문자를 만들어줌(IR 효과)
							이미지 스프라이트
					-->
					</div>
				</div>
			</div>
			<!-- header -->
			
			<div id="content">
				<div id = "cont_nav">
					<div class="container">
						<div class="nav">
							<div class="nav_tit">
								<h2>WHERE &amp; WHEN</h2>
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
			<!-- cont_tit -->
			
				<div id = "cont_cont">
					<div class="container">
						<div class="cont">
							<div class="column col">
								<h3><span class="ico_img ir_pm">아이콘</span><span class="ico_tit">Notice</span></h3>
								<p class="col_desc">게시판 내용 리스트</p>
								<!-- 게시판 -->
								<div class="notice">
									<h4>Web Publisher Notice</h4>
									<table class="type_01 "border="1">
									    <thead>
									    <tr>
									        <th scope="co_1">닉네임</th>
									        <th scope="co_2">제목</th>
									        <th scope="co_3">조회수</th>
									        <th scope="co_4">작성날짜</th>
									    </tr>
									    </thead>
									    <tbody>
									    <tr>
									        <th scope="row">회원 닉네임</th>
									        <td>내용이 들어갑니다.</td>
									        <td>내용이 들어갑니다.</td>
									        <td>내용이 들어갑니다.</td>
									    </tr>
									    <tr>
									        <th scope="row">회원 닉네임</th>
									        <td>내용이 들어갑니다.</td>
									        <td>내용이 들어갑니다.</td>
									        <td>내용이 들어갑니다.</td>
									    </tr>
									    <tr>
									        <th scope="row">회원 닉네임</th>
									        <td>내용이 들어갑니다.</td>
									        <td>내용이 들어갑니다.</td>
									        <td>내용이 들어갑니다.</td>
									    </tr>
									    <tr>
									        <th scope="row">회원 닉네임</th>
									        <td>내용이 들어갑니다.</td>
									        <td>내용이 들어갑니다.</td>
									        <td>내용이 들어갑니다.</td>
									    </tr>
									    </tbody>
									</table>
									<a href="#" class="">더보기</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			<!-- cont_cont -->
			
				<div id = "cont_ban">
					<div class="container">cont_ban</div>
				</div>
			<!-- cont_ban -->
			</div>
			<!-- content -->
			
			<div id="footer">
					<div class="container">footer</div>
			</div>
			<!-- footer -->
		
	</div>
	<!-- wrap -->
	
</body>
</html>