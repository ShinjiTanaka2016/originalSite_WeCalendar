<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String Msg = (String)request.getAttribute("msg"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK rel="stylesheet" type="text/css" href="bootstrap.min.css">
	<title>WeCalendar</title>
</head>
<body>

	<nav class="navbar navbar-inverse">
		      <div style="color:#fff;font-size:18px;margin:10px;"><b>ログアウト完了</b></div>
	</nav>
	<h1><% if(Msg != null){ %><%= Msg %><% } %>
	<br>ログアウトしました</h1>
	<jsp:include page="/footer.jsp"/>

</body>
</html>