<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Job System - Edit Employee</title>
</head>
<body>
		<form action = "editEmployeeServlet" method = "post">
		Name: <input type = "text" name = "firstName" value = "${employeeToEdit.firstName}"> <input type = "text" name = "lastName" value="${employeeToEdit.lastName}"> <br /><br />
		Phone: <input type = "text" name = "phone" value = "${employeeToEdit.phone}"><br /> <br />
		Home Address: <input type = "text" name = "homeAddress" value = "${employeeToEdit.homeAddress}"><br /> <br />
		Email: <input type = "text" name = "email" value = "${employeeToEdit.email}"><br /> <br />
		Termination Date: <input type = "text" name = "termDate" value = "${employeeToEdit.terminationDate}"><br /> <br />
		<input type = "hidden" name = "id" value = "${employeeToEdit.id}">
		<input type = "submit" value = "Save Edited Employee">
		<input type = "reset" value = "Reset Fields">
	</form>
	<a href = "viewEmployeesServlet">View All Employees</a>
	<a href = "employeeHome.html">Return Home</a>
</body>
</html>