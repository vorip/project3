package com.rt.travel.note.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rt.travel.note.service.NoteDeleteService;

@Controller
public class NoteDeleteController {
	
	@Autowired
	private NoteDeleteService noteDeleteService;
	
	@RequestMapping("noteDelete")
	public String noteDelete(int noteNum) {
		noteDeleteService.noteDelete(noteNum);
		return "ajax/ajaxResult";
	}
	
}
