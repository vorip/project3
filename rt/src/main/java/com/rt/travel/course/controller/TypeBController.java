package com.rt.travel.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rt.travel.course.dao.TypeBDAOImpl;
import com.rt.travel.course.dto.TypeBDTO;

@Controller
public class TypeBController {
	@Autowired
	TypeBDAOImpl dao;
	
	@RequestMapping("List_typeB.do")
	public void list(TypeBDTO typeBDTO, Model model) {
			System.out.println(typeBDTO.toString());
		dao.insert(typeBDTO);
			System.out.println("입력!");
		model.addAttribute("list", dao.selectAll());
	}
}
