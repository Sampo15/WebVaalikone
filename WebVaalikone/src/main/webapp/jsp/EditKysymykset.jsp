<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Muokka kysymyksiä</h2>

<c:forEach var="kysymys" items="${requestScope.kysymysentlist}">
<div class="Ehdokkaat">
	<strong><br>${kysymys}</strong> <a href='/rest/kysymysservice/deletekysymys/${kysymys.kysymys_id}'>Poista</a> <a href='/rest/kysymysservice/readtoupdatekysymys/${kysymys.kysymys_id}'>Muokkaa</a>
	</div>
</c:forEach>
<a href='/jsp/AdminPage.jsp'>
		<button class="button button2">Poistu</button>
	</a>

</body>
</html>