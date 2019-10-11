<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/myPageStyle.css">
<link rel="stylesheet" href="resources/css/chat.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/myPage.js"></script>
${publicHead}
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
//우편번호 api
function sample4_execDaumPostcode() {
   new daum.Postcode({
      oncomplete: function(data) {
          var roadAddr = data.roadAddress; // 도로명 주소 변수
             var extraRoadAddr = ''; // 참고 항목 변수

             // 법정동명이 있을 경우 추가한다. (법정리는 제외)
             // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
             if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                 extraRoadAddr += data.bname;
             }
             // 건물명이 있고, 공동주택일 경우 추가한다.
             if(data.buildingName !== '' && data.apartment === 'Y'){
                extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
             }
             // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
             if(extraRoadAddr !== ''){
                 extraRoadAddr = ' (' + extraRoadAddr + ')';
             }

             // 우편번호와 주소 정보를 해당 필드에 넣는다.
             document.getElementById('sample4_postcode').value = data.zonecode;
             document.getElementById("sample4_roadAddress").value = roadAddr;
             document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
             
             // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
             if(roadAddr !== ''){
                 document.getElementById("sample4_extraAddress").value = extraRoadAddr;
             } else {
                 document.getElementById("sample4_extraAddress").value = '';
             }

             var guideTextBox = document.getElementById("guide");
             // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
             if(data.autoRoadAddress) {
                 var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                 guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                 guideTextBox.style.display = 'block';

             } else if(data.autoJibunAddress) {
                 var expJibunAddr = data.autoJibunAddress;
                 guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                 guideTextBox.style.display = 'block';
             } else {
                 guideTextBox.innerHTML = '';
                 guideTextBox.style.display = 'none';
             }
         }
   }).open();
  }
var fileValue = $("#fileChange").val().split("\\");
var fileName = fileValue[fileValue.length-1]; // 파일명

</script>
</head>
<body>
<img id='getChat'onclick = "getChat();" src = "resources/img/logo.png">
${publicBody}
<div id="my" class="filewrap" align="center">
   <h2>회원정보수정</h2>
   <p>회원정보를 수정하실 수 있습니다.</p>
   <form name="form1">
   <table class="myTable" >
      <tr>
         <td width="180" class="td_title">아이디</td>
         <td>${dto.id}</td>
      </tr>
      <tr>
         <td width="180" class="td_title">이름</td>
         <td>${dto.name}
         <input type="hidden" name="pw" value="${dto.pw}" id="pw"></td>
      </tr>
      <tr>
         <td width="180" class="td_title">전화번호</td>
         <td><input type="text" name="tel" id="tel" value="${dto.tel}"></td>
      </tr>
      <tr>
         <td width="180" class="td_title">이메일</td>
         <td><input type="text" name="email" id="email" value="${dto.email}"></td>
      </tr>
      <tr>
         <td width="180" class="td_title">생년월일</td>
         <td><input type="text" name="birth" id="birth" value="${dto.birth}"></td>
      </tr>
      <tr>
         <td width="180" class="td_title" rowspan="3">주소</td>
         <td class="td_title"><input type="text" style="width: 250px"  value="${dto.roadaddr}"></td>
      </tr>
      <tr>
         <td class="td_title"><input type="text" id="sample4_postcode" name="addr1" value="${addr}" placeholder="우편번호" class="signInput">
         <input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기" class="singButton"></td>
      </tr>
      <tr>
         <td><input type="text" id="sample4_roadAddress" name="addr2" value="${addr1}" placeholder="도로명주소" class="signInput">
      <input type="text" id="sample4_jibunAddress" name="addr3" placeholder="지번주소" value="${addr2}" class="signInput">
      <span id="guide" style="color:#999;display:none"></span>
      <input type="text" id="sample4_detailAddress" name="addr4" placeholder="상세주소" value="${addr3}" class="signInput">
      <input type="text" id="sample4_extraAddress" placeholder="참고항목" class="signInput"></td>
      </tr>
      <tr>
         <td width="180" class="td_title" rowspan="2">관심분야</td>
         <td><input type="text" name="travel_theme" id="travel_theme" value="${dto.travel_theme}"></td>
      </tr>
      <tr>
      	<td>
      		<fieldset>
                  <input type="radio" name="travel_theme2" value="역사"> <label style="display: inline-block;">역사</label> 
                  <input type="radio" name="travel_theme2" value="체험"> <label style="display: inline-block;">체험</label> 
                  <input type="radio" name="travel_theme2" value="자연"> <label style="display: inline-block;">자연</label>
                  <input type="radio" name="travel_theme2" value="휴양"> <label style="display: inline-block;">휴양</label> 
                  <input type="radio" name="travel_theme2" value="산업"> <label style="display: inline-block;">산업</label> 
                  <input type="radio" name="travel_theme2" value="조형물"> <label style="display: inline-block;">조형물</label>
               </fieldset>
      	</td>
      </tr>
      <tr>
         <td width="180" class="td_title">사진</td>
         <td><img id="img" src="resources/img/${dto.thumb}"></td>
      </tr>
      <tr>
         <td width="180" class="td_title">탈퇴</td>
         <td><input type="button" value="탈퇴하기" class="purebtn button-small" id="delete" ></td>
      </tr>
      
   </table>
   <input type="button" class="purebtn" id="update" value="수정하기" >
   </form>
   <form action='main.do'>
   		<button type = 'submit' class ='purebtn'>메인으로</button>
   </form>
</div>
</body>
</html>