package com.rt.travel.boardcomment.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rt.travel.boardcomment.dto.CommentDTO;
import com.rt.travel.boardcomment.service.CommentService;

@Controller
public class CommentController {

	@Inject
	CommentService commentService;
	
	@RequestMapping("Comment_insert.do") //댓글 작성
	private String commentInsert(CommentDTO commentDTO) throws Exception {
		System.out.println("controller부분 : " + commentDTO);
		commentService.commentInsert(commentDTO);
		return "Board/view";
	}
	
	
	 @RequestMapping("Comment_update.do") //댓글 수정 
	 private String commentUpdate(CommentDTO commentDTO) throws Exception {
		System.out.println("controller update부분 : " + commentDTO);
		commentService.commentUpdate(commentDTO); 
		return "Board/view";
	 }
	 
	
	@RequestMapping("Comment_delete.do") //댓글 삭제
	private String commentDelete(CommentDTO commentDTO) throws Exception {
		commentService.commentDelete(commentDTO);
		return "Board/view";
	}
	
}
