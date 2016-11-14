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
      <a class="navbar-brand" href="/WeCalendar/Calendar.jsp"><b>カレンダー</b></a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
      <ul class="nav navbar-nav">
        <li><a href="myPage.jsp"><b>マイページ</b></a></li>
        <li><a href="myGroup.jsp"><b>マイグループ</b></a></li>
      </ul>
<!-- ------------------------------------------------------------------
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">検索</button>
      </form>
 ------------------------------------------------------------------------>
      <ul class="nav navbar-nav navbar-right">
      	<li style="color:#fff;">ID:[<%= myId %>]　Name:[<%= myName %>]　
      	Group:[<% if( gB.getGroupId()=="0"){%>nothing<% }else{ %><%= groupName %><% } %>]</li>
        <li><a href="logOut.jsp"><b>ログアウト</b></a></li>
      </ul>
    </div>
  </div>
</nav>