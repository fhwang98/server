<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>

	#view tr:nth-child(4) {height: 100px;}
	
	#add-comment td:nth-child(1) {width: auto; text-align:center;}
	#add-comment td:nth-child(2) {width: 110px; text-align:center;}
	
	#list-comment td:nth-child(1) {width: auto;}
	#list-comment td:nth-child(2) {width: 170px;  text-align:center;}
	
	#list-comment td:nth-child(1) > div {
		display: flex;
		justify-content: space-between;
	}
	
	#list-comment td:nth-child(1) > div > div:nth-child(2) {
		font-size: 12px;
		color: #777;
	}
	
</style>
</head>
<body>
	<!-- view.jsp -->
	<%@ include file="/WEB-INF/views/inc/header.jsp" %>
	<main id="main">
		<h1 class="sub">게시판 <small>상세보기</small></h1>
		<table class="vertical" id="view">
			<tr>
				<th>번호</th>
				<td>${ dto.seq }</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${ dto.name }(${ dto.id })</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${ dto.subject }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${ dto.content }</td>
			</tr>
			<tr>
				<th>날짜</th>
				<td>${ dto.regdate }</td>
			</tr>
			<tr>
				<th>읽음</th>
				<td>${ dto.readcount }</td>
			</tr>
		</table>
		
		<!-- 댓글 쓰기 -->
		<c:if test="${ not empty id }">
		<table id="add-comment">
			<tr>
				<td><input type="text" name="comment" id="comment" class="full"></td>
				<td><button type="button" class="comment" id="btnComment">댓글쓰기</button></td>
			</tr>
		</table>
		</c:if>
		
		<!-- 댓글 목록 -->
		<table id="list-comment">
		<tbody>
		
		</tbody>
		</table>
		
		<div>
			<button type="button" class="back" onclick="location.href='/toy/board/list.do';">뒤로가기</button>
			<c:if test="${ not empty id && (id == dto.id || lv == 2) }">
			<button type="button" class="edit" onclick="location.href='/toy/board/edit.do?seq=${dto.seq}';">수정하기</button>
			<button type="button" class="del" onclick="location.href='/toy/board/del.do?seq=${dto.seq}';">삭제하기</button>
			</c:if>
		</div>
	</main>

	<script>
	
		$('#btnComment').click(function() {
			$.ajax({
				type: 'POST',
				url: '/toy/board/comment.do',
				data: {
					content: $('#comment').val(),
					bseq: ${dto.seq}
				},
				dataType: 'json',
				success: function(result) {
					//alert(result.result);
					
					// 댓글이 제대로 써졌으면
					if(result.result) { 
						load(); // 목록 새로고침
					}
					
					$('#comment').val(''); //초기화					
				},
				error: function(a, b, c) {
					console.log(a, b, c)
				}
			});
		});
		
		$('#comment').keydown(function() {
			if (event.keyCode == 13) { // 엔터(\r)
				$('#btnComment').click();
			}
		});
		
		
		
		load();
		//댓글 목록 가져오기(ajax) > 화면에 출력
		function load() {
			
			$.ajax({
				type:'GET',
				url: '/toy/board/comment.do',
				data: 'bseq=${dto.seq}',
				dataType: 'json',
				success: function(result) {
					//result == 댓글 목록
					
					//기존 목록 삭제
					$('#list-comment tbody').html('');
					
					$(result).each((index, item) => {
						//console.log(item);
						
						let temp = `
							<tr>
							<td>
								<div>
									<div>\${item.content}</div>
									<div>\${item.regdate}</div>
								</div>
							</td>
							<td>
								<div>\${item.name}(\${item.id})</div>`;
						
						if (item.id == '${id}') {
							temp +=	`<c:if test="${ not empty id }">
									<div>
										<button type="button" class="edit" onclick="editComment(\${item.seq});">수정</button>
										<button type="button" class="del" onclick="delComment(\${item.seq});">삭제</button>
									</div>
									</c:if>`;
						}
								
						temp +=	`</td>
							</tr>
							`;
						
						$('#list-comment tbody').append(temp);
						
					});
					
				},
				error: function(a, b, c) {
					console.log(a, b, c);
				}
			});
		}
		
		function delComment(seq) {
			//alert(seq);
			if (confirm('delete?')) {
				$.ajax({
					type: 'POST',
					url: '/toy/board/delcomment.do',
					data: 'seq=' + seq,
					dataType: 'json',
					success: function(result) {
						if (result.result) {
							load(); // 목록 새로고침
						}
					},
					erroe: function(a, b, c) {
						console.log(a, b, c)
					}
				});
			}
			
		}
		
		function editComment(seq) {
			
			let val = $(event.target).parent().parent().prev().children().eq(0).children().eq(0).text();

			
			$('.edit-comment').remove();
			
			let temp = `
				<tr class="edit-comment">
				<td><input type="text" name="ecomment" id="ecomment" class="long" value="\${val}"></td>
				<td>
					<button type="button" class="edit" onclick="editCommentOk(\${seq});">완료</button>
					<button type="button" class="cancle" onclick="$('.edit-comment').remove();">취소</button>
				</td>
				</tr>
				`;
				
			$(event.target).parent().parent().parent().after(temp);
		};
		
		function editCommentOk(seq) {
			//alert($('#ecomment').val());
			//alert(seq);
			
			$.ajax({
				type: 'POST',
				url: '/toy/board/editcomment.do',
				data: {
					content: $('#ecomment').val(),
					seq: seq
				},
				datatype: 'json',
				success: function(result) {
					if (result.result) {
						load(); // 목록 새로고침
					}
				},
				error: function(a, b, c) {
					console.log(a, b, c);
				}
			});
			
		}
		
		/* $('#ecomment').keydown(function() {
			if (event.keyCode == 13) {
			event.target의 부모의 동생의 첫번째 자식
				$(event.target).click();
			}
		}); */
		
	</script>
</body>
</html>


