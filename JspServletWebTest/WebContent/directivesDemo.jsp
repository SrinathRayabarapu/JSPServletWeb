<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Directives Demo</title>
</head>
<body>
<%@include file="header.jsp" %>
<hr>
<jsp:include page="header.jsp">
	<jsp:param value="companyname" name="valtech"/>
</jsp:include>
<hr>

<jsp:useBean id="bean" class="com.bean.BeanDemo" scope="session">
	<jsp:setProperty name="bean" property="name" value="srinath" />
	<jsp:setProperty name="bean" property="age" value="45" />
</jsp:useBean>
<jsp:getProperty name="bean" property="name" />
<jsp:getProperty name="bean" property="age" />
 
<jsp:forward page="beanDemo.jsp"></jsp:forward>

<%@include file="footer.jsp" %>
</body>
</html>