<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div class="container">
	<h1>Welcome To The Red Dragon Casino</h1>
	
	<%-- <c:forEach items="${cards}" var="deckId">
		<li>Cards remaining: ${cards.remaining}</li>
		<li><a href="/reshuffle=${cards.shuffled}"></a></li>
		<form action="/">
	  		How many cards:<input type="text">
	  		<input type="submit">
		</form>
	</c:forEach> --%>
	
	
	<%-- <c:forEach items="${list}" var="cards">
	<p>Cards Remaining: ${cards.remaining}</p>
	</c:forEach> --%>
	<p>Cards Remaining: ${list}</p>
	
	<form action="/draw" method="post">
		How many cards? <input type="number" name="draw"> <!-- // give parameter name to call with controller -->
		<input type="submit" value="Draw">
	</form>
		<a href="/new/shuffle=${cards.deckId}">Reshuffle</a>
	
	</div>
	
</body>
</html>