package com.test.ajax.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.test.ajax.model.AddressDTO;
import com.test.ajax.repository.AjaxDAO;

@WebServlet("/add.do")
public class Add extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Add.java
		
		//1. 데이터 가져오기
		//2. DB 작업 > insert
		//3. 피드백 반환
		
		//1.
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		String address = req.getParameter("address");
		
		//2.
		AjaxDAO dao = new AjaxDAO();
		
		AddressDTO dto = new AddressDTO();
		dto.setName(name);
		dto.setAge(age);
		dto.setGender(gender);
		dto.setAddress(address);
		
		int result = dao.addAddress(dto);
		
		//3.
		JSONObject obj = new JSONObject();
		obj.put("result", result);
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = resp.getWriter();
		writer.print(obj.toString());
		writer.close();

	}
}