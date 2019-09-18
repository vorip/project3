package com.rt.travel.course.dto;

public class CourseDTO {
	static int no=0;
	String id;
	String place_url;
	String place_name;
	String place_address_name;
	String place_phone;
	String place_x;
	String place_y;
	String place_memo;
	int day;
	int memo_index;
	
	@Override
	public String toString() {
		return "CourseDTO [no=" + no + ", id=" + id + ", day=" + day + ", place_url=" + place_url + ", place_name="
				+ place_name + ", place_address_name=" + place_address_name + ", place_phone=" + place_phone
				+ ", place_x=" + place_x + ", place_y=" + place_y + ", place_memo="+ place_memo+", memo_index="+memo_index+ "]";
	}
	
	public int getMemo_index() {
		return memo_index;
	}
	
	public void setMemo_index(int memo_index) {
		this.memo_index = memo_index;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
		no++;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getPlace_url() {
		return place_url;
	}
	public void setPlace_url(String place_url) {
		this.place_url = place_url;
	}
	public String getPlace_name() {
		return place_name;
	}
	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}
	public String getPlace_address_name() {
		return place_address_name;
	}
	public void setPlace_address_name(String place_address_name) {
		this.place_address_name = place_address_name;
	}
	public String getPlace_phone() {
		return place_phone;
	}
	public void setPlace_phone(String place_phone) {
		this.place_phone = place_phone;
	}
	public String getPlace_x() {
		return place_x;
	}
	public void setPlace_x(String place_x) {
		this.place_x = place_x;
	}
	public String getPlace_y() {
		return place_y;
	}
	public void setPlace_y(String place_y) {
		this.place_y = place_y;
	}
	public String getPlace_memo() {
		return place_memo;
	}
	public void setPlace_memo(String place_memo) {
		this.place_memo = place_memo;
	}
}
