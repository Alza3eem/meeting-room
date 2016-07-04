<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>My meetings list</title>
</head>
<body>
	My meetings list:
	<br />
	<br />
	<table>
		<thead>
			<tr>
				<th>Meeting ID</th>
				<th>Meeting Room</th>
				<th>Created By</th>
				<th>Meeting Date</th>
				<th>Start Time</th>
				<th>Finish Time</th>
			</tr>
		</thead>
		<c:if test="${meeting ne null} ">
			<c:forEach items="${meeting }" var="oneMeeting">
				<c:url value="/meeting-info/?id=${oneMeeting.id }" var="meetingUrl"></c:url>
				<tbody>
					<tr>
						<td>${oneMeeting.id}</td>
						<td>${oneMeeting.meetingRoom.name}</td>
						<td>${oneMeeting.userCreate}</td>
						<td>${oneMeeting.meetingDate }</td>
						<td>${oneMeeting.meetingStartTime }</td>
						<td>${oneMeeting.meetingEndTime }</td>
					</tr>
				</tbody>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>
