<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="userBeansInclude.jsp" %>
<%@ include file="/groupBeansInclude.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<LINK rel="stylesheet" type="text/css" href="bootstrap.min.css">
	<LINK rel="stylesheet" type="text/css" href="calendarTable.css">
	<title>WeCalendar</title>
</head>

<body>
	<jsp:include page="/header.jsp"/>
	<div class="alert alert-dismissible alert-info">
		<strong>MyCalendar</strong>
	</div>

	<script type="text/javascript"  src="calendarDisplay.js"></script>
	<div id="result"></div>

<jsp:include page="/footer.jsp"/>
</body>
</html>