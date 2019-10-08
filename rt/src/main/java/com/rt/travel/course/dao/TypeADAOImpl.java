package com.rt.travel.course.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rt.travel.course.dto.TypeADTO;

@Repository
public class TypeADAOImpl implements TypeADAO {
	@Autowired
	SqlSessionTemplate my;

	@Override
	public TypeADTO select(String inputId) {
		return my.selectOne("typeADAO.select", inputId);
	}

	@Override
	public void insert(TypeADTO typeADTO) {
		my.insert("typeADAO.insert", typeADTO);
	}

	@Override
	public List<TypeADTO> selectAll() {
		return my.selectList("typeADAO.selectAll");
	}

	@Override
	public List<TypeADTO> typeASelectAll(String choice_public) {
		return my.selectList("typeADAO.typeASelectAll", choice_public);
	}

	public void addCurrentMem(int chatRoomNum) {
		my.update("typeADAO.addCurrentMem", chatRoomNum);
	}

	public List<TypeADTO> selectPlan(String id) {
		return my.selectList("typeADAO.select", id);
	}

	@Override
	public TypeADTO select_report(int db_number) {

		TypeADTO adto = my.selectOne("typeADAO.select_by_num", db_number);
		System.out.println(adto);
		return adto;
	}
	
	public String day_endSelect(int no) {
		return my.selectOne("typeADAO.day_endSelect",no);
	}
	
	@Override
	public void chatRoomNumUpdate(TypeADTO typeADTO) {
		my.update("typeADAO.chatRoomNumUpdate",typeADTO);
	}
	
	@Override
	public void choiceUpdate(TypeADTO typeADTO) {
		my.update("typeADAO.choiceupdate",typeADTO);
	}
}
