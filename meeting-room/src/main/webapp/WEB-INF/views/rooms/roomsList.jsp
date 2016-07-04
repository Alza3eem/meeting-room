<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Rooms List</title>
</head>
<body>
	Rooms:${message }
	<%
		session.removeAttribute("message");
	%>
	<br />
	
	<br />
	<table>
		<thead>
			<tr>
				<th> Name</th>
				<th> Location</th>
				<th> Capacity</th>
				<th> Equipment</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${fn:length(rooms) eq 0}">
				<tr>
					<td colspan="5">No Rooms Found</td>
				</tr>
			</c:if>
			<c:forEach items="${rooms}" var="room">
				<c:url value="/update-room/?roomName=${room.name}"
					var="updateRoomUrl"></c:url>
				<c:url value="/delete-room/?roomName=${room.name}"
					var="deleteUrl"></c:url>
				<tr>
					<td><a onclick="return false;"
						ondblclick="location.href='${roomInfoUrl}';" href="${roomInfoUrl}">
							${room.name}</a></td>
					<td>${room.location}</td>
					<td>${room.capacity}</td>
					<td>${room.equipment}</td>
					<td><button onclick="location.href='${updateRoomUrl}';" id=update>Update</button></td>
					<td><button onclick="location.href='${deleteUrl}';"
							id="delete">Delete</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>