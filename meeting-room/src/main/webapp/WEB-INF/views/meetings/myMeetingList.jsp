<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
				<th>Meeting Title</th>
				<th>Meeting Room</th>
				<th>Created By</th>
				<th>Meeting Date</th>
				<th>Start Time</th>
				<th>Finish Time</th>
			</tr>
		</thead>
		<c:forEach items="${meetings }" var="oneMeeting">
			<c:url value="/meeting-info/?id=${oneMeeting.id }" var="meetingUrl"></c:url>
			<tbody>
				<tr>
					<td><a onclick="return false;"
						ondblclick="location.href='${meetingUrl}';" href="${meetingUrl}">
							${oneMeeting.title}</a></td>
					<td>${oneMeeting.meetingRoom.name}</td>
					<td>${oneMeeting.userCreate.username}</td>
					<td>${oneMeeting.meetingDate }</td>
					
					<jsp:useBean id="startTime" class="java.util.Date"></jsp:useBean>
					<jsp:setProperty property="time" name="startTime"
						value="${oneMeeting.meetingStartTime }" />
					<td><f:formatDate value="${startTime }" pattern="hh:mm a" /></td>
					
					<jsp:useBean id="endTime" class="java.util.Date"></jsp:useBean>
					<jsp:setProperty property="time" name="endTime"
						value="${oneMeeting.meetingEndTime }" />
					<td><f:formatDate value="${endTime }" pattern="hh:mm a" /></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
</body>
</html>
