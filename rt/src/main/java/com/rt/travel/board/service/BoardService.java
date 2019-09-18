package com.rt.travel.board.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.rt.travel.board.dto.BoardDTO;

public interface BoardService {

	public void insert(BoardDTO bDTO) throws Exception;

	public BoardDTO read(int bno) throws Exception;
	
	public void update(BoardDTO bDTO) throws Exception;
	
	public void delete(int bno) throws Exception;
	
	public List<BoardDTO> listAll() throws Exception;

	public void increaseViewcnt(int bno, HttpSession session) throws Exception;
}
