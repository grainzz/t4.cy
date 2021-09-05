<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도토리 충전 고고!</title>
<style type="text/css">
hr{
	border-top: 1px solid #bbb;
}
</style>
<body>

<%-- 로그인 안돼있을경우 로그인해달라는 내용 --%>
<c:if test="${sessionScope.loginMember.c_id == null}">
도토리<img src="resources/img/dotori.jpg" width='15px'>를 충전하려면 로그인해주세요
<hr>
<button style="border: 1px solid grey; background-color: orange; color: white; height: 25px;" onclick='loginGo();'>로그인하러</button>
</c:if>

<%-- 로그인 돼있을경우 충전 진행 --%>
<c:if test="${not empty sessionScope.loginMember.c_id }">
<form action="pay.call" method="post">
<img src="resources/img/dotoripack.png" width='80px'>
<h2>도토리 충전</h2>
<input type="radio" name="dotoriNum" value="3" checked> 도토리 3개 지갑<br>
<input type="radio" name="dotoriNum" value="10"> 도토리 10개 지갑<br>
<input type="radio" name="dotoriNum" value="30"> 도토리 30개 지갑<br>
<input type="radio" name="dotoriNum" value="50"> 도토리 50개 지갑<br>
<input type="radio" name="dotoriNum" value="100"> 도토리 100개 지갑<br>
<%-- input name="c_id" value="${sessionScope.loginMember.c_id }" type="hidden"--%>
<hr>
도토리를 충전하시겠습니까?
<hr>
카카오페이로 충전하기 <button><img src="resources/img/pay_icon.png" width='50px'></button>
</form>
<button style="border: 1px solid grey; background-color: orange; color: white; height: 25px;" onclick='homeGo();'>취소</button>
</c:if>





</body>
</html>