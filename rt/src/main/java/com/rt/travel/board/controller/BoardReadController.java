package com.rt.travel.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rt.travel.board.dto.BoardDTO;
import com.rt.travel.board.service.BoardService;
import com.rt.travel.boardcomment.dto.CommentDTO;
import com.rt.travel.main.publicModule.MainPublicModule;

@Controller
public class BoardReadController {

   @Inject
   BoardService boardService;

   @Autowired
   MainPublicModule mainPublicModule;
   // 게시글 목록
   
   @RequestMapping("list.do")
   public ModelAndView list(int page, Model model, HttpSession session) throws Exception {
      List<BoardDTO> list = boardService.listAll(page);
      ModelAndView mav = new ModelAndView();
      model.addAttribute("publicBody", mainPublicModule.body(session.getAttribute("id")));
      model.addAttribute("publicBody2", mainPublicModule.body2());
      model.addAttribute("publicHead", mainPublicModule.head());
      model.addAttribute("publicfooter", mainPublicModule.footer());
      model.addAttribute("BoardPage", boardService.board_count_list());
      mav.setViewName("Board/list");
      mav.addObject("list", list);
      
      
      return mav;
   }

   @RequestMapping(value = "write.do", method = RequestMethod.GET)
   public String write(HttpSession session,Model model) {
      model.addAttribute("publicBody", mainPublicModule.body(session.getAttribute("id")));
      model.addAttribute("publicHead", mainPublicModule.head());
      model.addAttribute("publicfooter", mainPublicModule.footer());
      return "Board/write"; // write.jsp로 이동
   }

   // 게시글 작성처리
   @RequestMapping(value = "insert.do", method = { RequestMethod.GET, RequestMethod.POST })
   public String insert(@ModelAttribute BoardDTO bDTO, HttpSession session) throws Exception {
      
      // 로그인한 사용자의 아이디
      String writer = (String) session.getAttribute("id");
      bDTO.setWriter(writer);
      // 레코드 저장
      boardService.insert(bDTO);
      // 목록 갱신
      return "redirect:list.do?page=1";
   }

   // 게시글 상세내용 조회 및 조회수 증가
   @RequestMapping(value = "view.do", method = RequestMethod.GET)
   public ModelAndView detailView(@RequestParam int bno, HttpSession session, Model model) throws Exception {
      // 조회수 증가 처리
      boardService.increaseViewcnt(bno, session);
      
      List<CommentDTO> commentlist = boardService.commentList(bno);
      
      model.addAttribute("publicBody", mainPublicModule.body(session.getAttribute("id")));
      model.addAttribute("publicBody2", mainPublicModule.body2());
      model.addAttribute("publicHead", mainPublicModule.head());
      model.addAttribute("publicfooter", mainPublicModule.footer());
      model.addAttribute("BoardPage", boardService.board_count_list());
      
      model.addAttribute("commentlist", commentlist);
      // 모델(데이터)+뷰(화면)를 함께 전달하는 객체
      ModelAndView mav = new ModelAndView();
      // 뷰의 이름
      mav.setViewName("Board/view");
      // 뷰에 전달할 데이터
      mav.addObject("dto", boardService.read(bno));
      return mav;
   }

   // 게시글 수정
   @RequestMapping(value = "Board_update.do", method = RequestMethod.POST)
   public String update(@ModelAttribute BoardDTO bDTO) throws Exception {
      boardService.update(bDTO);
      return "redirect:list.do?page=1";
   }

   // 게시글 삭제
   @RequestMapping("Board_delete.do")
   public String delete(@RequestParam int bno) throws Exception {
      boardService.delete(bno);
      return "redirect:list.do?page=1";
   }
   
   @RequestMapping("board_search.do")
   public String board_search(String searchWord, Model model, String searchType) throws Exception {
      switch (searchType) {
      case "title" :
         model.addAttribute("result", boardService.board_search_title(searchWord)+"<><a href=\'#\'>1</a>");
         break;
         
      case "content" :
         model.addAttribute("result", boardService.board_search_content(searchWord)+"<><a href=\'#\'>1</a>");
         break;
         
      default:
         model.addAttribute("result", boardService.board_search_writer(searchWord)+"<><a href=\'#\'>1</a>");
         break;
      }
      return "ajax/ajaxResult";
   }
}