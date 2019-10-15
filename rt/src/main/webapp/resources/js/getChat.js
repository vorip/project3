function getChat() {
   $("#getChat").remove();
   $.ajax({
      url : "getChat",
      success : function(result) {
         if (document.getElementById("logOut")) {
            $("body").append(result);
            $("#minimiChat").click(function() {
               $("#chatDiv").remove();
               $(".chatRoom").remove();
               $.ajax({
                  url : "chatClose",
                  success : function(result) {
                     $("body").append(result);
                     ws.close();
                  }
               })
            });
         } else {
            alert("로그인이 필요합니다.");
            $("body").append("<img id='getChat'onclick = \"getChat();\" src = \"resources/img/logo.png\">");
         }
      }
   });
}
var ws;
var messages;
function openSocket() {
   if (ws !== undefined && ws.readyState !== WebSocket.CLOSED) {
      return;
   }
   // 웹소켓 객체 만드는 코드(http일떄 ws https일때 wss)
   var path = window.location.host + "/"
         + window.location.pathname.trim().split('/')[1] + "/websocket";
   if (window.location.protocol.trim() == "http:") {
      ws = new WebSocket("ws://" + path);
   } else {
      ws = new WebSocket("wss://" + path);
   }
   ws.onopen = function(event) {
   };
   ws.onmessage = function(event) {
      writeResponse(event.data);
   };
   ws.onclose = function(event) {
   }
}
function send(name, content, chatRoomNum, time1, time2) {
   ws.send(name + "{}" + content + '{}' + chatRoomNum + '{}' + time1 + '{}'
         + time2);
}
function writeResponse(text) {
   text1 = text.split("{}");
   $.ajax({
      url : "writeResponse",
      data : {
         "name" : text1[0],
         "content" : text1[1],
         "time2" : text1[4]
      },
      success : function(result) {
         $("#roomContent" + text1[2]).append(result);
         $("#roomContent" + text1[2]).scrollTop(9999);
      }
   })
   $("#" + text1[2]).text(text1[1]);
   $("#t1" + text1[2]).text(text1[3]);
   $("#t2" + text1[2]).text(text1[4]);
}
function socketClose() {
   ws.close();
}
function roomNumsSetting(roomNums) {
   $.ajax({
      url : "roomNumsSetting",
      data : {
         "roomNums" : roomNums
      },
      success : function() {
         openSocket();
      }
   });
}