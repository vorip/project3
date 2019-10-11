package com.rt.travel.board.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.rt.travel.board.dto.BoardDTO;
import com.rt.travel.boardcomment.dto.CommentDTO;

public interface BoardService {

	public void insert(BoardDTO bDTO) throws Exception;

	public BoardDTO read(int bno) throws Exception;
	
	public void update(BoardDTO bDTO) throws Exception;
	
	public void delete(int bno) throws Exception;
	
	public List<CommentDTO> commentList(int bno) throws Exception;
	
	public List<BoardDTO> listAll(int page) throws Exception;
	
	public String board_count_list() throws Exception;
	
	public String board_count_search() throws Exception;
	
	public String board_search_title(String searchWord) throws Exception;
	
	public String board_search_content(String searchWord) throws Exception;
	
	public String board_search_writer(String searchWord) throws Exception;
	
	public void increaseViewcnt(int bno, HttpSession session) throws Exception;
}
