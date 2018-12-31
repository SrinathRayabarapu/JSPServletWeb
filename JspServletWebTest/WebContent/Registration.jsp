<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Registration process</title>
</head>
<body>
<jsp:include flush="true" page="header.jsp"></jsp:include>
<center><b>
It seems you are not registered, please do it now...
<p>
</center>
		<form action="/TEST_WEB_PROJ/Login" method="post">
			<table align="center">
				<tr>
					<td>UserName:</td>
					<td><input type="text" name="uname" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="pname"/></td>
				</tr>
				<tr>
					<td>Roll Number:</td>
					<td><input type="password" name="rollno"/></td>
				</tr>
				<tr align="center">
					<td align="center"><input type="submit" value="Register"/></td>
				</tr>
			</table>
			<input type="hidden" name="action" value="rollno"/>
		</form>
</body>
</html>