<%@ page import="model.ScheduleBeans" %>
<%
ScheduleBeans sb = (ScheduleBeans) session.getAttribute("plandata");
int		planId = sb.getPlanId();
String	planDate = sb.getDate();
String	planStartTime = sb.getStartTime();
if(planStartTime==null){planStartTime = "";}
String	planEndTime = sb.getEndTime();
if(planEndTime==null){planEndTime = "";}
String	planAttribute = sb.getAttribute();
String	planPlace = sb.getPlace();
if(planPlace==null){planPlace = "";}
String	planTitle = sb.getTitle();
String 	planContent = sb.getContent();
if(planContent==null){planContent = "";}
String 	planAuthority = sb.getAuthority();
String 	planCreateGroup = sb.getCreateGroup();
String 	planCreateUser = sb.getCreateUser();
%>