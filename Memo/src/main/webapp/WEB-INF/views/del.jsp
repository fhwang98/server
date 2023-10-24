<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>
	
</style>
</head>
<body>
	<!-- del.jsp -->
	
	<%@ include file="/WEB-INF/views/inc/header.jsp" %>
	
	<form method="POST" action="/memo/delok.do">
	<table class="vertical">
		<tr>
			<th>암호</th>
			<td><input type="password" name="pw" required></td>
		</tr>
	</table>
	<div>
		<input type="button" value="돌아가기" onclick="location.href='/memo/list.do';">
		<input type="submit" value="삭제하기">
	</div>
	<input type="hidden" name="seq" value="${ seq }">	
	</form>

	<script>
		
	</script>	
</body>
</html>