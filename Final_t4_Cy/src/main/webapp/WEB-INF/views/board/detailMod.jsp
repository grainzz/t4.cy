<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="board.modify.do">
<table>
<tr>
	<td>제목</td>
	<td><input name="b_title" style="width: 300px; height: 30px;" value="${bb.b_title }"></td>
</tr>
<tr>
	<td>내용</td>
	<td><input name="b_content" style="width: 300px; height: 200px;" value="${bb.b_content }"></td>
</tr>
</table>
<input name="b_no" value="${bb.b_no }" type="hidden">
<button id="bannerBtn2">등록</button>
</form>

</body>
</html>