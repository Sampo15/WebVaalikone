<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="Data.Ehdokas"%>
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
<title>Ehdokkaiden poisto</title>
</head>
<body>
	<a href='/jsp/AdminPage.jsp'>
		<button class="button">Takaisin</button>
	</a>



<table  class="table_center">
<c:forEach var="ehdokkaat" items="${requestScope.ehdokkaatlist}" >
<div class="Ehdokkaat">
       ${ehdokkaat.ehdokas_id}. <strong>Ehdokkaan nimi:</strong> ${ehdokkaat.sukunimi} ${ehdokkaat.etunimi} <strong>Vaalinumero:</strong> ${ehdokkaat.vaalinro}. <a href='/EhdokkaatPoisto?id=${ehdokkaat.ehdokas_id}'><br>Poista</a>
</div>
</c:forEach>
</table>

</body>
</html>