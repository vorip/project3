package com.rt.travel.course.dto;

public class TypeADTO {
	private int no;
	private String id;
	private String title;
	private int travel_day;
	private String day_start;
	private String travel_type;
	private String travel_theme;
	private String choice_public;
	private String travel_intro;
	private int current_mem;
	private int max_mem;
	private String day_end;
	
	@Override
	public String toString() {
		return "TypeADTO [no=" + no + ", id=" + id + ", title=" + title + ", travel_day=" + travel_day + 
				",travel_type="+ travel_type + ", travel_theme=" + travel_theme +", choice_public=" + choice_public
				+ ", travel_intro=" + travel_intro + "]";
	}
	
	public int getCurrent_mem() {
		return current_mem;
	}
	public void setCurrent_mem(int current_mem) {
		this.current_mem = current_mem;
	}
	public int getMax_mem() {
		return max_mem;
	}
	public void setMax_mem(int max_mem) {
		this.max_mem = max_mem;
	}
	public String getDay_end() {
		return day_end;
	}
	public void setDay_end(String day_end) {
		this.day_end = day_end;
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
