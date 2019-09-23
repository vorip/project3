package com.rt.travel.chat.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rt.travel.chat.service.ChatCloseService;

@Controller
public class ChatCloseController {
	
	@Autowired
	ChatCloseService chatCloseService;
	
	@RequestMapping("chatClose")
	public String chatClose(Model model,HttpSession session) {
		model.addAttribute("result", chatCloseService.chatClose((String)session.getAttribute("name")));
		return "ajax/ajaxResult";
	}
}
