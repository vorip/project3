package com.rt.travel.course.dto;

public class TypeBDTO {
	int no;
	String id;
	String title;
	int travel_day;
	int day_start_year;
	int day_start_mon;
	String day_start_time;
	String travel_type;
	String travel_theme;
	String m_choice;
	String m_gender;
	String m_age;
	String choice_public;
	String travel_intro;
	
	@Override
	public String toString() {
		return "TypeBDTO [no=" + no + ", id=" + id + ", title=" + title + ", travel_day=" + travel_day + ", day_start_year="
				+ day_start_year + ", day_start_mon=" + day_start_mon + ", day_start_time =" + day_start_time + ", travel_type=" 
				+ travel_type + ", travel_theme=" + travel_theme + ", m_choice="
				+ m_choice + ", m_gender=" + m_gender + ", m_age=" + m_age + ", choice_public=" + choice_public
				+ ", travel_intro=" + travel_intro + "]";
	}
	public TypeBDTO() {
		
	}
	
	public int getDay_start_year() {
		return day_start_year;
	}
	public void setDay_start_year(int day_start_year) {
		this.day_start_year = day_start_year;
	}
	public int getDay_start_mon() {
		return day_start_mon;
	}
	public void setDay_start_mon(int day_start_mon) {
		this.day_start_mon = day_start_mon;
	}
	public String getDay_start_time() {
		return day_start_time;
	}
	public void setDay_start_time(String day_start_time) {
		this.day_start_time = day_start_time;
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
	public String getM_choice() {
		return m_choice;
	}
	public void setM_choice(String m_choice) {
		this.m_choice = m_choice;
	}
	public String getM_gender() {
		return m_gender;
	}
	public void setM_gender(String m_gender) {
		this.m_gender = m_gender;
	}
	public String getM_age() {
		return m_age;
	}
	public void setM_age(String m_age) {
		this.m_age = m_age;
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
