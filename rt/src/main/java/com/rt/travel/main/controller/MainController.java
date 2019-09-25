package com.rt.travel.main.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping(value="main.do")
	public String MainView(ModelAndView mv,HttpSession session,Model model) {
		if(session.getAttribute("id") != null) {
			model.addAttribute("loginPageScript","<script>$(function() {" + 
					"	$(\"#loginPageHref\").remove();" + 
					"	$(\"#signHref\").remove();" + 
					"$(\".header_menu\").append(\"<a href='logout'>로그아웃</a>\");"+
					"})</script>");
			mv.setViewName("main/main");
		}else {
			
			mv.setViewName("main/main");
		}
		return mv.getViewName();
	}
}
