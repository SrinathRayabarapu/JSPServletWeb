
<jsp:include flush="true" page="header.jsp"></jsp:include>

<jsp:include page="logout.jsp"/>
<hr>

<form action="/TestWebProj/control.do">
	
	<input type="hidden" name="page" value="shop">
	<input type="hidden" name="shop" value="shop1">

	<input type="checkbox" name="c1" value="gold coin">GoldCoin</input>
	<input type="checkbox" name="c2" value="diamonds">diamonds</input>
	<input type="checkbox" name="c3" value="silver">silver</input>
	
	<input type="submit" value="nextshop..">

</form>