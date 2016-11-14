<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/userBeansInclude.jsp" %>
<%@ include file="/groupBeansInclude.jsp" %>
<%@ include file="/scheduleBeansInclude.jsp" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK rel="stylesheet" type="text/css" href="bootstrap.min.css">
	<title>WeCalendar Schedule</title>
</head>
<body>
	<jsp:include page="/header.jsp"/>
	<div class="panel panel-info">
	  <div class="panel-heading">
	  	【日時】<%= planDate %>　<%= planStartTime %>～<%= planEndTime %>　　
	  	【場所】<%= planPlace %>　　【属性】<%= planAttribute %>
	    <h3 class="panel-title"><b><%= planTitle %></b></h3>
	  </div>
	  <div class="panel-body">
	    <%= planContent %>
	  </div>
	</div>

	<a href="userScheduleDisplay.jsp" class="btn btn-info" style="margin:20px;"><b>戻る</b></a>
	<jsp:include page="/footer.jsp"/>
</body>
</html>