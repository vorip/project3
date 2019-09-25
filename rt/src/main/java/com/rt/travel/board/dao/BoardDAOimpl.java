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
	SqlSession SqlSession;
	
	@Override
	public void insert(BoardDTO bDTO) throws Exception {
		SqlSession.insert("bDAO.insert", bDTO);
	}

	@Override
	public BoardDTO read(int bno) throws Exception {
		return SqlSession.selectOne("bDAO.view", bno);
	}

	@Override
	public void update(BoardDTO bDTO) throws Exception {
		SqlSession.update("bDAO.updateArticle", bDTO);
	}

	@Override
	public void delete(int bno) throws Exception {
		SqlSession.delete("bDAO.deleteArticle", bno);
	}

	//게시글 전체 목록
	/*
	 * @Override public List<BoardDTO> listAll(String searchOption, String keyword)
	 * throws Exception { //검색옵션, 키워드 맵에 저장 Map<String, String> map = new
	 * HashMap<String, String>(); map.put(searchOption, searchOption);
	 * map.put(keyword, keyword); return SqlSession.selectList("bDAO.listAll", map);
	 * }
	 */
	
	@Override
	public List<BoardDTO> listAll() throws Exception {
		return SqlSession.selectList("bDAO.listAll");
	}

	@Override
	public void increaseViewcnt(int bno) throws Exception {
		SqlSession.update("bDAO.increaseViewcnt", bno);
	}

	/*
	 * //게시글 레코드 갯수
	 * 
	 * @Override public int countArticle(String searchOption, String keyword) throws
	 * Exception { //검색옵션, 키워드 맵에 저장 Map<String, String> map = new HashMap<String,
	 * String>(); map.put(searchOption, searchOption); map.put(keyword, keyword);
	 * return SqlSession.selectOne("bDAO.countArticle", map); }
	 */

}
