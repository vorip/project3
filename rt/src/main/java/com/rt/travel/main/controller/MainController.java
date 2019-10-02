package com.rt.travel.main.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rt.travel.main.publicModule.MainPublicModule;

@Controller
public class MainController {
   
   @Autowired
   MainPublicModule mainPublicModule;
   
   @RequestMapping(value="main.do")
   public String MainView(ModelAndView mv,HttpSession session,Model model) {
      
      model.addAttribute("publicBody", mainPublicModule.body(session.getAttribute("id")));
      model.addAttribute("publicHead", mainPublicModule.head());
      model.addAttribute("publicBody2", mainPublicModule.body2());
      mv.setViewName("main/main");
      return mv.getViewName();
   }

   
}