<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test conducting Jsp</title>
</head>
<body>
	<jsp:include flush="true" page="header.jsp"></jsp:include>
	
	<jsp:useBean id="bean" class="com.proj.testbean.Question" scope="session">
		<jsp:getProperty name="bean" property="question" />
	</jsp:useBean>
</body>
</html>