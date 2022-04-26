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




	<form action='/UpdateEhdokkaat' method='post'>
		<div class="input-group">
			<label></label> <input hidden="hidden" type='text' name='ehdokas_id'
				value='${requestScope.ehdokas.ehdokas_id}' readonly> <input
				hidden="hidden" type='text' name='vaalinro'
				value='${requestScope.ehdokas.vaalinro}' readonly>
		</div>
		<div class="input-group">
			<label>Muokkaa Sukunimi:</label> <input type='text' name='sukunimi'
				value='${requestScope.ehdokas.sukunimi}'>
		</div>
		<div class="input-group">
			<label>Muokkaa Etunimi:</label> <input type='text' name='etunimi'
				value='${requestScope.ehdokas.etunimi}'>
		</div>

		<div class="input-group">
			<label>Muokkaa kotipaikkakunta:</label> <input type='text'
				name='paikkakunta' value='${requestScope.ehdokas.paikkakunta}'>
		</div>




		<div class="input-group">
			<label>Muokkaa Puolue:</label> <input type='text' name='puolue'
				value='${requestScope.ehdokas.puolue}'>
		</div>

		<div class="input-group">
			<label>Muokkaa miksi eduskuntaan:</label> <input type='text'
				name='eduskunta' value='${requestScope.ehdokas.eduskunta}'>
		</div>
		<div class="input-group">
			<label>Lisää mitä haluaa edistää</label> <input type='text'
				name='edistaa' value='${requestScope.ehdokas.edistaa}'>
		</div>
		<div class="input-group">
			<input type='submit' name='ok' value='Muokkaa'>
		</div>


	</form>
</body>
</html>