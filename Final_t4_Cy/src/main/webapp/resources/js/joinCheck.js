function joincheck(){
	let c_id = document.joinForm.c_id;
	let c_pw = document.joinForm.c_pw;
	let c_pw2 = document.joinForm.c_pw2;
	let c_name = document.joinForm.c_name;
	let c_phone = document.joinForm.c_phone;
	let c_birth = document.joinForm.c_birth;
	let c_photo = document.joinForm.c_photo;
	
	
	if (isEmpty(c_id)) {
		alert('아이디를 입력하세요.');

		c_id.svalue = "";
		c_id.focus();

		return false;
	
	}
	
	if (containKR(c_id)) {
		alert('id에 사용할 수 없는 문자입니다.');

		c_id.value = "";
		c_id.focus();

		return false;
	
	
	}
	
	
	if (isEmpty(c_pw)) {
		alert('비밀번호를 입력하세요.');

		c_pw.value = "";
		c_pw.focus();

		return false;
	
	}
	
	
		if (isEmpty(c_pw2)) {
		alert('비밀번호가 맞는지 다시한번 확인해주세요.');

		c_pw2.value = "";
		c_pw2.focus();

		return false;
	}
	
	if(notEquals(c_pw, c_pw2)){
		alert('비밀번호가 서로 다릅니다.')
		
		c_pw.value="";
		c_pw2.value="";
		c_pw.focus();
		
		return false;
	}
	if (isEmpty(c_name)) {
		alert('이름을 입력하세요.');

		c_name.value = "";
		c_name.focus();

		return false;
	
	}
	if (isEmpty(c_phone)) {
		alert('핸드폰번호를 입력하세요.');

		c_phone.value = "";
		c_phone.focus();

		return false;
	
	}
	
	if (isEmpty(c_birth)) {
		alert('생일을 넣어주세요.');

		c_birth.value = "";
		c_birth.focus();

		return false;
	
	}
	if (isEmpty(c_photo)) {
		alert('파일을 넣어주세요.');

		c_photo.value = "";
		c_photo.focus();

		return false;
	
	}

	
	

	
}



