<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styling.css">
<title>Employee Job System - Edit Building</title>
</head>
<body>
	<form action="editBuildingServlet" method="post">
		Building Address: <input type = "text" name = "streetAddress" value = "${buildingToEdit.address}"><br />
		Square Feet: <input type = "text" name = "squareFeet" value = "${buildingToEdit.squareFeet}"><br />
		Number of Rooms: <input type = "text" name = "numberOfRooms" value = "${buildingToEdit.numRooms}"><br />
		<input type = "hidden" name = "id" value = "${buildingToEdit.id}">
		<input type = "submit" value = "Save Edited Building">
		<input type = "reset" value = "Reset Fields">
	</form> <br />
	<a href = "viewBuildingsServlet">View All Buildings</a> | 
	<a href = "employeeHome.html">Return Home</a>
</body>
</html>