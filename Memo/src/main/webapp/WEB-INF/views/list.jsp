<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>
	#list {
		display: grid;
		grid-template-columns: repeat(3, 1fr);
		gap: 10px;
	}
	#list .item {
		border: 1px solid #CCC;
		cursor: pointer;
	}
	#list .item > div {
		padding: 5px;
	}
	#list .item > div:nth-child(2) {
		height: 50px;
	}
	#list .item > div:nth-child(odd) {
		background-color: #EEE;
	}
</style>
</head>
<body>
	<!-- list.jsp -->
	
	<%@ include file="/WEB-INF/views/inc/header.jsp" %>

	<div id="list">
		<c:forEach items="${list}" var="dto">
		<div class="item" onclick="location.href='/memo/view.do?seq=${ dto.seq }';">
			<div>${ dto.seq }. ${ dto.name }</div>
			<!-- dto.memo.substring(0, 10) -> 데이터 조작 -> view에서 x 서블릿에서 o -->
			<div>${ dto.memo }</div> 
			<div>${ dto.regdate }</div>
		</div>
		</c:forEach>
	</div>
	
	<div>
		<input type="button" value="쓰기" onclick="location.href='/memo/add.do';">
	</div>

	<hr>
	
	<div id="result"></div>
	<div>
		<input type="button" value="클릭" id ="btn1">
	</div>

	<script>
		/* $('#btn1').click(function() { */
			$('#result').text('홍길동');
		/* }); */
	</script>	
</body>
</html>