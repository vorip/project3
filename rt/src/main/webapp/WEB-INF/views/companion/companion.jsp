<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/companionStyle.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/companion.js"></script>
</head>
<body>
	<div class="compaList" id="compaList">
		<h2>동행찾기 리스트</h2>
			<p>동행찾기 신청자 리스트 입니다.</p>
		<table class="comTable">
		
			<tr style="text-align: center;">
				<th class="td_title" style="min-width: 200px;">프로필</th>
				<th class="td_title" style="min-width: 200px;">이름</th>
				<th class="td_title" style="min-width: 200px;" >현재인원/제한인원수</th>
				<th class="td_title" style="min-width: 200px;">여행출발장소</th>
				<th class="td_title" style="min-width: 200px;">여행도착장소</th>
				<th class="td_title" style="min-width: 200px;">여행기간</th>
				<th class="td_title" style="min-width: 200px;">여행소개</th>
			</tr>
			${companionResult}
		</table>
	</div>
</body>
</html>