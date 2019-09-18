package com.rt.travel.course.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rt.travel.course.dto.CourseDTO;
import com.rt.travel.course.dto.TypeADTO;

@Repository
public class CourseDAOImpl implements CourseDAO {
	@Autowired
	SqlSessionTemplate my;
	
	@Override
	public void courseInsert(CourseDTO courseDTO) {
		my.insert("courseDAO.insert", courseDTO);
	}
	
	@Override
	public void typeAInsert(TypeADTO typeADTO) {
		my.insert("typeADAO.insert", typeADTO);
	}
	
	/*
	 * public CourseDTO select(CourseDTO courseDTO) { return
	 * my.selectOne("courseDAO.select", courseDTO); }
	 */ 
	@Override
	public List<CourseDTO> select(CourseDTO courseDTO) {
		return my.selectList("courseDAO.select", courseDTO);
	} 
	
	@Override
	public List<CourseDTO> select_report(CourseDTO courseDTO) {
		return my.selectList("courseDAO.select_report", courseDTO);
	} 
	
	@Override
	public void delete(CourseDTO courseDTO) {
		my.delete("courseDAO.delete", courseDTO);
	}
	
	@Override
	public List<CourseDTO> selectAll() {
		return my.selectList("courseDAO.selectAll");
	}
	
	@Override
	public CourseDTO select(String inputId) {
		return my.selectOne("courseDAO.select",inputId);
	}
}
