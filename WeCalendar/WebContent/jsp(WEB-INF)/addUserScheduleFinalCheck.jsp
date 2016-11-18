<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.ScheduleBeans" %>
<%
ScheduleBeans sb = (ScheduleBeans)request.getAttribute("schedule");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK rel="stylesheet" type="text/css" href="bootstrap.min.css">
	<title>WeCalendar MyPage</title>
</head>
<body>
	<jsp:include page="/header.jsp"/>

	<b>以下の情報で登録しますか？</b><br>
	<table>
	<tr><td>日付</td><td>:<%= sb.getDate() %></td><tr>
	<tr><td>時間</td><td>:<%= sb.getStartTime() %>　～　<%= sb.getEndTime() %></td><tr>
	<tr><td>属性</td><td>:<%= sb.getAttribute() %></td><tr>
	<tr><td>場所</td><td>:<%= sb.getPlace() %></td><tr>
	<tr><td>タイトル</td><td>:<%= sb.getTitle() %></td><tr>
	<tr><td>内容</td><td>:<%= sb.getContent() %></td><tr>
	</table><br>

	<form action="/WeCalendar/AddUserScheduleComplete" method="post">
	<input type="hidden" name="date" value="<%= sb.getDate() %>">
	<input type="hidden" name="starttime" value="<%= sb.getStartTime() %>">
	<input type="hidden" name="endtime" value="<%= sb.getEndTime() %>">
	<input type="hidden" name="attribute" value="<%= sb.getAttribute() %>">
	<input type="hidden" name="place" value="<%= sb.getPlace() %>">
	<input type="hidden" name="title" value="<%= sb.getTitle() %>">
	<input type="hidden" name="content" value="<%= sb.getContent() %>">
	<input type="hidden" name="authority" value="<%= sb.getAuthority() %>">
	<input type="hidden" name="createuser" value="<%= sb.getCreateUser() %>">
	<input type="submit" value="スケジュール登録">
	</form><br>

	<a href="./addUserSchedule.jsp" class="btn btn-primary btn-sm">戻る</a>
	<jsp:include page="/footer.jsp"/>
</body>
</html>