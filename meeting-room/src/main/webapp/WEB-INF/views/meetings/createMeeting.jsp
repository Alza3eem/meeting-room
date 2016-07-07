<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.3/jquery.timepicker.min.css">
<script
	src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.3/jquery.timepicker.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('input.timepicker').timepicker({});
	});
</script>
<title>Book meeting</title>
</head>
<body>
	<c:url value="/book-meeting" var="bookMeetingUrl"></c:url>
	Book a meeting: ${mess}

	<form action="${bookMeetingUrl}" method="post" id="meetingForm">
		<table>
			<tr>
				<td>Title</td>
				<td><input type="text" name="title" /></td>
			</tr>
			<tr>
				<td>Meeting room</td>
				<td><select id="meetingRoom" name="meetingRoom"
					title="Select meetong room">
						<c:if test="${fn:length(rooms) ne 0 }">
							<c:forEach var="room" items="${rooms }">
								<option value="${room.name}">${room.name}</option>
							</c:forEach>
						</c:if>
				</select></td>
			</tr>
			<tr>
				<td>Attendees</td>
				<td><select id="attendees" name="attendees"
					title="Select attendees" multiple="multiple">
						<c:if test="${fn:length(users) ne 0 }">
							<c:forEach var="user" items="${users }">
								<option value="${user.username}">${user.firstName}
									${user.lastName}</option>
							</c:forEach>
						</c:if>
				</select></td>
			</tr>
			<tr>
				<td>Notes</td>
				<td><textarea name="notes" rows="4" cols="50" name="notes"></textarea></td>
			</tr>
			<tr>
				<td>Date</td>
				<td><input type="text" id="datepicker" name="meetingDate"
					readonly="readonly" /></td>
			</tr>
			<tr>
				<td>Start time</td>
				<td><input class="timepicker" name="meetingStartTime"
					type="text" /></td>
			</tr>
			<tr>
				<td>End time</td>
				<td><input type="text" class="timepicker" name="meetingEndTime" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" /><input type="reset" /></td>
			</tr>
		</table>
	</form>
</body>
</html>