<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="userBeansInclude.jsp" %>


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
	パスワードを入力して下さい。<br>
    <form action="DeleteUserCheck" method="post" class="form-horizontal">
        <div class="form-group">
            <label class="control-label col-xs-2">Pass</label>
            <div class="col-xs-5">
                <input type="password" name="deletepass" pattern="^[0-9A-Za-z]+$"
                 minlength='8' maxlength='12' class="form-control" placeholder="Password">
            </div>
            <div style="color:red;font-size:12px;"><br>(半角英数,8～30文字)</div>
        </div>
        <div class="form-group">
            <div class="col-xs-offset-2 col-xs-10">
	            <div style="color:red">
	            ※送信するとID・スケジュール・管理グループが削除され、同IDではログインできなくなります。
	            </div>
                <button type="submit" class="btn btn-info" style="margin:20px;">送信</button>
                <button type="reset" class="btn btn-warning" style="margin:20px;">リセット</button>
            </div>
        </div>
    </form>
	</div>
	<a href="myPage.jsp" class="btn btn-info" ><b>戻る</b></a><br>

	<jsp:include page="/footer.jsp"/>
</body>
</html>