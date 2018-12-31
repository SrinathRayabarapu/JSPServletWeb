
<html>
	<body>
	
		<jsp:include flush="true" page="header.jsp"></jsp:include>
		
		<center><h3>Enter your credentials</h3></center>
		<form action="/webproj/Login" method="post">
			<table align="center">
				<tr>
					<td>UserName:</td>
					<td><input type="text" name="uname" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="pname"/></td>
				</tr>
				<tr align="center">
					<td align="center"><input type="submit" value="Login"/></td>
				</tr>
			</table>
			<input type="hidden" name="action" value="login"/>
		</form>
	</body>
</html>
