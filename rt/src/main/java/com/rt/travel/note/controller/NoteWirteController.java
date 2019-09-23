package com.rt.travel.note.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rt.travel.note.dto.NoteDTO;
import com.rt.travel.note.service.NoteWriteService;

@Controller
public class NoteWirteController {

	
	@Autowired
	private NoteWriteService noteWriteService;
	
	@RequestMapping("sendNoteDiv")
	public String sendNoteDiv(String otherName, Model model) {
		model.addAttribute("result", noteWriteService.sendNoteDiv(otherName));
		return "ajax/ajaxResult";
	}
	
	@RequestMapping("sendNote")
	public String sendNote(NoteDTO noteDTO,HttpSession session) {
		noteWriteService.noteSend(noteDTO,(String)session.getAttribute("name"));
		return "ajax/ajaxResult";
	}
	
	@RequestMapping("applyCompanion")
	public String applyCompanion(String me,int chatRoomNum,HttpSession session,Model model) {
		model.addAttribute("result",noteWriteService.companionApply(me, chatRoomNum,(String)session.getAttribute("name")));
		return "ajax/ajaxResult";
	}
	@RequestMapping("friendApply")
	public String friendApply(String myName,String friendName) {
		noteWriteService.friendApply(myName, friendName);
		return "ajax/ajaxResult";
	}
}
