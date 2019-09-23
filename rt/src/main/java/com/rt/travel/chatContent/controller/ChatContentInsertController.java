package com.rt.travel.chatContent.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rt.travel.chatContent.dto.ChatContentDTO;
import com.rt.travel.chatContent.service.ChatContentInsertService;

@Controller
public class ChatContentInsertController {

	@Autowired
	ChatContentInsertService chatContentInsertService;
	
	@RequestMapping("addContent")
	public String addContent(ChatContentDTO chatContentDTO,Model model,HttpSession session) {
		model.addAttribute("result",chatContentInsertService.addContent(chatContentDTO,(String)session.getAttribute("name"))+"{}"+(String)session.getAttribute("name"));
		return "ajax/ajaxResult";
	}
	@RequestMapping("writeResponse")
	public String writeResponse(String name,String content,String time2,Model model,HttpSession session) {
		model.addAttribute("result",chatContentInsertService.writeResponse(name, content, time2,(String)session.getAttribute("name")));
		return "ajax/ajaxResult";
	}
}
