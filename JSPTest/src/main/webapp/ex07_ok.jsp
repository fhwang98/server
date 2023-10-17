<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//클라이언트 > (데이터)> 서버
	//1. POST
	//	- 패킷 본문(body)안에 넣어서 전송
	//	- 택배 상자 안에 넣어서 전송
	//	- 정석
	//	- 자바를 통해서 데이터를 전송 > 인코딩이 자바를 통해서 진행
	//	- 브라우저(UTF-8) > 인터넷(ISO-8859-1) > 톰캣(UFT-8) > 자바JSP(UTF-8)
	//2. GET
	//	- URL 뒤에 붙여서 전송
	//	- 넘겨지는 데이터의 인코딩이 URL 규칙에 따라 인코딩 된다.
	//	- 톰캣(UTF-8) 담당
	
	//데이터 수신하기
	//- String request.getParameter(String key)
	
	//POST 방식으로 넘어 온 데이터 인코딩
	request.setCharacterEncoding("UTF-8");
	
	String txt = request.getParameter("txt");
	String num = request.getParameter("num");
	
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
	<!-- ex07_ok.jsp -->
	<h1>결과</h1>
	<div>문자: <%= txt %></div>
	<div>숫자: <%= num %></div>
	
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="http://pinnpublic.dothome.co.kr/cdn/example-min.js"></script>
	<script>
		
	</script>	
</body>
</html>