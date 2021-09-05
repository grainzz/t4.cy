<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
function modBoardGo(n){
	var b_no = n;
	location.href="board.modify?b_no="+b_no;
}

function delBoardGo(n){
	var b_no = n;
	var con = confirm('정말 삭제하시겠습니까?');
	if(con){
	location.href = "board.del.do?b_no="+b_no;
		
	}
}
</script>
<style type="text/css">

.sub_news {
	border: 0
}

.sub_news a {
	color: #383838;
	text-decoration: none;
}

.sub_news {
	width: 450px;
	border-bottom: 1px solid #999;
	color: #666;
	font-size: 12px;
	table-layout: fixed;
}

.sub_news caption {
	display: none;
}

.sub_news th {
	padding: 5px 0 6px;
	border-top: solid 1px #999;
	border-bottom: solid 1px #b2b2b2;
	background-color: #f1f1f4;
	color: #333;
	font-weight: bold;
	line-height: 20px;
	vertical-align: top;
}
</style>

<title>Insert title here</title>
</head>
<body>
<button style="border: 1px solid grey; background-color: orange; color: white; height: 25px;" onclick="boardGo();">목록으로</button>
<p>
	 <table class="sub_news">
		<caption>
			<colgroup>
				<col>
				<col width="250">
				<col width="100">
				<col width="50">
			</colgroup>
			<thead>
				<tr>
					<th scope="col">번호</th>
					<th scope="col">제목</th>
					<th scope="col">날짜</th>
					<th scope="col">조회수</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td align="center">${bb.b_no }</td>
					<td>${bb.b_title}</td>
					<td align="center"><fmt:formatDate value="${bb.b_date }" pattern="yyyy-MM-dd"/></td>
					<td align="center">${bb.b_hit }</td>
				</tr>
				<tr><td colspan="4"><hr><p></td></tr>
				<tr>
					<td colspan="4">${bb.b_content }</td>
				</tr>
				<tr><td colspan="4"><p></td></tr>
			</tbody>
	</table>
	<p>

	<c:if test="${sessionScope.pageInfo.p_id == sessionScope.loginMember.c_id }">
	<button style="border: 1px solid grey; background-color: orange; color: white; height: 25px;" onclick="modBoardGo(${bb.b_no});">수정</button>
	<button style="border: 1px solid grey; background-color: orange; color: white; height: 25px;" onclick="delBoardGo(${bb.b_no});">삭제</button>
	</c:if>



</body>
</html>