package com.rt.travel.course.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rt.travel.course.dao.TypeADAO;
import com.rt.travel.course.dto.TypeADTO;
import com.rt.travel.member.dao.MemberDAOImpl;

@Controller
public class TypeAController {
	@Autowired
	TypeADAO dao;
	@Autowired
	MemberDAOImpl memberDAO;
	
	// 여행일정 만들기 탭 클릭시 A양식으로 이동
	@RequestMapping("typea.do")
	public ModelAndView typea() throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("course/MapMain_TypeA");
		return mav;
	}
	
	   
	   // 여행 리스트 selectAll
	   @RequestMapping("selectAll.do")
	   public ModelAndView selectAll() throws Exception {
	      List<TypeADTO> list = dao.selectAll();
	      for (int i = 0; i < list.size(); i++) {
	         
	         String[] str = list.get(i).getDay_start().split(" ");
	         String[] end = list.get(i).getDay_end().split(" ");
	         
	         list.get(i).setDay_start(str[0]);
	         list.get(i).setDay_end(end[0]);
	      }   
	      
	      ModelAndView mav = new ModelAndView();
	      mav.addObject("selectAll",list);
	      mav.setViewName("course/selectAll");
	      return mav;
	   }
	   
		@RequestMapping("choiceUpdate.do")
		public String choiceupdate(TypeADTO typeADTO) {
			dao.choiceUpdate(typeADTO);
			return "course/choiceUpdate";
		}
}
