<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
		
		<table>
		<form:form action="login" commandName="userForm">
				<tr>
					<td align="left" width="20%">User Name: </td>
					<td align="left" width="40%"><form:input path="userName" size="30"/></td>
					<td align="left"><form:errors path="userName" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Password: </td>
					<td><form:password path="password" size="30"/></td>
					<td><form:errors path="password" cssClass="error"/></td>
				</tr>
				<tr>
					<br/>
					<td align="center"><input type="submit" value="Login"/></td>
					
				</tr>
		</form:form>
		</table>
	</div>
</body>
</html>