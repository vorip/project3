package com.rt.travel.chatRoom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.travel.chat.dao.ChatDAO;
import com.rt.travel.chatRoom.dto.ChatRoomDTO;

@Service
public class ChatRoomInsertServiceImpl implements ChatRoomInsertService {

	@Autowired
	ChatDAO chatDAO;
	
	@Override
	public void createRoom(ChatRoomDTO chatRoomDTO) {
		chatRoomDTO.setThumbnail("thumb.jpg");
		chatDAO.createRoom(chatRoomDTO);
	}
}
