<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ page import="Data.Ehdokas"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="cache-control" content="no-cache, must-revalidate, post-check=0, pre-check=0" />
<link rel="stylesheet" type="text/css" href="/CSS/Admin.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
<title>Tervetuloa ${requestScope.ehdokas.etunimi} ${requestScope.ehdokas.sukunimi}!</title>
</head>
<body>
	<a href='/index.html'>
		<button class="button">Takaisin</button>
	</a>




	<form action='/rest/ehdokasservice/updateehdokas' method='post'>
	
		<img src="../img/${requestScope.ehdokas.ehdokas_id}.png" width="200" height="250" id="img" onerror="this.onerror=null; this.src='../img/Default.png'">
			
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
				name='paikkakunta' value='${requestScope.ehdokas.kotipaikkakunta}'>
		</div>




		<div class="input-group">
			<label>Muokkaa Puolue:</label> <input type='text' name='puolue'
				value='${requestScope.ehdokas.puolue}'>
		</div>

		<div class="input-group">
			<label>Muokkaa miksi eduskuntaan:</label> <input type='text'
				name='eduskunta' value='${requestScope.ehdokas.miksi_eduskuntaan}'>
		</div>
		<div class="input-group">
			<label>Lisää mitä haluaa edistää</label> <input type='text'
				name='edistaa' value='${requestScope.ehdokas.mita_asioita_haluat_edistaa}'>
		</div>
			<div class="input-group">
			 <input hidden="hidden" type='text' name='ehduser'
				value='${requestScope.ehdokas.ehduser}' readonly>
		</div>
		<div class="input-group">
			 <input hidden="hidden" type='text' name='ehdpass'
				value='${requestScope.ehdokas.ehdpass}' readonly>
		</div>
	
		<div class="input-group">
			<input type='submit' name='ok' value='Muokkaa'>
		</div>

	</form>
	<a href='/rest/ehdokasservice/readkysymys/${requestScope.ehdokas.ehdokas_id}'>
		<button class="button">Vastaa kysymyksiin</button>
	</a>
	
</body>
</html>