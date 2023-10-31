<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>
	#list th:nth-child(1) {width: 50px;}
	#list th:nth-child(2) {width: auto;}
	#list th:nth-child(3) {width: 70px;}
	#list th:nth-child(4) {width: 120px;}
	#list th:nth-child(5) {width: 50px;}
	
	#list td {text-align: center;}
	#list td:nth-child(2) {text-align: left;}
	
	.is-new {
		font-size: 13px;
		color: tomato;
	}
</style>
</head>
<body>
	<!-- list.jsp -->
	<%@ include file="/WEB-INF/views/inc/header.jsp" %>
	<main id="main">
		<h1>게시판 <small>목록</small></h1>
		<table id="list">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>이름</th>
				<th>날짜</th>
				<th>읽음</th>
			</tr>
			
			<c:forEach items="${ list }" var="dto">
			<tr>
				<td>${ dto.seq }</td>
				<td>
					${ dto.subject }
					<c:if test="${ dto.isnew == 1 }">
					<span class="is-new">new</span>
					</c:if>
				</td>
				<td>${ dto.name }</td>
				<td>${ dto.regdate }</td>
				<td>${ dto.readcount }</td>
			</tr>
			</c:forEach>
		</table>
		<div>
			<button type="button" class="list" onclick="location.href='/toy/board/list.do'">목록보기</button>
			<button type="button" class="add primary" onclick="location.href='/toy/board/add.do'">글쓰기</button>
		</div>
		
	</main>

	<script>
		
	</script>
</body>
</html>






