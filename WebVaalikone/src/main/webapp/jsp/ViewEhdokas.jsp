<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="Data.Ehdokas"%>

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
<title>${requestScope.ehdokas.etunimi}
	${requestScope.ehdokas.sukunimi}</title>
</head>
<body class="vastauksetbody">




	<table class="table_center">

		<div class="input-group">
			<label></label> <input hidden="hidden" type='text' name='ehdokas_id'
				value='${requestScope.ehdokas.ehdokas_id}' readonly>
		</div>
		<div>
			<label><h1>${requestScope.ehdokas.etunimi}
					${requestScope.ehdokas.sukunimi}</h1></label> <br>
			<div class='tiedot'>

				<strong>Vaalinumero:</strong> ${ehdokas.vaalinro}<br> <strong>Kotipaikkakunta:</strong>
				<br> ${ehdokas.paikkakunta}<br> <strong>Puolue:</strong> <br>
				${ehdokas.puolue} <br> <strong>Miksi eduskuntaan:</strong> <br>${ehdokas.eduskunta}
				<br> <strong>Mita haluaa edistää:</strong> <br>${ehdokas.edistaa}</div>

		</div>


	</table>

	<button class="button button3" name="back" onclick="history.back()">Takaisin</button>
</body>
</html>