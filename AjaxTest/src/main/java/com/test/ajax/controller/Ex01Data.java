package com.test.ajax.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.ajax.repository.AjaxDAO;

@WebServlet("/ex01data.do")
public class Ex01Data extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Ex01Data.java
		
		//메모가 몇개인지?
		//DB 작업
		AjaxDAO dao = new AjaxDAO();
		
		int count = dao.getMemoCount();
		
		//JSP 호출
		req.setAttribute("count", count);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/ex01data.jsp");
		dispatcher.forward(req, resp);
	}
}