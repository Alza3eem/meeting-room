<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Meeting Info</title>
</head>
<body>
	Meeting Info:${errMess }
	<br />
	<br />
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Meeting Room</th>
				<th>Created By</th>
				<th>Status</th>
				<th>Meeting Date</th>
				<th>Start Time</th>
				<th>Finish Time</th>
				<th>Attendees</th>
			</tr>
		</thead>
		<c:if test="${meeting ne null} ">
			<tbody>
				<tr>
					<td>${meeting.id}</td>
					<td>${meeting.meetingRoom.name}</td>
					<td>${meeting.userCreate}</td>
					<td>${meeting.status }</td>
					<td>${meeting.meetingDate }</td>
					<td>${meeting.meetingStartTime }</td>
					<td>${meeting.meetingEndTime }</td>
					<c:forEach items="${meeting.attendees}" var="attendees">
						<td>${attendees.user.name }</td>
					</c:forEach>
				</tr>
			</tbody>
		</c:if>
	</table>
</body>
</html>
