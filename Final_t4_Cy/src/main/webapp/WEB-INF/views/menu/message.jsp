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
   text-align:center;
   border: 1px solid grey;
   background-color: orange;
   color: white;
   width: 45px;
   height: 25px
}
#button2 {
   border: 1px solid grey;
   background-color: orange;
   color: white;
   width: 45px;
   height: 25px
   }
   
 a:link { color: black; text-decoration: none;}
 a:visited { color: black; text-decoration: none;}

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

function Check(){
	if(!document.insertForm.c_guest_comment.value){
		alert("내용을 입력해 주세요");
		document.insertForm.c_guest_comment.focus();
		return false;
	}
	document.insertForm.submit();
}

function checkDel(){
	var con = confirm('삭제하시겠습니까?');
	if(!con){
		return false;
	}
	else{
		return true;
	}
}

function goSearchId(input){
	var keyword = input;
	location.href="search.go?keyword="+keyword;
}

</script>

<title>Insert title here</title>
</head>
<body>


   <div style="width:100%; height:420px; overflow:auto">
   <form action="msgWrite" name="insertForm" onsubmit="return Check();">
      <table
         style="position: static; left: 280px; top: 80px; background-color: #e4e4e4;">
         <tr>
            <td id="msgName">${sessionScope.loginMember.c_name }</td>
         </tr>
         <tr>
            <td><img src="${sessionScope.loginMember.c_minimi}"
               style="border: 1px solid black; width: 90px; height: 90px"></td>
            <td><textarea id="c_guest_comment" name="c_guest_comment"
                  style="border: 1px solid black; resize: none;"></textarea></td>
         </tr>
         <tr>
            <td>
               <button id="button1" type="submit">확인</button>
            </td>
            <td align="right" style="color:grey; font-size:8pt" id="counter"> (0/200) </td>
         </tr>
      </table>
 <input name="token" value="${token }" type="hidden">
   </form>

 
   <c:forEach var="m" items="${msgs }"> 
 <form name="msgForm" action="msgDelGo">
      <table id="msgTbl">
         <tr>
            <td id="msgName"><a href="search.go?keyword=${m.c_id }">${m.c_name}</a> <input type="hidden" value="${m.c_no }"></td>
            <td id="msgDate" style="text-align: right;"><fmt:formatDate value="${m.c_date }"
                  pattern="yyyy.MM.dd HH:mm" /></td>
         </tr>
         
         <tr>
            <td style="width: 90px"><img src="${m.c_minimi }"
               style="border: 1px solid black; width: 90px; height: 90px"></td>
            <td id="msgGC">${m.c_guest_comment }</td>
         </tr>
         
         <tr>
   <c:forEach var="mm" items="${msgs2 }">
      <c:if test="${m.c_no == mm.c_no }">
         <input type="hidden" value="${mm.c_no }" name="c_no">
      </c:if> 
   </c:forEach>
            <!-- 글쓴이만 수정 버튼 보이게 -->
            <td colspan="2"><c:if test="${m.c_id == sessionScope.loginMember.c_id}">
                  <button id="button1" type="submit" formaction='msg.update.go'>수정</button>
                  <button id="button2" type="submit" formaction="msg.del.go" onsubmit="checkDel();">삭제</button>
               </c:if> 
            </td>
         </tr>
      </table> <!-- onclick="goDel(${m.c_no})" 
                onclick="UpdateGo(${m.c_no})" 
                formaction='msg.update.go' -->
   </form>
   </c:forEach>
   
   
   <form name="search" action="msg.search">
   <table>
   <div id="msgSearch" style="margin-top: 20px;">
   <tr>
   <td> 작성자 </td>
   <td>   <input id="search" >
      <input id="button1" type="button" onclick="goSearch()" value="검색"></td>
      </tr>
   </div>
   </table>
   </form>


   
   <!-- <table>
      <tr>
   <td align="center" style="font-size: 10pt;">
            <c:choose>
               <c:when test="${curPageNo != 1 }"> ◀ </c:when>
               <c:otherwise>
               <a href="MoviePageController?p=${curPageNo -1 }">◀</a>
               </c:otherwise>
            </c:choose>
         </td>
            <td align="center" style="font-size: 10pt;">
            <c:choose>
               <c:when test="${curPageNo == pageCount}"> ▶ </c:when>
               <c:otherwise>
               <a href="MoviePageController?p=${curPageNo +1 }">▶</a>
               </c:otherwise>
            </c:choose>
      </td>
         </tr>
      </table> -->

   </div>
</body>
</html>