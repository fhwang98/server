package com.test.memo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.memo.model.MemoDTO;
import com.test.memo.repository.MemoDAO;

@WebServlet("/list.do")
public class List extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//List.java
		
		//1. DB 작업 > select > DAO 위임
		//2. 결과 테이블
		//3. jsp 호출하기(+ 결과 테이블 전달)
		
		//1. + 2.
		MemoDAO dao = new MemoDAO();
		
		ArrayList<MemoDTO> list = dao.list();
		
		//System.out.println(list);
		
		for (MemoDTO dto : list) {
			if (dto.getMemo().length() > 12) {
				dto.setMemo(dto.getMemo().substring(0, 12) + "...");;
			}
		}
		
		//3.
		req.setAttribute("list", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/list.jsp");
		dispatcher.forward(req, resp);
	}
}