<jsp:include page="logout.jsp"/>

<hr>

<h1>....Welcome to the Fancy Shop....</h1>

<h2><center>Fancy Shop Jewellery</center></h2>

<form action="/TestWebProj/control.do">
	
	<input type="hidden" name="page" value="shop">
	<input type="hidden" name="shop" value="shop3">
	
	<input type="checkbox" name="c7" value="toy car">toy car</input>
	<input type="checkbox" name="c8" value="tennis bat">tennis bat</input>
	<input type="checkbox" name="c9" value="air baloon">air baloon</input>
	
	<input type="submit" value="nextshop..">

</form>