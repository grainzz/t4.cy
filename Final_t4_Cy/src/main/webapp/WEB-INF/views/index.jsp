<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
$(document).ready(function() {
	$('').click(function () {
		
	});
	
});
</script>

<link rel="stylesheet" href="resources/css/index${theme }.css">
<link rel="stylesheet" href="resources/css/board.css">
<link rel="stylesheet" href="resources/css/event.css">
<link rel="stylesheet" href="resources/css/portfolio.css">
<link rel="stylesheet" href="resources/css/resume.css">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/go.js"></script>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript" src="resources/js/joinCheck.js"></script>
<script type="text/javascript" src="resources/js/validCheck.js"></script>
<style type="text/css">
@font-face {
      src : url("resources/font/DungGeunMo.woff");
      font-family: "dunggeunmo"
}
</style>

</head>

<body onresize="parent.resizeTo(750,520)"
	onload="parent.resizeTo(750,520)"
	style="padding-left: 20px; padding-top: 10px;">
<div id="div">
	<table id="siteMenuArea" align="center">
		<tr><td align="center" style="position: fixed; left:280px;"> <jsp:include page="${titlePage}"></jsp:include></td></tr>
		<table id="table" style="border: 2px solid grey; border-radius: 3%;   
		margin-top: 30px; background-color: #8ab6dd; width: 680px; height: 380px; padding: 15px; border-radius: 4px 4px 4px 4px;">
<td id="homePage"><jsp:include page="${homePage}"></jsp:include></td> </table>
		
		
			<!-- 메뉴 / 로그인을 하지 않았을 때는 로그인 창으로? 또는 로그인 경고창. -->
		<table
			style="position: fixed; text-align: center; left: 734px; top: 90px;">
			<tr>
				<td onclick="homeGo()"
					style="background-color: #3497b8; border-radius: 5%; color: white; width: 50px; height: 5px; border: 1px solid white; padding: 5px;">
					홈</td>
			</tr>
			<tr>
				<td onclick="boardGo()"
					style="background-color: #3497b8; border-radius: 5%; color: white; width: 50px; height: 5px; border: 1px solid white; padding: 5px;">
					게시판</td>
			</tr>
			<tr>
				<td onclick="messageGo()"
					style="background-color: #3497b8; border-radius: 5%; color: white; width: 50px; height: 5px; border: 1px solid white; padding: 5px;">
					광장</td>
			</tr>
			<c:if test="${not empty sessionScope.loginMember }">
			<c:if test="${sessionScope.loginMember.c_id == sessionScope.pageInfo.p_id }">
			<tr>
				<td onclick="settingGo()"
					style="background-color: #3497b8; border-radius: 5%; color: white; width: 50px; height: 5px; border: 1px solid white; padding: 5px;">
					설정</td>
			</tr>
			</c:if>
			</c:if>
		</table>
		<div id="BannerArea"
			style="position: fixed; width: 150px; height: 200px; left: 810px; top: 46px; background-color: white; border: 2px solid orange">
			<jsp:include page="${bannerPage}"></jsp:include>
		</div>
	</table>
</div>
</body>
</html>
