<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기안서</title>
</head>
<body>
	<jsp:include page="appMenu.jsp"></jsp:include> <!-- 메뉴 + 소메뉴 -->
	<div class="s-container">
		<h1>기안서</h1>
		<form id="form" action="/approval/draftDocWrite.sw" method="post" enctype="multipart/form-data" onsubmit="return nullChk()">
			<table border="1">
				<tr>
					<td>문서번호</td>
					<td></td>
					<td rowspan="3" style="writing-mode: vertical-rl;">결재</td>
					<td>담당</td>
					<td id="d-app0"></td>
					<td id="d-app1"></td>
					<td id="d-app2"></td>
				</tr>
				<tr>
					<td>기안일</td>
					<td>${nowTime }<input type="hidden" value="${nowTime }" name="docDate" readonly></td>
					<td></td>
					<td align="center"><button type="button" onclick="appBtn('app');">선택</button></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>기안자</td>
					<td>${loginUser.memberName }<input type="hidden" value="${loginUser.memberNum }" name="memNum" readonly></td>
					<td>${loginUser.memberName }</td>
					<td id="name-app0"></td><input type="hidden" id="num-app" name="appMemNum" readonly>
					<td id="name-app1"></td>
					<td id="name-app2"></td>
				</tr>
				<tr>
					<td>참조자</td>
					<td colspan="5" id="ref-list"></td><input type="hidden" id="num-ref" name="refMemNum" readonly>
					<td><button id="app-btn" type="button" onclick="appBtn('ref');">선택</button></td>
				</tr>
				<tr>
					<td>제목</td>
					<td colspan="6"><input type="text" name="docTitle" id="title"></td>
				</tr>
				<tr>
					<td colspan="7" align="center">내용</td>
				</tr>
				<tr>
					<td colspan="7" align="center"><textarea cols="50" rows="10" name="docContent" id="content"></textarea></td>
				</tr>
			</table>
			<p>파일 첨부
			<input type="file" name="uploadFile">
			<br>
			<input type="submit" value="결재 요청">
			<input type="button" value="임시 저장">
			<input type="button" value="취소">
		</form>
	</div>
	<jsp:include page="appModal.jsp"></jsp:include> <!-- 결재자 선택 모달 -->
	<script>
		function nullChk() {
			if($("#title").val() == "") {
				alert("제목을 입력해주세요.");
				$("#title").focus();
				return false;
			}else if($("#content").val() == "") {
				alert("내용을 입력해주세요.");
				$("#content").focus();
				return false;
			}else if($("#num-app").val() == "") {
				alert("결재자를 선택해주세요.");
				return false;
			}
		}
	</script>
</body>
</html>