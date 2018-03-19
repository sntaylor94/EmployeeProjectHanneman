<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="viewTables.css">
<title>Employee Job System - View Buildings</title>
</head>
<body>
	<form method = "post" action = "editBuildingListServlet">
		<table>
			<tr>
				<th>Building ID</th>
				<th>Building Address</th>
				<th>Square Feet</th>
				<th>Number of Rooms</th>
			</tr>
			<c:forEach items = "${requestScope.allBuildings}" var = "currentBuilding">
				<tr>
					<td><input type = "radio" name = "id" value = "${currentBuilding.id}">${currentBuilding.id}</td>
					<td>${currentBuilding.address}</td>
					<td>${currentBuilding.squareFeet}</td>
					<td>${currentBuilding.numRooms}</td>
			</c:forEach>
		</table><br />
		<input type = "submit" value = "Edit Building" name = "doThis">
		<input type = "submit" value = "Remove Building" name = "doThis">
		<input type = "submit" value = "Add Building" name = "doThis"><br/>
	</form>
	<a href = "employeeHome.html">Return Home</a>
</body>
</html>