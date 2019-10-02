package com.rt.travel.companion.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rt.travel.chat.dao.ChatDAO;
import com.rt.travel.chatRoom.dto.ChatRoomDTO;
import com.rt.travel.companion.service.CompanionReadServiceImpl;
import com.rt.travel.course.dao.CourseDAO;
import com.rt.travel.course.dao.TypeADAO;
import com.rt.travel.course.dto.CourseDTO;
import com.rt.travel.course.dto.TypeADTO;
import com.rt.travel.main.publicModule.MainPublicModule;
import com.rt.travel.member.dao.MemberDAOImpl;
import com.rt.travel.member.dto.MemberDTO;


@Controller
public class CompanionReadController {
	MemberDTO memberDTO;
	ChatRoomDTO chatroomDTO;
	CourseDTO courseDTO;
	TypeADTO typeADTO;
	
	@Autowired
	ChatDAO chatDAO;
	@Autowired
	MemberDAOImpl memberDAO;
	@Autowired
	CourseDAO courseDAO;
	@Autowired
	TypeADAO typeADAO;
	@Autowired
	CompanionReadServiceImpl companion;
	@Autowired
	MainPublicModule mainPublicModule;

	// 동행자 신청 리스트
	@RequestMapping("companion")
	public String companion(Model model,HttpSession session) {
		model.addAttribute("companionResult", companion.companionList());
		model.addAttribute("loginPageScript","<script>$(function() {" + 
				"	$(\"#loginPageHref\").remove();" + 
				"	$(\"#signHref\").remove();" + 
				"$(\".header_menu\").append(\"<a href='logout'>로그아웃</a>\");"+
				"})</script>");
		return "companion/companion";
	}

	@RequestMapping("detail")
	public void detail(String leader, Model model) {
		List<ChatRoomDTO> list = chatDAO.chatSelectAll();
		String inputId = "";
		
		for (int i = 0; i < list.size(); i++) {
			leader = list.get(i).getLeader();
			String[] id = leader.split("_");
			inputId = id[1];
			
		}
		courseDTO = courseDAO.select(inputId);
		typeADTO = typeADAO.select(inputId);
		int days = Integer.parseInt(typeADTO.getDay_start());
		int term = days + typeADTO.getTravel_day();
		
		model.addAttribute("leader",leader);
		model.addAttribute("typeA", typeADTO);
		model.addAttribute("course", courseDTO);
		model.addAttribute("term", term);
	}
}
