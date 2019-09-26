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
   <title>여행일정 리스트</title>
   <!-- CSS STYLE -->
   <link rel="stylesheet" href="resources/assets/css/reset.css">
   <link rel="stylesheet" href="resources/assets/css/style.css">
   <link rel="stylesheet" href="resources/assets/css/weather.css">
   
   <!-- 웹 폰트 -->
   <link href="https://fonts.googleapis.com/css?family=Black+Han+Sans|Orbitron&display=swap" rel="stylesheet">
   <link href="https://fonts.googleapis.com/css?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
   
   <style type="text/css">
      .list_table {
         padding-top: 70px;
         padding-bottom: 70px;
         padding-left: 400px;
      }
      
      .list_topBanner {
         background-color: pink;
         height: 200px;
      }
   </style>
</head>
<body>

<!-- 상단메뉴 -->
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
               <div>
                  <h3 class="font_color">마이페이지</h3>
                  <ul>
                     <li><a class="menu_nav" href="#">나의 여행일정</a></li>
                     <li><a class="menu_nav" href="#">나의 동행찾기 수정</a></li>
                     <li><a class="menu_nav" href="my">회원정보보기</a></li>
                  </ul>
               </div>
            </div>
         </div>
      </div>
      
   <!-- 상단 스타일 배너 -->
   <div class="list_topBanner">
      <h2 style="text-align: center; padding-top: 80px;">여행 리스트</h2>
   </div>
   
   <!-- 리스트 테이블 -->
   <div class="list_table">   
   <table border="1">
      <tr style="text-align: center;">
         <td>작성자</td>
         <td>제목</td>
         <td>기간</td>
         <td>여행타입</td>
         <td>여행테마</td>
         <td>상세내용</td>
         <td>:></td>
      </tr>
      <!-- courseDTO에서 TypeaDTO와 같은 no와 id값을 찾아서, 여행지 개수를 count -->
      <c:forEach var="typeADTO" items="${selectAll}">
         <tr style="text-align: center;">
            <td style="width: 100px;">
            <span id="id">${typeADTO.id}</span>
            </td>
            <td style="width: 100px;">${typeADTO.title}</td>
            <td style="width: 300px;">${typeADTO.day_start}~${typeADTO.day_end}   (${typeADTO.travel_day})일간
               <input id="day" type="hidden" value="${typeADTO.travel_day}">
            </td>
            <td style="width: 100px;">${typeADTO.travel_type}</td>
            <td style="width: 100px;">${typeADTO.travel_theme}</td>
            <td style="width: 300px;">${typeADTO.travel_intro}</td>
            <td style="width: 80px;"><button class="map_btn" value = "${typeADTO.no}">자세히보기</button></td>
            
         </tr>
      </c:forEach>
   </table>
   </div>
   
   <script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
   <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=afbdd676e0cb9858d78365c02cbc33b7&libraries=services"></script>
   <script>
      // 자세히보기를 누르면 id랑 no 가지고 넘기기,,?
      $(function() {
         $(".map_btn").click(function() {
            var no = $(this).val();
            
             location.href = "showindex.do?no="+no;
         })
      }); 
   </script>
   
   <!-- footer -->
   <div id="footer">
      <div class="container"></div>
   </div>
   
</body>
</html>