<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="userBeansInclude.jsp" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK rel="stylesheet" type="text/css" href="bootstrap.min.css">
	<title>WeCalendar Logout</title>
</head>
<body>
	<jsp:include page="/header.jsp"/>
	ログインＩＤ：<%= myId %><br>
	<%= myName %>さん　　ログアウトしますか？<br>
	<a href="/WeCalendar/LogOutUser" class="btn btn-info" style="margin:20px;">はい</a>
	<a href="myPage.jsp" class="btn btn-success" style="margin:20px;">いいえ</a>
	<jsp:include page="/footer.jsp"/>
</body>
</html>