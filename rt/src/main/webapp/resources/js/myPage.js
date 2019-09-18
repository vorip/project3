$(document).ready(function() {
	$("#update").click(function() {
		document.form1.action = "updateAll";
		document.form1.submit();
	})
	
	$("#delete").click(function() {
		var pw2 = $("#pw").val();
		var pwCheck = prompt("비밀번호를 입력하세요.");
		if(pwCheck == pw2){
			document.form1.action = "delete";
			document.form1.submit();
		}else{
			alert("비밀번호가 틀렸어요!!");
			return false;
		}
	})
})


