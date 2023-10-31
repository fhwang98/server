package com.test.toy.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.toy.user.repository.UserDAO;

@WebServlet("/user/unregister.do")
public class Unregister extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Unregister.java

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/unregister.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//UnregisterOK 역할
		
		//회원 탈퇴
		//탈퇴한다고 해서 삭제하면 안됨 (탈퇴한 회원과 관련된 데이터를 전부 삭제해야됨)
		//- delete(X) -> update(O)
	
		//1.
		String id = req.getSession().getAttribute("id").toString();
		
		//2. DB
		UserDAO dao = new UserDAO();
		
		int result = dao.unregister(id);
		
		//3.
		if (result == 1) {
			//회원 탈퇴 + 로그아웃
			req.getSession().removeAttribute("id");
			req.getSession().removeAttribute("name");
			req.getSession().removeAttribute("lv");
			
			resp.sendRedirect("/toy/index.do");
		} else {
			//실패
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('failed');history.back();</script>");
			writer.close();
			
		}
	}
}