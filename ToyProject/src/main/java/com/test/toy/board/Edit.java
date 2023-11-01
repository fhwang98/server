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

@WebServlet("/board/edit.do")
public class Edit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Edit.java
		
		//- view.do > 수정하기 버튼 클릭 > edit.do?seq=${}
		
		//1. 데이터 가져오기
		String seq = req.getParameter("seq");
		
		//2. DB > select
		BoardDAO dao = new BoardDAO();
		
		BoardDTO dto = dao.get(seq);
		
		// 제목 태그 
		String subject = dto.getSubject();
		subject = subject.replace("\"", "&quot;");
		dto.setSubject(subject);

		//3. 결과 + JSP 호출하기
		req.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/edit.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//수정하기
	
		//EditOK 역할
		
		//session에서 id 미리 꺼내기
		HttpSession session = req.getSession();
				
		//1. 데이터 가져오기
		String seq = req.getParameter("seq");
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		
		//2. DB > update
		BoardDAO dao = new BoardDAO();
		
		BoardDTO dto = new BoardDTO();
		dto.setSeq(seq); // 수정할 글번호
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setId(session.getAttribute("id").toString());
		
		int result = dao.edit(dto);
		
		//3. 피드백
		if (result == 1) {
			//성공 > 목록보기
			resp.sendRedirect("/toy/board/view.do?seq=" + seq);
		} else {
			//실패
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('failed');history.back();</script>");
			writer.close();
		}
	
	}
}