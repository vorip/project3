package com.rt.travel.friend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rt.travel.friend.service.FriendDeleteService;

@Controller
public class FriendDeleteController {
	
	@Autowired
	FriendDeleteService friendDeleteService;

	@RequestMapping("deleteFriend")
	public String deleteFriend(String name,HttpSession session) {
		friendDeleteService.deleteFriend((String)session.getAttribute("name"),name);
		return "ajax/ajaxResult";
	}
}
