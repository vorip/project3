package com.rt.travel.boardcomment.dao;

import java.util.List;

import com.rt.travel.boardcomment.dto.CommentDTO;

public interface CommentDAO {

	//댓글 개수
	public int commentCount() throws Exception;
	
	//댓글 목록
	public List<CommentDTO>	commentList(int bno) throws Exception;
	
	//댓글 작성
	public void commentInsert(CommentDTO commentDTO) throws Exception;
	
	//댓글 수정
	public void commentUpdate(CommentDTO commentDTO) throws Exception;
	
	//댓글 삭제
	public void commentDelete(CommentDTO commentDTO) throws Exception;
}
