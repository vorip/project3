package com.rt.travel.note.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.travel.chat.dao.ChatDAO;
import com.rt.travel.chatRoom.dto.ChatRoomDTO;
import com.rt.travel.friend.dto.FriendDTO;
import com.rt.travel.member.dao.MemberDAOImpl;
import com.rt.travel.note.dao.NoteDAO;
import com.rt.travel.note.dto.NoteDTO;

@Service
public class NoteWriteServiceImpl implements NoteWriteService {
	
	NoteDTO noteDTO;
	ChatRoomDTO chatRoomDTO;
	private FriendDTO friendDTO;

	@Autowired
	NoteDAO noteDAO;
	@Autowired
	ChatDAO chatDAO;
	@Autowired
	MemberDAOImpl memberDAO;
	
	@Override
	public void friendApply(String myName,String friendName) {
		friendDTO = new FriendDTO();
		friendDTO.setAuth('X');
		friendDTO.setFriendName(friendName);
		friendDTO.setFriendId(friendName.split("_")[1]);
		friendDTO.setMyName(myName);
		friendDTO.setMyId(myName.split("_")[1]);
		memberDAO.addFriend(friendDTO);
		friendApplyNote(friendName,myName);
	}
	private void friendApplyNote(String me,String other) {
		noteDTO = new NoteDTO();
		noteDTO.setMe(me);
		noteDTO.setOther(other);
		noteDTO.setContent(other+"님이 친구신청을 보냈습니다.");
		noteDTO.setNoteType('X');
		noteDTO.setApplyType('f');
		noteDAO.send(noteDTO);
	}
	@Override
	public String sendNoteDiv(String meName) {
		return "<div id = 'sendNoteDiv'>" +
				"	<div id = 'sendNoteDiv1'>"+ 
				"		<img id = 'minimiNote' onclick = 'minimiNote()' src = 'resources/img/minimi.png'>" +
				"		<h3 style = 'margin-left : 15px;'>쪽지보내기</h3>" + 
				"	</div>"+
				"			<span style = 'margin-left : 15px;' id = 'meNameSpan'>받는사람 : "+meName+"</span><br>" + 
				"		<div id = 'contentBox' align=\"center\">" +
				"			<textarea id='noteContent' rows=\"20\" cols=\"40\"></textarea>" + 
				"		</div>" + 
				"		<input id = 'meName' type = 'hidden' value = '"+meName+"'><br>" + 
				"		<button id = 'sendNote' style = 'margin-right : 15px; float:right;' onclick='sendNote();' type = 'button'>전송</button>" + 
				"</div>";
	}
	
	@Override
	public void noteSend(NoteDTO noteDTO,String name) {
		noteDTO.setNoteType('O');
		noteDTO.setApplyType('m');
		noteDTO.setOther(name);
		noteDAO.send(noteDTO);
	}
	@Override
	public char companionApply(String me,int chatRoomNum,String other) {
		chatRoomDTO = new ChatRoomDTO();
		chatRoomDTO.setchatRoomNum(chatRoomNum);
		chatRoomDTO.setMembers(other);
		if(chatDAO.isMembers(chatRoomDTO)==0) {
			noteDTO = new NoteDTO();
			noteDTO.setMe(me);
			noteDTO.setOther(other+"<>"+chatRoomNum);
			noteDTO.setApplyType('c');
			if(noteDAO.isApplyCompanion(noteDTO)==0) {
				noteDTO.setNoteType('X');
				noteDTO.setContent(other+"님이 동행자요청을 보내셨습니다.");
				noteDAO.send(noteDTO);
				return 'O';
			}else {
				return 'X';
			}
		}else {
			return 'X';
		}
	}
}
