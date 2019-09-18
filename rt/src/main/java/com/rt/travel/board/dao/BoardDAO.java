package com.rt.travel.board.dao;

import java.util.List;

import com.rt.travel.board.dto.BoardDTO;

public interface BoardDAO {

	public void insert(BoardDTO bDTO) throws Exception;

	public BoardDTO read(int bno) throws Exception;
	
	public void update(BoardDTO bDTO) throws Exception;
	
	public void delete(int bno) throws Exception;
	
	public List<BoardDTO> listAll() throws Exception;
	
	public void increaseViewcnt(int bno) throws Exception;
}
