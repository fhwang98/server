package com.test.ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.ajax.repository.AjaxDAO;

@WebServlet("/ex02data.do")
public class Ex02Data extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//System.out.println(100 / 0); // 에러내보기
		
		//Ex02Data.java
		// DB
		AjaxDAO dao = new AjaxDAO();
		
		int count = dao.getMemoCount();
		
		
		//Ajax > jsp로 돌려줄 필요 없음 > jsp 안만들어도 ㄱㅊ
		// JSP 호출
		//req.setAttribute("count", count);

		//RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/ex02data.jsp");
		//dispatcher.forward(req, resp);
		
		PrintWriter writer = resp.getWriter();
		
		writer.print(count);
		writer.close();
	}
}
