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

	<link rel="stylesheet" href="resources/assets/css/Boardreset.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	
	<script>
		$(document).ready(function () {
			$('#btnWrite').click(function () {
				location.href= "${path}/Board/write.do";
			});
		});
		function board_search() {
			$.ajax({
				url : 'board_search.do',
				data : {"searchWord" : $("#searchWord").val(),
						"searchType" : $("#searchType").val()},
				success : function(result) {
					var result_ = result.split("<>");
					$("#board_list").empty()
					$("#board_list").append(result_[0])
					$("#board_page").empty()
					$("#board_page").append(result_[1])
				}
			});
		}
	</script>
${publicHead}
</head>

<body>
${publicBody}			
			<div>
				<div class = "cont_Board_header">
					<div class="container">
						<div class="cont_1">
							<div class="column col_board">
								<h3><span class="ico_img ir_pm">아이콘</span><span class="ico_tit">Notice</span></h3>
							</div>
						</div>
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
									        <th scope="co_1">제목</th>
									        <th scope="co_2">닉네임</th>
									        <th scope="co_3">조회수</th>
									        <th scope="co_4">작성날짜</th>
									    </tr>
									    </thead>
									    <tbody id="board_list">
									    <c:forEach var="row" items="${list}">
										    <tr>
										        <th scope="row">${row.bno}</th>
										        <td><a href="${path}view.do?bno=${row.bno}">${row.title}</a></td>
										        <td>${row.writer}</td>
										        <td>${row.viewcnt}</td>
										        <td><fmt:formatDate value="${row.regdate}" pattern="yyyy-MM-dd HH:mm"/></td>
										    </tr>
									    </c:forEach>
									    </tbody>
									</table>
						<div id="board_page" style="overflow: auto; width: 100%; margin: 0 50%; padding: 0 0 1% 0;">
							${BoardPage}
						</div>
						<div class="button_position">
								<a href="write.do"><button type="button" class="btn btn-primary" id="btnWrite">글쓰기</button></a>
						</div>
						<div class="search_position">
							<select name="searchType" id="searchType">
								<option value="title" selected="selected">제목</option>
								<option value="content">내용</option>
								<option value="writer">작성자</option>
							</select>
							&nbsp;&nbsp;<input type="text" name="searchWord" id="searchWord">
							<button type="button" onclick="board_search()"class="btn btn-success">검색</button>
						</div>
					</div>
				</div>
			<!-- cont_nav -->
			
			</div>
			<!-- content -->
					${publicfooter}
			<!-- footer -->
		
	</div>
	<!-- wrap -->
</body>
</html>