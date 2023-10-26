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
	<!-- ex06.jsp -->
	<h1>아이디 중복검사</h1>
	
	<table class="vertical">
		<tr>
			<th>이름</th>
			<td><input type="text"></td>
		</tr>
		<tr>
			<th>아이디</th>
			<td>
				<input type="text" id="id" class="short">
				<input type="button" id="btn" value="중복검사">
				<span id="result"></</span>
			</td>
		</tr>
	</table>
	<div>
		<input type="button" value="가입하기" id="regBtn" disabled onclick="alert('가입')">
	</div>

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="http://pinnpublic.dothome.co.kr/cdn/example-min.js"></script>
	<script>
	
		$('#btn').click(function() {
			$.ajax({
				type: 'POST',
				url: '/ajax/ex06data.do',
				data: {
					id: $('#id').val() //id=hong
				},
				dataType: 'json',
				success: function(result) {
					
					//alert(result.result);
					
					if(result.result == 0) {
						$('#result').text('사용 가능한 아이디입니다.');
						$('#regBtn').prop('disabled', false);
					} else {
						$('#result').text('이미 사용중인 아이디입니다.');
						$('#regBtn').prop('disabled', true);
					}
					
				},
				error: function(a, b, c) {
					console.log(a, b, c);
				}
			});	
		});
		
		//아이디를 수정하면 > 가입 불가능
		$('#id').change(function() {
			$('#regBtn').prop('disabled', true);			
		});
		
	</script>	
</body>
</html>