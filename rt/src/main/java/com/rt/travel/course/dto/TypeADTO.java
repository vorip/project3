package com.rt.travel.course.dto;

public class TypeADTO {
	int no;
	String id;
	String title;
	int travel_day;
	String day_start;
	String travel_type;
	String travel_theme;
	String choice_public;
	String travel_intro;
	
	@Override
	public String toString() {
		return "TypeADTO [no=" + no + ", id=" + id + ", title=" + title + ", travel_day=" + travel_day + 
				",travel_type="+ travel_type + ", travel_theme=" + travel_theme +", choice_public=" + choice_public
				+ ", travel_intro=" + travel_intro + "]";
	}
	public TypeADTO() {
		
	}
	
	public String getDay_start() {
		return day_start;
	}
	public void setDay_start(String day_start) {
		this.day_start = day_start;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getTravel_day() {
		return travel_day;
	}
	public void setTravel_day(int travel_day) {
		this.travel_day = travel_day;
	}
	public String getTravel_type() {
		return travel_type;
	}
	public void setTravel_type(String travel_type) {
		this.travel_type = travel_type;
	}
	public String getTravel_theme() {
		return travel_theme;
	}
	public void setTravel_theme(String travel_theme) {
		this.travel_theme = travel_theme;
	}
	public String getChoice_public() {
		return choice_public;
	}
	public void setChoice_public(String choice_public) {
		this.choice_public = choice_public;
	}
	public String getTravel_intro() {
		return travel_intro;
	}
	public void setTravel_intro(String travel_intro) {
		this.travel_intro = travel_intro;
	}
}
