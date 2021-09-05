<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="resources/js/go.js"></script>
<link rel="stylesheet" href="resources/css/portfolio.css">
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function resumeGo() {
	location.href='resume.show';
}
function portGo(){
	location.href='port.show';
}
</script>
<style type="text/css">
 a:link { color: inherit; text-decoration: none;}
 a:visited { color: inherit; text-decoration: none;}
 a:hover { color: inherit; text-decoration: none;}
</style>
</head>
<body>
<button style="position: fixed; left: 260px; border: 1px solid grey; background-color: orange; color: white; height: 25px;" onclick="portGo();">포트폴리오</button>
<button style="position: fixed; left: 350px; border: 1px solid grey; background-color: orange; color: white; height: 25px;" onclick="resumeGo();">자기소개서</button>

<%--
<form action="correct.OK" method="post" enctype="multipart/form-data">
<button style="position: fixed; left: 260px; border: 1px solid grey; background-color: orange; color: white; height: 25px;">포트폴리오</button>
</form>

--%>
<%--
<form action="resume.correct.OK" method="post" enctype="multipart/form-data">
<button style="position: fixed; left: 350px; border: 1px solid grey; background-color: orange; color: white; height: 25px;">자기소개서</button>
</form>
--%>

<hr style="margin-top: 36px;">

<div style="width:100%; height:420px; overflow:auto">
<table style="text-align: center; height:400px;">
	<tr>
		<td colspan="2">인사말<br>
		<textarea name="p_textarea" style="font-weight:bold; background-color: #f0f0f0; border: 2px inherit grey; border-radius: 5px; resize: none;" cols="35" rows="5" id="p_textarea" readonly="readonly">${pt.p_textarea}</textarea>
		</td>
	</tr>
	
	<tr>
		<td colspan="2">
		<hr>
		</td>
	</tr>
	
	<tr>
		<td colspan="2">
			학력
			<table class="type07">
			<thead>
				<tr>
				<td>기간</td>
				<td>학교명</td>
				<td>전공</td>
				<td>졸업</td>
				</tr>
			</thead>
			<tbody>	
				<tr id="main_school">
				<td style="vertical-align: middle;">${pt.p_month1}<br>~<br>${pt.p_month2}</td>
				<td style="vertical-align: middle;">${pt.p_school}</td>
				<td style="vertical-align: middle;">${pt.p_major}</td>
				<td style="vertical-align: middle;">${pt.p_schoolInfo}</td>
				</tr>
			</tbody>	
			</table>
		</td>
	</tr>
	<tr>
		<td colspan="2">
		<hr>
		</td>
	</tr>
	
	<tr>
		<td>
			관심직종
			<table class="type07" style="width: 230px; height:89px; margin-left: auto; margin-right: auto; table-layout: fixed;">
			<thead>
				<tr>
				<td>대분류</td>
				<td>소분류</td>
				</tr>
			</thead>
			<tbody>	
				<tr id="main_school">
				<td style="vertical-align: middle;">${pt.p_selectBox1}</td>
				<td style="vertical-align: middle;">${pt.p_selectBox2}</td>
				</tr>
			</tbody>	
			</table>
		</td>
		
		<td>자격증
			<table class="type07" style="width: 230px; height: 89px; margin-left: auto; margin-right: auto; table-layout: fixed;">
			<thead>
				<tr>
				<td>취득일자</td>
				<td>자격명</td>
				</tr>
			</thead>
			<tbody>	
				<tr id="main_school">
				<td style="vertical-align: middle;">${pt.p_licenDate}</td>
				<td style="vertical-align: middle;">${pt.p_licenName}</td>
				</tr>
			</tbody>	
			</table>
		</td>
	</tr>
	
	<tr>
		<td colspan="2">
		<hr>
		</td>
	</tr>

	<tr>
		<td>스킬
			<table class="type07" style="width: 230px; height: 89px; margin-left: auto; margin-right: auto; table-layout: fixed;">
			<thead>
				<tr>
				<td>스킬명</td>
				<td>레벨</td>
				</tr>
			</thead>
			<tbody>	
				<tr>
				<td id="main_skill" style="vertical-align: middle;">${pt.p_skillname}</td>
				<td style="vertical-align: middle;"><input  id="main_skill_Lev" type="range" value="${pt.p_skillrange}" min='1' max='5' step='1'></td>
				</tr>
			</tbody>
			</table>
		</td>

		<td>
		취미<br>
		<table class="type07" style="width: 230px; height: 89px; margin-left: auto; margin-right: auto; table-layout: fixed;">
			<thead>
				<tr>
				<td>이름</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td style="vertical-align: middle;">${pt.p_hobby }</td>
				</tr>
			</tbody>
		</table>
		</td>
	</tr>
		
	<tr>
		<td colspan="2">
		<hr>
		</td>
	</tr>
	<c:if test="${sessionScope.pageInfo.p_id == sessionScope.loginMember.c_id }">
	<tr>
		<td colspan="2"><button style="border: 1px solid grey; background-color: orange; color: white; height: 25px;">
		<a href="port.Detail.go">EDIT</a></button></td>
	</tr>
	</c:if>
</table>
</div>

	
</body>
</html>

