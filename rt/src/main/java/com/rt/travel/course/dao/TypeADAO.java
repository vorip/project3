package com.rt.travel.course.dao;

import java.util.List;

import com.rt.travel.course.dto.TypeADTO;

public interface TypeADAO {

	void insert(TypeADTO typeADTO);

	List<TypeADTO> selectAll();

	public TypeADTO select(String inputId);
}