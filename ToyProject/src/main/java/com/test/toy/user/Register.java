package com.test.toy.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.test.toy.user.model.UserDTO;
import com.test.toy.user.repository.UserDAO;

@WebServlet("/user/register.do")
public class Register extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Register.java
		// 브라우저로 그냥 페이지를 열었을 때 > Get

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/register.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Register.java
		// 회원가입을 완료하고 form 태그 > Post
		// 회원가입 데이터를 받아서 DB작업 (RegisterOK 역할)
		
		//1. 데이터 가져오기
		//2. DB 작업 > insert
		//3. 피드백
		
		//enctype="multipart/form-data"
		//req.getParameter() 동작 불가능 > multipartRequest 대체

		try {
			MultipartRequest multi = new MultipartRequest(
										req,
										req.getRealPath("/asset/pic"),
										1024 * 1024 * 10,
										"UTF-8",
										new DefaultFileRenamePolicy()
									);
			//System.out.println(req.getRealPath("/asset/pic"));
			///Users/eugene/class/code/server/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ToyProject/asset/pic
			
			String id = multi.getParameter("id");
			String pw = multi.getParameter("pw");
			String name = multi.getParameter("name");
			String email = multi.getParameter("email");
			String pic = multi.getFilesystemName("pic");
			String intro = multi.getParameter("intro");
			
			UserDTO dto = new UserDTO();
			
			dto.setId(id);
			dto.setPw(pw);
			dto.setName(name);
			dto.setEmail(email);
			dto.setPic(pic);
			dto.setIntro(intro);
			
			UserDAO dao = new UserDAO();
			
			int result = dao.register(dto);
			
			if (result == 1) {
				resp.sendRedirect("/toy/index.do");
			}
			
		} catch (Exception e) {
			System.out.println("Register.doPost()");
			e.printStackTrace();
		}
		
		// 0 또는 에러
		PrintWriter writer = resp.getWriter();
		writer.print("<script>alert('failed');history.back();</script>");
		writer.close();
		
	}
}