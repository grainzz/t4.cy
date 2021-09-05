<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
textarea {
	width: 300px;
	height: 90px;
}

#msgName {
	font-size: 10pt;
	font-weight: bold;
}

#msgGC {
	font-size: 11pt;
	font-weight: 400;
}

#msgDate {
	font-size: 7pt;
	color: grey;
}

#msgTbl {
	left: 280px;
	top: 250px;
	width: 405px;
	background-color: white;
	border: 1px solid grey;
}

#button1 {
	border: 1px solid grey;
	background-color: orange;
	color: white;
	width: 45px;
	height: 25px
}
</style>
<script type="text/javascript" src="resources/js/go.js"></script>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript">
$(function(){
	
$('#c_guest_comment').on('keyup', function() {
    $('#counter').html("("+$(this).val().length+" / 200)");
    if($(this).val().length > 200) {
        $(this).val($(this).val().substring(0, 200));
        $('#counter').html("(200 / 200)");
    }
});

});
function getnewc() {
	let a= $("#c_guest_comment").val();
return a;
}

function updateDo(a, c){
	   if(confirm('수정 하시겠습니까?')){
	      location.href="msg.update.do?c_no=" + a + "&c_guest_comment=" + c;
	   }
	}
</script>
<title>Insert title here</title>
</head>
<body>

<div style="width:100%; height:420px; overflow:auto">


 <input type="hidden" name="c_no" value="${param.c_no }"/>
		<table id="msgTbl">
			<tr>
				<td id="msgName">${sessionScope.loginMember.c_name}</td>
				
				<td id="msgDate"><fmt:formatDate value="${msg.c_date}"
						pattern="yyyy.MM.dd HH:mm" /></td>
			</tr>
			<tr>
				<td><img src="${sessionScope.loginMember.c_minimi}"
					style="border: 1px solid black; width: 90px; height: 90px"></td>
				<td id="msgGC">
				<textarea id="c_guest_comment" name="c_guest_comment" style="border: 1px solid black;">${msg.c_guest_comment }</textarea> </td>
			</tr>
			<tr>
			<td>
			<button id="button1" type="submit" onclick="updateDo('${param.c_no}', getnewc())">완료</button>
			</td>
			<td align="right" style="color:grey; font-size:8pt" id="counter"> (0/200) </td>
			</tr>
		</table>
</div>
	
</body>
</html>