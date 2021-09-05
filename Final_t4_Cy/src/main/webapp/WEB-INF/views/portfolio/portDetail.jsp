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
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript">
$(function() {
	
	$("#selectBox1").change(function() {	//1번 박스를 바꾸는 반응이 일어나면
		$("#selectBox2").empty();

		
	let sv = $("#selectBox1 option:selected").val();
	
	if(sv == 1){
		$("#selectBox2").empty();
		$("#selectBox2").append("<option>호텔·여행·항공</option><option>스포츠·여가·레저·뷰티·미용</option><option>정비·A/S·카센터</option><option>렌탈·임대·리스</option><option>시설관리·보안·경비</option>");
	} else if(sv == 2){
		$("#selectBox2").empty();
		$("#selectBox2").append("<option>은행·금융</option><option>캐피탈·대출</option><option>증권·보험·카드</option>");
	} else if(sv == 3){
		$("#selectBox2").empty();
		$("#selectBox2").append("<option>웹·응용·시스템 프로그래밍</option><option>쇼핑몰·포털·컨텐츠·커뮤니티</option><option>네트워크·서버·보안</option><option>웹디자인·웹퍼블리셔</option><option>동영상제작</option><option>소프트웨어·하드웨어</option>");
	} else if(sv == 4){
		$("#selectBox2").empty();
		$("#selectBox2").append("<option>백화점·유통·도,소매</option><option>무역·물류</option>");
	} else if(sv == 5){
		$("#selectBox2").empty();
		$("#selectBox2").append("<option>전기·반도체·기계</option><option>자동차·조선·철강·항공</option><option>금속·재료·자재</option><option>화학·에너지·환경</option><option>섬유·의류·패션</option><option>식품가공</option><option>농축산·어업·임업</option>");
	} else if(sv == 6){
		$("#selectBox2").empty();
		$("#selectBox2").append("<option>학교(초·중·고·대학·특수)</option><option>유아·유치원·어린이집</option><option>학원·어학원·교육원</option><option>학습지·방문교육</option>");
	} else if(sv == 7){
		$("#selectBox2").empty();
		$("#selectBox2").append("<option>건축·설비·환경</option><option>건설·시공·토목·조경</option><option>인테리어·자재</option><option>부동산·중개·임대</option>");
	} else if(sv == 8){
		$("#selectBox2").empty();
		$("#selectBox2").append("<option>의료</option><option>간호·원무·상담</option><option>제약·보건·바이오</option><option>사회복지·요양</option>");
	} else if(sv == 9){
		$("#selectBox2").empty();
		$("#selectBox2").append("<option>방송·케이블·프로덕션</option><option>신문·출판·인쇄</option><option>광고·홍보·전시</option><option>영화·음반·연예·엔터테인먼트</option>");
	} else if(sv == 10){
		$("#selectBox2").empty();
		$("#selectBox2").append("<option>문화·공연·예술</option><option>디자인·CAD</option>");
	} else if(sv == 11){
		$("#selectBox2").empty();
		$("#selectBox2").append("<option>공기업·공공기관</option><option>컨설팅·연구·조사</option><option>회계·세무·법무</option>");
	}     
	
	
	});
	
	$('#p_textarea').on('keyup', function() {
	      $('#test_cnt').html("("+$(this).val().length+" / 100)");
	      if($(this).val().length > 100) {
	          $(this).val($(this).val().substring(0, 100));
	          $('#test_cnt').html("(100 / 100)");
	      }
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

<form action="correct.OK" method="post"
		enctype="multipart/form-data">
<div style="width:100%; height:420px; overflow:auto">

<table style="text-align: center; height:400px;">
	<tr>
		<td colspan="2">인사말<br>
		<textarea name="p_textarea" style="font-weight:bold; background-color: #f0f0f0; border: 2px inherit grey; border-radius: 10px; resize: none;" cols="35" rows="5" id="p_textarea">${pt.p_textarea}</textarea>
		<div id="test_cnt" style="font-size: 8px">(0 / 100)</div>
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
				<tr>
				<td style="vertical-align: middle;"><input value="${pt.p_month1}" class="monthBox" name="p_month1" type="month">~<input value="${pt.p_month2}" class="monthBox" name="p_month2" type="month"></td>
				<td style="vertical-align: middle;"><input value="${pt.p_school}" name="p_school" id="school" type="search"></td>
				<td style="vertical-align: middle;"><select id="major" name="p_major">
				<option value="${pt.p_major}" selected="selected">${pt.p_major}</option>
     					<optgroup label="공학계열">
     						<option>건축학</option>
     						<option>토목공학</option>
     						<option>조경학</option>
     						<option>도시공학</option>
     						<option>지상교통공학</option>
     						<option>항공학</option>
     						<option>조선공학</option>
     						<option>바이오·유전공학</option>
     						<option>금속공학</option>
     						<option>기계·메카트로닉스·로봇</option>
     						<option>자동차공학</option>
     						<option>산업공학</option>
     						<option>반도체·세라믹공학</option>
     						<option>섬유공학</option>
     						<option>신소재·재료공학</option>
     						<option>전기·전자공학</option>
     						<option>제어계측공학</option>
     						<option>광학공학</option>
     						<option>에너지공학</option>
     						<option>화학공학</option>
     						<option>소방방재학과</option>
     						<option>전산학·컴퓨터공학</option>
     						<option>응용소프트웨어공학</option>
     						<option>정보·통신공학</option>
		     			</optgroup>
     					<optgroup label="자연계열">
        					<option>물리·과학</option>
		        			<option>수학</option>
		        			<option>천문·기상학</option>
		        			<option>통계학</option>
		        			<option>동물·수의학</option>
		        			<option>생물학</option>
		        			<option>지원학</option>
		        			<option>화학</option>
		        			<option>농업학</option>
		        			<option>산림·원예학</option>
		        			<option>수산학</option>
		        			<option>식품영양·조리학</option>
		        			<option>의류·의상학</option>
		     			</optgroup>
		     			<optgroup label="사회계열">
		     				<option>경영학</option>
		     				<option>경제학</option>
		     				<option>호텔·관광경영학</option>
		     				<option>광고·홍보학</option>
		     				<option>금융·회계·세무학</option>
		     				<option>무역·유통학</option>
		     				<option>법학</option>
		     				<option>가족·복지·아동·청소년학</option>
		     				<option>국제학</option>
		     				<option>도시·지역학</option>
		     				<option>사회학</option>
		     				<option>신문·방송·언론·미디어학</option>
		     				<option>정치외교학</option>
		     				<option>행정학·경찰·보건행정</option>
		     				<option>비서학</option>
		     				<option>지리학</option>
		     			</optgroup>	
		     			<optgroup label="인문계열">
		     				<option>국어·국문학</option>
		     				<option>영미어·문학</option>
		     				<option>일본어·문학</option>
		     				<option>중국어·문학</option>
		     				<option>독일어·문학</option>
		     				<option>러시아어·문학</option>
		     				<option>스페인어·문학</option>
		     				<option>프랑스어·문학</option>
		     				<option>기타아시아어·문학</option>
		     				<option>기타유럽어·문학</option>
		     				<option>언어학</option>
		     				<option>국제지역학</option>
		     				<option>문헌정보학</option>
		     				<option>문화·민속·미술사학</option>
		     				<option>심리학</option>
		     				<option>역사·고고학</option>
		     				<option>철학·윤리학</option>
		     				<option>종교학</option>
		     			</optgroup>	
		     			<optgroup label="예체능계열">
		     				<option>산업디자인</option>
		     				<option>시각디자인</option>
		     				<option>패션디자인</option>
		     				<option>무용</option>
		     				<option>체육</option>
		     				<option>미술·조형</option>
		     				<option>연극·영화</option>
		     				<option>음악</option>
		     				<option>공예</option>
		     				<option>사진</option>
		     				<option>애니메이션학</option>
		     				<option>영상·예술</option>
		     			</optgroup>	
		     			<optgroup label="교육계열">
		     				<option>교육학</option>
		     				<option>유아교육학</option>
		     				<option>초등교육학</option>
		     				<option>공학교육학</option>
		     				<option>사회교육학</option>
		     				<option>언어교육학</option>
		     				<option>예체능교육학</option>
		     				<option>인문교육학</option>
		     				<option>자연계교육학</option>
		     				<option>특수교육학</option>
		     			</optgroup>	
		     			<optgroup label="의약계열">
							
		     				<option>간호</option>
		     				<option>약학</option>
		     				<option>의학</option>
		     				<option>치의학</option>
		     				<option>한의학</option>
		     				<option>보건학</option>
		     				<option>의료공학</option>
		     				<option>치위생학</option>
		     				<option>치기공학</option>
		     				<option>임상병리학</option>
		     				<option>방사선학학</option>
		     				<option>재활/물리치료학</option>
		     				<option>의무행정학</option>
		     			</optgroup>
					</select>
				</td>
				<td style="vertical-align: middle;"><select id="schoolInfo" name="p_schoolInfo">
					<option>${pt.p_schoolInfo}</option>
  					<option value="재학">재학</option>
  					<option value="휴학">휴학</option>
  					<option value="졸업">졸업</option>
  					<option value="자퇴">자퇴</option>
					</select></td>
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
			<table class="type07">
			<thead>
				<tr>
				<td>대분류</td>
				<td>소분류</td>
				</tr>
			</thead>
			<tbody>	
				<tr>
				<td><select id="selectBox1" name="p_selectBox1">
			<option value="${pt.p_selectBox1}" selected="selected">${pt.p_selectBox1}</option>
			<option value="1">서비스업</option>
			<option value="2">금융·은행업</option>
			<option value="3">IT·정보통신업</option>
			<option value="4">판매·유통업</option>
			<option value="5">제조·생산·화학업</option>
			<option value="6">교육업</option>
			<option value="7">건설업</option>
			<option value="8">의료·제약업</option>
			<option value="9">미디어·광고업</option>
			<option value="10">문화예술·디자인업</option>
			<option value="11">기관·협회</option>
			</select>
				</td>
				<td><select id="selectBox2" name="p_selectBox2">
			<option value="${pt.p_selectBox2}" selected="selected">${pt.p_selectBox2}</option>
			<option>호텔·여행·항공</option>
			<option>스포츠·여가·레저·뷰티·미용</option>
			<option>정비·A/S·카센터</option>
			<option>렌탈·임대·리스</option>
			<option>시설관리·보안·경비</option>
			</select>
				</td>
				</tr>
			</tbody>	
			</table>
		</td>
		
	 	<td>자격증
			<table class="type07">
			<thead>
				<tr>
					<td>취득일자</td>
					<td>자격명</td>
				</tr>
			</thead>
			<tbody>	
				<tr>
					<td><input value="${pt.p_licenDate}" id="licenDate" type="date" name="p_licenDate"></td> 
					<td><input value="${pt.p_licenName}" id="licenName" name="p_licenName"></td> 
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
			<table class="type07">
			<thead>
				<tr>
				<td>스킬명</td>
				<td>레벨</td>
				</tr>
			</thead>
			<tbody>	
				<tr>
				<td><input id="skillname" value="${pt.p_skillname}" name="p_skillname" placeholder="예시)어학,프로그램,강점"></td>
				<td><input id="skillLevel" name="p_skillrange" type="range" value="${pt.p_skillrange}" min='1' max='5' step='1'></td>
				</tr>
			</tbody>
			</table>
		</td>

		<td>
		취미<br>
		<table class="type07">
			<thead>
				<tr>
				<td>이름</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
					<input id="hobby" value="${pt.p_hobby }" name="p_hobby">
					</td>
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
		<td colspan="2"><button style="border: 1px solid grey; background-color: orange; color: white; height: 25px;">확인</button></td>
	</tr>
</table>
</div>
</form>	

</body>
</html>

