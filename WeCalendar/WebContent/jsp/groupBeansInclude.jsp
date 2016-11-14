<%@ page import="model.GroupBeans" %>
<%
GroupBeans gB = (GroupBeans) session.getAttribute("groupdata");
String groupId 	= gB.getGroupId();
String groupName 	= gB.getGroupName();
String groupPass	= gB.getGroupPass();
String groupAdministrator 	= gB.getAdministrator();
%>