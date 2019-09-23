package com.rt.travel.friend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.travel.friend.dto.FriendDTO;
import com.rt.travel.member.dao.MemberDAOImpl;

@Service
public class FriendUpdateServiceImpl implements FriendUpdateService {
	
	@Autowired
	MemberDAOImpl memberDAO;
	
	@Override
	public void acceptFriend(FriendDTO friendDTO) {
		friendDTO.setAuth('O');
		memberDAO.updateFriend(friendDTO);
	}
}
