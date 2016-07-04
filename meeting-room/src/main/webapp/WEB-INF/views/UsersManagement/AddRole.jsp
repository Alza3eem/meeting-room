<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Role</title>
</head>
<body>
	<table style="width: 100%">
		<col width="30%">
		<col width="70%">
		<tr>
			<td><a
				href="${pageContext.request.contextPath}/UsersManagement/listusers">Users
					List</a></td>
			<td rowspan="5">
				<table style="width: 100%">
				<form method="post"
							action="${pageContext.request.contextPath}/addrole">
						<tr>
							<td>Role Name<sup>*</sup> <input type="text" name="roleName" value=""
								required="required" pattern=".{2,30}" /></td>
						</tr>
						<td><select name="listt" multiple>
								<c:forEach var="function" items="${funcslst}">
									<option value="${function.functionId}">${function.functionName}</option>
<%-- 									<input type="hidden" name="id" value="${function.functionId}">
 --%>								</c:forEach>
						</select></td>
						<input type="submit" value="submit">
					</form>
				</table>

			</td>
		</tr>

		<tr>
			<td><a
				href="${pageContext.request.contextPath}/admin/userloginfailedattempts">login
					failed</a></td>
		</tr>

		<tr>
			<td><a
				href="${pageContext.request.contextPath}/admin/changePassword">change
					password</a></td>
		</tr>

		<tr>
			<td><a
				href="${pageContext.request.contextPath}/admin/userssearch">Search
					user</a></td>
		</tr>

		<tr>
			<td><a href="${pageContext.request.contextPath}/admin/logout">logout</a></td>
		</tr>
	</table>
</body>
</html>