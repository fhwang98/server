<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//첫번째 페이지(데이터 생성) > 두번째 페이지(데이터 사용)
	
	//1. 지역 변수 > 실패
	int a = 10;
	
	//3. pageContext 객체 > 실패
	pageContext.setAttribute("c", 30);
	
	//4. request 객체 > 실패
	request.setAttribute("d", 40);
	
	//5. session 객체
	session.setAttribute("e", 50);
	
	//6. application 객체
	application.setAttribute("f", 60);
	
	//response.sendRedirect("ex19_scope_2.jsp");
	
	//pageContext.forward("ex19_scope_2.jsp");
	
	//request + forward
	
%>
<%!
	
	//2. 멤버 변수 > 실패
	int b = 20;
	
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
	<!-- ex19_scope_1.jsp -->
	<h1>첫번째 페이지</h1>
	
	<a href="ex19_scope_2.jsp?a=<%= a %>">두번째 페이지</a>
	
	<hr>
	
	<input type="button" value="두번째 페이지" id="btn1">

	<hr>
	
	<form method="GET" action="ex19_scope_2.jsp">
		<input type="hidden" name="a" value="<%= a %>">
		<input type="submit" value="두번째 페이지">
	</form>

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="http://pinnpublic.dothome.co.kr/cdn/example-min.js"></script>
	<script>
		$('#btn1').click(function() {
			location.href = 'ex19_scope_2.jsp?a=<%= a %>';
		});
	</script>	
</body>
</html>