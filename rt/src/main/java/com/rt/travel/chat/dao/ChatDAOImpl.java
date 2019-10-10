package com.rt.travel.chat.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.rt.travel.chatContent.dto.ChatContentDTO;
import com.rt.travel.chatRoom.dto.ChatRoomDTO;


public class ChatDAOImpl implements ChatDAO {
	
	@Autowired
	SqlSessionTemplate mybatis;
	
	@Override
	public void createRoom(ChatRoomDTO chatRoomDTO) {
		mybatis.insert("chatDAO.createRoom",chatRoomDTO);
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
	public void deleteRoom(int chatRoomNum) {
		mybatis.delete("chatDAO.deleteRoom",chatRoomNum);
	}
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
	public void acceptCompanion(ChatRoomDTO chatRoomDTO) {
		mybatis.update("chatDAO.acceptCompanion",chatRoomDTO);
	}
	@Override
	public int isMembers(ChatRoomDTO chatRoomDTO) {
		return mybatis.selectOne("chatDAO.isMembers",chatRoomDTO);
	}
	@Override
	public List<Integer> selectChatRoomNums(){
		return mybatis.selectList("chatDAO.selectChatRoomNums");
	}
	@Override
	public List<ChatRoomDTO> chatSelectAll(){
		return mybatis.selectList("chatDAO.chatSelectAll");
	}
	@Override
	public int chatRoomIndex() {
		return mybatis.selectOne("chatDAO.chatRoomIndex");
	}
}
