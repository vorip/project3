package com.rt.travel.chatContent.service;

import com.rt.travel.chatContent.dto.ChatContentDTO;

public interface ChatContentInsertService {

	String addContent(ChatContentDTO chatContentDTO, String name);

	String chatRoomCon(ChatContentDTO chatContentDTO, String name);

	String writeResponse(String name, String content, String time2, String sessionName);

}