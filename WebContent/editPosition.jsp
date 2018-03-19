<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styling.css">
<title>Employee Job System - Edit Position</title>
</head>
<body>
	<form action = "editPositionServlet" method = "post">
		Job Description: <input type = "text" name = "description" value = "${positionToEdit.description}"> <br />
		Hours: <input type = "text" name = "hours" value = "${positionToEdit.hours}"><br />
		Pay Rate: <input type = "text" name = "payRate" value = "${positionToEdit.payRate}"><br />
		Is Position Active? Y/N <input type = text name = "active" value = "${positionToEdit.activeJob}"><br />
		<input type = "hidden" name = "id" value = "${positionToEdit.id}">
		<input type = "submit" value = "Save Edited Position">
		<input type = "reset" value = "Reset Fields">
	</form><br />
	<a href = "viewPositionsServlet">View All Positions</a> | 
	<a href = "employeeHome.html">Return Home</a>
</body>
</html>