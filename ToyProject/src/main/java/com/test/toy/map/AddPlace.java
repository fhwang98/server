package com.test.toy.map;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

@WebServlet("/map/addplace.do")
public class AddPlace extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//AddPlace.java
		//1.
		String lat = req.getParameter("lat");
		String lng = req.getParameter("lng");
		String name = req.getParameter("name");
		String category = req.getParameter("category");
		
		//2.
		MapDAO dao = new MapDAO();
		PlaceDTO dto = new PlaceDTO();
		dto.setLat(lat);
		dto.setLng(lng);
		dto.setName(name);
		dto.setCategory(category);
		
		int result = dao.addPlace(dto);
		
		//3. 피드백
		resp.setContentType("application/json");
		
		JSONObject obj = new JSONObject();
		obj.put("result", result);
		
		PrintWriter writer = resp.getWriter();
		writer.write(obj.toString());
		writer.close();

	}
}