package com.test.ajax.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.ajax.model.AddressDTO;
import com.test.ajax.model.CatDTO;
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

	public ArrayList<AddressDTO> listAddress() {
		
		try {
			
			String sql = "SELECT seq, name, age, gender, address, to_char(regdate, 'YYYY-MM-DD') AS regdate FROM tblAddress ORDER BY seq DESC";

			stat = conn.createStatement();
			rs= stat.executeQuery(sql);
			
			ArrayList<AddressDTO> list = new ArrayList<AddressDTO>();
			
			while(rs.next()) {
				//레코드 1줄 == AddressDTO 1개
				AddressDTO dto = new AddressDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getString("age"));
				dto.setGender(rs.getString("gender"));
				dto.setAddress(rs.getString("address"));
				dto.setRegdate(rs.getString("regdate"));
				
				list.add(dto);
				
			}
			
			rs.close();
			stat.close();
			conn.close();
			
			return list;
			
		} catch (Exception e) {
			System.out.println("AjaxDAO.listAddress()");
			e.printStackTrace();
		}
		
		return null;
	}

	public int addAddress(AddressDTO dto) {
		
		try {
			
			String sql = "INSERT INTO tblAddress (seq, name, age, gender, address, regdate) VALUES (seqAddress.nextVal, ?, ?, ?, ?, default)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getName());
			pstat.setString(2, dto.getAge());
			pstat.setString(3, dto.getGender());
			pstat.setString(4, dto.getAddress());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("AjaxDAO.addAddress()");
			e.printStackTrace();
		}
		
		return 0;
	}

	public int editAddress(HashMap<String, String> map) {
		
		try {
			
			String sql = String.format("UPDATE tblAddress SET %s = ? WHERE seq = ?", map.get("column"));
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, map.get("value"));
			pstat.setString(2, map.get("seq"));
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("AjaxDAO.editAddress()");
			e.printStackTrace();
		}
		
		return 0;
	}

	public int delAddress(String seq) {
		
		try {
			
			String sql = "DELETE FROM tblAddress WHERE seq = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("AjaxDAO.delAddress()");
			e.printStackTrace();
		}
		
		return 0;
	}
	
}
