<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
	Date nowTime = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("a hh:mm:ss");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>





<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>근태관리</title>

	<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
	<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
	


</head>
<body>

	<%= sf.format(nowTime) %><br>
	
	$("#datepicker").datepicker({
	
	});
	
	
	<form action="/attendance/registerAtt.sw" method="post">
		<div id="">
			<input type="submit" id="button1" value="출근">
		</div> <br>
	</form>
	<form action="/attendance/modifyAtt.sw" method="post">
		<div id="">
			<input type="submit" id="button2" value="퇴근">
		</div> <br>
	</form>		
	
	<!-- 검색일<input type="text" id="searchDate">  -->
	<form action="/attendance/searchDate.sw" method="post">
    	<div>
	      <input type="date" value="Sysdate">
	      <input type="submit" value="검색">
    	</div>
    
    	<br>
    	<div>
			<table border="1">
				<tr><th>통계</th></tr>
				<tr>
					<td>지각</td>
					<td>조퇴</td>
					<td>출근</td>
				</tr>
			</table>
		</div>
    </form>
  	<br>
		
		<div>
			<table border="1">
				<tr>
					<th>날짜</th>
					<th>출근시간</th>
					<th>퇴근시간</th>
					<th>근무시간</th>
					<th>근무상태</th>
				</tr>
				<c:forEach items="${aList }" var="attendance">
				<tr>
					<td>${attendance.attDate }</td>
					<td>${attendance.attStrTime }</td>
					<td>${attendance.attFinTime }</td>
					<td>${attendance.attTotalTime }</td>
					<td>${attendance.attStatus }</td>
				</tr>
				</c:forEach>
				
			</table>
		</div>

	
</body>
</html>