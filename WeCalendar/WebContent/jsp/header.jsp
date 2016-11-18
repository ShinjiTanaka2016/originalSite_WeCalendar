<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="userBeansInclude.jsp" %>
<%@ include file="groupBeansInclude.jsp" %>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>

      </button>
      <a class="navbar-brand" href="/WeCalendar/Calendar.jsp">
      <b style="color:white;font-size:22px;">カレンダー</b></a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
      <ul class="nav navbar-nav">
        <li><a href="myPage.jsp"><b style="color:white;">マイページ</b></a></li>
        <li><a href="myGroup.jsp"><b style="color:white;">マイグループ</b></a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      	<li style="color:#fff;">ID:[<%= myId %>]　Name:[<%= myName %>]</li>
        <li><a href="logOut.jsp"><b style="color:white;">ログアウト</b></a></li>
      </ul>
    </div>
  </div>
</nav>