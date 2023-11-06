package com.test.toy.map;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

@WebServlet("/map/addmarker.do")
public class AddMarker extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//AddMarker.java
		
		//1.
		String lat = req.getParameter("lat");
		String lng = req.getParameter("lng");
		
		//2.
		MapDAO dao = new MapDAO();
		MapDTO dto = new MapDTO();
		dto.setLat(lat);
		dto.setLng(lng);
		
		int result = dao.add(dto);

		//3. 피드백
		resp.setContentType("application/json");
		
		JSONObject obj = new JSONObject();
		obj.put("result", result);
		
		PrintWriter writer = resp.getWriter();
		writer.write(obj.toString());
		writer.close();
		
	}
}
