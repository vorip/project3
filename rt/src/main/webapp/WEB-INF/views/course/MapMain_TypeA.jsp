<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<!-- <script type="text/javascript" src="resources/js/MapMain.js"></script> -->
	<script type = "text/javascript">
	
	window.onload = function() {
	    document.getElementById('next_btn').onclick = function() {
	    	
	        var title = $("#title").val();
		      var date = $("#travel_day").val();
		      var date_start = $("#datepicker").val();
		      
		      if(title=="" || date=="" || date_start==""){
		         alert("필수항목을 입력해주세요");
		         return false;
		      }
		      else{
		    	  alert("실행됨");
	        	  document.getElementById('index_submit').submit();
		    	  return true;
		      }
	    };
	};

	</script>
</head>
<body>
<%String id = (String)session.getAttribute("id");%>
	<!-- 타이틀 -->
	<div class="main_title">
		<h1>여행 만들기</h1>
		<h3>여행 기본정보 입력</h3>
	</div>  
	
<form action="index.do" id = "index_submit">
	<!-- 타입 이동 버튼 -->
	<div class="type_button">
		<div onClick="location.href='MapMain_TypeA.jsp'" class="typeA_button">자세한 계획</div>
		<div onClick="location.href='MapMain_TypeB.jsp'" class="typeB_button">대략적인 계획</div>
	</div>
	
	<!-- 양식 테이블 -->
	<div class="main_table">
		<table class="typeA_table">
				<input type="hidden" id="id" name="id" value="<%=id%>">
			<tr>
				<td>제목<sup style="color: red">*필수</sup></td>
				<td><input type="text" id="title" name="title"></td>
			</tr>
			<tr>
				<td>여행기간<sup style="color: red">*필수</sup></td>
				<td>
					<input type="text" id="travel_day" name="travel_day" style="width: 30px;">일
				</td>
			</tr>
			<tr>
				<td>출발일<sup style="color: red">*필수</sup></td>
				<td>
				 <p><input type="date" id="datepicker" name="day_start"/></p>
				</td>
			</tr>
			<tr>
				<td>여행구분</td>
				<td><select name="travel_type">
						<option value="">선택</option>
						<option value="솔로여행">솔로여행</option>
						<option value="커플여행">커플여행</option>
						<option value="가족여행">가족여행</option>
						<option value="우정여행">우정여행</option> 
						<option value="동호회여행">동호회여행</option>
						<option value="비즈니스여행">비즈니스여행</option>

				</select></td>
			</tr>
			<tr>
				<td>여행테마</td>
				<td>
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
				<td>동행인원</td>
				<td>
					<select name="max_mem">
						<option value="">선택</option>
						<option value="01">01</option>
						<option value="02">02</option>
						<option value="03">03</option>
						<option value="04">04</option>
						<option value="05">05</option>
						<option value="06">06</option>
						<option value="07">07</option>
						<option value="08">08</option>
						<option value="09">09</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
					</select>명
				</td>
			</tr>
			<tr>
				<td>공개설정</td>
				<td>
					<fieldset>
						<input type="radio" name="choice_public" value="공개미완" checked><label>공개</label>
						<input type="radio" name="choice_public" value="비공개미완"><label>비공개</label>
					</fieldset>
					<div style="font-size: 12px; color:grey;">* 공개로 설정하면 다른 사람들이 여행지를 검색할 수 있습니다:></div>
				</td>
			</tr>
			<tr>
				<td>간단한 여행소개</td>
				<td><input type="text" id="travel_intro" name="travel_intro"></td>
			</tr>
		</table>
	</div>
	<input type="hidden" value="1" name="current_mem" id="current_mem">
	<div>
		<button type="submit" id = "next_btn">다음</button>
	</div>
	</form>

	<style type="text/css">
	
body {
	width: 100%;
	line-height: 1.6em;
	font-size: 16px;
}

.typeA_button {
	text-align: center; 
	padding: 1em; 
	border:1px solid #7f8c8d;
	width: 100px;
}

.typeB_button {
	text-align: center; 
	padding: 1em; 
	border:1px solid #7f8c8d;	
}

sub {
	top: -0.5em;
	font-size: 75%;
	line-height: 0;
	position: relative;
	vertical-align: baseline;
	vertical-align: super;
	font-size: smaller;
}

.main_table {
	display: table-row-group;
	vertical-align: middle;
	border-color: inherit;
}

tr {
	display: table-row;
	vertical-align: inherit;
	border-color: inherit;
}

input {
	padding: 0.5em 0.6em;
	display: inline-block;
	border: 1px solid #ccc;
	box-shadow: inset 0 1px 3px #ddd;
	border-radius: 4px;
	vertical-align: middle;
	box-sizing: border-box;
	line-height: normal;
	-webkit-writing-mode: horizontal-tb !important;
	text-rendering: auto;
	letter-spacing: normal;
	word-spacing: normal;
	text-transform: none;
	text-indent: 0px;
	text-shadow: none;
	-webkit-rtl-ordering: logical;
	cursor: text;
	text-align: start;
}

.type_button {
	display: flex;
}

.typeA_table {
	border-collapse: collapse;
	border-spacing: 0;
	-webkit-border-horizontal-spacing: 0px;
	-webkit-border-vertical-spacing: 0px;
	empty-cells: show;
	border: 1px solid #cbcbcb;
	border-top-color: rgb(203, 203, 203);
	border-top-style: solid;
	border-top-width: 1px;
	border-right-color: rgb(203, 203, 203);
	border-right-style: solid;
	border-right-width: 1px;
	border-bottom-color: rgb(203, 203, 203);
	border-bottom-style: solid;
	border-bottom-width: 1px;
	border-left-color: rgb(203, 203, 203);
	border-left-style: solid;
	border-left-width: 1px;
	border-image-source: initial;
	border-image-slice: initial;
	border-image-width: initial;
	border-image-outset: initial;
	border-image-repeat: initial;
}

.typeA_table td {
	padding: 0.5em 1em;
}

table {
	border-collapse: separate;
	border-spacing: 2px;
	-webkit-border-horizontal-spacing: 2px;
	-webkit-border-vertical-spacing: 2px;
}
</style>
</body>
</html>
