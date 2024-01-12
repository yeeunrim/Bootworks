<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOARD | WRITE</title>
<link rel="stylesheet" href="../static/css/style.css">
</head>
<body>
	<div class="wrap">
		<h2>글 쓰기</h2>
		<form action="/board/write" method="post">
			<table class="tbl_write">
				<tbody>
					<tr>
						<td>
							<input type="text" name="title" placeholder="제목" required>
						</td>
					</tr>
					<tr>
						<td>
							<input type="text" name="writer" placeholder="작성자" required>
						</td>
					</tr>
					<tr>
						<td>
							<textarea rows="5" cols="60" name="content" placeholder="내용" required></textarea>
						</td>
					</tr>
					<tr>
						<td>
							<input type="submit" value="등록">
							<input type="reset" value="지우기">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>