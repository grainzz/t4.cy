<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	   
	$('#p_profile').on('keyup', function() {
	    $('#counter').html("("+$(this).val().length+" / 80)");
	    if($(this).val().length > 200) {
	        $(this).val($(this).val().substring(0, 80));
	        $('#counter').html("(80 / 80)");
	    }
	});

	});
</script>
</head>
<body>
	<form name="profileForm" action="profile.set">
		<table id="joinTable">
			<tr><td><input type="hidden" name="p_id" value="${sessionScope.pageInfo.p_id }"></td></tr>
			<tr>
				<td colspan="2" align="center"><h2>프로필메시지 설정</h2></td>
			</tr>
			<!--
			<tr>
				<td>프로필사진</td>
				<td><img src="resources/img/${sessionScope.pageInfo.p_photo }" width="150"></td>
			</tr>
			-->
			<tr>
				<td>이름</td>
				<td>${sessionScope.pageInfo.p_name }</td>
			</tr>
			<tr>
				<td>프로필메시지</td>
				<td><textarea name="p_profile" id="p_profile" placeholder="프로필메시지 입력" style="height: 80px; resize:none">${sessionScope.pageInfo.p_profile }</textarea></td>
			</tr>
			<tr>
				<td></td>
				<td align="right" style="color:grey; font-size:8pt" id="counter"> (0/80) </td>
			</tr>
			<tr>
				<!--  td>이메일주소</td-->
				<td><input name="p_email" value="${sessionScope.pageInfo.p_email }" placeholder="이메일 입력" type="hidden" value=" "></td>
			</tr>
			<tr>
				<!--  td>sns주소</td-->
				<td><input name="p_sns" value="${sessionScope.pageInfo.p_sns }" placeholder="sns주소 입력" type="hidden" value=" "></td>
			</tr>
			<tr>
				<!--  td>구직상태</td-->
				<td>
				<input name="p_state" value=" " type="hidden">
				<%--
				<select name="p_state" >
					<option value="구직중" >구직중</option>
					<option value="제안 받음">제안 받음</option>
					<option value="구직 안함">구직 안함</option>
				</select></td>
				--%>
			<tr>
			<tr>
				<td colspan='2' align="center"><button style="border: 1px solid grey; background-color: orange; color: white; height: 25px;">설정</button></td>
			</tr>
		
		</table>
	</form>
	
	
</body>
</html>