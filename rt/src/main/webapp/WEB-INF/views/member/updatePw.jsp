<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/memberStyle.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/member.js"></script>
</head>
<body>
<form action="updatePw2">
<div id="updatePw">
<input type="hidden" value="${id}" name="id" class="changeId">
변경할 비밀번호 : <input type="text" name="pw" id="pw" class="changeId"><br>
<input type="submit" value="변경하기" id="change">
</div>
</form>
</body>
</html>