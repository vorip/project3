package com.rt.travel.chat.service;

public interface ChatReadService {

	String getChat(String member);

	// chat의 menutype가져오는 메소드
	String getMenuType(String menuType);

	//chat의 menucontent가져오는 메소드
	String getMenuContent_chat(String member);

	String getMenuContent_friend(String name);

	void setMenuListHtml(int divStyle, String name, String email);

}