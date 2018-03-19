<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="viewTables.css">
<title>Employee Job System - Assign Employee Job</title>
</head>
<body>
	<form method = "post" action = "assignJobServlet">
		<table>
		<caption>Employee Details</caption>
			<tr>
				<th>Employee ID</th>
				<th>First Name</th>
				<th>Last Name</th>
			</tr>
			<tr>
				<td><input type = "hidden" name = "employeeId" value =  "${employee.id}">${employee.id}</td>
				<td><c:out value = "${employee.firstName}"/></td>
				<td><c:out value = "${employee.lastName}"/></td>
			</tr>
		</table>
		<h3>Start Date</h3>
		Start Month: <select name = "month">
						<option value = "jan">Jan</option>
						<option value = "feb">Feb</option>
						<option value = "mar">March</option>
						<option value = "april">April</option>
						<option value = "may">May</option>
						<option value = "june">June</option>
						<option value = "july">July</option>
						<option value = "aug">August</option>
						<option value = "sep">September</option>
						<option value = "oct">October</option>
						<option value = "nov">November</option>
						<option value = "dec">December</option>
					</select>
			Start Day: <input type = "text" name = "day">
			Start Year: <input type = "text" name = "year">
		<table>
		<caption>Available Positions</caption>
			<tr>
				<th>Position ID</th>
				<th>Description</th>
				<th>Hours</th>
				<th>Pay Rate</th>
			</tr>
			<c:forEach items = "${requestScope.allPositions}" var = "currentPosition">
				<tr>
					<td><input type = "radio" name = "positionId" value = "${currentPosition.id}">${currentPosition.id}</td>
					<td>${currentPosition.description}</td>
					<td>${currentPosition.hours}</td>
					<td>${currentPosition.payRate}</td>
			</c:forEach>
		</table>
		<table>
			<caption>Available Buildings</caption>
			<tr>
				<th>Building ID</th>
				<th>Building Address</th>
				<th>Square Feet</th>
				<th>Number of Rooms</th>
			</tr>
			<c:forEach items = "${requestScope.allBuildings}" var = "currentBuilding">
				<tr>
					<td><input type = "radio" name = "buildingId" value = "${currentBuilding.id}">${currentBuilding.id}</td>
					<td>${currentBuilding.address}</td>
					<td>${currentBuilding.squareFeet}</td>
					<td>${currentBuilding.numRooms}</td>
			</c:forEach>
		</table>
		<input type = "submit" value = "Assign Job">
		<input type = "reset" value = "Reset Fields">
	</form>
	<a href = "viewEmployeesServlet">View All Employees</a><br />
	<a href = "employeeHome.html">Return Home</a>
</body>
</html>