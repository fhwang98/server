<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//logoutok.jsp
	
	//1. 로그아웃 처리
	//2. 피드백
	
	//1. 
	//- 인증 후 == 인증 티켓 소유
	//- 인증 전 == 인증 티켓 미소유
	
	// 로그아웃 == 인증 전으로 돌아가기
	session.removeAttribute("auth"); //로그아웃
	
	response.sendRedirect("../index.jsp");
	
	
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
	<!-- logoutok.jsp -->

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="http://pinnpublic.dothome.co.kr/cdn/example-min.js"></script>
	<script>
		
	</script>	
</body>
</html>