<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/tlds/customTag.tld" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Custom Tag Test Page</title>
	<style>
	p, b { font-family:Tahoma,Sans-Serif; font-size:10pt; }
	b { font-weight:bold; }
	</style>
</head>
<body>

	<p align="center">
	
	<em><u>Your first JSP tag : FirstTag</u></em></p>
	
	<p> Name entered : <s:firsttag name="Srinath"/>
	
	<p> No name entered : <s:firsttag name="Valtech"/> </p>

</body>
</html>