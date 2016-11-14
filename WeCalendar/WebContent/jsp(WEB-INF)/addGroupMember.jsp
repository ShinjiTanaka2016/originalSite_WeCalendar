<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.GroupBeans" %>
<%@ include file="/userBeansInclude.jsp" %>
<%
GroupBeans gb = (GroupBeans)request.getAttribute("gb");
String id = gb.getGroupId();
String name = gb.getGroupName();
String pass = gb.getGroupPass();
String administrator = gb.getAdministrator();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK rel="stylesheet" type="text/css" href="bootstrap.min.css">
	<title>WeCalendar GroupPage</title>
</head>

<body>
	<jsp:include page="/header.jsp"/>

	以下で登録します。<br><br>
	<table>
	<tr><td>グループID</td>		<td>：<%= id %></td></tr>
	<tr><td>グループ名</td>		<td>：<%= name %></td></tr>
	<tr><td>グループパス</td>	<td>：<%= pass %></td></tr>
	<tr><td>グループ管理者</td>	<td>：<%= administrator %></td></tr>
	</table><br><br>

	<div class="container">
    <form action="/WeCalendar/AddGroupMenberCheck" method="post" class="form-horizontal">
    <label>グループメンバーを追加して下さい。</label>
    	<div class="form-group">
            <label class="control-label col-xs-2">GroupMenberID</label>
            <div class="col-xs-5">
                <input type="text" pattern="^[0-9A-Za-z]+$" minlength='8' maxlength='12'
                 name="member1" class="form-control" placeholder="ID">
                <input type="text" pattern="^[0-9A-Za-z]+$" minlength='8' maxlength='12'
                 name="member2" class="form-control" placeholder="ID">
                <input type="text" pattern="^[0-9A-Za-z]+$" minlength='8' maxlength='12'
                 name="member3" class="form-control" placeholder="ID">
                <input type="text" pattern="^[0-9A-Za-z]+$" minlength='8' maxlength='12'
                 name="member4" class="form-control" placeholder="ID">
                <input type="text" pattern="^[0-9A-Za-z]+$" minlength='8' maxlength='12'
                 name="member5" class="form-control" placeholder="ID">
                <input type="text" pattern="^[0-9A-Za-z]+$" minlength='8' maxlength='12'
                 name="member6" class="form-control" placeholder="ID">
        	</div>
        </div>
		<div class="form-group">
            <div class="col-xs-offset-2 col-xs-10">
            	<input type="hidden" name="groupid" 	value="<%= id %>">
		        <input type="hidden" name="groupname" 	value="<%= name %>">
		        <input type="hidden" name="grouppass" 	value="<%= pass %>">
		        <input type="hidden" name="createuser" 	value="<%= administrator %>">
                <button type="submit" class="btn btn-info">送信</button>
                <button type="reset" class="btn btn-warning" style="margin:20px;">リセット</button>
            </div>
        </div>
    </form>
	</div>

	<jsp:include page="/footer.jsp"/>
</body>
</html>