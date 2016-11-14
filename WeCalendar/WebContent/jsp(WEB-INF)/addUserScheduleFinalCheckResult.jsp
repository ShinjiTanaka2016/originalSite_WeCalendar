<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/userBeansInclude.jsp" %>
<%@ include file="/scheduleBeansInclude.jsp" %>
<%@ page import="model.WeCalendarDAO" %>
<%
WeCalendarDAO wcDAO = new WeCalendarDAO();

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK rel="stylesheet" type="text/css" href="bootstrap.min.css">
	<title>WeCalendar UserSchedule</title>
</head>
<body>
	<jsp:include page="/header.jsp"/>
	<h1>スケジュールを登録しました。</h1>

	<table>
	<tr><td>日付</td><td>:<%= planDate %></td><tr>
	<tr><td>時間</td><td>:<%= planStartTime %>　～　<%= planEndTime %></td><tr>
	<tr><td>属性</td><td>:<%= planAttribute %></td><tr>
	<tr><td>場所</td><td>:<%= planPlace %></td><tr>
	<tr><td>タイトル</td><td>:<%= planTitle %></td><tr>
	<tr><td>内容</td><td>:<%= planContent %></td><tr>
	</table>

	<a href="./myPage.jsp" class="btn btn-primary btn-sm">戻る</a>
	<jsp:include page="/footer.jsp"/>
</body>
</html>