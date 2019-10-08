<%@page import="com.rt.travel.course.dto.TypeADTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<html>
<head>
    <meta charset="utf-8">
    <title>**ROMANTIC TRAVEL**</title>
    <style>
    /* map_wrap = 지도 담아올 div */
.map_wrap, .map_wrap * {margin:0;padding:0;font-family:'Malgun Gothic',dotum,'돋움',sans-serif;font-size:12px;}
.map_wrap a, .map_wrap a:hover, .map_wrap a:active{color:#000;text-decoration: none;}
.map_wrap {/* position:relative;width:100%; */height:100%;}
#menu_wrap {position:absolute;top:0;left:0;bottom:0;width:250px;margin:10px 0 30px 10px;padding:5px;overflow-y:auto;background:rgba(255, 255, 255, 0.7);z-index: 1;font-size:12px;border-radius: 10px;}

.bg_white {background:#fff;}

#menu_wrap hr {display: block; height: 1px;border: 0; border-top: 2px solid #5F5F5F;margin:3px 0;}
#menu_wrap .option{text-align: center;}
#menu_wrap .option p {margin:10px 0;}  
#menu_wrap .option button {margin-left:5px;}

#placesList li {list-style: none;}
#placesList .item {position:relative;border-bottom:1px solid #888;overflow: hidden;cursor: pointer;min-height: 65px;}
#placesList .item span {display: block;margin-top:4px;}
#placesList .item h5, #placesList .item .info {text-overflow: ellipsis;overflow: hidden;white-space: nowrap;}
#placesList .item .info{padding:10px 0 10px 55px;}
#placesList .info .gray {color:#8a8a8a;}
#placesList .info .jibun {padding-left:26px;background:url(http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_jibun.png) no-repeat;}
#placesList .info .tel {color:#009900;}
#placesList .item .markerbg {float:left;position:absolute;width:36px; height:37px;margin:10px 0 0 10px;background:url(http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png) no-repeat;}
#placesList .item .marker_1 {background-position: 0 -10px;}
#placesList .item .marker_2 {background-position: 0 -56px;}
#placesList .item .marker_3 {background-position: 0 -102px}
#placesList .item .marker_4 {background-position: 0 -148px;}
#placesList .item .marker_5 {background-position: 0 -194px;}
#placesList .item .marker_6 {background-position: 0 -240px;}
#placesList .item .marker_7 {background-position: 0 -286px;}
#placesList .item .marker_8 {background-position: 0 -332px;}
#placesList .item .marker_9 {background-position: 0 -378px;}
#placesList .item .marker_10 {background-position: 0 -423px;}
#placesList .item .marker_11 {background-position: 0 -470px;}
#placesList .item .marker_12 {background-position: 0 -516px;}
#placesList .item .marker_13 {background-position: 0 -562px;}
#placesList .item .marker_14 {background-position: 0 -608px;}
#placesList .item .marker_15 {background-position: 0 -654px;}


#pagination {margin:10px auto;text-align: center;}
#pagination a {display:inline-block;margin-right:10px;}
#pagination .on {font-weight: bold; cursor: default;color:#777;}

.placeinfo_wrap {position:absolute;bottom:28px;left:-150px;width:300px;}
.placeinfo {position:relative;width:100%;border-radius:6px;border: 1px solid #ccc;border-bottom:2px solid #ddd;padding-bottom: 10px;background: #fff;}
.placeinfo:nth-of-type(n) {border:0; box-shadow:0px 1px 2px #888;}
.placeinfo_wrap .after {content:'';position:relative;margin-left:-12px;left:50%;width:22px;height:12px;background:url('http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')}
.placeinfo a, .placeinfo a:hover, .placeinfo a:active{color:#fff;text-decoration: none;}
.placeinfo a, .placeinfo span {display: block;text-overflow: ellipsis;overflow: hidden;white-space: nowrap;}
.placeinfo span {margin:5px 5px 0 5px;cursor: default;font-size:13px;}
.placeinfo .title {font-weight: bold; font-size:14px;border-radius: 6px 6px 0 0;margin: -1px -1px 0 -1px;padding:10px; color: #fff;background: #d95050;background: #d95050 url(http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/arrow_white.png) no-repeat right 14px center;}
.placeinfo .tel {color:#0f7833;}
.placeinfo .jibun {color:#999;font-size:11px;margin-top:0;}

#customoverlay_cancel{float:right; width:30px; color:white; background-Color:#d95050 ; border-radius: 12px;}       
#customoverlay_add{float:right; width:30px; color:white; background-Color:green ; border-radius: 12px;}

.white_content {position: fixed; top: 0; right: 0; bottom: 0; left: 0; background: rgba(0, 0, 0, 0.8); opacity:0; -webkit-transition: opacity 100ms ease-in; -moz-transition: opacity 100ms ease-in; transition: opacity 100ms ease-in; pointer-events: none;}
.white_content:target { opacity:1; pointer-events: auto;  z-index: 3;}
.white_content > div {   position: absolute;   top: 25%;   left: 25%;   width: 50%;   height: 50%;   padding: 16px;   border: 16px solid orange;   background-color: white; overflow: auto;}

.tabmenu {width : 100px; margin-bottom: 10px;}
.nextbtn {width : 100px;}

.radius_border{border:1px solid #919191;border-radius:5px;}     
.custom_typecontrol {position:absolute;top:10px;right:10px;overflow:hidden;width:195px;height:30px;margin:0;padding:0;z-index:4;font-size:12px;font-family:'Malgun Gothic', '맑은 고딕', sans-serif;}
.custom_typecontrol span {display:block;width:65px;height:30px;float:left;text-align:center;line-height:30px;cursor:pointer;}
.custom_typecontrol .btn {background:#fff;background:linear-gradient(#fff,  #e6e6e6);}       
.custom_typecontrol .btn:hover {background:#f5f5f5;background:linear-gradient(#f5f5f5,#e3e3e3);}
.custom_typecontrol .btn:active {background:#e6e6e6;background:linear-gradient(#e6e6e6, #fff);}    
.custom_typecontrol .selected_btn {color:#fff;background:#425470;background:linear-gradient(#425470, #5b6d8a);}
.custom_typecontrol .selected_btn:hover {color:#fff;}


</style>
</head>
<body>
<div class="container" style = "width : 2000px ; height : 1000px"><!-- 메인 컨테이너 -->
   <div id = "left-container" style = "float:left; height : 88%; width : 400px; "><!-- 좌측 div  -->
      <div id="memberinfo" style="border: 1px solid red; width: 398px; height: 100px; float:left">
      
      <div id="memberpic"style="margin : 10px 10px 0px 10px; background:#B7F0B1; width: 80px; height: 80px; float:left;">작성자 프사</div><!-- 사진 div -->
      제목 : ${typeADTO_model.title}<br>
      출발 날짜 : ${typeADTO_model.day_start.substring(0,10)} <button type = "button" onclick = "test()">테스트버튼</button><br>
      작성자 : ${typeADTO_model.id}<br>
      ${typeADTO_model.travel_type} / 추천: / 즐겨찾기<br>
      
      </div> <!-- 회원 정보 div  -->
      
      <div id="road_date" style="border-bottom: 1px solid red; border-right: 1px solid red; border-left: 1px solid red; float: left; height: 94%; width: 148px;padding-top: 9px; text-align: center; overflow: auto;">
      
    <%--      <c:forEach var="courseDTO" items="${select_list}" varStatus="stat">
      </c:forEach> --%>
   
      <%
         TypeADTO adto = (TypeADTO)request.getAttribute("typeADTO_model");
         for(int i = 1 ; i <= adto.getTravel_day() ; i++){
      %>
         <button class="tabmenu" value=<%=i%> id="default"><%=i%>일차</button>
      <%
         }
      %>
      
      <!-- 여행계획서로 전송 --> 
      <div>
         <button class="nextbtn1">완성</button>
         <button class="nextbtn2">동행신청</button>
         <button class="homebtn" onclick="location.href='main.do'" style = "margin-top: 10px;">저장후 홈으로 가기</button>
      </div>
      </div> <!-- 여행 일차 등 들어가는 div  -->
      <div id="roadsidebar" style="border-bottom: 1px solid red; border-right: 1px solid red; overflow:scroll; overflow-x:hidden; float: left; height: 95%; width: 249px; "><!-- 여행 일차별 목적지 div -->
        
      </div>
   </div><!--left-container-->
   
   
   <div class="map_wrap" >
       <div id="map" style="width:1500px;height:935px;position:relative;overflow:hidden;">
   
          <div id="menu_wrap" class="bg_white" style = "z-index: 2">
              <div class="option">
                  <div>
                      <form onsubmit="searchPlaces(); return false;">
                     키워드 : <input type="text" value="" id="keyword" size="15"> 
                     <button type="submit">검색하기</button> 
                      </form>
                  </div>
                  
    
              </div>
              <hr>
              <ul id="placesList"></ul>
              <div id="pagination"></div>
              
          </div>
          
               <div class="custom_typecontrol radius_border">
                 <span id="btnRoadmap" class="selected_btn" onclick="setMapType('roadmap')">지도</span>
                 <span id="btnSkyview" class="btn" onclick="setMapType('skyview')">스카이뷰</span>
                 <span id="btnTraffic" class="btn" onclick="setMapType('traffic')">교통정보</span>
             </div>
             
       </div>
   </div>
   
    <div class="white_content" id="open">
        <div style = "width: 700; height: auto;">
            <p>이 장소에 대한 메모를 입력해주세요<br></p>
             <input type = "hidden" id = "hidden_memo_index">
             <textarea name = "memo_text" id = "memo_text" class = "memo_text" style = "width: 700px; height: 350px;"></textarea><br>
             <button type = "button" class = "memo_write" onclick = "location.href='#close'">작성</button>
             <button type = "button" onclick = "location.href='#close'">취소</button>
        </div>
    </div>
    
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=afbdd676e0cb9858d78365c02cbc33b7&libraries=services"></script>
<script>
var start_date = new Date();
var datetemp = "${typeADTO_model.day_start}";
var start_dd = datetemp.substring(8,10);
var start_mm = datetemp.substring(5,7); 
var start_yyyy = datetemp.substring(0,4);
start_date = start_mm+'/'+start_dd+'/'+start_yyyy;

var today = new Date();
var today_dd = today.getDate();
var today_mm = today.getMonth()+1; //January is 0!
var today_yyyy = today.getFullYear();

if(today_dd<10) {
   today_dd='0'+today_dd
} 

if(today_mm<10) {
   today_mm='0'+today_mm
} 

today = today_mm+'/'+today_dd+'/'+today_yyyy;

var longday = new Array();
<c:forEach items="${daycount}" var="item1" varStatus="i">
longday.push("${daycount.get(i.index)}");
</c:forEach>

function applyCompanion(me,chatRoomNum) {
   $.ajax({
      url : "applyCompanion",
      data : {"me" : me,
            "chatRoomNum" : chatRoomNum},
      success : function(result) {
         if(result.trim()=="O")
            alert("동행신청이 완료되었습니다.")
            //동행신청완료시 typeA의 현재인원 +1하는 처리가 들어갈 자리
         else
            alert("이미 신청했거나 동행중입니다.")
      }
   })
}


var placeOverlay = new kakao.maps.CustomOverlay({zIndex:1}), 
    contentNode = document.createElement('div'), // 커스텀 오버레이의 컨텐츠 엘리먼트 입니다 
    markers = []; // 마커를 담을 배열입니다
    
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
        level: 5 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

function setMapType(maptype) { 
    var roadmapControl = document.getElementById('btnRoadmap');
    var skyviewControl = document.getElementById('btnSkyview');
    var trafficControl = document.getElementById('btnTraffic');
      
    
    if (maptype === 'roadmap') {
        map.setMapTypeId(kakao.maps.MapTypeId.ROADMAP);    
        roadmapControl.className = 'selected_btn';
        skyviewControl.className = 'btn';
    } 
    else if(maptype === 'skyview') {
        map.setMapTypeId(kakao.maps.MapTypeId.HYBRID);    
        roadmapControl.className = 'btn';
        skyviewControl.className = 'selected_btn';
    }
    else if(maptype === 'traffic'){
       if(trafficControl.className == "btn"){
         map.addOverlayMapTypeId(kakao.maps.MapTypeId.TRAFFIC);
            trafficControl.className = 'selected_btn';
       }
       
       else{
          trafficControl.className = 'btn';
          map.removeOverlayMapTypeId(kakao.maps.MapTypeId.TRAFFIC);  
       }
       
    }
}


// 장소 검색 객체를 생성합니다
var ps = new kakao.maps.services.Places();  

//커스텀 오버레이의 컨텐츠 노드에 css class를 추가합니다 
contentNode.className = 'placeinfo_wrap';
 
// 커스텀 오버레이 컨텐츠를 설정합니다
placeOverlay.setContent(contentNode);  

//커스텀 오버레이의 컨텐츠 노드에 mousedown, touchstart 이벤트가 발생했을때
//지도 객체에 이벤트가 전달되지 않도록 이벤트 핸들러로 kakao.maps.event.preventMap 메소드를 등록합니다               //-------------------HONG(링크를 누르고 드래그 했을때의 오류 수정)
addEventHandle(contentNode, 'mousedown', kakao.maps.event.preventMap);
addEventHandle(contentNode, 'touchstart', kakao.maps.event.preventMap);

//엘리먼트에 이벤트 핸들러를 등록하는 함수입니다
function addEventHandle(target, type, callback) {
    if (target.addEventListener) {
        target.addEventListener(type, callback);
    } else {
        target.attachEvent('on' + type, callback);
    }
}

// 키워드 검색을 요청하는 함수입니다
function searchPlaces() {

    var keyword = document.getElementById('keyword').value;

    if (!keyword.replace(/^\s+|\s+$/g, '')) {
        alert('키워드를 입력해주세요!');
        return false;
    }

    // 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
    ps.keywordSearch( keyword, placesSearchCB); 
    placeOverlay.setMap(null);                                                               // --------------HONG (커스텀 오버레이 숨기는게 낫다고 판단)
}

// 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
function placesSearchCB(data, status, pagination) {
    if (status === kakao.maps.services.Status.OK) {

        // 정상적으로 검색이 완료됐으면
        // 검색 목록과 마커를 표출합니다
        displayPlaces(data);

        // 페이지 번호를 표출합니다
        displayPagination(pagination);

    } else if (status === kakao.maps.services.Status.ZERO_RESULT) {

        alert('검색 결과가 존재하지 않습니다.');
        return;

    } else if (status === kakao.maps.services.Status.ERROR) {

        alert('검색 결과 중 오류가 발생했습니다.');
        return;  

    }
} 


//클릭한 마커에 대한 장소 상세정보를 커스텀 오버레이로 표시하는 함수입니다                                                      ---------------------------HONG
function displayPlaceInfo(place) {
    var content = '<div class="placeinfo">' +
                    '   <a class="title" href="' + place.place_url + '" target="_blank" title="' + place.place_name + '">' + place.place_name + '</a>';
         var place_url = place.place_url;
         place_url = place_url.replace(/ /gi,"&nbsp;");
           
         var place_name = place.place_name;
         place_name = place_name.replace(/ /gi,"&nbsp;");
        
         var place_address_name = place.address_name;
         place_address_name = place_address_name.replace(/ /gi,"&nbsp;");
        
         var place_road_address_name = place.road_address_name;
         place_road_address_name = place_road_address_name.replace(/ /gi,"&nbsp;");
         
         var place_phone = place.phone;
         place_phone = place_phone.replace(/ /gi,"&nbsp;");
         
    if (place.road_address_name) {
            
        content +=  '    <span title="' + place.road_address_name + '">' + place.road_address_name + 
                    '    <button type = "button" id="customoverlay_cancel" onclick="customoverlay_cancel();">X</button>' +            // -------------------------HONG (취소버튼까지 span안에 넣어봤음)
                    '    <button id=customoverlay_add onclick=customoverlay_add("'+place_url+'","'+place_name+'","'+place_address_name+'","'+place_road_address_name+'","'+place_phone+'","'+place.x+'","'+place.y+'")>V</button></span>'+
                    '    <span class="jibun" title="' + place.address_name + '">(지번 : ' + place.address_name + ')</span>';
    }  
    else {
        content +=  '    <span title="' + place.address_name + '">' + place.address_name +
                    '    <button type = "button" id="customoverlay_cancel" onclick="customoverlay_cancel();">X</button>' + 
                    '    <button id=customoverlay_add onclick=customoverlay_add("'+place_url+'","'+place_name+'","'+place_address_name+'","'+place_road_address_name+'","'+place_phone+'","'+place.x+'","'+place.y+'")>V</button>'+
                    '    </span>';
    }                
   
    content += '    <span class="tel">' + place.phone + '</span>' +
               '   </div>' + 
               '   <div class="after"></div>';

    contentNode.innerHTML = content;
    placeOverlay.setPosition(new kakao.maps.LatLng(place.y, place.x));
    placeOverlay.setMap(map);  
  
    if(id!=nowid){
       $("#customoverlay_add").remove();
   }
    
}
  

var ourmarker = [];
var ourindex = 0;
function ourmarkeradd(y,x){                                       // -----------------HONG(내가 정한 장소 지도에 마커로 표시)
   var markerPosition  = new kakao.maps.LatLng(y, x);
   /* var imageSrc = 'https://postfiles.pstatic.net/MjAxOTA5MjBfMzEg/MDAxNTY4OTYyMzE3ODUw.4tdESTi8sQRVpQgsSjxwVToiyvrMv4UDG5sGI7gi4f8g.I9ERXc5QnIqR2emhT0ZEk_B-Xx6-rbWoN3lYVsWdRSsg.PNG.jooahn424/Untitled.png?type=w773', */ 
   /* var imageSrc = 'https://postfiles.pstatic.net/MjAxOTA5MjBfMTI4/MDAxNTY4OTYzNjQ0NzY3.faER9cg_yYIzrIhFJDhvqy1mS3EvgXnExJLB03uLH-Eg.kENpQnWGeHoDW-BGCDH4Vx1f40lrT31CB_8Gbdy0HF8g.PNG.jooahn424/markermarker.png?type=w773', // 마커이미지의 주소입니다 */
   var imageSrc = "resources/img/markermarker.png",
   imageSize = new kakao.maps.Size(58, 60), // 마커이미지의 크기입니다
   imageOption = {offset: new kakao.maps.Point(23, 60)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
     
   //마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
   var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
      marker = new kakao.maps.Marker({
          position: markerPosition,
          image: markerImage
      });
      ourmarker[ourindex] = marker;
      ourindex++;
   marker.setMap(map);
}

function ourmarker_alldel(){
   for(var i = 0 ; i < ourmarker.length ; i++){
      ourmarker[i].setMap(null);
   }
   ourindex = 0;
   ourmarker = [];
}

function ourmarkerdel(delete_num){
   var marker = ourmarker[delete_num-1]; 
   ourindex--;
   for(var i = delete_num ; i<=ourindex; i++){
      ourmarker[i-1] = ourmarker[i];
   }
   marker.setMap(null);
}

var delete_index = 0;
var memo_index = 0;
var day = 1;

// **********************
var no = ${typeADTO_model.no}; 
var id = "${typeADTO_model.id}";
var nowid = "<%=(String)session.getAttribute("id")%>";
/*var nowid = sessionStorage.getItem("id"); */
var memo = "메모를 입력하지 않았습니다!";
alert(nowid);
var choice = ${typeADTO_model.complete};
if(choice == 1){
	choice = 0;
}

// **********************

function applychoice(){// 완성 눌렀을 때,
	choice = ${typeADTO_model.complete};
	if(choice == 0){
		choice = 1;
	}
	    $.ajax({
		      url : "choiceUpdate.do",
		      data : {
		    	  "complete" : choice,
		    	  "no" : no
		          },
		      success : function(result) {
		    	  
		      }
		   }) 
}
$(function() {
   
   if(id!=nowid){
      $(".memo_write").remove();
      $(".nextbtn1").remove();
      
   }
   else{
	   $.ajax({
		    url : "choiceUpdate.do",
		    data : {
		  	  "complete" : choice,
		  	  "no" : no
		        },
		    success : function(result) {
		    }
		 }) 
      $(".nextbtn2").remove();
   }
  
   
   $(".nextbtn1").click(function() {
		var indexOX = true;
		var daybetween = ${typeADTO_model.travel_day};
		if(daybetween>longday.length){
			indexOX=false;
		}
		for(var i = 0 ; i < longday.length ; i++){
			if(longday[i]==0){
				indexOX=false;
			}
		}
		  
		if(indexOX){
			applychoice();
			location.href = "myPerfectPlanList";
		}
		else{
		   	alert("날짜당 한개 이상의 경로를 추가해주세요");
		}
	})
  
   
   if(start_date>today){
       $(".nextbtn2").click(function() {
             applyCompanion('${me}',${typeADTO_model.chatRoomNum});
             location.href = "main.do";
          })
    }
    else{
    	$(".nextbtn2").click(function() {
       		alert("이미 출발/종료된 여행입니다.");
     	})
    }
   
});


 $.ajax({                  /* 페이지 첫 로딩시 select */
       url: 'select.do',
       data: {"id":id,"no":no,"day":day}, 
       success: function(result){
        $("#roadsidebar").append(result);
        delete_index = $("#select_delete_index").val();
        if(id!=nowid){
           $("#place_delete").attr("disabled","disabled");
        }
        refreshline();
       },
       error: function() {
         alert("실패:/");
      } //error End
    })
    
$(function() {

   $(".memo_write").click(function() {
      
      var place_memo = $("#memo_text").val();
      var hidden_memo_index = $("#hidden_memo_index").attr("value");
      
      $.ajax({
         url: 'memoedit.do',
         data : {
          "day" : day,
          "memo_index" : hidden_memo_index,
          "place_memo" : place_memo,
          "no" : no
         },
         success: function() {
            alert("메모 추가 완료:>");
            
         },
         error: function() {
            alert("실패:/");
         }
      })
   })
});

$(function() {
     $(".tabmenu").click(function(){/* 일차변경 */
         day = $(this).val();
      $.ajax({
       url: 'select.do',
       data: {"id":id,"no":no,"day":day}, 
       success: function(result){
        $("#roadsidebar").empty();
        $("#roadsidebar").append(result);
        delete_index = $("#select_delete_index").val();       /* delete index 유지 */

        if(id!=nowid){
           $("#place_delete").attr("disabled","disabled");
        }
        refreshline();
        ourmarker_alldel();
        for(var i = 0 ; i <= delete_index ; i++){
           var x = $("#road_place_"+i).find("#place_x").val();
           var y = $("#road_place_"+i).find("#place_y").val();
           ourmarkeradd(y,x);
        }
       },
       error: function() {
         alert("실패:/");
      } //error End
      }) //Ajax End
      
      
     }) //button End
    }); //JQuery End
    
function customoverlay_add(place_url,place_name,place_address_name,place_road_address_name,place_phone,x,y){ 
       
   if(typeof longday[day-1] == "undefined"){
	longday[day-1] = 1;
   }
   else{
   	longday[day-1] = longday[day-1]+1;
   }
   memo_index++;
     // 만약 일차버튼이 on일 때, 버튼 상태값을 변수에 담고 넘겨주기!:>
     //ggg
      // V버튼 눌렀을 때, insert 실행
          $.ajax({
            url: 'insert_root.do',
            data: {
               "no": no,
               "id": id,
               "day": day,
               "place_url": place_url,
               "place_name": place_name,
               "place_x": x,
               "place_y": y, 
               "place_address_name": place_address_name,
               "place_phone": place_phone,
               "place_memo": memo,
               "memo_index": memo_index,
               "place_road_address_name": place_road_address_name
            },
            success: function(result) {
            },
            error: function() {
               alert('실패:/');
            }
         }); 
      
    delete_index++;
    var div = document.createElement('div');
    div.className = 'roadrow';
    div.innerHTML = '<div style="height: 200px; width: 99%; border: 1px solid ;position:relative"id =road_place_'+delete_index+'>'+place_url+"<br>"+
                "<span id =side_place_name>"+place_name+"</span><br>"+place_address_name+"<br>"+place_road_address_name+"<br>"+place_phone+
                    '<button id="open_memo" class="open_memo" onclick=memo_open('+memo_index+') style="position:absolute; bottom:0px; left:0px">메모추가</button>'+
                    '<button id="place_move" style="position:absolute; bottom:0px; left:81px" onclick=panTo('+y+','+x+')>위치보기</button>'+
                    '<button id="place_delete" style="position:absolute; bottom:0px; right:0px" onclick=customoverlay_delete('+delete_index+','+memo_index+')>위치삭제</button>'+
                    '<input type = "hidden" id = "memo_val">'+
                    '<input type = "hidden" id = "place_x" value = '+x+'> '+
                    '<input type = "hidden" id = "place_y" value = '+y+'> </div></div>';
                    
   
   if(delete_index>1){
      var road_search = document.createElement('div');   
      road_search.className = 'road_search';
      road_search.id = 'road_search_'+Number(delete_index-1);
      
      var side_place_name = $("#road_place_"+Number(delete_index-1)).find("#side_place_name").text();
      road_search.innerHTML = '<div style = "height:20px; width : 99%; background: #C0FFFF; text-align: center;">'+
                        '<a href=https://map.kakao.com/?eName='+place_name+'&sName='+side_place_name+' id = "road_url" target="_blank">↕길찾기↕</a>'+
                        '</div>';
                        
      document.getElementById('roadsidebar').appendChild(road_search);
   }
    document.getElementById('roadsidebar').appendChild(div);
   ourmarkeradd(y,x);
   refreshline();
}

function memo_open(memo_index_open){
            location.href="#open";
         $("#hidden_memo_index").val(memo_index_open);
         
          $.ajax({
               url: 'memoselect.do',
               data: {
                "day" : day,
               "memo_index" : memo_index_open,
               "no" : no
               },
               success: function(result) {
                  $("#memo_text").val(result) /* result = 메모내용 */
               },
               error: function() {
                  alert('메모 셀렉트 실패:/');
               }
             }); 
          
}

function customoverlay_delete(delete_num,memo_index){  
   longday[day-1] = longday[day-1]-1;
     $.ajax({
      url: 'delete.do',
      data: {
         "no": no,
         "id": id,
         "memo_index":memo_index
      },
      success: function(result) {
         alert('성공');
      },
      error: function() {
         alert('실패:/');
      }
    }); 
     
   var x = $("#road_place_"+delete_num).find("#place_x").val();
   var y = $("#road_place_"+delete_num).find("#place_y").val();
   
   ourmarkerdel(delete_num);
   
    $("div").remove("#road_place_"+delete_num);
    if(delete_num==1){
       $("div").remove("#road_search_"+delete_num);
    }
    else{
       $("div").remove("#road_search_"+Number(delete_num-1));
         var first = $("#road_place_"+Number(delete_num-1)).find("#side_place_name").text();
          var second = $("#road_place_"+Number(delete_num+1)).find("#side_place_name").text();
       $("#road_search_"+delete_num).find("#road_url").prop('href',"https://map.kakao.com/?eName="+second+"&sName="+first);
    }
    
    for(var i=delete_num+1 ; i <= delete_index; i++){
        
        var imsi = $("#road_place_"+i).find("#place_delete").attr("onclick");
        var imsi2 = imsi.split(',');
        imsi = imsi2[1].replace(')','');
       $("#road_place_"+i).find("#place_delete").removeAttr("onclick");
       $("#road_place_"+i).find("#place_delete").attr("onclick","customoverlay_delete("+(i-1)+","+imsi+")");
       $("#road_place_"+i).attr('id','road_place_'+(i-1)); 
       
       if(delete_num>1){
          $("#road_search_"+Number(i-1)).attr('id','road_search_'+Number(i-2));
       }
       else{
          $("#road_search_"+i).attr('id','road_search_'+(i-1));
       }
     
       
    }
    delete_index--;
    refreshline();
}


function customoverlay_cancel(){                                                // ------------HONG (취소 버튼을 통해 커스텀 오버레이를 숨기기 위한 함수)
    placeOverlay.setMap(null);
}


// 검색 결과 목록과 마커를 표출하는 함수입니다
function displayPlaces(places) {
   
   /* //인포윈도우를 생성합니다
   var infowindow = new kakao.maps.InfoWindow({
       content : '<div style="padding:5px;">Hello World!<button type = "button" >경로 추가</button> </div>', 
       // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다                                                                                                                                                    --------------HONG(처음엔 인포 윈도우 쓰다가 커스텀 오버레이로 변경)
       removable : true
   }); */
   

    var listEl = document.getElementById('placesList'), 
    menuEl = document.getElementById('menu_wrap'),
    fragment = document.createDocumentFragment(), 
    bounds = new kakao.maps.LatLngBounds(), 
    listStr = '';
    
    // 검색 결과 목록에 추가된 항목들을 제거합니다
    removeAllChildNods(listEl);

    // 지도에 표시되고 있는 마커를 제거합니다
    removeMarker();
    
    for ( var i=0; i<places.length; i++ ) {

        // 마커를 생성하고 지도에 표시합니다
        var placePosition = new kakao.maps.LatLng(places[i].y, places[i].x),
            marker = addMarker(placePosition, i), 
            itemEl = getListItem(i, places[i]); // 검색 결과 항목 Element를 생성합니다                  // ----------HONG(반복 함수 호출.. 그럼 뭐를 봐야될까요? -> getListItem()가서 확인을 해야겠죠 ?)

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
        // LatLngBounds 객체에 좌표를 추가합니다
        bounds.extend(placePosition);

        // 마커와 검색결과 항목에 mouseover 했을때
        // 해당 장소에 인포윈도우에 장소명을 표시합니다
        // mouseout 했을 때는 인포윈도우를 닫습니다
        
        
         (function(marker, place) {                  // --------------------------------------HONG(아래에 (marker, places[i])의 파라메터)
           /* kakao.maps.event.addListener(marker, 'mouseover', function() {                  --------------------------HONG(마우스over, out은 안쓸게욤)                      
                displayInfowindow(marker, title);
            });

            kakao.maps.event.addListener(marker, 'mouseout', function() {
                infowindow.close();
            });
                     
            itemEl.onmouseover =  function () {
                displayInfowindow(marker, title);
            };

            itemEl.onmouseout =  function () {
                infowindow.close();
            }; */

            // 마커에 클릭이벤트를 등록합니다
            kakao.maps.event.addListener(marker, 'click', function() {
                        
                  displayPlaceInfo(place);
                  /* infowindow.open(map, marker); */
                  /* alert(marker.getPosition());                                  //--------------HONG(marker로 좌표값을 받아오는것이랑 place의 x,y좌표는 실은 동일하다 뭘 써도 상관은 없음) */
            });
            
        })(marker, places[i]); //  -----------------------HONG(실은 상당히 중요한 부분임, 원래 places[i].names 이런식으로 돼어있었는데, 그러면 place[i]의 네임값 밖에 못가져오는 손해가 발생함)
                                               //(고로 plces[i]를 해버려서 object 전체를 가져와서 이벤트 호출하는것이 훨씬 간편하면서 범용성이 좋음)

        fragment.appendChild(itemEl);
    }

    // 검색결과 항목들을 검색결과 목록 Elemnet에 추가합니다
    listEl.appendChild(fragment);
    menuEl.scrollTop = 0;

    // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
    map.setBounds(bounds);
}

 function panTo(y,x) {
    // 이동할 위도 경도 위치를 생성합니다 
    var moveLatLon = new kakao.maps.LatLng(y, x);
    
    // 지도 중심을 부드럽게 이동시킵니다
    // 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
    map.panTo(moveLatLon);            
}         

// 검색결과 항목을 Element로 반환하는 함수입니다
function getListItem(index, places) {                                                //----------------HONG(지금 이 메서드가 반복문에서 사용되기 때문에 여러번 반복되서 호출된다)
   
    var el = document.createElement('li'),
    itemStr = '<span class="markerbg marker_' + (index+1) + '"></span>' +
                '<div class="info" >' +                  /* ----------hong(좌측에(menu_span)검색결과에 x,y좌표를 받아서 지도 이동 시켜주는 test()메서드 실행 )*/
                '   <a href = \'#\'><h5>' + places.place_name + '</h5></a>';

    if (places.road_address_name) {
        itemStr += '    <span>' + places.road_address_name + '</span>' +
                    '   <span class="jibun gray">' +  places.address_name  + '</span>';
    } else {
        itemStr += '    <span>' +  places.address_name  + '</span>'; 
    }
                 
      itemStr += '  <span class="tel">' + places.phone  + '</span>' +
                '</div>';           

    el.innerHTML = itemStr;
    el.className = 'item';
    
    el.addEventListener('click', function(){                              // -------------------HONG(button onclick 으로 itemStr에서 추가하려고 하면 온전히 object를 넘길수가 없어서)
       test(places,places.y,places.x);
   });

    return el;
}

function test(places,y,x){ /* 좌측 목록 선택시 좌표 출력                                                                             *****************************HONG(panto 실행 시키는 메서드 추후에 없애고 바로 가게 해도 됨)  */
     displayPlaceInfo(places);
     panTo(y,x);
}


// 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
function addMarker(position, idx, title) {
    var imageSrc = 'http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
        imageSize = new kakao.maps.Size(36, 37),  // 마커 이미지의 크기
        imgOptions =  {
            spriteSize : new kakao.maps.Size(36, 691), // 스프라이트 이미지의 크기
            spriteOrigin : new kakao.maps.Point(0, (idx*46)+10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
            offset: new kakao.maps.Point(13, 37) // 마커 좌표에 일치시킬 이미지 내에서의 좌표
        },
        markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions),
            marker = new kakao.maps.Marker({
            position: position, // 마커의 위치
            image: markerImage 
        });

    marker.setMap(map); // 지도 위에 마커를 표출합니다
    markers.push(marker);  // 배열에 생성된 마커를 추가합니다
   
    return marker;
}

// 지도 위에 표시되고 있는 마커를 모두 제거합니다
function removeMarker() {
    for ( var i = 0; i < markers.length; i++ ) {
        markers[i].setMap(null);
    }   
    markers = [];
}


// 검색결과 목록 하단에 페이지번호를 표시는 함수입니다
function displayPagination(pagination) {
    var paginationEl = document.getElementById('pagination'),
        fragment = document.createDocumentFragment(),
        i; 

    // 기존에 추가된 페이지번호를 삭제합니다
    while (paginationEl.hasChildNodes()) {
        paginationEl.removeChild (paginationEl.lastChild);
    }

    for (i=1; i<=pagination.last; i++) {
        var el = document.createElement('a');
        el.href = "#";
        el.innerHTML = i;

        if (i===pagination.current) {
            el.className = 'on';
        } else {
            el.onclick = (function(i) {
                return function() {
                    pagination.gotoPage(i);
                }
            })(i);
        }

        fragment.appendChild(el);
    }
    paginationEl.appendChild(fragment);
}

 // 검색결과 목록의 자식 Element를 제거하는 함수입니다
function removeAllChildNods(el) {   
    while (el.hasChildNodes()) {
        el.removeChild (el.lastChild);
    }
}
 
var lineshow;

function deleteClickLine() {
    if (lineshow) {
       lineshow.setMap(null);    
       lineshow = null;        
    }
}

function refreshline(){
   
    deleteClickLine();
   
   var line_x;
   var line_y;
   
   var line_setpos = [delete_index];

   
   for(var i = 1 ; i <= delete_index ; i++){

      line_x = $("#road_place_"+i).find("#place_x").val();
      line_y = $("#road_place_"+i).find("#place_y").val();
      
      var lineloc = new kakao.maps.LatLng(line_y, line_x);
      line_setpos[i-1] = lineloc;
      
      if(i==1){
          lineshow = new kakao.maps.Polyline({
            map:map,
            path:[lineloc],
            strokeWeight: 5, // 선의 두께입니다 
             strokeColor: '#FE7AFA', // 선의 색깔입니다
             strokeOpacity: 1, // 선의 불투명도입니다 0에서 1 사이값이며 0에 가까울수록 투명합니다
             strokeStyle: 'solid' // 선의 스타일입니다
          })
      }
      else{
          var path = lineshow.getPath();
          path.push(lineloc);
          lineshow.setPath(path);
      }
      
   } 
   
}

function test(){
	for(var i = 0 ; i<longday.length ; i++){
		alert(longday[i]);
	}
}
      

</script>
</div>
</body>
</html>