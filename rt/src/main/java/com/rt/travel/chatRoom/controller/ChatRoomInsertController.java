package com.rt.travel.chatRoom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rt.travel.chatRoom.dto.ChatRoomDTO;
import com.rt.travel.chatRoom.service.ChatRoomInsertService;

@Controller
public class ChatRoomInsertController {
	
	ChatRoomInsertService chatRoomInsertService;
	
	@RequestMapping("createRoom")
	public String createRoom(ChatRoomDTO chatRoomDTO) {
		chatRoomInsertService.createRoom(chatRoomDTO);
		return "ajax/ajaxResult";
	}
}
