<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function calldotori(){
	var con = confirm('도토리 3개가 소모됩니다. 구매하시겠습니까?');
	if(!con){
		location.href="menu.home.go"
		return false;
	}
};

function shopBgmGo(){
	location.href="shop.bgm.go";
}

function shopThemeGo(){
	location.href="shop.theme.go";
}

</script>
</head>
<body>

<form action="shop.buy" onsubmit="calldotori();">
보유 도토리: ${sessionScope.loginMember.c_dotori}개
<h2>인기 브금 구매</h2>
<input name="c_id" value="${sessionScope.loginMember.c_id }" type="hidden">
<input name="c_dotori" value="${sessionScope.loginMember.c_dotori }" type="hidden">
<div style="width:100%; height:320px; overflow:auto">
<table>
<tr>
	<td><input type="radio" name="bgm" value="Y (Please Tell Me Why) - 프리스타일" checked></td>
	<td><img src="resources/music/Y (Please Tell Me Why) - 프리스타일.jpeg" width='30'></td>
	<td>Y (Please Tell Me Why) - 프리스타일</td>
</tr>
<tr>
	<td><input type="radio" name="bgm" value="몽환의 숲 (feat.이루마) - 키네틱플로우"></td>
	<td><img src="resources/music/몽환의 숲 (feat.이루마) - 키네틱플로우.jpeg" width='30'></td>
	<td>몽환의 숲 (feat.이루마) - 키네틱플로우</td>
</tr>
<tr>
	<td><input type="radio" name="bgm" value="눈의 꽃 - 박효신"></td>
	<td><img src="resources/music/눈의 꽃 - 박효신.jpeg" width='30'></td>
	<td>눈의 꽃 - 박효신</td>
</tr>
<tr>
	<td><input type="radio" name="bgm" value="Love Love Love - 에픽하이"></td>
	<td><img src="resources/music/Love Love Love - 에픽하이.jpeg" width='30'></td>
	<td>Love Love Love - 에픽하이</td>
</tr>
<tr>
	<td><input type="radio" name="bgm" value="Perhaps Love(사랑인가요) (duet with J) - 하울(HowL)"></td>
	<td><img src="resources/music/Perhaps Love(사랑인가요) (duet with J) - 하울(HowL).jpeg" width='30'></td>
	<td>Perhaps Love(사랑인가요) (duet with J) - 하울(HowL)</td>
</tr>
<tr>
	<td><input type="radio" name="bgm" value="심장이 없어 - 에이트(8Eight)"></td>
	<td><img src="resources/music/심장이 없어 - 에이트(8Eight).jpeg" width='30'></td>
	<td>심장이 없어 - 에이트(8Eight)</td>
</tr>
<tr>
	<td><input type="radio" name="bgm" value="벌써일년 - 브라운 아이즈"></td>
	<td><img src="resources/music/벌써일년 - 브라운 아이즈.jpeg" width='30'></td>
	<td>벌써일년 - 브라운 아이즈</td>
</tr>
<tr>
	<td><input type="radio" name="bgm" value="응급실 - izi"></td>
	<td><img src="resources/music/응급실 - izi.jpeg" width='30'></td>
	<td>응급실 - izi</td>
</tr>
<tr>
	<td><input type="radio" name="bgm" value="Officially Missing You - 긱스"></td>
	<td><img src="resources/music/Officially Missing You - 긱스.jpeg" width='30'></td>
	<td>Officially Missing You - 긱스</td>
</tr>
<tr>
	<td><input type="radio" name="bgm" value="비행소녀 - 마골피"></td>
	<td><img src="resources/music/비행소녀 - 마골피.jpeg" width='30'></td>
	<td>비행소녀 - 마골피</td>
</tr>
<tr>
	<td><input type="radio" name="bgm" value="헤어지지 못하는 여자, 떠나가지 못하는 남자 (feat. 정인) - 리쌍"></td>
	<td><img src="resources/music/헤어지지 못하는 여자, 떠나가지 못하는 남자 (feat. 정인) - 리쌍.jpeg" width='30'></td>
	<td>헤어지지 못하는 여자, 떠나가지 못하는 남자 (feat. 정인) - 리쌍</td>
</tr>
<tr>
	<td><input type="radio" name="bgm" value="우산 (feat. 윤하) - 에픽하이"></td>
	<td><img src="resources/music/우산 (feat. 윤하) - 에픽하이.jpeg" width='30'></td>
	<td>우산 (feat. 윤하) - 에픽하이</td>
</tr>
<tr>
	<td><input type="radio" name="bgm" value="Kissing You - 소녀시대"></td>
	<td><img src="resources/music/Kissing You - 소녀시대.jpeg" width='30'></td>
	<td>Kissing You - 소녀시대</td>
</tr>
<tr>
	<td><input type="radio" name="bgm" value="Timeless - SG워너비"></td>
	<td><img src="resources/music/Timeless - SG워너비.jpeg" width='30'></td>
	<td>Timeless - SG워너비</td>
</tr>
<tr>
	<td><input type="radio" name="bgm" value="나에게로 떠나는 여행 - 버즈"></td>
	<td><img src="resources/music/나에게로 떠나는 여행 - 버즈.jpeg" width='30'></td>
	<td>나에게로 떠나는 여행 - 버즈</td>
</tr>
</table>
</div>
<hr>
<button style="border: 1px solid grey; background-color: orange; color: white; height: 25px;">도토리로 구매</button>
</form>
<button style="border: 1px solid grey; background-color: orange; color: white; height: 25px;" onclick="homeGo();">취소</button>
</body>
</html>