package com.rt.travel.board.dao;

import java.util.List;

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
		System.out.println(bDTO.toString());
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

	@Override
	public List<BoardDTO> listAll() throws Exception {
		return SqlSession.selectList("bDAO.listAll");
	}

	@Override
	public void increaseViewcnt(int bno) throws Exception {
		SqlSession.update("bDAO.increaseViewcnt", bno);
	}

}
