package com.rt.travel.course.dao;

import java.util.List;

import com.rt.travel.course.dto.CourseDTO;
import com.rt.travel.course.dto.TypeADTO;

public interface CourseDAO {

	void courseInsert(CourseDTO courseDTO);

	void typeAInsert(TypeADTO typeADTO);

	List<CourseDTO> select(CourseDTO courseDTO);

	List<CourseDTO> select_report(CourseDTO courseDTO);

	void delete(CourseDTO courseDTO);

	List<CourseDTO> selectAll();
	
	public CourseDTO select(String inputId);

	public String placeSelectStart(int no);
	
	public String placeSelectEnd(int no);
}