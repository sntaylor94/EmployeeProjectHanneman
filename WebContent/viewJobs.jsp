<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="viewTables.css">
<title>Employee Job System - View Jobs for Employee</title>
</head>
<body>
	<form method = "post" action = "editJobListServlet">
		<table>
		<caption>Employee Details</caption>
			<tr>
				<th>Employee ID</th>
				<th>First Name</th>
				<th>Last Name</th>
			</tr>
			<tr>
				<td><c:out value = "${employee.id}"/></td>
				<td><c:out value = "${employee.firstName}"/></td>
				<td><c:out value = "${employee.lastName}"/></td>
			</tr>
		</table><br />
		<table>
		<caption>Employee Jobs</caption>
			<tr>
				<th>Job ID</th>
				<th>Start Date</th>
				<th>Termination Date</th>
				<th>Position Description</th>
				<th>Position Hours</th>
				<th>Position Pay Rate</th>
				<th>Assigned Building Address</th>
			</tr>
			<c:forEach items = "${requestScope.allJobsForEmployee}" var = "currentJob">
				<tr>
					<td><input type = "radio" name = "id" value = "${currentJob.id}">${currentJob.id}</td>
					<td>${currentJob.startDate}</td>
					<td>${currentJob.endDate}</td>
					<td>${currentJob.position.description}</td>
					<td>${currentJob.position.hours} hours/week</td>
					<td>$${currentJob.position.payRate}/hour</td>
					<td>${currentJob.building.address}</td>
			</c:forEach>
		</table><br />
		<input type = "submit" value = "Edit Job" name = "doThis">
		<input type = "submit" value = "Terminate Job" name = "doThis">
	</form>
	<a href = "viewEmployeesServlet">Return to View All Employees</a> |
	<a href = "employeeHome.html">Return Home</a>
</body>
</html>