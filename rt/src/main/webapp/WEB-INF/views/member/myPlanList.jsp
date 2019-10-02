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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
${publicBody}
	<div class="compaList" id="compaList" style="margin-left: 8%;margin-top:2%; height: 700px;">
		<h2 style="color: #34495e;">나의 여행일정</h2>
			<p style="display: block; margin-top: 0.5em; box-sizing: border-box;">나의 여행일정 리스트입니다.</p>
		<table class="comTable" style="border-collapse : collapse; border-spacing:0; empty-cells : show; border: 1px solid #cbcbcb;">
		
			<tr style="text-align: center;">
				<th class="td_title" style="min-width: 200px;border-width: 0 0 1px 0;border-bottom: 1px solid #cbcbcb;border-left: 1px solid #cbcbcb;
			font-size: inherit; margin: 0; overflow: visible; padding: 0.5em 1em; font-weight: bold; color: #666;">프로필</th>
				<th class="td_title" style="min-width: 200px;">제목</th>
				<th class="td_title" style="min-width: 200px;" >여행일수</th>
				<th class="td_title" style="min-width: 200px;">여행타입</th>
				<th class="td_title" style="min-width: 200px;">여행테마</th>
				<th class="td_title" style="min-width: 200px;">공개여부</th>
				<th class="td_title" style="min-width: 200px;">여행기간</th>
				<th class="td_title" style="min-width: 200px;">자세히보기</th>
			</tr>
			${myPlan}
		</table>
	</div>
</body>
</html>