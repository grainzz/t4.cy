<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
function loginCheck(){
	if (!document.loginForm.id.value){
		alert("아이디를 입력해 주세요.");
		document.loginForm.id.focus();
		return false;
	}
	if (!document.loginForm.pw.value) {
		alert("비밀번호를 입력해 주세요.");
		document.loginForm.pw.focus();
		return false;
	}
	document.loginForm.submit();
}




</script>
<title>Insert title here</title>
</head>
<body>
<form name="loginForm" action="member.login" method="post"
		onsubmit="return loginCheck();">
		<table>
			<tr>
				<td><input id="id" style="border:2px solid orange" id="userId" name="c_id" placeholder="아이디"></td>
			</tr>
			<tr>
				<td><input id="pw" style="border:2px solid orange" type="password" name="c_pw" placeholder="비밀번호"></td>
				<td>
				<button style="border: 1px solid grey;  position: absolute; left: 580px; top: 260px; 
				height: 55px; background-color: orange; color: white;">로그인</button></td>
				
					</tr>
				<tr>
				<td><input style="width: 25px;" name="autologin" type="checkbox">로그인 상태 유지</td>
			</tr>
			<tr>
				<td style="padding-top: 7px;">
					<input style="border: hidden; background-color: white; color: red;" type="button" onClick="location.href='member.join.go'" value="회원가입">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>