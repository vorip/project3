package com.rt.travel.chat.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.rt.travel.chat.dto.ChatContentDTO;
import com.rt.travel.chat.dto.ChatRoomDTO;


public class ChatDAOImpl implements ChatDAO {
	
	@Autowired
	SqlSessionTemplate mybatis;
	
	//채팅방관련 DB처리
	@Override
	public void createRoom(ChatRoomDTO chatRoomDTO) {
		mybatis.insert("chatDAO.createRoom",chatRoomDTO);
	}
	@Override
	public void reNameRoom(ChatRoomDTO chatRoomDTO) {
		mybatis.update("chatDAO.reNameRoom", chatRoomDTO);
	}
	@Override
	public List<ChatRoomDTO> selectRooms(String member) {
		return mybatis.selectList("chatDAO.selectRooms","%" + member + "%");
	}
	@Override
	public ChatRoomDTO selectRoom(int chatRoomNum) {
		return mybatis.selectOne("chatDAO.selectRoom",chatRoomNum);
	}
	@Override
	public void deleteRoom() {
		mybatis.delete("chatDAO.deleteRoom");
	}
	//채팅내용관련 DB처리
	@Override
	public void addContent(ChatContentDTO chatContentDTO) {
		mybatis.insert("chatDAO.addContent", chatContentDTO);
	}
	@Override
	public ChatContentDTO getContent(int chatRoomNum) {
		return mybatis.selectOne("chatDAO.getContent",chatRoomNum);
	}
	@Override
	public List<ChatContentDTO> getContents(int chatRoomNum) {
		return mybatis.selectList("chatDAO.getContents",chatRoomNum);
	}
	@Override
	public void deleteContent(String member) {
		mybatis.delete("chatDAO.deleteContent", member);
	}
	@Override
	public List<Integer> selectRoomNums(String name){
		return mybatis.selectList("chatDAO.selectRoomNums",name);
	}
	@Override
	public ChatRoomDTO select(String leader) {
		return mybatis.selectOne("chatroomDAO.select",leader);
	}
}
