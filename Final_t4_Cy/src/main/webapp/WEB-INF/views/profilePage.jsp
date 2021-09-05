<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	var a = '<%=session.getAttribute("weatherLat")%>';
	var b = '<%=session.getAttribute("weatherLon")%>';
	
	if(a=="-33.836024526801246"&&b=="151.20617143625608"){
		//session값이 시드니이면 현재 위치를 불러옴. 아니면 그대로
		if (navigator.geolocation) {
  	 
   	 // GeoLocation을 이용해서 접속 위치를 얻어옵니다
   		 navigator.geolocation.getCurrentPosition(function(position) {
   	     
    	    var lat = position.coords.latitude, // 위도
            lon = position.coords.longitude; // 경도
    	    location.href="location.go?lat="+lat+"&lon="+lon;
   	   	});
		} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
			location.href="location.go?lat=37.569308472100836&lon=126.98598514056673";
			//37.569308472100836, 126.98598514056673 : 학원주소
			//위치 설정을 사용할수 없을때는 학원주소로 설정.
		}
	}

</script>
</head>
<body>

<!-- 로그인 안 돼 있을 때 보여줄 페이지 -->
<c:if test="${sessionScope.loginMember == null}">
<c:if test="${sessionScope.pageInfo == null }">
<img src="resources/weathericon/${sessionScope.weatherIcon}.png" height="50px">
<h1 onclick="homeGo();">42월드</h1>
</c:if>
</c:if>

<!-- 로그인 돼 있을 때 p_id에 따라 보여줄 페이지 -->
<c:if test="${not empty sessionScope.pageInfo}">
<table id="loginTbl">
		<tr><td align="center"><h5><img src="resources/weathericon/${sessionScope.weatherIcon}.png" height="30px"></h5></td></tr>
		<tr><td><hr></td></tr>
		<tr><td id="loginSTd"><img src='resources/img/${sessionScope.pageInfo.p_photo}'width="150px"></td></tr>
		<c:if test="${not empty sessionScope.pageInfo.p_profile }">
		<tr><td><hr></td></tr>
		<tr><td align="center"><h5>${sessionScope.pageInfo.p_profile }</h5></td></tr>
		</c:if>
		<tr><td><hr></td></tr>
		<tr><td id="loginTd"><h5>${sessionScope.pageInfo.p_name }님의 미니홈피</h5></td></tr>
		<%--
		<c:if test="${not empty sessionScope.pageInfo.p_email }"><tr><td><h5>contact: ${sessionScope.pageInfo.p_email }"</h5></td></tr></c:if>
		<c:if test="${not empty sessionScope.pageInfo.p_sns }"><tr><td><h5><a href="${sessionScope.pageInfo.p_sns }" target='_blank'>SNS</a></h5></td></tr></c:if>
		<c:if test="${not empty sessionScope.pageInfo.p_state }"><tr><td><h5>now: ${sessionScope.pageInfo.p_state }</h5></td></tr></c:if>
--%>
	</table>
</c:if>

<!-- a href="https://kr.pikbest.com">무료  일러스트 부터 kr.pikbest.com</a-->




</body>
</html>