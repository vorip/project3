package com.rt.travel.chatRoom.dto;

public class ChatRoomDTO {
	private String members;
	private String chatRoomName;
	private String startTime;
	private int chatRoomNum;
	private int limitMember;
	private String leader;
	private String thumbNail;
	private String endTime;
	
	@Override
	public String toString() {
		return "ChatRoomDTO [members=" + members + ", chatRoomName=" + chatRoomName + ", startTime=" + startTime
				+ ", chatRoomNum=" + chatRoomNum + ", limitMember=" + limitMember + ", leader=" + leader
				+ ", thumbNail=" + thumbNail + ", endTime=" + endTime + "]";
	}
	
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
	public String getThumbNail() {
		return thumbNail;
	}
	public void setThumbNail(String thumbnail) {
		this.thumbNail = thumbnail;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
}
