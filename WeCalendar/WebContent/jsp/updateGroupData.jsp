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
	現在ログイン中のグループは
	<% if(gB.getGroupId().equals("0")){ %>
		ありません。<br>
	<% }else{ %>
		『 ${groupdata.groupName} 』です。<br><br>

		パスワードを入力後、変更したい情報を入力して下さい。<br>
		<div class="container">
	    <form action="/WeCalendar/UpdateGroupDataCheck" method="post" class="form-horizontal">
	    	<div class="form-group">
	            <label class="control-label col-xs-2">GroupPass</label>
	            <div class="col-xs-5">
	                <input type="password" pattern="^[0-9A-Za-z]+$" minlength='8' maxlength='12'
	                 name="grouppass" class="form-control" placeholder="Password" required>
	            </div>
	            <div style="color:red;font-size:12px;"><br>(半角英数,8～12文字)</div>
	        </div><br><br>
	    	<div class="form-group">
	            <label class="control-label col-xs-2">GroupID</label>
	            <div class="col-xs-5">
	                <input type="text" pattern="^[0-9A-Za-z]+$" minlength='8' maxlength='12'
	                name="newid" class="form-control" placeholder="ID">
	            </div>
	            <div style="color:red;font-size:12px;"><br>(半角英数,8～12文字)</div>
	        </div>
	        <div class="form-group">
	            <label class="control-label col-xs-2">GroupName</label>
	            <div class="col-xs-5">
	                <input type="text" name="newname" class="form-control" placeholder="Name">
	            </div>
	        </div>
	        <div class="form-group">
	            <label class="control-label col-xs-2">GroupPass</label>
	            <div class="col-xs-5">
	                <input type="password" pattern="^[0-9A-Za-z]+$" minlength='8' maxlength='12'
	                 name="newgrouppass01" class="form-control" placeholder="Password">
	            </div>
	            <div style="color:red;font-size:12px;"><br>(半角英数,8～12文字)</div>
	        </div>
	        <div class="form-group">
	            <label class="control-label col-xs-2">Pass(確認)</label>
	            <div class="col-xs-5">
	                <input type="password"  pattern="^[0-9A-Za-z]+$" minlength='8' maxlength='12'
	                 name="newgrouppass02" class="form-control" placeholder="Password">
	            </div>
	        </div>
			<!-- ----------------------------------------------
			<div class="form-group">
	            <label class="control-label col-xs-2">GroupMenberID</label>
	            <div class="col-xs-5">
	                <input type="text" pattern="^[0-9A-Za-z]+$" minlength='8' maxlength='12'
	                	name="menberid01" class="form-control" placeholder="ID" required>
	                <input type="text" pattern="^[0-9A-Za-z]+$" minlength='8' maxlength='12'
	                	name="menberid02" class="form-control" placeholder="ID" required>
	                <input type="text" pattern="^[0-9A-Za-z]+$" minlength='8' maxlength='12'
	                	name="menberid03" class="form-control" placeholder="ID" required>
	                <input type="text" pattern="^[0-9A-Za-z]+$" minlength='8' maxlength='12'
	                	name="menberid04" class="form-control" placeholder="ID" required>
	                <input type="text" pattern="^[0-9A-Za-z]+$" minlength='8' maxlength='12'
	                	name="menberid05" class="form-control" placeholder="ID" required>
	                <input type="text" pattern="^[0-9A-Za-z]+$" minlength='8' maxlength='12'
	                	name="menberid06" class="form-control" placeholder="ID" required>
	            </div>
	            <div style="color:red;font-size:12px;"><br>(半角英数,8～12文字)</div>
	        </div>
	        -------------------------------------------->
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