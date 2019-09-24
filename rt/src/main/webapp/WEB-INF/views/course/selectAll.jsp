<%@page import="com.rt.travel.course.dto.TypeADTO"%>
<%@page import="com.rt.travel.course.dto.CourseDTO"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.NEW"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	CourseDTO courseDTO = new CourseDTO();
	TypeADTO typeADTO = new TypeADTO();
	
	if(typeADTO.getId().equals(courseDTO.getId())/*  && typeADTO.getNo().equals(courseDTO.getNo()) */) {
		
	}
%>
	<table border="1">
		<tr>
			<td>작성자</td>
			<td>제목</td>
			<td>기간</td>
			<td>여행타입</td>
			<td>여행테마</td>
			<td>상세내용</td>
		</tr>
		<!-- courseDTO에서 TypeaDTO와 같은 no와 id값을 찾아서, 여행지 개수를 count -->
		<c:forEach var="typeADTO" items="${selectAll_typea}" <%-- var="courseDTO" items="${}" --%>>
			<tr>
				<td>${typeADTO.id}</td>
				<td>${typeADTO.title}</td>
				<td>${typeADTO.day_start}~${typeADTO.day_end}(${typeADTO.travel_day})일간</td>
				<td>${typeADTO.travel_type}</td>
				<td>${typeADTO.travel_theme}</td>
				<td>${typeADTO.travel_intro}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>