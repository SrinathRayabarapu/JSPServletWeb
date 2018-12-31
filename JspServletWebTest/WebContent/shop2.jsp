<jsp:include page="logout.jsp"/>
<hr>

<h1>....Welcome to the Grocery Shop....</h1>

<h2><center>ISI marked groceries</center></h2>

<form action="/TestWebProj/control.do">
	
	<input type="hidden" name="page" value="shop">
	<input type="hidden" name="shop" value="shop2">
	
	<input type="checkbox" name="c4" value="asafotida">asafotida</input>
	<input type="checkbox" name="c5" value="rice">rice</input>
	<input type="checkbox" name="c6" value="daal">daal</input>
	
	<input type="submit" value="nextshop..">

</form>