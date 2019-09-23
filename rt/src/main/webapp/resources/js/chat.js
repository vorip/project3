$(function() {
	$("#contentSubmit").click(function() {
		var data = 
		{
				"content" : $("#content").val(),
				"contentTime" : "systimestamp",
				"chatRoomNum" : $("#chatRoomNum").val(),
				"member" : $("#member").val()
		}
		$.ajax({
			url : "addContent",
			data : data,
			success : function(result) {
				$("#chatDiv").append(result)
			}
		})
	})
	$("#friend").click(function() {
		menuChange_friend();
	})
	$(".rooms").click(function() {
		$(this).each(function() {
			var chatRoomNum = $(this).children('input').val()+"";
			$("#chatRoom"+chatRoomNum).remove();
			$.ajax({
				url : 'eachRoom.do',
				data : {'chatRoomNum' : chatRoomNum},
				success : function(result) {
					$("body").append(result)
					$("#roomContent"+chatRoomNum).scrollTop(8000);
					$(".exit").click(function() {
						$(this).each(function() {
							var num = $(this).val()+"";
							$("#chatRoom"+num).remove()
						})
					})
					$(".textA").keyup(function() {
						$(this).each(function() {
							if($(this).val().trim().length>0){
								$(this).parent().children('button').attr('disabled',false)
							}else{
								$(this).parent().children('button').attr('disabled',true)
							}
						})
					})
					$(".addCon").click(function() {
										$(this).each(function() {
											var content = $("#textA"+$(this).val()).val()
											var chatRoomNum = $(this).val()
											var date = new Date();
											$.ajax({
												url : "addContent",
												data : {
													"content":content,
													"chatRoomNum" : chatRoomNum
														},
												success : function(result) {
													var con_ = result.split("{}");
													alert(con_[0]);
													alert(con_[1]);
													$("#roomContent"+chatRoomNum).append(con_[0])
													$("#textA"+chatRoomNum).val("")
													$("#addCon"+chatRoomNum).attr('disabled','disabled')
													$("#"+chatRoomNum).text(content)
													var time1 = (date.getMonth()+1)+"월"+date.getDate()+"일";
													var time2 = date.getHours()+"시"+date.getMinutes()+"분";
													$("#t1"+chatRoomNum).text(time1)
													$("#t2"+chatRoomNum).text(time2)
													send(con_[1],content,chatRoomNum,time1,time2);
													$("#roomContent"+chatRoomNum).scrollTop(9000);
												}
											})
										})
									})
				}
			})
		})
	})
	$("#chatImg").click(function() {
		$("#plus").remove();
		$.ajax({
			url : "menuChange_chat.do",
			success : function(result) {
				$("#typeName").text("채팅")
				$(".friends").remove()
				$(".rooms").remove()
				$("#menuContent").append(result)
					$(".rooms").click(function() {
						$(this).each(function() {
							var chatRoomNum = $(this).children('input').val()+"";
							$("#chatRoom"+chatRoomNum).remove();
							$.ajax({
								url : 'eachRoom.do',
								data : {'chatRoomNum' : chatRoomNum},
								success : function(result){ 
									$("#roomContent"+chatRoomNum).scrollTop(8000);
									$("body").append(result)
									$(".exit").click(function() {
										$(this).each(function() {
											var num = $(this).val()+"";
											$("#chatRoom"+num).remove()
										})
									})
									$(".textA").keyup(function() {
										$(this).each(function() {
											if($(this).val().trim().length>0){
												$(this).parent().children('button').attr('disabled',false)
											}else{
												$(this).parent().children('button').attr('disabled',true)
											}
										})
									})
									$(".addCon").click(function() {
										$(this).each(function() {
											var content = $("#textA"+$(this).val()).val()
											var chatRoomNum = $(this).val()
											var date = new Date();
											$.ajax({
												url : "addContent",
												data : {
													"content":content,
													"chatRoomNum" : chatRoomNum
														},
												success : function(result) {
													var con_ = result.split("{}");
													$("#roomContent"+chatRoomNum).append(con_[0])
													$("#textA"+chatRoomNum).val("")
													$("#addCon"+chatRoomNum).attr('disabled','disabled')
													$("#"+chatRoomNum).text(content)
													var time1 = (date.getMonth()+1)+"월"+date.getDate()+"일";
													var time2 = date.getHours()+"시"+date.getMinutes()+"분";
													$("#t1"+chatRoomNum).text(time1)
													$("#t2"+chatRoomNum).text(time2)
													send(con_[1],content,chatRoomNum,time1,time2);
													$("#roomContent"+chatRoomNum).scrollTop(9000);
												}
											})
										})
									})
								}
							})
						})
					})
			}
		})
	})
})
function plus() {
	$.ajax({
		url : "addFriend",
		success : function(result) {
			$("body").append(result);
			getMove("addFriend");
			$("#chatDiv").css("pointer-events","none");
		}
	})
}
function searchFriend() {
	var id = $("#friendSearchInput").val();
	$.ajax({
		url : "searchFriend",
		data : {"id" : id},
		success : function(result) {
			$("#friendSearchResult").empty();
			$("#friendSearchResult").append(result);
		}
	})
}
function addChatRoom(title,name,limitMember,startTime,endTime) {
	var members = name;
	$.ajax({
		url : "createRoom",
		data : {
			"members" : members,
			"chatRoomName" : title,
			"startTime" : startTime,
			"limitMember" : limitMember,
			"leader" : members,
			"endTime" : endTime
		},
		success : function() {
			alert("여행계획서를 기반으로 채팅방이 자동으로 생성되었습니다.");
		}
	})
}
function addFriendButton(myName,friendName) {
	$("#addFriendButton").remove();
	$.ajax({
		url : "friendApply",
		data : {"myName" : myName,
				"friendName" : friendName},
		success : function() {
			$("#friendSearchResult").append("<span class = \'addFriendText3\'>친구신청이 완료되었습니다</span>")
		}
	})
}
function add() {
	$("#menuType").append("<img onclick = \'plus()\'id = \'plus\' src = \'resources/img/plus.jpg\'>");
}
function getMove(divId) {
	dragElement(document.getElementById(divId)); 
	function dragElement(elmnt) {  
	  var pos1 = 0, pos2 = 0, pos3 = 0, pos4 = 0; 
	  if (document.getElementById(divId+"1")) { 
	    document.getElementById(divId+"1").onmousedown = dragMouseDown; 
	  } else { 
	    elmnt.onmousedown = dragMouseDown; 
	  } 
	  function dragMouseDown(e) { 
	    e = e || window.event; 
	    e.preventDefault(); 
	    pos3 = e.clientX; 
	    pos4 = e.clientY; 
	    document.onmouseup = closeDragElement; 
	    document.onmousemove = elementDrag; 
	  }  
	  function elementDrag(e) { 
	    e = e || window.event; 
	    e.preventDefault(); 
	    pos1 = pos3 - e.clientX; 
	    pos2 = pos4 - e.clientY; 
	    pos3 = e.clientX; 
	    pos4 = e.clientY; 
	    elmnt.style.top = (elmnt.offsetTop - pos2) + "px"; 
	    elmnt.style.left = (elmnt.offsetLeft - pos1) + "px"; 
	  } 
	  function closeDragElement() { 
	    document.onmouseup = null; 
	    document.onmousemove = null;  
	  }
	}
}
function minimiAddFriend() {
	$("#addFriend").remove();
	$("#chatDiv").css('pointer-events','all');
}
function minimiInfo() {
	$(".friendInfo").remove();
	$("#chatDiv").css('pointer-events','all');
}
function noteList(changeMinimi) {
	$.ajax({
		url : "noteSelectAll",
		success : function(result) {
			$("body").append(result);
			$("#chatDiv").css('pointer-events','none');
			getMove("noteList");
			$("#minimiNoteList").attr("onclick","minimiNoteList"+changeMinimi+"()")
		}
	})
}
function minimiNote() {
	$("#sendNoteDiv").remove();
	if($("#noteList").length>0){
		$("#noteList").css('pointer-events','all');
	}else{
		$("#chatDiv").css('pointer-events','all');
	}
}
function sendNoteDiv(name) {
	$(".friendInfo").remove();
	$("#chatDiv").css('pointer-events','all');
	$.ajax({
		url : "sendNoteDiv",
		data : {"otherName" : name},
		success : function(result) {
			$("body").append(result);
			getMove("sendNoteDiv");
			$("#chatDiv").css('pointer-events','none');
			$("#noteList").css('pointer-events','none')
			$("#sendNote").attr('disabled',true);
			$("#noteContent").keyup(function() {
				if($("#noteContent").val().trim().length>0){
					$("#sendNote").attr('disabled',false);
				}else{
					$("#sendNote").attr('disabled',true);
				}
			})
		}
	})
}
function minimiNoteList() {
	$("#noteList").remove();
	$("#chatDiv").css('pointer-events','all');
}
function minimiNoteList_friend() {
	$("#noteList").remove();
	$("#chatDiv").css('pointer-events','all');
	menuChange_friend();
}
function minimiNoteList_companion() {
	$("#noteList").remove();
	$("#chatDiv").remove();
	getChat();
}
function sendNote() {
	var meName = $("#meName").val();
	var noteContent = $("#noteContent").val();
	$.ajax({
		url : "sendNote",
		data : {"content" : noteContent,
			"me" : meName},
			success : function() {
				alert("쪽지전송이 완료되었습니다.");
				$("#sendNoteDiv").remove();
				$("#chatDiv").css('pointer-events','all');
			}
	})
}
function deleteFriend(name) {
	if(confirm('정말로 삭제하시겠습니까?')){
		$.ajax({
			url : "deleteFriend",
			data : {'name' : name},
			success : function() {
				alert("삭제되었습니다.");
				$(".friends").remove();
				$(".friendInfo").remove();
				$("#chatDiv").css('pointer-events','all');
				menuChange_friend();
			}
		})
	}
}
function deleteNote(noteNum,changeMinimi) {
	$.ajax({
		url : "noteDelete",
		data : {"noteNum" : noteNum.trim()},
		success : function() {
			alert("삭제가 완료되었습니다.")
			$("#noteList").remove();
			noteList(changeMinimi);
		}
	})
}
function acceptFriend(other,me,noteNum) {
	$.ajax({
		url : "acceptFriend",
		data : {"other" : other,
				"me" : me},
		success : function() {
			alert(other+"님의 친구신청을 수락하셨습니다.");
			deleteNote(noteNum,"_friend");
		}
	})
}
function acceptCompanion(otherName,noteNum,chatRoomNum) {
	$.ajax({
		url : "acceptCompanion",
		data : {"otherName" : otherName,
				"chatRoomNum" : chatRoomNum},
		success : function() {
			alert(otherName+"님의 동행신청을 수락하셨습니다.");
			deleteNote(noteNum,"_companion");
		}
	})
}
function rejectFriend(otherName,noteNum) {
	alert(otherName+"님의 친구신청을 거절하셨습니다.");
	deleteNote(noteNum,"_friend");
}
function rejectCompanion(otherName,noteNum) {
	alert(otherName+"님의 동행신청을 거절하셨습니다.");
	deleteNote(noteNum,"_companion");
}
function menuChange_friend() {
	$("#plus").remove();
	$.ajax({
		url : "menuChange_friend.do",
		success : function(result) {
			$("#typeName").text("친구")
			$(".rooms").remove()
			$(".friends").remove()
			$("#menuContent").append(result)
			add();
			$(document).ready(function() {
				$(".friends").click(function() {
					$(this).each(function() {
						var friendName = $(this).children('.roomName').children('.names').text();
						$.ajax({
							url : "friendInfo",
							data : { "friendName" : friendName},
							success : function(result) {
								$("body").append(result);
								getMove("friendInfo");
								$("#chatDiv").css('pointer-events','none');
							}
						})
					})
				})
			})
		}
	})
}