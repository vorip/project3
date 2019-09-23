package com.rt.travel.note.dto;

public class NoteDTO {
	private String noteNum;
	private String me;
	private String other;
	private char noteType;
	private char applyType;
	private String sendTime;
	private String content;
	public char getApplyType() {
		return applyType;
	}
	public void setApplyType(char applyType) {
		this.applyType = applyType;
	}
	public char getNoteType() {
		return noteType;
	}
	public void setNoteType(char noteType) {
		this.noteType = noteType;
	}
	@Override
	public String toString() {
		return "NoteDTO [noteNum=" + noteNum + ", me=" + me + ", other=" + other + ", noteType=" + noteType
				+ ", applyType=" + applyType + ", sendTime=" + sendTime + ", content=" + content + "]";
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getNoteNum() {
		return noteNum;
	}
	public String getMe() {
		return me;
	}
	public void setMe(String me) {
		this.me = me;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getSendTime() {
		return sendTime;
	}

}
