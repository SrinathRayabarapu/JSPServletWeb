<html>
<body>
<jsp:include flush="true" page="header.jsp"></jsp:include>

<form action="/TestWebProj/control.do" method="post">
	<input type="hidden" name="page" value="lang">
	
	<select name="language">
	
		<option value="te">Telugu</option>
		<option value="hi">Hindi</option>
	
	</select>
	
	<input type="submit" value="Select Your Language..">
	
</form>
</body>
</html>