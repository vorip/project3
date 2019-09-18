package com.rt.travel.chat.service;

import com.rt.travel.chat.dto.ChatContentDTO;
import com.rt.travel.chat.dto.ChatRoomDTO;

public interface ChatInterface {
	
	String getChat(String member);
	
	String addContent(ChatContentDTO chatContentDTO,String name);
	
	void createRoom(ChatRoomDTO chatRoomDTO);
	
	String getEachChat(String name,String chatRoomNum);
	
	String menuChange_chat(String member);
	
	String menuChange_friend(String member);
	
	String chatClose(String name);
	
	String searchFriendResult(String id,String name);
	
	void friendApply(String myName,String friendName);
	
	String addFriend();
	
	void companionApply(String name,String leader);
	
	String friendInfo(String friendName,String name);
	
	void deleteFriend(String name,String friendName);
	
}
