<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.WeCalendarDAO" %>
<% WeCalendarDAO wcDAO = new WeCalendarDAO(); %>
<%@ include file="/userBeansInclude.jsp" %>
<%@ include file="/groupBeansInclude.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK rel="stylesheet" type="text/css" href="bootstrap.min.css">
	<LINK rel="stylesheet" type="text/css" href="myGroupCss.css">
	<title>WeCalendar MyGroup</title>
</head>
<body>
	<jsp:include page="/header.jsp"/>

	<div class="alert alert-dismissible alert-info">
	  <strong>MyGroup</strong>　　　now　LoginGroup　is　
	  【<%= groupName %>】　　グループスケジュール管理
	</div>

	<div id="menu_box">
	<a href="/WeCalendar/addGroupSchedule.jsp" class="btn btn-info"
		style="margin:20px;width:200px;"><b>グループスケジュール登録</b></a>
	<a href="/WeCalendar/groupScheduleDisplay.jsp" class="btn btn-warning"
		style="margin:20px;width:200px;"><b>グループスケジュール一覧</b></a><br>
	<a href="/WeCalendar/updateGroupSchedule.jsp" class="btn btn-success"
		style="margin:20px;width:200px;"><b>グループスケジュール変更</b></a>
	<a href="/WeCalendar/deleteGroupSchedule.jsp" class="btn btn-danger"
		style="margin:20px;width:200px;"><b>グループスケジュール削除</b></a><br>
	</div>

	<div id="member_box">
		<%if(gB.getGroupId().equals("0")){}else{ %>
		<table  align="left">
		<tr><th>GroupName</th></tr>
		<tr><td>【　<%= groupName %>　】</td></tr>
		<tr><th>member</th></tr>
		<tr><td><%= wcDAO.displayGroupMember(gB.getGroupId()) %></td></tr>
		</table>
		<% } %>
	</div>

	<div style="clear: both;">
	<br><a href="./myGroup.jsp" class="btn btn-primary btn-sm">戻る</a><br>
	<jsp:include page="/footer.jsp"/>
	</div>

</body>
</html>