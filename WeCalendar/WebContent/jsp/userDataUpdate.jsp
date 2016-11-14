<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="userBeansInclude.jsp" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK rel="stylesheet" type="text/css" href="bootstrap.min.css">
	<title>WeCalendar</title>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/header.jsp"/>

	パスワードを入力し、変更したいデータを入力してください。
	<div class="container">
    <form action="/WeCalendar/UserDataUpdateCheck" method="post" class="form-horizontal">
    	<div class="form-group">
            <label class="control-label col-xs-2">Pass(現在)</label>
            <div class="col-xs-5">
                <input type="password" name="userpass" class="form-control" placeholder="Password"
                 pattern="^[0-9A-Za-z]+$" minlength='8' maxlength='12'>
            </div>
        </div><br><br>
    	<div class="form-group">
            <label class="control-label col-xs-2">UserID</label>
            <div class="col-xs-5">
                <input type="text" name="newuserid" class="form-control" placeholder="ID"
                 pattern="^[0-9A-Za-z]+$" minlength='8' maxlength='12'>
            </div>
            <div style="color:red;font-size:12px;"><br>(半角英数,8～12文字)</div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-2">Name</label>
            <div class="col-xs-5">
                <input type="text" name="newusername" class="form-control" placeholder="Name">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-2">Mail</label>
            <div class="col-xs-5">
                <input type="text" name="newusermail" class="form-control" placeholder="Mail">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-2">Pass(変更後)</label>
            <div class="col-xs-5">
                <input type="password" name="newuserpass01" class="form-control" placeholder="Password"
                 pattern="^[0-9A-Za-z]+$" minlength='8' maxlength='12'>
            </div>
            <div style="color:red;font-size:12px;"><br>(半角英数,8～12文字)</div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-2">Pass(確認)</label>
            <div class="col-xs-5">
                <input type="password" name="newuserpass02" class="form-control" placeholder="Password"
                 pattern="^[0-9A-Za-z]+$" minlength='8' maxlength='12'>
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

	<a href="myPage.jsp" class="btn btn-info" style="margin:20px;"><b>戻る</b></a>
	<jsp:include page="/footer.jsp"/>
</body>
</html>