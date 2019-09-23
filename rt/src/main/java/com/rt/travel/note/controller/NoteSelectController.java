package com.rt.travel.note.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rt.travel.note.service.NoteSelectService;

@Controller
public class NoteSelectController {
	
	@Autowired
	NoteSelectService noteSelectService;
	
	@RequestMapping("noteSelectAll")
	public String noteSelectAll(Model model,HttpSession session){
		model.addAttribute("result",noteSelectService.noteSelectAll((String)session.getAttribute("name")));
		return "ajax/ajaxResult";
	}

}
