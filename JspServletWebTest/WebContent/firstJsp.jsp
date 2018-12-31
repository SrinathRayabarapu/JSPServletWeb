<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My First Jsp page</title>
</head>
<body>

<%!
	String name = "srinath";
	void getName(){
		System.out.println(name);
	}
%>

<% 
	out.print(session);
	out.println(config);
	out.println(application);
	session.setAttribute("name",name);
	getName();
	
	out.println((new java.util.Date()).toString());

%>

<%=	session.getAttribute("name")%>
<%= name %>

</body>
</html>