package com.rt.travel.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rt.travel.course.dao.CourseDAO;
import com.rt.travel.course.dto.CourseDTO;
import com.rt.travel.course.dto.TypeADTO;

@Controller
public class CourseController {
	@Autowired
	CourseDAO dao;
	
	// 양식에서 map으로 이동
	@RequestMapping("index.do")
	public String index(TypeADTO typeADTO, Model model) {
		dao.typeAInsert(typeADTO);	
		System.out.println("ㅎㅇ");
		model.addAttribute("no",dao.returnno());
		System.out.println("ㅂㅇ");
		return "course/index";
	}
	
	@RequestMapping("show_index.do")
	public String only_show_index(TypeADTO typeADTO , Model model) {
		model.addAttribute("no",dao.returnno());
		return "course/index";
	}
	
	// v버튼 누르고, 코스 정보 insert
	@RequestMapping("insert.do")
	public String insert(CourseDTO courseDTO) {
		dao.courseInsert(courseDTO);
		return "insert";
	}
	
	// 일차별 버튼 눌렀을 때, select해서 일차, no값, id에 맞는 장소들 출력
	@RequestMapping("select.do")
	public void select(CourseDTO courseDTO, Model model) {
		List<CourseDTO> list = dao.select(courseDTO);
		model.addAttribute("select_list", list);
	}
	
	// report에 띄우는 select
	@RequestMapping("report.do")
	public void select_report(CourseDTO courseDTO, Model model) {
		List<CourseDTO> list = dao.select_report(courseDTO);
		model.addAttribute("select_report", list);
	}
	
	// selectAll
	@RequestMapping("selectAll.do")
	public void selectAll(Model model) {
		List<CourseDTO> list = dao.selectAll();
		model.addAttribute("selectAll_list", list);
	}
	
	@RequestMapping("delete.do")
	public void delete(CourseDTO courseDTO) {
		dao.delete(courseDTO);
	}
	
	@RequestMapping("memoedit.do")
	public void memoedit(CourseDTO courseDTO) {
		dao.memoedit(courseDTO);
	}
	
	@RequestMapping("memoselect.do")
	public void memoselect(CourseDTO courseDTO, Model model) {
		CourseDTO memoresult = dao.memoselect(courseDTO);
		model.addAttribute("memoresult",memoresult);
	}
	
}
