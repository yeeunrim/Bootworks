<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOARD | DETAIL</title>
<link rel="stylesheet" href="../static/css/style.css">
</head>
<body>
	<div class="wrap">
		<h2>글 상세보기</h2>
		<table class="tbl_write">
			<tbody>
				<tr>
					<td>
						<input type="text" name="title" value="제목 : ${board.title}" readonly>
					</td>
				</tr>
				<tr>
					<td>
						<input type="text" name="writer" value="작성자 : ${board.writer}" readonly>
					</td>
				</tr>
				<tr>
					<td>
						<textarea rows="5" cols="60" name="content" readonly>${board.content}</textarea>
					</td>
				</tr>
				<tr>
					<td>
						<button type="button" onclick="updateFn(${board.id})">수정</button>
						<button type="button" onclick="deleteFn(${board.id})">삭제</button>
						<button type="button" onclick="list()">목록</button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<script>
		// 수정
		let updateFn = function(id){
			location.href = "/board/update?id=" + id;
		}
		
		// 삭제
		let deleteFn = function(id){
			const result = confirm('정말로 삭제하시겠습니까?');
			if(result === false){
				location.href = "/board/";
			} else{
				location.href = "/board/delete?id=" + id;				
			}
		}
		
		// 목록
		let list = function(){
			location.href = "/board/";
		}
	</script>
</body>
</html>