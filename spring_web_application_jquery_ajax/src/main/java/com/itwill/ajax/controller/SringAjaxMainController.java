package com.itwill.ajax.controller;
import java.io.Console;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.ajax.News;

@RestController
public class SringAjaxMainController {
	/*
	 * << @ResponseBody >>
	 * - ViewResolver-->View-->foward jsp 를 사용하지않는다
	 * - MessageConverter(text,xml,json)가 클라이언트로 응답한다.
	 */
	
	@RequestMapping(value = "02.ajaxRequest",produces = "text/plain;charset=UTF-8")
	public String ajaxRequest(@RequestParam(required = true,defaultValue = "") String id) throws Exception {
		String msg="";
		if(id.startsWith("guard")){
			msg="사용가능";
		}else{
			msg="사용불가능";
		}
		Thread.sleep(1000);
		return msg;
	}
	@RequestMapping(value = "03.ajaxRequestGETPOST",produces = "text/plain;charset=UTF-8")
	public String ajaxRequestGETPOST(@RequestParam(required = true,defaultValue = "") String id) throws Exception {
		String msg="";
		if(id.startsWith("guard")){
			msg="사용가능";
		}else{
			msg="사용불가능";
		}
		Thread.sleep(1000);
		return msg;
	}
	
	@RequestMapping(value = "04.server_clock", produces = "text/plain;charset=UTF-8")
	public String server_clock() {
		return new Date().toLocaleString();
	}
	
	@RequestMapping(value = "/06.newsTitlesHTML",produces = "text/plain;charset=UTF-8")
	public String newsTitlesHTML() {
		List<News> newsList= this.getNewsList();
		StringBuffer sb=new StringBuffer();
		sb.append("<ul>");
		for(int i=0;i<newsList.size();i++){
			News news=newsList.get(i);
			sb.append("<li>"+news.getTitle()+"["+news.getCompany()+"-"+news.getDate()+"][HTML]</li>");
		}
		sb.append("</ul>");
		return sb.toString();
	}
	
	@RequestMapping(value = "07.newsTitlesXML",produces = "text/xml;charset=UTF-8")
	public Map newsTitlesXML() {
		
		Map resultMap = new HashMap();
		resultMap.put("code", 1);
		resultMap.put("news", this.getNewsList());
		
		return resultMap;
	}
	@RequestMapping(value = "08.newsTitlesJSON",produces = "application/json;charset=UTF-8")
	public Map newsTitlesJson() {
		
		Map resultMap = new HashMap();
		resultMap.put("code", 1);
		resultMap.put("data", this.getNewsList());
		return resultMap;
	}
	

	
	public List<News> getNewsList(){
	    /*
		for(int i=0;i<300000;i++){
	    	System.out.println("");
	    }
	    */
		List<News> newsList=new ArrayList<News>();
		newsList.add(new News("참으로 수고 많으셨습니다...","연합뉴스",new Date().toLocaleString()));
		newsList.add(new News("IS 60개국 테러 위협 영상 공개…한국도 포함 포토","SBS뉴스",new Date().toLocaleString()));
		newsList.add(new News("통일부 남북 당국회담 실무접촉서 입장차","KBS뉴스",new Date().toLocaleString()));
		newsList.add(new News("내년도 수도권 집값·전세값↑…2∼3년후 조정","TBC뉴스",new Date().toLocaleString()));
		newsList.add(new News("국토부 폴크스바겐 경유차 연비 3단계로 조사","OMY뉴스",new Date().toLocaleString()));
		newsList.add(new News("日롯데 신격호 소송 이해하는가 건강문제 제기","조선뉴스",new Date().toLocaleString()));
		newsList.add(new News("국가유공자 부인 위장 재혼시 유족자격 있다","YTN뉴스",new Date().toLocaleString()));
		newsList.add(new News("청소년에 한달 100건 성매매 강요 조폭 징역 6년","CBS뉴스",new Date().toLocaleString()));
		newsList.add(new News("한국인들 실직·이직 공포에 시달린다","ITWILL뉴스",new Date().toLocaleString()));
		return newsList;
	}
}























