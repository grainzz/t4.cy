<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<style type="text/css"> 
#bannerBtn {
border: 1px solid grey; background-color: orange; color: white;
width: 45px;
height: 25px
}
#bannerBtn2 {
border: 1px solid grey; background-color: orange; color: white;
width: 75px;
height: 25px 
}
</style>
<script type="text/javascript">
function shopGo(){
	location.href='shop.go';
};

var audio = new Audio('resources/music/${bgm}.mp3');
audio.loop=true; //반복재생함
audio.volume=0.5; //음량 설정 범위: 0~1

function playMusic(playbtn){
	if(playbtn.value == '▶'){
		audio.play();
		playbtn.value='■';
	}else{
		audio.pause();
		playbtn.value='▶';
	}
}
/*
function darkMode(theme){
	var body = document.querySelector('body');
	var btn = document.getElementById('btnDisplayMode');
	var tbl = document.getElementById('bannerTbl');
	if (theme.value == '🌜') {
		body.style.backgroundColor = 'black';
		body.style.color = '#121212';
		btn.style.backgroundColor = 'yellow';
		tbl.style.backgorundColor = 'black';
		tbl.style.color = '#121212';
		theme.value = '🌞';
	} else {
		body.style.backgroundColor = '#8f8f8f';
		body.style.color = 'black';
		btn.style.background = 'black';
		tbl.style.backgroundColor = 'white';
		tbl.style.color = 'black';
		theme.value = '🌜';
	}
	localStorage.setItem('theme', theme)
}
*/

</script> 
 
</head>
<BODY>
<table id="bannerTbl" align="center">
<tr>
<td>BGM</td>
</tr>
<c:if test="${sessionScope.pageInfo.p_music == null}">
<tr>
<td width="90" style="background-color: black; color:white">
 <marquee scrolldelay="160">사용중인 브금이 없습니다</marquee>
 </td>
</tr>
</c:if>

<c:if test="${not empty sessionScope.pageInfo.p_music }">
<tr>
<td width="90" style="background-color: black; color:white">
 <marquee scrolldelay="160">${sessionScope.pageInfo.p_music }</marquee>
 </td>
 <td><input type="button" value="▶" onclick=playMusic(this)></td>
</tr>
<%--
<tr><td><audio id="au" autoplay loop controls><source src="resources/music/${sessionScope.pageInfo.p_music }.mp3" type="audio/mp3"></audio></td></tr>
--%>
</c:if>
<%--
<tr>
<td> <input type="button" id='btnDisplayMode'
 style="background-color: black;" value="🌜" onclick=darkMode(this)> 
</tr>
<tr>
<td><font onclick=purple() style="color:#ecd4ff; cursor : pointer;">●</font>
<font onclick=pink() style="color:#ffdff3; cursor : pointer;">●</font>
<font onclick=blue() style="color:#def9ff; cursor : pointer;">●</font>
<font onclick=green() style="color:#e6ffca; cursor : pointer;">●</font>
<font onclick=orange() style="color:#ffe2c8; cursor : pointer;">●</font></td>
</tr>
--%>
<tr>
<td><img src="resources/img/dotori.jpg" width="15px">
<c:if test="${not empty sessionScope.loginMember.c_dotori }">${sessionScope.loginMember.c_dotori }개 </c:if>
<button id="bannerBtn" onclick="payGo();">충전</button>
</td>
</tr>
<tr>
<td><button id="bannerBtn2" onclick="shopGo();">선물가게</button></td>
</tr>
<c:if test="${not empty sessionScope.loginMember.c_id}">
<tr><td><h5>${sessionScope.loginMember.c_name }님<br>안녕하세요!</h5></td></tr>
</c:if>


</table>
</body>
</html>