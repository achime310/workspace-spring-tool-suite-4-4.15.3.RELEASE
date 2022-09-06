package com.itwill.guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*
이름             널?       유형             
-------------- -------- -------------- 
GUEST_NO       NOT NULL NUMBER(10)     
GUEST_NAME     NOT NULL VARCHAR2(50)   
GUEST_DATE     NOT NULL DATE           
GUEST_EMAIL             VARCHAR2(50)   
GUEST_HOMEPAGE          VARCHAR2(50)   
GUEST_TITLE    NOT NULL VARCHAR2(100)  
GUEST_CONTENT  NOT NULL VARCHAR2(4000) 
*/
@Component(value = "guest")
public class Guest {
	private int guest_no;
	private String guest_name;
	private String guest_date;
	private String guest_email;
	private String guest_homepage;
	private String guest_title;
	private String guest_content;
	public Guest() {
		System.out.println("### Guest()기본 생성자");
	}
	@Autowired
	public Guest(@Value(value = "999") int guest_no,
				 @Value(value = "이름") String guest_name, 
				 @Value(value = "2022/10/10") String guest_date,
				 @Value(value = "guard@gmail.com") String guest_email,
				 @Value(value = "http://www.gmail.com") String guest_homepage,
				 @Value(value = "제목") String guest_title,
				 @Value(value = "내용")String guest_content) {
		super();
		this.guest_no = guest_no;
		this.guest_name = guest_name;
		this.guest_date = guest_date;
		this.guest_email = guest_email;
		this.guest_homepage = guest_homepage;
		this.guest_title = guest_title;
		this.guest_content = guest_content;
		System.out.println("####Guest("+guest_no+","+guest_name+".....) 생성자");
	}
	public int getGuest_no() {
		return guest_no;
	}
	@Autowired
	@Value(value = "100")
	public void setGuest_no(int guest_no) {
		this.guest_no = guest_no;
	}
	public String getGuest_name() {
		return guest_name;
	}
	@Autowired
	@Value(value = "김이름")
	public void setGuest_name(String guest_name) {
		this.guest_name = guest_name;
	}
	
	public String getGuest_date() {
		return guest_date;
	}
	@Autowired
	@Value(value = "2022/10/21")
	public void setGuest_date(String guest_date) {
		this.guest_date = guest_date;
	}
	public String getGuest_email() {
		return guest_email;
	}
	@Autowired
	@Value(value = "100")
	public void setGuest_email(String guest_email) {
		this.guest_email = guest_email;
	}
	public String getGuest_homepage() {
		return guest_homepage;
	}
	@Autowired
	@Value(value = "www.naver.com")
	public void setGuest_homepage(String guest_homepage) {
		this.guest_homepage = guest_homepage;
	}
	public String getGuest_title() {
		return guest_title;
	}
	@Autowired
	@Value(value = "타이틀")
	public void setGuest_title(String guest_title) {
		this.guest_title = guest_title;
	}
	public String getGuest_content() {
		return guest_content;
	}
	@Autowired
	@Value(value = "컨텐트")
	public void setGuest_content(String guest_content) {
		this.guest_content = guest_content;
	}
	@Override
	public String toString() {
		return "Guest [guest_no=" + guest_no + ", guest_name=" + guest_name + ", guest_date=" + guest_date
				+ ", guest_email=" + guest_email + ", guest_homepage=" + guest_homepage + ", guest_title=" + guest_title
				+ ", guest_content=" + guest_content + "]";
	}
	
	
	
}
