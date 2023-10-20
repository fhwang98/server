package com.text.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Ex04_PreparedStatement {

	public static void main(String[] args) {
		
		m1();
		
	}

	private static void m1() {
		
		// Statement vs PreparedStatement
		//- Statement > 정적 SQL(매개변수 X)
		//- PreparedStatement > 동적 SQL(매개변수 O)
		
		//PreparedStatement 장점
		//1. 매개변수 관리 용이
		//2. 매개변수 유효성 처리
		
		
		
		//정적 SQL
		String sql = "INSERT INTO tblAddress (seq, name, age, gender, address, regdate)\n"
				+ "	VALUES (seqAddress.nextVal, '아무개', 22, 'm', '서울시 강남구 대치동', default)";
		
		//정적 SQL
		sql = "INSERT INTO tblAddress (seq, name, age, gender, address, regdate)\n"
				+ "	VALUES (seqAddress.nextVal, '%s', %s, '%s', '%s', default)"; 
		
		//동적 SQL
		//오라클 매개변수를 이용한 쿼리 -> 동적 쿼리
		sql = "INSERT INTO tblAddress (seq, name, age, gender, address, regdate)\n"
				+ "	VALUES (seqAddress.nextVal, ?, ?, ?, ?, default)";
		
		
		//insert + 사용자 입력 + Scanner
		String name = "하하하";
		String age = "20";
		String gender = "m";
		String address = "서울시 강남구 역삼동 's 아파트";
		
		//Statement
		//ORA-00917: missing comma > "'"에 이스케이프
//		name = name.replace("'", "''");
//		address = address.replace("'", "''");
		
		Connection conn = null;
		// Statement or PreparedState 원래는 둘중 하나만 사용
		Statement stat = null;
		PreparedStatement pstat = null;
		
		try {
			conn = DBUtil.open();
			
			//Statement
//			sql = String.format("INSERT INTO tblAddress (seq, name, age, gender, address, regdate)\n"
//					+ "	VALUES (seqAddress.nextVal, '%s', %s, '%s', '%s', default)", name, age, gender, address);
//			
//			System.out.println(sql);
//			
//			stat = conn.createStatement();
//			
//			int result = stat.executeUpdate(sql);
//			
//			System.out.println(result);
			
			
			//PreparedStatement
			sql = "INSERT INTO tblAddress (seq, name, age, gender, address, regdate)\n"
					+ "	VALUES (seqAddress.nextVal, ?, ?, ?, ?, default)";
			
			//만들때 sql 쿼리를 매개변수로 받음 실행할 때는 매개변수 x
			pstat = conn.prepareStatement(sql);

			// 그냥 실행해버리면
			// 인덱스에서 누락된 IN 또는 OUT 매개변수:: 1
			// 1번째 매개변수가 누락됐어요
//			int result = pstat.executeUpdate();

			//pstat > 매개변수를 관리하는 역할 겸함
			pstat.setString(1, name);
			pstat.setString(2, age);
			pstat.setString(3, gender);
			pstat.setString(4, address);
			
			int result = pstat.executeUpdate();
			
			System.out.println(result);
			
			pstat.close();
			conn.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
