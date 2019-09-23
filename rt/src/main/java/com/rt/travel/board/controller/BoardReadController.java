package com.rt.travel.board.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rt.travel.board.dto.BoardDTO;
import com.rt.travel.board.service.BoardService;

@Controller
public class BoardReadController {
	
	@Inject
	BoardService boardService;
	
	//게시글 목록
	@RequestMapping("list.do")
	public ModelAndView list() throws Exception {
		List<BoardDTO> list = boardService.listAll();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Board/list");
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping(value="write.do", method=RequestMethod.GET)
	public String write() {
		return "Board/write"; //write.jsp로 이동
	}
	
	//게시글 작성처리
	@RequestMapping(value="insert.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String insert(@ModelAttribute BoardDTO bDTO, HttpSession session) throws Exception {
		//로그인한 사용자의 아이디
		String writer = (String)session.getAttribute("userid");
		bDTO.setWriter(writer);
		//레코드 저장
		boardService.insert(bDTO);
		//목록 갱신
		return "redirect:list.do";
	}
		
	//게시글 상세내용 조회 및 조회수 증가
	@RequestMapping(value="view.do", method=RequestMethod.GET)
	public ModelAndView detailView(@RequestParam int bno, HttpSession session) throws Exception {
		//조회수 증가 처리
		boardService.increaseViewcnt(bno, session);
		//모델(데이터)+뷰(화면)를 함께 전달하는 객체
		ModelAndView mav = new ModelAndView();
		//뷰의 이름
		mav.setViewName("Board/view");
		//뷰에 전달할 데이터
		mav.addObject("dto", boardService.read(bno));
		return mav;
	}
		
	//게시글 수정
	@RequestMapping(value="update.do", method=RequestMethod.POST)
	public String update(@ModelAttribute BoardDTO bDTO) throws Exception {
		boardService.update(bDTO);
		return "redirect:list.do";
	}
		
	//게시글 삭제
	@RequestMapping("Board_delete.do")
	public String delete(@RequestParam int bno) throws Exception {
		boardService.delete(bno);
		return "redirect:list.do";
	}
}
