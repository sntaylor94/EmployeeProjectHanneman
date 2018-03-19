<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styling.css">
<title>Employee Job System - View Employees</title>
</head>
<body>
	<form method = "post" action = "editEmployeeListServlet">
		<table>
			<tr>
				<th>Employee ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Phone</th>
				<th>Address</th>
				<th>Email</th>
				<th>Termination Date</th>
			</tr>
			<c:forEach items = "${requestScope.allEmployees}" var = "currentEmployee">
				<tr>
					<td><input type = "radio" name = "id" value = "${currentEmployee.id}">${currentEmployee.id}</td>
					<td>${currentEmployee.firstName}</td>
					<td>${currentEmployee.lastName}</td>
					<td>${currentEmployee.phone}</td>
					<td>${currentEmployee.homeAddress}</td>
					<td>${currentEmployee.email}</td>
					<td>${currentEmployee.terminationDate}</td>
			</c:forEach>
		</table><br />
		<input type = "submit" value = "Edit Employee" name = "doThis">
		<input type = "submit" value = "Terminate Employee" name = "doThis">
		<input type = "submit" value = "Add Employee" name = "doThis">
		<input type = "submit" value = "View this Employees' Jobs" name = "doThis">
		<input type = "submit" value = "Assign Employee New Job" name = "doThis">
	</form><br />
	<a href = "employeeHome.html">Return Home</a>
</body>
</html>