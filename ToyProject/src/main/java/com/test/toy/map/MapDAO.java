package com.test.toy.map;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.toy.DBUtil;

import oracle.net.aso.s;

public class MapDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public MapDAO() {
		this.conn = DBUtil.open();
	}

	public int add(MapDTO dto) {
		
		try {
			String sql = "INSERT INTO tblMarker (seq, lat, lng) VALUES (seqMarker.nextVal, ?, ?)";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getLat());
			pstat.setString(2, dto.getLng());

			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("MapDAO.add()");
			e.printStackTrace();
		}
		
		return 0;
	}

	public ArrayList<MapDTO> list() {
		
		try {
			
			String sql = "SELECT * FROM tblMarker";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);	
			
			ArrayList<MapDTO> list = new ArrayList<MapDTO>();
			
			while (rs.next()) {
				
				MapDTO dto = new MapDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setLat(rs.getString("lat"));
				dto.setLng(rs.getString("lng"));
				
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("MapDAO.list()");
			e.printStackTrace();
		}
		
		return null;
	}

	public int addPlace(PlaceDTO dto) {
		
		try {
			String sql = "INSERT INTO tblPlace (seq, lat, lng, name, category) VALUES (seqPlace.nextVal, ?, ?, ?, ?)";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getLat());
			pstat.setString(2, dto.getLng());
			pstat.setString(3, dto.getName());
			pstat.setString(4, dto.getCategory());

			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("MapDAO.addPlace()");
			e.printStackTrace();
		}
		
		return 0;
	}
	
}
