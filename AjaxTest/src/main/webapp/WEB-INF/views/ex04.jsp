<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://pinnpublic.dothome.co.kr/cdn/example-min.css">
<style>
	div > input {
		margin-bottom: 15px;
	}
</style>
</head>
<body>
	<!-- ex04.jsp -->
	
	<h1>Ajax 응답 데이터 형식</h1>
	
	<div>
		<h2>Text</h2>
		<input type="button" id="btn1" value="클릭">
		<div id="result1"></div>
	</div>
	
	<div>
		<h2>XML</h2>
		<input type="button" id="btn2" value="클릭">
		<div id="result2"></div>
	</div>
	
	<div>
		<h2>JSON</h2>
		<input type="button" id="btn3" value="클릭">
		<div id="result3"></div>
	</div>

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="http://pinnpublic.dothome.co.kr/cdn/example-min.js"></script>
	<script>
	
		$('#btn1').click(function() {
			
			$.ajax({
				
				type: 'GET',
				url: '/ajax/ex04data.do',
				
				// type이 1이면 text로 돌려받음
				//단일값
				data: 'type=1', //무난
				//다중값
				//data: 'type=2', //비권장
				
				// 돌려받을 데이터 형식
				dataType: 'text',
				success: function(result) {
					
					//$('#result1').text(result);
					
					const list = result.split('\r\n');
					
					list.forEach(memo => {
						
						//alert(memo);
						
						const item = memo.split(',');
						
						$('#result1').append('<div>' + item[0] + '</div>');
						$('#result1').append('<div>' + item[1] + '</div>');
						$('#result1').append('<div>' + item[2] + '</div>');
						$('#result1').append('<br>');
						
					});
					
				},
				error: function(a, b, c) {
					console.log(a, b, c);
				}
				
				
			});
			
		});
		
		$('#btn2').click(function() {
			
			//단일값
			//다중값
			$.ajax({
				
				type: 'GET',
				url: '/ajax/ex04data.do',
				data: 'type=3',
				dataType: 'xml',
				
				success: function(result) {
					
					//alert($(result).find('name').text());
					
					$('#result2').append('<div>번호: ' + $(result).find('seq').text() + '</div>');
					$('#result2').append('<div>이름: ' + $(result).find('name').text() + '</div>');
					$('#result2').append('<div>암호: ' + $(result).find('pw').text() + '</div>');
					$('#result2').append('<div>메모: ' + $(result).find('memo > memo').text() + '</div>');
					$('#result2').append('<div>날짜: ' + $(result).find('regdate').text() + '</div>');
					
				},
				error: function(a, b, c) {
					console.log(a, b, c);
				}
				
				
			});
		});
		
		$('#btn3').click(function() {
			
			
		});
		
	</script>	
</body>
</html>