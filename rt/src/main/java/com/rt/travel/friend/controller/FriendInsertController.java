package com.rt.travel.friend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rt.travel.friend.service.FriendInsertService;

@Controller
public class FriendInsertController {
	
	@Autowired
	FriendInsertService friendInsertService;

	@RequestMapping("addFriend")
	public String addFriend(Model model) {
		model.addAttribute("result",friendInsertService.addFriend());
		return "ajax/ajaxResult";
	}
}
