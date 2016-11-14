<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.WeCalendarDAO" %>
<% WeCalendarDAO wcDAO = new WeCalendarDAO(); %>
<% String msg = (String)request.getAttribute("msg"); %>
<%@ include file="/userBeansInclude.jsp" %>
<%@ include file="/groupBeansInclude.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK rel="stylesheet" type="text/css" href="bootstrap.min.css">
	<title>WeCalendar GroupPage</title>
</head>
<body>
	<jsp:include page="/header.jsp"/>

	<%= msg %><br>
	<b>以下の内容で登録が完了しました。(重複IDは登録をキャンセルします。)</b><br><br>
	<table class="table table-striped table-hover ">
	<tr><td width="130px"><b>グループID</p></td>			<td><%= groupId %></td></tr>
	<tr><td><b>グループ名</b></td>			<td><%= groupName %></td></tr>
	<tr><td><b>グループパス</b></td>		<td><%= groupPass %></td></tr>
	<tr><td><b>グループ管理者</b></td>		<td><%= groupAdministrator %></td></tr>
	<tr><td align="left" valign="top"><b>グループメンバー</b></td>
		<td><%= wcDAO.displayGroupMember(gB.getGroupId()) %></td></tr>
	</table>

	<jsp:include page="/footer.jsp"/>
</body>
</html>