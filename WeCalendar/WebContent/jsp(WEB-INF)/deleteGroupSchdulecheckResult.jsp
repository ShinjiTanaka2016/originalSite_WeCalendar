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
	<title>WeCalendar MyGroup</title>
</head>
<body>
	<jsp:include page="/header.jsp"/>
	下記のスケジュールを削除します。よろしいですか？<br><br>

	<table>
	<tr><td>GroupID</td><td>:<%= groupId %></td></tr>
	<tr><td>PlanID</td><td>:<%= planId %></td></tr>
	<tr><td>日付</td><td>:<%= planDate %></td></tr>
	<tr><td>時間</td><td>:<%=  planStartTime %>～<%=  planEndTime %></td></tr>
	<tr><td>属性</td><td>:<%=  planAttribute %></td></tr>
	<tr><td>場所</td><td>:<%=  planPlace %></td></tr>
	<tr><td>タイトル</td><td>:<%=  planTitle %></td></tr>
	<tr><td>内容</td><td>:<%=  planContent %></td></tr>
	<tr><td>作成者</td><td>:<%= planCreateUser %></td></tr>
	</table><br>

	<div>
    <form action="/WeCalendar/DeleteGroupScheduleComplete" method="post">
    	<input type="hidden" name="deleteid" value="<%= planId %>">
        <button type="submit" class="btn btn-danger">削除</button>
    </form>
	</div><br>

	<a href="myGroup.jsp" class="btn btn-info" ><b>戻る</b></a><br>
	<jsp:include page="/footer.jsp"/>
</body>
</html>