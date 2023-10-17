<%@page import="com.test.jsp.MyMath"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name ="홍길동";
	int age = 20;
	String txt = "<input type='text'>";
	
	String color = "cornflowerblue";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	div {
		color: <%= color %>;
	}
</style>
</head>
<body>
	<!-- ex05.jsp -->
	<h1>스크립틀릿 + 표현식</h1>
	<div>이름: <%= name %></div>
	<div>나이: <%= age %></div>
	<div><%= txt %></div>
	<div><input type="text" value="<%= color %>"></div>
	
	<input type="button" value="버튼" id="btn1">
	
	<hr>
	<!-- The method sum(int, int) is undefined -->
	<%-- <div><%= sum(30, 40) %></div> --%>
	<%
		MyMath m = new MyMath();
	%>
 	<div><%= m.sum(30, 40) %></div>
	
	<script>
		document.getElementById('btn1').onclick = function() {
			alert('<%= color %>');
		};
	</script>
</body>
</html>