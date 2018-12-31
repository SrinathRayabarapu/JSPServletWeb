<%@ page import="java.util.*"%>
<jsp:include page="logout.jsp"/>

<h2>You bought the following items</h2>

<h1>Now pay for it</h1>

<h3>

<%
	Enumeration e=session.getAttributeNames();
	while(e.hasMoreElements())
	{
		String name=(String)e.nextElement();
		String value=session.getAttribute(name).toString();
		if(name.equals("uname")&&name.equals("rb")&&name.equals("shop")){}else{
		out.println("<h2>"+name+":"+value+"</h2>");}
	}

%>