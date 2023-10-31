package com.test.toy.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.toy.board.model.BoardDTO;
import com.test.toy.board.repository.BoardDAO;

@WebServlet("/board/add.do")
public class Add extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Add.java

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/add.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//AddOK 역할
		
		//session에서 id 미리 꺼내기
		HttpSession session = req.getSession();
		
		//req.setCharacterEncoding("UTF-8");
		
		//1. 데이터 가져오기
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		
		//2. DB 작업 > insert
		BoardDAO dao = new BoardDAO();
		
		BoardDTO dto = new BoardDTO();
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setId(session.getAttribute("id").toString());
		
		int result = dao.add(dto);
		
		
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