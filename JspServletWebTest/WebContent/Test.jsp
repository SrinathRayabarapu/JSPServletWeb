<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Take Test here</title>
</head>
<body>
<jsp:include flush="true" page="header.jsp"></jsp:include>

	<form action="/TestWebProj/control.do" method="post">
		<table align="center">
			<tr>
				<td>Take the test</td>
				<td align="center"><input type="submit" value="Take Test"/></td>
			</tr>
		</table>
		<input type="hidden" name="page" value="test"/>
	</form>
</body>
</html>