<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="paging"> <!-- 일반 리스트 페이징 -->
		<c:if test="${search.memberNum == null }"> <!-- 검색 하지 않았으면 -->
				<c:if test="${pi.prev == true}">
					<a href='<c:url value="/meetionRoom/roomResevationList.sw?page=${pi.startNavi-1 }"/>'><button class="page-btn">＜</button></a>
				</c:if>
				<c:forEach var="p" begin="${pi.startNavi }" end="${pi.endNavi }">
					<c:url var="pagination" value="/meetionRoom/roomResevationList.sw">
						<c:param name="page" value="${p }"></c:param>
					</c:url>
					<a href="${pagination }"><button class="page-btn ${p eq currentPage ? 'active' : '' }">${p }</button></a>&nbsp;								
				</c:forEach>
				<c:if test="${pi.next == true && pi.endNavi > 0}">
					<a href='<c:url value="/meetionRoom/roomResevationList.sw?page=${pi.endNavi+1 }"/>'><button class="page-btn">＞</button></a>
				</c:if>
		</c:if>
	</div>	
</body>
</html>