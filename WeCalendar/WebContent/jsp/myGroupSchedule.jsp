<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/userBeansInclude.jsp" %>
<%@ include file="/groupBeansInclude.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK rel="stylesheet" type="text/css" href="bootstrap.min.css">
	<title>WeCalendar MyGroup</title>
</head>
<body>
	<jsp:include page="/header.jsp"/>

	<div class="alert alert-dismissible alert-info">
	  <strong>MyGroup</strong>　　　now　LoginGroup　is　
	  【<%= groupName %>】　　グループスケジュール管理
	</div>

	<a href="/WeCalendar/addGroupSchedule.jsp" class="btn btn-info"
		style="margin:20px;width:200px;"><b>グループスケジュール登録</b></a>
	<a href="/WeCalendar/groupScheduleDisplay.jsp" class="btn btn-warning"
		style="margin:20px;width:200px;"><b>グループスケジュール一覧</b></a><br>
	<a href="/WeCalendar/updateGroupSchedule.jsp" class="btn btn-success"
		style="margin:20px;width:200px;"><b>グループスケジュール変更</b></a>
	<a href="/WeCalendar/deleteGroupSchedule.jsp" class="btn btn-danger"
		style="margin:20px;width:200px;"><b>グループスケジュール削除</b></a><br>

	<br><a href="./myGroup.jsp" class="btn btn-primary btn-sm">戻る</a><br>
	<jsp:include page="/footer.jsp"/>
</body>
</html>