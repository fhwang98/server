<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- inc > header.jsp -->
<header id="header">
	<h1>
		<c:if test="${empty id}">
		<span>Toy</span>
		</c:if>
		
		<c:if test="${not empty id}">
		<span>
			<span class="material-symbols-outlined">toys</span>..
			Toy
		</span>
		</c:if>
		
		<span>Project</span>
	</h1>
	<nav>
		
		<c:if test="${not empty id}">
		<span style="font-size: 11px; color: #555; margin-right: 10px;">${ name }(${ id })</span>
		</c:if>
	
		<a href="/toy/index.do">Home</a>
		
		<c:if test="${empty id}">
		<a href="/toy/user/register.do">Register</a>
		<a href="/toy/user/login.do">Login</a>
		</c:if>
		
		<c:if test="${not empty id}">
		<a href="/toy/user/info.do">Info</a>
		<a href="/toy/user/unregister.do">Unregister</a>
		<a href="/toy/user/logout.do">Logout</a>
		</c:if>
		
		<a href="/toy/board/list.do">Board</a>
	</nav>
</header>
