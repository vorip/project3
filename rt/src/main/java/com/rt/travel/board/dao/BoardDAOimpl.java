package com.rt.travel.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.rt.travel.board.dto.BoardDTO;

@Repository
public class BoardDAOimpl implements BoardDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public void insert(BoardDTO bDTO) throws Exception {
		sqlSession.insert("bDAO.insert", bDTO);
	}

	@Override
	public BoardDTO read(int bno) throws Exception {
		return sqlSession.selectOne("bDAO.view", bno);
	}

	@Override
	public void update(BoardDTO bDTO) throws Exception {
		sqlSession.update("bDAO.updateArticle", bDTO);
	}

	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete("bDAO.deleteArticle", bno);
	}

	//게시글 전체 목록
	
	/*
	 * @Override public List<BoardDTO> listAll(String searchOption, String keyword)
	 * throws Exception { //검색옵션, 키워드 맵에 저장 Map<String, String> map = new
	 * HashMap<String, String>(); map.put(searchOption, searchOption);
	 * map.put(keyword, keyword); return SqlSession.selectList("bDAO.listAll", map);
	 * }
	 */
	
	
	 @Override public List<BoardDTO> listAll(int page) throws Exception { 
		 return sqlSession.selectList("bDAO.Board_list", page); 
	 }
	 

	@Override
	public void increaseViewcnt(int bno) throws Exception {
		sqlSession.update("bDAO.increaseViewcnt", bno);
	}

	@Override
	public int board_count() throws Exception {
		return sqlSession.selectOne("bDAO.Board_count");
	}

	@Override
	public List<BoardDTO> board_search_title(String title) throws Exception {
		return sqlSession.selectList("bDAO.Board_search_title", "%" + title + "%");
	}

	@Override
	public List<BoardDTO> board_search_content(String content) throws Exception {
		return sqlSession.selectList("bDAO.Board_search_content", "%" + content + "%");
	}

	@Override
	public List<BoardDTO> board_search_writer(String writer) throws Exception {
		return sqlSession.selectList("bDAO.Board_search_writer", "%" + writer + "%");
	}

	/*
	 * //게시글 레코드 갯수
	 * 
	 * @Override public int countArticle(String searchOption, String keyword) throws
	 * Exception { //검색옵션, 키워드 맵에 저장 Map<String, String> map = new
	 * HashMap<String,String>(); map.put(searchOption, searchOption);
	 * map.put(keyword, keyword); return SqlSession.selectOne("bDAO.countArticle",
	 * map); }
	 */
}
