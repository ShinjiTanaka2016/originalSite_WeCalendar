<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="userBeansInclude.jsp" %>
<%@ include file="groupBeansInclude.jsp" %>
<%@ page import="model.ScheduleBeans" %>
<%@ page import="model.ScheduleDAO" %>
<% ScheduleDAO sDAO = new ScheduleDAO(); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK rel="stylesheet" type="text/css" href="bootstrap.min.css">
	<title>WeCalendar MyGroup</title>
</head>
<body>
	<jsp:include page="/header.jsp"/>

	<table class="table table-striped table-hover ">
		<thead>
			<tr>
				<th>詳細</th>
				<th><b>グループID</b></th>
				<th><b>PlanID</b></th>
				<th><b>日付</b></th>
				<th><b>時間</b></th>
				<th><b>属性</b></th>
				<th><b>場所</b></th>
				<th><b>タイトル</b></th>
				<th><b>作成者</b></th>
			</tr>
		</thead>
		<tbody>
		<% for(ScheduleBeans sb:sDAO.getGroupSchedules(gB.getGroupId())){ %>
			<tr>
				<td>
					<form action="/WeCalendar/GroupsTodayCheck" method="post">
						<input type="hidden" name="planid" value="<%= sb.getPlanId() %>">
						<input type="submit" value="○">
					</form>
				</td>
				<td><%= sb.getCreateGroup() %></td>
				<td><%= sb.getPlanId() %></td>
				<td><%= sb.getDate() %></td>
				<td><%= sb.getStartTime() %>～<%= sb.getEndTime() %></td>
				<td><%= sb.getAttribute() %></td>
				<td><%= sb.getPlace() %></td>
				<td><%= sb.getTitle() %></td>
				<td><%= sb.getCreateUser() %></td>
			</tr>
		<% } %>
		</tbody>
	</table>

	<br><a href="./myGroupSchedule.jsp" class="btn btn-primary btn-sm">戻る</a><br>
	<jsp:include page="/footer.jsp"/>
</body>
</html>