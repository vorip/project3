package com.rt.travel.chatRoom.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rt.travel.chatRoom.service.ChatRoomSelectService;

@Controller
public class ChatRoomSelectController {
	@Autowired
	ChatRoomSelectService chatRoomSelectService;

	@RequestMapping("eachRoom")
	public String eachRoom(Model model,HttpSession session,String chatRoomNum) {
		model.addAttribute("result",chatRoomSelectService.getEachChat((String)session.getAttribute("name"),Integer.parseInt(chatRoomNum)));
		return "ajax/ajaxResult";
	}
}
