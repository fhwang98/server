package com.test.memo.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.memo.DBUtil;
import com.test.memo.model.MemoDTO;

public class MemoDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public MemoDAO() {
		this.conn = DBUtil.open();
	}
	
	public int add(MemoDTO dto) {

		//DTO > insert
		try {
			
			String sql = "INSERT INTO tblMemo (seq, name, pw, memo, regdate)"
					+ "	VALUES (seqMemo.nextVal, ?, ?, ?, default)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getName());
			pstat.setString(2, dto.getPw());
			pstat.setString(3, dto.getMemo());

			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList<MemoDTO> list() {
		
		//select
		
		ArrayList<MemoDTO> list = new ArrayList<MemoDTO>();
		
		try {
		
			String sql = "SELECT * FROM tblMemo ORDER BY seq DESC";
			
			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);
			
			// rs == 메모 목록
			
			// rs > list
			while (rs.next()) {
				
				// 레코드 1줄 > MemoDTO 1개
				MemoDTO dto = new MemoDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setPw(rs.getString("pw"));
				dto.setMemo(rs.getString("memo"));
				dto.setRegdate(rs.getString("regdate"));
				
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}

	public MemoDTO get(String seq) {
		
		try {
			
			String sql = "SELECT * FROM tblMemo WHERE seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();
			
			MemoDTO dto = new MemoDTO();
			if (rs.next()) {
				
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setPw(rs.getString("pw"));
				dto.setMemo(rs.getString("memo"));
				dto.setRegdate(rs.getString("regdate"));
				
				return dto;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int edit(MemoDTO dto) {
		
		try {
			
			String sql = "UPDATE tblMemo SET name = ?, memo = ? WHERE seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getName());
			pstat.setString(2, dto.getMemo());
			pstat.setString(3, dto.getSeq());
			
			return pstat.executeUpdate();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public boolean check(MemoDTO dto) {
		
		try {
			
			String sql = "SELECT count(*) as cnt FROM tblMemo WHERE seq = ? AND pw = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getSeq());
			pstat.setString(2, dto.getPw());
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				return rs.getInt("cnt") == 1 ? true : false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public int del(String seq) {
		
		try {
			
			String sql = "DELETE FROM tblMemo WHERE seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

}
