package com.rt.travel.chat.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rt.travel.chat.service.ChatReadService;
import com.rt.travel.member.service.MemberTools;

@Controller
public class ChatReadController {

   @Autowired
   ChatReadService chatService;
   @Autowired
   MemberTools memberTools;

   @RequestMapping("getChat")
   public String getChat(Model model, HttpSession session, HttpServletResponse response) {
      model.addAttribute("result", chatService.getChat((String) session.getAttribute("name")));
      return "ajax/ajaxResult";
   }

   @RequestMapping("menuChange_chat")
   public String menuChange_chat(Model model, HttpSession session) {
      model.addAttribute("result", chatService.getMenuContent_chat((String) session.getAttribute("name")));
      return "ajax/ajaxResult";
   }

   @RequestMapping("menuChange_friend")
   public String menuChange_friend(Model model, HttpSession session) {
      model.addAttribute("result", chatService.getMenuContent_friend((String) session.getAttribute("name")));
      return "ajax/ajaxResult";
   }
}