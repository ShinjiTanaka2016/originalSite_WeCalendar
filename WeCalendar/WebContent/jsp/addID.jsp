<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK rel="stylesheet" type="text/css" href="bootstrap.min.css">
	<title>Insert title here</title>
</head>


<body>
	<nav class="navbar navbar-inverse">
		<div style="color:#fff;font-size:18px;margin:10px;"><b>新規ユーザ登録</b></div>
	</nav>

	<div class="container">
    <form action="/WeCalendar/AddUserIDCheck" method="post" class="form-horizontal">
    	<div class="form-group">
            <label class="control-label col-xs-2">UserID</label>
            <div class="col-xs-5">
                <input type="text" pattern="^[0-9A-Za-z]+$" minlength='8' maxlength='12'
                name="userid" class="form-control" placeholder="ID" required>
            </div>
            <div style="color:red;font-size:12px;"><br>(半角英数,8～12文字)</div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-2">Name</label>
            <div class="col-xs-5">
                <input type="text" name="username" class="form-control" placeholder="Name" required>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-2">Mail</label>
            <div class="col-xs-5">
                <input type="text" name="usermail" class="form-control" placeholder="Mail" required>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-2">Pass</label>
            <div class="col-xs-5">
                <input type="password" pattern="^[0-9A-Za-z]+$" minlength='8' maxlength='12'
                 name="userpass01" class="form-control" placeholder="Password" required>
            </div>
            <div style="color:red;font-size:12px;"><br>(半角英数,8～12文字)</div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-2">Pass(確認)</label>
            <div class="col-xs-5">
                <input type="password"  pattern="^[0-9A-Za-z]+$" minlength='8' maxlength='12'
                 name="userpass02" class="form-control" placeholder="Password" required>
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
	<a href="/WeCalendar/index.jsp" class="btn btn-primary btn-sm">TOPへ</a><br><br>
</body>
</html>