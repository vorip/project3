<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/chat.css">

	<!-- CSS STYLE -->
	<link rel="stylesheet" href="resources/assets/css/reset.css">
	<link rel="stylesheet" href="resources/assets/css/Boardstyle.css">
	<link rel="stylesheet" href="resources/assets/css/weather.css">

	<!-- 웹 폰트 -->
	<link href="https://fonts.googleapis.com/css?family=Black+Han+Sans|Orbitron&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/companion.js"></script>
</head>
<body>

<!-- //스킵 내비게이션 -->
${loginPageScript}
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
							<a class="menu_nav" href="myPerfectPlanList">나의 여행일정</a>
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
					</div>
				</div>
			</div>
		</div>
	<div class="compaList" id="compaList" style="margin-left: 14%">
		<h2 style="color: #34495e;">동행찾기 리스트</h2>
			<p style="display: block; margin-top: 0.5em; box-sizing: border-box;">동행찾기 신청자 리스트 입니다.</p>
		<table class="comTable" style="border-collapse : collapse; border-spacing:0; empty-cells : show; border: 1px solid #cbcbcb;">
		
			<tr style="text-align: center;">
				<th class="td_title" style="min-width: 200px;border-width: 0 0 1px 0;border-bottom: 1px solid #cbcbcb;border-left: 1px solid #cbcbcb;
			font-size: inherit; margin: 0; overflow: visible; padding: 0.5em 1em; font-weight: bold; color: #666;">프로필</th>
				<th class="td_title" style="min-width: 200px;">이름</th>
				<th class="td_title" style="min-width: 200px;" >현재인원/제한인원수</th>
				<th class="td_title" style="min-width: 200px;">여행출발장소</th>
				<th class="td_title" style="min-width: 200px;">여행도착장소</th>
				<th class="td_title" style="min-width: 200px;">여행기간</th>
				<th class="td_title" style="min-width: 200px; ">여행소개</th>
			</tr>
			${companionResult}
		</table>
	</div>
</body>
</html>