package com.rt.travel.boardcomment.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.rt.travel.boardcomment.dao.CommentDAO;
import com.rt.travel.boardcomment.dto.CommentDTO;

@Service
public class CommentServiceimpl implements CommentService {

	@Inject
	CommentDAO commentDao;
	
	@Override
	public int commentCount() throws Exception {
		return commentDao.commentCount();
	}

	@Override
	public void commentInsert(CommentDTO commentDTO) throws Exception {
		/* commentDTO.setWriter("aaaaa"); */
		System.out.println("service단 : " + commentDTO);
		commentDao.commentInsert(commentDTO);
	}

	@Override
	public void commentUpdate(CommentDTO commentDTO) throws Exception {
		commentDao.commentUpdate(commentDTO);
	}

	@Override
	public void commentDelete(CommentDTO commentDTO) throws Exception {
		commentDao.commentDelete(commentDTO);
	}

}
