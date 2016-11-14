<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/scheduleBeansInclude.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK rel="stylesheet" type="text/css" href="bootstrap.min.css">
	<title>WeCalendar MyPage</title>
</head>

<body>
<jsp:include page="/header.jsp"/>

	<div class="container">
    <form action="/WeCalendar/UpDateGroupScheduleFinalCheck" method="post" class="form-horizontal">
    	スケジュール入力
    	<div class="form-group">
            <label class="control-label col-xs-2">グループスケジュールID：<%= planId %></label>
            <input type="hidden" name="id" value="<%= planId %>">
        </div>
    	<div class="form-group">
            <label class="control-label col-xs-2">日付</label>
            <div class="col-xs-5">
                <input type="date" name="date" class="form-control" style="width:100;"
                 value="<%= planDate %>" required>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-2">開始時間</label>
            <div class="col-xs-5">
                <input type="time" name="starttime" class="form-control" value="<%= planStartTime %>">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-2">終了時間</label>
            <div class="col-xs-5">
                <input type="time" name="endtime" class="form-control" value="<%= planEndTime %>">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-2">属性</label>
            <div class="col-xs-5">
                <b>
                仕事:<input type="radio" name="attribute" value="仕事"
                	  <% if(sb.getAttribute().equals("仕事")){ %>checked="checked"<% } %>>
                イベント:<input type="radio" name="attribute" value="イベント"
                		  <% if(sb.getAttribute().equals("イベント")){ %>checked="checked"<% } %>>
                プライベート:<input type="radio" name="attribute" value="プライベート"
                			  <% if(sb.getAttribute().equals("プライベート")){ %>checked="checked"<% } %>>
                その他:<input type="radio" name="attribute" value="その他"
                		<% if(sb.getAttribute().equals("その他")){ %>checked="checked"<% } %>>
                </b>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-2">場所</label>
            <div class="col-xs-5">
                <input type="text" name="place" class="form-control"
                 value="<%= planPlace %>" maxlength='100'>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-2">タイトル</label>
            <div class="col-xs-5">
                <input type="text" name="title" class="form-control"
                 value="<%= planTitle %>" maxlength='100' required>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-2">内容</label>
            <div class="col-xs-5">
                <textarea name="content" class="form-control" rows="5" cols="30"><%= planContent %></textarea>
            </div>
        </div>
        <input type="hidden" name="authority" value="グループ">
        <input type="hidden" name="creategroup" value="<%= sb.getCreateGroup() %>">
        <input type="hidden" name="createuser" value="<%= sb.getCreateUser() %>">
        <div class="form-group">
            <div class="col-xs-offset-2 col-xs-10">
                <button type="submit" class="btn btn-info">送信</button>
                <button type="reset" class="btn btn-warning" style="margin:20px;">リセット</button>
            </div>
        </div>
    </form>
	</div>

	<a href="/WeCalendar/updateGroupSchedule.jsp" class="btn btn-primary btn-sm">戻る</a>
	<jsp:include page="/footer.jsp"/>
</body>
</html>