package com.rt.travel.note.dao;

import java.util.List;

import com.rt.travel.note.dto.NoteDTO;

public interface NoteDAO {

	void send(NoteDTO noteDTO);

	void noteDelete(int noteNum);

	void noteDeleteAll(String me);

	List<NoteDTO> noteSelectAll(String me);

	NoteDTO noteSelect(NoteDTO noteDTO);

	int isApplyCompanion(NoteDTO noteDTO);
}