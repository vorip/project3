<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모정</title>

<link rel="stylesheet"
   href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
   integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
   crossorigin="anonymous">

<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script>
   var bno = '${dto.bno}'; //게시물 번호

   $('[name=commentInsertBtn]').click(function() { //댓글 등록 버튼 클릭시 
      if (document.getElementById("logOut")) {
         alert("댓글이 등록되었습니다.");
         var insertData = $('[name=commentInsertForm]').serialize(); //commentInsertForm의 내용을 가져옴
         commentInsert(insertData); //Insert 함수호출(아래)
         window.location.reload();
      } else {
         alert("로그인을 해주세요");
         location.href = "loginPage";
      }
   });

   //댓글 등록
   function commentInsert(insertData) {
      $.ajax({
         url : 'Comment_insert.do',
         data : insertData,
         success : function(data) {
         }
      });
   }

   //댓글 수정 - 댓글 내용 출력을 input 폼으로 변경 
   function commentUpdate(cno, content) {
      var a = '';

      a += '<div class="input-group">';
      a += '<input type="text" class="form-control" name="content_'+cno+'" value="'+content+'"/>';
      a += '<span class="input-group-btn"><button class="btn btn-success" type="button" onclick="commentUpdateProc('
            + cno + ');">수정</button> </span>';
      a += '</div>';

      $('.commentContent' + cno).html(a);

   }

   //댓글 수정
   function commentUpdateProc(cno) {
      var updateContent = $('[name=content_' + cno + ']').val();

      $.ajax({
         url : 'Comment_update.do',
         data : {
            'content' : updateContent,
            'cno' : cno
         },
         success : function(data) {
            alert("댓글이 수정되었습니다.");
            window.location.reload();
         }
      });
   }

   //댓글 삭제
   function commentDelete(cno) {
      var a = '';
      a += '<input type="hidden" class="form-control" name="content_'+cno+'" value="'+cno+'"/>';
      $('.commentContent' + cno).html(a);

   }

   //댓글 삭제 
   function commentDelete(cno) {
      var deleteContent = $('[name=content_' + cno + ']').val();

      $.ajax({
         url : 'Comment_delete.do',
         data : {
            'cno' : cno
         },
         success : function(data) {
            alert("댓글이 삭제되었습니다.");
            window.location.reload(); //댓글 삭제후 목록 출력 
         }
      });
   }
</script>
</html>