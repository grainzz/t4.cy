<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table
		style="border: 1px dashed white; border-radius: 4%; width: 700px; height: 500px;"
		rowspan="2">
		<td id="ProfileArea" align="center"
			style="background-color: white; width: 200px; border-radius: 20px 20px 20px 20px;">
			<jsp:include page="${profilePage}"></jsp:include></td>
		<td id="ContentArea" align="center"
			style="background-color: white; border-radius: 20px 20px 20px 20px;">
			<jsp:include page="${contentPage}"></jsp:include>
		</td>
	</table>

</body>
</html>