<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="Data.Ehdokkaat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/CSS/kysymykset.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
<title>Sopivimmat ehdokkaat</title>
</head>
<body class="vastauksetbody">

	<h1>Sopivimmat ehdokkaat:</h1>
	<br>
	<br>

	<table class="table_center">
		<c:forEach var="ehdokasList" items="${requestScope.topThree}">
			<div class="Vastaukset">
				<a href='/ViewEhdokas?id=${ehdokasList.ehdokas_id}'>${ehdokasList.etunimi}
					${ehdokasList.sukunimi}, ${ehdokasList.puolue}</a>
			</div>
		</c:forEach>
	</table>

	<a href='index.html'>
		<button class="button button3">Takaisin</button>
	</a>

</body>
</html>