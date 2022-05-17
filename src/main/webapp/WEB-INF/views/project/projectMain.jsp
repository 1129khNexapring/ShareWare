<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@3.5.1/dist/chart.min.js"></script>
<title>프로젝트 메인 화면 </title>
<link href="/resources/css/approval/appList-style.css" rel="stylesheet">
</head>
<body>
<jsp:include page="projectMainMenu.jsp"></jsp:include>
		<div class="s-container">
		<br><br>
		<div class="border">
		<div>
		<span>중요공지</span><button onclick="location.href='/project/importantList.sw?projectNo=${projectNo}'">더보기</button>
		<table>
			<thead>
				<tr>
					<th>제목</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${iList }" var="important" varStatus="status">
				<tr>
					<c:url var="iDetail" value="/project/importantDetail.sw">
						<c:param name="importantNo" value="${important.importantNo }"></c:param>
						<c:param name="projectNo" value="${projectNo }"></c:param>
					</c:url>
					<td><a href="${iDetail }">${important.importantTitle }</a></td>
					<td>${important.importantDate }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		</div>
		<br><br>
		<span>업무현황</span><button onclick="location.href='/project/workList.sw?projectNo=${projectNo}'">더보기</button>
		<div>
			<table>
		<thead>
			<tr>
				<th>제목</th>
				<th>작성일</th>
				<th>작성자</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${wList }" var="work" varStatus="status">
				<tr>
					<c:url var="wDetail" value="/project/workDetail.sw">
						<c:param name="workNo" value="${work.workNo }"></c:param>
						<c:param name="projectNo" value="${projectNo }"></c:param>
					</c:url>
					<td><a href="${wDetail }">${work.workTitle }</a></td>
					<td>${work.workDate }</td>
					<td>${work.workWriter }</td>
				</tr>
			</c:forEach>
			</tbody>
	</table>
		</div>
		</div>
		<div>
		<button onclick="chart()">입력</button>
		<table>
			<tr>
				<c:forEach items="${cList }" var="workChart">
					<td>${workChart.wpRate }%</td>
				</c:forEach>
			</tr>
			<tr>
				<c:forEach items="${cList }" var="workChart">
					<td>${workChart.projectWriter }</td>
				</c:forEach>
			</tr>
		</table>
		</div>
		<div>
			<span>구성원</span>
			<div>
				<div>프로젝트 관리자 ${project.projectMade }</div>
				<c:forEach items="${pList }" var="participant">
					<div>${participant.division } ${participant.memberName } ${participant.rank }</div>
				</c:forEach>
			</div>
			<canvas id="Chart" width="400" height="400"></canvas>
		</div>
	</div>
		
<script>
// 'Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'
		var chartArea = document.getElementById('Chart').getContext('2d');
		var myChart = new Chart(chartArea, {
		  type: 'bar',
		  data: {
		      labels: [<c:forEach items="${cList }" var="workChart">'${workChart.projectWriter }',</c:forEach>],
		      datasets: [{
		          label: '진행현황',
		          data: [<c:forEach items="${cList }" var="workChart">${workChart.wpRate },</c:forEach>],
		          backgroundColor: 'rgba(117, 144, 194, 0.38)',
		          borderColor: 'rgb(47, 71, 117)',
		          borderWidth: 1
		      }]
		  },
		  options: {
		      scales: {
		          y: {
		        	  suggestedMax: 100,
		              beginAtZero: true
		          }
		      }
		  }
		});
	
	function chart(){
		var chart=prompt("업무진행률을 입력하세요.(%)")
		var projectNo = "${projectNo }";
		var memNum = "${loginUser.memberNum }";
		var projectWriter = "${loginUser.memberName }";
		if(chart != null) {
			location.href = '/project/workChart.sw?projectNo=' + projectNo + '&memNum=' + memNum + '&projectWriter=' + projectWriter + '&wpRate=' + chart;
		}
		
	}
</script>
</body>
</html>