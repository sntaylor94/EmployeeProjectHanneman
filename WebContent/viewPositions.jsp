<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="viewTables.css">
<title>Employee Job System - View Positions</title>
</head>
<body>
	<form method = "post" action = "editPositionListServlet">
		<table>
			<tr>
				<th>Position ID</th>
				<th>Description</th>
				<th>Hours</th>
				<th>Pay Rate</th>
				<th>Active Job</th>
			</tr>
			<c:forEach items = "${requestScope.allPositions}" var = "currentPosition">
				<tr>
					<td><input type = "radio" name = "id" value = "${currentPosition.id}">${currentPosition.id}</td>
					<td>${currentPosition.description}</td>
					<td>${currentPosition.hours}</td>
					<td>${currentPosition.payRate}</td>
					<td>${currentPosition.activeJob}</td>
			</c:forEach>
		</table><br />
		<input type = "submit" value = "Edit Position" name = "doThis">
		<input type = "submit" value = "Remove Position" name = "doThis">
		<input type = "submit" value = "Add Position" name = "doThis"><br/>
	</form>
	<a href = "employeeHome.html">Return Home</a>
</body>
</html>