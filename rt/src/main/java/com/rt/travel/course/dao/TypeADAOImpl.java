package com.rt.travel.course.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rt.travel.course.dto.TypeADTO;


@Repository
public class TypeADAOImpl implements TypeADAO{
	@Autowired
	SqlSessionTemplate my;
	
	@Override
	public TypeADTO select(String inputId) {
		return my.selectOne("typeADAO.select",inputId);
	}
	
	@Override
	public void insert(TypeADTO typeADTO) {
		my.insert("typeADAO.insert", typeADTO);
	}
	
	@Override
	public List<TypeADTO> selectAll() {
		return my.selectList("typeADAO.selectAll");
	}
}
