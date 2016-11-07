<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String errorMsg = (String)request.getAttribute("errormsg"); %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK rel="stylesheet" type="text/css" href="bootstrap.min.css">
	<title>WeCalendar MyPage</title>
</head>
<body>
	<jsp:include page="/header.jsp"/>

	<div style="color:red;"><b><%= errorMsg %></b></div>
	<a href="./UserDataDeletePass.jsp" class="btn btn-info" ><b>戻る</b></a><br>

	<jsp:include page="/footer.jsp"/>
</body>
</html>