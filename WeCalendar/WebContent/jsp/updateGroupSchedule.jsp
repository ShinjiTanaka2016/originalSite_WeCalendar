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
	<% }else{ %>
		<div class="container">
		変更したいグループスケジュールIDを入力して下さい。
	    <form action="/WeCalendar/UpdateGroupScheduleCheck" method="post" class="form-horizontal">
	    	<div class="form-group">
	            <label class="control-label col-xs-2">
	            	GroupPlanID<div style="color:red;">(必須)</div></label>
	            <div class="col-xs-5">
	                <input type="text" name="planid" class="form-control" style="width:100;"
	                maxlength="10" pattern="^[0-9]+$" required>
	            </div>
	        </div>
	        <div class="form-group">
	            <div class="col-xs-offset-2 col-xs-10">
	                <button type="submit" class="btn btn-info">送信</button>
	                <button type="reset" class="btn btn-warning" style="margin:20px;">リセット</button>
	            </div>
	        </div>
	    </form>
		</div>
	<% } %>
	<jsp:include page="/footer.jsp"/>
</body>
</html>