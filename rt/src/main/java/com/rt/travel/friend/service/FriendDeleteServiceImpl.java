package com.rt.travel.friend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.travel.friend.dto.FriendDTO;
import com.rt.travel.member.dao.MemberDAOImpl;

@Service
public class FriendDeleteServiceImpl implements FriendDeleteService {
	private FriendDTO friendDTO;
	
	@Autowired
	private MemberDAOImpl memberDAO;

	@Override
	public void deleteFriend(String name,String friendName) {
		friendDTO = new FriendDTO();
		friendDTO.setMyName(name);
		friendDTO.setFriendName(friendName);
		memberDAO.deleteFriend(friendDTO);
	}
}
