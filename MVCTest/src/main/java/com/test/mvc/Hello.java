package com.test.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Hello extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 서블릿 호출
		// 업무 처리
		
		//HTML 페이지 생산 > 불편;; > JSP 위임
		//resp.sendRedirect("/mvc/hello.jsp");
		
		//DB 작업 > select count(*)
		int count = 100;
		
		// 서블릿 > 자신의 업무 완료 > 산출물 일부 > 출력 > JSP 페이지 전달 
		req.setAttribute("count", count);
		
		//resp.sendRedirect("/mvc/hello.jsp");
		//pageContext.forward("/mvc/hello.jsp");
		
		// '/' > webapp 폴더
		//sendRedirect로 전달하지 않고 forward 메소드로 전달한 이유
		// request에 데이터를 담아서 jsp로 전달
		//주소창에는 hello.do 보고있지만 실제로는 jsp 페이지
		// 서블릿을 부르면 서블릿이 일을 다하고 jsp를 부름
		// jsp를 바로 부르면 > 데이터 없음
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/hello.jsp");
		dispatcher.forward(req, resp); //pageContext.forward()
		
	}

}
