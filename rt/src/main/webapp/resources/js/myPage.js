$(document).ready(function() {
	$("#update").click(function() {
		alert("수정이 완료되었습니다!!")
		document.form1.action = "updateAll";
		document.form1.submit();
	})
	
	$("#delete").click(function() {
		var pw2 = $("#pw").val();
		var pwCheck = prompt("비밀번호를 입력하세요.");
		if(pwCheck == pw2){
			alert("탈퇴가 완료되었습니다!")
			document.form1.action = "delete";
			document.form1.submit();
		}else{
			alert("비밀번호가 틀렸어요!!");
			return false;
		}
	})
	
//	$("input[type=file]").change(function () {
//        
//        var fileListView = "";
//         
//        var formData = new FormData(); //ajax로 넘길 data
//         
//        var fileInput = document.getElementById("fileChange"); //id로 파일 태그를 호출
//         
//        var files = fileInput.files; //업로드한 파일들의 정보를 넣는다.
//         
//        for (var i = 0; i < files.length; i++) {
//            formData.append('file-'+i, files[i]); //업로드한 파일을 하나하나 읽어서 FormData 안에 넣는다.
//        }
//         
//        $.ajax({
//            url: "/test/fileSave",
//            data: formData,
//            processData: false,
//            contentType: false,
//            type: 'POST',
//            success: function(data){
//                 
//                if(data.code == "OK"){ //응답결과
//                     
//                    fileInfoList = data.fileInfoList; //응답 결과 데이터 fileInfoList
//                    $.each(fileInfoList, function( index, fileInfo ) {
//                         
//                        console.log("Path: "+fileInfo.fileFullPath); //전체경로
//                        console.log("FileName: "+fileInfo.originalFilename); //파일명
//                                                 
//                        fileListView += "<p>"+fileInfo.originalFilename+"</p>"; //루프를 돌려서 화면에 보여줄 리스트 작성
//                         
//                    });
//                     
//                    $("#file_view_list").html(fileListView); //리스트를 화면에 보여줌
//                     
//                }else{
//                    alert("파일 등록에 실패하였습니다.");
//                }
//                 
//            },
//            error: function(xhr,textStatus,error){
//                                     
//                console.log("textStatus: "+xhr.status+", error: "+error);
//                alert("예상치 못한 오류가 발생했습니다.");
//                 
//            }
//        });
//
//         
//    });
	var fileTarget = $('.filewrap #fileChange');



	fileTarget.on('change', function(){ // 값이 변경되면

	if(window.FileReader){ // modern browser

	var filename = $(this)[0].files[0].name;

	 }

	else { // old IE

	 var filename = $(this).val().split('/').pop().split('\\').pop(); // 파일명만 추출

	}  // 추출한 파일명 삽입

	$(this).siblings('#thumb').val(filename);

	});

})



