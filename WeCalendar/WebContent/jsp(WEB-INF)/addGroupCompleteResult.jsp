<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	以下の内容で登録が完了しました。<br><br>
	グループID：<%= groupId %><br>
	グループ名：<%= groupName %><br>
	グループパス：<%= groupPass %><br>
	グループ管理者：<%= groupCreateUser %><br>
	グループメンバー：<%= groupMember %><br><br>
	<jsp:include page="/footer.jsp"/>
</body>
</html>