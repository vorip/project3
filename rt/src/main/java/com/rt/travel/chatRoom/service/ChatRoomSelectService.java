package com.rt.travel.chatRoom.service;

import com.rt.travel.chatContent.dto.ChatContentDTO;

public interface ChatRoomSelectService {

	String getEachChat(String name, int chatRoomNum);

	String notice(int chatRoomNum);

	String roomInfo(int chatRoomNum);

	String chatRoomCon(ChatContentDTO chatContentDTO, String name);

	String chatRoomScript(int chatRoomNum);

}