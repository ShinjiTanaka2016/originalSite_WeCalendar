<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.addUserBeans" %>
<% addUserBeans aub = (addUserBeans)request.getAttribute("aub"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK rel="stylesheet" type="text/css" href="bootstrap.min.css">
	<title>WeCalendar</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div style="color:#fff;font-size:18px;margin:10px;"><b>登録確認</b></div>
	</nav>
	以下で登録します。<br>
	<table>
	<tr><td>UserID</td>		<td>:<%= aub.getUserId() %></td></tr>
	<tr><td>UserName</td>	<td>:<%= aub.getUserName() %></td></tr>
	<tr><td>UserMail</td>	<td>:<%= aub.getUserMail() %></td></tr>
	<tr><td>UserPass</td>	<td>:<%= aub.getUserPass() %></td></tr>
	</table>

	<form action="/WeCalendar/AddUserComplete" method="post">
		<input type="hidden" name="userid" value="<%= aub.getUserId() %>">
		<input type="hidden" name="username" value="<%= aub.getUserName() %>">
		<input type="hidden" name="usermail" value="<%= aub.getUserMail() %>">
		<input type="hidden" name="userpass" value="<%= aub.getUserPass() %>">
		<input type="submit" value="登録">
	</form><br>
	<a href="/WeCalendar/addID.jsp" class="btn btn-primary btn-sm">戻る</a>
<!-- <jsp:include page="/footer.jsp"/> -->
	<hr>
	<a href="/WeCalendar/top.jsp" class="btn btn-primary btn-sm">TOPへ</a><br><br>

</body>
</html>