package com.itwill.ajax.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.itwill.ajax.News;
import com.itwill.ajax.NewsListResult;

/*

<< jackson 라이브러리가 의존성추가되어있는경우에는 MappingJackson2XmlHttpMessageConverter 우선적으로 사용되어짐 >>
<dependency>
			<groupId>com.fasterxml.jackson.dataformat</groupId>
			<artifactId>jackson-dataformat-xml</artifactId>
			<version>2.9.6</version>
</dependency>
 */
@Controller
public class XMLMessageConverterRestController {
	
	@ResponseBody
	@RequestMapping(value = "/newsTitleXML", produces = "text/xml;charset=UTF-8")
	public News newsTitleXML() {	//Dto1개 반환
		News news = this.getNewsList().get(0);
		return news;
	}
	@ResponseBody
	@RequestMapping(value = "/newsTitlesListXML")
	public List<News> newsTitleListXML() {	//jackson 라이브러리를 pom.xml에 dependency추가해서 사용
		return this.getNewsList();
	}
	
	@ResponseBody
	@RequestMapping(value = "newsTitlesMapXML")
	public Map newsTitleMapXML() {
		List<News> newsList=this.getNewsList();
		Map newsMap = new HashMap();
		newsMap.put("code", 1);
		newsMap.put("news", newsList);
		return newsMap;
	}

	
	
	private List<News> getNewsList() {
		List<News> newsList = new ArrayList<News>();
		newsList.add(new News("참으로 수고 많으셨습니다...", "연합뉴스", new Date().toLocaleString()));
		newsList.add(new News("IS 60개국 테러 위협 영상 공개…한국도 포함 포토", "SBS뉴스", new Date().toLocaleString()));
		newsList.add(new News("통일부 남북 당국회담 실무접촉서 입장차", "KBS뉴스", new Date().toLocaleString()));
		newsList.add(new News("내년도 수도권 집값·전세값↑…2∼3년후 조정", "TBC뉴스", new Date().toLocaleString()));
		newsList.add(new News("국토부 폴크스바겐 경유차 연비 3단계로 조사", "OMY뉴스", new Date().toLocaleString()));
		newsList.add(new News("日롯데 신격호 소송 이해하는가 건강문제 제기", "조선뉴스", new Date().toLocaleString()));
		newsList.add(new News("국가유공자 부인 위장 재혼시 유족자격 있다", "YTN뉴스", new Date().toLocaleString()));
		newsList.add(new News("청소년에 한달 100건 성매매 강요 조폭 징역 6년", "CBS뉴스", new Date().toLocaleString()));
		newsList.add(new News("한국인들 실직·이직 공포에 시달린다", "ITWILL뉴스", new Date().toLocaleString()));
		return newsList;
	}
}






