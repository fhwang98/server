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

@WebServlet("/ex03data.do")
public class Ex03Data extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Ex03Data.java
		
		//이름을 받아서 그 사람의 메모 개수
		String name = req.getParameter("name");
		
		AjaxDAO dao = new AjaxDAO();
		
		int count = dao.getMemoCount(name);
		
		try {
			
			//메모 개수 > 시간 걸림..
			//동기 통신 > 10초 기다리는동안 아모고토 못함
			Thread.sleep(10000);
			
		} catch (Exception e) {
			System.out.println("Ex03Data.doGet()");
			e.printStackTrace();
		}
		
		PrintWriter writer = resp.getWriter();
		writer.print(count);
		writer.close();

	}
}
