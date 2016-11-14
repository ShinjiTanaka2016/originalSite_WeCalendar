<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/scheduleBeansInclude.jsp" %>
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

	<h2>以下の内容で更新しました。</h2>
	<table>
	<tr><td><b>スケジュールID</b></td><td>：<%= planId %></td></tr>
	<tr><td><b>日付</b></td><td>：<%= planDate %></td></tr>
	<tr><td><b>時間</b></td><td>：<%= planStartTime %>～<%= planEndTime %></td></tr>
	<tr><td><b>属性</b></td><td>：<%= planAttribute %></td></tr>
	<tr><td><b>場所</b></td><td>：<%= planPlace %></td></tr>
	<tr><td><b>タイトル</b></td><td>：<%= planTitle %></td></tr>
	<tr><td><b>内容</b></td><td>：<%= planContent %></td></tr>
	</table><br>

	<a href="./myPage.jsp" class="btn btn-primary btn-sm">戻る</a>
	<jsp:include page="/footer.jsp"/>
</body>
</html>