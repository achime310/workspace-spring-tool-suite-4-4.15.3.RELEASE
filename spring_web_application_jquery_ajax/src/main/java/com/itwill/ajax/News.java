package com.itwill.ajax;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "jacksonNews")
public class News {
	private String title;
	private String company;
	private String date;
	public News() {
		// TODO Auto-generated constructor stub
	}
	
	public News(String title, String company, String date) {
		super();
		this.title = title;
		this.company = company;
		this.date = date;
	}
	@JsonProperty(value = "jsonNewsTitle")
	@JacksonXmlProperty(localName = "jacksonNewsTitle")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
