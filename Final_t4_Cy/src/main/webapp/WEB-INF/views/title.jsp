<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css"> 
#titleBtn{
	border: none; background: none; color: white; width: 78px; height: 25px
} </style>
<script type="text/javascript">
function myHomeGo(){
	location.href='myHome.go';
}
</script>
</head>
<body>
	<table id="siteMenu" style="padding-bottom: 5px;">
		<tr>
			${r }
			<!-- 로그인 된 상태일때 -->
			<c:if test="${not empty sessionScope.loginMember.c_id}">
				<form action="search.go">
				<input style="border: 2px solid red;" align="left" type="text"
				placeholder="ID 입력" name="keyword">
				<button style="border:hidden; background-color: red; color: white;">검색</button></form>
				<input id="titleBtn" type=button value="랜덤방문" onclick="RandomGo()">
				<c:if test="${sessionScope.loginMember.c_id != sessionScope.pageInfo.p_id }">
				<input id="titleBtn" type=button value="내홈으로" onclick="myHomeGo()">
				</c:if>
				<input id="titleBtn" type=button value="마이페이지" onclick="memberInfoGo()" >
				<input id="titleBtn" type=button value="로그아웃" onclick="logout()">
			</c:if>
			
			<!-- 로그아웃 된 상태일때 -->
			<c:if test="${sessionScope.loginMember.c_id == null}">
				<form action="search.go">
				<input style="border: 2px solid red;" align="left" type="text"
					placeholder="ID 입력" name="keyword">
				<button style="border:hidden; background-color: red; color: white;">검색</button></form>
				<input id="titleBtn" type=button value="랜덤방문" onclick="RandomGo()">
				<input id="titleBtn" type=button value="로그인" onclick="loginGo()">
			</c:if>

	</table>
</body>
</html>