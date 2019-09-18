package com.rt.travel.course.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rt.travel.course.dto.TypeBDTO;

@Repository
public class TypeBDAOImpl implements TypeBDAO {
	@Autowired
	SqlSessionTemplate my;
	
	@Override
	public void insert(TypeBDTO typeBDTO) {
		my.insert("typeBDAO.insert", typeBDTO);
	}
	
	@Override
	public List<TypeBDTO> selectAll() {
		return my.selectList("typeBDAO.selectAll");
	}
}
