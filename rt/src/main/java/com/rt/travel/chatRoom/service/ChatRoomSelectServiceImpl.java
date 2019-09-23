package com.rt.travel.chatRoom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.travel.chat.dao.ChatDAO;
import com.rt.travel.chatContent.dto.ChatContentDTO;
import com.rt.travel.chatRoom.dto.ChatRoomDTO;

@Service
public class ChatRoomSelectServiceImpl implements ChatRoomSelectService {

	private String contentTime2;
	private String[] contentTime_;
	private String roomInfoHtml;
	private List<ChatContentDTO> list_content;
	private String eachHtml;
	
	private ChatContentDTO chatContentDTO;
	private ChatRoomDTO chatRoomDTO;

	@Autowired
	private ChatDAO chatDAO;
	
	@Override
	public String getEachChat(String name,int chatRoomNum) {
		eachHtml = "";
		list_content = chatDAO.getContents(chatRoomNum);
		eachHtml += "<div class = \'chatRoom\'id = \'chatRoom" + chatRoomNum + "\'>" + chatRoomScript(chatRoomNum)
				+ "<div class = \'roomInfo\' id = \'roomInfo" + chatRoomNum + "\'>" + roomInfo(chatRoomNum) + "</div>"
				+ "<div class = \'notice\'>" + notice(chatRoomNum) + "</div>" + "<div id = \'roomContent" + chatRoomNum
				+ "\' class = \'roomContent\'>";
		if (list_content != null) {
			for (int i = 0; i < list_content.size(); i++) {
				chatContentDTO = list_content.get(i);
				eachHtml += chatRoomCon(chatContentDTO, name);
			}
		}
		eachHtml += "</div><div class = \'addContentDiv\'>" + "<textarea id = \'textA" + chatRoomNum
				+ "\'class = \'textA\' cols=\'30\' rows=\'5\'></textarea>" + "<button id = \'addCon" + chatRoomNum
				+ "\' value = \'" + chatRoomNum + "\'class = \'addCon\'disabled=\'disabled\'>전송</button>"
				+ "</div></div>";
		return eachHtml;
	}
	@Override
	public String notice(int chatRoomNum) {
		return "";
	}
	@Override
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
	
	@Override
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
	
	@Override
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
	
	
}
