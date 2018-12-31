<%@ taglib uri="/WEB-INF/myTagLib.tld" prefix="valt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tag Library demo jsp </title>
</head>
<body>
	<valt:checkNumber number="<%=request.getParameter(\"num\")%>"/>
</body>
</html>