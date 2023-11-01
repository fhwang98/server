<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>
	#view tr:nth-child(4) {height: 100px;}
</style>
</head>
<body>
	<!-- view.jsp -->
	<%@ include file="/WEB-INF/views/inc/header.jsp" %>
	<main id="main">
		<h1 class="sub">게시판 <small>상세보기</small></h1>
		<table class="vertical" id="view">
			<tr>
				<th>번호</th>
				<td>${ dto.seq }</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${ dto.name }(${ dto.id })</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${ dto.subject }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${ dto.content }</td>
			</tr>
			<tr>
				<th>날짜</th>
				<td>${ dto.regdate }</td>
			</tr>
			<tr>
				<th>읽음</th>
				<td>${ dto.readcount }</td>
			</tr>
		</table>
		<div>
			<button type="button" class="back" onclick="location.href='/toy/board/list.do';">뒤로가기</button>
			<c:if test="${ not empty id }">
			<c:if test="${ id == dto.id }">
			<button type="button" class="edit" onclick="location.href='/toy/board/edit.do?seq=${dto.seq}';">수정하기</button>
			<button type="button" class="del" onclick="location.href='/toy/board/del.do?seq=${dto.seq}';">삭제하기</button>
			</c:if>
			</c:if>
		</div>
	</main>

	<script>
		
	</script>
</body>
</html>


