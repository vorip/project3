package com.rt.travel.course.dao;

import java.util.List;

import com.rt.travel.course.dto.TypeBDTO;

public interface TypeBDAO {

	void insert(TypeBDTO typeBDTO);

	List<TypeBDTO> selectAll();

}