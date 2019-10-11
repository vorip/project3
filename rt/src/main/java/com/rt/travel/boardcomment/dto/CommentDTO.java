package com.rt.travel.boardcomment.dto;

import java.util.Date;

public class CommentDTO {

	private int cno;
	private int bno;
	private String content;
	private String writer;
	private Date regdate;
	
	public CommentDTO() {
		
	}
	
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "CommentDTO [cno=" + cno + ", bno=" + bno + ", content=" + content + ", writer=" + writer + ", regdate="
				+ regdate + "]";
	}
	
}
