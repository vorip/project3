<%@page import="java.util.ArrayList"%>
<%@page import="com.rt.travel.course.dto.CourseDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<%int i = 0;%>
	<%ArrayList<String> url = new ArrayList<String>(); %>
	<c:forEach var="courseDTO" items="${select_list}">
		<%
			CourseDTO test = (CourseDTO)pageContext.getAttribute("courseDTO") ;
			url.add(i, test.getPlace_name());
			i++;
		%>
	</c:forEach>
	
	
	<%i = 1;%>
	<c:forEach var="courseDTO" items="${select_list}">
	
		<%
		if(i>1){
		%>
			<div class = "road_search" id = "road_search_<%=i-1%>" >
				<div style = "height:20px; width : 99%; background: #C0FFFF; text-align: center;">
					<a href="https://map.kakao.com/?eName=<%=url.get(i-1)%>&sName=<%=url.get(i-2)%>" id="road_url" target="_blank">↕길찾기↕</a>
				</div>
			</div>
		<%
			}
		%>
		
			<div class="roadrow">
				<div style="height: 200px; width: 99%; border: 1px solid ;position:relative; font-size: 15px; "id ='road_place_<%=i%>'>
				<%=i+"> "%><span id =side_place_name>${courseDTO.place_name}</span><br>
				기본 주소<br>
				${courseDTO.place_address_name}<br>
				도로명 주소<br>
				${courseDTO.place_road_address_name}<br>
				TEL : ${courseDTO.place_phone}<br>
				<a href="${courseDTO.place_url}">웹 브라우저로 보기</a><br>
			      <button id="open_memo" class="open_memo" onclick = "memo_open(${courseDTO.memo_index})" style="position:absolute; bottom:0px; left:0px">메모추가</button>
			      <button id="place_move" style="position:absolute; bottom:0px; left:81px;" onclick='panTo(${courseDTO.place_y},${courseDTO.place_x})'>위치보기</button>
			      <button id="place_delete" style="position:absolute; bottom:0px; right:0px;" onclick='customoverlay_delete(<%=i %>,${courseDTO.memo_index})'>위치삭제</button>
			      <input type = "hidden" id = "memo_val">
			      <input type = "hidden" id = "place_x" value = '${courseDTO.place_x}'>
			      <input type = "hidden" id = "place_y" value ='${courseDTO.place_y}'>
				</div>
			</div>
			<%i++;%>
	</c:forEach>
	<input type ="hidden" id = select_delete_index value= "<%=i-1%>">
	</body>
</html>
