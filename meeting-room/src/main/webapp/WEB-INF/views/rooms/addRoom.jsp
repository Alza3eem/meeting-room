<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a Room</title>
</head>
<body>
Add a Room:${message }
		<br />
		
		<br />
	<form action="add-room" method="post">
<table>
			<tr>
				<td>Room Name</td>
				<td><input type="text" name="name" value="${room.name }" /></td>
			</tr>
			<tr>
				<td>Room Location</td>
				<td><input type="text" name="location" value="${room.location }"/></td>
			</tr>
			<tr>
				<td>Room Equipment</td>
				<td><input type="text" name="equipment" value="${room.equipment }" } /></td>
			</tr>
			<tr>
				<td>Room Capacity</td>
				<td><input type="text" name="capacity" value="${room.capacity }"/></td>
			</tr>
			<input type="hidden" value="${room.id }" name="id" />
			<tr>
				<td><input type="submit" value="Submit"/></td>
			</tr>
			</table>
</form>
</body>
</html>