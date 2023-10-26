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
	<!-- ex05.jsp -->
	
	<h1>Ajax 데이터 보내는 방법</h1>
	
	<form action="" id="form1">
	<table class="vertical">
		<tr>
			<th>이름</th>
			<td><input type="text" name="name" id="name" value="홍길동"></td>
		</tr>
		<tr>
			<th>나이</th>
			<td><input type="text" name="age" id="age" value="20"></td>
		</tr>
		<tr>
			<th>성별</th>
			<td>
				<input type="radio" name="gender" id="gender1" value="m" checked>남자
				<input type="radio" name="gender" id="gender2" value="f">여자
			</td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input type="text" name="address" id="address" value="서울시 강남구 역삼동"></td>
		</tr>
		<tr>
			<th>전화</th>
			<td><input type="text" name="tel" id="tel" value="010-1234-5678"></td>
		</tr>
	</table>
	
	<div>
		<input type="button" value="확인" id="btn">
	</div>
	
	</form>

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="http://pinnpublic.dothome.co.kr/cdn/example-min.js"></script>
	<script>
		
		$('#btn').click(function() {
			
			//1. 단일 데이터 전송
			/* 
			$.ajax({
				type: 'POST',
				url: '/ajax/ex05data.do',
				data:  //'key=value' 
					  'name=' + $('#name').val(),
				//success: function(result) {
				//	데이터 수신
				//	데이터 송신만 할 때는 success 필요 없음
				//},
				error: function(a, b, c) {
					console.log(a, b, c);
				} 
			});
			 */
			
			/*  
			$.ajax({
				type: 'POST',
				url: '/ajax/ex05data.do',
				data: // 'key=value'
					  'name=' + $('#name').val() + '&age=' + $('#age').val(),
				error: function(a, b, c) {
					console.log(a, b, c);
				} 
			});
			 */
			
			 //남자 선택? 여자 선택?
			//$('input[name=gender]:checked').hide();
			 //alert($('input[name=gender]:checked').val());
			 
			/* 
			$.ajax({
				type: 'POST',
				url: '/ajax/ex05data.do',
				data: 'name=' + $('#name').val() + '&age=' + $('#age').val() + '&gender=' + $('input[name=gender]:checked').val() + '&address=' + $('#address').val() + '&tel=' + $('#tel').val(),
				error: function(a, b, c) {
					console.log(a, b, c);
				} 
			});
			 */
			
			// 데이터를 key=value 형태가 아닌 object 형식으로 전송할 수 있다
			/* 
			$.ajax({
				type: 'POST',
				url: '/ajax/ex05data.do',
				data: {
						name: $('#name').val(),
						age: $('#age').val(),
						gender: $('input[name=gender]:checked').val(),
						address: $('#address').val(),
						tel: $('#tel').val()
					} ,
				error: function(a, b, c) {
					console.log(a, b, c);
				} 
			});
			 */
			 
			//제한적 조건 하에 사용할 수 있는 방법
			//alert($('#form1').serialize()); // 쿼리스트링 만들어줌
			//1. <form> 태그 사용
			//2. <input name="key"> 태그의 name값을 key로 사용 > 태그마다 name을 반드시 명시
			/* 
			$.ajax({
				type: 'POST',
				url: '/ajax/ex05data.do',
				data: $('#form1').serialize(),
				error: function(a, b, c) {
					console.log(a, b, c);
				} 
			});
			 */
			
			
			
			
			
		});
	
	</script>	
</body>
</html>