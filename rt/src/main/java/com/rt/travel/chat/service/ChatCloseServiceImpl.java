package com.rt.travel.chat.service;

import org.springframework.stereotype.Service;

@Service
public class ChatCloseServiceImpl implements ChatCloseService {

	@Override
	public String chatClose(String name) {
		return "<img id='getChat'onclick = \"getChat();\" src = \"resources/img/logo.png\">";
	}
}
