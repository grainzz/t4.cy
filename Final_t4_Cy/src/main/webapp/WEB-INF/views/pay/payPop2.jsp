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
<script type="text/javascript">
var url = '<%=request.getAttribute("successUrl")%>';
window.open(url, '결제진행', 'width=700px, height=800px, scrollbars=yes');
</script>
<body>
<c:if test="${not empty dotoricheck }">
도토리<img src="resources/img/dotori.jpg" width="15px"> ${dotoricheck }개
</c:if>
<h3>${result }</h3>
<button style="border: 1px solid grey; background-color: orange; color: white; height: 25px;" onclick="homeGo();">홈으로 돌아가기</button>

</body>
</html>