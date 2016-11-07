<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/sheduleBeansInclude.jsp" %>
<%@ include file="/userBeansInclude.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK rel="stylesheet" type="text/css" href="bootstrap.min.css">
	<title>WeCalendar MyPage</title>
</head>
<body>
	<jsp:include page="/header.jsp"/>

	<h1>以下の内容で更新しました。</h1>
	<b>スケジュールID：</b><br><%= planId %><br>
	<b>日付：</b><br><%= planDate %><br>
	<b>時間：</b><br><%= planTime %><br>
	<b>属性：</b><br><%= planAttribute %><br>
	<b>場所：</b><br><%= planPlace %><br>
	<b>タイトル：</b><br><%= planTitle %><br>
	<b>内容：</b><br><%= planContent %><br>

	<% session.removeAttribute("plandata"); %>

	<jsp:include page="/footer.jsp"/>
</body>
</html>