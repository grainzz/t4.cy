<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function calldotori(){
	var con = confirm('도토리 2개가 소모됩니다. 구매하시겠습니까?');
	if(!con){
		location.href="menu.home.go"
		return false;
	}
};
</script>
</head>
<body>
<form action="shop.buyTheme" onsubmit="calldotori();">
보유 도토리: ${sessionScope.loginMember.c_dotori}개
<h2>테마 구매</h2>
<input name="c_id" value="${sessionScope.loginMember.c_id }" type="hidden">
<input name="c_dotori" value="${sessionScope.loginMember.c_dotori }" type="hidden">
<table>
<tr>
	<td><input type="radio" name="theme" value="purple" checked></td>
	<td><font style="color:#7774a1;">●</font></td>
</tr>
<tr>
	<td><input type="radio" name="theme" value="pink"></td>
	<td><font style="color:#e3b8dd;">●</font></td>
</tr>
<tr>
	<td><input type="radio" name="theme" value="blue"></td>
	<td><font style="color:#94abd1;">●</font></td>
</tr>
<tr>
	<td><input type="radio" name="theme" value="green"></td>
	<td><font style="color:#88b88d;">●</font></td>
</tr>
<tr>
	<td><input type="radio" name="theme" value="orange"></td>
	<td><font style="color:#d1b482;">●</font></td>
</tr>
<tr>
	<td><input type="radio" name="theme" value="default"></td>
	<td>기본 테마</td>
</tr>
</table>
<hr>
<button style="border: 1px solid grey; background-color: orange; color: white; height: 25px;">도토리로 구매</button>
</form>
<button style="border: 1px solid grey; background-color: orange; color: white; height: 25px;" onclick="homeGo();">취소</button>
</body>
</html>