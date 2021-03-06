<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 메인 소메뉴</title>
</head>
<body>
	<jsp:include page="../common/menuBar.jsp"></jsp:include>
	<div class="s-menu">
		<div class="s-menu-title">
			<p>프로젝트 관리
			<i class="fa-solid fa-folder-open"></i>
		</div>
		<div class="s-list-item ${listCondition eq 'projectMain' ? 'active' : ''}"><a href="/project/main.sw?projectNo=${projectNo }">프로젝트 메인</a></div>
		<div class="s-list-item ${listCondition eq 'projectDetail' ? 'active' : ''}"><a href="/project/detail.sw?projectNo=${projectNo }">프로젝트 정보</a></div>
		<div class="s-list-item ${listCondition eq 'projectWork' ? 'active' : ''}"><a href="/project/workList.sw?projectNo=${projectNo }">진행현황</a></div>
		<div class="s-list-item ${listCondition eq 'projectImportant' ? 'active' : ''}"><a href="/project/importantList.sw?projectNo=${projectNo }">중요공지</a></div>
	</div>
</body>
</html>