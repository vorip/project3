package com.rt.travel.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rt.travel.course.dao.TypeADAO;
import com.rt.travel.course.dto.TypeADTO;

@Controller
public class TypeAController {
	@Autowired
	TypeADAO dao;
	
	@RequestMapping("course.do")
	public void list(TypeADTO typeADTO, Model model) {
			System.out.println(typeADTO.toString());
		dao.insert(typeADTO);
			System.out.println("입력!");
		model.addAttribute("list2", dao.selectAll());
	}
}
