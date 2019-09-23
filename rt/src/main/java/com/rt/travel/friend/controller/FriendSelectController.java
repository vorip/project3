package com.rt.travel.friend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rt.travel.friend.service.FriendSelectService;

@Controller
public class FriendSelectController {

	@Autowired
	FriendSelectService friendSelectService;
	
	@RequestMapping("searchFriend")
	public String searchFriend(String id,Model model,HttpSession session) {
		model.addAttribute("result", friendSelectService.searchFriendResult(id,(String)session.getAttribute("name")));
		return "ajax/ajaxResult";
	}
	@RequestMapping("friendInfo")
	public String friendInfo(String friendName,Model model,HttpSession session) {
		model.addAttribute("result", friendSelectService.friendInfo(friendName,(String)session.getAttribute("name")));
		return "ajax/ajaxResult";
	}
}
