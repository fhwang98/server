package com.test.toy.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		// 권한 체크
		//System.out.println("권한 체크 필터");
		
		// 인증받지 못한 사용자 내쫓기!!
		//HttpServletRequest req > getSession() (O)
		//ServletRequest req > getSession() (X)
		HttpServletRequest httpReq = (HttpServletRequest)req;
		HttpServletResponse httpResp = (HttpServletResponse)resp;
		
		HttpSession session = httpReq.getSession();
		
//		if (session.getAttribute("id") == null) {
//			System.out.println("비회원");
//		} else {
//			System.out.println("회원: " + session.getAttribute("id"));
//		}
//		System.out.println();
		
		//익명 사용자 > 배제
		//현재 요청한 페이지가 뭔지 확인
		//System.out.println(httpReq.getRequestURI());
		
		if (session.getAttribute("id") == null)	{
			
			if (httpReq.getRequestURI().endsWith("add.do")
					|| httpReq.getRequestURI().endsWith("edit.do")
					|| httpReq.getRequestURI().endsWith("del.do")
					|| httpReq.getRequestURI().endsWith("info.do")) {
				
				//httpResp.sendRedirect("/toy/user/login.do");
				
				PrintWriter writer = httpResp.getWriter();
				
				writer.write("<script>alert('unauthorized');location.href='/toy/user/login.do';</script>");
				
				writer.close();
				
				return;
			}
		}
		
		
		//서블릿 호출
		chain.doFilter(req, resp);
		
	}

}
