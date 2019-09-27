package com.rt.travel.course.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rt.travel.chat.dao.ChatDAO;
import com.rt.travel.chatRoom.dto.ChatRoomDTO;
import com.rt.travel.course.dao.CourseDAO;
import com.rt.travel.course.dao.TypeADAO;
import com.rt.travel.course.dto.CourseDTO;
import com.rt.travel.course.dto.TypeADTO;
import com.rt.travel.member.dao.MemberDAOImpl;

@Controller
public class CourseController {
	@Autowired
	CourseDAO dao;
	@Autowired
	MemberDAOImpl memberDAO;
	@Autowired
	ChatDAO chatDAO;
	@Autowired
	TypeADAO typeADAO;
	
	// 양식에서 map으로 이동
	@RequestMapping("index.do")
	public String index(TypeADTO typeADTO, Model model,HttpSession session) {
		
		dao.typeAInsert(typeADTO);
		typeADTO.setNo(dao.returnno());
		
		ChatRoomDTO chatRoomDTO = new ChatRoomDTO();
		chatRoomDTO.setMembers((String)session.getAttribute("name"));
		chatRoomDTO.setchatRoomName(typeADTO.getTitle());
		chatRoomDTO.setStartTime(typeADTO.getDay_start().split(" ")[0]);
		chatRoomDTO.setLimitMember(typeADTO.getMax_mem());
		chatRoomDTO.setEndTime(typeADAO.day_endSelect(typeADTO.getNo()).split(" ")[0]);
		chatRoomDTO.setLeader((String)session.getAttribute("name"));
		
		chatRoomDTO.setThumbNail("thumb.jpg");
		System.out.println(chatRoomDTO.toString());
		chatDAO.createRoom(chatRoomDTO);
		typeADTO.setChatRoomNum(chatDAO.chatRoomIndex());
		System.out.println(typeADTO.toString());
		
		typeADAO.chatRoomNumUpdate(typeADTO);
		model.addAttribute("typeADTO_model",typeADTO);
		return "course/index";
	}
	
	// v버튼 누르고, 코스 정보 insert
	@RequestMapping("insert_root.do")
	public String insert(CourseDTO courseDTO) {
		System.out.println(courseDTO);
		dao.courseInsert(courseDTO);
		return "course/insert";
	}
	
	// 일차별 버튼 눌렀을 때, select해서 일차, no값, id에 맞는 장소들 출력
	@RequestMapping("select.do")
	public String select(CourseDTO courseDTO, Model model) {
		List<CourseDTO> list = dao.select(courseDTO);
		model.addAttribute("select_list", list);
		return "course/select";
	}
	
	@RequestMapping("delete.do")
	public String delete(CourseDTO courseDTO) {
		dao.delete(courseDTO);
		return "course/delete";
	}
	
	@RequestMapping("memoedit.do")
	public String memoedit(CourseDTO courseDTO) {
		dao.memoedit(courseDTO);
		return "course/memodit";
	}
	
	@RequestMapping("memoselect.do")
	public String memoselect(CourseDTO courseDTO, Model model) {
		CourseDTO memoresult = dao.memoselect(courseDTO);
		model.addAttribute("memoresult",memoresult);
		return "course/memoselect";
	}
	
}
