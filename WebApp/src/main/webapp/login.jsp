<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf8">
	<link rel="stylesheet" href="./resources/Styles/RegLoginStyles.css">
	<title><spring:message code="label.title" /></title>
</head>
<body style="color: #ff1a13">
<c:if test="${not empty param.error}">
	<font color="red"> <spring:message code="label.loginerror" />
	: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} </font>
</c:if>
<div id="login_form">
	<div id="login_inner" style="padding-top: 20%; padding-left: 15%">
<form method="POST" action="<c:url value="/j_spring_security_check" />">
<table>
	<tr>
		<td align="right"><spring:message code="label.login" /></td>
		<td><input class="field" type="text" name="j_username" /></td>
	</tr>
	<tr>
		<td align="right"><spring:message code="label.password" /></td>
		<td><input class="field" type="password" name="j_password" /></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<spring:message code="label.remember" />
			<input type="checkbox" name="_spring_security_remember_me" />
		</td>
	</tr>
	<tr>
		<td colspan="2" align="right"><input class="field" type="submit" value="Login" /></td>
	</tr>
	<tr>
		<td colspan="2" align="right"><input class="field" type="reset" value="Reset"/></td>
	</tr>
</table>
</form>
	</div>
</div>
</body>
</html>