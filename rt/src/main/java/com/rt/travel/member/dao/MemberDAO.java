package com.rt.travel.member.dao;

import java.util.List;

import com.rt.travel.chat.dto.FriendDTO;
import com.rt.travel.member.dto.MemberDTO;

public interface MemberDAO {

	void insert(MemberDTO memberDTO);

	MemberDTO select(String inputId);

	int selectCnt(MemberDTO memberDTO);

	int selectCnt2(MemberDTO memberDTO);

	int selectCnt3(String inputId);

	MemberDTO selectId(MemberDTO memberDTO);

	MemberDTO selectPw(MemberDTO memberDTO);

	void update(String id);

	void updatePw(MemberDTO memberDTO);

	void updateAll(MemberDTO memberDTO);

	void delete(String inputId);

	List<MemberDTO> selectAll();

	void userAuth(String email);

	List<FriendDTO> friendList(String myName);

	void addFriend(FriendDTO friendDTO);

	void deleteFriend(FriendDTO friendDTO);


	MemberDTO selectEmail(String id);

	int getIsFriend(FriendDTO friendDTO);

}