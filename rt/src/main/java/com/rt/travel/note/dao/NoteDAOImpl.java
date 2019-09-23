package com.rt.travel.note.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.rt.travel.note.dto.NoteDTO;

public class NoteDAOImpl implements NoteDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public void send(NoteDTO noteDTO) {
		mybatis.insert("noteDAO.send",noteDTO);
	}
	@Override
	public void noteDelete(int noteNum) {
		mybatis.delete("noteDAO.noteDelete",noteNum);
	}
	@Override
	public void noteDeleteAll(String me) {
		mybatis.delete("noteDAO.noteDeleteAll",me);
	}
	@Override
	public List<NoteDTO> noteSelectAll(String me) {
		return mybatis.selectList("noteDAO.noteSelectAll", me);
	}
	@Override
	public NoteDTO noteSelect(NoteDTO noteDTO) {
		return mybatis.selectOne("noteDAO.noteSelect",noteDTO);
	}
	
	@Override
	public int isApplyCompanion(NoteDTO noteDTO) {
		return mybatis.selectOne("noteDAO.isApplyCompanion",noteDTO);
	}
}
