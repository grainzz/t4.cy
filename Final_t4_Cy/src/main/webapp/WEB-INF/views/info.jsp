<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		$('#c_pw').keyup(function() {
			$('#chkNotice').html('');
		});

		$('#c_pw2').keyup(function() {

			if ($('#c_pw').val() != $('#c_pw2').val()) {
				$('#chkNotice').html('비밀번호가 일치하지 않습니다');
				$('#chkNotice').attr('color', '##FF0000');
			} else {
				$('#chkNotice').html('비밀번호가 일치합니다');
				$('#chkNotice').attr('color', '#228B22');
			}

		});
	});
</script>
</head>
<body>

	<form name="joinForm" action="member.update" method="post"
		enctype="multipart/form-data">
		<table id="joinTable">
			<tr>
				<td colspan="2" class="joinTd"><b>회원정보</b></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input name="c_id"
					value="${sessionScope.loginMember.c_id }" readonly="readonly"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" id="c_pw" placeholder="10글자 이상"
					minlength="10" name="c_pw" required="required" /></td>
				</th>
			</tr>

			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" id="c_pw2" name="c_pw2"
					required="required" minlength="10"> <br> <font
					id="chkNotice" size="1"> </font></td>
			</tr>


			<tr>
				<td>이름</td>
				<td><input name="c_name"
					value="${sessionScope.loginMember.c_name }"></td>
			</tr>

			<tr>
				<td>연락처</td>
				<td><input name="c_phone"
					value="${sessionScope.loginMember.c_phone }"></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input name="c_birth" type="date"
					value="${sessionScope.loginMember.c_birth }"></td>
			</tr>
			<tr>
				<td>사진</td>
				<td><img
					src="resources/img/${sessionScope.loginMember.c_photo }"
					width="100px"> <input type="file" name="c_photo"></td>
			</tr>
			<tr>
				<td colspan="2" class="joinTd">
					<button type="submit" value="수정"
						style="border: 1px solid grey; position: absolute; left: 550px; top: 480px; height: 50px; background-color: orange; color: white; width: 70px; height: 25px">수정</button>
					<button type="submit" value="탈퇴" onclick="byebye()"
						style="border: 1px solid grey; position: absolute; left: 630px; top: 480px; height: 50px; background-color: orange; color: white; width: 70px; height: 25px">탈퇴</button>
					<!-- 
				 <input type="button" value="탈퇴" onclick="byebye()" style="border: 1px solid grey; position: absolute; left: 630px; top: 480px; height: 50px; background-color: orange; color: white; width: 70px; height: 25px"> 
				 -->
				</td>

			</tr>
		</table>
	</form>
</body>
</html>