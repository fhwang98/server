package com.test.ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.ajax.model.MemoDTO;
import com.test.ajax.repository.AjaxDAO;

@WebServlet("/ex04data.do")
public class Ex04Data extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Ex04Data.java
		
		//ex04data.do?type=1		
		String type = req.getParameter("type");
		
		if (type.equals("1")) {
			
			m1(req, resp); // 결과 printWriter > resp필요 인자로 넘기기
			
		} else if (type.equals("2")) {
			
			m2(req, resp);
			
		} else if (type.equals("3")) {
			m3(req, resp);
			
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/ex04data.jsp");
		dispatcher.forward(req, resp);
	}

	private void m3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		AjaxDAO dao = new AjaxDAO();
		
		MemoDTO dto = dao.get(7);
		
		//MemoDTO > XML 형식 > ajax
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/xml");
		
		PrintWriter writer = resp.getWriter();
		
		writer.print("<?xml version='1.0' encoding='UTF-8'?>");
		writer.print("<memo>");
		writer.printf("<seq>%s</seq>", dto.getSeq());
		writer.printf("<name>%s</name>", dto.getName());
		writer.printf("<pw>%s</pw>", dto.getPw());
		writer.printf("<memo>%s</memo>", dto.getMemo());
		writer.printf("<regdate>%s</regdate>", dto.getRegdate());
		writer.print("</memo>");
		
		writer.close();
		
	}

	private void m2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		AjaxDAO dao = new AjaxDAO();
		
		ArrayList<MemoDTO> list = dao.listMemo();
		
		//CSV
		String temp = "";
		for (MemoDTO dto : list) {
			temp += String.format("%s,%s,%s,%s,%s\r\n"
										, dto.getSeq()
										, dto.getName()
										, dto.getPw()
										, dto.getMemo().replace("\r\n", "\n")
										, dto.getRegdate());
		}
		
		System.out.println(temp);
		
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = resp.getWriter();
		writer.print(temp);
		writer.close();
		
	}

	private void m1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//텍스트 반환(단일값)
		AjaxDAO dao = new AjaxDAO();
		int count = dao.getMemoCount();
		
		//MIME > 브라우저(or ajax객체)에게 네가 돌려받는 데이터가 이런 형식의 데이터다.. 라고 알려주는 표시
		resp.setContentType("text/plain"); // 순수 텍스트 데이터
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = resp.getWriter();
		writer.print(count);
		writer.close();
		
	}
}