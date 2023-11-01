package com.test.toy.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.toy.board.model.BoardDTO;
import com.test.toy.board.repository.BoardDAO;

@WebServlet("/board/list.do")
public class List extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//List.java
		
		HttpSession session = req.getSession();
		
		//조회수 티켓
		session.setAttribute("read", "n");
		
		
		//1. DB 작업 > select
		//2. 반환 > jsp 호출하기
		
		//1.
		BoardDAO dao = new BoardDAO();
		
		ArrayList<BoardDTO> list = dao.list();
		
		//1.5 데이터 가공
		for (BoardDTO dto : list) {
			
			//날짜 자르기
			//String regdate = dto.getRegdate();
			//dto.setRegdate(regdate.substring(0, 10));
			
			// 길이 자르기
			String subject = dto.getSubject();
			if (subject.length() > 20) {
				subject = subject.substring(0, 20) + "...";
			}
			
			//태그 비활성화 처리
			subject = subject.replace("<", "&lt;").replace(">", "&gt;");
			
			
			dto.setSubject(subject);
			
		}
		
		//2.
		req.setAttribute("list", list);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/list.jsp");
		dispatcher.forward(req, resp);
	}
}