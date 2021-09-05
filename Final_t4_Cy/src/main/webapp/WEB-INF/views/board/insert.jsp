<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript">
$(function(){
   
$('#content').on('keyup', function() {
    $('#counter').html("("+$(this).val().length+" / 600)");
    if($(this).val().length > 200) {
        $(this).val($(this).val().substring(0, 600));
        $('#counter').html("(600 / 600)");
    }
});

});

function boardCheck(){
	if (!document.insertForm.title.value){
		alert("제목을 입력해 주세요.");
		document.insertForm.title.focus();
		return false;
	}
	if (!document.insertForm.content.value) {
		alert("내용을 입력해 주세요.");
		document.insertForm.content.focus();
		return false;
	}
	document.insertForm.submit();
}

</script>
</head>
<body>

<form name="insertForm" action="board.reg.do" onsubmit="return boardCheck();">
<table>
<tr>
	<td>제목</td>
	<td><input id="title" name="b_title" style="width: 300px; height: 30px;"></td>
</tr>
<tr>
	<td>내용</td>
	<td><textarea id="content" name="b_content" style="width: 300px; height: 200px; resize:none"></textarea>
	</td>
</tr>
<tr>
	<td></td>
	<td align="right" style="color:grey; font-size:8pt" id="counter"> (0/600) </td>
</tr>
</table>
<input name="b_writer" value="${sessionScope.pageInfo.p_id }" type="hidden">
<button id="bannerBtn2">등록</button>
</form>

</body>
</html>