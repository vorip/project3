package com.rt.travel.note.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.travel.note.dao.NoteDAO;

@Service
public class NoteDeleteServiceImpl implements NoteDeleteService {
	
	@Autowired
	NoteDAO noteDAO;
	
	@Override
	public void noteDelete(int noteNum) {
		noteDAO.noteDelete(noteNum);
	}

}
