<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Job System - Edit Job</title>
<link rel="stylesheet" type="text/css" href="styling.css">
</head>
<body>
	<form method = "post" action = "editJobServlet">
		Start Date: <input type = "text" name = "startDate" value = "${jobToEdit.startDate}">
		Termination Date: <input type = "text" name = "termDate" value = "${jobToEdit.endDate}">
		<table>
			<caption>Current Building Assignment</caption>
			<tr>
				<th>Building ID</th>
				<th>Building Address</th>
				<th>Square Feet</th>
				<th>Number of Rooms</th>
			</tr>
			<tr>
				<td>${jobToEdit.building.id}</td>
				<td>${jobToEdit.building.address}</td>
				<td>${jobToEdit.building.squareFeet}</td>
				<td>${jobToEdit.building.numRooms}</td>
			</tr>
		</table>
		<table>
			<caption>Future Building Assignment</caption>
			<tr>
				<th>Building ID</th>
				<th>Building Address</th>
				<th>Square Feet</th>
				<th>Number of Rooms</th>
			</tr>
			<c:forEach items = "${requestScope.allBuildings}" var = "currentBuilding">
				<tr>
					<td><input type = "radio" name = "futureBuildingId" value = "${currentBuilding.id}">${currentBuilding.id}</td>
					<td>${currentBuilding.address}</td>
					<td>${currentBuilding.squareFeet}</td>
					<td>${currentBuilding.numRooms}</td>
				</tr>
			</c:forEach>
		</table><br />
		<input type = "hidden" name = "id" value = "${jobToEdit.id}">
		<input type = "submit" value = "Save Edited Job">
		<input type = "reset" value = "Reset Fields">
	</form><br />
	<a href = "viewEmployeesServlet">View All Employees</a> | 
	<a href = "employeeHome.html">Return Home</a>
</body>
</html>