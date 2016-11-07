<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="userBeansInclude.jsp" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK rel="stylesheet" type="text/css" href="bootstrap.min.css">
	<title>WeCalendar UserDelete</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
	IDを削除するとそのIDでログインできなくなりますがよろしいですか？<br>

	<a href="UserDataDeletePass.jsp" class="btn btn-danger" style="margin:20px;"><b>はい</b></a><br>
	<a href="myPage.jsp" class="btn btn-info" style="margin:20px;"><b>戻る</b></a>

	<jsp:include page="/footer.jsp"/>
</body>
</html>