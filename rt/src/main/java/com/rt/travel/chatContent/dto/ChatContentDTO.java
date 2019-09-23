package com.rt.travel.chatContent.dto;

public class ChatContentDTO {
	private String content;
	private String contentTime;
	private int chatRoomNum;
	private String member;
	
	
	@Override
	public String toString() {
		return "ChatContentDTO [content=" + content + ", contentTime=" + contentTime + ", chatRoomNum=" + chatRoomNum
				+ ", member=" + member + "]";
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContentTime() {
		return contentTime;
	}
	public void setContentTime(String contentTime) {
		this.contentTime = contentTime;
	}
	public int getChatRoomNum() {
		return chatRoomNum;
	}
	public void setChatRoomNum(int chatRoomNum) {
		this.chatRoomNum = chatRoomNum;
	}
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
}
