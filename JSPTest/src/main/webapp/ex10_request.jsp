<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<!-- ex10_request.jsp -->
	<h1>request</h1>
	
	<p>요청 URL: <%= request.getRequestURI() %></p>
	<p>요청 서버 도메인: <%= request.getServerName()%></p>
	<p>요청 방식: <%= request.getMethod() %></p>
	<p>클라이언트 주소(IP): <%= request.getRemoteAddr() %></p>
	<p>컨텍스트 경로: <%= request.getContextPath() %></p>
	
	<a href="ex09.jsp">9번 예제</a>
	<a href="/jsp/ex09.jsp">9번 예제</a>
	<a href="<%= request.getContextPath() %>/ex09.jsp">9번 예제</a>

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="http://pinnpublic.dothome.co.kr/cdn/example-min.js"></script>
	<script>
		
	</script>	
</body>
</html>