package com.rt.travel.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping(value="main.do")
	public String MainView(ModelAndView mv) {
		
		mv.setViewName("main/main");
		return mv.getViewName();
	}

}
