<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="datepair.js"></script>
<script type="text/javascript" src="jquery.datepair.js"></script>
<script>
	// initialize input widgets first
	$('#datepairExample .time').timepicker({
		'showDuration' : true,
		'timeFormat' : 'g:ia'
	});

	$('#datepairExample .date').datepicker({
		'format' : 'yyyy-m-d',
		'autoclose' : true
	});

	// initialize datepair
	$('#datepairExample').datepair();
</script>
<title>Book meeting</title>
</head>
<body>
	<c:url value="/book-meeting" var="bookMeetingUrl"></c:url>
	Book a meeting: ${mess}

	<form action="${bookMeetingUrl}" method="post" id="meetingForm">
		<table>
			<tr>
				<td>Meeting room</td>
				<td><select id="meetingRoom" name="meetingRoom"
					title="Select meetong room">
						<c:if test="${fn:length(meetingRoom) ne 0 }">
							<c:forEach var="meetingRoom" items="${meetingRoom }">
								<option value="${meetingRoom.name}">${meetingRoom.name}</option>
							</c:forEach>
						</c:if>
				</select></td>
			</tr>
			<tr>
				<td>Attendees</td>
				<td><input type="text" name="attendees" /></td>
			</tr>
			<tr>
				<td>Notes</td>
				<td>
				<textarea name="notes" rows="4" cols="50"></textarea> </td>
			</tr>
			<tr>
				<td>Date</td>
				<td><input type="text" id="datepairExample" name="meetingDate"
					class="date start" /></td>
			</tr>
			<tr>
				<td>Start time</td>
				<td><input id="datepairExample" name="meetingStartTime"
					type="text" class="time start" /></td>
			</tr>
			<tr>
				<td>End time</td>
				<td><input type="text" id="datepairExample"
					name="meetingEndTime" class="time end" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" /><input type="reset" /></td>
			</tr>
		</table>
	</form>
</body>
</html>