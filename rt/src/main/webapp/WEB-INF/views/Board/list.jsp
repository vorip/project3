<%@page import="com.rt.travel.board.dto.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모정</title>

	<!-- CSS STYLE -->
	<link rel="stylesheet" href="resources/assets/css/Boardreset.css">
	<link rel="stylesheet" href="resources/assets/css/Boardstyle.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

	<!-- 웹 폰트 -->
	<link href="https://fonts.googleapis.com/css?family=Black+Han+Sans|Orbitron&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
	
	<script>
		$(document).ready(function () {
			$('#btnWrite').click(function () {
				location.href= "${path}/Board/write.do";
			});
		});
	</script>
	
</head>

<body>
<%-- <%@ include file="../include/menu.jsp" %> --%>
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
							<a class="menu_nav" href="#">여행일정 만들기</a>
							<a class="menu_nav" href="#">여행일정 리스트</a>
						</div>
					</div>
					<div class="dropdown">
						<h3 class="font_color">동행찾기</h3>
						<div class="dropdown-content">
							<a class="menu_nav" href="#">전체동맹찾기 리스트</a>
							<a class="menu_nav" href="#">동행찾기 리스트</a>
							<a class="menu_nav" href="#">같은 여행지 사람찾기</a>
							<a class="menu_nav" href="#">동행찾는 여행일정</a>
						</div>
					</div>
					<div class="dropdown">
						<h3 class="font_color">소통광장</h3>
						<div class="dropdown-content">
							<a class="menu_nav" href="Board.do">여행후기 게시판</a>
							<a class="menu_nav" href="#">?? 게시판</a>
							<a class="menu_nav" href="#">?? 게시판</a>
							<a class="menu_nav" href="#">동행찾는 여행일정</a>
						</div>
					</div>
					<div>
						<h3 class="font_color">마이페이지</h3>
						<ul>
							<li><a class="menu_nav" href="#">나의 여행일정</a></li>
							<li><a class="menu_nav" href="#">즐겨찾는 여행일정</a></li>
							<li><a class="menu_nav" href="#">나의 동행찾기 수정</a></li>
							<li><a class="menu_nav" href="#">받는 쪽지함</a></li>
							<li><a class="menu_nav" href="#">보낸 쪽지함</a></li>
							<li><a class="menu_nav" href="#">회원정보수정</a></li>
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
							<a href="로그인 경로 페이지">로그인</a>
							<a href="회원가입 경로 페이지">회원가입</a>
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
			
			<div>
				<div id = "cont_Board_header">
					<div class="container">
						내용 미정
					</div>
				</div>
			</div>
			
			<div id="content">
				<div id = "cont_nav">
					<div class="container">
						<div class="notice">
									<h4>여행후기 게시판</h4>
									
									<table class="type_01 "border="1">
									    <thead>
									    <tr>
									        <th scope="co_0">번호</th>
									        <th scope="co_1">닉네임</th>
									        <th scope="co_2">제목</th>
									        <th scope="co_3">조회수</th>
									        <th scope="co_4">작성날짜</th>
									    </tr>
									    </thead>
									    <tbody>
									    <c:forEach var="row" items="${list}">
										    <tr>
										        <th scope="row">${row.bno}</th>
										        <td>${row.writer}</td>
										        <td><a href="${path}view.do?bno=${row.bno}">${row.title}</a></td>
										        <td>${row.viewcnt}</td>
										        <td><fmt:formatDate value="${row.regdate}" pattern="yyyy-MM-dd HH:mm"/></td>
										    </tr>
									    </c:forEach>
									    </tbody>
									</table>
									
					</div>
					<div class="button_position">
							<a href="write.do"><button type="button" class="btn btn-primary" id="btnWrite">글쓰기</button></a>
					</div>
				</div>
			<!-- cont_nav -->
			
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