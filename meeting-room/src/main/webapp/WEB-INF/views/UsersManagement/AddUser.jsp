<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add user</title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath}/adduser">
		<!--  use c:url instead of write direct -->
		<center>
			<table border="1" width="30%" cellpadding="5">
				<thead>
					<tr>
						<th colspan="2">User Information</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>First Name<sup>*</sup></td>
						<td><input type="text" name="firstName" value=""
							required="required" pattern=".{2,30}" /></td>
					</tr>
					<tr>
						<td>Last Name<sup>*</sup></td>
						<td><input type="text" name="lastName" value=""
							required="required" pattern=".{2,30}" /></td>
					</tr>
					<tr>
						<td>Title</td>
						<td><input type="text" name="title"></td>
					</tr>
					<tr>
						<td>User Name<sup>*</sup></td>
						<td><input type="text" name="username" value=""
							required="required" pattern=".{6,30}" /></td>
					</tr>
					<tr>
						<td>Role<sup>*</sup></td>
						<td><select name="roleId">
						<c:forEach var="role" items="${rolsLst}">
								<option value="${role.roleId}">${role.roleName}</option>
							</c:forEach>
						
						</select>
					</tr>
					<tr>
						<td>Password<sup>*</sup></td>
						<td><input type="password" name="password" value=""
							required="required"
							pattern="(?=.*[a-z])(?=.*[A-Z])([a-zA-Z]){8,30}" /></td>
					</tr>
					<tr>
						<td>Confirm Password<sup>*</sup></td>
						<td><input type="password" name="confirmPassword" value=""
							required="required"
							pattern="(?=.*[a-z])(?=.*[A-Z])([a-zA-Z]){8,30}" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Submit" /></td>
						<td><input type="reset" value="Reset" /></td>
					</tr>
					<tr>
						<td colspan="2">Already registered!! <a href="${pageContext.request.contextPath}/login">Login Here</a></td>
					</tr>
				</tbody>
			</table>
		</center>
	</form>
</body>
</html>