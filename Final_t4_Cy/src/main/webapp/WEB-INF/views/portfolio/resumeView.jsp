<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="resources/js/go.js"></script>
<link rel="stylesheet" href="resources/css/resume.css">
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

<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript">
$(function() {
	//누르면 펼쳐지는 메뉴 제이쿼리
    // html dom 이 다 로딩된 후 실행된다.
    $(".que").click(function() {
    	   $(this).next(".anw").stop().slideToggle(300);
    	  $(this).toggleClass('on').siblings().removeClass('on');
    	  $(this).next(".anw").siblings(".anw").slideUp(300); // 1개씩 펼치기
    	});
});
</script>
</head>
<body>
<button style="position: fixed; left: 260px; border: 1px solid grey; background-color: orange; color: white; height: 25px;" onclick="portGo();">포트폴리오</button>
<button style="position: fixed; left: 350px; border: 1px solid grey; background-color: orange; color: white; height: 25px;" onclick="resumeGo();">자기소개서</button>

<%--
<form action="correct.OK" method="post" enctype="multipart/form-data">
<button style="position: fixed; left: 260px; border: 1px solid grey; background-color: orange; color: white; height: 25px;">포트폴리오</button>
</form>

<form action="resume.correct.OK" method="post" enctype="multipart/form-data">
<button style="position: fixed; left: 350px; border: 1px solid grey; background-color: orange; color: white; height: 25px;">자기소개서</button>
</form>
--%>
<hr style="margin-top: 36px;">

<form action="resume.correct.OK" method="post"
		enctype="multipart/form-data">
<div style="width:100%; height:420px; overflow:auto">
<table id="resumeTbl" style="height:400px;">
	
	<tr>
		<td style="width: 430px;">
     	<div class="que" style="text-align: left;">
      	<span style="color: #8bb7dd;">&nbsp;▼</span><span>&nbsp;신념과가치관</span>
     	</div>
     	<div class="anw" style="padding: 13px; font-size: 14px; text-align: left;">
			${rm.r_txt1 }
    	 </div>
		</td>
	</tr>

	<tr>
		<td>
     	<div class="que" style="text-align: left;">
      	<span style="color: #8bb7dd;">&nbsp;▼</span><span>&nbsp;성격소개</span>
     	</div>
     	<div class="anw" style="padding: 13px; font-size: 14px; text-align: left;">
			${rm.r_txt2 }
    	 </div>
		</td>
	</tr>
		
	<tr>
		<td>
     	<div class="que" style="text-align: left;">
      	<span style="color: #8bb7dd;">&nbsp;▼</span><span>&nbsp;자신이 가장 노력했던 경험 또는 성공한 경험</span>
     	</div>
     	<div class="anw" style="padding: 13px; font-size: 14px; text-align: left;">
			${rm.r_txt3 }
    	 </div>
		</td>
	</tr>
	
	<tr>
		<td>
     	<div class="que" style="text-align: left;">
      	<span style="color: #8bb7dd;">&nbsp;▼</span><span>&nbsp;경험, 경력 사항</span>
     	</div>
     	<div class="anw" style="padding: 13px; font-size: 14px; text-align: left;">
			${rm.r_txt4 }
    	 </div>
		</td>
	</tr>
	
	<tr>
		<td>
     	<div class="que" style="text-align: left;">
      	<span style="color: #8bb7dd;">&nbsp;▼</span><span>&nbsp;지원동기 및 입사 후 포부</span>
     	</div>
     	<div class="anw" style="padding: 13px; font-size: 14px; text-align: left;">
			${rm.r_txt5 }
    	 </div>
		</td>
	</tr>
	<c:if test="${sessionScope.pageInfo.p_id == sessionScope.loginMember.c_id }">
   <tr>
      <td colspan="2"><button style="border: 1px solid grey; background-color: orange; color: white; height: 25px;"><a href="resume.Detail.go">EDIT</a></button></td>
   </tr>
   </c:if>
</table>
</div> 
</form>	

</body>
</html>