package com.test.toy.board.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.test.toy.DBUtil;
import com.test.toy.board.model.BoardDTO;
import com.test.toy.board.model.CommentDTO;

public class BoardDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public BoardDAO() {
		this.conn = DBUtil.open();
	}

	public int add(BoardDTO dto) {
		
		try {
			String sql = "INSERT INTO tblboard (seq, subject, content, regdate, readcount, id)\n"
					+ "	VALUES (seqboard.nextVal, ?, ?, DEFAULT, DEFAULT, ?)";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getSubject());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getId());

			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("BoardDAO.add()");
			e.printStackTrace();
		}
		
		return 0;
	}

	public ArrayList<BoardDTO> list(HashMap<String, String> map) {
		
		try {
			
			String where = "";
			
			if (map.get("search").equals("y")) {
				where = String.format("WHERE %s LIKE '%%%s%%'", map.get("column"), map.get("word"));
			}
			
			String sql = String.format("SELECT * FROM (SELECT a.*, rownum AS rnum FROM vwBoard a %s) WHERE rnum BETWEEN %s AND %s"
																			, where
																			, map.get("begin")
																			, map.get("end"));
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);	
			
			ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
			
			while (rs.next()) {
				
				BoardDTO dto = new BoardDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setSubject(rs.getString("subject"));
				dto.setId(rs.getString("id"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setName(rs.getString("name"));
				dto.setIsnew(rs.getString("isnew"));
				dto.setCcnt(rs.getString("ccnt"));
				
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("BoardDAO.list()");
			e.printStackTrace();
		}
		
		return null;
	}

	public BoardDTO get(String seq) {
		
		try {
			
			String sql = "SELECT tblBoard.*, (SELECT name FROM tbluser WHERE id = tblboard.id) AS name FROM tblBoard WHERE seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();	
			
			if (rs.next()) {
				
				BoardDTO dto = new BoardDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setId(rs.getString("id"));
				
				dto.setName(rs.getString("name"));
				
				return dto;
			}
			
		} catch (Exception e) {
			System.out.println("BoardDAO.get()");
			e.printStackTrace();
		}
		
		return null;
	}

	public void updateReadcount(String seq) {

		try {
			String sql = "UPDATE tblBoard SET readcount = readcount + 1 WHERE seq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);

			pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("BoardDAO.updateReadcount()");
			e.printStackTrace();
		}
		
	}

	public int edit(BoardDTO dto) {
		
		try {
			String sql = "UPDATE tblBoard set subject = ?, content = ? WHERE seq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getSubject());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getSeq());

			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("BoardDAO.edit()");
			e.printStackTrace();
		}
		
		return 0;
	}

	public int del(String seq) {
		
		try {
			String sql = "DELETE FROM tblBoard WHERE seq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);

			return pstat.executeUpdate();
			

		} catch (Exception e) {
			System.out.println("BoardDAO.del()");
			e.printStackTrace();
		}
		
		return 0;
	}

	public int getTotalCount() {
		
		try {

			String sql = "SELECT count(*) AS cnt FROM tblboard";

			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			if (rs.next()) {
				return rs.getInt("cnt");
			}

		} catch (Exception e) {
			System.out.println("BoardDAO.getTotalCount()");
			e.printStackTrace();
		}
		
		return 0;
	}

	public int addComment(CommentDTO dto) {
		
		try {
			String sql = "INSERT INTO tblcomment (seq, content, regdate, id, bseq) "
					+ "VALUES (seqComment.nextVal, ?, DEFAULT, ?, ?)";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getContent());
			pstat.setString(2, dto.getId());
			pstat.setString(3, dto.getBseq());

			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("BoardDAO.addComment()");
			e.printStackTrace();
		}
		
		return 0;
	}

	public ArrayList<CommentDTO> listComment(String bseq) {
		
		try {
			
			String sql = "SELECT c.*, (SELECT name FROM tblUser WHERE id = c.id) AS name "
					+ "FROM tblComment c WHERE bseq = ? ORDER BY seq DESC";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, bseq);
			
			rs = pstat.executeQuery();	
			
			ArrayList<CommentDTO> list = new ArrayList<CommentDTO>();
			
			while (rs.next()) {
				
				CommentDTO dto = new CommentDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setId(rs.getString("id"));
				dto.setBseq(rs.getString("bseq"));
				
				dto.setName(rs.getString("name"));
				
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("BoardDAO.listComment()");
			e.printStackTrace();
		}
		
		return null;
	}

	public int delComment(String seq) {
		
		try {
			String sql = "DELETE FROM tblComment WHERE seq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);

			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("BoardDAO.delComment()");
			e.printStackTrace();
		}
		
		return 0;
	}

	public void delCommentAll(String seq) {
		
		try {
			String sql = "DELETE FROM tblComment WHERE bseq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);

			pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("BoardDAO.delCommentAll()");
			e.printStackTrace();
		}
		
	}

	public int editComment(CommentDTO dto) {
		
		try {
			String sql = "UPDATE tblComment SET content = ? WHERE seq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getContent());
			pstat.setString(2, dto.getSeq());

			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("BoardDAO.editComment()");
			e.printStackTrace();
		}
		
		return 0;
	}
	
}
