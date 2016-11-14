<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

	更新が完了しました。<br><br>
	<table>
	<tr><td><b>ユーザID</b></td><td>：<%= myId %></td></tr>
	<tr><td><b>名前</b></td><td>：<%= myName %></td></tr>
	<tr><td><b>メール</b></td><td>：<%= myMail %></td></tr>
	</table><br>

	<a href="./myPage.jsp" class="btn btn-primary btn-sm">戻る</a>
	<jsp:include page="/footer.jsp"/>
</body>
</html>