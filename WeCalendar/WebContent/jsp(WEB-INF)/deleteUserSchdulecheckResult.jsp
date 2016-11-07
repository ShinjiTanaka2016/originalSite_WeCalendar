<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/sheduleBeansInclude.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK rel="stylesheet" type="text/css" href="bootstrap.min.css">
	<title>WeCalendar MyPage</title>
</head>
<body>
	<jsp:include page="/header.jsp"/>

	以下のスケジュールを削除します。<br><br>
	<b>ID:</b><br>
	<%= planId %><br>
	<b>日付:</b><br>
	<%= planDate %><br>
	<b>時間:</b><br>
	<%= planTime %><br>
	<b>属性:</b><br>
	<%= planAttribute %><br>
	<b>場所:</b><br>
	<%= planPlace %><br>
	<b>タイトル:</b><br>
	<%= planTitle %><br>
	<b>内容:</b><br>
	<%= planContent %><br>


	よろしいですか？
	<div class="container">
    <form action="/WeCalendar/DeleteUserScheduleComplete" method="post">
        <input type="hidden" name="deleteid" value="<%= planId %>">
        <div class="form-group">
            <div class="col-xs-offset-2 col-xs-10">
                <button type="submit" class="btn btn-info">はい</button>
            </div>
        </div>
    </form>
	</div>

	<a href="/WeCalendar/deleteUserSchedule.jsp" class="btn btn-primary btn-sm">戻る</a>

	<jsp:include page="/footer.jsp"/>
</body>
</html>