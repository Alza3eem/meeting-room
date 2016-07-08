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
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Meeting Room</th>
					<th>Created By</th>
					<th>Title</th>
					<th>Meeting Date</th>
					<th>Start Time</th>
					<th>Finish Time</th>
					<th>Attendees</th>
				</tr>
			</thead>

			<tbody>
				<tr>
					<td>${meeting.id}</td>
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
						<td>${attendee.attendee.firstName}</td>
						<c:if test="${attendee.attendee.username eq loggedUser.username}">
							<c:choose>
								<c:when test="${attendee.response eq 'WAITING'}">
									<tr>
										<td><input type="submit" name="accept" value="accept" /></td>
										<td><input type="submit" name="reject" value="reject" /></td>
									</tr>
								</c:when>
								<c:otherwise>
									<td>${attendee.response }</td>
								</c:otherwise>
							</c:choose>
						</c:if>
					</c:forEach>
				</tr>
				<tr>
					<c:if test="${meeting.userCreate.username eq loggedUser.username}">
						<td><input type="submit" name="cancel" value="cancel" /></td>
					</c:if>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>
