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

@WebServlet("/editok.do")
public class EditOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//EditOk.java
		
		//1. 데이터 가져오기(수정 데이터)
		//2. DB 작업 > update > DAO 위임
		//3. 결과 > 피드백 > JSP 호출하기
		
		//1.
		req.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("name");
		String memo = req.getParameter("memo");
		String seq = req.getParameter("seq");
		String pw = req.getParameter("pw"); // 권한 확인용
		
		//2.
		MemoDAO dao = new MemoDAO();
		
		MemoDTO dto = new MemoDTO();
		dto.setName(name);
		dto.setMemo(memo);
		dto.setSeq(seq);
		dto.setPw(pw);
		
		//암호 확인
		boolean flag = dao.check(dto);
		
		
		int result = 0; // 수정 성공(1), 실패(0), 암호틀림(2)
		
		if (flag) {
			result = dao.edit(dto); 			
		} else {
			result = 2;
		}
		
		//3. 
		req.setAttribute("result", result);
		req.setAttribute("seq", seq);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/editok.jsp");
		dispatcher.forward(req, resp);
	}
}