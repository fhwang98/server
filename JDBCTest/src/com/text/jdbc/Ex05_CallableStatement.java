package com.text.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import oracle.jdbc.OracleTypes;
import oracle.jdbc.oracore.OracleType;

public class Ex05_CallableStatement {
	
	public static void main(String[] args) {
		
		
//		m1();
//		m2();
//		m3();
//		m4();
//		m5();
		
	}

	
	private static void m5() {
		
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			
			String sql = "{ call procM5(?) }";
			
			stat = conn.prepareCall(sql);
			
			stat.registerOutParameter(1, OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			//오라클 커서 == 결과 테이블을 탐색하는 참조 객체 == 결과 테이블
			//ResultSet == 결과 테이블을 탐색하는 참조 객체 == 결과 테이블
			//오라클 커서 == ResultSet 동일한 구조
			rs = (ResultSet)stat.getObject(1);
			
			while (rs.next()) {
				System.out.println(rs.getString("name"));
				System.out.println(rs.getInt("age"));
				System.out.println(rs.getString("address"));
				System.out.println();
			}
			
			rs.close();
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void m4() {
		
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			
			String sql = "{ call procM4(?, ?, ?) }";
			stat = conn.prepareCall(sql);
			
			stat.registerOutParameter(1, OracleTypes.VARCHAR);
			stat.registerOutParameter(2, OracleTypes.NUMBER);
			stat.registerOutParameter(3, OracleTypes.VARCHAR);
			
			stat.executeQuery();
			
			System.out.println(stat.getString(1));
			System.out.println(stat.getInt(2));
			System.out.println(stat.getString(3));
			
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void m3() {
		
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			
			String sql = "{ call procM3(?) }";
			stat = conn.prepareCall(sql);
			
			// out 매개변수
			stat.registerOutParameter(1, OracleTypes.NUMBER);
			
			//두 방법중 하나 사용
//			int result = stat.executeUpdate();
			stat.executeQuery(); // ResultSet 안받음
			
			//rs.getInt(1)
			int cnt = stat.getInt(1);
			
			System.out.println(cnt);
			
			stat.close();
			conn.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void m2() {
		
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			
			String sql = "{ call procM2(?, ?, ?, ?) }";
			stat = conn.prepareCall(sql);
			
			stat.setString(1, "홍길동");
			stat.setString(2, "20");
			stat.setString(3, "m");
			stat.setString(4, "서울시 강남구 역삼동");
			
			int result = stat.executeUpdate();
			
			System.out.println(result);
			
			stat.close();
			conn.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void m1() {

		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			
			String sql = "{ call procM1 }";
			stat = conn.prepareCall(sql);
			
			int result = stat.executeUpdate();
			
			System.out.println(result);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
