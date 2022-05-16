<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShareWare</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<link href="/resources/css/home-style.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="./common/menuBar.jsp"></jsp:include>
	<div class="container">
		<div class="c-left">
			<div class="myInfo box">
				<span class="c-title">내 정보</span>
				<img src="../resources/profile/kwonjihye.png" onclick="location.href='/member/myInfo.sw'">
				<div style="font-size:18px;">${loginUser.memberName } ${loginUser.rank }</div>
				<div style="color: rgba(90, 90, 90); font-size:16px">${loginUser.division }</div>
				<div class="info-list">
					<a href="/approval/appListView.sw?docStatus=대기">결재 대기 문서<span>${appCount }건</span></a>	
					<a href="/approval/draftListView.sw?docStatus=진행">결재 진행 문서<span>${draftCount }건</span></a>				
					<a href="/approval/appListView.sw?docStatus=예정">결재 예정 문서<span>${expCount }건</span></a>				
				</div>
			</div>
			<div class="attendance box">
				<span class="c-title">근태 관리</span>
				<div class="att-time">
					<div>
						출근 시간<span id="att-str"></span>
					</div>
					<div>
						퇴근 시간<span id="att-fin"></span>
					</div>
				</div>
				<div class="att-btn">
					<button id="attStr-btn">출근</button>
					<button id="attFin-btn">퇴근</button>
				</div>
			</div>
		</div>
		<div class="c-center">
			<div class="calendar box-t">
			</div>
			<div class="calendar-detail box-t">
			</div>
		</div>
		<div class="c-right">
			<div class="notice box">
				<span class="c-title">공지사항</span>
			</div>
			<div class="project box">
				<span class="c-title">프로젝트 관리</span>
			</div>
		</div>
	</div>
</body>
<script>
	$(document).ready(function() {
		attTime();
	})
	
	// 근태 관리 시간 조회
	function attTime() {
		$.ajax({
			url : "/attendance/workTime.sw",
			type : "get",
			data : { "memberNum" : "${loginUser.memberNum}"},
			success : function(attendance) {
				if(attendance.attStrTime != null){
					$("#att-str").text(attendance.attStrTime);
				}else {
					$("#att-str").text("00:00:00");
				}
				if(attendance.attFinTime != null){
					$("#att-fin").text(attendance.attFinTime);
				}else {
					$("#att-fin").text("00:00:00");
				}
			},
			error : function() {
				alert("출근 등록 실패");
			}
		})
	}
	
	// 출근
	$("#attStr-btn").click(function(){
		$.ajax({
			url : "/attendance/workStart.sw",
			type : "get",
			data : { "memberNum" : "${loginUser.memberNum}"},
			success : function(result) {
				attTime();
			},
			error : function() {
				alert("출근 등록 실패");
			}
		})
	});
	
	// 퇴근
	$("#attFin-btn").click(function(){
		$.ajax({
			url : "/attendance/workEnd.sw",
			type : "get",
			data : { "memberNum" : "${loginUser.memberNum}"},
			success : function(result) {
				attTime();
			},
			error : function() {
				alert("퇴근 등록 실패");
			}
		})
	});
</script>
</html>
