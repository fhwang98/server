package com.test.toy.map;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/map/listplace.do")
public class ListPlace extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//ListPlace.java
		
		//1.
		MapDAO dao = new MapDAO();
		
		ArrayList<PlaceDTO> list = dao.listPlace();
		
		//2. list > JSONArray
		resp.setContentType("application.json");
		resp.setCharacterEncoding("UTF-8");
		
		JSONArray arr = new JSONArray();
		
		for (PlaceDTO dto : list) {
			//DTO > JSONObject
			JSONObject obj = new JSONObject();
			
			obj.put("seq", dto.getSeq());
			obj.put("lat", dto.getLat());
			obj.put("lng", dto.getLng());
			obj.put("name", dto.getName());
			obj.put("category", dto.getCategory());
			
			arr.add(obj);
			
		}
		
		PrintWriter writer = resp.getWriter();
		writer.write(arr.toString());
		writer.close();
		
	}
}