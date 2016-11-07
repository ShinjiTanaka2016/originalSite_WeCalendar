<%@ page import="model.LoginUserBeans" %>
<%
LoginUserBeans lUB = (LoginUserBeans) session.getAttribute("lub");
String myId 	= lUB.getUserId();
String myName 	= lUB.getUserName();
String myMail 	= lUB.getUserMail();
String myPass	= lUB.getUserPass();
String myGroup 	= lUB.getUsersGroup();
%>