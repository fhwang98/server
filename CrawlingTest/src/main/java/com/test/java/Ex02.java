package com.test.java;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Ex02 {

	public static void main(String[] args) {

		// 다음 영화 > 박스오피스
		//Jsoup
		
		try {
			
			String url = "https://movie.daum.net/ranking/boxoffice/weekly";
			
			Document doc = Jsoup.connect(url).get();
			
			//System.out.println(doc.html());
			
			Elements list = doc.select(".item_poster");
			
			//System.out.println(list.size());
			
			for (Element movie : list) {
				
				Element title = movie.selectFirst(".link_txt");
				System.out.println(title.text());
				
				Element date = movie.selectFirst(".txt_num");
				System.out.println(date.text());
				
				Element count = movie.selectFirst(".screen_out");
				// 주의: nextElementSibling(태그인 형제 찾기) 아님!
				System.out.println(count.nextSibling());
				
				Element poster = movie.selectFirst(".img_thumb");
				if (poster != null) {
					System.out.println(poster.attr("src"));
					
					getImage(poster.attr("src"), title.text());
					
					Thread.sleep(2000); // 여기서 잠시 멈추세요
				}
				System.out.println();
				
				// 수집한 데이터를 DB에 저장
				// DTO > 포장
				// dao.add(dto) > insert
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void getImage(String imgUrl, String filename) {
		
		// 이미지를 하드에 저장하는 메소드
		URL url = null;
		InputStream in = null;
		OutputStream out = null;
		
		try {
			
			url = new URL(imgUrl);
			in = url.openStream(); // 이미지 읽기
			out = new FileOutputStream("/Users/eugene/class/code/server/CrawlingTest/poster/" + filename + ".png"); // 파일 저장하기(쓰기)
			
			while (true) {
				
				int data = in.read();
				if (data == -1) {
					break;
				}
				out.write(data);
				
			}
			
			in.close();
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
