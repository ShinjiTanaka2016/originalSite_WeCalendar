<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.WeCalendarDAO" %>
<% WeCalendarDAO wcDAO = new WeCalendarDAO(); %>
<%@ include file="/userBeansInclude.jsp" %>
<%@ include file="/groupBeansInclude.jsp" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK rel="stylesheet" type="text/css" href="bootstrap.min.css">
	<LINK rel="stylesheet" type="text/css" href="myGroupCss.css">
	<title>WeCalendar MyGroup</title>
</head>
<body>
	<jsp:include page="/header.jsp"/>

	<div class="alert alert-dismissible alert-info">
	  <strong>MyGroup</strong>　　　now　LoginGroup　is　
	  【<% if(gB.getGroupName().equals("0")){%>nothing<%}else{%><%= groupName %><% } %>】
	</div>

	<div id="menu_box">
	<a href="/WeCalendar/addGroup.jsp" class="btn btn-info"
		style="margin:20px;width:200px;"><b>グループ作成</b></a>
	<a href="/WeCalendar/groupLogin.jsp" class="btn btn-info"
		style="margin:20px;width:200px;"><b>グループログイン・切替</b></a><br>
	<a href="/WeCalendar/myGroupSchedule.jsp" class="btn btn-success"
		style="margin:20px;width:200px;"><b>グループスケジュール管理</b></a>
	<a href="/WeCalendar/myGroupData.jsp" class="btn btn-success"
		style="margin:20px;width:200px;"><b>グループ情報管理</b></a><br>
	<!--
	<a href="/WeCalendar/ToDo.jsp" class="btn btn-warning"
		style="margin:20px;width:200px;"><b>グループメール配信</b></a><br>
	-->
	</div>
	<div id="member_box">
		<%if(gB.getGroupId().equals("0")){}else{ %>
		<table  align="left">
		<tr><th>GroupName</th></tr>
		<tr><td>【　<%= groupName %>　】</td></tr>
		<tr><th>member</th></tr>
		<tr><td><%= wcDAO.displayGroupMember(gB.getGroupId()) %></td></tr>
		</table>
		<% } %>
	</div>

	<div style="clear: both;">
	<jsp:include page="/footer.jsp"/>
	</div>
</body>
</html>