<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="Data.Admin"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/CSS/Admin.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
<title>Admin sivu</title>
</head>
<body>



	<h1 class="h1">
		<br>Hallinnoi ehdokkaita
	</h1>
	<div>
		<a href='/ShowEhdokkaat' method="GET">
			<button class="button">Muokkaa ehdokkaita</button>
		</a> <a href='AddEhdokas.jsp'>
			<button class="button">Lisää ehdokas</button>
		</a> <a href='/ShowDelete'>
			<button class="button">Poista ehdokas</button>
		</a>
	</div>
	<div>
		
<form action='../readkysymys' method='get'>

<input class="button "type='submit' name='ok' value='Muokkaa kysymyksiä'>
</form>
	</div>
	<a href='/index.html'>
		<button class="button button2">Poistu</button>
	</a>
</body>
</html>