package com.test.toy.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.toy.user.model.UserDTO;
import com.test.toy.user.repository.UserDAO;

@WebServlet("/user/login.do")
public class Login extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Login.java

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/login.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// LoginOk 역할
		//1. 데이터 가져오기 (id, pw)
		//2. DB 작업 > select
		//3. 인증 티켓 발급?
		//4. 피드백
		
		//1. 
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		//2.
		UserDAO dao = new UserDAO();
		
		UserDTO dto = new UserDTO();
		dto.setId(id);
		dto.setPw(pw);
		
		UserDTO result = dao.login(dto);
		
		if (result != null) {
			//로그인 성공
			req.getSession().setAttribute("id", id); // 인증 티켓
			
			req.getSession().setAttribute("name", result.getName());
			req.getSession().setAttribute("lv", result.getLv());
			
			resp.sendRedirect("/toy/index.do");
			
		} else {
			//로그인 실패
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('failed');history.back();</script>");
			writer.close();
			
		}
		
	}
}