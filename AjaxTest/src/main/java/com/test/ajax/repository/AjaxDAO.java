package com.test.ajax.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.ajax.model.MemoDTO;

public class AjaxDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public AjaxDAO() {
		this.conn = DBUtil.open();
	}

	public int getMemoCount() {
		
		try {
			
			String sql = "SELECT count(*) as cnt FROM tblMemo";
			
			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			System.out.println("AjaxDAO.getMemoCount()");
			e.printStackTrace();
		}
		
		return 0;
	}

	public int getMemoCount(String name) {
		
		try {
			
			String sql = String.format("SELECT count(*) as cnt FROM tblMemo WHERE name = '%s'", name);
			
			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			System.out.println("AjaxDAO.getMemoCount()");
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList<MemoDTO> listMemo() {
		
		try {
			
			String sql = "SELECT * FROM tblMemo ORDER BY seq DESC";
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			ArrayList<MemoDTO> list = new ArrayList<MemoDTO>();
			
			//ResultSet > 복사 < ArrayList<MemoDTO
			
			while (rs.next()) {
				
				//메모 1개 = 레코드 1줄 => MemoDTO 1개
				MemoDTO dto = new MemoDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setPw(rs.getString("pw"));
				dto.setMemo(rs.getString("memo"));
				dto.setRegdate(rs.getString("regdate"));
				
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("AjaxDAO.listMemo()");
			e.printStackTrace();
		}
		
		return null;
	}

	public MemoDTO get(int seq) {
		
		try {
			
			String sql ="SELECT * FROM tblMemo WHERE seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, seq);
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				
				MemoDTO dto = new MemoDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setPw(rs.getString("pw"));
				dto.setMemo(rs.getString("memo"));
				dto.setRegdate(rs.getString("regdate"));
				
				return dto;
			}
			
		} catch (Exception e) {
			System.out.println("AjaxDAO.get()");
			e.printStackTrace();
		}
		return null;
	}

	public int check(String id) {
		try {
			
			String sql = "SELECT count(*) as cnt FROM tblUser WHERE id = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				return rs.getInt("cnt"); 
			}
			
		} catch (Exception e) {
			System.out.println("AjaxDAO.check()");
			e.printStackTrace();
		}
		return 0;
	}

	public void updatePosition(CatDTO dto) {
		
		try {
			
			String sql = "UPDATE tblCat SET x = ? , y = ? WHERE catid =?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getX());
			pstat.setString(2, dto.getY());
			pstat.setString(3, dto.getCatid());
			
			pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("AjaxDAO.updatePosition()");
			e.printStackTrace();
		}
		
	}

	public ArrayList<CatDTO> listCat() {
		
		try {
			
			String sql = "SELECT * FROM tblCat";
			
			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);
			
			ArrayList<CatDTO> list = new ArrayList<CatDTO>();
			
			while (rs.next()) {
				
				// 레코드 1줄 > CatDTO 1개
				CatDTO dto = new CatDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setX(rs.getString("x"));
				dto.setY(rs.getString("y"));
				dto.setCatid(rs.getString("catid"));
			
				list.add(dto);
			}
			
			rs.close();
			stat.close();
			conn.close();
			
			return list;
			
		} catch (Exception e) {
			System.out.println("AjaxDAO.listCat()");
			e.printStackTrace();
		}
		
		return null;
	}
	
}
