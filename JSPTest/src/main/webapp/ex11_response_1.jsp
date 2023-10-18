<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 페이지 > (이동) > 페이지
	
	//1. HTML
	//- <a href="">
	//- 사용자 클릭을 통해서..
	
	//2. JavaScript
	//- location.href=''
	//- 자유롭게 프로그램으로 제어 가능
	//- 클라이언트 코드
	
	//3. Servlet, JSP
	//- response.sendRedirect(URL)
	//- 자유롭게 프로그램으로 제어 가능
	//- 서버 코드
	
	//response.sendRedirect("ex11_response_2.jsp");
	
	
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
	<!-- ex11_response_1.jsp -->
	<h1>첫번째 페이지</h1>

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="http://pinnpublic.dothome.co.kr/cdn/example-min.js"></script>
	<script>
		location.href ='ex11_response_2.jsp';	
	</script>	
</body>
</html>