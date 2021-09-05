<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function shopBgmGo(){
	location.href="shop.bgm.go";
}

function shopThemeGo(){
	location.href="shop.theme.go";
}

function historyGo(){
	location.href="shop.history.go";
}

</script>
</head>
<body>

<%-- 로그인 안돼있을경우 로그인해달라는 내용 --%>
<c:if test="${sessionScope.loginMember.c_id == null}">
쇼핑하려면 로그인해주세요
<hr>
<button style="border: 1px solid grey; background-color: orange; color: white; height: 25px;" onclick='loginGo();'>로그인하러</button>
</c:if>

<%-- 로그인 돼있을경우 쇼핑 --%>
<c:if test="${not empty sessionScope.loginMember.c_id }">
<img src="resources/img/dotoripack.png" width='120px'><p>
<h2>도토리 상점</h2>
<button style="border: 1px solid grey; background-color: orange; color: white; height: 25px;" onclick="shopBgmGo();">배경음악 구입</button>
<button style="border: 1px solid grey; background-color: orange; color: white; height: 25px;" onclick="shopThemeGo();">테마 구입</button>
<hr>
<button style="border: 1px solid grey; background-color: orange; color: white; height: 25px;" onclick="historyGo();">구입내역 보기</button>
<button style="border: 1px solid grey; background-color: orange; color: white; height: 25px;" onclick="homeGo();">돌아가기</button>

</c:if>
</body>
</html>