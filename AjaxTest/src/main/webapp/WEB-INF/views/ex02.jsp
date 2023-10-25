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
	<!-- ex02.jsp -->
	
	<div>
		<input type="text" id="txt1" value="${ count }">
		<input type="button" value="버튼1" id="btn1">
	</div>
	
	<div id="msg" class="message"></div>
	
	<div>
		<input type="text" id="txt2">
		<input type="button" value="버튼2" id="btn2">
	</div>
	

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="http://pinnpublic.dothome.co.kr/cdn/example-min.js"></script>
	<script>
		$("#btn1").click(function () {
			
			//페이지(데이터) 요청
			//1. 브라우저를 통해서 요청
			//	- 서버측 > HTML 페이지를 반환
			//2. ajax를 통해서 요청
			//	- 서버측 > 필요한 데이터만 반환
			
			
			
			//Ajax
			//1. 순수 자바스크립트
			//2. jQuery > 개량
			
			//Ajax > 서버에게 데이터 요청 + 서버에게 응답 > Ajax 객체(XMLHttpRequest)
			const ajax = new XMLHttpRequest(); // 서버와 데이터를 송수신
			
			// readyState
			// ajax 객체의 상태(= 현재 서버와의 통신 상태)
			//1. UNSENT (숫자 0) : XMLHttpRequest 객체가 생성됨.
			//2. OPENED (숫자 1) : open() 메소드가 성공적으로 실행됨.
			//3. HEADERS_RECEIVED (숫자 2) : 모든 요청에 대한 응답이 도착함.
			//4. LOADING (숫자 3) : 요청한 데이터를 처리 중임.
			//5. DONE (숫자 4) : 요청한 데이터의 처리가 완료되어 응답할 준비가 완료됨.

			ajax.onreadystatechange = function() {
				
				//readystate change
				
				//$('#msg').html(ajax.responseText);
				
				//******** ajax가 서버로부터 응답받은 데이터를 접근하려면 반드시 readyState가 4일때만 접근해야 한다.
				// 모든 작업들을 ajax.readyState가 4일 때만
				// 서버 응답 상태가 멀쩡할 때만 > ajax.status == 200 
				if (ajax.readyState == 4 && ajax.status == 200) {
					
					$('#msg').append('<div>readyState: ' + ajax.readyState + '</div>');
					
					
					//상태코드
					//- 서버가 요청에 응답할 때의 상태
					//- 200 OK > 모든 상태가 정상
					//- 나머지는 다 에러
					//- 404 Not Found > 브라우저 오류 (주소 틀림)
					//- 405 Method Not Allowed > doGet, doPost 오류
					//- 408 Request Timeout > 응답시간 만료 (무한루프 등..)
					//- 500 Internal Server Error > 서버 오류 (자바 코드 에러)
					$('#msg').append('<div>status: ' + ajax.status + '</div>');
					
					$('#msg').append('<div>responseText: ' + ajax.responseText + '</div>');
					
					$('#msg').append('<hr>');
					
					$('#txt1').val(ajax.responseText);
					
				} else {
					if (ajax.readyState == 4) {
						alert('서버와 통신이 불안정합니다.');
					}
				}
				
			}
			
			//<form method="GET" action="주소"> -> 서버와 데이터를 주고받는 도구 -> Ajax로 
			//ajax.open('GET', '서버쪽 프로그램 주소');
			//ajax.open('GET', '/ajax/ex02.txt'); // 서버연결(x) > 설정(o)
			ajax.open('GET', '/ajax/ex02data.do'); // 서블릿 호출
			
			ajax.send(); // 서버와 연결해라! > connect
			
			
		});
	</script>	
</body>
</html>