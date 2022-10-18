package com.itwill.controller;

//import lombok.AllArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

//@AllArgsConstructor
@Controller
public class CrawlingTestController {
    @GetMapping(value = "/crawling")
    public String goRegister() throws IOException {
        Document doc = Jsoup.connect("https://www.daangn.com/hot_articles").get();
        //Elements infoList = doc.select("div[class=product-name]").select("a[class=article-headline]");
        Elements infoList = doc.select("article[class=card-top]");
        //Elements contentList = doc.select("span.main-url + p");
        for (int i = 0; i < infoList.size(); i++) {
            //제목
            System.out.println(infoList.get(i).select("div[class=card-desc]").select("h2[class=card-title]").text());
            //링크
            System.out.println(infoList.get(i).select("div[class=card-desc]").select("div[class=card-price]").text());
            //이미지 url
            //String imageUrl = doc.select("a[href=" + infoList.get(i).attr("href") + "]").select("img").attr("src");
            String imageUrl = infoList.get(i).select("div[class=card-photo]").select("img").attr("src");
            System.out.println(imageUrl);
            //내용
            //String content = contentList.get(i).text();
            //System.out.println(content);

        }
        return "crawling";
    }
}