<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모정</title> 
<!-- ckeditor 포함 -->
<script src="resources/ckeditor/ckeditor.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- 글쓰기 기능 -->
<script type="text/javascript">
   $(document).ready(function () {
      $("#btnSave").click(function () {
         var title = $("#title").val().trim();
         /* CKEDITOR가 적용된 textarea의 값을 가져오는 메소드 */
         var content = CKEDITOR.instances.p_content.getData();
         if(title == ""){
            alert("제목을 입력하세요");
            document.form1.title.focus();
            return false;
         }else if(content == ""){
            alert("내용을 입력하세요");
            document.form1.content.focus();
            return false;
         }
         alert("글이 등록되었습니다.");
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
      <div>
         <div id="cont_Board_header">
            <div class="container">내용 미정</div>
         </div>
      </div>

      <div id="content">
         <div id="cont_nav_bo">
            <div class="container">
               <div class="notice">
                  <h4>여행후기 게시판</h4>
                  <form method="get" action="insert.do" id="form1" name="form1">
                     <table class="type_01" border="2" style="width: 100%;">
                        <thead>
                           <tr>
                              <th scope="co_0" colspan="2" style="width: 100%;">게시판 글쓰기 양식</th>
                           </tr>
                        </thead>
                        <tbody>
                           <tr>
                              <td><input type="text"
                                 placeholder="글 제목" name="title" id='title' maxlength="50" style="width: 100%;  height:30px;"></td>
                           </tr>
                           <tr>
                              <td><textarea
                                 placeholder="글 내용" name="content" id="p_content" class="content" maxlength="4000" rows=14 style="width: 100%;"></textarea></td>
                           </tr>
                        </tbody>
                     </table>
                           <script>
                              CKEDITOR.replace("p_content", {height: "450px"
                                 });
                           </script>
                     <div>
                        <input type="button" class="btn btn-primary button_position" id="btnSave"
                           value="등록">
                     </div>
                  </form>
               </div>
            </div>
         </div>
         <!-- cont_nav -->

      </div>
      <!-- content -->
${publicfooter }

   </div>
   <!-- wrap -->
</body>
</html>