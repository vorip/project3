package com.rt.travel.chat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.travel.chat.dao.ChatDAO;
import com.rt.travel.chatContent.dto.ChatContentDTO;
import com.rt.travel.chatRoom.dto.ChatRoomDTO;
import com.rt.travel.friend.dto.FriendDTO;
import com.rt.travel.member.dao.MemberDAOImpl;

@Service
public class ChatReadServiceImpl implements ChatReadService {

	private String roomNums;
	private String openSocket;
	private String menuTypeHtml;
	private List<ChatRoomDTO> list_room;
	private String content;
	private String contentTime;
	private String menuListHtml;
	private String contentTime2;
	private String[] contentTime_;
	private List<FriendDTO> list_friend;
	private String name;
	private String email;

	private ChatRoomDTO chatRoomDTO;
	private ChatContentDTO chatContentDTO;
	private FriendDTO friendDTO;

	@Autowired
	private ChatDAO chatDAO;
	@Autowired
	private MemberDAOImpl memberDAO;

	@Override
	public String getChat(String member) {
		return "<div id=\"chatDiv\" style=\"border-radius: 25px;background: white;position : fixed;right : 30px;bottom : 30px;width : 345px;height : 500px;\">"
				+ "<div id = \"menuDiv\" style = \"width: 65px;height: 500px;position: absolute;padding-top: 50px;padding-left: 7px;background: #edebeb;border-radius: 10px;box-shadow: 1px 1px 5px;\">"
				+ "<img id = \'friend\' src=\'resources/img/friend.png\'>"
				+ "<img id = \'chatImg\' src=\'resources/img/malpung.png\' style = \'margin-top : 20px;\'>" + "</div>"
				+ "<div id = \"contentListDiv\" style= \"position : fixed;right : 30px;bottom : 30px;width : 280px;height : 500px;\">"
				+ "<div id = \"menuType\" style=\"padding-top : 25px;padding-left : 10px;width: 280px;position: absolute;height: 90px;background: #555a9c;border-radius: 10px 10px 10px 10px;box-shadow : 0px 0px 3px;\">"
				+ getMenuType("채팅") + "</div>"
				+ "<div id = \"menuContent\" style=\"overflow : auto; position : fixed; width:280px; height : 410px; right : 30px;bottom : 30px;\">"
				+ "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>"
				+ "<script type = \"text/javascript\" src = \"resources/js/chat.js\"></script>"
				+ getMenuContent_chat(member) + openSocket + "</div>" + "</div>" + "</div>";
	}

	@Override
	public String getMenuType(String menuType) {
		menuTypeHtml = "<span id = \'typeName\'style = \'color: white;font-size : 21px; font-weight : bold;\'>" + menuType
				+ "</span><br>"
				+ "<span id = \'noteInfo\'></span><button id = 'note' onclick = \"noteList('');\">쪽지</button>"
				+ "<img id = \'minimiChat\' src=\'resources/img/minimi.png\'>";
		return menuTypeHtml;
	}

	@Override
	public String getMenuContent_chat(String member) {
		openSocket = "";
		chatDAO.deleteRoom();
		list_room = chatDAO.selectRooms(member);
		int divPositionVal = 335;
		int divHeight = 60;
		menuListHtml = "";
		// websocket에서 open시킬 채팅방 번호목록을 저장시킬 변수
		roomNums = "";
		for (int i = 0; i < list_room.size(); i++) {
			chatRoomDTO = list_room.get(i);
			chatContentDTO = chatDAO.getContent(chatRoomDTO.getchatRoomNum());
			content = "";
			contentTime = "";
			contentTime2 = "";
			roomNums += chatRoomDTO.getchatRoomNum() + ",";
			if (chatContentDTO != null) {
				// open시킬 채팅방 번호목록 저장하는부분
				contentTime_ = chatContentDTO.getContentTime().split(" ");
				contentTime = contentTime_[0];
				contentTime2 = contentTime_[1];
				contentTime_ = contentTime.split("-");
				contentTime = contentTime_[1] + "월" + contentTime_[2] + "일";
				contentTime_ = contentTime2.split(":");
				contentTime2 = contentTime_[0] + "시" + contentTime_[1] + "분";
				content = chatContentDTO.getContent();
			}
			menuListHtml += "<div class = \"rooms\" style=\"width : 263px; height : 60px;\">"
					+ "<input type = \'hidden\' value=\'" + chatRoomDTO.getchatRoomNum() + "\'>"
					+ "<div class=\'thumbnail\' style=\'float : left;padding : 5px;width : 55px; height : 50px; bottom : "
					+ (divPositionVal - i * divHeight) + "px;\'>" + "<img src=\'resources/img/"
					+ chatRoomDTO.getThumbnail() + "\'>" + "</div>"
					+ "<div class=\'roomName\' style=\'float : left;padding : 5px;width : 123px;bottom : "
					+ (divPositionVal - i * divHeight) + "px; height : 50px;'>"
					+ "<span style=\'font-size : 13px;font-weight : bold;font-family: 맑은고딕;\'>" + chatRoomDTO.getchatRoomName()
					+ "</span>" + "<span style=\'font-size : 10px;font-family: 맑은고딕;margin-left : 10px;\'>"
					+ chatRoomDTO.getLimitMember() + "</span><br>" + "<span id=\'" + chatRoomDTO.getchatRoomNum()
					+ "\'style=\'font-size : 12px;font-family: 맑은고딕; color : #666562;\'>" + content + "</span>" + "</div>"
					+ "<div class=\'time\' style=\'float : left;padding : 5px;width : 55px; bottom : "
					+ (divPositionVal - i * divHeight) + "px;height : 50px;\'>" + "<span id=\'t1"
					+ chatRoomDTO.getchatRoomNum() + "\' style=\'font-size : 8px;font-family: 맑은고딕; color:#b5b1a7;\'>" + contentTime
					+ "</span><br>" + "<span id=\'t2" + chatRoomDTO.getchatRoomNum()
					+ "\' style=\'font-size : 8px;font-family: 맑은고딕; color:#b5b1a7;\'>" + contentTime2 + "</span>" + "</div>" + "</div>";
		}
		if (list_room.size() > 0)
			openSocket = "<script>roomNumsSetting(\'" + roomNums.substring(0, roomNums.length() - 1) + "\')</script>";
		return menuListHtml;
	}

	@Override
	public String getMenuContent_friend(String name) {
		list_friend = memberDAO.friendList(name);
		int divPositionVal = 335;
		int divHeight = 60;
		menuListHtml = "";
		if (list_friend != null) {
			for (int i = 0; i < list_friend.size(); i++) {
				friendDTO = list_friend.get(i);
				if (friendDTO.getAuth() != 'X') {
					if (!name.equals(friendDTO.getFriendName()))
						this.name = friendDTO.getFriendName();
					else
						this.name = friendDTO.getMyName();
					this.email = memberDAO.selectEmail((this.name).split("_")[1]).getEmail();
					setMenuListHtml(divPositionVal - i * divHeight, this.name, this.email);
				}
			}
		}
		return menuListHtml;
	}

	@Override
	public void setMenuListHtml(int divStyle, String name, String email) {
		menuListHtml += "<div class = \"friends\" onclick=\'\' style=\"width : 263px; height : 60px;\">"
				+ "<div class=\'thumbnail\' style=\'float : left;padding : 5px;width : 55px; height : 50px; bottom : "
				+ divStyle + "px;\'>"
				// 나중에 member테이블의 thumbnail로 교체
				+ "<img src=\'resources/img/thumb.jpg\'>" + "</div>"
				+ "<div class=\'roomName\' style=\'float : left;padding : 5px;width : 123px;bottom : " + divStyle
				+ "px; height : 50px;\'>" + "<span class=\'names\'style=\'font-size : 15px; font-weight : bold;\'>"
				+ name + "</span><br>" + "<span style=\'font-size : 14px; color : #666562;\'>" + email + "</span>"
				+ "</div>" + "<div class=\'time\' style=\'float : left;padding : 5px;width : 55px; bottom : " + divStyle
				+ "px;height : 50px;\'>" + "</div>" + "</div>";
	}
}
