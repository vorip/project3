package com.rt.travel.chat.dao;

import java.util.List;

import com.rt.travel.chatContent.dto.ChatContentDTO;
import com.rt.travel.chatRoom.dto.ChatRoomDTO;

public interface ChatDAO {

	void createRoom(ChatRoomDTO chatRoomDTO);

	List<ChatRoomDTO> selectRooms(String member);

	ChatRoomDTO selectRoom(int chatRoomNum);

	void deleteRoom();

	void addContent(ChatContentDTO chatContentDTO);

	ChatContentDTO getContent(int chatRoomNum);

	List<ChatContentDTO> getContents(int chatRoomNum);

	void deleteContent(String member);

	List<Integer> selectRoomNums(String name);

	void acceptCompanion(ChatRoomDTO chatRoomDTO);

	int isMembers(ChatRoomDTO chatRoomDTO);

	List<Integer> selectChatRoomNums();
	
	List<ChatRoomDTO> chatSelectAll();
}