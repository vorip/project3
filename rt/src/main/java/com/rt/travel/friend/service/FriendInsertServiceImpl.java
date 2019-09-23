package com.rt.travel.friend.service;

import org.springframework.stereotype.Service;

@Service
public class FriendInsertServiceImpl implements FriendInsertService {

	
	@Override
	public String addFriend() {
		return "<div id = \"addFriend\" align=\"center\">" + 
				"<div id = 'addFriend1'>"+
				"<img id = 'minimiAddFriend' onclick='minimiAddFriend();' src = 'resources/img/minimi.png'>"+
				"</div>"+
				"<input id=\"friendSearchInput\" type = \"text\"><button id = \"friendSearchButton\" onclick = \"searchFriend();\"type=\"button\">검색</button>" + 
				"<div id = \"friendSearchResult\">" + 
				"<span class = \"addFriendText\">아이디로 친구를 검색하세요</span><br>" + 
				"<span class = \"addFriendText2\">상대가 친구신청을 수락할 경우<br>친구목록에 추가됩니다.</span><br>" +
				"</div>" + 
				"</div>";
	}
}
