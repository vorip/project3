<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모정</title> 
<!-- ckeditor 포함 -->
<script src="resources/ckeditor/ckeditor.js"></script>

<!-- 글쓰기 기능 -->
<script type="text/javascript">
	$(document).ready(function () {
		$("#btnSave").click(function () {
			var title = $("#title").val();
			var content = $(".content").val();
			if(title == ""){
				alert("제목을 입력하세요");
				document.form1.title.focus();
				return;
			}
			if(content == ""){
				alert("내용을 입력하세요");
				document.form1.content.focus();
				return;
			}
			document.form1.submit();
		});
	});
</script>


<!-- CSS STYLE -->
<link rel="stylesheet" href="resources/assets/css/Boardreset.css">
<link rel="stylesheet" href="resources/assets/css/Boardstyle.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<!-- 웹 폰트 -->
<link
	href="https://fonts.googleapis.com/css?family=Black+Han+Sans|Orbitron&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Nanum+Pen+Script&display=swap"
	rel="stylesheet">

</head>

<body>
	<!-- 스킵 내비게이션 -->
	<div id="skip">
		<a href="#cont_nav">전체 메뉴 바로가기</a> <a href="#cont_ban">배너 영역 바로가기</a>
		<a href="#cont_cont">컨텐츠 영역 바로가기</a>
	</div>
	<!-- //스킵 내비게이션 -->
	<div id="wrap">
		<div id="menu">
			<div class="container">
				<div class="menu">
					<div>
						<h3>
							<a class="font_color" href="main.do">홈</a>
						</h3>
					</div>
					<div class="dropdown">
						<h3 class="font_color">여행일정</h3>
						<div class="dropdown-content">
							<a class="menu_nav" href="#">여행일정 만들기</a> <a class="menu_nav"
								href="#">여행일정 리스트</a>
						</div>
					</div>
					<div class="dropdown">
						<h3 class="font_color">동행찾기</h3>
						<div class="dropdown-content">
							<a class="menu_nav" href="#">전체동맹찾기 리스트</a> <a class="menu_nav"
								href="#">동행찾기 리스트</a> <a class="menu_nav" href="#">같은 여행지
								사람찾기</a> <a class="menu_nav" href="#">동행찾는 여행일정</a>
						</div>
					</div>
					<div class="dropdown">
						<h3 class="font_color">소통광장</h3>
						<div class="dropdown-content">
							<a class="menu_nav" href="list.do">여행후기 게시판</a> <a
								class="menu_nav" href="#">?? 게시판</a> <a class="menu_nav"
								href="#">?? 게시판</a> <a class="menu_nav" href="#">동행찾는 여행일정</a>
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
						<a href="로그인 경로 페이지">로그인</a> <a href="회원가입 경로 페이지">회원가입</a>
					</div>
					<!-- //헤더 메뉴 -->
					<div class="header-tit">
						<h1>모두의 정보 &amp; 모정!!</h1>
						<br>
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
			<div id="cont_Board_header">
				<div class="container">내용 미정</div>
			</div>
		</div>

		<div id="content">
			<div id="cont_nav_bo">
				<div class="container">
					<div class="notice">
						<h4>여행후기 게시판</h4>
						<form method="post" action="insert.do" id="form1" name="form1">
							<table class="type_01" border="2" style="width: 100%;">
								<thead>
									<tr>
										<th scope="co_0" colspan="2" style="width: 100%;">게시판 글쓰기 양식</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><input type="text"
											placeholder="글 제목" name="title" id='title' maxlength="50" style="width: 100%;  height:30px;"></td>
									</tr>
									<tr>
										<td><textarea
											placeholder="글 내용" name="content" id="p_content" class="content" maxlength="4000" rows=14 style="width: 100%;"></textarea></td>
									</tr>
								</tbody>
							</table>
									<script>
										CKEDITOR.replace("p_content", {height: "450px"
											});
									</script>
							<div><!--  -->
								<input type="submit" class="btn btn-primary button_position" id="btnSave"
									value="등록">
							</div>
						</form>
					</div>
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