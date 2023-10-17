package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex02_Receive extends HttpServlet {
	
	//서블릿 요청 메소드
	//1. GET 방식 요청 > doGet() 호출
	//2. POST 방식 요청 > doPost() 호출

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 수신
		//- <input type="text" name="name"> -> name=홍길동
		//- <input type="text" name="age">  -> age=20
		
		//HttpServletRequest req
		//- 데이터를 수신하는 담당자 역할
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		
		System.out.println(name);
		System.out.println(age);
		
		resp.setCharacterEncoding("UTF-8");
		PrintWriter writer = resp.getWriter();
		writer.println("<!DOCTYPE html>\n"
				+ "<html>\n"
				+ "<head>\n"
				+ "<meta charset=\"UTF-8\">\n"
				+ "<title>Insert title here</title>\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "	<h1>데이터 수신</h1>\n"
				+ "	<p>데이터 처리가 완료되었습니다.</p>\n"
				+ "</body>\n"
				+ "</html>");
		
		writer.close();
		
		
	}
	
}
