package com.rt.travel.chat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rt.travel.chat.dao.ChatDAO;
import com.rt.travel.chat.dto.ChatContentDTO;
import com.rt.travel.chat.dto.ChatRoomDTO;
import com.rt.travel.chat.dto.FriendDTO;
import com.rt.travel.member.dao.MemberDAO;
import com.rt.travel.member.dto.MemberDTO;

public class ChatHtmlSetter {
	private String menuListHtml;
	private String menuTypeHtml;
	private List<ChatRoomDTO> list_room;
	private List<FriendDTO> list_friend;
	private List<ChatContentDTO> list_content;
	private String content;
	private String contentTime;
	private String contentTime2;
	private String[] contentTime_;
	private String name;
	private String email;
	private String eachHtml;
	private String roomInfoHtml;
	private String roomNums;
	private String openSocket;
	private String friendInfoName;
	
	@Autowired
	private ChatDAO chatDAO;
	@Autowired
	private MemberDAO memberDAO;
	private FriendDTO friendDTO;
	private ChatContentDTO chatContentDTO;
	private ChatRoomDTO chatRoomDTO;
	
	//chat의 몸체 가져오는 메소드
	public String getChat(String member) {
		

		return "<div id = \"chatDiv\" style = \"position : fixed; right : 30px; bottom : 30px;width : 345px; height : 500px;\">"
				+	"<div id = \"menuDiv\" style = \"padding-top : 35px;padding-left : 10px;padding-right : 10px;border :thin solid black; position : fixed;bottom : 30px; right : 310px; width : 45px; height : 465px;\">"
				+		"<img id = \'friend\' src=\'resources/img/friend.jpg\'>"
				+		"<img id = \'chatImg\' src=\'resources/img/malpung.jpg\' style = \'margin-top : 20px;\'>"
				+	"</div>" 
				+	"<div id = \"contentListDiv\" style= \"border :thin solid black; position : fixed;right : 30px;bottom : 30px; width : 280px; height : 500px;\">"
				+		"<div id = \"menuType\" style=\"padding-top : 25px;padding-left : 10px;position : fixed;border :thin solid black; width:270px; height : 65px; right : 30px;\">"
				+			getMenuType("채팅")
				+		"</div>"
				+		"<div id = \"menuContent\" style=\"overflow : auto; position : fixed;border :thin solid black; width:280px; height : 410px; right : 30px;bottom : 30px;\">"
				+			"<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>"  
				+			"<script type = \"text/javascript\" src = \"resources/js/chat.js\"></script>"
				+			getMenuContent_chat(member)
				+			openSocket
				+		"</div>"
				+	"</div>" 
				+"</div>";
	}
	//chat의 menutype가져오는 메소드
		public String getMenuType(String menuType) {
			menuTypeHtml =  "<span id = \'typeName\'style = \'font-size : 21px; font-weight : bold;\'>"+menuType+"</span><br>"
					+ 		"<input id=\'roomSearch\' type = \"text\" >"
					+		"<img id = \'minimiChat\' src=\'resources/img/minimi.png\'>";
			return menuTypeHtml;
		}
	//chat의 menucontent가져오는 메소드
	public String getMenuContent_chat(String member) {
		openSocket = "";
		chatDAO.deleteRoom();
		list_room = chatDAO.selectRooms(member);
		int divPositionVal = 335;
		int divHeight = 60;
		menuListHtml =  "";
		//websocket에서 open시킬 채팅방 번호목록을 저장시킬 변수
		roomNums = "";
		for(int i=0;i<list_room.size();i++) {
			chatRoomDTO = list_room.get(i);
			chatContentDTO = chatDAO.getContent(chatRoomDTO.getchatRoomNum());
			content = "";
			contentTime = "";
			contentTime2 = "";
			roomNums += chatRoomDTO.getchatRoomNum()+",";
			if(chatContentDTO!=null) {
				//open시킬 채팅방 번호목록 저장하는부분
				contentTime_ = chatContentDTO.getContentTime().split(" ");
				contentTime = contentTime_[0];
				contentTime2 = contentTime_[1];
				contentTime_ = contentTime.split("-");
				contentTime = contentTime_[1]+"월"+contentTime_[2]+"일";
				contentTime_ = contentTime2.split(":");
				contentTime2 = contentTime_[0]+"시"+contentTime_[1]+"분";
				content = chatContentDTO.getContent();
			}
				menuListHtml+="<div class = \"rooms\" style=\"width : 263px; height : 60px;\">"
							+	"<input type = \'hidden\' value=\'"+chatRoomDTO.getchatRoomNum()+"\'>"
							+	"<div class=\'thumbnail\' style=\'float : left;padding : 5px;width : 55px; height : 50px; bottom : "+(divPositionVal-i*divHeight)+"px;\'>"
							+		"<img src=\'resources/img/"+chatRoomDTO.getThumbnail()+"\'>"
							+	"</div>"
							+	"<div class=\'roomName\' style=\'float : left;padding : 5px;width : 123px;bottom : "+(divPositionVal-i*divHeight)+"px; height : 50px;'>"
							+		"<span style=\'font-size : 15px; font-weight : bold\'>"+chatRoomDTO.getchatRoomName()+"</span>"
							+		"<span style=\'font-size : 12px; margin-left : 10px;\'>"+chatRoomDTO.getLimitMember()+"</span><br>"
							+		"<span id=\'"+chatRoomDTO.getchatRoomNum()+"\'style=\'font-size : 14px; color : #666562;\'>"+content+"</span>"
							+	"</div>"
							+	"<div class=\'time\' style=\'float : left;padding : 5px;width : 55px; bottom : "+(divPositionVal-i*divHeight)+"px;height : 50px;\'>"
							+		"<span id=\'t1"+chatRoomDTO.getchatRoomNum()+"\' style=\'font-size : 10px; color:#b5b1a7;\'>"+contentTime+"</span><br>"
							+		"<span id=\'t2"+chatRoomDTO.getchatRoomNum()+"\' style=\'font-size : 10px; color:#b5b1a7;\'>"+contentTime2+"</span>"
							+	"</div>"
							+ "</div>";
		}
		if(list_room.size()>0)
			openSocket ="<script>roomNumsSetting(\'"+roomNums.substring(0, roomNums.length()-1)+"\')</script>";
		return menuListHtml;
	}
	//chat의 menucontent가져오는 메소드
	public String getMenuContent_friend(String name) {
		list_friend = memberDAO.friendList(name);
		int divPositionVal = 335;
		int divHeight = 60;
		menuListHtml =  "";
		if(list_friend!=null) {
			for(int i=0;i<list_friend.size();i++) {
				friendDTO = list_friend.get(i);
				if(friendDTO.getAuth()=='O') {
					if(i==0) {
						this.name=friendDTO.getMyName();
						this.email=memberDAO.selectEmail(friendDTO.getMyId()).getEmail();
						setMenuListHtml(divPositionVal-i*divHeight);
						this.name = friendDTO.getFriendName();
						this.email=memberDAO.selectEmail(friendDTO.getFriendId()).getEmail();
						setMenuListHtml(divPositionVal-i*divHeight);
					}else {
						this.name = friendDTO.getFriendName();
						this.email=memberDAO.selectEmail(friendDTO.getFriendId()).getEmail();
						setMenuListHtml(divPositionVal-i*divHeight);
					}
				}
			}
		}
		return menuListHtml;
	}
	public void setMenuListHtml(int divStyle) {
		menuListHtml+="<div class = \"friends\" onclick=\'\' style=\"width : 263px; height : 60px;\">"
				+	"<div class=\'thumbnail\' style=\'float : left;padding : 5px;width : 55px; height : 50px; bottom : "+divStyle+"px;\'>"
				//나중에 member테이블의 thumbnail로 교체
				+		"<img src=\'resources/img/thumb.jpg\'>"
				+	"</div>"
				+	"<div class=\'roomName\' style=\'float : left;padding : 5px;width : 123px;bottom : "+divStyle+"px; height : 50px;\'>"
				+		"<span class=\'names\'style=\'font-size : 15px; font-weight : bold;\'>"+this.name+"</span><br>"
				+		"<span style=\'font-size : 14px; color : #666562;\'>"+this.email+"</span>"
				+	"</div>"
				+	"<div class=\'time\' style=\'float : left;padding : 5px;width : 55px; bottom : "+divStyle+"px;height : 50px;\'>"
				+	"</div>"
				+ "</div>";
	}
	
	//채팅방
	public String eachChat(String name,int chatRoomNum) {
		eachHtml = "";
			list_content = chatDAO.getContents(chatRoomNum);
			eachHtml +="<div class = \'chatRoom\'id = \'chatRoom"+chatRoomNum+"\'>"
					+		chatRoomScript(chatRoomNum)
					+	"<div class = \'roomInfo\' id = \'roomInfo"+chatRoomNum+"\'>"
					+		roomInfo(chatRoomNum)
					+	"</div>"
					+	"<div class = \'notice\'>"
					+		notice(chatRoomNum)
					+	"</div>"
					+	"<div id = \'roomContent"+chatRoomNum+"\' class = \'roomContent\'>";
			if(list_content!=null) {
				for(int i=0;i<list_content.size();i++) {
					chatContentDTO = list_content.get(i);
					eachHtml += chatRoomCon(chatContentDTO,name);
				}
			}
			eachHtml += "</div><div class = \'addContentDiv\'>"
					+		"<textarea id = \'textA"+chatRoomNum+"\'class = \'textA\' cols=\'30\' rows=\'5\'></textarea>"
					+		"<button id = \'addCon"+chatRoomNum+"\' value = \'"+chatRoomNum+"\'class = \'addCon\'disabled=\'disabled\'>전송</button>"
					+ 	"</div></div>";
		return eachHtml;
	}
	public String chatRoomCon(ChatContentDTO chatContentDTO,String name) {
		contentTime2 = "";
		contentTime_ = chatContentDTO.getContentTime().split(" ");
		contentTime2 = contentTime_[1];
		contentTime_ = contentTime2.split(":");
		contentTime2 = contentTime_[0]+"시"+contentTime_[1]+"분";
				//memberThumb
		if(!name.equals(chatContentDTO.getMember()))
			return "<div class = \'chatConThumb\'><img src = \'resources/img/thumb.jpg\'></div>"
					+	"<div class = \'chatMsg\'>"
					+ 		"<div class=\'chatConDiv\'>"
					+			"<span class=\'chatM\'>"+chatContentDTO.getMember()+"</span><br>"
					+			"<span class=\'chatCon\'>"+chatContentDTO.getContent()+"</span>"
					+			"<span class=\'chatT\'>"+contentTime2+"</span>"
					+		"</div>"
					+	"</div>";
		else
			return  "<div class = \'myChatConThumb\'><img src = \'resources/img/thumb.jpg\'></div>"
					+"<div class = \'myMsg\'>"
					+	"<div class=\'myConDiv\'>"
					+		"<span class=\'myChatM\'>나</span><br>"
					+		"<span class =\'myChatT\'>"+contentTime2+"</span>"
					+		"<span class = \'myChatCon\'>"+chatContentDTO.getContent()+"</span>"
					+	"</div>"
					+"</div>";
	}
	public String roomInfo(int chatRoomNum) {
		roomInfoHtml = "";
		chatRoomDTO = chatDAO.selectRoom(chatRoomNum);
		roomInfoHtml =  "<div class = \'roomInfoDiv\'>"
							//나중에 썸네일 제대로 고치기(roomThumb)
				+			"<div class=\'roomInfoThumb\'><img src='resources/img/thumb.jpg'></div>"
				+			"<div class=\'roomInfoCon\'>"
				+				"<div class=\'leftRoomInfo\'>"
				+					"<span>"+chatRoomDTO.getchatRoomName()+"</span>"
				+					"<span>"+chatRoomDTO.getLimitMember()+"</span><br>"
				+				"</div>"
				+				"<div class=\'rightRoomInfo\'>"
				+					"<button class =\'exit\' value=\'"+chatRoomNum+"\'>닫기</button><br>"
				+				"</div>"
				+			"</div>"
				+ 		"</div>";
		return roomInfoHtml;
	}
	public String notice(int chatRoomNum) {
		return "";
	}
	public String searchResult(MemberDTO memberDTO,String isFriend) {
		//고칠거
		return "<img id =\"friendPicture\" src = \"resources/img/thumb.jpg\"><br>" + 
				"<span id = \"resultFriendName\">"+memberDTO.getName()+"_"+memberDTO.getId()+"</span><br>" + 
				isFriend;
	}
	public String chatRoomScript(int chatRoomNum) {
		return "<script>" +
				"dragElement(document.getElementById(\"chatRoom"+chatRoomNum+"\"));" + 
				"function dragElement(elmnt) {" + 
				"  var pos1 = 0, pos2 = 0, pos3 = 0, pos4 = 0;" + 
				"  if (document.getElementById(\"roomInfo"+chatRoomNum+"\")) {" + 
				"    document.getElementById(\"roomInfo"+chatRoomNum+"\").onmousedown = dragMouseDown;" + 
				"  } else {" + 
				"    elmnt.onmousedown = dragMouseDown;" + 
				"  }" + 
				"  function dragMouseDown(e) {" + 
				"    e = e || window.event;" + 
				"    e.preventDefault();" + 
				"    pos3 = e.clientX;" + 
				"    pos4 = e.clientY;" + 
				"    document.onmouseup = closeDragElement;" + 
				"    document.onmousemove = elementDrag;" + 
				"  }" + 
				"  function elementDrag(e) {" + 
				"    e = e || window.event;" + 
				"    e.preventDefault();" + 
				"    pos1 = pos3 - e.clientX;" + 
				"    pos2 = pos4 - e.clientY;" + 
				"    pos3 = e.clientX;" + 
				"    pos4 = e.clientY;" + 
				"    elmnt.style.top = (elmnt.offsetTop - pos2) + \"px\";" + 
				"    elmnt.style.left = (elmnt.offsetLeft - pos1) + \"px\";" + 
				"  }" + 
				"  function closeDragElement() {" + 
				"    document.onmouseup = null;" + 
				"    document.onmousemove = null;" + 
				"  }" + 
				"}</script>";
	}
	public String writeResponse(String name,String content,String time2,String sessionName) {
		if(!name.equals(sessionName))
			return "<div class = \'chatConThumb\'><img src = \'resources/img/thumb.jpg\'></div>"
					+	"<div class = \'chatMsg\'>"
					+ 		"<div class=\'chatConDiv\'>"
					+			"<span class=\'chatM\'>"+name+"</span><br>"
					+			"<span class=\'chatCon\'>"+content+"</span>"
					+			"<span class=\'chatT\'>"+time2+"</span>"
					+		"</div>"
					+	"</div>";
		else
			return  "<div class = \'myChatConThumb\'><img src = \'resources/img/thumb.jpg\'></div>"
					+"<div class = \'myMsg\'>"
					+	"<div class=\'myConDiv\'>"
					+		"<span class=\'myChatM\'>나</span><br>"
					+		"<span class =\'myChatT\'>"+time2+"</span>"
					+		"<span class = \'myChatCon\'>"+content+"</span>"
					+	"</div>"
					+"</div>";
	}
	public String friendInfo(MemberDTO memberDTO,String name) {
		friendInfoName = memberDTO.getName()+"_"+memberDTO.getId();
		if(!friendInfoName.equals(name))
			return "<div class = 'friendInfo' id = 'friendInfo'>" + 
					"<img id = 'minimiInfo' src = 'resources/img/minimi.png' onclick = 'minimiInfo();'>" +
					"<div align='center'><h3>친구정보</h3></div>" + 
					"<div align = 'center' class = 'friendThumb'><img src = 'resources/img/thumb.jpg'></div>" + 
					"<div align = 'center' class = 'friendNameDiv'><span class = 'friendName'>"+friendInfoName+"</span></div>" + 
					"<div align = 'center' class = 'friendEmailDiv'><span class = 'friendEmail'>"+memberDTO.getEmail()+"</span><br></div>" + 
					"<div align='center' class = 'friendInfoBtn'>" + 
						"<button class = 'sendNoteBtn' onclick=\"sendNote('"+friendInfoName+"');\">쪽지보내기</button>" + 
						"<button class = 'deleteFriendBtn' onclick=\"deleteFriend('"+friendInfoName+"');\">친구삭제</button>" + 
					"</div>" + 
				"</div>";
		else
			return "<div class = 'friendInfo' id='friendInfo'>" + 
			"<img id = 'minimiInfo' src = 'resources/img/minimi.png' onclick = 'minimiInfo();'>" +
			"<div align='center'><h3>친구정보</h3></div>" + 
			"<div align = 'center' class = 'friendThumb'><img src = 'resources/img/thumb.jpg'></div>" + 
			"<div align = 'center' class = 'friendNameDiv'><span class = 'friendName'>"+friendInfoName+"</span></div>" + 
			"<div align = 'center' class = 'friendEmailDiv'><span class = 'friendEmail'>"+memberDTO.getEmail()+"</span><br></div>" + 
			"<div align='center' class = 'friendInfoBtn'>" + 
			"<button class = 'sendNoteBtn' onclick=\"sendNote('"+friendInfoName+"');\" disabled = 'disabled'>쪽지보내기</button>" + 
			"<button class = 'deleteFriendBtn' onclick=\"deleteFriend('"+friendInfoName+"');\" disabled = 'disabled'>친구삭제</button>" + 
			"</div>" + 
			"</div>";
	}
}
