<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="kysymys" items="${requestScope.kysymysentlist}">
	<li>${kysymys} <a href='/rest/kysymysservice/deletekysymys/${kysymys.kysymys_id}'>Delete</a> <a href='/rest/kysymysservice/readtoupdatekysymys/${kysymys.kysymys_id}'>Update</a>
</c:forEach>


</body>
</html>