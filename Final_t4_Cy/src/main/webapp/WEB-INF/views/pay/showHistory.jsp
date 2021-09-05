<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function setMusicByHistory(input){
	var bgm = input;
	location.href="history.setMusic?bgm="+bgm;
}
</script>
</head>
<body>
<h2>구입내역</h2>

<div style="width:100%; height:400px; overflow:auto">
<table>

	<c:if test="${not empty B_history }">
	<tr><td colspan="3" align="center"><h3>브금</h3></td></tr>
	<tr><td align="left">제목</td><td align="center" width="130">구입 날짜</td><td width="50"></td></tr>
	<tr><td colspan="3"><hr></td></tr>
	<c:forEach var="b" items="${B_history }" >
	<tr>
	<form action="history.setMusic">
		<td align="left">${b.bh_music }</td>
		<td align="right"><fmt:formatDate value="${b.bh_date }" pattern="yyyy-MM-dd hh:mm"/></td>
		<input name="bgm" value="${b.bh_music }" type="hidden"> 
		<td><button>적용</button></td>
	</form>
	</tr>
	<tr><td colspan="3"><hr></td></tr>
	</c:forEach>
	</c:if>
	
	
	<c:if test="${not empty T_history }">
	<tr><td colspan="3" align="center"><h3>테마</h3></td></tr>
	<tr><td align="left">이름</td><td align="center">구입 날짜</td><td width="50"></td></tr>
	<tr><td colspan="3"><hr></td></tr>
	<c:forEach var="b" items="${T_history }" >
	<tr>
	<form action="history.setTheme">
		<td align="left">${b.th_theme }</td>
		<td align="right"><fmt:formatDate value="${b.th_date }" pattern="yyyy-MM-dd hh:mm"/></td>
		<input name="theme" value="${b.th_theme }" type="hidden"> 
		<td><button>적용</button></td>
		</form>
	</tr>
	<tr><td colspan="3"><hr></td></tr>
	</c:forEach>
	</c:if>
</table>	
</div>

</body>
</html>