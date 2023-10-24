package com.test.java;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Ex01 {

	public static void main(String[] args) {
		
		//Jsoup 라이브러리
		//- 브라우저처럼 사이트 접속 > 접속한 페이지의 소스 읽기 > 소스 분석 > 탐색 > 원하는 부분 추출
		//- JavaScript의 DOM을 조작하는 분위기
		
		// 외부작업 > try catch
		try { 
			
			// 접속해서 읽어온 페이지 소스를 관리하는 문서 객체
			Document doc = Jsoup.connect("http://localhost:8090/memo/list.do").get();
			
			//System.out.println(doc.html());
			
			//doc.select(CSS 선택자)
			Element h1 = doc.selectFirst("body > h1");
			
			System.out.println(h1.text());
			
			Elements item = doc.select(".item > div:nth-child(2)");
			
			for (Element ele : item) {
				System.out.println(ele.text());
			}
			
			Element result = doc.selectFirst("#result");
			System.out.println("result: " + result.text());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
