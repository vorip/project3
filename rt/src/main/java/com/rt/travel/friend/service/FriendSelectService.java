package com.rt.travel.friend.service;

import com.rt.travel.member.dto.MemberDTO;

public interface FriendSelectService {

	String searchFriendResult(String id, String name);

	String searchResult(MemberDTO memberDTO, String isFriend);

	String friendInfo(String friendName, String name);

	String friendInfoHtml(MemberDTO memberDTO, String name);

}