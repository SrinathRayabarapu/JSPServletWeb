<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Online Test</title>
</head>
<body>
<jsp:include flush="true" page="header.jsp"></jsp:include>

	<form action="/webproj/Login" method="post">
		<table align="center">
			<tr>
				<td>Take the test</td>
				<td align="center"><input type="submit" value="Take Test"/></td>
			</tr>
		</table>
		<input type="hidden" name="action" value="taketest"/>
	</form>
</body>
</html>