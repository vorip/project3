//package com.rt.travel.member.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.rt.travel.chat.dao.ChatDAO;
//import com.rt.travel.chatRoom.dto.ChatRoomDTO;
//import com.rt.travel.course.dao.CourseDAOImpl;
//import com.rt.travel.course.dao.TypeADAOImpl;
//import com.rt.travel.course.dto.CourseDTO;
//import com.rt.travel.course.dto.TypeADTO;
//import com.rt.travel.member.dao.MemberDAOImpl;
//import com.rt.travel.member.dto.CompanionDTO;
//import com.rt.travel.member.dto.MemberDTO;
//
//@Controller
//public class CompanionController {
//
//	@Autowired
//	ChatDAO chatRoomDAO;
//
//	@Autowired
//	MemberDAOImpl memberDAO;
//
//	@Autowired
//	CourseDAOImpl courseDAO;
//
//	@Autowired
//	TypeADAOImpl typeADAO;
//
//	MemberDTO memberDTO;
//	ChatRoomDTO chatRoomDTO;
//	CourseDTO courseDTO;
//	TypeADTO typeADTO;
//	
//	//동행자 신청 리스트 
//	@RequestMapping("companion")
//	public void companion(String leader, String inputId, Model model) {
//		CompanionDTO dto = new CompanionDTO();
//		
//		inputId = "asdf1";
//		memberDTO = new MemberDTO();
//		memberDTO = memberDAO.select(inputId);
//		dto.setThumb(memberDTO.getThumb());
//
//		leader = memberDTO.getName() + "_" + inputId;
//		chatRoomDTO = chatRoomDAO.select(leader);
//		dto.setLeader(chatRoomDTO.getLeader());
//		String inwon = chatRoomDTO.getMembers();
//		if (inwon.contains(",")) {
//			int in = inwon.split(",").length;
//		} else {
//			int in = 1;
//			dto.setInwon(in);
//			dto.setLimit(chatRoomDTO.getLimitMember());
//		}
//		
//		courseDTO = new CourseDTO();
//		courseDTO = courseDAO.select(inputId);
//		dto.setPlace_name(courseDTO.getPlace_name());
//		
//		typeADTO = new TypeADTO();
//		typeADTO = typeADAO.select(inputId);
//		int days = Integer.parseInt(typeADTO.getDay_start()); 
//		int term = days+typeADTO.getTravel_day();
//		dto.setStart(days);
//		dto.setTerm(term);
//		
//		model.addAttribute("dto",dto);	
//	}
//
//	@RequestMapping("detail")
//	public void detail(String leader,Model model) {
//		String inputId = "asdf1";
//		courseDTO = courseDAO.select(inputId);
//		typeADTO = typeADAO.select(inputId);
//		
//		int days = Integer.parseInt(typeADTO.getDay_start());
//		int term = days+typeADTO.getTravel_day();
//		
//		model.addAttribute("typeA",typeADTO);
//		model.addAttribute("course",courseDTO);
//		model.addAttribute("leader", leader);
//		model.addAttribute("term",term);
//	}
//}
