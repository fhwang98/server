package com.test.ajax.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.test.ajax.repository.AjaxDAO;

@WebServlet("/edit.do")
public class Edit extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Edit.java
		//1. 데이터 가져오기(seq, column, value)
		//2. DB 작업 > update
		//3. 피드백 > JSON
		
		//1.
		String seq = req.getParameter("seq");
		String column = req.getParameter("column");
		String value = req.getParameter("value");
		
		//2.
		AjaxDAO dao = new AjaxDAO();
		
		//HashMap으로 
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("seq", seq);
		map.put("column", column);
		map.put("value", value);
		
		int result = dao.editAddress(map);
		
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









