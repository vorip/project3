package com.rt.travel.course.dao;

import java.util.List;

import com.rt.travel.chatRoom.dto.ChatRoomDTO;
import com.rt.travel.course.dto.TypeADTO;

public interface TypeADAO {

	void insert(TypeADTO typeADTO);

	List<TypeADTO> selectAll();

	public TypeADTO select(String inputId);
	
	List<TypeADTO> typeASelectAll(String choice_public);
	
	public void addCurrentMem(int chatRoomNum);
	
	List<TypeADTO> selectPlan(String id);
	
	TypeADTO select_report(int db_number);
	
	void chatRoomNumUpdate(TypeADTO typeADTO);
	
	public String day_endSelect(int no);
}