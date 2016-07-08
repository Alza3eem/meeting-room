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
	<c:url value="/meeting-info" var="infoMeetingUrl"></c:url>
	<form action="${infoMeetingUrl }" method="post" id="infoForm">
		<input type="hidden" name="meetingId" value="${meeting.id}">
		<table>
			<thead>
				<tr>
					<th>Meeting Room</th>
					<th>Created By</th>
					<th>Title</th>
					<th>Meeting Date</th>
					<th>Start Time</th>
					<th>Finish Time</th>
					<th>Attendees</th>
					<th>Response</th>
				</tr>
			</thead>

			<tbody>
				<tr>
					<td>${meeting.meetingRoom.name}</td>
					<td>${meeting.userCreate.firstName}</td>
					<td>${meeting.title }</td>
					<td>${meeting.meetingDate }</td>

					<jsp:useBean id="startTime" class="java.util.Date"></jsp:useBean>
					<jsp:setProperty property="time" name="startTime"
						value="${meeting.meetingStartTime }" />
					<td><f:formatDate value="${startTime }" pattern="hh:mm a" /></td>

					<jsp:useBean id="endTime" class="java.util.Date"></jsp:useBean>
					<jsp:setProperty property="time" name="endTime"
						value="${meeting.meetingEndTime }" />
					<td><f:formatDate value="${endTime }" pattern="hh:mm a" /></td>
					<c:forEach items="${meeting.attendees}" var="attendee">
						<td>${attendee.attendee.firstName}
							${attendee.attendee.lastName}</td>
						<c:if test="${attendee.attendee.username eq loggedUser.username}">
							<c:set var="value" value="${attendee.response}"></c:set>
							<c:if test="${attendee.response eq 'WAITING'}">
								<input type="submit" name="Accept" value="accept" />
								<input type="submit" name="Reject" value="reject" />
							</c:if>
						</c:if>
					</c:forEach>
					<td>${value }</td>
				</tr>
				<c:if test="${meeting.userCreate.username eq loggedUser.username}">
					<input type="submit" name="cancel" value="Cancel" />
				</c:if>
			</tbody>
		</table>
	</form>
</body>
</html>
