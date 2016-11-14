<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String errorMsg = (String)request.getAttribute("errormsg"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK rel="stylesheet" type="text/css" href="bootstrap.min.css">
	<title>WeCalendar(Error)</title>
</head>

<body>
	<nav class="navbar navbar-inverse">
		      <div style="color:#fff;font-size:18px;margin:10px;"><b>エラー</b></div>
	</nav>
	<div style="color:red;"><b><%= errorMsg %></b></div>
	<a href="/WeCalendar/login.jsp" class="btn btn-primary btn-sm">戻る</a>
<!-- <jsp:include page="/footer.jsp"/> -->
<hr>
<a href="/WeCalendar/top.jsp" class="btn btn-primary btn-sm">TOPへ</a><br><br>
</body>
</html>