<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="Data.Ehdokkaat"%>
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
<title>Insert title here</title>
</head>
<body>
	<a href='/jsp/AdminPage.jsp'>
		<button class="button">Takaisin</button>
	</a>




	<form action='/AddEhdokas' method='post'>
		<div class="input-group">
			<label>Lisää sukunimi</label> <input type="text" name="sukunimi"
				required>
		</div>
		<div class="input-group">
			<label>Lisää etunimi</label> <input type="text" name="etunimi"
				required>
		</div>
		<div class="input-group">
			<label>Lisää vaalinumero</label> <input type="text" name="vaalinro"
				required>
		</div>
		<div class="input-group">
			<label>Lisää kotipaikkakunta</label> <input type="text"
				name="paikkakunta" required>
		</div>
		<div class="input-group">
			<label>Lisää puolue</label> <input type="text" name="puolue" required>
		</div>
		<div class="input-group">
			<label>Lisää miksi eduskuntaan</label>
			<textarea type="text" name="eduskunta" cols="50" rows="5" required></textarea>
		</div>
		<div class="input-group">
			<label>Lisää mitä haluaa edistää</label>
			<textarea type="text" name="edistaa" cols="50" rows="5" required></textarea>
		</div>
		<div class="input-group">
			<label>Lisää käyttäjätunnus</label> <input type="text" name="ehduser" required>
		</div>
		<div class="input-group">
			<label>Lisää salasana</label> <input type="text" name="ehdpass" required>
		</div>
		<div class="input-group">
			<input type='submit' name='ok' value='Lisää ehdokas'>
		</div>


	</form>


</body>
</html>