package com.test.toy.map;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/map/ex.do")
public class Ex extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Ex.java
		//- ex.do?no=01 > ex01.jsp
		//- ex.do?no=02 > ex02.jsp
		String no = req.getParameter("no");
		
		
		// ex03
		if (no.equals("03")) {
			// 좌표 가져오기
			MapDAO dao = new MapDAO();
			
			ArrayList<MapDTO> list = dao.list();
			
			req.setAttribute("list", list);
			
		} else if (no.equals("05")) {
			
			MapDAO dao = new MapDAO();
			ArrayList<PlaceDTO> list = dao.listPlace();
			//System.out.println(list);
			
			req.setAttribute("list", list);
			
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/map/ex" + no +".jsp");
		dispatcher.forward(req, resp);
	}
}