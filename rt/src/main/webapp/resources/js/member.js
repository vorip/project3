//아이디 중복체크
$(function() {
	
	$("#checkId").click(function() {
		var id = $("#id").val();
		$.ajax({
			url: "selectId",
			data : {"id":id},
			success : function(result) {
				if(result.trim()=="중복됨"){
					alert("중복됐어요!!")
				}else{
					alert("사용가능!!")
					$("#sign").prop("disabled",false)
				}
			}
		})
	})
//비밀번호 유효성 검사
	$("#sign").click(function() {
		var pw = $("#pw").val();
		var name = $("#name").val();
		var tel = $("#tel").val();
		var email = $("#email").val();
		var birth = $("#birth").val();
		var addr = $("#sample4_postcode").val();
		//최소 8자리 숫자,문자 특수문자 각각 1개 이상 포함
		if(pw.search("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z0-9$@$!%*#?&]{8,}$")){
			alert("최소 8자리 숫자,문자 특수문자 각각 1개 이상 포함해주세요.");
			return false;
		//공백 없이 
		}else if(id.trim()=="" || pw.trim()=="" || name.trim()=="" || tel.trim()=="" || email.trim()=="" || birth.trim()=="" || addr.trim()==""){
			alert("공백없이 작성해주세요!!")
			return false;
		}else{
			alert("가입완료!!");
		}
	})
	//비밀번호 변경할때 유효성 검사
	$("#change").click(function() {
		var pw = $("#pw").val();
		if(pw.search("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z0-9$@$!%*#?&]{8,}$")){
			alert("최소 8자리 숫자,문자 특수문자 각각 1개 이상 포함해주세요.");
			return false;
		}else{
			alert("변경완료! 로그인페이지로 이동합니다!");
		}
	})
})



