<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.ScheduleBeans" %>
<%
String error = (String)request.getAttribute("msg");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK rel="stylesheet" type="text/css" href="bootstrap.min.css">
	<title>WeCalendar Error</title>
</head>
<body>
	<jsp:include page="/header.jsp"/>

	<div style="color:red;"><b><%= error %></b></div><br><br>

	<jsp:include page="/footer.jsp"/>
</body>
</html>