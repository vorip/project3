package com.rt.travel.chatContent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.travel.chat.dao.ChatDAO;
import com.rt.travel.chatContent.dto.ChatContentDTO;

@Service
public class ChatContentInsertServiceImpl implements ChatContentInsertService {

	private String contentTime2;
	private String[] contentTime_;

	@Autowired
	ChatDAO chatDAO;

	@Override
	public String addContent(ChatContentDTO chatContentDTO, String name) {
		chatContentDTO.setMember(name);
		chatDAO.addContent(chatContentDTO);
		chatContentDTO = chatDAO.getContent(chatContentDTO.getChatRoomNum());
		return chatRoomCon(chatContentDTO, name);
	}

	@Override
	public String chatRoomCon(ChatContentDTO chatContentDTO, String name) {
		contentTime2 = "";
		contentTime_ = chatContentDTO.getContentTime().split(" ");
		contentTime2 = contentTime_[1];
		contentTime_ = contentTime2.split(":");
		contentTime2 = contentTime_[0] + "시" + contentTime_[1] + "분";
		// memberThumb
		if (!name.equals(chatContentDTO.getMember()))
			return "<div class = \'chatConThumb\'><img src = \'resources/img/thumb.jpg\'></div>"
					+ "<div class = \'chatMsg\'>" + "<div class=\'chatConDiv\'>" + "<span class=\'chatM\'>"
					+ chatContentDTO.getMember() + "</span><br>" + "<span class=\'chatCon\'>"
					+ chatContentDTO.getContent() + "</span>" + "<span class=\'chatT\'>" + contentTime2 + "</span>"
					+ "</div>" + "</div>";
		else
			return "<div class = \'myChatConThumb\'><img style = 'float:right;'src = \'resources/img/thumb.jpg\'></div>"
					+ "<div class = \'myMsg\'>" + "<div class=\'myConDiv\'>" + "<span class=\'myChatM\'>나</span><br>"
					+ "<span class =\'myChatT\'>" + contentTime2 + "</span>" + "<span class = \'myChatCon\'>"
					+ chatContentDTO.getContent() + "</span>" + "</div>" + "</div>";
	}

	@Override
	public String writeResponse(String name, String content, String time2, String sessionName) {
		if (!name.equals(sessionName))
			return "<div class = \'chatConThumb\'><img src = \'resources/img/thumb.jpg\'></div>"
					+ "<div class = \'chatMsg\'>" + "<div class=\'chatConDiv\'>" + "<span class=\'chatM\'>" + name
					+ "</span><br>" + "<span class=\'chatCon\'>" + content + "</span>" + "<span class=\'chatT\'>"
					+ time2 + "</span>" + "</div>" + "</div>";
		else
			return "<div class = \'myChatConThumb\'><img src = \'resources/img/thumb.jpg\'></div>"
					+ "<div class = \'myMsg\'>" + "<div class=\'myConDiv\'>" + "<span class=\'myChatM\'>나</span><br>"
					+ "<span class =\'myChatT\'>" + time2 + "</span>" + "<span class = \'myChatCon\'>" + content
					+ "</span>" + "</div>" + "</div>";
	}
}