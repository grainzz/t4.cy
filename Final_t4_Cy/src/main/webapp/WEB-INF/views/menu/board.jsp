<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
function goGetAllBoard(){
	location.href="board.goGetAll";
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
<script type="text/javascript">
	function boardDetailGo(no){
		var b_no = no;
		location.href='board.showDetail?b_no='+b_no;
	}

</script>
<title>Insert title here</title>
</head>
<body>

<%--
	<h1>
		<a href="board.showAll">게시판 조회</a>
	</h1>

	--%>
${sessionScope.pageInfo.p_name }의 게시판 <%--<button onclick="goGetAllBoard();">전체 게시판 보기</button>--%><p>
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
					<%-- <th scope="col">작성자</th> --%>
					<th scope="col">작성일</th>
					<th scope="col">조회수</th>
				</tr>
			</thead>
			<tbody>
 
			<c:forEach var="b" items="${board }" >
				<tr>
					<td class="num" align="center">${b.b_no }</td>
					<td onclick="boardDetailGo(${b.b_no});">${b.b_title }</td>
					<td class="date" align="center"><fmt:formatDate value="${b.b_date }" pattern="yyyy-MM-dd"/></td>
					<td class="hit" align="center">${b.b_hit }</td>
				</tr>
				</c:forEach>
			</tbody>
	</table>

	<c:if test="${sessionScope.pageInfo.p_id == sessionScope.loginMember.c_id }">
	<a href="board.reg.go?b_writer='${sessionScope.pageInfo.p_id }'"><img src="resources/img/write.jpg"></a>
	</c:if>

</body>
</html>