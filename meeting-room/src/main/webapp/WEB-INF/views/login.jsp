<%-- <%@page import="com.progressoft.UserPortalManagement.controller.LoginController"%> --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%><%-- 
<%@ page import="net.tanesha.recaptcha.ReCaptcha"%>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Example</title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath}/login">
		<center>
			<table border="1" width="30%" cellpadding="3">
				<thead>
					<tr>
						<th colspan="2">Login Here</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>User Name<sup>*</sup></td>
						<td><input type="text" name="username" value=""
							required="required"/>
						<!--  pattern=".{6,30}"  --> </td>
					</tr>
					<tr>
						<td>Password<sup>*</sup></td>
						<td><input type="password" name="password" value=""
							required="required"/>
							<!-- pattern="(?=.*[a-z])(?=.*[A-Z])([a-zA-Z]){8,30}"  --></td>
					</tr>
					<%-- <tr>
						<td>Capture<sup>*</sup></td>
						<td><c:set var="rand"><%=java.lang.Math.round((java.lang.Math.random() * 7) + 1)%></c:set>
							<img src="<c:url value='/images/CAPTCHA_${rand}.png'/>" /></td>
						<input type="hidden" name="imageNo" value="${rand}" />
					</tr> --%>
					<!-- <tr>
						<td></td>
						<td><input name="capture" /></td>
					</tr> -->
					<tr>
						<td><input type="submit" value="Login" /></td>
						<td><input type="reset" value="Reset" /></td>
					</tr>

					<c:if test="${not empty errorMessage}">
						<tr>
							<td><c:out value="${errorMessage}" /></td>
						</tr>
					</c:if>

					<tr>
						<td colspan="2">Yet Not Registered!! <a
							href="${pageContext.request.contextPath}/adduser">Register
								Here</a></td>
					</tr>
				</tbody>
			</table>
		</center>
	</form>
</body>
</html>