<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모정</title>
<!-- ckeditor 포함 -->
<script src="resources/ckeditor/ckeditor.js"></script>
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
   $(document).ready(function() {
      $("#btnDelete").click(function() {
         if (confirm("삭제하시겠습니까?")) {
            document.form1.action = "Board_delete.do"
            document.form1.submit();
         }
      });

      $('#btnUpdate').click(function() {
         var title = $("#title").val().trim();
         var content = CKEDITOR.instances.p_content.getData();
         if(title == ""){
            alert("제목을 입력하세요");
            document.form1.title.focus();
            return false;
         }else if(content == ""){
            alert("내용을 입력하세요")
            document.form1.content.focus();
            return false;
         }
         document.form1.action = "Board_update.do"
         //폼에 입력한 데이터를 서버로 전송
         document.form1.submit();
      });
   });
</script>

<!-- CSS STYLE -->
<link rel="stylesheet" href="resources/assets/css/Boardreset.css">
<link rel="stylesheet"
   href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
   integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
   crossorigin="anonymous">

${publicHead}

</head>

<body>
   ${publicBody}
      <!-- header -->

      <div>
         <div id="cont_Board_header">
            <div class="container">내용 미정</div>
         </div>
      </div>

      <div id="content">
         <div id="cont_nav">
            <div class="container">
               <div class="notice">
                  <h4>게시글 상세보기</h4>
                  <form method="post" name="form1">
                     <table class="type_01" border="2" style="width: 100%;">
                        <thead>
                           <tr>
                              <th scope="co_0" colspan="2" style="width: 100%;"><input
                                 type="text" name="title" id="title" style="width: 100%;"
                                 value="${dto.title }"></th>
                           </tr>
                           <tr>
                              ${dto.writer}
                              <span class="bar2">&nbsp;|&nbsp;</span>
                              <span class="p11">&nbsp;조회 ${dto.viewcnt}&nbsp;</span>
                              <span class="bar2">&nbsp;|&nbsp;</span>
                              <span class="p11"><fmt:formatDate
                                    value="${dto.regdate }" pattern="yyyy-MM-dd a HH:mm" /></span>
                           </tr>
                        </thead>
                        <tbody>
                           <tr>
                              <td><textarea name="content" id="p_content" rows=14
                                    style="width: 100%;">${dto.content }</textarea></td>
                           </tr>
                        </tbody>
                     </table>
                     <script>
                        CKEDITOR.replace("p_content", {
                           height : "450px"
                        });
                     </script>
                     <div style="width: 100%; text-align: center;">
                        <!--  -->
                        <input type="hidden" name="bno" value="${dto.bno}">
                        <button type="button" class="btn btn-success" id="btnUpdate">수정</button>
                        <button type="button" class="btn btn-danger" id="btnDelete">삭제</button>
                     </div>
                  </form>
                  <label for="content">comment</label>
                  <form name="commentInsertForm">
                     <div class="input-group">
                        <input type="hidden" name="cno" value="1" /> 
                        <input type="hidden" name="bno" value="${dto.bno}" /> 
                        <input type="hidden" name="writer" value="aaaaa" /> 
                        <input type="text" class="form-control" id="content" name="content"
                           placeholder="내용을 입력하세요."> <span class="input-group-btn">
                           <button class="btn btn-primary button_position" type="button"
                              name="commentInsertBtn">등록</button>
                        </span>
                     </div>
                  </form>
                  <div class="commentList"></div>
                  <c:forEach var="commentlist" items="${commentlist}">
                     <div class="commentArea" style="border-bottom:1px solid darkgray; margin-bottom: 15px;">
                     <div class="commentInfo${commentlist.cno }">댓글번호 : ${commentlist.cno} / 작성자 : ${commentlist.writer} / 
                        <a onclick="commentUpdate('${commentlist.cno}', '${commentlist.content}')"> 수정 </a>
                        <a onclick="commentDelete(${commentlist.cno})"> 삭제 </a>
                     </div>
                        <div class="commentContent${commentlist.cno}"> <p> 내용 : ${commentlist.content}</p></div>
                     </div>
                  </c:forEach>
                  <%@ include file="Board_comment.jsp" %>
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