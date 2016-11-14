<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="userBeansInclude.jsp" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK rel="stylesheet" type="text/css" href="bootstrap.min.css">
	<title>WeCalendar Schedule</title>
</head>
<body>
	<jsp:include page="/header.jsp"/>


	<div class="container">
	スケジュール入力
    <form action="/WeCalendar/AddUserScheduleCheck" method="post" class="form-horizontal">
    	<div class="form-group">
            <label class="control-label col-xs-2">日付</label>
            <div class="col-xs-5">
                <input type="date" name="date" class="form-control" style="width:100;" required>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-2">開始時間</label>
            <div class="col-xs-5">
                <input type="time" name="starttime" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-2">終了時間</label>
            <div class="col-xs-5">
                <input type="time" name="endtime" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-2">属性</label>
            <div class="col-xs-5">
                <b>仕事:<input type="radio" name="attribute" value="仕事">
                イベント:<input type="radio" name="attribute" value="イベント">
                プライベート:<input type="radio" name="attribute" value="プライベート">
                その他:<input type="radio" name="attribute" value="その他" checked="checked"></b>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-2">場所</label>
            <div class="col-xs-5">
                <input type="text" name="place" class="form-control" maxlength='100'>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-2">タイトル</label>
            <div class="col-xs-5">
                <input type="text" name="title" class="form-control"
                 value="予定" maxlength='100' required>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-2">内容</label>
            <div class="col-xs-5">
                <textarea name="content" class="form-control" rows="4" cols="100"></textarea>
            </div>
        </div>
        <input type="hidden" name="authority" value="個人">
        <input type="hidden" name="createuser" value="<%= myId %>">
        <div class="form-group">
            <div class="col-xs-offset-2 col-xs-10">
                <button type="submit" class="btn btn-info">送信</button>
                <button type="reset" class="btn btn-warning" style="margin:20px;">リセット</button>
            </div>
        </div>
    </form>
	</div>

	<a href="myPage.jsp" class="btn btn-info" style="margin:20px;"><b>戻る</b></a>
	<jsp:include page="/footer.jsp"/>
</body>
</html>