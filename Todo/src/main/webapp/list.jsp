<%@page import="com.test.todo.DBUtil"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//list.jsp
	
	//1. DB 작업 > select > ResultSet
	//2. ResultSet > 화면 출력
	
	//1. 
	Connection conn = null;
	Statement stat = null;
	ResultSet rs = null;
	
	try {
		
		conn = DBUtil.open();
		
		String sql = "SELECT * FROM tblTodo ORDER BY state, seq DESC";
		
		stat = conn.createStatement();
		
		rs = stat.executeQuery(sql);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="inc/asset.jsp" %>
<style>
	table td {
		
	}
	table td:nth-child(1) {
		test-align: center;
		width: 20px;
		border-right: 0 ;
	}
	table td:nth-child(2) {
		width: auto;
		border-left: 0;
		border-right: 0;
	}
	table td:nth-child(3) {
		text-align: center;
		width: 20px;
		border-left: 0;
	}
	table td:nth-child(3) > div {
		display: none;
	}
	table tr:hover td:nth-child(3) > div {
		display: block;
		cursor: pointer;
	}
</style>
</head>
<body class="narrow">
	<!-- list.jsp -->
	<%@ include file="inc/header.jsp" %>
	
	<table>
		<% while (rs.next()) { %>
		<tr>
			<td><input type="checkbox" onchange="editTodo(<%= rs.getString("seq") %>);" <% if(rs.getString("state").equals("y")) { out.print("checked"); } %>></td>
			<td>
				<% if (rs.getString("state").equals("n")) { %>
				<div><%= rs.getString("todo") %></div>
				<% } else { %>
				<div style="text-decoration: line-through;">
				<%= rs.getString("todo") %>
				</div>
				<% } %>
			</td>
			<td><div onclick="delTodo(<%= rs.getString("seq") %>);">&times;</div></td>
		</tr>
		<% } %>
	</table>
	
	<div>
		<button class="add" onclick="location.href='add.jsp';">등록하기</button>
	</div>

	<script>
	
		function editTodo(seq) {
			//alert();
			//어떤 할 일을 눌렀는지? > event.target(JavaScript 작업)
			
			//editok.jsp?seq=5
			location.href = 'editok.jsp?seq=' + seq;
			
		}
		
		function delTodo(seq) {
			
			if (confirm('delete?')) {
				location.href = 'delok.jsp?seq=' + seq;
			}
		}
		
	</script>	
</body>
</html>

<%
	try {
		rs.close();
		stat.close();
		conn.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
%>