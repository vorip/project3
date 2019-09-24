package com.rt.travel.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rt.travel.course.dao.TypeADAO;
import com.rt.travel.course.dto.TypeADTO;

@Controller
public class TypeAController {
	@Autowired
	TypeADAO dao;
	
	// 여행일정 만들기 탭 클릭시 A양식으로 이동
	@RequestMapping("typea.do")
	public ModelAndView typea() throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("course/MapMain_TypeA");
		return mav;
	}
}
