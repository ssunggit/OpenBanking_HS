<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>

<title>게시물 목록</title>

<script defer>
	function writeForm(){
		location.href='${ pageContext.request.contextPath }/boardWriteForm.do';
	}
	function checkLogin(boardNo) {
		/* el과 jstl중에서는 jstl(백단코드)의 해석이 먼저된다  */
		/* js에서 c:set태그를 실행하려는것은 안된다 */
		<c:choose>
			<c:when test="${ empty userVO }">	
				if(confirm('로그인 후 사용가능합니다\n로그인 페이지로 이동할까요?')){
					location.href = '${ pageContext.request.contextPath }/loginForm.do'
				}
			</c:when>	
			
			<c:otherwise>
				location.href = 'detail.jsp?no=' + boardNo
			</c:otherwise>
		</c:choose>
	}
</script>
</head>
<body>

	<section>
		<div align="center">
		<hr>
		<h2>전체게시글 조회</h2>
		<hr>
		<br>
		<c:forEach items="${ boardList }" var="board" varStatus="loop">
			<a href="${ pageContext.request.contextPath }/detail.do?no=${board.no}">
				<c:out value="${ board.no }"/> 
			</a>
			<a href="${ pageContext.request.contextPath }/detail.do?no=${board.no}">
				<c:out value="${ board.title }"/> 
			</a>	
			
			<!-- 목록에서 내용이 보여줄지는 확인하기 -->
			<c:out value="${ board.content }"/> 
			
			<c:out value="${ board.writer }"/> 
			
			<c:out value="${ board.writingTime }"/> 
			<br>
		</c:forEach>
		
		<c:if test="${ not empty loginVO }">
			<button id="addBtn" onclick="writeForm()">새글등록</button>
		</c:if>
	</div>
	</section>

</body>
</html>