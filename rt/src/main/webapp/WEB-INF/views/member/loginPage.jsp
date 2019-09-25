<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/memberStyle.css">
<link rel="stylesheet" href="resources/css/chat.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/member.js"></script>

	<!-- CSS STYLE -->
	<link rel="stylesheet" href="resources/assets/css/reset.css">
	<link rel="stylesheet" href="resources/assets/css/Boardstyle.css">
	<link rel="stylesheet" href="resources/assets/css/weather.css">

	<!-- 웹 폰트 -->
	<link href="https://fonts.googleapis.com/css?family=Black+Han+Sans|Orbitron&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
</head>
<body>
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
						<h3><a class="font_color" href="main.do">홈</a></h3>
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
					<div class="dropdown">
						<h3 class="font_color">마이페이지</h3>
						<div class="dropdown-content">
							<a class="menu_nav" href="#">나의 여행일정</a>
							<a class="menu_nav" href="#">나의 동행찾기 수정</a>
							<a class="menu_nav" href="my">회원정보보기</a>
						</div>
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
					</div>
				</div>
			</div>
			</div>
${loginPage}
</body>
</html>