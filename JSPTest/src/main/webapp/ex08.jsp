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
	<!-- ex08.jsp -->
	<h1>컨트롤 입력 + 전송</h1>
	
	<form method="POST" action="ex08_ok.jsp">
	<table class="vertical">
		<tr>
			<th>텍스트 박스</th>
			<td><input type="text" name="txt1"></td>
		</tr>
		<tr>
			<th>암호 박스</th>
			<td><input type="password" name="txt2"></td>
		</tr>
		<tr>
			<th>다중 텍스트</th>
			<td><textarea name="txt3"></textarea></td>
		</tr>
		<tr>
			<th>체크 박스</th>
			<td><input type="checkbox" name="cb1" value="yes"></td>
		</tr>
		<tr>
			<th>체크 박스</th>
			<td>
				<h3>취미를 선택하세요.</h3>
				<label><input type="checkbox" name="cb2" value="독서">독서</label>
				<label><input type="checkbox" name="cb3" value="운동">운동</label>
				<label><input type="checkbox" name="cb4" value="코딩">코딩</label>
			</td>
		</tr>
		<tr>
			<th>체크 박스</th>
			<td>
				<h3>취미를 선택하세요.</h3>
				<label><input type="checkbox" name="cb5" value="독서">독서</label>
				<label><input type="checkbox" name="cb5" value="운동">운동</label>
				<label><input type="checkbox" name="cb5" value="코딩">코딩</label>
			</td>
		</tr>
		<tr>
			<th>라디오 버튼</th>
			<td>
				<h3>성별을 선택하시오.</h3>
				<label><input type="radio" name="rb" value="male" checked>남자</label>
				<label><input type="radio" name="rb" value="female">여자</label>
			</td>
		</tr>
		<tr>
			<th>셀렉트 박스</th>
			<td>
				<select name="sel1">
					<option value="1">사과</option>
					<option value="2">바나나</option>
					<option value="3">포도</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>셀렉트 박스</th>
			<td>
				<select name="sel2" multiple>
					<option value="1">사과</option>
					<option value="2">바나나</option>
					<option value="3">포도</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>히든 태그</th>
			<td><input type="hidden" name="txt4" value="hong"></td>
		</tr>
		<tr>
			<th>날짜</th>
			<td><input type="date" name="regdate"></td>
		</tr>
		<tr>
			<th>범위</th>
			<td><input type="range" name="min" min="10" max="1000" step="10"></td>
		</tr>
		<tr>
			<th>색상</th>
			<td><input type="color" name="color" style="height: 50px;"></td>
		</tr>
	</table>
	<div>
		<input type="submit" value="보내기">
		<input type="button" value="클릭" id="btn1">
		<input type="button" value="클릭" id="btn2">
	</div>
	<input type="hidden" name="count">
	</form>
	
	<h1>링크</h1>
	
	<div>
		<a href="ex08_ok.jsp?id=hong&pw=1234">링크입니다.</a>
	</div>
	

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="http://pinnpublic.dothome.co.kr/cdn/example-min.js"></script>
	<script>
	
		let count = 0; // 서버로 전송하고 싶다.
		
		$('#btn1').click(function() {
			count++;
			$('input[name=count]').val(count);
		});
		
		$('#btn2').click(function() {
			location.href = 'ex08_ok.jsp?id=test&pw=1111';
		});
		
	</script>	
</body>
</html>