package com.rt.travel.chat.dao;

import java.util.List;

import com.rt.travel.chat.dto.ChatContentDTO;
import com.rt.travel.chat.dto.ChatRoomDTO;

public interface ChatDAO {

	//채팅방관련 DB처리
	void createRoom(ChatRoomDTO chatRoomDTO);

	void reNameRoom(ChatRoomDTO chatRoomDTO);

	List<ChatRoomDTO> selectRooms(String member);

	ChatRoomDTO selectRoom(int chatRoomNum);

	void deleteRoom();

	//채팅내용관련 DB처리
	void addContent(ChatContentDTO chatContentDTO);

	ChatContentDTO getContent(int chatRoomNum);

	List<ChatContentDTO> getContents(int chatRoomNum);

	void deleteContent(String member);

	List<Integer> selectRoomNums(String name);
	
	ChatRoomDTO select(String leader);
}