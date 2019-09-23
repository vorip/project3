package com.rt.travel.chatRoom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rt.travel.chatRoom.service.ChatRoomUpdateService;


@Controller
public class ChatRoomUpdateController {
	
	@Autowired
	private ChatRoomUpdateService chatRoomUpdateService;
	
	
	@RequestMapping("acceptCompanion")
	public String acceptCompanion(int chatRoomNum,String otherName) {
		chatRoomUpdateService.acceptCompanion(chatRoomNum, otherName);
		return "ajax/ajaxResult";
	}
}
