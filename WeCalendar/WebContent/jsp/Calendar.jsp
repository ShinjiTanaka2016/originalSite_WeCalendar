<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="userBeansInclude.jsp" %>
<%@ include file="/groupBeansInclude.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<LINK rel="stylesheet" type="text/css" href="bootstrap.min.css">


	<style type="text/css">
		table {
		  align: center;
		  border: solid 1px #000000;
		}
		th {
		  border: solid 2px #000000;
		  padding:10px;
		}
		td {
		  border: solid 2px #000000;
		  padding:10px;
		}
		.tdlink {
		  cursor: pointer;
		  // display: block;
		}
		.tdlink:hover {
		  background-color: #ff0000;
		}
		.btn1{
			border:1px solid #111;
		}
		.btn2{
			border:1px solid #111;
			margin:20px;
		}
		.btn3{
			border:1px solid #111;
		}
		button.btn_day{
			width:65px;
			font-size:2.4em;
			background-color:skyblue;
			border-radius:5px;
		}
	</style>
</head>
<body>
<jsp:include page="/header.jsp"/>
<script type="text/javascript"  src="calendarDisplay.js"></script>
<div id="result"></div>
<jsp:include page="/footer.jsp"/>
</body>
</html>