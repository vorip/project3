package com.rt.travel.chat.dto;

public class ChatRoomDTO {
	
	private String members;
	private String chatRoomName;
	private String startTime;
	private int chatRoomNum;
	private int limitMember;
	private String leader;
	private String thumbnail;
	private String endTime;
	public String getMembers() {
		return members;
	}
	public void setMembers(String members) {
		this.members = members;
	}
	public String getchatRoomName() {
		return chatRoomName;
	}
	public void setchatRoomName(String chatRoomName) {
		this.chatRoomName = chatRoomName;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public int getchatRoomNum() {
		return chatRoomNum;
	}
	public void setchatRoomNum(int chatRoomNum) {
		this.chatRoomNum = chatRoomNum;
	}
	public int getLimitMember() {
		return limitMember;
	}
	public void setLimitMember(int limitMember) {
		this.limitMember = limitMember;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	
	

}
