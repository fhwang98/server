package com.test.toy.user.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.test.toy.DBUtil;
import com.test.toy.user.model.UserDTO;

public class UserDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public UserDAO() {
		this.conn = DBUtil.open();
	}
	
	/*
		코드조각 생성
		
		매개변수 유/무
		반환값 유/무 > 단일값, DTO, List<DTO>

		queryNoParamNoReturn
		queryParamNoReturn
		
		queryNoParamTokenReturn
		queryParamTokenReturn
		
		queryNoParamDTOReturn
		queryParamDTOReturn
		
		queryNoParamListReturn
		queryParamListReturn
		
			
	 */
	public int register(UserDTO dto) {
		
		try {
			String sql = "INSERT INTO tblUser (id, pw, name, email, pic, lv, intro, ing) values (?, ?, ?, ?, ?, 1, ?, default)";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			pstat.setString(3, dto.getName());
			pstat.setString(4, dto.getEmail());
			pstat.setString(5, dto.getPic());
			pstat.setString(6, dto.getIntro());

			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("UserDAO.register()");
			e.printStackTrace();
		}
		
		return 0;
	}

	public UserDTO login(UserDTO dto) {

		// 매개변수(O) 반환값(DTO)
		try {
			
			String sql = "SELECT * FROM tblUser WHERE id = ? AND pw = ? AND ing = 'y'";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			
			rs = pstat.executeQuery();	
			
			if (rs.next()) {
				
				UserDTO result = new UserDTO();
				
				result.setId(rs.getString("id"));;
				result.setName(rs.getString("name"));;
				result.setLv(rs.getString("lv"));;
				
				return result;
			}
			
		} catch (Exception e) {
			System.out.println("UserDAO.login()");
			e.printStackTrace();
		}
		
		return null;
	}

	public int unregister(String id) {
		
		try {
			String sql = "UPDATE tblUser SET ing = 'n' WHERE id = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);

			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("UserDAO.unregister()");
			e.printStackTrace();
		}
		
		return 0;
	}

	public UserDTO get(String id) {
		
		try {
			
			String sql = "SELECT * FROM tblUser WHERE id = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			
			rs = pstat.executeQuery();	
			
			if (rs.next()) {
				
				UserDTO dto = new UserDTO();
				
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setPic(rs.getString("pic"));
				dto.setIntro(rs.getString("intro"));
				
				return dto;
			}
			
		} catch (Exception e) {
			System.out.println("UserDAO.get()");
			e.printStackTrace();
		}
		
		return null;
	}

}
