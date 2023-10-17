package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex02_Send extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");
		PrintWriter writer = resp.getWriter();
		writer.println("<!DOCTYPE html>\n"
				+ "<html>\n"
				+ "<head>\n"
				+ "<meta charset=\"UTF-8\">\n"
				+ "<title>Insert title here</title>\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "	<h1>데이터 전송</h1>\n"
				+ "	<form method=\"POST\" action='/servlet/receive.do'>\n"
				+ "		<div>\n"
				+ "			이름: <input type=\"text\" name=\"name\">			\n"
				+ "		</div>\n"
				+ "		<div>\n"
				+ "			나이: <input type=\"text\" name=\"age\">			\n"
				+ "		</div>\n"
				+ "		<input type=\"submit\" value=\"보내기\">\n"
				+ "	</form>\n"
				+ "</body>\n"
				+ "</html>");
	
		writer.close();
	}
	
}
