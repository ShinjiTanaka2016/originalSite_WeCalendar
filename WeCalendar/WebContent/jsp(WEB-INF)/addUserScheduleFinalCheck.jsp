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

	以下の情報で登録しますか？
	<table>
	<tr><td></td><td>:<%= sb.getDate() %></td><tr>
	<tr><td></td><td>:<%= sb.getTime() %></td><tr>
	<tr><td></td><td>:<%= sb.getAttribute() %></td><tr>
	<tr><td></td><td>:<%= sb.getPlace() %></td><tr>
	<tr><td></td><td>:<%= sb.getTitle() %></td><tr>
	<tr><td></td><td>:<%= sb.getContent() %></td><tr>
	</table>

	<form action="/WeCalendar/AddUserScheduleComplete" method="post">
	<input type="hidden" name="date" value="<%= sb.getDate() %>">
	<input type="hidden" name="time" value="<%= sb.getTime() %>">
	<input type="hidden" name="attribute" value="<%= sb.getAttribute() %>">
	<input type="hidden" name="place" value="<%= sb.getPlace() %>">
	<input type="hidden" name="title" value="<%= sb.getTitle() %>">
	<input type="hidden" name="content" value="<%= sb.getContent() %>">
	<input type="hidden" name="authority" value="<%= sb.getAuthority() %>">
	<input type="hidden" name="createuser" value="<%= sb.getCreateUser() %>">
	<input type="submit" value="スケジュール登録">
	</form>
	<a href="./addUserSchedule.jsp" class="btn btn-primary btn-sm">戻る</a>
	<jsp:include page="/footer.jsp"/>
</body>
</html>