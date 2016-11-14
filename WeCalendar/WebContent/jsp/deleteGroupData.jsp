<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/userBeansInclude.jsp" %>
<%@ include file="/groupBeansInclude.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK rel="stylesheet" type="text/css" href="bootstrap.min.css">
	<title>WeCalendar MyGroup</title>
</head>

<body>
	<jsp:include page="/header.jsp"/>
	<% if(gB.getGroupId().equals("0")){ %>
		<b style="color:red;">現在ログイン中のグループはありません。</b><br>
	<% }else if(!gB.getAdministrator().equals(lUB.getUserId())){ %>
		<b style="color:red;">グループ情報削除の権限がありません。</b><br>
	<% }else{ %>
		<div Style="color:red;font-size:16px;"><b>
		グループIDを削除すると該当IDのグループ機能は失われ,グループスケジュールは全て削除されます。<br>
		よろしいですか？</b><br>
		</div>
		<a href="deleteGroupDataPass.jsp" class="btn btn-danger" style="margin:20px;"><b>はい</b></a><br>
	<% } %>
	<a href="myGroupData.jsp" class="btn btn-info" style="margin:20px;"><b>戻る</b></a>
	<jsp:include page="/footer.jsp"/>
</body>
</html>