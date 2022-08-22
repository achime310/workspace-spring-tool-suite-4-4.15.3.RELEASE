package com.mybatis3.domain;

import java.util.Date;
import java.util.List;
/*
STUD_ID NOT NULL NUMBER(11)   
NAME    NOT NULL VARCHAR2(50) 
EMAIL   NOT NULL VARCHAR2(50) 
PHONE            VARCHAR2(15) 
DOB              DATE         
ADDR_ID          NUMBER(11)         
*/

/*
이름      널?       유형           
------- -------- ------------ 
STUD_ID NOT NULL NUMBER(11)   
NAME    NOT NULL VARCHAR2(50) 
EMAIL   NOT NULL VARCHAR2(50) 
PHONE            VARCHAR2(15) 
DOB              DATE         
BIO              CLOB         
PIC              BLOB         
ADDR_ID          NUMBER(11)   
 */
public class Student {
	private Integer studId; // wrapper객체로 되어 있음.
	private String name;
	private String email;
	private Date dob;

	// private int addrId; //FK
	private Address address;
	
	private List<Course> courseList;

	public Student() {
	}
	// course정보를 함께 입력하는 경우를 생각해서, courses포함되지 않은 생성자만 둔다.
	public Student(Integer studId, String name, String email, Date dob, Address address) {
		super();
		this.studId = studId;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.address = address;
	}

	public Integer getStudId() {
		return studId;
	}

	public void setStudId(Integer studId) {
		this.studId = studId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	@Override
	public String toString() {
		return "Student [studId=" + studId + ", name=" + name + ", email=" + email + ", dob=" + dob + ", address="
				+ address + ", courseList=" + courseList + "]";
	}
	
}
