<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/memberStyle.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
</script>
<script type="text/javascript" src="resources/js/member.js"></script>
</head>
<body>
<h2 class="title">회원가입</h2>
<form action="insert" id="signForm">
<table class="signTable">
	<tr>
   		 <td class="signTd">아이디 : <input type="text" id="id" name="id" class="signInput"><input type="button" id="checkId" value="중복확인" class="singButton"><br></td>
	</tr>
	<tr>
		<td class="signTd">비밀번호 : <input type="text" id="pw" name="pw" class="signInput"><br></td>
	</tr>
	<tr>
		<td class="signTd">이름 : <input type="text" id="name" name="name" class="signInput"><br></td>
	</tr>
	<tr>
		<td class="signTd">전화번호 : <input type="text" id="tel" name="tel" class="signInput"><br></td>
	</tr>
	<tr>
		<td class="signTd">이메일 : <input type="text" id="email" name="email" class="signInput"><br></td>
	</tr>
	<tr>
		<td class="signTd">생년월일 : <input type="text" id="birth" name="birth" class="signInput"><br></td>
	</tr>
	<tr>
		<td class="signTd"><input type="text" id="sample4_postcode" name="addr1" placeholder="우편번호" class="signInput">
	<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기" class="singButton"><br></td>
	</tr>
	<tr>
		<td class="signTd"><input type="text" id="sample4_roadAddress" name="addr2" placeholder="도로명주소" class="signInput">
		<input type="text" id="sample4_jibunAddress" name="addr3" placeholder="지번주소" class="signInput">
		<span id="guide" style="color:#999;display:none"></span>
		<input type="text" id="sample4_detailAddress" name="addr4" placeholder="상세주소" class="signInput">
		<input type="text" id="sample4_extraAddress" placeholder="참고항목" class="signInput"></td>
	</tr>
	<tr>
		<td>
		관심분야 :
			<fieldset>
                  <input type="radio" name="travel_theme" value="역사"> <label style="display: inline-block;">역사</label> 
                  <input type="radio" name="travel_theme" value="체험"> <label style="display: inline-block;">체험</label> 
                  <input type="radio" name="travel_theme" value="자연"> <label style="display: inline-block;">자연</label>
                  <input type="radio" name="travel_theme" value="휴양"> <label style="display: inline-block;">휴양</label> 
                  <input type="radio" name="travel_theme" value="산업"> <label style="display: inline-block;">산업</label> 
                  <input type="radio" name="travel_theme" value="조형물"> <label style="display: inline-block;">조형물</label>
               </fieldset>
		</td>
	</tr>
	<tr>
		<td class="signTd"><input type="submit" id="sign" value="회원가입" disabled="disabled" class="singButton"></td>
	</tr>
</table>
</form>
</body>
</html>