package com.rt.travel.chat.service;


import org.springframework.beans.factory.annotation.Autowired;

import com.rt.travel.chat.dao.ChatDAO;
import com.rt.travel.chat.dto.ChatContentDTO;
import com.rt.travel.chat.dto.ChatRoomDTO;
import com.rt.travel.chat.dto.FriendDTO;
import com.rt.travel.member.dao.MemberDAO;
import com.rt.travel.member.dto.MemberDTO;

public class ChatService implements ChatInterface{
	
	private MemberDTO memberDTO;
	private FriendDTO friendDTO;
	private String friendName;
	
	@Autowired
	private ChatHtmlSetter html;
	@Autowired
	private ChatDAO chatDAO;
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public String addContent(ChatContentDTO chatContentDTO,String name) {
		chatContentDTO.setMember(name);
		chatDAO.addContent(chatContentDTO);
		chatContentDTO = chatDAO.getContent(chatContentDTO.getChatRoomNum());
		return html.chatRoomCon(chatContentDTO,name);
	}

	@Override
	public void createRoom(ChatRoomDTO chatRoomDTO) {
		chatRoomDTO.setThumbnail("thumb.jpg");
		chatDAO.createRoom(chatRoomDTO);
	}
	
	@Override
	public String getEachChat(String name,String chatRoomNum) {
		return html.eachChat(name, Integer.parseInt(chatRoomNum));
	}
	@Override
	public String menuChange_chat(String member) {
		return html.getMenuContent_chat(member);
	}
	@Override
	public String getChat(String member) {
		return html.getChat(member);
	}

	@Override
	public String menuChange_friend(String member) {
		return html.getMenuContent_friend(member);
	}
	
	@Override
	public String chatClose(String name) {
		return "<img id='getChat'onclick = \"getChat();\" src = \"resources/img/logo.png\">";
	}
	
	@Override
	public String searchFriendResult(String id,String name) {
		memberDTO = memberDAO.select(id);
		friendDTO = new FriendDTO();
		friendDTO.setMyName(name);
		if(memberDTO!=null) {
			friendName = memberDTO.getName()+"_"+memberDTO.getId();
			friendDTO.setFriendName(friendName);
			if(memberDAO.getIsFriend(friendDTO)==0&&!name.equals(friendName))
					return html.searchResult(memberDTO,"<button onclick = \'addFriendButton("+name+","+(friendName)+");\' type = \"button\" id = \"addFriendButton\">친구추가</button>"+
						"<br><button type = \"button\" onclick = \'exitAddFriend();\' id =\"exitAddFriendButton\">나가기</button>");
			else
				return html.searchResult(memberDTO,"<span class = \'addFriendText3\'>이미 친구입니다</span>"+
						"<br><button type = \"button\" onclick = \'exitAddFriend();\' id =\"exitAddFriendButton\">나가기</button>");
		}else {
			return "<span class = \"addFriendText\">"+id+"</span><br>" + 
					"<span class = \"addFriendText\">님을 찾을 수 없습니다.</span><br>" + 
					"<span class = \"addFriendText2\">입력하신 ID는 등록된 회원이 아닙니다.</span>"+
					"<button type = \"button\" onclick = \'exitAddFriend();\' id =\"exitAddFriendButton\">나가기</button>";
		}
	}
	@Override
	public void friendApply(String myName,String friendName) {
		friendDTO = new FriendDTO();
		friendDTO.setAuth('X');
		friendDTO.setFriendName(friendName);
		friendDTO.setFriendId(friendName.split("_")[1]);
		friendDTO.setMyName(myName);
		friendDTO.setMyId(myName.split("_")[1]);
		memberDAO.addFriend(friendDTO);
	}
	
	@Override
	public String addFriend() {
		return "<div id = \"addFriend\" align=\"center\">" + 
				"<input id=\"friendSearchInput\" type = \"text\"><button id = \"friendSearchButton\" onclick = \"searchFriend();\"type=\"button\">검색</button>" + 
				"<div id = \"friendSearchResult\">" + 
				"<span class = \"addFriendText\">아이디로 친구를 검색하세요</span><br>" + 
				"<span class = \"addFriendText2\">상대가 친구신청을 수락할 경우<br>친구목록에 추가됩니다.</span><br>" +
				"<button type = \"button\" onclick = \'exitAddFriend();\' id =\"exitAddFriendButton\">나가기</button>"+
				"</div>" + 
				"</div>";
	}
	@Override
	public void companionApply(String name,String leader) {
		memberDTO = memberDAO.selectEmail(leader.split("_")[1]);
	}
	
	@Override
	public String friendInfo(String friendName,String name) {
		return html.friendInfo(memberDAO.select(friendName.split("_")[1]),name); 
	}
	
	@Override
	public void deleteFriend(String name,String friendName) {
		friendDTO = new FriendDTO();
		friendDTO.setMyName(name);
		friendDTO.setFriendName(friendName);
		memberDAO.deleteFriend(friendDTO);
	}
	

}
