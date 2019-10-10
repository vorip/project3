<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/chat.css">

	${publicHead}
	<link rel="stylesheet" href="resources/css/chat.css">
	<script src="resources/js/getChat.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript">
	function showPlan(no) {
		location.href = "showindex.do?no="+no;
	}
	</script>
</head>
<body>
	<script src="resources/js/companion.js"></script>
	<img id='getChat'onclick = "getChat();" src = "resources/img/logo.png">
${publicBody}
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