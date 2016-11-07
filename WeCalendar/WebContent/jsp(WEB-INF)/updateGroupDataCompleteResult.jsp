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
	以下の情報で更新しました。<br><br>
	<b>グループID：</b><%= groupId %><br>
	<b>グループ名：</b><%= groupName %><br>
	<b>グループパス:</b><%= groupPass %><br>
	<b>管理者：</b><%= groupCreateUser %><br>

	<jsp:include page="/footer.jsp"/>
</body>
</html>