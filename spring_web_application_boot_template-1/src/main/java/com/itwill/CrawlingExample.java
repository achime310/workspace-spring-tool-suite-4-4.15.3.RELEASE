package com.itwill;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CrawlingExample {

    /**
     * 조회할 URL셋팅 및 Document 객체 로드하기
     */
    private static final String url = "https://www.coupang.com/np/categories/178255";
    public void process() {
        Connection conn = Jsoup.connect(url);
        //Jsoup 커넥션 생성

        Document document = null;
        try {
            document = conn.get();
            //url의 내용을 HTML Document 객체로 가져온다.
            //https://jsoup.org/apidocs/org/jsoup/nodes/Document.html 참고
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> list = getDataList(document);
    }


    /**
     * data가져오기
     */
    private List<String> getDataList(Document document) {
        List<String> list = new ArrayList<>();
        //Elements selects = document.select(".sentence-list");	//⭐⭐⭐
        Elements selects = document.select(".product-name");	//⭐⭐⭐
        //select 메서드 안에 css selector를 작성하여 Elements를 가져올 수 있다.

        for (Element select : selects) {
            System.out.println(select.html());		//⭐⭐⭐
            //html(), text(), children(), append().... 등 다양한 메서드 사용 가능
            //https://jsoup.org/apidocs/org/jsoup/nodes/Element.html 참고
        }
        return list;
    }
}
