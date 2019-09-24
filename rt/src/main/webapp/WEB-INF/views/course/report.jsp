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
   작성자 >> ${courseDTO.id}
   <table border="1">
      <tr>
         <td>일차</td>
         <td>장소</td>
      </tr>
      <c:forEach var="courseDTO" items="${select_report}">
      <tr>
         <td><h3>${courseDTO.day}</h3></td>
         <td>${courseDTO.place_name}</td>
      </tr>
      </c:forEach>
   </table>
      <a href="main.jsp"><button>홈으로</button></a>
   </body>
</html>