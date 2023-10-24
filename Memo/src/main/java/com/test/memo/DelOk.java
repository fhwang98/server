package com.test.memo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.memo.model.MemoDTO;
import com.test.memo.repository.MemoDAO;

@WebServlet("/delok.do")
public class DelOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//DelOk.java
		//1. 데이터 가져오기 seq, pw
		//2. 암호 확인 > 권한?
		//3. DB 작업 > delete > DAO
		//3. 피드백 > JSP 호출
		
		//1. 
		String seq = req.getParameter("seq");
		String pw = req.getParameter("pw");
		
		//2. 
		MemoDAO dao = new MemoDAO();
		MemoDTO dto = new MemoDTO();
		dto.setSeq(seq);
		dto.setPw(pw);
		
		// 암호 확인
		int result = 0;
		
		if (dao.check(dto)) {
			result = dao.del(seq);
		} else {
			result = 2;
		}
		
		//3.
		req.setAttribute("result", result);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/delok.jsp");
		dispatcher.forward(req, resp);
	}
}