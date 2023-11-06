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
	<h1>Map <small>지도 좌표 이동하기 + 레벨 바꾸기</small></h1>
	
	<div id="map" style="width:768px;height:400px;"></div>
	<hr>
	
	
	<div>
		<input type="button" value="종각역으로 이동하기" id="btn1">
		<input type="button" value="역삼역으로 이동하기" id="btn2">
		<input type="button" value="잠실역으로 이동하기" id="btn3">
	</div>
	<div>
		<input type="button" value="확대" id="btn4">
		<input type="button" value="축소" id="btn5">
	</div>
	<div>
		<input type="button" value="이동 제어" id="btn6">
		<input type="button" value="확대/축소 제어" id="btn7">
	</div>
	

	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=179b707191522e4fe7b9e78b1155a332"></script>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="http://pinnpublic.dothome.co.kr/cdn/example-min.js"></script>
	
	<script>
	
		const container = document.getElementById('map');
		
		
		const options = {
			center: new kakao.maps.LatLng(37.499316, 127.033192),
			level: 3
		};
	
		const map = new kakao.maps.Map(container, options);
		
		// 쌍용 > 37.499316, 127.033192
		// 종각 > 37.570180, 126.983029
		// 역삼 > 37.500612, 127.036277
		// 잠실 > 37.513251, 127.099935
		
		$('#btn1').click(function() {
			const p1 = new  kakao.maps.LatLng(37.570180, 126.983029);
			map.setCenter(p1);
		});
		
		$('#btn2').click(function() {
			const p1 = new  kakao.maps.LatLng(37.500612, 127.036277);
			//map.setCenter(p1); // 순간이동
			map.panTo(p1); // 패닝
		});
		
		$('#btn3').click(function() {
			const p1 = new  kakao.maps.LatLng(37.513251, 127.099935);
			map.setCenter(p1);
		});
		
		$('#btn4').click(function() {
			map.setLevel(map.getLevel() - 1);
		});
		
		$('#btn5').click(function() {
			map.setLevel(map.getLevel() + 1);
		});
		
		
		
		map.setDraggable(false);
		$('#btn6').click(function() {
			// 토글 버튼(드래그 On/Off)
			if (map.getDraggable()) {
				map.setDraggable(false);
				$(this).css('background-color', '#EFEFEF');
			} else {
				map.setDraggable(true);
				$(this).css('background-color', 'gold');
			}
		});
		
		map.setZoomable(false);
		$('#btn7').click(function() {
			// 토글 버튼(확대/축소 On/Off)
			if (map.getZoomable()) {
				map.setZoomable(false);
				$(this).css('background-color', '#EFEFEF');
			} else {
				map.setZoomable(true);
				$(this).css('background-color', 'gold');
			}
		});
		
	</script>	
</body>
</html>