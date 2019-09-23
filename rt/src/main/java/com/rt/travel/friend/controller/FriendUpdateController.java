package com.rt.travel.friend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rt.travel.friend.dto.FriendDTO;
import com.rt.travel.friend.service.FriendUpdateService;

@Controller
public class FriendUpdateController {
	
	@Autowired
	FriendUpdateService friendUpdateService;
	
	@RequestMapping("acceptFriend")
	public String acceptFriend(FriendDTO friendDTO) {
		friendUpdateService.acceptFriend(friendDTO);
		return "ajax/ajaxResult";
	}
}
