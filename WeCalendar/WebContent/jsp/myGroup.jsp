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

	<a href="/WeCalendar/addGroup.jsp" class="btn btn-info"
		style="margin:20px;width:200px;"><b>グループ作成</b></a>
	<a href="/WeCalendar/updateGroupMember.jsp" class="btn btn-info"
		style="margin:20px;width:200px;"><b>グループメンバ追加</b></a>
	<a href="/WeCalendar/groupLogin.jsp" class="btn btn-info"
		style="margin:20px;width:200px;"><b>グループログイン・切替</b></a><br>
	<a href="/WeCalendar/addGroupSchedule.jsp" class="btn btn-info"
		style="margin:20px;width:200px;"><b>グループスケジュール登録</b></a>
	<a href="/WeCalendar/updateGroupData.jsp" class="btn btn-success"
		style="margin:20px;width:200px;"><b>グループ情報変更</b></a><br>
	<a href="/WeCalendar/updateGroupSchedule.jsp" class="btn btn-success"
		style="margin:20px;width:200px;"><b>グループスケジュール変更</b></a>
	<a href="/WeCalendar/sendGroupMail.jsp" class="btn btn-default"
		style="margin:20px;width:200px;"><b>グループメール配信</b></a><br>
	<a href="/WeCalendar/deleteGroupSchedule.jsp" class="btn btn-warning"
		style="margin:20px;width:200px;"><b>グループスケジュール削除</b></a>
	<a href="/WeCalendar/deleteGroupID.jsp" class="btn btn-danger"
		style="margin:20px;width:200px;"><b>グループIDの削除</b></a><br>

	<jsp:include page="/footer.jsp"/>
</body>
</html>