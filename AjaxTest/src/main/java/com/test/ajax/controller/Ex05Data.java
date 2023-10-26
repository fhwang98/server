package com.test.ajax.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex05data.do")
public class Ex05Data extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Ex05Data.java
		
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		String address = req.getParameter("address");
		String tel = req.getParameter("tel");
		
		System.out.println("name: " + name);
		System.out.println("age: " + age);
		System.out.println("gender: " + gender);
		System.out.println("address: " + address);
		System.out.println("tel: " + tel);
		
		
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/ex05data.jsp");
//		dispatcher.forward(req, resp);
	}
}