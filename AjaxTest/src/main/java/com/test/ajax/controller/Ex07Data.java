package com.test.ajax.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.ajax.repository.AjaxDAO;
import com.test.ajax.repository.CatDTO;

@WebServlet("/ex07data.do")
public class Ex07Data extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Ex07Data.java

		String x = req.getParameter("x");
		String y = req.getParameter("y");
		String catid = req.getParameter("catid");
		
		AjaxDAO dao = new AjaxDAO();
		CatDTO dto = new CatDTO();
		dto.setX(x);
		dto.setY(y);
		dto.setCatid(catid);
		
		dao.updatePosition(dto);
		
	}
}