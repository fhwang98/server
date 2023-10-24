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
	<!-- view.jsp -->
	
	<%@ include file="/WEB-INF/views/inc/header.jsp" %>
	
	<table class="vertical">
		<tr>
			<th>번호</th>
			<td>${ dto.seq }</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${ dto.name }</td>
		</tr>
		<tr>
			<th>메모</th>
			<td style="word-break:break-all;">${ dto.memo }</td>
		</tr>
		<tr>
			<th>날짜</th>
			<td>${ dto.regdate }</td>
		</tr>
	</table>
	<div>
		<input type="button" value="돌아가기" onclick="location.href='/memo/list.do';">
		<input type="button" value="수정하기" onclick="location.href='/memo/edit.do?seq=${dto.seq}';">
		<input type="button" value="삭제하기" onclick="location.href='/memo/del.do?seq=${dto.seq}';">
	</div>

	<script>
		
	</script>	
</body>
</html>