<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>
	
</style>
</head>
<body>
	<!-- addok.jsp -->
	
	<%@ include file="/WEB-INF/views/inc/header.jsp" %>

	<script>
		<%-- <% if (request.getAttribute("result") == 1) { %>
			location.href='/memo/list.do';
		<% } else { %>
			alert('실패');
			location.href = '/memo/add.do';
		<% } %> --%>
		<c:if test="${result == 1}">
			location.href='/memo/list.do';
		</c:if>
		<c:if test="${result == 0}">
			alert('실패');
			//location.href='/memo/add.do'; > 페이지 새로 요청
			history.back(); // 페이지 새로 요청(x) > 이전 상태로 되돌리기
			// histrory.back() > 보안이 중요할 경우 사용하면 x
		</c:if>
	</script>	
</body>
</html>