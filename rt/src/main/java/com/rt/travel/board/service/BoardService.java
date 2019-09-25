package com.rt.travel.board.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.rt.travel.board.dto.BoardDTO;

public interface BoardService {

	public void insert(BoardDTO bDTO) throws Exception;

	public BoardDTO read(int bno) throws Exception;
	
	public void update(BoardDTO bDTO) throws Exception;
	
	public void delete(int bno) throws Exception;
	/*
	 * //게시글 전체 목록 => 검색옵션, 키워드 매개변수 추가 public List<BoardDTO> listAll(String
	 * searchOption, String keyword) throws Exception; //게시글 레코드 갯수 메서드 추가 public
	 * int countArticle(String searchOption, String keyword) throws Exception;
	 */
	
	public List<BoardDTO> listAll() throws Exception;
	
	public void increaseViewcnt(int bno, HttpSession session) throws Exception;
}
