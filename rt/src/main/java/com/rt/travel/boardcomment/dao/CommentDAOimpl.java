package com.rt.travel.boardcomment.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.rt.travel.boardcomment.dto.CommentDTO;

@Repository
public class CommentDAOimpl implements CommentDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public int commentCount() throws Exception {
		return sqlSession.selectOne("commentDAO.commentCount");
	}

	@Override
	public List<CommentDTO> commentList(int bno) throws Exception {
		return sqlSession.selectList("commentDAO.commentList", bno);
	}

	@Override
	public void commentInsert(CommentDTO commentDTO) throws Exception {
		System.out.println("DAO단 : " + commentDTO);
		sqlSession.insert("commentDAO.commentInsert", commentDTO);
	}

	@Override
	public void commentUpdate(CommentDTO commentDTO) throws Exception {
		sqlSession.update("commentDAO.commentUpdate", commentDTO);
	}

	@Override
	public void commentDelete(CommentDTO commentDTO) throws Exception {
		sqlSession.delete("commentDAO.commentDelete", commentDTO);
	}

}
