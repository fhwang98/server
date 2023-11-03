package com.test.toy.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.test.toy.board.model.CommentDTO;
import com.test.toy.board.repository.BoardDAO;

@WebServlet("/board/comment.do")
public class Comment extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Comment.java
		
		//1. 데이터 가져오기 (bseq)
		//2. DB > select
		//3. 목록 반환 > JSON 반환
		
		//1.
		String bseq = req.getParameter("bseq");
		
		//2.
		BoardDAO dao = new BoardDAO();
		
		ArrayList<CommentDTO> clist = dao.listComment(bseq);
		
		//3.
		JSONArray arr = new JSONArray(); // ==ArrayList
		
		for (CommentDTO dto : clist) {
			//CommentDTO > JSONObject
			JSONObject obj = new JSONObject();
			
			obj.put("seq", dto.getSeq());
			obj.put("content", dto.getContent());
			obj.put("regdate", dto.getRegdate());
			obj.put("id", dto.getId());
			obj.put("name", dto.getName());
			obj.put("bseq", dto.getBseq());
			
			arr.add(obj);
		}
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = resp.getWriter();
		writer.write(arr.toString()); // 댓글 목록
		writer.close();

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//댓글 쓰기
		//1. 데이터 가져오기 (content, bseq)
		//2. 댓글 작성자 아이지 > session 안에
		//3. DB > insert
		//4. 피드백 > ajax한테
		
		HttpSession session = req.getSession();
		
		//1.
		String content = req.getParameter("content");
		String bseq = req.getParameter("bseq");
		
		//2.
		String id = session.getAttribute("id").toString();
		
		//3.
		BoardDAO dao = new BoardDAO();
		
		CommentDTO dto = new CommentDTO();
		dto.setContent(content);
		dto.setBseq(bseq);
		dto.setId(id);
	
		int result = dao.addComment(dto);
		
		//4.
		resp.setContentType("application/json");
		
		JSONObject obj = new JSONObject();
		obj.put("result", result);
		
		PrintWriter writer = resp.getWriter();
		writer.write(obj.toString());
		writer.close();
		
	}
}