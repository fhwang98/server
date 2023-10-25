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
	<!-- ex03.jsp -->
	
	<div>
		<input type="text" id="txt1" value="${ count }">
		<input type="button" value="버튼1" id="btn1">
	</div>
	
	<div>
		<input type="text" id="txt2">
		<input type="button" value="버튼2" id="btn2">
	</div>
	

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="http://pinnpublic.dothome.co.kr/cdn/example-min.js"></script>
	<script>
	
		//Ajax > jQuery
		$('#btn1').click(function() {
			
			const hong = {
					name: '홍길동',
					age: 20,
					hello: function(){
						
					}
			};
			
			
			$.ajax({ //객체를 인자로
				
				//Ajax
				//- 비동기 자바스크립트 통신
				async: true, // true(비동기) > 디폴트, false(동기)
				// 동기통신으로 하는 경우 없음
				
			
				//ajax.open('GET', '~~.do') > 페이지 요청 정보
				type: 'GET',
				url: '/ajax/ex03data.do',
				
				//메모 작성자 이름을 넘김
				//ex03data.do?name=홍길동
				data: 'name=홍길동',
				
				//onreadystatechange + readyState(4) + status(200)
				// success라는 이벤트가 발생하면서 함수를 호출 
				success: function(result) {
					//result == ajax.responseText
					$('#txt1').val(result);
				},
				
				//에러 발생시 호출되는 이벤트
				error: function(a, b, c) {
					console.log(a, b, c);
				}
				
			});
		});
	</script>	
</body>
</html>