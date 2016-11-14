<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="userBeansInclude.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK rel="stylesheet" type="text/css" href="bootstrap.min.css">
	<title>WeCalendar MyPage</title>
</head>

<body>
	<jsp:include page="/header.jsp"/>
	<div class="alert alert-dismissible alert-info">
	  <strong>MyPage</strong>
	</div>

	<a href="/WeCalendar/addUserSchedule.jsp" class="btn btn-info"
		style="margin:20px;width:200px;"><b>スケジュール登録</b></a>
	<a href="/WeCalendar/userScheduleDisplay.jsp" class="btn btn-info"
		style="margin:20px;width:200px;"><b>スケジュール一覧</b></a><br>	<!-- ToDo -->
	<a href="/WeCalendar/updateUserSchedule.jsp" class="btn btn-success"
		style="margin:20px;width:200px;"><b>スケジュール変更</b></a>
	<a href="/WeCalendar/userDataUpdate.jsp" class="btn btn-success"
		style="margin:20px;width:200px;"><b>ユーザ情報変更</b></a><br>
	<a href="/WeCalendar/deleteUserSchedule.jsp" class="btn btn-warning"
		style="margin:20px;width:200px;"><b>スケジュール削除</b></a>
	<a href="/WeCalendar/userDataDelete.jsp" class="btn btn-danger"
		style="margin:20px;width:200px;"><b>IDの削除</b></a><br>

	<jsp:include page="/footer.jsp"/>
</body>
</html>