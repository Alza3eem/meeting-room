<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users List</title>
</head>
<body>
	<table style="width: 100%">
		<col width="30%">
		<col width="70%">
		<tr>
			<td><a
				href="${pageContext.request.contextPath}/listusers">List Users</a></td>
			<td rowspan="5">
				<table style="width: 100%">
					<tr>
						<td>ID</td>
						<td>First name</td>
						<td>Last name</td>
						<td>Username</td>
						<td>Title</td>
						<td></td>
					</tr>
					<c:forEach var="user" items="${userslst}">
						<tr>
							<td>${user.id}</td>
							<td>${user.firstName}</td>
							<td>${user.lastName}</td>
							<td>${user.username}</td>
							<td>${user.title}</td>
							<form method="post"
								action="${pageContext.request.contextPath}/deleteuser">
								<input type="hidden" name="id" value="${user.id}">
							<td><input type="submit" value="Delete" /></td>
							</form>

							<form method="get"
								action="${pageContext.request.contextPath}/updateuser">
								<input type="hidden" name="id" value="${user.id}">
								<td><input type="submit" value="Edit" /></td>
							</form>
						</tr>
					</c:forEach>


				</table>
 
			</td>
		</tr>

		<tr>
			<td><a
				href="${pageContext.request.contextPath}/listrole">List Role</a></td>
		</tr>

		<tr>
			<td><a
				href="${pageContext.request.contextPath}/listfuncs">List Functions</a></td>
		</tr>

		<tr>
			<td><a
				href="${pageContext.request.contextPath}/adduser">Add User</a></td>
		</tr>
		
		<tr>
			<td><a
				href="${pageContext.request.contextPath}/addrole">Add Role</a></td>
		</tr>
		
		<tr>
			<td><a
				href="${pageContext.request.contextPath}/addfunction">Add Function</a></td>
		</tr>
		
		<tr>
			<td><a
				href="${pageContext.request.contextPath}/rooms-list">List Rooms</a></td>
		</tr>		
		
		<tr>
			<td><a
				href="${pageContext.request.contextPath}/add-room">Add Room</a></td>
		</tr>	
		
		<tr>
			<td><a
				href="${pageContext.request.contextPath}/my-meetings">My Meetings</a></td>
		</tr>	
		
		
		<tr>
			<td><a
				href="${pageContext.request.contextPath}/book-meeting">Book meeting</a></td>
		</tr>	
		
		<tr>
			<td><a href="${pageContext.request.contextPath}/logout">logout</a></td>
		</tr>
	</table>
</body>
</html>