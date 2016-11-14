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
	以下のグループ情報でログインしました。<br><br>
	<table>
		<tr><td><b>グループID</b></td>	<td>：<%= groupId %></td></tr>
		<tr><td><b>グループ名</b></td>	<td>：<%= groupName %></td></tr>
		<tr><td><b>管理者</b></td>		<td>：<%= groupAdministrator %></td></tr>
	</table>

	<br><a href="/WeCalendar/myGroup.jsp" class="btn btn-primary btn-sm">戻る</a><br>
	<jsp:include page="/footer.jsp"/>
</body>
</html>