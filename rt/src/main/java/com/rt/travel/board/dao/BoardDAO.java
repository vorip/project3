package com.rt.travel.board.dao;

import java.util.List;

import com.rt.travel.board.dto.BoardDTO;

public interface BoardDAO {

	public void insert(BoardDTO bDTO) throws Exception;

	public BoardDTO read(int bno) throws Exception;
	
	public void update(BoardDTO bDTO) throws Exception;
	
	public void delete(int bno) throws Exception;
	
	public List<BoardDTO> listAll(int page) throws Exception;
	 
	public int board_count() throws Exception;
	 
	public List<BoardDTO> board_search_title(String title) throws Exception;
	 
	public List<BoardDTO> board_search_content(String content) throws Exception;
	 
	public List<BoardDTO> board_search_writer(String writer) throws Exception;
	
	public void increaseViewcnt(int bno) throws Exception;
}
