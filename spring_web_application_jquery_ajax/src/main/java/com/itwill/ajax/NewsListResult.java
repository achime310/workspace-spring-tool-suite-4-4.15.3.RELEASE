package com.itwill.ajax;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class NewsListResult {
	private int code;
	private List<News> newsList;


	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

}
