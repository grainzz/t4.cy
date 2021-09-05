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
	
    $(".doque").click(function() {
    	   $(this).next(".doanw").stop().slideToggle(300);
    	  $(this).toggleClass('on').siblings().removeClass('on');
    	  $(this).next(".doanw").siblings(".doanw").slideUp(300); // 1개씩 펼치기
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
     	<div class="doque" style="text-align: left;">
      	<span style="background: orange;">🔔도움말</span>
     	</div>
     	<div class="doanw" style="text-align: left; padding: 12px;">
			<span style="font-weight: bold;">&nbsp;작성하기 전 주의사항</span>
			<br><span style="font-size: 13px;">&nbsp;&nbsp;&nbsp;&nbsp;①자신의 장점과 약점을 10가지 정도 적어보는 것 부터 시작하자
			<br>&nbsp;&nbsp;&nbsp;&nbsp;②두괄식으로 작성하자 
			<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;→<u>Theme(주제) + Episode(사례,근거) + Advantage(강조,포부)</u>
			<br>&nbsp;&nbsp;&nbsp; ③자기PR을 적극적으로 하되 과장되지 않게하자
			<br>&nbsp;&nbsp;&nbsp;&nbsp;④필요한 부분만 간단명료하게 기술하자
			<br>&nbsp;&nbsp;&nbsp;&nbsp;⑤말하고자 하는 바를 잘 전달하기 위해 구체적으로 쓰자</span><br><br>
    		<span style="font-weight: bold;">&nbsp;작성 후  주의사항</span>
			<br><span style="font-size: 13px;">&nbsp;&nbsp;&nbsp;&nbsp;①오타가 있는지 확인하자
			<br>&nbsp;&nbsp;&nbsp;&nbsp;②어색한 문장을 찾아내기 위해 소리내어 읽어보자
			<br>&nbsp;&nbsp;&nbsp;&nbsp;③중복되는 단어는 회피하자
			<br>&nbsp;&nbsp;&nbsp;&nbsp;④여러 번의 수정과정을 거치자
			<br>&nbsp;&nbsp;&nbsp;&nbsp;⑤추가 자료(포트폴리오)를 제출하는 것을 잊지말자</span>
    	 </div>
		</td>
	</tr>
	<tr>
		<td style="width: 430px;">
     	<div class="que" style="text-align: left;">
      	<span style="color: #8bb7dd;">&nbsp;▼</span><span>&nbsp;신념과가치관</span>
     	</div>
     	<div class="anw" style="padding: 17px;">
     		<div style="color: gray; font-style: italic; text-align: left; font-size: 14px;">TIP!<br>-자신의 가치판단의 기준인 가치관, 삶의 태도에 대해 어필할 수 있는 내용 작성<br>-직무적인 능력을 연결할 수 있는 에피소드를 인용</div>
			<br>
			<textarea name="r_txt1" style="border: 2px inherit gray; border-radius: 4px; resize: none; font-size: 14px;" rows="10" cols="56">${rm.r_txt1 }</textarea>
    	 </div>
		</td>
	</tr>

	<tr>
		<td>
     	<div class="que" style="text-align: left;">
      	<span style="color: #8bb7dd;">&nbsp;▼</span><span>&nbsp;성격소개</span>
     	</div>
     	<div class="anw" style="padding: 17px;">
     		<div style="color: gray; font-style: italic; text-align: left; font-size: 14px;">TIP!<br>-내 직무와 어울리는 성향으로 작성하기<br>-장점을 70% 이상 작성<br>-단점은 반드시 극복하는 모습을 보일 것</div>
			<br>
			<textarea name="r_txt2" style="border: 2px inherit gray; border-radius: 4px; resize: none; font-size: 14px;" rows="10" cols="56">${rm.r_txt2 }</textarea>
    	 </div>
		</td>
	</tr>
		
	<tr>
		<td>
     	<div class="que" style="text-align: left;">
      	<span style="color: #8bb7dd;">&nbsp;▼</span><span>&nbsp;자신이 가장 노력했던 경험 또는 성공한 경험</span>
     	</div>
     	<div class="anw" style="padding: 17px;">
     		<div style="color: gray; font-style: italic; text-align: left; font-size: 14px;">TIP!<br>-살면서 가장 노력했던 경험 으로 인해 성공한 에피소드를 작성</div>
			<br>
			<textarea name="r_txt3" style="border: 2px inherit gray; border-radius: 4px; resize: none; font-size: 14px;" rows="10" cols="56">${rm.r_txt3 }</textarea>
    	 </div>
		</td>
	</tr>
	
	<tr>
		<td>
     	<div class="que" style="text-align: left;">
      	<span style="color: #8bb7dd;">&nbsp;▼</span><span>&nbsp;경험, 경력 사항</span>
     	</div>
     	<div class="anw" style="padding: 17px;">
     		<div style="color: gray; font-style: italic; text-align: left; font-size: 14px;">TIP!<br>-동아리,아르바이트,직무 에서 자신이 해왔던 역할에 대해 서술<br>-이러한 경험을 토대로 기여도 작성</div>
			<br>
			<textarea name="r_txt4" style="border: 2px inherit gray; border-radius: 4px; resize: none; font-size: 14px;" rows="10" cols="56">${rm.r_txt4 }</textarea>
    	 </div>
		</td>
	</tr>
	
	<tr>
		<td>
     	<div class="que" style="text-align: left;">
      	<span style="color: #8bb7dd;">&nbsp;▼</span><span>&nbsp;지원동기 및 입사 후 포부</span>
     	</div>
     	<div class="anw" style="padding: 17px;">
     		<div style="color: gray; font-style: italic; text-align: left; font-size: 14px;">TIP!<br>-지원동기 : 다양한 것 중 ㅇㅇ으로 선택한 이유와 그 중 ㅇㅇㅇ에 지원한 동기에 대해 작성<br>-입사 후 포부 : 직무를 잘 수행할 수 있는 이유와 포부를 내걸 때 그에 맞는 대책까지 세운다면 best!</div>
			<br>
			<textarea name="r_txt5" style="border: 2px inherit gray; border-radius: 4px; resize: none; font-size: 14px;" rows="10" cols="56">${rm.r_txt5 }</textarea>
    	 </div>
		</td>
	</tr>
	
	<tr>
		<td colspan="2"><button style="border: 1px solid grey; background-color: orange; color: white; height: 25px;">확인</button></td>
	</tr>
</table>
</div> 
</form>	

 
</body>
</html>