<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		$("#c_id").keyup(function() {
			$('#idchkNotice').html('');
			let inputVal = $("#c_id").val();
					
			$.ajax({
				type : 'GET',
				url : "/cy/member.IdChk",
				data : {
					"c_id" : inputVal
				},
				dataType : 'json',
				success : function(data) {
					
					if (data == 1) {
						$('#idchkNotice').html('이미 사용 중인 ID입니다');
						$('#idchkNotice').attr('color', '##FF0000');
					}

					else if (data == 0) {
						$('#idchkNotice').html('사용가능한 ID입니다');
						$('#idchkNotice').attr('color', '#228B22');
					}
				}
			});

		});
	});
</script>
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
	<form name="joinForm" action="member.join" method="post"
		enctype="multipart/form-data">
		<table id="joinTable">
			<tr>
				<td style="text-align: center;" colspan="2"><b>회원가입 </b>
					<h5>(모든 칸 필수입력)</h5></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" class="c_id" id="c_id" name="c_id"
					placeholder="10글자 이내 알파벳 및 숫자 입력" maxlength="10"
					required="required"><br> <font id="idchkNotice"
					size="1"> </font>
			</tr>
			<tr>
				<div class="eTooltip">
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
				<td><input name="c_name" required="required"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					 <input type="radio" value="남자" name="c_gender" width="70px" >남자 
					<input type="radio" value="여자" name="c_gender" width="70px" >여자
				</td>
			</tr>
				<td> 미니미 선택</td>
				<td>
				 	<img src="resources/img/m.jpg" width="70px" value="남"> 
					<input type="radio" name="c_minimi" width="70px" src="resources/img/m.jpg" value="resources/img/m.jpg"> 

					<img src="resources/img/w.jpg" width="70px" value="여"> 
					<input type="radio" name="c_minimi" width="70px" src="resources/img/w.jpg" value="resources/img/w.jpg"> 
				</td>
			<tr>
				<p>
				<td>전화번호</td>
				<td><input name="c_phone" placeholder="‘-’ 를 제외한 숫자만 입력"
					maxlength="11" required="required" /></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input name="c_birth" type="date" required="required"></td>
			</tr>
			<tr>
				<td>프로필 사진</td>
				<td><input type="file" name="c_photo" required="required"></td>
			</tr>
			<tr>
				<td class="join_button_wrap">
				<input style="border: 1px solid grey; position: absolute; left: 630px; top: 520px; height: 50px; background-color: orange; color: white; width: 70px; height: 25px"
					type="submit" class="join_button" value="가입"></td>
			</tr>
		
		</table>
	</form>
	</div>
</body>
</html>