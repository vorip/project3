package com.rt.travel.note.service;

import com.rt.travel.note.dto.NoteDTO;

public interface NoteWriteService {

	void friendApply(String myName, String friendName);

	String sendNoteDiv(String meName);

	void noteSend(NoteDTO noteDTO, String name);

	char companionApply(String me, int chatRoomNum, String other);

}