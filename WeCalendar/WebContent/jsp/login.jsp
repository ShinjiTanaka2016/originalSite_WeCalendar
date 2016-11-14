<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK rel="stylesheet" type="text/css" href="bootstrap.min.css">
	<title>WeCalendar</title>
</head>


<body>

	<nav class="navbar navbar-inverse">
	      <div style="color:#fff;font-size:18px;margin:10px;">ログイン</div>
	</nav>

	<div class="container">
    <form action="/WeCalendar/LoginCheck" method="post" class="form-horizontal">
    	<div class="form-group">
            <label class="control-label col-xs-2">UserID</label>
            <div class="col-xs-5">
                <input type="text" name="loginuserid" class="form-control" pattern="^[0-9A-Za-z]+$"
                 maxlength='12' placeholder="ID">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-2">Pass</label>
            <div class="col-xs-5">
                <input type="password" name="loginuserpass" class="form-control" pattern="^[0-9A-Za-z]+$"
                 maxlength='12' placeholder="Password">
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

<!-- <jsp:include page="/footer.jsp"/> -->
<hr>
<a href="/WeCalendar/top.jsp" class="btn btn-primary btn-sm">TOPへ</a><br><br>
</body>
</html>