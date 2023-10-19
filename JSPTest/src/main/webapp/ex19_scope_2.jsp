<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String a = request.getParameter("a");
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
	<!-- ex19_scope_2.jsp -->
	<h1>두번째 페이지</h1>
	
	<%-- <p>1. 지역 변수 a: <%= a %></p> --%>
	<p>1. 지역 변수 a: <%= a %></p>
	<%-- <p>2. 멤버 변수 b: <%= b %></p> --%>
	<p>3. pageContext c: <%= pageContext.getAttribute("c") %></p>
	<p>4. request d: <%= request.getAttribute("d") %></p>
	<p>5. session e: <%= session.getAttribute("e") %></p>
	<p>6. application f: <%= application.getAttribute("f") %></p>
	

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="http://pinnpublic.dothome.co.kr/cdn/example-min.js"></script>
	<script>
		
	</script>	
</body>
</html>