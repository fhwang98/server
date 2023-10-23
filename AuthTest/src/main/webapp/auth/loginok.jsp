<%@page import="com.test.auth.DBUtil"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//loginok.jsp
	
	//1. 데이터 가져오기(id, pw)
	//2. DB 작업 > select
	//3.1 존재O > 인증 티켓 발급
	//3.2 존재X > 아무일x
	//4. 피드백
	
	//1.
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	//2.
	Connection conn = null;
	PreparedStatement stat = null;
	ResultSet rs = null;
	
	try {
		conn = DBUtil.open();
		
		String sql = "SELECT * FROM tblUser WHERE id = ? AND pw = ?";
		
		stat = conn.prepareStatement(sql);
		stat.setString(1, id);
		stat.setString(2, pw);
		
		rs = stat.executeQuery();
		
		if (rs.next()) {
			System.out.println("로그인 성공");
			
			//로그인 성공 > 인증 티켓 발견 > 세션 안에 로그인을 성공했다는 표시를 저장!!(세션 > 전역 변수, 개인 공간)
			session.setAttribute("auth", id); // 인증 티켓
			
			session.setAttribute("name", rs.getString("name"));
			session.setAttribute("lv", rs.getString("lv"));
			
			response.sendRedirect("../index.jsp");
			
		} else {
			System.out.println("로그인 실패");
			response.sendRedirect("login.jsp");
		}
		
		rs.close();
		stat.close();
		conn.close();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://pinnpublic.dothome.co.kr/cdn/example-min.css">
<style>
	
</style>
</head>
<body>
	<!-- loginok.jsp -->

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="http://pinnpublic.dothome.co.kr/cdn/example-min.js"></script>
	<script>
		
	</script>	
</body>
</html>