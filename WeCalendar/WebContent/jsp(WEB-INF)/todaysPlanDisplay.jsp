<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/userBeansInclude.jsp" %>
<%@ include file="/groupBeansInclude.jsp" %>
<%@ page import="model.ScheduleBeans" %>
<%@ page import="model.ScheduleDAO" %>
<% String today = (String) session.getAttribute("today"); %>
<% ScheduleDAO sDAO = new ScheduleDAO(); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK rel="stylesheet" type="text/css" href="bootstrap.min.css">
	<title>WeCalendar MyPage</title>
</head>
<body>
	<jsp:include page="/header.jsp"/></div>

	<h1><%= today %>　Schedule</h1>
	<table class="table table-striped table-hover ">
		<thead>
			<tr>
				<th>詳細</th>
				<th>ID</th>
				<th>予定</th>
				<th>時間</th>
				<th>権限</th>
			</tr>
		</thead>
		<tbody>
		<% for(ScheduleBeans sb01:sDAO.getTodaySchedules(today,lUB.getUserId())){ %>
			<tr>
				<td width="60px"><form action="/WeCalendar/TodayScheduleCheck" method="post">
						<input type="hidden" name="planid" value="<%= sb01.getPlanId() %>">
						<input type="submit" value="○">
					</form></td>
				<td width="80px"><%= sb01.getPlanId() %></td>
				<td width="200px"><%= sb01.getTitle() %></td>
				<td><% if(sb01.getStartTime()!=null){ %><%= sb01.getStartTime() %>
					<% }if(sb01.getEndTime()!=null){ %>～<%= sb01.getEndTime() %><% } %></td>
				<td width="80px"><%= sb01.getAuthority() %></td>
			</tr>
		<% } %>
		<% if(!gB.getGroupId().equals("0")){ %>
		<% for(ScheduleBeans sb01:sDAO.getTodaySchedulesGroup(today,gB.getGroupId())){ %>
			<tr>
				<td width="40px"><form action="/WeCalendar/TodayScheduleCheck" method="post">
						<input type="hidden" name="planid" value="<%= sb01.getPlanId() %>">
						<input type="submit" value="○">
					</form></td>
				<td width="80px"><%= sb01.getPlanId() %></td>
				<td width="200px"><%= sb01.getTitle() %></td>
				<td><% if(sb01.getStartTime()!=null){ %><%= sb01.getStartTime() %>
					<% }if(sb01.getEndTime()!=null){ %>～<%= sb01.getEndTime() %><% } %></td>
				<td width="80px"><%= sb01.getAuthority() %></td>
			</tr>
		<% } %>
		<% } %>
		</tbody>
	</table>

	<a href="Calendar.jsp" class="btn btn-info" style="margin:20px;"><b>戻る</b></a>
	<jsp:include page="/footer.jsp"/>
</body>
</html>