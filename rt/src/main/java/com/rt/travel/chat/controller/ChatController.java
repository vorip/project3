package com.rt.travel.chat.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rt.travel.chat.dto.ChatContentDTO;
import com.rt.travel.chat.dto.ChatRoomDTO;
import com.rt.travel.chat.service.ChatHtmlSetter;
import com.rt.travel.chat.service.ChatInterface;

@Controller
public class ChatController {
	
	@Autowired
	ChatInterface chat;
	@Autowired
	ChatHtmlSetter html;
	
	@RequestMapping("getChat")
	public String getChat(Model model,HttpSession session) {
		model.addAttribute("result",chat.getChat((String)session.getAttribute("name")));
		return "ajax/ajaxResult";
	}
	@RequestMapping("addContent")
	public String addContent(ChatContentDTO chatContentDTO,Model model,HttpSession session) {
		model.addAttribute("result",chat.addContent(chatContentDTO,(String)session.getAttribute("name"))+"{}"+(String)session.getAttribute("name"));
		return "ajax/ajaxResult";
	}
	@RequestMapping("menuChange_chat")
	public String menuChange_chat(Model model,HttpSession session) {
		model.addAttribute("result",chat.menuChange_chat((String)session.getAttribute("name")));
		return "ajax/ajaxResult";
	}
	@RequestMapping("menuChange_friend")
	public String menuChange_friend(Model model,HttpSession session) {
		model.addAttribute("result",chat.menuChange_friend((String)session.getAttribute("name")));
		return "ajax/ajaxResult";
	}
	@RequestMapping("eachRoom")
	public String eachRoom(Model model,HttpSession session,String chatRoomNum) {
		model.addAttribute("result",chat.getEachChat((String)session.getAttribute("name"), chatRoomNum));
		return "ajax/ajaxResult";
	}
	@RequestMapping("chatClose")
	public String chatClose(Model model,HttpSession session) {
		model.addAttribute("result", chat.chatClose((String)session.getAttribute("name")));
		return "ajax/ajaxResult";
	}
	@RequestMapping("addFriend")
	public String addFriend(Model model) {
		model.addAttribute("result",chat.addFriend());
		return "ajax/ajaxResult";
	}
	@RequestMapping("searchFriend")
	public String searchFriend(String id,Model model,HttpSession session) {
		model.addAttribute("result", chat.searchFriendResult(id,(String)session.getAttribute("name")));
		return "ajax/ajaxResult";
	}
	@RequestMapping("friendApply")
	public String friendApply(String myName,String friendName) {
		chat.friendApply(myName, friendName);
		return "ajax/ajaxResult";
	}
	@RequestMapping("createRoom")
	public String createRoom(ChatRoomDTO chatRoomDTO) {
		chat.createRoom(chatRoomDTO);
		return "ajax/ajaxResult";
	}
	@RequestMapping("companionApply")
	public String companionApply(String name,String leader) {
		chat.companionApply(name,leader);
		return "ajax/ajaxResult";
	}
	@RequestMapping("writeResponse")
	public String writeResponse(String name,String content,String time2,Model model,HttpSession session) {
		model.addAttribute("result",html.writeResponse(name, content, time2,(String)session.getAttribute("name")));
		return "ajax/ajaxResult";
	}
	@RequestMapping("friendInfo")
	public String friendInfo(String friendName,Model model,HttpSession session) {
		model.addAttribute("result", chat.friendInfo(friendName,(String)session.getAttribute("name")));
		return "ajax/ajaxResult";
	}
	@RequestMapping("deleteFriend")
	public String deleteFriend(String name,HttpSession session) {
		chat.deleteFriend((String)session.getAttribute("name"),name);
		return "ajax/ajaxResult";
	}
	
}
