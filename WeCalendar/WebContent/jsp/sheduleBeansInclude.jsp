<%@ page import="model.ScheduleBeans" %>
<%
ScheduleBeans sb = (ScheduleBeans) session.getAttribute("plandata");
int		planId = sb.getPlanId();
String	planDate = sb.getDate();
String	planTime = sb.getTime();
String	planAttribute = sb.getAttribute();
String	planPlace = sb.getPlace();
String	planTitle = sb.getTitle();
String 	planContent = sb.getContent();
String 	planAuthority = sb.getAuthority();
String 	planCreateGroup = sb.getCreateGroup();
String 	planCreateUser = sb.getCreateUser();
%>