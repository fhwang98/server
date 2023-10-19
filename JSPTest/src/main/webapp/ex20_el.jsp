<%@page import="com.test.jsp.Score"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<!-- ex20_el.jsp -->
	<h1>EL</h1>
	
	<%
		int a = 10;
		pageContext.setAttribute("b", 20);
		request.setAttribute("c", 30);
	%>
	
	<h2>표현식</h2>
	<div>a: <%= a %></div>
	<div>b: <%= pageContext.getAttribute("b") %></div>
	<div>c: <%= request.getAttribute("c") %></div>
	
	<!--
		*** EL은 일반 자원(지역변수, 멤버변수)은 출력할 수 없다.
		*** 내장 객체(pageContext, request, session, application) 안에 있는 데이터만 전용으로 출력하는 표현식 > EL
	-->
	<h2>EL</h2>
	<div>a: ${a}</div>
	<div>b: ${pageContext.getAttribute("b")}</div> <!-- 안씀 -->
	<div>c: ${request.getAttribute("c")}</div> <!-- 안씀 -->
	
	<div>a: ${a}</div> <!-- 내장 객체 안의 key값이라고 생각 -> null -> 지역변수에는 사용불가 -->
	<div>b: ${b}</div>
	<div>c: ${c}</div>
	
	<hr>
	<h3>연산 기능</h3>
	<div>b + 10 = ?</div>
	<!-- 표현식 -->
	<div>b + 10 = <%= (int)pageContext.getAttribute("b") + 10 %></div>
	<!-- EL -->
	<div>b + 10 = ${b} + 10</div>
	
	<div>b + 10 = ${b + 10}</div>
	<div>b - 10 = ${b - 10}</div>
	<div>b * 10 = ${b * 10}</div>
	<div>b / 10 = ${b / 10}</div>
	<div>b % 10 = ${b % 10}</div>
	<div>b mod 10 = ${b mod 10}</div>
	
	<hr>
	
	<div>b &gt; 10 = ${b > 10}</div>
	<div>b &lt; 10 = ${b < 10}</div>
	
	<div>b &gt; 10 = ${b gt 10}</div>
	<div>b &lt; 10 = ${b lt 10}</div>
	
	<div>b &gt;= 10 = ${b >= 10}</div>
	<div>b &gt;= 10 = ${b ge 10}</div>
	
	<div>b == 20 = ${b == 20}</div>
	<div>b != 20 = ${b != 20}</div>
	
	<div>b == 20 = ${b eq 20}</div>
	<div>b != 20 = ${b ne 20}</div>
	
	<hr>
	
	<!--
		쇼트 서킷(Short-circuit)
		- true && true
		- false && true
		- true || false
	-->
	
	<div>${true && true}</div>
	<div>${true || true}</div>
	<div>${!true}</div>
	
	<div>${true and true}</div>
	<div>${true or true}</div>
	<div>${not true}</div>
	
	<hr>
	
	<div>${b > 0 ? "양수" : "음수"}</div>
	
	<hr>
	
	<div>${"문자열".equals("문자열")}</div>
	<div>${"문자열" == "문자열"}</div>
	
	<div>${"문자열" == '문자열'}</div>
	
	<hr>
	
	<%
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("kor", 100);
		map.put("eng", 90);
		map.put("math", 80);
		
		pageContext.setAttribute("map", map);
	
	%>
	<h3>객체 출력(HashMap)</h3>
	<div>국어: <%= map.get("kor") %></div>
	<div>영어: <%= map.get("eng") %></div>
	<div>수학: <%= map.get("math") %></div>
	
	<div>국어: ${map.get("kor")}</div>
	<div>국어: ${map["kor"]}</div>
	<div>국어: ${map.kor}</div>
	<div>영어: ${map.eng}</div>
	<div>수학: ${map.math}</div>
	
	
	
	
	<%
		Score score = new Score();
	
		score.setKor(99);
		score.setEng(88);
		score.setMath(77);
		
		pageContext.setAttribute("score", score);
		
	%>
	<h3>객체 출력(일반 객체)</h3>
	<div>국어: <%= score.getKor() %></div>
	<div>국어: ${score.getKor()}</div>
	
	
	<!--
		kor > get + kor > getKor > getKor()
	-->
	<div>국어: ${score.kor}</div>
	<div>국어: ${score["kor"]}</div>
	<div>영어: ${score.eng}</div>
	<div>수학: ${score.math}</div>
	
	<div>총점: ${score.kor} + ${score.eng} + ${score.math}</div>
	<div>총점: ${score.kor + score.eng + score.math}</div>
	
	<hr>
	
	<%

		// *** 무언가가 충돌
		//- 부모와 자식 충돌 > 자식
		//- 넓은 범위와 좁은 범위 > 좁은 범위
		//- 두리뭉실과 구체적 충돌 > 구체적
		
		//EL > 순차적 탐색
		//- pageContext > request > session > application
		pageContext.setAttribute("color", "tomato");
		request.setAttribute("color", "gold");
		session.setAttribute("color", "cornflowerblue");
		application.setAttribute("color", "yellowgreen");
		
	%>
	
	<div style="background-color: ${requestScope.color};">${requestScope.color}</div>
	
	
	
	
	
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="http://pinnpublic.dothome.co.kr/cdn/example-min.js"></script>
	<script>
		
	</script>	
</body>
</html>