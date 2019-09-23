package com.rt.travel.friend.dto;

public class FriendDTO {
	
	private String myName;
	private String friendName;
	private String myId;
	private String friendId;
	private char auth;
	

	public String getMyId() {
		return myId;
	}
	public void setMyId(String myId) {
		this.myId = myId;
	}
	public String getFriendId() {
		return friendId;
	}
	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}
	public char getAuth() {
		return auth;
	}
	public void setAuth(char auth) {
		this.auth = auth;
	}
	public String getMyName() {
		return myName;
	}
	public void setMyName(String myName) {
		this.myName = myName;
	}
	public String getFriendName() {
		return friendName;
	}
	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}
}
