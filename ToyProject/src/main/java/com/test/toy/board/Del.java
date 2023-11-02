package com.test.toy.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.toy.board.repository.BoardDAO;

@WebServlet("/board/del.do")
public class Del extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Del.java
		// - del.do?seq=5
		
		
		if (Auth.check(req, resp)) {
			return;
		}
		
		
		//1. 데이터 가져오기 
		String seq = req.getParameter("seq");
		
		//2. JSP 전달
		req.setAttribute("seq", seq);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/del.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//DelOK.java 역할
		
		//1. 데이터 가져오기 (seq)
		String seq = req.getParameter("seq");
		
		//2. DB > delete
		BoardDAO dao = new BoardDAO();
		
		int result = dao.del(seq);
		
		//3. 피드백
		if (result == 1) {
			//성공 > 목록보기
			resp.sendRedirect("/toy/board/list.do");
		} else {
			//실패
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('failed');history.back();</script>");
			writer.close();
		}
		
	}
}