<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/scheduleBeansInclude.jsp" %>
<%@ include file="/userBeansInclude.jsp" %>
<%@ include file="/groupBeansInclude.jsp" %>

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

	<table>
		<tr><td><b>グループID</b></td>		<td>：<%= planId %><br></td></tr>
		<tr><td><b>スケジュールID</b></td>	<td>：<%= planId %><br></td></tr>
		<tr><td><b>日付</b></td>			<td>：<%= planDate %><br></td></tr>
		<tr><td><b>時間</b></td>			<td>：<%= planStartTime %>～<%= planEndTime %><br></td></tr>
		<tr><td><b>属性</b></td>			<td>：<%= planAttribute %><br></td></tr>
		<tr><td><b>場所</b></td>			<td>：<%= planPlace %><br></td></tr>
		<tr><td><b>タイトル</b></td>		<td>：<%= planTitle %><br></td></tr>
		<tr><td><b>内容</b></td>			<td>：<%= planContent %><br></td></tr>
	</table>

	<a href="./myGroupSchedule.jsp" class="btn btn-info" style="margin:20px;"><b>戻る</b></a>
	<jsp:include page="/footer.jsp"/>
</body>
</html>