<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="userBeansInclude.jsp" %>
<%@ page import="model.ScheduleBeans" %>
<%@ page import="model.ScheduleDAO" %>
<% ScheduleDAO sDAO = new ScheduleDAO(); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK rel="stylesheet" type="text/css" href="bootstrap.min.css">
	<title>WeCalendar MyPage</title>
</head>
<body>
	<jsp:include page="/header.jsp"/>

	<table class="table table-striped table-hover ">
		<thead>
			<tr>
				<th>詳細</th>
				<th>PlanID</th>
				<th>日時</th>
				<th>属性</th>
				<th>場所</th>
				<th>タイトル</th>
			</tr>
		</thead>
		<tbody>
		<% for(ScheduleBeans sb:sDAO.getUserSchedules(lUB.getUserId())){ %>
			<tr>
				<td>
					<form action="/WeCalendar/UsersTodayCheck" method="post">
						<input type="hidden" name="planid" value="<%= sb.getPlanId() %>">
						<input type="submit" value="○">
					</form>
				</td>
				<td><%= sb.getPlanId() %></td>
				<td><%= sb.getDate() %>　
				<%if(sb.getStartTime()==null){}else{%><%= sb.getStartTime() %>～<% } %>
				<%if(sb.getEndTime()==null){}else{%><%= sb.getEndTime() %><% } %></td>
				<td><%= sb.getAttribute() %></td>
				<td><%if(sb.getPlace()==null){}else{%><%= sb.getPlace() %><% } %></td>
				<td><%= sb.getTitle() %></td>
			</tr>
		<% } %>
		</tbody>
	</table>

	<a href="myPage.jsp" class="btn btn-info" style="margin:20px;"><b>戻る</b></a>
	<jsp:include page="/footer.jsp"/>
</body>
</html>