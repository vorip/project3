package com.rt.travel.chatRoom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.travel.chat.dao.ChatDAO;
import com.rt.travel.chatRoom.dto.ChatRoomDTO;
import com.rt.travel.course.dao.TypeADAO;
import com.rt.travel.course.dto.TypeADTO;

@Service
public class ChatRoomUpdateServiceImpl implements ChatRoomUpdateService {

	
	private ChatRoomDTO chatRoomDTO;

	@Autowired
	private ChatDAO chatDAO;
	@Autowired
	private TypeADAO typeADAO;
	
	@Override
	public void acceptCompanion(int chatRoomNum,String otherName) {
		chatRoomDTO = new ChatRoomDTO();
		chatRoomDTO.setMembers(chatDAO.selectRoom(chatRoomNum).getMembers()+","+otherName);
		chatRoomDTO.setchatRoomNum(chatRoomNum);
		chatDAO.acceptCompanion(chatRoomDTO);
		typeADAO.addCurrentMem(chatRoomNum);
	}
}
